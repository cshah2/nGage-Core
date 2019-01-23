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
import utils.DateUtil

'Login into application'
CustomKeywords.'actions.Common.login'()

//Pre-requisite : Add new document of Doc Class : Date n time
String BM_Date = DateUtil.getCurrentDateTimeMinusDays(0, "MM-dd-yyyy") //Level1
String DateRange = DateUtil.getCurrentDateTimeMinusDays(1, "MM-dd-yyyy") // Level2
String BM_DateTime = DateUtil.getCurrentDateTimeMinusDays(2, "MM-dd-yyyy HH:mm:ss a") //Level 3
String DateTimeRange = DateUtil.getCurrentDateTimeMinusDays(3, "MM-dd-yyyy HH:mm:ss a") //Level 4

'Create new Document'
CustomKeywords.'actions.Common.createDocument_DateTimeDT'(BM_Date, DateRange, BM_DateTime, DateTimeRange)

'Click on Repository Menu'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/h3_Repository Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

String tree_BM_Date = BM_Date.substring(0, 10).replaceAll('-', '/').trim().toUpperCase()
String tree_DateRange = DateRange.substring(0, 10).replaceAll('-', '/').trim().toUpperCase()
String tree_BM_DateTime = BM_DateTime.substring(0, 10).replaceAll('-', '/').trim().toUpperCase()
String tree_DateTimeRange = DateTimeRange.substring(0, 10).replaceAll('-', '/').trim().toUpperCase()

CustomKeywords.'actions.MenuBar.clickTreeMenu'('REPO', 'Date n Date time EDM','Date n Date time search class', tree_BM_Date, tree_DateRange, tree_BM_DateTime, tree_DateTimeRange)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/BrowseResults Tab/iframe_BROWSETAB_iframe'))

int count = CustomKeywords.'actions.MenuBar.getRecordCountInActivity'('REPO', 'Date n Date time EDM','Date n Date time search class', tree_BM_Date, tree_DateRange, tree_BM_DateTime, tree_DateTimeRange)
CustomKeywords.'actions.Common.verifyTotalRecordCountFromPageSummary'(findTestObject('Page_nGage_Dashboard/Repository/BrowseResults Tab/Table_PageResults'), count)

'Get Column numbers of all 4 date columns'
int colNo_BM_Date = CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Page_nGage_Dashboard/Repository/BrowseResults Tab/table_Header_SearchResults'), 'BM Date')
int colNo_DateRange = CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Page_nGage_Dashboard/Repository/BrowseResults Tab/table_Header_SearchResults'), 'Date range')
int colNo_BM_DateTime = CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Page_nGage_Dashboard/Repository/BrowseResults Tab/table_Header_SearchResults'), 'BM DateTime') 
int colNo_DateTimeRange = CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Page_nGage_Dashboard/Repository/BrowseResults Tab/table_Header_SearchResults'), 'Date time range')

'Sort records by DocID descending'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Repository/BrowseResults Tab/columnHeader_DocID'))
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Repository/BrowseResults Tab/columnHeader_DocID'))

'Verify date values in table'
String act_BM_Date = CustomKeywords.'actions.Table.getCellText'(findTestObject('Page_nGage_Dashboard/Repository/BrowseResults Tab/table_SearchResults'), 1, colNo_BM_Date)
String act_DateRange = CustomKeywords.'actions.Table.getCellText'(findTestObject('Page_nGage_Dashboard/Repository/BrowseResults Tab/table_SearchResults'), 1, colNo_DateRange)
String act_BM_DateTime = CustomKeywords.'actions.Table.getCellText'(findTestObject('Page_nGage_Dashboard/Repository/BrowseResults Tab/table_SearchResults'), 1, colNo_BM_DateTime)
String act_DateTimeRange = CustomKeywords.'actions.Table.getCellText'(findTestObject('Page_nGage_Dashboard/Repository/BrowseResults Tab/table_SearchResults'), 1, colNo_DateTimeRange)

WebUI.verifyMatch(act_BM_Date.replaceAll('/', '-').toUpperCase(), BM_Date, false)
WebUI.verifyMatch(act_DateRange.replaceAll('/', '-').toUpperCase(), DateRange, false)
WebUI.verifyMatch(act_BM_DateTime.replaceAll('/', '-').toUpperCase(), BM_DateTime, false)
WebUI.verifyMatch(act_DateTimeRange.replaceAll('/', '-').toUpperCase(), DateTimeRange, false)