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

import common.DocClass
import common.DocType
import common.Fields
import internal.GlobalVariable as GlobalVariable
import static utils.DateUtil.*
import static utils.Consts.*

'Login into application'
CustomKeywords.'actions.Common.login'()

'Create document if not present'
if(!FLAG_P1_REPO_DOC247) {
	CustomKeywords.'actions.Data.create'(DocClass.DATE_DATETIME_DC, DocType.DATE_DATETIME_DT, P1_REPO_DOC247)
	FLAG_P1_REPO_DOC247 = true
}

String BM_Date = P1_REPO_DOC247.get(Fields.DATE)					//Level 1
String DateRange = P1_REPO_DOC247.get(Fields.DATE_RANGE) 			//Level 2
String BM_DateTime = P1_REPO_DOC247.get(Fields.DATE_TIME)			//Level 3
String DateTimeRange = P1_REPO_DOC247.get(Fields.DATE_TIME_RANGE)	//Level 4

'Click on Repository Menu'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/h3_Repository Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

String tree_BM_Date = BM_Date
String tree_DateRange = DateRange
String tree_BM_DateTime = convert(BM_DateTime, FORMAT_DATETIME, FORMAT_DATE) 
String tree_DateTimeRange = convert(DateTimeRange, FORMAT_DATETIME, FORMAT_DATE)

'Click on Foldered date 1st level'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('REPO', 'Date n Date time EDM','Date n Date time search class', tree_BM_Date)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/BrowseResults Tab/iframe_BROWSETAB_iframe'))

'Verify record count in activity and grid matches'
int recordCountInFirstNode = CustomKeywords.'actions.MenuBar.getRecordCountInActivity'('REPO', 'Date n Date time EDM','Date n Date time search class', tree_BM_Date)
CustomKeywords.'actions.Common.verifyTotalRecordCountFromPageSummary'(findTestObject('Page_nGage_Dashboard/Repository/BrowseResults Tab/Table_PageResults'), recordCountInFirstNode)

'Click on Foldered date 2nd level'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('REPO', 'Date n Date time EDM','Date n Date time search class', tree_BM_Date, tree_DateRange)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/BrowseResults Tab/iframe_BROWSETAB_iframe'))

'Verify record count in activity and grid matches'
int recordCountInSecondNode = CustomKeywords.'actions.MenuBar.getRecordCountInActivity'('REPO', 'Date n Date time EDM','Date n Date time search class', tree_BM_Date, tree_DateRange)
CustomKeywords.'actions.Common.verifyTotalRecordCountFromPageSummary'(findTestObject('Page_nGage_Dashboard/Repository/BrowseResults Tab/Table_PageResults'), recordCountInSecondNode)

'Click on Foldered date 3rd level'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('REPO', 'Date n Date time EDM','Date n Date time search class', tree_BM_Date, tree_DateRange, tree_BM_DateTime)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/BrowseResults Tab/iframe_BROWSETAB_iframe'))

int recordCountInThirdNode = CustomKeywords.'actions.MenuBar.getRecordCountInActivity'('REPO', 'Date n Date time EDM','Date n Date time search class', tree_BM_Date, tree_DateRange, tree_BM_DateTime)
CustomKeywords.'actions.Common.verifyTotalRecordCountFromPageSummary'(findTestObject('Page_nGage_Dashboard/Repository/BrowseResults Tab/Table_PageResults'), recordCountInThirdNode)

'Click on Foldered date 4th level'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('REPO', 'Date n Date time EDM','Date n Date time search class', tree_BM_Date, tree_DateRange, tree_BM_DateTime, tree_DateTimeRange)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/BrowseResults Tab/iframe_BROWSETAB_iframe'))

int recordCountInFourthNode = CustomKeywords.'actions.MenuBar.getRecordCountInActivity'('REPO', 'Date n Date time EDM','Date n Date time search class', tree_BM_Date, tree_DateRange, tree_BM_DateTime, tree_DateTimeRange)
CustomKeywords.'actions.Common.verifyTotalRecordCountFromPageSummary'(findTestObject('Page_nGage_Dashboard/Repository/BrowseResults Tab/Table_PageResults'), recordCountInFourthNode)