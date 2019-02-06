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

'Create two document in DateTimeRequired activity'
CustomKeywords.'actions.Common.createDocument_MyWorkDateTime'(DC_DATETIMEREQUIRED, DT_DATETIMEREQUIRED, P1_MW084_STARTDATE, P1_MW084_ENDDATE, P1_MW084_STARTDATETIME, P1_MW084_ENDDATETIME, 'Test')
CustomKeywords.'actions.Common.createDocument_MyWorkDateTime'(DC_DATETIMEREQUIRED, DT_DATETIMEREQUIRED, P1_MW097_STARTDATE, P1_MW097_ENDDATE, P1_MW097_STARTDATETIME, P1_MW097_ENDDATETIME, 'Test')

'Click on My Work link from left menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_iframe_105'))

String treeDate = convert(P1_MW084_STARTDATETIME, FORMAT_DATETIME, FORMAT_DATE_TREE)
String filterDate1 = convert(P1_MW084_STARTDATETIME, FORMAT_DATETIME, FORMAT_DATE)
String filterDate2 = convert(P1_MW097_STARTDATETIME, FORMAT_DATETIME, FORMAT_DATE)

'Expand Processes by Click on the Expand Icon and Verify Foldered data displayed (For Document 1)'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('My_Work','Processes','Datetimerequired','Datetimerequired', treeDate)
//TODO: Issue pending from Dev for Date format in tree MY_WORK
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Verify the foldered date group should be displayed with only Date (not with time) '
CustomKeywords.'actions.MenuBar.verifyAllActivityNamesAreValidDate'('My_Work', FORMAT_DATE_TREE,'Processes','Datetimerequired','Datetimerequired')
//TODO: Issue pending from Dev for Date format in tree MY_WORK

'Click On Search Bar'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/h3_Search Bar'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Verify date autopopulated should show in the search panel'
WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/process_DateTimeRequired/input_StartDateTimeRequired'), 'value', filterDate1, GlobalVariable.G_LongTimeout)

'Select Date Operator (Not Null)from Dropdown Menu for EndDate time filter'
WebUI.selectOptionByLabel(findTestObject('Page_nGage_Dashboard/My_Work/process_DateTimeRequired/select_EndDateTime_operater'), 'Not Null', false)

'Click On Search Button'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/btn_Search'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Sort records in result grid by Doc ID'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'Doc ID')
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'Doc ID')

'Verify Search Result displays data as per filter'
int colNo_StartTestDateTime= CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'),'Start test datetime')
CustomKeywords.'actions.Table.verifyDateFilter'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'), colNo_StartTestDateTime, filterDate1, '', '=')

int colNo_EndTestDateTime= CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'),'End test datetime')
CustomKeywords.'actions.Table.verifyDateFilter'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'), colNo_EndTestDateTime, filterDate2, '', 'Not Null')