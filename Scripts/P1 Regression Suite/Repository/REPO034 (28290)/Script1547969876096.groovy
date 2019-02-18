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
import static utils.Consts.*

'Login into application'
CustomKeywords.'actions.Common.login'()

'Create Document Required field DT'
CustomKeywords.'actions.Common.createDocument_RequiredFieldDT'(P1_REPO_BMTEXT_DOC1, P1_REPO_BMSTRING_DOC1, P1_REPO_INT_DOC1, P1_REPO_DATETIMEREQ_DOC1, P1_REPO_DATEREQ_DOC1)

'Expand Repository Menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/Repository/h3_Repository Menu'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Select Repository - Advance Search tab'
WebUI.selectOptionByLabel(findTestObject('Page_nGage_Dashboard/Repository/select_Repository Drop Down'), 'Required Date string field EDM', false)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Selinput_btnSearchect Search For - Advance Search tab'
WebUI.selectOptionByLabel(findTestObject('Page_nGage_Dashboard/Repository/select_Search For Drop Down'), 'Required field date string search class', false)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Enter data in required field'
String filterStringRequiered = P1_REPO_BMSTRING_DOC1 
WebUI.setText(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/inpur_BM_String_Required'), filterStringRequiered)

'Enter date in required field'
String dateFrom = P1_REPO_DATEREQ_DOC1
String dateTo = P1_REPO_DATEREQ_DOC1
CustomKeywords.'actions.Common.setText_Date'(findTestObject('Page_nGage_Dashboard/Repository/input_BM_DateFrom_Required'), dateFrom)
CustomKeywords.'actions.Common.setText_Date'(findTestObject('Page_nGage_Dashboard/Repository/input_BM_DateTo_Required'), dateTo)


'Click on Search button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Repository/input_btnSearch'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

'Wait for Result Table'
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/Repository/table_SearchResults'), GlobalVariable.G_LongTimeout)

'Sort record by DocID desc'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Repository/table_Header_SearchResults'), 'Doc ID')
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Repository/table_Header_SearchResults'), 'Doc ID')

'Verify records are between the filter dates'
int columnNoDate = CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Page_nGage_Dashboard/Repository/table_Header_SearchResults'), 'Date Required')
CustomKeywords.'actions.Table.verifyDateFilter'(findTestObject('Page_nGage_Dashboard/Repository/table_SearchResults'), columnNoDate, dateFrom, dateTo, 'between')

'Verify values for BM String required fielf for all visible rows'
int columnNoString = CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Page_nGage_Dashboard/Repository/table_Header_SearchResults'), 'BM String required')
CustomKeywords.'actions.Table.verifyCellContainsValue'(findTestObject('Page_nGage_Dashboard/Repository/table_SearchResults'), 1, columnNoString, filterStringRequiered)