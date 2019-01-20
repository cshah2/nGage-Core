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
CustomKeywords.'actions.Common.createDocument_MyWorkDateTime'(Consts.DC_DATEREQUIRED, Consts.DT_DATEREQUIRED, Consts.P1_MW084_STARTDATE, Consts.P1_MW084_ENDDATE, Consts.P1_MW084_STARTDATETIME, Consts.P1_MW084_ENDDATETIME, Consts.P1_MW084_BMTEXT)

Consts.P1_MW117_BMTEXT = 'Automation-'+DateUtil.getCurrentDateTimeMinusDays(0, "MM/dd/yyyy HH:mm:ss a")
CustomKeywords.'actions.Common.createDocument_MyWorkDateTime'(Consts.DC_DATEREQUIRED, Consts.DT_DATEREQUIRED, Consts.P1_MW117_STARTDATE, Consts.P1_MW117_ENDDATE, Consts.P1_MW117_STARTDATETIME, Consts.P1_MW117_ENDDATETIME, Consts.P1_MW117_BMTEXT)

'Click on My Work link from left menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Expand Processes by Click on the Expand Icon and Verify Foldered data displayed (For Document 1)'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('My_Work','Processes','Date Required','Daterequiredsearch', DateUtil.formatDate_Slash(Consts.P1_MW084_STARTDATE))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Verify the foldered date group should be displayed with only Date (not with time) '
CustomKeywords.'actions.MenuBar.verifyAllActivityNamesAreValidDate'('My_Work','MM/dd/yyyy','Processes','Date Required','Daterequiredsearch')

'Click On Search Bar'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/h3_Search Bar'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Verify date autopopulated should show in the search panel'
String actualText = WebUI.getAttribute(findTestObject('Page_nGage_Dashboard/My_Work/Process_Date Required/input_StartDate'),'value')
WebUI.verifyMatch(actualText, DateUtil.formatDate_Hyphen(Consts.P1_MW084_STARTDATE), false)

'Select Date Operator (Not Null)from Dropdown Menu for EndDate filter'
WebUI.selectOptionByLabel(findTestObject('Page_nGage_Dashboard/My_Work/Process_Date Required/select_EndDate_operator'), 'Not Null', false)

'Click On Search Button'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/btn_Search'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Sort records in result grid by DocID Desc'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/My_Work/tableHeader_DocID'))
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/My_Work/tableHeader_DocID'))

'Verify Search Result displays data as per filter'
int colNo_StartTestDate= CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'),'Start test date')
CustomKeywords.'actions.Table.verifyDateFilter'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'), colNo_StartTestDate, DateUtil.formatDate_Hyphen(Consts.P1_MW084_STARTDATE), '=')

int colNo_EndTestDate= CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'),'Endtestdate')
CustomKeywords.'actions.Table.verifyDateFilter'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'), colNo_EndTestDate, DateUtil.formatDate_Hyphen(Consts.P1_MW117_STARTDATE), 'Not Null')

//'Login Into Application'
//CustomKeywords.'actions.Common.login'()
//
//'Click on My Work link from left menu'
//WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
//WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
//
//'Create a new Document in Date Required activity'
//CustomKeywords.'actions.Common.createDocument_MyWorkDateTime'('daterequiredsearch','daterequiredsearch','01012018','01012025','01012018 05:08:14 PM','08-30-2002 09:29:45 AM','Test')
//
//'Expand Processes and Verify Date Required activity Displayed'
//CustomKeywords.'actions.MenuBar.clickTreeMenu'('My_Work','Processes','Date Required','Daterequiredsearch','01/01/2018')
//CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))
//
//'Click On Search Bar'
//WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/h3_Search Bar'))
//CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))
//
//'Verify the foldered date group should be displayed with only Date (not with time)'
//CustomKeywords.'actions.MenuBar.verifyAllActivityNamesAreValidDate'('My_Work','MM/DD/YYYY','Processes','Date Required','Daterequiredsearch')
//
//'Verify date autopopulated should show in the search panel'
//String actualText = WebUI.getAttribute(findTestObject('Page_nGage_Dashboard/My_Work/Process_Date Required/input_StartDate'),'value')
//println actualText
//WebUI.verifyMatch(actualText, '01-01-2018', false)
//
//'Verify searched data (selected date in activity)should be displayed in the search result'
//WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/tableHeader_DocCreateDate'))
//CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))
//WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/tableHeader_DocCreateDate'))
//CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))
//int columnPosition_StartTestDate= CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'),'Start test date')
//println columnPosition_StartTestDate
//String actualTextOfStartTextDateColumn= CustomKeywords.'actions.Table.getCellText'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'), 1, columnPosition_StartTestDate)
//println actualTextOfStartTextDateColumn
//WebUI.verifyMatch(actualTextOfStartTextDateColumn, '1/1/2018', false)
//
//'Select Date Operator (Not Null)from Dropdown Menu'
//WebUI.selectOptionByLabel(findTestObject('Page_nGage_Dashboard/My_Work/Process_Date Required/select_StartDate_operator'), 'Not Null', false)
//
//'Enter Date'
//CustomKeywords.'actions.Common.setText_Date'(findTestObject('Page_nGage_Dashboard/My_Work/Process_Date Required/input_StartDate'),'01-01-2018')
//
//'Click On Search Button'
//WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/btn_Search'))
//CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))
//
//'Verify Search Result'
//CustomKeywords.'actions.Table.verifyDateFilter'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'),columnPosition_StartTestDate, '01/01/2018','not null')