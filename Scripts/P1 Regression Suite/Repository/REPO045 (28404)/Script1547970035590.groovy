import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

'Login Into Application'
CustomKeywords.'actions.Common.login'()

'Expand Repository Menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/Repository/h3_Repository Menu'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

'Select Repository - Advance Search tab'
WebUI.selectOptionByLabel(findTestObject('Page_nGage_Dashboard/Repository/select_Repository Drop Down'), 'Required Date time EDM', false)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

'Selinput_btnSearchect Search For - Advance Search tab'
WebUI.selectOptionByLabel(findTestObject('Page_nGage_Dashboard/Repository/select_Search For Drop Down'), 'Required field date time search class', false)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

'Click on Search button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Repository/input_btnSearch'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

'Verify error message is displayed for required field'
WebUI.verifyElementVisible(findTestObject('Page_nGage_Dashboard/Repository/label_Required_DateTimeRange_End'))
WebUI.verifyElementVisible(findTestObject('Page_nGage_Dashboard/Repository/label_Required_DateTimeRange_Start'))
WebUI.verifyElementNotPresent(findTestObject('Page_nGage_Dashboard/Repository/label_Required_DateRange_End'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementNotPresent(findTestObject('Page_nGage_Dashboard/Repository/label_Required_DateRange_Start'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementText(findTestObject('Page_nGage_Dashboard/Repository/label_Required_DateTimeRange_End'), 'Required')
WebUI.verifyElementText(findTestObject('Page_nGage_Dashboard/Repository/label_Required_DateTimeRange_Start'), 'Required')


'Select Repository - Advance Search tab'
WebUI.selectOptionByLabel(findTestObject('Page_nGage_Dashboard/Repository/select_Repository Drop Down'), 'Required Date string field EDM', false)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

'Selinput_btnSearchect Search For - Advance Search tab'
WebUI.selectOptionByLabel(findTestObject('Page_nGage_Dashboard/Repository/select_Search For Drop Down'), 'Required field date string search class', false)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

'Click on Search button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Repository/input_btnSearch'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

'Verify error message is displayed for required field'
WebUI.verifyElementVisible(findTestObject('Page_nGage_Dashboard/Repository/label_Required_DateRange_End'))
WebUI.verifyElementVisible(findTestObject('Page_nGage_Dashboard/Repository/label_Required_DateRange_Start'))
WebUI.verifyElementNotPresent(findTestObject('Page_nGage_Dashboard/Repository/label_Required_DateTimeRange_End'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementNotPresent(findTestObject('Page_nGage_Dashboard/Repository/label_Required_DateTimeRange_Start'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementText(findTestObject('Page_nGage_Dashboard/Repository/label_Required_DateRange_End'), 'Required')
WebUI.verifyElementText(findTestObject('Page_nGage_Dashboard/Repository/label_Required_DateRange_Start'), 'Required')