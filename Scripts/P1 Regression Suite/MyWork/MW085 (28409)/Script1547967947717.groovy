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

'Create a new Document in DateTimeRequired activity'
Consts.P1_MW084_BMTEXT = 'Automation-'+DateUtil.getCurrentDateTimeMinusDays(0, "MM/dd/yyyy HH:mm:ss a")
CustomKeywords.'actions.Common.createDocument_MyWorkDateTime'(Consts.DC_DATETIMERANGEREQUIRED, Consts.DT_DATETIMERANGEREQUIRED, Consts.P1_MW084_STARTDATE, Consts.P1_MW084_ENDDATE, Consts.P1_MW084_STARTDATETIME, Consts.P1_MW084_ENDDATETIME, Consts.P1_MW084_BMTEXT)

'Click on My Work link from left menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Expand Processes and Verify Foldered Document Displayed'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('My_Work','Processes','Datetime range required','Date time range required', DateUtil.formatDate_Slash(Consts.P1_MW084_STARTDATETIME))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Verify foldered data should be displayed in the activity'
CustomKeywords.'actions.MenuBar.verifyAllActivityNamesAreValidDate'('My_Work','MM/dd/yyyy','Processes','Datetime range required','Date time range required')

'Click on Search bar to open'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/h3_Search Bar'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Verify auto populated values'
WebUI.verifyElementAttributeValue(findTestObject('Page_nGage_Dashboard/My_Work/process_DatetimeRangeRequired/input_StartTestDateTime_From'), 'value', DateUtil.formatDate_Hyphen(Consts.P1_MW084_STARTDATETIME)+' 12:00:00 AM', GlobalVariable.G_LongTimeout)
WebUI.verifyElementAttributeValue(findTestObject('Page_nGage_Dashboard/My_Work/process_DatetimeRangeRequired/input_StartTestDateTime_To'), 'value', DateUtil.formatDate_Hyphen(Consts.P1_MW084_STARTDATETIME)+' 11:59:59 PM', GlobalVariable.G_LongTimeout)

'Sort records in result grid by DocCreate Date'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/tableHeader_DocCreateDate'))
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/tableHeader_DocCreateDate'))

'Verify searched data (selected date in activity)should be displayed in the search result with Time as hh:mm:ss'
int colNo_StartTestDateTime= CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'),'Start test datetime')
CustomKeywords.'actions.Table.verifyCellContainsValue'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'), 1, colNo_StartTestDateTime, Consts.P1_MW084_STARTDATETIME)

int colNo_BMText= CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'),'BM Text')
CustomKeywords.'actions.Table.verifyCellContainsValue'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'), 1, colNo_BMText, Consts.P1_MW084_BMTEXT)