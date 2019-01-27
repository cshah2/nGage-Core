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

'Create a new Document in DateTimeRequired activity'
String BM_Text = 'Automation-'+getCurrentDateTimeMinusDays(0, FORMAT_DATETIME)
CustomKeywords.'actions.Common.createDocument_MyWorkDateTime'(DC_DATETIMEREQUIRED, DT_DATETIMEREQUIRED, P1_MW084_STARTDATE, P1_MW084_ENDDATE, P1_MW084_STARTDATETIME, P1_MW084_ENDDATETIME, BM_Text)

'Click on My Work link from left menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

String treeDate = convert(P1_MW084_STARTDATETIME, FORMAT_DATETIME, FORMAT_DATE_TREE)
String filterDate = convert(P1_MW084_STARTDATETIME, FORMAT_DATETIME, FORMAT_DATE)

'Expand Processes by Click on the Expand Icon and Verify Foldered data displayed'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('My_Work','Processes','Datetimerequired','Datetimerequired', treeDate)
//TODO: Issue pending from Dev for Date format in tree MY_WORK

CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Verify the foldered date group should be displayed with only Date (not with time) '
CustomKeywords.'actions.MenuBar.verifyAllActivityNamesAreValidDate'('My_Work',FORMAT_DATE_TREE,'Processes','Datetimerequired','Datetimerequired')

'Click On Search Bar to open'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/h3_Search Bar'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Verify date autopopulated should show in the search panel'
String actualText = WebUI.getAttribute(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/process_DateTimeRequired/input_StartDateTimeRequired'),'value')
WebUI.verifyMatch(actualText, filterDate, false)

'Sort records in result grid by DocCreate Date'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/tableHeader_DocCreateDate'))
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/tableHeader_DocCreateDate'))

'Verify searched data (selected date in activity)should be displayed in the search result with Time'
int colNo_StartTestDateTime= CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'),'Start test datetime')
CustomKeywords.'actions.Table.verifyCellContainsValue'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'), 1, colNo_StartTestDateTime, P1_MW084_STARTDATETIME)

int colNo_BMText= CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'),'BM Text')
CustomKeywords.'actions.Table.verifyCellContainsValue'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'), 1, colNo_BMText, BM_Text)