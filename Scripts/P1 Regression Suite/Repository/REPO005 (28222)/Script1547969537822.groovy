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
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

String tree_BM_Date = BM_Date.substring(0, 10).replaceAll('-', '/').trim()
String tree_DateRange = DateRange.substring(0, 10).replaceAll('-', '/').trim()
String tree_BM_DateTime = BM_DateTime.substring(0, 10).replaceAll('-', '/').trim() 
String tree_DateTimeRange = DateTimeRange.substring(0, 10).replaceAll('-', '/').trim()

'Verify correct tree path is loaded at each level'
CustomKeywords.'actions.MenuBar.verifySubMenuPresent'('REPO', tree_BM_Date, 'Date n Date time EDM','Date n Date time search class')
CustomKeywords.'actions.MenuBar.verifySubMenuPresent'('REPO', tree_DateRange, 'Date n Date time EDM','Date n Date time search class', tree_BM_Date)
CustomKeywords.'actions.MenuBar.verifySubMenuPresent'('REPO', tree_BM_DateTime, 'Date n Date time EDM','Date n Date time search class', tree_BM_Date, tree_DateRange)
CustomKeywords.'actions.MenuBar.verifySubMenuPresent'('REPO', tree_DateTimeRange, 'Date n Date time EDM','Date n Date time search class', tree_BM_Date, tree_DateRange, tree_BM_DateTime)

'Click on Last Tree node'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('REPO', 'Date n Date time EDM','Date n Date time search class', tree_BM_Date, tree_DateRange, tree_BM_DateTime)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/BrowseResults Tab/iframe_BROWSETAB_iframe'))

int recordCountInActivity = CustomKeywords.'actions.MenuBar.getRecordCountInActivity'('REPO', 'Date n Date time EDM','Date n Date time search class', tree_BM_Date, tree_DateRange, tree_BM_DateTime)
CustomKeywords.'actions.Common.verifyTotalRecordCountFromPageSummary'(findTestObject('Page_nGage_Dashboard/Repository/BrowseResults Tab/Table_PageResults'), recordCountInActivity)