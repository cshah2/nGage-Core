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
import static utils.DateUtil.*

'Login Into Application'
CustomKeywords.'actions.Common.login'()

'Create documents for filter'
CustomKeywords.'actions.Common.createDateRangeFilterDataMyWork'()

'Click on My Work link from left menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_iframe_105'))

String startDate = convert(P1_MW_DOCG_STARTDATE, FORMAT_DATE, FORMAT_DATE_TREE)
String endDate = convert(P1_MW_DOCI_STARTDATE, FORMAT_DATE, FORMAT_DATE_TREE)

'Expand Processes and Verify Date Required activity Displayed'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('My_Work','Processes','DateRange required','Date range required')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Click On Search Bar'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/h3_Search Bar'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))

CustomKeywords.'actions.Common.setText_Date'(findTestObject('Page_nGage_Dashboard/My_Work/Process_DateRangeRequired/input_StartDate_From'), startDate)
CustomKeywords.'actions.Common.setText_Date'(findTestObject('Page_nGage_Dashboard/My_Work/Process_DateRangeRequired/input_StartDate_To'), endDate)

'Click On Search Button'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/btn_Search'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Verify result grid contains atleast 1 record'
int rowCount = CustomKeywords.'actions.Table.getRowsCount'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'))
WebUI.verifyGreaterThan(rowCount, 0)

int columnPosition_StartTestDate= CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'),'Start test date')
println columnPosition_StartTestDate

'verify search result'
CustomKeywords.'actions.Table.verifyDateFilter'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'), columnPosition_StartTestDate, P1_MW_DOCG_STARTDATE, P1_MW_DOCI_STARTDATE, 'between')

CustomKeywords.'actions.Table.verifyRecordNotPresentInColumn'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'), columnPosition_StartTestDate, P1_MW_DOCF_STARTDATE)
CustomKeywords.'actions.Table.verifyRecordPresentInColumn'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'), columnPosition_StartTestDate, P1_MW_DOCG_STARTDATE)
CustomKeywords.'actions.Table.verifyRecordPresentInColumn'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'), columnPosition_StartTestDate, P1_MW_DOCH_STARTDATE)
CustomKeywords.'actions.Table.verifyRecordPresentInColumn'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'), columnPosition_StartTestDate, P1_MW_DOCI_STARTDATE)
CustomKeywords.'actions.Table.verifyRecordNotPresentInColumn'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'), columnPosition_StartTestDate, P1_MW_DOCJ_STARTDATE)