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
CustomKeywords.'actions.Common.createDocument_MyWorkDateTime'(DC_DATETIMERANGEREQUIRED, DT_DATETIMERANGEREQUIRED, P1_MW084_STARTDATE, P1_MW084_ENDDATE, P1_MW084_STARTDATETIME, P1_MW084_ENDDATETIME, 'Test')
CustomKeywords.'actions.Common.createDocument_MyWorkDateTime'(DC_DATETIMERANGEREQUIRED, DT_DATETIMERANGEREQUIRED, P1_MW095_STARTDATE, P1_MW095_ENDDATE, P1_MW095_STARTDATETIME, P1_MW095_ENDDATETIME, 'Test')

'Click on My Work link from left menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

String treeDate = convert(P1_MW084_STARTDATETIME, FORMAT_DATETIME, FORMAT_DATE_TREE)
String filterDate = convert(P1_MW084_STARTDATETIME, FORMAT_DATETIME, FORMAT_DATE)

'Expand datetime range required processes'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('MY_WORK', 'Processes', 'Datetime range required', 'Date time range required', treeDate)
//TODO: Issue pending from Dev for Date format in tree MY_WORK
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Verify the foldered date group should be displayed with only Date (not with time) '
CustomKeywords.'actions.MenuBar.verifyAllActivityNamesAreValidDate'('My_Work',FORMAT_DATE_TREE,'Processes', 'Datetime range required', 'Date time range required')
//TODO: Issue pending from Dev for Date format in tree MY_WORK

'Expand search bar'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/h3_Search Bar'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Verify auto populated values'
WebUI.verifyElementAttributeValue(findTestObject('Page_nGage_Dashboard/My_Work/process_DatetimeRangeRequired/input_StartTestDateTime_From'), 'value', filterDate+' '+P1_TIME_START, GlobalVariable.G_LongTimeout)
WebUI.verifyElementAttributeValue(findTestObject('Page_nGage_Dashboard/My_Work/process_DatetimeRangeRequired/input_StartTestDateTime_To'), 'value', filterDate+' '+P1_TIME_END, GlobalVariable.G_LongTimeout)

'Select operator as Null'
WebUI.selectOptionByLabel(findTestObject('Page_nGage_Dashboard/My_Work/process_DatetimeRangeRequired/select_StartTestDatetime_operator'), 'Null', false)

'click on search button'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/btn_Search'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))

CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/tableHeader_DocCreateDate'))
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/tableHeader_DocCreateDate'))

int colNo_StartTestDatetime= CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'),'Start test datetime')

'Verify search result'
CustomKeywords.'actions.Table.verifyDateFilter'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'), colNo_StartTestDatetime, '', 'Null')