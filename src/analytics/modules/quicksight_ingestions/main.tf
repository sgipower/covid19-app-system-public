locals {
  table_name = "${terraform.workspace}_analytics_quicksight_ingestions"
}

module "quicksight_ingestions" {
  source                   = "../../libraries/analytics_s3"
  name                     = "analytics-quicksight-ingestions"
  service                  = var.service
  force_destroy_s3_buckets = var.force_destroy_s3_buckets
  enable_versioning        = false
  logs_bucket_id           = var.logs_bucket_id
  tags                     = var.tags
}

resource "aws_glue_catalog_table" "this" {
  name          = local.table_name
  database_name = var.database_name

  storage_descriptor {
    location      = "s3://${module.quicksight_ingestions.bucket_name}/"
    input_format  = "org.apache.hadoop.mapred.TextInputFormat"
    output_format = "org.apache.hadoop.hive.ql.io.HiveIgnoreKeyTextOutputFormat"

    ser_de_info {
      name                  = "csv"
      serialization_library = "org.apache.hadoop.hive.serde2.OpenCSVSerde"

      parameters = {
        "separatorChar"          = ","
        "skip.header.line.count" = "1"
      }
    }

    columns {
      name = "data_set_id"
      type = "string"
    }

    columns {
      name = "ingestion_id"
      type = "string"
    }

    columns {
      name = "status"
      type = "string"
    }

    columns {
      name = "created_time"
      type = "string"
    }

    columns {
      name = "time_in_seconds"
      type = "string"
    }
  }
}
