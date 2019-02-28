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
import utils.DateUtil

'Login Into Application'
CustomKeywords.'actions.Common.login'()

'Create document'
if(!FLAG_P1_MW_DOCQ) {
	CustomKeywords.'actions.Common.createDocument_MyWorkDateTime'(DC_DATETIMERANGEREQUIRED, DT_DATETIMERANGEREQUIRED, P1_MW_DOCQ_STARTDATE, P1_MW_DOCQ_ENDDATE, P1_MW_DOCQ_STARTDATETIME, P1_MW_DOCQ_ENDDATETIME, "")
	FLAG_P1_MW_DOCQ = true
}

'Click on My Work link from left menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_iframe_105'))

'Click Tree Menu'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('MY_WORK', 'Processes', 'Datetime range required', 'Date time range required')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))

'verify activity count with grid count'
int recordCount = CustomKeywords.'actions.MenuBar.getRecordCountInActivity'('MY_WORK', 'Processes', 'Datetime range required', 'Date time range required')
CustomKeywords.'actions.Common.verifyTotalRecordCountFromPageSummary'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/div_PageCount'), recordCount)

'Expand Search Bar'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/h3_Search Bar'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Enter date value using calender picker'
CustomKeywords.'actions.Calender.selectDate'(P1_MW_DOCQ_STARTDATE_DATE, P1_MW_DOCQ_STARTDATE_MONTH, P1_MW_DOCQ_STARTDATE_YEAR, findTestObject('Page_nGage_Dashboard/My_Work/process_DatetimeRangeRequired/calender_StartTestDate'))

'Verify date value'
WebUI.verifyElementAttributeValue(findTestObject('Page_nGage_Dashboard/My_Work/process_DatetimeRangeRequired/input_StartTestDate'), 'value', P1_MW_DOCQ_STARTDATE, GlobalVariable.G_LongTimeout)

'Enter date time value in calender picker'
CustomKeywords.'actions.Calender.selectDateTime'(P1_MW_DOCQ_STARTDATETIME_DATE, P1_MW_DOCQ_STARTDATETIME_MONTH, P1_MW_DOCQ_STARTDATETIME_YEAR, findTestObject('Page_nGage_Dashboard/My_Work/process_DatetimeRangeRequired/calender_StartTestDateTime_From'))

'Verify date value'
String datetime = WebUI.getAttribute(findTestObject('Page_nGage_Dashboard/My_Work/process_DatetimeRangeRequired/input_StartTestDateTime_From'), 'value').toUpperCase()
String startDateTime = convert(P1_MW_DOCQ_STARTDATETIME, FORMAT_DATETIME, FORMAT_DATE)+' '+P1_TIME_START
String endDateTime = convert(P1_MW_DOCQ_STARTDATETIME, FORMAT_DATETIME, FORMAT_DATE)+' '+P1_TIME_END
WebUI.verifyMatch(datetime, startDateTime, false)

'Enter date time value in start date time to field'
CustomKeywords.'actions.Common.setText_Date'(findTestObject('Page_nGage_Dashboard/My_Work/process_DatetimeRangeRequired/input_StartTestDateTime_To'), endDateTime)

'Click On Search Button'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/btn_Search'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Sort records in result grid by Doc ID'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'Doc ID')
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'Doc ID')

'Verify correct records are displayed'
int colNo_StartTestDate= CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'),'Start test date')
CustomKeywords.'actions.Table.verifyDateFilter'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'), colNo_StartTestDate, P1_MW_DOCQ_STARTDATE, '', '=') 

int colNo_StartTestDateTime= CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'),'Start test datetime')
CustomKeywords.'actions.Table.verifyDateTimeFilter'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'), colNo_StartTestDateTime, startDateTime, endDateTime, 'between')