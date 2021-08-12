package contract

import contract.infra.BackendContractScenario
import contract.infra.RecordingTest
import contract.infra.ReplayTest
import org.junit.jupiter.api.Test
import smoke.actors.ApiVersion.V2
import smoke.actors.MobileApp
import smoke.actors.TestLab
import smoke.data.DiagnosisKeyData
import smoke.env.SmokeTests
import uk.nhs.nhsx.domain.TestEndDate
import uk.nhs.nhsx.domain.TestKit.LAB_RESULT
import uk.nhs.nhsx.domain.TestResult.Positive
import uk.nhs.nhsx.virology.VirologyUploadHandler.VirologyResultSource.Npex
import uk.nhs.nhsx.virology.VirologyUploadHandler.VirologyTokenExchangeSource.Wls

interface UserGetsVirologyTestAndPollForResult : BackendContractScenario {
    @Test
    @JvmDefault
    fun `Mobile user orders test and polls for result`() {
        val mobileApp = MobileApp(mitmHttpClient(), envConfig)

        control.addNote("Mobile App orders test")
        val orderTest = mobileApp.orderTest()
        val ctaToken = orderTest.tokenParameterValue

        control.addNote("Mobile App checks incomplete test")
        mobileApp.pollForIncompleteTestResult(orderTest, V2)

        outOfBandAction { TestLab(http(), envConfig).uploadTestResult(ctaToken, Positive, Npex, V2, LAB_RESULT) }

        control.addNote("Mobile App checks for completed test result")
        mobileApp.pollForTestResult(orderTest.testResultPollingToken, V2)
    }

    @Test
    @JvmDefault
    fun `Mobile user registers test and polls for result`() {
        val mobileApp = MobileApp(mitmHttpClient(), envConfig)

        control.addNote("Mobile App registers test")
        val registerTest = mobileApp.registerTest()

        val ctaToken = registerTest.tokenParameterValue

        control.addNote("Mobile App checks incomplete test")
        mobileApp.pollForIncompleteTestResult(registerTest, V2)

        outOfBandAction { TestLab(http(), envConfig).uploadTestResult(ctaToken, Positive, Npex, V2, LAB_RESULT) }

        control.addNote("Mobile App checks for completed test result")
        mobileApp.pollForTestResult(registerTest.testResultPollingToken, V2)
    }

    @Test
    fun `Mobile user gets a test result in exchange for a cta token that was not generated by the app`() {
        val ctaToken =
            TestLab(http(), envConfig).generateCtaTokenFor(Positive, TestEndDate.of(2020, 11, 19), Wls, V2, LAB_RESULT)

        control.addNote("Mobile App exchanges manually acquired token for test result")
        MobileApp(mitmHttpClient(), envConfig).exchange(ctaToken, V2)
    }

    @Test
    @JvmDefault
    fun `Mobile user uploads diagnosis keys`() {
        val mobileApp = MobileApp(mitmHttpClient(), envConfig)

        control.addNote("Mobile App orders test")
        val orderTest = mobileApp.orderTest()

        control.addNote("Mobile App submits diagnosis keys")
        mobileApp.submitKeys(
            orderTest.diagnosisKeySubmissionToken,
            DiagnosisKeyData.generateDiagnosisKeyData(5)
        )
    }

    @Test
    @JvmDefault
    fun `Mobile performs empty submission`() {
        control.addNote("Mobile performs empty submission")
        MobileApp(mitmHttpClient(), envConfig).emptySubmission()
    }
}

class RecordingUserGetsVirologyTestAndPollForResultTest : RecordingTest(), UserGetsVirologyTestAndPollForResult {
    override val envConfig = SmokeTests.loadConfig()
}

class ReplayUserGetsVirologyTestAndPollForResultTest : ReplayTest(), UserGetsVirologyTestAndPollForResult {
    override val envConfig = SmokeTests.loadConfig()
}
