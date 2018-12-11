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

'Login into application'
CustomKeywords.'actions.Common.login'()

'Expand Repository Menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/Repository/h3_Repository Menu'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

'Select Repository - Advance Search tab'
WebUI.selectOptionByLabel(findTestObject('Page_nGage_Dashboard/Repository/select_Repository Drop Down'), 'Required Date string field EDM', false)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

'Selinput_btnSearchect Search For - Advance Search tab'
WebUI.selectOptionByLabel(findTestObject('Page_nGage_Dashboard/Repository/select_Search For Drop Down'), 'Required field date string search class', false)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

'Enter data in required field'
String value = 'test'
WebUI.setText(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/inpur_BM_String_Required'), value)

'Enter date in required field'
String dateFrom = '10-01-2017'
String dateTo = '11-30-2018'
WebUI.setText(findTestObject('Page_nGage_Dashboard/Repository/input_BM_DateFrom_Required'), dateFrom)
WebUI.setText(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/input_BM_DateTo_Required'), dateTo)

'Click on Search button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Repository/input_btnSearch'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

'Wait for Result Table'
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/Repository/table_SearchResults'), GlobalVariable.G_LongTimeout)

'Verify records are between the filter dates'
int columnNoDate = CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Page_nGage_Dashboard/Repository/table_Header_SearchResults'), 'Date Required')
CustomKeywords.'actions.Table.verifyRecordsWithinDateRange'(findTestObject('Page_nGage_Dashboard/Repository/table_SearchResults'), columnNoDate, dateFrom, dateTo)

'Verify values for BM String required fielf for all visible rows'
int columnNoString = CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Page_nGage_Dashboard/Repository/table_Header_SearchResults'), 'BM String required')
CustomKeywords.'actions.Table.verifyAllValuesInColumnMatches'(findTestObject('Page_nGage_Dashboard/Repository/table_SearchResults'), columnNoString, value)