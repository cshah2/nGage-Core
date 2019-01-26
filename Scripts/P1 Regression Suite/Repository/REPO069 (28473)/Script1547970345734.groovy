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
import static utils.DateUtil.*
import static utils.Consts.*

'Login into application'
CustomKeywords.'actions.Common.login'()

//Pre-requisite : Add new document of Doc Class : Date n time
String BM_Date = getCurrentDateTimeMinusDays(0, FORMAT_DATE) //Level1
String DateRange = getCurrentDateTimeMinusDays(1, FORMAT_DATE) // Level2
String BM_DateTime = getCurrentDateTimeMinusDays(2, FORMAT_DATETIME) //Level 3
String DateTimeRange = getCurrentDateTimeMinusDays(3, FORMAT_DATETIME) //Level 4

'Create new Document'
CustomKeywords.'actions.Common.createDocument_DateTimeDT'(BM_Date, DateRange, BM_DateTime, DateTimeRange)

'Click on Repository Menu'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/h3_Repository Menu'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

String tree_BM_Date = BM_Date
String tree_DateRange = DateRange
String tree_BM_DateTime = convert(BM_DateTime, FORMAT_DATETIME, FORMAT_DATE) 
String tree_DateTimeRange = convert(DateTimeRange, FORMAT_DATETIME, FORMAT_DATE)

CustomKeywords.'actions.MenuBar.verifyAllActivityNamesAreValidDate'('REPO', FORMAT_DATE, 'Date n Date time EDM','Date n Date time search class')
CustomKeywords.'actions.MenuBar.verifyAllActivityNamesAreValidDate'('REPO', FORMAT_DATE, 'Date n Date time EDM','Date n Date time search class', tree_BM_Date)
CustomKeywords.'actions.MenuBar.verifyAllActivityNamesAreValidDate'('REPO', FORMAT_DATE, 'Date n Date time EDM','Date n Date time search class', tree_BM_Date, tree_DateRange)
CustomKeywords.'actions.MenuBar.verifyAllActivityNamesAreValidDate'('REPO', FORMAT_DATE, 'Date n Date time EDM','Date n Date time search class', tree_BM_Date, tree_DateRange, tree_BM_DateTime)

'Click on Advance Search Tab'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/a_Advanced Search Tab'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

'Select Repository - Advance Search tab'
WebUI.selectOptionByLabel(findTestObject('Page_nGage_Dashboard/Repository/select_Repository Drop Down'), 'Date n Date time EDM', false)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

'Select Search For - Advance Search tab'
WebUI.selectOptionByLabel(findTestObject('Page_nGage_Dashboard/Repository/select_Search For Drop Down'), 'Date n Date time search class', false)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

'Enter date range as filter criteria'
String filter_StartDate = getCurrentDateTimeMinusDays(2, FORMAT_DATE)
String filter_EndDate = getCurrentDateTimeMinusDays(0, FORMAT_DATE)
CustomKeywords.'actions.Common.setText_Date'(findTestObject('Page_nGage_Dashboard/Repository/input_DateRange_From'), filter_StartDate)
CustomKeywords.'actions.Common.setText_Date'(findTestObject('Page_nGage_Dashboard/Repository/input_DateRange_To'), filter_EndDate)

'Click on Search button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Repository/input_btnSearch'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

'Verify all records are within filter date range'
int colNo = CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Page_nGage_Dashboard/Repository/table_Header_SearchResults'), 'Date range')
CustomKeywords.'actions.Table.verifyRecordsWithinDateRange'(findTestObject('Page_nGage_Dashboard/Repository/table_SearchResults'), colNo, filter_StartDate, filter_EndDate)