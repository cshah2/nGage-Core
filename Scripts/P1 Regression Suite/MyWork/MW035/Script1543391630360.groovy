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

'Click on DateRangeRequired icon to expand'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Process_DateRangeRequired/icon_expand_DateRangeRequired'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Click on DateRangeRequired to see work items'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/Process_DateRangeRequired/a_DateRangeRequired'))

'Click On Search Bar to display Date field to Enter search Dates'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/h3_Search Bar'))

'Verify Fields from Search Form'
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/btn_Search'), 5)
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/btn_Reset'), 5)

'Enter date range'
WebUI.setText(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Process_DateRangeRequired/input_EndTestDate_from'),'01-01-2011')
WebUI.setText(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Process_DateRangeRequired/input_EndTestDate_To'),'01-01-2025')
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/btn_Search'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Uncheck Show Assigned Only if Checked'
WebUI.uncheck(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/chexkbox_ShowAssignedOnly'))

WebUI.delay(10)

int StartTestDate_ColumnPosition= CustomKeywords.'actions.Table.getColumnNumber'( findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'Start test date')
println 'Column Position of Search date is ' +StartTestDate_ColumnPosition

'Verify Search Results'
CustomKeywords.'actions.Table.verifyRecordsWithinDateRange'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'),5,'01-01-2011','01-01-2025')