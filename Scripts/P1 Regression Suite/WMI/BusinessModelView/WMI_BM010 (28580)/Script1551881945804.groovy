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

'Create a new Refrence Object Feature Document'
WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'('Business Model View', 'Standard Grid')
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

WebUI.switchToWindowTitle('(Doc ID: NEW )')
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Click on WMI Harness page'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Result_View/span_WMI Harness'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Result_View/iframe_ContentPlaceHolder1_iPage'))

'Click on Save button'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Result_View/span_Save'))

'Verify the record is saved'
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/BusinessModelView/StandardGrid/a_Audit History'))

'Open Audit History tab'
WebUI.click(findTestObject('Page_WMI_NEW/BusinessModelView/StandardGrid/a_Audit History'))

'Verify Audit History tab is loaded'
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/BusinessModelView/StandardGrid/AuditHistory/table_Audit History'))

'Verify revision, Action Date,Action By, Action Description are displayed'
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/BusinessModelView/StandardGrid/AuditHistory/td_Revision'))
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/BusinessModelView/StandardGrid/AuditHistory/td_ActionBy'))
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/BusinessModelView/StandardGrid/AuditHistory/td_ActionDescription'))

'Verify the bordercolor for grid.(border color set in wmi is #FFA500=orange)'
CustomKeywords.'actions.Common.verifyCssValue'(findTestObject('Page_WMI_NEW/BusinessModelView/StandardGrid/AuditHistory/td_Audit History'), 'border-top-color', 'rgba(255, 165, 0, 1)')

'Verify the backgroundcolor for grid (backgroundcolor set in wmi is #DAA520=Goldenrod)'
CustomKeywords.'actions.Common.verifyCssValue'(findTestObject('Page_WMI_NEW/BusinessModelView/StandardGrid/AuditHistory/table_Audit History'), 'background-color', 'rgba(218, 165, 32, 1)')

'Verify the headerbgcolor for grid (headerbgcolor set in wmi is #FFDAB9=PeachPuff)'
CustomKeywords.'actions.Common.verifyCssValue'(findTestObject('Page_WMI_NEW/BusinessModelView/StandardGrid/AuditHistory/td_Audit History'), 'background-color', 'rgba(255, 218, 185, 1)')

'Add 3 records to Audit History tab (One record is already present due to 1st save operation) Hence creating 2 records'
'Click on Save button'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Result_View/span_Save'))

'Verify the record is saved'
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/BusinessModelView/StandardGrid/a_Audit History'))

'Open Audit History tab'
WebUI.click(findTestObject('Page_WMI_NEW/BusinessModelView/StandardGrid/a_Audit History'))

'Verify Audit History tab is loaded'
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/BusinessModelView/StandardGrid/AuditHistory/table_Audit History'))

'Click on Save button'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Result_View/span_Save'))

'Verify the record is saved'
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/BusinessModelView/StandardGrid/a_Audit History'))

'Open Audit History tab'
WebUI.click(findTestObject('Page_WMI_NEW/BusinessModelView/StandardGrid/a_Audit History'))

'Verify Audit History tab is loaded'
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/BusinessModelView/StandardGrid/AuditHistory/table_Audit History'))

'Verify table has 2 rows on every page and 2 pages are appearing for 4 records'
int expectedRows = 2
int rowCount = CustomKeywords.'actions.Table.getRowsCount'(findTestObject('Page_WMI_NEW/BusinessModelView/StandardGrid/AuditHistory/table_ActualRow'))
WebUI.verifyEqual(rowCount, expectedRows)

'Verify page count is 2'
String pageCount = WebUI.getText(findTestObject('Page_WMI_NEW/BusinessModelView/StandardGrid/AuditHistory/page_Count'))
String[] actualPageCount = pageCount.split('of ')
String actualPageCount1 = actualPageCount[0]
String actualPageCount2 = actualPageCount[1]
WebUI.verifyEqual(actualPageCount2, expectedRows)

'Verify Back to top link is visible'
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/BusinessModelView/StandardGrid/AuditHistory/a_ Back to Top'))