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

String tree_BM_Date = BM_Date.substring(0, 10).replaceAll('-', '/').trim()
String tree_DateRange = DateRange.substring(0, 10).replaceAll('-', '/').trim()
String tree_BM_DateTime = BM_DateTime.substring(0, 10).replaceAll('-', '/').trim()
String tree_DateTimeRange = DateTimeRange.substring(0, 10).replaceAll('-', '/').trim()

CustomKeywords.'actions.MenuBar.verifyAllActivityNamesAreValidDate'('REPO', 'MM/dd/yyyy', 'Date n Date time EDM','Date n Date time search class')
CustomKeywords.'actions.MenuBar.verifyAllActivityNamesAreValidDate'('REPO', 'MM/dd/yyyy', 'Date n Date time EDM','Date n Date time search class', tree_BM_Date)
CustomKeywords.'actions.MenuBar.verifyAllActivityNamesAreValidDate'('REPO', 'MM/dd/yyyy', 'Date n Date time EDM','Date n Date time search class', tree_BM_Date, tree_DateRange)
CustomKeywords.'actions.MenuBar.verifyAllActivityNamesAreValidDate'('REPO', 'MM/dd/yyyy', 'Date n Date time EDM','Date n Date time search class', tree_BM_Date, tree_DateRange, tree_BM_DateTime)

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
CustomKeywords.'actions.Common.setText_Date'(findTestObject('Page_nGage_Dashboard/Repository/input_BM_Date'), BM_Date)

'Click on Search button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Repository/input_btnSearch'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

'Verify all records are within filter date range'
int colNo = CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Page_nGage_Dashboard/Repository/table_Header_SearchResults'), 'BM Date')
CustomKeywords.'actions.Table.verifyDateFilter'(findTestObject('Page_nGage_Dashboard/Repository/table_SearchResults'), colNo, BM_Date, '=')