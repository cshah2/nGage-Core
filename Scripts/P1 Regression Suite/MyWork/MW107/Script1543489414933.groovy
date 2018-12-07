import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.Keys

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

'Click on DateRequiredSearch icon to expand'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Process_Date Required/icon_DateRequiredSearch_Expand'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'click 060617'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Process_Date Required/a_06-06-2017_DateRequiredSearch'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Verify Date format present with MM/DD/YYYY format(No time)'
CustomKeywords.'actions.Common.verifyDateFormat'(WebUI.getText(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Process_Date Required/a_06-06-2017_DateRequiredSearch')).split('[(]')[0].trim(), 'MM/DD/YYYY')



'Click On Search Bar'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/h3_Search Bar'))

'Verify Search result shown in the grid matches with the Date selected in the Activity'
println WebUI.getText(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Process_Date Required/a_06-06-2017_DateRequiredSearch')).split('[(]')[0].trim()
String activityName=WebUI.getText(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Process_Date Required/a_06-06-2017_DateRequiredSearch')).split('[(]')[0].trim().replaceAll('/','-')
println WebUI.getAttribute(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Process_Date Required/input_searchDateField'),'value')
WebUI.verifyMatch(activityName,WebUI.getAttribute(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Process_Date Required/input_searchDateField'),'value'), false)


'Select Date Operator (=)from Dropdown Menu'
WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Process_Date Required/icon_select_DateOperator'), '=', false)

'Enter Date'
WebUI.clearText(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Process_Date Required/input_searchDateField'))
WebUI.sendKeys(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Process_Date Required/input_searchDateField'), Keys.chord(Keys.TAB))
//WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Process_Date Required/input_Start Test Date'))

WebUI.setText(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Process_Date Required/input_Start Test Date'),'01-01-2018')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Click on Search Button to see required results'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/btn_Search'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Uncheck Show Assigned Only if Checked'
WebUI.uncheck(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/chexkbox_ShowAssignedOnly'))

int StartTestDate_ColumnPosition= CustomKeywords.'actions.Table.getColumnNumber'( findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'Start test date')
println 'Column Position of Search date is ' +StartTestDate_ColumnPosition

'Verify Search Result'
CustomKeywords.'actions.Table.verifyDateFilter'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'), StartTestDate_ColumnPosition , '01/01/2018','=')
WebUI.delay(5)