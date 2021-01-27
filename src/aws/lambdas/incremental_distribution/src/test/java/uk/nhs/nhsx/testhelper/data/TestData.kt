package uk.nhs.nhsx.testhelper.data

import uk.nhs.nhsx.diagnosiskeyssubmission.model.StoredTemporaryExposureKey
import uk.nhs.nhsx.diagnosiskeyssubmission.model.StoredTemporaryExposureKeyPayload
import uk.nhs.nhsx.virology.TestKit
import uk.nhs.nhsx.virology.TestResultPollingToken
import uk.nhs.nhsx.virology.persistence.TestResult

object TestData {
    const val STORED_KEYS_PAYLOAD = "{\"temporaryExposureKeys\":[" +
        "{\"key\":\"W2zb3BeMWt6Xr2u0ABG32Q==\",\"rollingStartNumber\":12345,\"rollingPeriod\":144,\"transmissionRisk\":7}," +
        "{\"key\":\"kzQt9Lf3xjtAlMtm7jkSqw==\",\"rollingStartNumber\":12499,\"rollingPeriod\":144,\"transmissionRisk\":7}" +
        "]}"
    const val STORED_KEYS_PAYLOAD_SUBMISSION = "{\"temporaryExposureKeys\":[" +
        "{\"key\":\"W2zb3BeMWt6Xr2u0ABG32Q==\",\"rollingStartNumber\":2666736,\"rollingPeriod\":144,\"transmissionRisk\":7}," +
        "{\"key\":\"kzQt9Lf3xjtAlMtm7jkSqw==\",\"rollingStartNumber\":2664864,\"rollingPeriod\":144,\"transmissionRisk\":7}" +
        "]}"
    const val STORED_KEYS_PAYLOAD_DAYS_SINCE_ONSET = "{\"temporaryExposureKeys\":[" +
        "{\"key\":\"W2zb3BeMWt6Xr2u0ABG32Q==\",\"rollingStartNumber\":12345,\"rollingPeriod\":144,\"transmissionRisk\":7,\"daysSinceOnsetOfSymptoms\":1}," +
        "{\"key\":\"kzQt9Lf3xjtAlMtm7jkSqw==\",\"rollingStartNumber\":12499,\"rollingPeriod\":144,\"transmissionRisk\":7,\"daysSinceOnsetOfSymptoms\":4}" +
        "]}"
    const val STORED_KEYS_PAYLOAD_DAYS_SINCE_ONSET_SUBMISSION = "{\"temporaryExposureKeys\":[" +
        "{\"key\":\"W2zb3BeMWt6Xr2u0ABG32Q==\",\"rollingStartNumber\":2666736,\"rollingPeriod\":144,\"transmissionRisk\":7,\"daysSinceOnsetOfSymptoms\":1}," +
        "{\"key\":\"kzQt9Lf3xjtAlMtm7jkSqw==\",\"rollingStartNumber\":2664864,\"rollingPeriod\":144,\"transmissionRisk\":7,\"daysSinceOnsetOfSymptoms\":4}" +
        "]}"
    const val STORED_KEYS_PAYLOAD_WITH_RISK_LEVEL = "{\"temporaryExposureKeys\":[" +
        "{\"key\":\"W2zb3BeMWt6Xr2u0ABG32Q==\",\"rollingStartNumber\":2666736,\"rollingPeriod\":144,\"transmissionRisk\":5}," +
        "{\"key\":\"kzQt9Lf3xjtAlMtm7jkSqw==\",\"rollingStartNumber\":2664864,\"rollingPeriod\":144,\"transmissionRisk\":4}" +
        "]}"
    const val STORED_KEYS_PAYLOAD_ONE_KEY = "{\"temporaryExposureKeys\":[" +
        "{\"key\":\"W2zb3BeMWt6Xr2u0ABG32Q==\",\"rollingStartNumber\":2666736,\"rollingPeriod\":144,\"transmissionRisk\":7}" +
        "]}"
    const val STORED_FEDERATED_KEYS_PAYLOAD_NI = "{\"temporaryExposureKeys\":[{\"key\":\"W2zb3BeMWt6Xr2u0ABG32Q==\",\"rollingStartNumber\":2666736,\"rollingPeriod\":144,\"transmissionRisk\":3},{\"key\":\"B3xb3BeMWt6Xr2u0ABG45F==\",\"rollingStartNumber\":2666874,\"rollingPeriod\":144,\"transmissionRisk\":6}]}"
    const val STORED_FEDERATED_KEYS_PAYLOAD_IE = "{\"temporaryExposureKeys\":[{\"key\":\"kzQt9Lf3xjtAlMtm7jkSqw==\",\"rollingStartNumber\":2666868,\"rollingPeriod\":144,\"transmissionRisk\":4}]}"
    val STORED_KEYS_PAYLOAD_DESERIALIZED = StoredTemporaryExposureKeyPayload(
        listOf(
            StoredTemporaryExposureKey("W2zb3BeMWt6Xr2u0ABG32Q==", 12345, 144, 7),
            StoredTemporaryExposureKey("kzQt9Lf3xjtAlMtm7jkSqw==", 12499, 144, 7)
        )
    )
    val STORED_KEYS_PAYLOAD_DESERIALIZED_DAYS_SINCE_ONSET = StoredTemporaryExposureKeyPayload(
        listOf(
            StoredTemporaryExposureKey("W2zb3BeMWt6Xr2u0ABG32Q==", 12345, 144, 7, 1),
            StoredTemporaryExposureKey("kzQt9Lf3xjtAlMtm7jkSqw==", 12499, 144, 7, 4)
        )
    )
    const val RISKY_VENUES_UPLOAD_PAYLOAD = "# venue_id, start_time, end_time\n" +
        "\"CD2\", \"2019-07-04T13:33:03Z\", \"2019-07-04T15:56:00Z\"\n" +
        "\"CD3\", \"2019-07-06T19:33:03Z\", \"2019-07-06T21:01:07Z\"\n" +
        "\"CD4\", \"2019-07-08T20:05:52Z\", \"2019-07-08T22:35:56Z\""
    const val STORED_RISKY_VENUES_UPLOAD_PAYLOAD = "{\"venues\":[" +
        "{\"id\":\"CD2\",\"riskyWindow\":{\"from\":\"2019-07-04T13:33:03Z\",\"until\":\"2019-07-04T15:56:00Z\"},\"messageType\":\"M1\"}," +
        "{\"id\":\"CD3\",\"riskyWindow\":{\"from\":\"2019-07-06T19:33:03Z\",\"until\":\"2019-07-06T21:01:07Z\"},\"messageType\":\"M1\"}," +
        "{\"id\":\"CD4\",\"riskyWindow\":{\"from\":\"2019-07-08T20:05:52Z\",\"until\":\"2019-07-08T22:35:56Z\"},\"messageType\":\"M1\"}" +
        "]}"
    const val STORED_ANALYTICS_PAYLOAD_IOS_NEW_METRICS = "{\"startDate\":\"2020-07-27T23:00:00Z\",\"endDate\":\"2020-07-28T22:59:00Z\",\"postalDistrict\":\"AB10\",\"deviceModel\":\"iPhone11,2\",\"operatingSystemVersion\":\"iPhone OS 13.5.1 (17F80)\",\"latestApplicationVersion\":\"3.0\",\"localAuthority\":null,\"cumulativeDownloadBytes\":140000000,\"cumulativeUploadBytes\":140000000,\"cumulativeCellularDownloadBytes\":80000000,\"cumulativeCellularUploadBytes\":70000000,\"cumulativeWifiDownloadBytes\":60000000,\"cumulativeWifiUploadBytes\":50000000,\"checkedIn\":1,\"canceledCheckIn\":1,\"receivedVoidTestResult\":1,\"isIsolatingBackgroundTick\":1,\"hasHadRiskyContactBackgroundTick\":1,\"receivedPositiveTestResult\":1,\"receivedNegativeTestResult\":1,\"hasSelfDiagnosedPositiveBackgroundTick\":1,\"completedQuestionnaireAndStartedIsolation\":1,\"encounterDetectionPausedBackgroundTick\":1,\"completedQuestionnaireButDidNotStartIsolation\":1,\"totalBackgroundTasks\":1,\"runningNormallyBackgroundTick\":1,\"completedOnboarding\":1,\"includesMultipleApplicationVersions\":false,\"receivedVoidTestResultEnteredManually\":1,\"receivedPositiveTestResultEnteredManually\":1,\"receivedNegativeTestResultEnteredManually\":0,\"receivedVoidTestResultViaPolling\":0,\"receivedPositiveTestResultViaPolling\":0,\"receivedNegativeTestResultViaPolling\":1,\"hasSelfDiagnosedBackgroundTick\":4,\"hasTestedPositiveBackgroundTick\":5,\"isIsolatingForSelfDiagnosedBackgroundTick\":6,\"isIsolatingForTestedPositiveBackgroundTick\":3,\"isIsolatingForHadRiskyContactBackgroundTick\":13,\"receivedRiskyContactNotification\":1,\"startedIsolation\":1,\"receivedPositiveTestResultWhenIsolatingDueToRiskyContact\":1,\"receivedActiveIpcToken\":1,\"haveActiveIpcTokenBackgroundTick\":1,\"selectedIsolationPaymentsButton\":1,\"launchedIsolationPaymentsApplication\":1,\"receivedPositiveLFDTestResultViaPolling\":1,\"receivedNegativeLFDTestResultViaPolling\":1,\"receivedVoidLFDTestResultViaPolling\":1,\"receivedPositiveLFDTestResultEnteredManually\":1,\"receivedNegativeLFDTestResultEnteredManually\":1,\"receivedVoidLFDTestResultEnteredManually\":1,\"hasTestedLFDPositiveBackgroundTick\":1,\"isIsolatingForTestedLFDPositiveBackgroundTick\":1,\"totalExposureWindowsNotConsideredRisky\":1,\"totalExposureWindowsConsideredRisky\":1}"
    const val STORED_ANALYTICS_PAYLOAD_IOS = "{\"startDate\":\"2020-07-27T23:00:00Z\",\"endDate\":\"2020-07-28T22:59:00Z\",\"postalDistrict\":\"AB10\",\"deviceModel\":\"iPhone11,2\",\"operatingSystemVersion\":\"iPhone OS 13.5.1 (17F80)\",\"latestApplicationVersion\":\"3.0\",\"localAuthority\":null,\"cumulativeDownloadBytes\":140000000,\"cumulativeUploadBytes\":140000000,\"cumulativeCellularDownloadBytes\":80000000,\"cumulativeCellularUploadBytes\":70000000,\"cumulativeWifiDownloadBytes\":60000000,\"cumulativeWifiUploadBytes\":50000000,\"checkedIn\":1,\"canceledCheckIn\":1,\"receivedVoidTestResult\":1,\"isIsolatingBackgroundTick\":1,\"hasHadRiskyContactBackgroundTick\":1,\"receivedPositiveTestResult\":1,\"receivedNegativeTestResult\":1,\"hasSelfDiagnosedPositiveBackgroundTick\":1,\"completedQuestionnaireAndStartedIsolation\":1,\"encounterDetectionPausedBackgroundTick\":1,\"completedQuestionnaireButDidNotStartIsolation\":1,\"totalBackgroundTasks\":1,\"runningNormallyBackgroundTick\":1,\"completedOnboarding\":1,\"includesMultipleApplicationVersions\":false,\"receivedVoidTestResultEnteredManually\":null,\"receivedPositiveTestResultEnteredManually\":null,\"receivedNegativeTestResultEnteredManually\":null,\"receivedVoidTestResultViaPolling\":null,\"receivedPositiveTestResultViaPolling\":null,\"receivedNegativeTestResultViaPolling\":null,\"hasSelfDiagnosedBackgroundTick\":null,\"hasTestedPositiveBackgroundTick\":null,\"isIsolatingForSelfDiagnosedBackgroundTick\":null,\"isIsolatingForTestedPositiveBackgroundTick\":null,\"isIsolatingForHadRiskyContactBackgroundTick\":null,\"receivedRiskyContactNotification\":null,\"startedIsolation\":null,\"receivedPositiveTestResultWhenIsolatingDueToRiskyContact\":null,\"receivedActiveIpcToken\":null,\"haveActiveIpcTokenBackgroundTick\":null,\"selectedIsolationPaymentsButton\":null,\"launchedIsolationPaymentsApplication\":null,\"receivedPositiveLFDTestResultViaPolling\":null,\"receivedNegativeLFDTestResultViaPolling\":null,\"receivedVoidLFDTestResultViaPolling\":null,\"receivedPositiveLFDTestResultEnteredManually\":null,\"receivedNegativeLFDTestResultEnteredManually\":null,\"receivedVoidLFDTestResultEnteredManually\":null,\"hasTestedLFDPositiveBackgroundTick\":null,\"isIsolatingForTestedLFDPositiveBackgroundTick\":null,\"totalExposureWindowsNotConsideredRisky\":null,\"totalExposureWindowsConsideredRisky\":null}"
    const val STORED_ANALYTICS_PAYLOAD_IOS_WITH_LOCAL_AUTHORITY = "{\"startDate\":\"2020-07-27T23:00:00Z\",\"endDate\":\"2020-07-28T22:59:00Z\",\"postalDistrict\":\"SY5_TF6\",\"deviceModel\":\"iPhone11,2\",\"operatingSystemVersion\":\"iPhone OS 13.5.1 (17F80)\",\"latestApplicationVersion\":\"3.0\",\"localAuthority\":\"E06000051\",\"cumulativeDownloadBytes\":140000000,\"cumulativeUploadBytes\":140000000,\"cumulativeCellularDownloadBytes\":80000000,\"cumulativeCellularUploadBytes\":70000000,\"cumulativeWifiDownloadBytes\":60000000,\"cumulativeWifiUploadBytes\":50000000,\"checkedIn\":1,\"canceledCheckIn\":1,\"receivedVoidTestResult\":1,\"isIsolatingBackgroundTick\":1,\"hasHadRiskyContactBackgroundTick\":1,\"receivedPositiveTestResult\":1,\"receivedNegativeTestResult\":1,\"hasSelfDiagnosedPositiveBackgroundTick\":1,\"completedQuestionnaireAndStartedIsolation\":1,\"encounterDetectionPausedBackgroundTick\":1,\"completedQuestionnaireButDidNotStartIsolation\":1,\"totalBackgroundTasks\":1,\"runningNormallyBackgroundTick\":1,\"completedOnboarding\":1,\"includesMultipleApplicationVersions\":false,\"receivedVoidTestResultEnteredManually\":null,\"receivedPositiveTestResultEnteredManually\":null,\"receivedNegativeTestResultEnteredManually\":null,\"receivedVoidTestResultViaPolling\":null,\"receivedPositiveTestResultViaPolling\":null,\"receivedNegativeTestResultViaPolling\":null,\"hasSelfDiagnosedBackgroundTick\":null,\"hasTestedPositiveBackgroundTick\":null,\"isIsolatingForSelfDiagnosedBackgroundTick\":null,\"isIsolatingForTestedPositiveBackgroundTick\":null,\"isIsolatingForHadRiskyContactBackgroundTick\":null,\"receivedRiskyContactNotification\":null,\"startedIsolation\":null,\"receivedPositiveTestResultWhenIsolatingDueToRiskyContact\":null,\"receivedActiveIpcToken\":null,\"haveActiveIpcTokenBackgroundTick\":null,\"selectedIsolationPaymentsButton\":null,\"launchedIsolationPaymentsApplication\":null,\"receivedPositiveLFDTestResultViaPolling\":null,\"receivedNegativeLFDTestResultViaPolling\":null,\"receivedVoidLFDTestResultViaPolling\":null,\"receivedPositiveLFDTestResultEnteredManually\":null,\"receivedNegativeLFDTestResultEnteredManually\":null,\"receivedVoidLFDTestResultEnteredManually\":null,\"hasTestedLFDPositiveBackgroundTick\":null,\"isIsolatingForTestedLFDPositiveBackgroundTick\":null,\"totalExposureWindowsNotConsideredRisky\":null,\"totalExposureWindowsConsideredRisky\":null}"
    const val STORED_ANALYTICS_MERGED_POSTCODE_PAYLOAD_IOS = "{\"startDate\":\"2020-07-27T23:00:00Z\",\"endDate\":\"2020-07-28T22:59:00Z\",\"postalDistrict\":\"AB13_AB14\",\"deviceModel\":\"iPhone11,2\",\"operatingSystemVersion\":\"iPhone OS 13.5.1 (17F80)\",\"latestApplicationVersion\":\"3.0\",\"localAuthority\":null,\"cumulativeDownloadBytes\":140000000,\"cumulativeUploadBytes\":140000000,\"cumulativeCellularDownloadBytes\":80000000,\"cumulativeCellularUploadBytes\":70000000,\"cumulativeWifiDownloadBytes\":60000000,\"cumulativeWifiUploadBytes\":50000000,\"checkedIn\":1,\"canceledCheckIn\":1,\"receivedVoidTestResult\":1,\"isIsolatingBackgroundTick\":1,\"hasHadRiskyContactBackgroundTick\":1,\"receivedPositiveTestResult\":1,\"receivedNegativeTestResult\":1,\"hasSelfDiagnosedPositiveBackgroundTick\":1,\"completedQuestionnaireAndStartedIsolation\":1,\"encounterDetectionPausedBackgroundTick\":1,\"completedQuestionnaireButDidNotStartIsolation\":1,\"totalBackgroundTasks\":1,\"runningNormallyBackgroundTick\":1,\"completedOnboarding\":1,\"includesMultipleApplicationVersions\":false,\"receivedVoidTestResultEnteredManually\":null,\"receivedPositiveTestResultEnteredManually\":null,\"receivedNegativeTestResultEnteredManually\":null,\"receivedVoidTestResultViaPolling\":null,\"receivedPositiveTestResultViaPolling\":null,\"receivedNegativeTestResultViaPolling\":null,\"hasSelfDiagnosedBackgroundTick\":null,\"hasTestedPositiveBackgroundTick\":null,\"isIsolatingForSelfDiagnosedBackgroundTick\":null,\"isIsolatingForTestedPositiveBackgroundTick\":null,\"isIsolatingForHadRiskyContactBackgroundTick\":null,\"receivedRiskyContactNotification\":null,\"startedIsolation\":null,\"receivedPositiveTestResultWhenIsolatingDueToRiskyContact\":null,\"receivedActiveIpcToken\":null,\"haveActiveIpcTokenBackgroundTick\":null,\"selectedIsolationPaymentsButton\":null,\"launchedIsolationPaymentsApplication\":null,\"receivedPositiveLFDTestResultViaPolling\":null,\"receivedNegativeLFDTestResultViaPolling\":null,\"receivedVoidLFDTestResultViaPolling\":null,\"receivedPositiveLFDTestResultEnteredManually\":null,\"receivedNegativeLFDTestResultEnteredManually\":null,\"receivedVoidLFDTestResultEnteredManually\":null,\"hasTestedLFDPositiveBackgroundTick\":null,\"isIsolatingForTestedLFDPositiveBackgroundTick\":null,\"totalExposureWindowsNotConsideredRisky\":null,\"totalExposureWindowsConsideredRisky\":null}"
    const val STORED_ANALYTICS_INVALID_PAIR = "{\"startDate\":\"2020-07-27T23:00:00Z\",\"endDate\":\"2020-07-28T22:59:00Z\",\"postalDistrict\":\"YO60_YO62\",\"deviceModel\":\"iPhone11,2\",\"operatingSystemVersion\":\"iPhone OS 13.5.1 (17F80)\",\"latestApplicationVersion\":\"3.0\",\"localAuthority\":null,\"cumulativeDownloadBytes\":140000000,\"cumulativeUploadBytes\":140000000,\"cumulativeCellularDownloadBytes\":80000000,\"cumulativeCellularUploadBytes\":70000000,\"cumulativeWifiDownloadBytes\":60000000,\"cumulativeWifiUploadBytes\":50000000,\"checkedIn\":1,\"canceledCheckIn\":1,\"receivedVoidTestResult\":1,\"isIsolatingBackgroundTick\":1,\"hasHadRiskyContactBackgroundTick\":1,\"receivedPositiveTestResult\":1,\"receivedNegativeTestResult\":1,\"hasSelfDiagnosedPositiveBackgroundTick\":1,\"completedQuestionnaireAndStartedIsolation\":1,\"encounterDetectionPausedBackgroundTick\":1,\"completedQuestionnaireButDidNotStartIsolation\":1,\"totalBackgroundTasks\":1,\"runningNormallyBackgroundTick\":1,\"completedOnboarding\":1,\"includesMultipleApplicationVersions\":false,\"receivedVoidTestResultEnteredManually\":null,\"receivedPositiveTestResultEnteredManually\":null,\"receivedNegativeTestResultEnteredManually\":null,\"receivedVoidTestResultViaPolling\":null,\"receivedPositiveTestResultViaPolling\":null,\"receivedNegativeTestResultViaPolling\":null,\"hasSelfDiagnosedBackgroundTick\":null,\"hasTestedPositiveBackgroundTick\":null,\"isIsolatingForSelfDiagnosedBackgroundTick\":null,\"isIsolatingForTestedPositiveBackgroundTick\":null,\"isIsolatingForHadRiskyContactBackgroundTick\":null,\"receivedRiskyContactNotification\":null,\"startedIsolation\":null,\"receivedPositiveTestResultWhenIsolatingDueToRiskyContact\":null,\"receivedActiveIpcToken\":null,\"haveActiveIpcTokenBackgroundTick\":null,\"selectedIsolationPaymentsButton\":null,\"launchedIsolationPaymentsApplication\":null,\"receivedPositiveLFDTestResultViaPolling\":null,\"receivedNegativeLFDTestResultViaPolling\":null,\"receivedVoidLFDTestResultViaPolling\":null,\"receivedPositiveLFDTestResultEnteredManually\":null,\"receivedNegativeLFDTestResultEnteredManually\":null,\"receivedVoidLFDTestResultEnteredManually\":null,\"hasTestedLFDPositiveBackgroundTick\":null,\"isIsolatingForTestedLFDPositiveBackgroundTick\":null,\"totalExposureWindowsNotConsideredRisky\":null,\"totalExposureWindowsConsideredRisky\":null}"
    const val STORED_ANALYTICS_EMPTY_PAIR = "{\"startDate\":\"2020-07-27T23:00:00Z\",\"endDate\":\"2020-07-28T22:59:00Z\",\"postalDistrict\":\"NOT SET\",\"deviceModel\":\"iPhone11,2\",\"operatingSystemVersion\":\"iPhone OS 13.5.1 (17F80)\",\"latestApplicationVersion\":\"3.0\",\"localAuthority\":null,\"cumulativeDownloadBytes\":140000000,\"cumulativeUploadBytes\":140000000,\"cumulativeCellularDownloadBytes\":80000000,\"cumulativeCellularUploadBytes\":70000000,\"cumulativeWifiDownloadBytes\":60000000,\"cumulativeWifiUploadBytes\":50000000,\"checkedIn\":1,\"canceledCheckIn\":1,\"receivedVoidTestResult\":1,\"isIsolatingBackgroundTick\":1,\"hasHadRiskyContactBackgroundTick\":1,\"receivedPositiveTestResult\":1,\"receivedNegativeTestResult\":1,\"hasSelfDiagnosedPositiveBackgroundTick\":1,\"completedQuestionnaireAndStartedIsolation\":1,\"encounterDetectionPausedBackgroundTick\":1,\"completedQuestionnaireButDidNotStartIsolation\":1,\"totalBackgroundTasks\":1,\"runningNormallyBackgroundTick\":1,\"completedOnboarding\":1,\"includesMultipleApplicationVersions\":false,\"receivedVoidTestResultEnteredManually\":null,\"receivedPositiveTestResultEnteredManually\":null,\"receivedNegativeTestResultEnteredManually\":null,\"receivedVoidTestResultViaPolling\":null,\"receivedPositiveTestResultViaPolling\":null,\"receivedNegativeTestResultViaPolling\":null,\"hasSelfDiagnosedBackgroundTick\":null,\"hasTestedPositiveBackgroundTick\":null,\"isIsolatingForSelfDiagnosedBackgroundTick\":null,\"isIsolatingForTestedPositiveBackgroundTick\":null,\"isIsolatingForHadRiskyContactBackgroundTick\":null,\"receivedRiskyContactNotification\":null,\"startedIsolation\":null,\"receivedPositiveTestResultWhenIsolatingDueToRiskyContact\":null,\"receivedActiveIpcToken\":null,\"haveActiveIpcTokenBackgroundTick\":null,\"selectedIsolationPaymentsButton\":null,\"launchedIsolationPaymentsApplication\":null,\"receivedPositiveLFDTestResultViaPolling\":null,\"receivedNegativeLFDTestResultViaPolling\":null,\"receivedVoidLFDTestResultViaPolling\":null,\"receivedPositiveLFDTestResultEnteredManually\":null,\"receivedNegativeLFDTestResultEnteredManually\":null,\"receivedVoidLFDTestResultEnteredManually\":null,\"hasTestedLFDPositiveBackgroundTick\":null,\"isIsolatingForTestedLFDPositiveBackgroundTick\":null,\"totalExposureWindowsNotConsideredRisky\":null,\"totalExposureWindowsConsideredRisky\":null}"
    const val STORED_ANALYTICS_UNKNOWN_POSTCODE_PAYLOAD_IOS = "{\"startDate\":\"2020-07-27T23:00:00Z\",\"endDate\":\"2020-07-28T22:59:00Z\",\"postalDistrict\":\"UNKNOWN\",\"deviceModel\":\"iPhone11,2\",\"operatingSystemVersion\":\"iPhone OS 13.5.1 (17F80)\",\"latestApplicationVersion\":\"3.0\",\"localAuthority\":\"UNKNOWN\",\"cumulativeDownloadBytes\":140000000,\"cumulativeUploadBytes\":140000000,\"cumulativeCellularDownloadBytes\":80000000,\"cumulativeCellularUploadBytes\":70000000,\"cumulativeWifiDownloadBytes\":60000000,\"cumulativeWifiUploadBytes\":50000000,\"checkedIn\":1,\"canceledCheckIn\":1,\"receivedVoidTestResult\":1,\"isIsolatingBackgroundTick\":1,\"hasHadRiskyContactBackgroundTick\":1,\"receivedPositiveTestResult\":1,\"receivedNegativeTestResult\":1,\"hasSelfDiagnosedPositiveBackgroundTick\":1,\"completedQuestionnaireAndStartedIsolation\":1,\"encounterDetectionPausedBackgroundTick\":1,\"completedQuestionnaireButDidNotStartIsolation\":1,\"totalBackgroundTasks\":1,\"runningNormallyBackgroundTick\":1,\"completedOnboarding\":1,\"includesMultipleApplicationVersions\":false,\"receivedVoidTestResultEnteredManually\":null,\"receivedPositiveTestResultEnteredManually\":null,\"receivedNegativeTestResultEnteredManually\":null,\"receivedVoidTestResultViaPolling\":null,\"receivedPositiveTestResultViaPolling\":null,\"receivedNegativeTestResultViaPolling\":null,\"hasSelfDiagnosedBackgroundTick\":null,\"hasTestedPositiveBackgroundTick\":null,\"isIsolatingForSelfDiagnosedBackgroundTick\":null,\"isIsolatingForTestedPositiveBackgroundTick\":null,\"isIsolatingForHadRiskyContactBackgroundTick\":null,\"receivedRiskyContactNotification\":null,\"startedIsolation\":null,\"receivedPositiveTestResultWhenIsolatingDueToRiskyContact\":null,\"receivedActiveIpcToken\":null,\"haveActiveIpcTokenBackgroundTick\":null,\"selectedIsolationPaymentsButton\":null,\"launchedIsolationPaymentsApplication\":null,\"receivedPositiveLFDTestResultViaPolling\":null,\"receivedNegativeLFDTestResultViaPolling\":null,\"receivedVoidLFDTestResultViaPolling\":null,\"receivedPositiveLFDTestResultEnteredManually\":null,\"receivedNegativeLFDTestResultEnteredManually\":null,\"receivedVoidLFDTestResultEnteredManually\":null,\"hasTestedLFDPositiveBackgroundTick\":null,\"isIsolatingForTestedLFDPositiveBackgroundTick\":null,\"totalExposureWindowsNotConsideredRisky\":null,\"totalExposureWindowsConsideredRisky\":null}"
    const val STORED_ANALYTICS_PAYLOAD_ANDROID = "{\"startDate\":\"2020-07-27T23:00:00Z\",\"endDate\":\"2020-07-28T22:59:00Z\",\"postalDistrict\":\"AB10\",\"deviceModel\":\"HUAWEI LDN-L21\",\"operatingSystemVersion\":\"29\",\"latestApplicationVersion\":\"3.0\",\"localAuthority\":null,\"cumulativeDownloadBytes\":null,\"cumulativeUploadBytes\":null,\"cumulativeCellularDownloadBytes\":null,\"cumulativeCellularUploadBytes\":null,\"cumulativeWifiDownloadBytes\":null,\"cumulativeWifiUploadBytes\":null,\"checkedIn\":1,\"canceledCheckIn\":1,\"receivedVoidTestResult\":1,\"isIsolatingBackgroundTick\":1,\"hasHadRiskyContactBackgroundTick\":1,\"receivedPositiveTestResult\":1,\"receivedNegativeTestResult\":1,\"hasSelfDiagnosedPositiveBackgroundTick\":1,\"completedQuestionnaireAndStartedIsolation\":1,\"encounterDetectionPausedBackgroundTick\":1,\"completedQuestionnaireButDidNotStartIsolation\":1,\"totalBackgroundTasks\":1,\"runningNormallyBackgroundTick\":1,\"completedOnboarding\":1,\"includesMultipleApplicationVersions\":false,\"receivedVoidTestResultEnteredManually\":null,\"receivedPositiveTestResultEnteredManually\":null,\"receivedNegativeTestResultEnteredManually\":null,\"receivedVoidTestResultViaPolling\":null,\"receivedPositiveTestResultViaPolling\":null,\"receivedNegativeTestResultViaPolling\":null,\"hasSelfDiagnosedBackgroundTick\":null,\"hasTestedPositiveBackgroundTick\":null,\"isIsolatingForSelfDiagnosedBackgroundTick\":null,\"isIsolatingForTestedPositiveBackgroundTick\":null,\"isIsolatingForHadRiskyContactBackgroundTick\":null,\"receivedRiskyContactNotification\":null,\"startedIsolation\":null,\"receivedPositiveTestResultWhenIsolatingDueToRiskyContact\":null,\"receivedActiveIpcToken\":null,\"haveActiveIpcTokenBackgroundTick\":null,\"selectedIsolationPaymentsButton\":null,\"launchedIsolationPaymentsApplication\":null,\"receivedPositiveLFDTestResultViaPolling\":null,\"receivedNegativeLFDTestResultViaPolling\":null,\"receivedVoidLFDTestResultViaPolling\":null,\"receivedPositiveLFDTestResultEnteredManually\":null,\"receivedNegativeLFDTestResultEnteredManually\":null,\"receivedVoidLFDTestResultEnteredManually\":null,\"hasTestedLFDPositiveBackgroundTick\":null,\"isIsolatingForTestedLFDPositiveBackgroundTick\":null,\"totalExposureWindowsNotConsideredRisky\":null,\"totalExposureWindowsConsideredRisky\":null}"
    const val STORED_ANALYTICS_PAYLOAD_ANDROID_WITH_LOCAL_AUTHORITY = "{\"startDate\":\"2020-07-27T23:00:00Z\",\"endDate\":\"2020-07-28T22:59:00Z\",\"postalDistrict\":\"SY5_TF6\",\"deviceModel\":\"HUAWEI LDN-L21\",\"operatingSystemVersion\":\"29\",\"latestApplicationVersion\":\"3.0\",\"localAuthority\":\"E06000051\",\"cumulativeDownloadBytes\":null,\"cumulativeUploadBytes\":null,\"cumulativeCellularDownloadBytes\":null,\"cumulativeCellularUploadBytes\":null,\"cumulativeWifiDownloadBytes\":null,\"cumulativeWifiUploadBytes\":null,\"checkedIn\":1,\"canceledCheckIn\":1,\"receivedVoidTestResult\":1,\"isIsolatingBackgroundTick\":1,\"hasHadRiskyContactBackgroundTick\":1,\"receivedPositiveTestResult\":1,\"receivedNegativeTestResult\":1,\"hasSelfDiagnosedPositiveBackgroundTick\":1,\"completedQuestionnaireAndStartedIsolation\":1,\"encounterDetectionPausedBackgroundTick\":1,\"completedQuestionnaireButDidNotStartIsolation\":1,\"totalBackgroundTasks\":1,\"runningNormallyBackgroundTick\":1,\"completedOnboarding\":1,\"includesMultipleApplicationVersions\":false,\"receivedVoidTestResultEnteredManually\":null,\"receivedPositiveTestResultEnteredManually\":null,\"receivedNegativeTestResultEnteredManually\":null,\"receivedVoidTestResultViaPolling\":null,\"receivedPositiveTestResultViaPolling\":null,\"receivedNegativeTestResultViaPolling\":null,\"hasSelfDiagnosedBackgroundTick\":null,\"hasTestedPositiveBackgroundTick\":null,\"isIsolatingForSelfDiagnosedBackgroundTick\":null,\"isIsolatingForTestedPositiveBackgroundTick\":null,\"isIsolatingForHadRiskyContactBackgroundTick\":null,\"receivedRiskyContactNotification\":null,\"startedIsolation\":null,\"receivedPositiveTestResultWhenIsolatingDueToRiskyContact\":null,\"receivedActiveIpcToken\":null,\"haveActiveIpcTokenBackgroundTick\":null,\"selectedIsolationPaymentsButton\":null,\"launchedIsolationPaymentsApplication\":null,\"receivedPositiveLFDTestResultViaPolling\":null,\"receivedNegativeLFDTestResultViaPolling\":null,\"receivedVoidLFDTestResultViaPolling\":null,\"receivedPositiveLFDTestResultEnteredManually\":null,\"receivedNegativeLFDTestResultEnteredManually\":null,\"receivedVoidLFDTestResultEnteredManually\":null,\"hasTestedLFDPositiveBackgroundTick\":null,\"isIsolatingForTestedLFDPositiveBackgroundTick\":null,\"totalExposureWindowsNotConsideredRisky\":null,\"totalExposureWindowsConsideredRisky\":null}"
    const val STORED_ANALYTICS_MERGED_POSTCODE_PAYLOAD_ANDROID = "{\"startDate\":\"2020-07-27T23:00:00Z\",\"endDate\":\"2020-07-28T22:59:00Z\",\"postalDistrict\":\"AB13_AB14\",\"deviceModel\":\"HUAWEI LDN-L21\",\"operatingSystemVersion\":\"29\",\"latestApplicationVersion\":\"3.0\",\"localAuthority\":null,\"cumulativeDownloadBytes\":null,\"cumulativeUploadBytes\":null,\"cumulativeCellularDownloadBytes\":null,\"cumulativeCellularUploadBytes\":null,\"cumulativeWifiDownloadBytes\":null,\"cumulativeWifiUploadBytes\":null,\"checkedIn\":1,\"canceledCheckIn\":1,\"receivedVoidTestResult\":1,\"isIsolatingBackgroundTick\":1,\"hasHadRiskyContactBackgroundTick\":1,\"receivedPositiveTestResult\":1,\"receivedNegativeTestResult\":1,\"hasSelfDiagnosedPositiveBackgroundTick\":1,\"completedQuestionnaireAndStartedIsolation\":1,\"encounterDetectionPausedBackgroundTick\":1,\"completedQuestionnaireButDidNotStartIsolation\":1,\"totalBackgroundTasks\":1,\"runningNormallyBackgroundTick\":1,\"completedOnboarding\":1,\"includesMultipleApplicationVersions\":false,\"receivedVoidTestResultEnteredManually\":null,\"receivedPositiveTestResultEnteredManually\":null,\"receivedNegativeTestResultEnteredManually\":null,\"receivedVoidTestResultViaPolling\":null,\"receivedPositiveTestResultViaPolling\":null,\"receivedNegativeTestResultViaPolling\":null,\"hasSelfDiagnosedBackgroundTick\":null,\"hasTestedPositiveBackgroundTick\":null,\"isIsolatingForSelfDiagnosedBackgroundTick\":null,\"isIsolatingForTestedPositiveBackgroundTick\":null,\"isIsolatingForHadRiskyContactBackgroundTick\":null,\"receivedRiskyContactNotification\":null,\"startedIsolation\":null,\"receivedPositiveTestResultWhenIsolatingDueToRiskyContact\":null,\"receivedActiveIpcToken\":null,\"haveActiveIpcTokenBackgroundTick\":null,\"selectedIsolationPaymentsButton\":null,\"launchedIsolationPaymentsApplication\":null,\"receivedPositiveLFDTestResultViaPolling\":null,\"receivedNegativeLFDTestResultViaPolling\":null,\"receivedVoidLFDTestResultViaPolling\":null,\"receivedPositiveLFDTestResultEnteredManually\":null,\"receivedNegativeLFDTestResultEnteredManually\":null,\"receivedVoidLFDTestResultEnteredManually\":null,\"hasTestedLFDPositiveBackgroundTick\":null,\"isIsolatingForTestedLFDPositiveBackgroundTick\":null,\"totalExposureWindowsNotConsideredRisky\":null,\"totalExposureWindowsConsideredRisky\":null}"
    const val STORED_ANALYTICS_UNKNOWN_POSTCODE_PAYLOAD_ANDROID = "{\"startDate\":\"2020-07-27T23:00:00Z\",\"endDate\":\"2020-07-28T22:59:00Z\",\"postalDistrict\":\"UNKNOWN\",\"deviceModel\":\"HUAWEI LDN-L21\",\"operatingSystemVersion\":\"29\",\"latestApplicationVersion\":\"3.0\",\"localAuthority\":\"UNKNOWN\",\"cumulativeDownloadBytes\":null,\"cumulativeUploadBytes\":null,\"cumulativeCellularDownloadBytes\":null,\"cumulativeCellularUploadBytes\":null,\"cumulativeWifiDownloadBytes\":null,\"cumulativeWifiUploadBytes\":null,\"checkedIn\":1,\"canceledCheckIn\":1,\"receivedVoidTestResult\":1,\"isIsolatingBackgroundTick\":1,\"hasHadRiskyContactBackgroundTick\":1,\"receivedPositiveTestResult\":1,\"receivedNegativeTestResult\":1,\"hasSelfDiagnosedPositiveBackgroundTick\":1,\"completedQuestionnaireAndStartedIsolation\":1,\"encounterDetectionPausedBackgroundTick\":1,\"completedQuestionnaireButDidNotStartIsolation\":1,\"totalBackgroundTasks\":1,\"runningNormallyBackgroundTick\":1,\"completedOnboarding\":1,\"includesMultipleApplicationVersions\":false,\"receivedVoidTestResultEnteredManually\":null,\"receivedPositiveTestResultEnteredManually\":null,\"receivedNegativeTestResultEnteredManually\":null,\"receivedVoidTestResultViaPolling\":null,\"receivedPositiveTestResultViaPolling\":null,\"receivedNegativeTestResultViaPolling\":null,\"hasSelfDiagnosedBackgroundTick\":null,\"hasTestedPositiveBackgroundTick\":null,\"isIsolatingForSelfDiagnosedBackgroundTick\":null,\"isIsolatingForTestedPositiveBackgroundTick\":null,\"isIsolatingForHadRiskyContactBackgroundTick\":null,\"receivedRiskyContactNotification\":null,\"startedIsolation\":null,\"receivedPositiveTestResultWhenIsolatingDueToRiskyContact\":null,\"receivedActiveIpcToken\":null,\"haveActiveIpcTokenBackgroundTick\":null,\"selectedIsolationPaymentsButton\":null,\"launchedIsolationPaymentsApplication\":null,\"receivedPositiveLFDTestResultViaPolling\":null,\"receivedNegativeLFDTestResultViaPolling\":null,\"receivedVoidLFDTestResultViaPolling\":null,\"receivedPositiveLFDTestResultEnteredManually\":null,\"receivedNegativeLFDTestResultEnteredManually\":null,\"receivedVoidLFDTestResultEnteredManually\":null,\"hasTestedLFDPositiveBackgroundTick\":null,\"isIsolatingForTestedLFDPositiveBackgroundTick\":null,\"totalExposureWindowsNotConsideredRisky\":null,\"totalExposureWindowsConsideredRisky\":null}"
    const val EXPOSURE_NOTIFICATION_CIRCUIT_BREAKER_PAYLOAD = " {\"matchedKeyCount\" : 2,\n" +
        " \"daysSinceLastExposure\": 3,\n" +
        " \"maximumRiskScore\" : 150\n" +
        " }"

    val positivePcrTestResult = TestResult("abc", "2020-04-23T18:34:03Z", "POSITIVE", "available", TestKit.LAB_RESULT)
    val pendingTestResultNoTestKit = TestResult("abc", "", "", "pending", null)
    val positiveLfdTestResult = TestResult("abc", "2020-04-23T18:34:03Z", "POSITIVE", "available", TestKit.RAPID_RESULT)

    fun positiveTestResultFor(token: TestResultPollingToken): TestResult {
        return TestResult(token.value, "2020-04-23T18:34:03Z", "POSITIVE", "available", TestKit.LAB_RESULT)
    }

    const val tokenGenRequestV1 = """{"testEndDate":"2020-09-07T01:01:01Z","testResult":"POSITIVE"}"""
    const val tokenGenRequestV2 = """{"testEndDate":"2020-09-07T01:01:01Z","testResult":"POSITIVE","testKit":"RAPID_RESULT"}"""

}
