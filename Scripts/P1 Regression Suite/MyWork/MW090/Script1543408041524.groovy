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
import utils.Consts
import utils.DateUtil

'Login Into Application'
CustomKeywords.'actions.Common.login'()

'Create two document in DateTimeRequired activity'
Consts.P1_MW084_BMTEXT = 'Automation-'+DateUtil.getCurrentDateTimeMinusDays(0, "MM/dd/yyyy HH:mm:ss a")
CustomKeywords.'actions.Common.createDocument_MyWorkDateTime'(Consts.DC_DATETIMEREQUIRED, Consts.DT_DATETIMEREQUIRED, Consts.P1_MW084_STARTDATE, Consts.P1_MW084_ENDDATE, Consts.P1_MW084_STARTDATETIME, Consts.P1_MW084_ENDDATETIME, Consts.P1_MW084_BMTEXT)

Consts.P1_MW087_BMTEXT = 'Automation-'+DateUtil.getCurrentDateTimeMinusDays(0, "MM/dd/yyyy HH:mm:ss a")
CustomKeywords.'actions.Common.createDocument_MyWorkDateTime'(Consts.DC_DATETIMEREQUIRED, Consts.DT_DATETIMEREQUIRED, Consts.P1_MW087_STARTDATE, Consts.P1_MW087_ENDDATE, Consts.P1_MW087_STARTDATETIME, Consts.P1_MW087_ENDDATETIME, Consts.P1_MW087_BMTEXT)

'Click on My Work link from left menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Expand Processes by Click on the Expand Icon and Verify Foldered data displayed (For Document 1)'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('My_Work','Processes','Datetimerequired','Datetimerequired', DateUtil.formatDate_Slash(Consts.P1_MW087_STARTDATETIME))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Verify the foldered date group should be displayed with only Date (not with time) '
CustomKeywords.'actions.MenuBar.verifyAllActivityNamesAreValidDate'('My_Work','MM/dd/yyyy','Processes','Datetimerequired','Datetimerequired')

'Click On Search Bar'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/h3_Search Bar'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Verify date autopopulated should show in the search panel'
WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/process_DateTimeRequired/input_StartDateTimeRequired'), 'value', DateUtil.formatDate_Hyphen(Consts.P1_MW087_STARTDATETIME), GlobalVariable.G_LongTimeout)

'Select Date Operator (<>)from Dropdown Menu'
WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/process_DateTimeRequired/select_StartDateTime_operater'), '<>', false)

'Enter Date for Document 1'
CustomKeywords.'actions.Common.setText_Date'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/process_DateTimeRequired/input_StartDateTimeRequired'), DateUtil.formatDate_Hyphen(Consts.P1_MW087_STARTDATETIME))

'Click On Search Button'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/btn_Search'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Sort records in result grid by DocCreate Date'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/tableHeader_DocCreateDate'))
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/tableHeader_DocCreateDate'))

'Verify Search Result displays data as per filter'
int colNo_StartTestDateTime= CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'),'Start test datetime')
CustomKeywords.'actions.Table.verifyDateFilter'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'), colNo_StartTestDateTime, DateUtil.formatDate_Hyphen(Consts.P1_MW087_STARTDATETIME), '<>')

//'Login Into Application'
//CustomKeywords.'actions.Common.login'()
//
//'Click on My Work link from left menu'
//WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
//WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
//
//'Create a new Document in DateTimeRequired activity'
//CustomKeywords.'actions.Common.createDocument_MyWorkDateTime'('Datetimerequired','Datetimerequired','01012018','01012025','01012018 05:08:14 PM','08-30-2002 09:29:45 AM','Test')
//
//'Expand Processes by Click on the Expand Icon and Verify Foldered data displayed'
//CustomKeywords.'actions.MenuBar.clickTreeMenu'('My_Work','Processes','Datetimerequired','Datetimerequired','01/01/2018')
//CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))
//
//'Click On Search Bar'
//WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/h3_Search Bar'))
//CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))
//
//'Verify the foldered date group should be displayed with only Date (not with time) '
//CustomKeywords.'actions.MenuBar.verifyAllActivityNamesAreValidDate'('My_Work','MM/DD/YYYY','Processes','Datetimerequired','Datetimerequired')
//
//'Verify date autopopulated should show in the search panel'
//String actualText = WebUI.getAttribute(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/process_DateTimeRequired/input_StartDateTimeRequired'),'value')
//println actualText
//WebUI.verifyMatch(actualText, '01-01-2018', false)
//
//'Verify searched data (selected date in activity)should be displayed in the search result'
//WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/tableHeader_DocCreateDate'))
//CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))
//WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/tableHeader_DocCreateDate'))
//CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))
//int columnPosition_StartTestDateTime= CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'),'Start test datetime')
//println columnPosition_StartTestDateTime
//String actualTextOfFirstRow= CustomKeywords.'actions.Table.getCellText'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'), 1, columnPosition_StartTestDateTime)
//println trimActualText= actualTextOfFirstRow.split('[ ]')[0].trim()
//WebUI.verifyMatch(trimActualText, '1/1/2018', false)
//
//'Select Date Operator (<>)from Dropdown Menu'
//WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/process_DateTimeRequired/select_StartDateTime_operater'), '<>', false)
//
//'Enter Date'
//CustomKeywords.'actions.Common.setText_Date'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/process_DateTimeRequired/input_StartDateTimeRequired'),'01-01-2018')
//
//'Click On Search Button'
//WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/btn_Search'))
//CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))
//
//'Verify Search Result'
//CustomKeywords.'actions.Table.verifyDateFilter'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'),columnPosition_StartTestDateTime, '01/01/2018','<>')