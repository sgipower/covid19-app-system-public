require 'zip'

module NHSx
  module Virology
    include NHSx::AWS

    def order(url, target_env_config, system_config)
      authentication_token = target_env_config["auth_headers"]["mobile"]
      lambda_function = target_env_config["virology_submission_lambda_function_name"]
      custom_oai = NHSx::AWS::Commandlines.get_lambda_custom_oai(lambda_function, system_config)

      headers = {
        "Authorization" => authentication_token,
        "x-custom-oai" => custom_oai
      }

      resp = Faraday.post(url) do |req|
        req.headers = headers
      end

      raise GaudiError, "Expecting status code to be 200 but was #{resp.status}" unless resp.status == 200

      JSON.parse(resp.body)
    end

    def upload_result(url, payload, target_env_config, system_config)
      authentication_token = target_env_config["auth_headers"]["testResultUpload"]
      lambda_function = target_env_config["virology_upload_lambda_function_name"]
      custom_oai = NHSx::AWS::Commandlines.get_lambda_custom_oai(lambda_function, system_config)

      headers = {
        "Content-Type" => "application/json",
        "Authorization" => authentication_token,
        "x-custom-oai" => custom_oai
      }

      resp = Faraday.post(url) do |req|
        req.headers = headers
        req.body = JSON.dump(payload)
      end

      raise GaudiError, "Expecting status code to be 202 but was #{resp.status}" unless resp.status == 202
    end

    def generate_single(config_file, system_config)
      # virology out dir (format: YYYYmmdd)
      date = Time.iso8601(system_config.test_end_date).strftime("%Y%m%d")
      virology_out_dir = File.join(system_config.out, "gen/virology/#{date}")

      # if virology exists for input test end date then raise
      raise GaudiError, "Local virology dir for #{system_config.test_end_date} already exists #{virology_out_dir}" unless !File.exist?(virology_out_dir)

      # lambda and payload
      lambda_function = config_file["virology_tokens_processing_function"]
      payload = {
        "testResult" => system_config.test_result,
        "testEndDate" => system_config.test_end_date,
        "testKit" => system_config.test_kit,
        "numberOfTokens" => system_config.number_of_tokens
      }
      payload_json = "'#{JSON.dump(payload)}'"

      # blocking invoke lambda
      output_log_file = NHSx::AWS::Commandlines.new_lambda_output_file(lambda_function, system_config)
      cmd_line = NHSx::AWS::Commandlines.invoke_lambda(lambda_function, payload_json, output_log_file)
      cmd = run_command("Invoke virology lambda", cmd_line, system_config)
      puts cmd.output

      # get zip filename from response
      response_json = JSON.parse(File.read(output_log_file).gsub('\\"', '"')[1..-2])
      puts JSON.pretty_generate(response_json)
      zip_filename = response_json["filename"]

      # download zip from s3 bucket
      s3_bucket = config_file["virology_tokens_processing_output_store"]
      object_name = "#{s3_bucket}/#{zip_filename}"
      zip_file_path = File.join(virology_out_dir, "#{zip_filename}")
      run_command("Download zip file", NHSx::AWS::Commandlines.download_from_s3(object_name, zip_file_path), system_config)

      # unzip to virology out dir
      run_command("Unzip archive", "unzip #{zip_file_path} -d #{virology_out_dir}", system_config)
      csv_filename = zip_filename.sub(".zip", ".csv")
      File.rename(File.join(virology_out_dir, "#{csv_filename}"), File.join(virology_out_dir, "#{date}.csv"))

      # remove downloaded s3 zip file
      File.delete(zip_file_path)
    end

    def generate_interval(config_file, system_config)
      virology_out_dir = File.join(system_config.out, "gen/virology/")

      # get TEST_RESULT and NUMBER_OF_TOKENS from env
      number_of_tokens = system_config.number_of_tokens
      test_result = system_config.test_result

      # get START_DATE and NUMBER_OF_DAYS from env and validate
      start_date = Time.iso8601(system_config.start_date)
      number_of_days = system_config.number_of_days
      now = Time.now
      start_of_today = Time.new(now.year, now.month, now.day, 0, 0, 0, 0)
      raise GaudiError, "START_DATE must not be in the past" unless start_date >= start_of_today

      # generate command line parameters based from [START_DATE, START_DATE+NUMBER_OF_DAYS]
      one_day = 24 * 60 * 60
      virology_gen_args = (0..number_of_days - 1).map { |n|
        test_end_date_time = (start_date + n * one_day)
        local_test_end_date_dir = test_end_date_time.strftime("%Y%m%d")
        virology_single_day_dir = File.join(virology_out_dir, "#{local_test_end_date_dir}")
        raise GaudiError, "Local virology dir for #{local_test_end_date_dir} already exists #{virology_out_dir}" unless !File.exist?(virology_single_day_dir)

        {
          'TEST_END_DATE' => test_end_date_time.strftime('%Y-%m-%dT00:00:00Z'),
          'NUMBER_OF_TOKENS' => number_of_tokens,
          'TEST_RESULT' => test_result
        }
      }

      # display all the parameters that are going to be used to generate tokens
      require "highline"
      cli = HighLine.new
      puts "\nGenerating virology data with (please verify correctness):"
      virology_gen_args.each { |e| puts e }
      answer = cli.ask "\nDo you want to proceed? Type 'yes' to confirm"
      raise GaudiError, "Aborted" unless ["yes"].include?(answer.downcase)

      # generate tokens for each TEST_END_DATE
      virology_gen_args.each { |e|
        ENV['TEST_END_DATE'] = e['TEST_END_DATE']
        ENV['NUMBER_OF_TOKENS'] = e['NUMBER_OF_TOKENS']
        ENV['TEST_RESULT'] = e['TEST_RESULT']
        generate_single(config_file, system_config)
      }

      # generate random pwd and store it
      zip_password = SecureRandom.alphanumeric(10)

      # zip csv with generated password
      start_date_formatted = start_date.strftime("%Y%m%d")
      end_date_day_formatted = (start_date + (number_of_days - 1) * one_day).day
      zip_file_name = "virology-#{start_date_formatted}-#{end_date_day_formatted}.zip"
      zip_enc_cmd = "cd #{virology_out_dir} && zip -r -e #{zip_file_name} * -P #{zip_password} && cd -"
      run_command("Zip archive password protected", zip_enc_cmd, system_config)

      # write pwd
      write_file(File.join(virology_out_dir, "pwd.txt"), zip_password)
    end
  end
end
