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

'Login Into Application'
CustomKeywords.'actions.Common.login'()

'Click on My Work link from left menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Create a new Document in Date Range Required activity'
CustomKeywords.'actions.Common.createDocument_MyWorkDateTime'('daterangerequired','daterangerequired','01-01-2018','01-01-2025','01-01-2018 05:08:14 PM','08-30-2002 09:29:45 AM','Test')

'Expand Processes and Verify Date Required activity Displayed and Click on Created date Document'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('My_Work','Processes','DateRange required','Date range required','01/01/2018')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Verify the foldered date group should be displayed with only Date (not with time)'
CustomKeywords.'actions.MenuBar.verifyAllActivityNamesAreValidDate'('My_Work','MM/DD/YYYY','Processes','DateRange required','Date range required')

'Click On Search Bar'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/h3_Search Bar'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Verify date autopopulated should show in the search panel'
String actualTextOfStartTestDateFrom = WebUI.getAttribute(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Process_DateRangeRequired/input_StateTestDate_From'),'value')
println actualTextOfStartTestDateFrom
WebUI.verifyMatch(actualTextOfStartTestDateFrom, '01-01-2018', false)

String actualTextOfStartTestDateTo = WebUI.getAttribute(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Process_DateRangeRequired/input_StartTestDate_To'),'value')
println actualTextOfStartTestDateTo
WebUI.verifyMatch(actualTextOfStartTestDateTo, '01-01-2018', false)

'click on search button'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/btn_Search'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Verify searched data (selected date in activity)should be displayed in the search result'
int columnPosition_StartTestDate= CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'),'Start test date')
println columnPosition_StartTestDate
String actualTextOfStartTextDateColumn= CustomKeywords.'actions.Table.getCellText'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'), 1, columnPosition_StartTestDate)
println actualTextOfStartTextDateColumn
WebUI.verifyMatch(actualTextOfStartTextDateColumn, '1/1/2018', false)
