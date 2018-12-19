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

Consts.P1_MW097_BMTEXT = 'Automation-'+DateUtil.getCurrentDateTimeMinusDays(0, "MM/dd/yyyy HH:mm:ss a")
CustomKeywords.'actions.Common.createDocument_MyWorkDateTime'(Consts.DC_DATETIMEREQUIRED, Consts.DT_DATETIMEREQUIRED, Consts.P1_MW097_STARTDATE, Consts.P1_MW097_ENDDATE, Consts.P1_MW097_STARTDATETIME, Consts.P1_MW097_ENDDATETIME, Consts.P1_MW097_BMTEXT)

'Click on My Work link from left menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Expand Processes by Click on the Expand Icon and Verify Foldered data displayed (For Document 1)'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('My_Work','Processes','Datetimerequired','Datetimerequired', DateUtil.formatDate_Slash(Consts.P1_MW084_STARTDATETIME))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Verify the foldered date group should be displayed with only Date (not with time) '
CustomKeywords.'actions.MenuBar.verifyAllActivityNamesAreValidDate'('My_Work','MM/dd/yyyy','Processes','Datetimerequired','Datetimerequired')

'Click On Search Bar'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/h3_Search Bar'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Verify date autopopulated should show in the search panel'
WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/process_DateTimeRequired/input_StartDateTimeRequired'), 'value', DateUtil.formatDate_Hyphen(Consts.P1_MW084_STARTDATETIME), GlobalVariable.G_LongTimeout)

'Select Date Operator (Not Null)from Dropdown Menu for EndDate time filter'
WebUI.selectOptionByLabel(findTestObject('Page_nGage_Dashboard/My_Work/process_DateTimeRequired/select_EndDateTime_operater'), 'Not Null', false)

'Click On Search Button'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/btn_Search'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Sort records in result grid by DocCreate Date'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/tableHeader_DocCreateDate'))
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/tableHeader_DocCreateDate'))

'Verify Search Result displays data as per filter'
int colNo_StartTestDateTime= CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'),'Start test datetime')
CustomKeywords.'actions.Table.verifyDateFilter'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'), colNo_StartTestDateTime, DateUtil.formatDate_Hyphen(Consts.P1_MW084_STARTDATETIME), '=')

int colNo_EndTestDateTime= CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'),'End test datetime')
CustomKeywords.'actions.Table.verifyDateFilter'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'), colNo_EndTestDateTime, DateUtil.formatDate_Hyphen(Consts.P1_MW084_STARTDATETIME), 'Not Null')