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

'Create all date filter data if not present'
CustomKeywords.'actions.Common.createDateFilterDataRepository'()

'Click on Repository Menu'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/h3_Repository Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

String tree_BM_Date = P1_REPO_DOCA_BMDATE
String tree_DateRange = P1_REPO_DOCA_DATERANGE
String tree_BM_DateTime = convert(P1_REPO_DOCA_BMDATETIME, FORMAT_DATETIME, FORMAT_DATE) 
String tree_DateTimeRange = convert(P1_REPO_DOCA_DATETIMERANGE, FORMAT_DATETIME, FORMAT_DATE)

CustomKeywords.'actions.MenuBar.verifyAllActivityNamesAreValidDate'('REPO', FORMAT_DATE, 'Date n Date time EDM','Date n Date time search class')
CustomKeywords.'actions.MenuBar.verifyAllActivityNamesAreValidDate'('REPO', FORMAT_DATE, 'Date n Date time EDM','Date n Date time search class', tree_BM_Date)

CustomKeywords.'actions.MenuBar.clickTreeMenu'('REPO', 'Date n Date time EDM','Date n Date time search class', tree_BM_Date)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/BrowseResults Tab/iframe_BROWSETAB_iframe'))

int count = CustomKeywords.'actions.MenuBar.getRecordCountInActivity'('REPO', 'Date n Date time EDM','Date n Date time search class', tree_BM_Date)
CustomKeywords.'actions.Common.verifyTotalRecordCountFromPageSummary'(findTestObject('Page_nGage_Dashboard/Repository/BrowseResults Tab/Table_PageResults'), count)