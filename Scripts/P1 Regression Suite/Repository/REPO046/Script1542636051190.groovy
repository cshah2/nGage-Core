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

'Login into application'
CustomKeywords.'actions.Common.login'()

'Create new Document'
CustomKeywords.'actions.Common.createDocument_DateTimeDT'(Consts.P1_REPO_BMDATE_DOC4, Consts.P1_REPO_DATERANGE_DOC4, Consts.P1_REPO_BMDATETIME_DOC4, Consts.P1_REPO_DATETIMERANGE_DOC4)

'Click on Repository Menu'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/h3_Repository Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Select Repository - Advance Search tab'
WebUI.selectOptionByLabel(findTestObject('Page_nGage_Dashboard/Repository/select_Repository Drop Down'), 'Date n Date time EDM', false)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

'Selinput_btnSearchect Search For - Advance Search tab'
WebUI.selectOptionByLabel(findTestObject('Page_nGage_Dashboard/Repository/select_Search For Drop Down'), 'Date n Date time search class', false)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

'Select operator (=)'
WebUI.selectOptionByLabel(findTestObject('Page_nGage_Dashboard/Repository/select_DateTimeRange'), '=', false)

'Enter date in DateTime field'
CustomKeywords.'actions.Calender.selectDateTime'(Consts.P1_REPO_DATETIMERANGEFROM_DATE_DOC4, Consts.P1_REPO_DATETIMERANGEFROM_MONTH_DOC4, Consts.P1_REPO_DATETIMERANGEFROM_YEAR_DOC4, findTestObject('Page_nGage_Dashboard/Repository/calender_DateTimeRange_From'))
String datetimeFrom = WebUI.getAttribute(findTestObject('Page_nGage_Dashboard/Repository/input_DateTimeRange_From'), 'value').toUpperCase()
WebUI.verifyMatch(datetimeFrom, Consts.P1_REPO_DATETIMERANGEFROM_DOC4, false)

CustomKeywords.'actions.Calender.selectDateTime'(Consts.P1_REPO_DATETIMERANGETO_DATE_DOC4, Consts.P1_REPO_DATETIMERANGETO_MONTH_DOC4, Consts.P1_REPO_DATETIMERANGETO_YEAR_DOC4, findTestObject('Page_nGage_Dashboard/Repository/calender_DateTimeRange_To'))
String datetimeTo = WebUI.getAttribute(findTestObject('Page_nGage_Dashboard/Repository/input_DateTimeRange_To'), 'value').toUpperCase()
WebUI.verifyMatch(datetimeTo, Consts.P1_REPO_DATETIMERANGETO_DOC4, false)

'Click on Search button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Repository/input_btnSearch'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

'Sort record by DocID desc'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Repository/columnHeader_DocID'))
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Repository/columnHeader_DocID'))

'Get the cell value to verify date format'
int colNo_DateTimeRange = CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Page_nGage_Dashboard/Repository/table_Header_SearchResults'), 'Date time range')
CustomKeywords.'actions.Table.verifyRecordsWithinDateRange'(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/table_SearchResults'), colNo_DateTimeRange, Consts.P1_REPO_DATETIMERANGEFROM_DOC4, Consts.P1_REPO_DATETIMERANGETO_DOC4)