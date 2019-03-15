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

import common.DocClass
import common.DocType
import internal.GlobalVariable as GlobalVariable
import static utils.Consts.*

'Login into application'
CustomKeywords.'actions.Common.login'()

'Create new Document'
CustomKeywords.'actions.Data.create'(DocClass.DATE_DATETIME_DC, DocType.DATE_DATETIME_DT, P1_REPO_DOC248)
CustomKeywords.'actions.Data.create'(DocClass.DATE_DATETIME_DC, DocType.DATE_DATETIME_DT, P1_REPO_DOC249)

'Click on Repository Menu'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/h3_Repository Menu'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))
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
CustomKeywords.'actions.Calender.selectDateTime'(P1_REPO_DOC248_DT_RANGE_FROM_DATE, P1_REPO_DOC248_DT_RANGE_FROM_MONTH, P1_REPO_DOC248_DT_RANGE_FROM_YEAR, findTestObject('Page_nGage_Dashboard/Repository/calender_DateTimeRange_From'))
String datetimeFrom = WebUI.getAttribute(findTestObject('Page_nGage_Dashboard/Repository/input_DateTimeRange_From'), 'value').toUpperCase()
WebUI.verifyMatch(datetimeFrom, P1_REPO_DOC248_DT_RANGE_FROM, false)

CustomKeywords.'actions.Calender.selectDateTime'(P1_REPO_DOC248_DT_RANGE_TO_DATE, P1_REPO_DOC248_DT_RANGE_TO_MONTH, P1_REPO_DOC248_DT_RANGE_TO_YEAR, findTestObject('Page_nGage_Dashboard/Repository/calender_DateTimeRange_To'))
String datetimeTo = WebUI.getAttribute(findTestObject('Page_nGage_Dashboard/Repository/input_DateTimeRange_To'), 'value').toUpperCase()
WebUI.verifyMatch(datetimeTo, P1_REPO_DOC248_DT_RANGE_TO, false)

'Click on Search button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Repository/input_btnSearch'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

'Sort record by DocID desc'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Repository/table_Header_SearchResults'), 'Doc ID')
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Repository/table_Header_SearchResults'), 'Doc ID')

'Get the cell value to verify date format'
int colNo_DateTimeRange = CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Page_nGage_Dashboard/Repository/table_Header_SearchResults'), 'Date time range')
CustomKeywords.'actions.Table.verifyDateTimeFilter'(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/table_SearchResults'), colNo_DateTimeRange, P1_REPO_DOC248_DT_RANGE_FROM, P1_REPO_DOC248_DT_RANGE_TO, 'between')