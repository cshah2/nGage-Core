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

'Click On Date Required icon to expand'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/Process_Date Required/icon_expand_DateRequired'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Click On DateRequiredSearch to load Frame'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Process_Date Required/a_DateRequiredSearch'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Click On Search Button'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/h3_Search Bar'))

'Verify Fields from Search Form'
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Process_Date Required/input_Start Test Date'), 5)
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/btn_Search'), 5)
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/btn_Reset'), 5)

'Enter Date'
WebUI.setText(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Process_Date Required/input_Start Test Date'),'01-01-2019')
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/btn_Search'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Uncheck Show Assigned Only if Checked'
WebUI.uncheck(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/chexkbox_ShowAssignedOnly'))

int StartTestDate_ColumnPosition= CustomKeywords.'actions.Table.getColumnNumber'( findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'Start test date')
println 'Column Position of Search date is ' +StartTestDate_ColumnPosition

'Verify Search Result'
CustomKeywords.'actions.Table.verifyAllValuesInColumnMatches'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'), StartTestDate_ColumnPosition , '1/1/2019')