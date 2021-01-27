package smoke.env

import com.fasterxml.jackson.annotation.JsonProperty

data class EnvConfig(
    @JsonProperty("workspace_name") val workspaceName: String,
    @JsonProperty("analytics_events_submission_endpoint") val analyticsEventsSubmissionEndpoint: String,
    @JsonProperty("analytics_events_submission_function_name") val analyticsEventsSubmissionFunctionName: String,
    @JsonProperty("analytics_events_submission_health_endpoint") val analyticsEventsSubmissionHealthEndpoint: String,
    @JsonProperty("analytics_events_submission_store") val analyticsEventsSubmissionStore: String,
    @JsonProperty("analytics_submission_ingestion_interval") val analyticsSubmissionIngestionInterval: String,
    @JsonProperty("analytics_submission_endpoint") val analyticsSubmissionEndpoint: String,
    @JsonProperty("analytics_submission_health_endpoint") val analyticsSubmissionHealthEndpoint: String,
    @JsonProperty("analytics_submission_store") val analytics_submission_store: String,
    @JsonProperty("analytics_submission_parquet_store") val analyticsSubmissionParquetStore: String,
    @JsonProperty("availability_android_distribution_endpoint") val availabilityAndroidDistUrl: String,
    @JsonProperty("availability_android_distribution_store") val availability_android_distribution_store: String,
    @JsonProperty("availability_ios_distribution_endpoint") val availabilityIosDistUrl: String,
    @JsonProperty("availability_ios_distribution_store") val availability_ios_distribution_store: String,
    @JsonProperty("base_distribution_endpoint") val base_distribution_endpoint: String,
    @JsonProperty("base_download_endpoint") val baseDownloadEndpoint: String,
    @JsonProperty("diagnosis_keys_distribution_2hourly_endpoint") val diagnosisKeysDist2hourlyEndpoint: String,
    @JsonProperty("diagnosis_keys_distribution_daily_endpoint") val diagnosisKeysDistributionDailyEndpoint: String,
    @JsonProperty("diagnosis_keys_distribution_store") val diagnosis_keys_distribution_store: String,
    @JsonProperty("diagnosis_keys_processing_function") val diagnosisKeysProcessingFunction: String,
    @JsonProperty("diagnosis_keys_submission_endpoint") val diagnosisKeysSubmissionEndpoint: String,
    @JsonProperty("diagnosis_keys_submission_health_endpoint") val diagnosisKeysSubmissionHealthEndpoint: String,
    @JsonProperty("diagnosis_keys_submission_store") val diagnosis_keys_submission_store: String,
    @JsonProperty("exposure_configuration_distribution_endpoint") val exposureConfigurationDistUrl: String,
    @JsonProperty("exposure_configuration_distribution_store") val exposure_configuration_distribution_store: String,
    @JsonProperty("exposure_notification_circuit_breaker_endpoint") val exposureNotificationCircuitBreakerEndpoint: String,
    @JsonProperty("exposure_notification_circuit_breaker_health_endpoint") val enCircuitBreakerHealthEndpoint: String,
    @JsonProperty("federation_keys_processing_upload_function") val federationKeysProcessingUploadFunction: String,
    @JsonProperty("federation_keys_processing_download_function") val federationKeysProcessingDownloadFunction: String,
    @JsonProperty("isolation_payment_consume_lambda_function_name") val isolationPaymentConsumeLambdaFunctionName: String,
    @JsonProperty("isolation_payment_create_endpoint") val isolationPaymentCreateEndpoint: String,
    @JsonProperty("isolation_payment_health_endpoint") val isolationPaymentHealthEndpoint: String,
    @JsonProperty("isolation_payment_order_lambda_function_name") val isolationPaymentOrderLambdaFunctionName: String,
    @JsonProperty("isolation_payment_tokens_table") val isolationPaymentTokensTable: String,
    @JsonProperty("isolation_payment_update_endpoint") val isolationPaymentUpdateEndpoint: String,
    @JsonProperty("isolation_payment_verify_lambda_function_name") val isolationPaymentVerifyLambdaFunctionName: String,
    @JsonProperty("post_districts_distribution_endpoint") val postDistrictsDistUrl: String,
    @JsonProperty("post_districts_distribution_store") val post_districts_distribution_store: String,
    @JsonProperty("risky_post_districts_upload_endpoint") val riskyPostDistrictsUploadEndpoint: String,
    @JsonProperty("risky_post_districts_upload_gateway_endpoint") val riskyPostDistrictsUploadGatewayEndpoint: String,
    @JsonProperty("risky_post_districts_upload_health_endpoint") val riskyPostDistrictsUploadHealthEndpoint: String,
    @JsonProperty("risky_venues_circuit_breaker_endpoint") val riskyVenuesCircuitBreakerEndpoint: String,
    @JsonProperty("risky_venues_circuit_breaker_health_endpoint") val riskyVenuesCircuitBreakerHealthEndpoint: String,
    @JsonProperty("risky_venues_distribution_endpoint") val riskyVenuesDistUrl: String,
    @JsonProperty("risky_venues_distribution_store") val risky_venues_distribution_store: String,
    @JsonProperty("risky_venues_messages_download_endpoint") val riskyVenuesMessagesDownloadEndpoint: String,
    @JsonProperty("risky_venues_upload_endpoint") val riskyVenuesUploadEndpoint: String,
    @JsonProperty("risky_venues_upload_health_endpoint") val riskyVenuesUploadHealthEndpoint: String,
    @JsonProperty("self_isolation_distribution_endpoint") val selfIsolationDistUrl: String,
    @JsonProperty("self_isolation_distribution_store") val self_isolation_distribution_store: String,
    @JsonProperty("symptomatic_questionnaire_distribution_endpoint") val symptomaticQuestionnaireDistUrl: String,
    @JsonProperty("symptomatic_questionnaire_distribution_store") val symptomatic_questionnaire_distribution_store: String,
    @JsonProperty("test_results_health_endpoint") val testResultsHealthEndpoint: String,
    @JsonProperty("test_results_npex_upload_endpoint") val testResultsNpexUploadEndpoint: String,
    @JsonProperty("test_results_fiorano_upload_endpoint") val testResultsFioranoUploadEndpoint: String,
    @JsonProperty("test_results_eng_tokengen_upload_endpoint") val engTokenGenUploadEndpoint: String,
    @JsonProperty("test_results_wls_tokengen_upload_endpoint") val wlsTokenGenUploadEndpoint: String,
    @JsonProperty("test_results_v2_npex_upload_endpoint") val v2NpexUploadEndpoint: String,
    @JsonProperty("test_results_v2_fiorano_upload_endpoint") val v2FioranoUploadEndpoint: String,
    @JsonProperty("test_results_v2_eng_tokengen_upload_endpoint") val v2EngTokenGenUploadEndpoint: String,
    @JsonProperty("test_results_v2_wls_tokengen_upload_endpoint") val v2WlsTokenGenUploadEndpoint: String,
    @JsonProperty("virology_kit_endpoint") val virologyKitEndpoint: String,
    @JsonProperty("virology_kit_health_endpoint") val virologyKitHealthEndpoint: String,
    @JsonProperty("virology_table_results") val virology_table_results: String,
    @JsonProperty("virology_table_submission_tokens") val virology_table_submission_tokens: String,
    @JsonProperty("virology_table_test_orders") val virology_table_test_orders: String,
    @JsonProperty("virology_submission_lambda_function_name") val virologySubmissionLambdaFunctionName: String,
    @JsonProperty("virology_tokens_processing_function") val virologyTokensProcessingFunction: String,
    @JsonProperty("virology_tokens_processing_output_store") val virology_tokens_processing_output_store: String,
    @JsonProperty("virology_upload_lambda_function_name") val virologyUploadLambdaFunctionName: String,
    @JsonProperty("auth_headers") val authHeaders: AuthHeaders,
    @JsonProperty("empty_submission_endpoint") val emptySubmissionEndpoint: String
)

data class AuthHeaders(
    @JsonProperty("mobile") val mobile: String,
    @JsonProperty("testResultUpload") val testResultUpload: String,
    @JsonProperty("highRiskVenuesCodeUpload") val highRiskVenuesCodeUpload: String,
    @JsonProperty("highRiskPostCodeUpload") val highRiskPostCodeUpload: String
)
