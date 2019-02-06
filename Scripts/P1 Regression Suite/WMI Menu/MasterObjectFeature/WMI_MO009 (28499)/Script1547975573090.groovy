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
import utils.DateUtil

'Login into application'
CustomKeywords.'actions.Common.login'()

'Click on NEW button'
WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))

'Select DocClass and DocType'
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'('Master Object Feature', 'Render As ChangeDocType')

'Click on OK button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))
WebUI.switchToWindowTitle('(Doc ID: NEW )')
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Verify Information Text'
WebUI.verifyElementText(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_ChangeDocType/span_Information'), 'This WMI imparts - Control renderas CHANGEDOCTYPE')

'Verify Drop down has options'
WebUI.verifyOptionSelectedByLabel(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_ChangeDocType/select_StringField'), 'Render As ChangeDocType', false, GlobalVariable.G_LongTimeout)
WebUI.verifyOptionSelectedByLabel(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_ChangeDocType/select_StringField_Lookup'), 'Render As ChangeDocType', false, GlobalVariable.G_LongTimeout)

'Verify drop down contains options'
WebUI.verifyOptionPresentByLabel(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_ChangeDocType/select_StringField'), 'Render As Label', false, GlobalVariable.G_LongTimeout)
WebUI.verifyOptionPresentByLabel(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_ChangeDocType/select_StringField'), 'Render As TextBox', false, GlobalVariable.G_LongTimeout)
WebUI.verifyOptionPresentByLabel(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_ChangeDocType/select_StringField'), 'Render As CheckBox', false, GlobalVariable.G_LongTimeout)
WebUI.verifyOptionPresentByLabel(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_ChangeDocType/select_StringField'), 'Render As CheckBox List', false, GlobalVariable.G_LongTimeout)
WebUI.verifyOptionPresentByLabel(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_ChangeDocType/select_StringField'), 'Render As RadioList', false, GlobalVariable.G_LongTimeout)
WebUI.verifyOptionPresentByLabel(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_ChangeDocType/select_StringField'), 'Render As LinkButton', false, GlobalVariable.G_LongTimeout)
WebUI.verifyOptionPresentByLabel(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_ChangeDocType/select_StringField'), 'Render As HtmlEdit', false, GlobalVariable.G_LongTimeout)

WebUI.verifyOptionPresentByLabel(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_ChangeDocType/select_StringField_Lookup'), 'Render As Label', false, GlobalVariable.G_LongTimeout)
WebUI.verifyOptionPresentByLabel(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_ChangeDocType/select_StringField_Lookup'), 'Render As TextBox', false, GlobalVariable.G_LongTimeout)
WebUI.verifyOptionPresentByLabel(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_ChangeDocType/select_StringField_Lookup'), 'Render As CheckBox', false, GlobalVariable.G_LongTimeout)
WebUI.verifyOptionPresentByLabel(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_ChangeDocType/select_StringField_Lookup'), 'Render As CheckBox List', false, GlobalVariable.G_LongTimeout)
WebUI.verifyOptionPresentByLabel(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_ChangeDocType/select_StringField_Lookup'), 'Render As RadioList', false, GlobalVariable.G_LongTimeout)
WebUI.verifyOptionPresentByLabel(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_ChangeDocType/select_StringField_Lookup'), 'Render As LinkButton', false, GlobalVariable.G_LongTimeout)
WebUI.verifyOptionPresentByLabel(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_ChangeDocType/select_StringField_Lookup'), 'Render As HtmlEdit', false, GlobalVariable.G_LongTimeout)

'Select drop down as Render as TextBox'
WebUI.selectOptionByLabel(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_ChangeDocType/select_StringField'), 'Render As TextBox', false)
WebUI.delay(5)

'Verify Information Text'
WebUI.verifyElementText(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_Textbox/span_Information'), 'This WMI imparts - Control renderas Textbox')

'Enter valid date in input field'
String currentDate = DateUtil.getCurrentDateTime('MM/dd/yyyy')
//TODO: Date time format is not valid
WebUI.setText(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_Textbox/input_DateType'), currentDate)

'Click Save'
WebUI.click(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_Textbox/span_Save'))

'Click close window'
CustomKeywords.'actions.Window.clickElementAndWaitForWindowClose'(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_Textbox/span_Close Window'), GlobalVariable.G_LongTimeout)

WebUI.switchToWindowTitle('Savana nGage')
'Close create new popup dialog'
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/span_ui-button-icon-primary ui'))

'Go to Recent documents'
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/a_Recent Documents'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/iframe_iframe_103'))

'Verify atleast 1 record is present in grid'
WebUI.verifyElementPresent(findTestObject('Page_nGage_Dashboard/Home/tableRow_recentDocuments_firstRow'), GlobalVariable.G_LongTimeout);

'Sort records in table by DocID Descending'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'), 'Doc ID')
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'), 'Doc ID')

'Verify Column values in 1st record'
CustomKeywords.'actions.Table.verifyCellContainsValue'(findTestObject('Page_nGage_Dashboard/Home/table_MyDocumentResults'), 1, 4, 'Render As TextBox')
CustomKeywords.'actions.Table.verifyCellContainsValue'(findTestObject('Page_nGage_Dashboard/Home/table_MyDocumentResults'), 1, 5, 'Created')

'Click on 1st Row'
CustomKeywords.'actions.Table.clickCell'(findTestObject('Page_nGage_Dashboard/Home/table_MyDocumentResults'), 1, 3)

'Open document'
WebUI.switchToWindowIndex(1)

'Verify Information Text'
WebUI.verifyElementText(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_Textbox/span_Information'), 'This WMI imparts - Control renderas Textbox')

'Verify value in datetime field is valid date'
WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_Textbox/input_DateType'), 'value').trim().replaceAll('-', '/'), currentDate, false)
