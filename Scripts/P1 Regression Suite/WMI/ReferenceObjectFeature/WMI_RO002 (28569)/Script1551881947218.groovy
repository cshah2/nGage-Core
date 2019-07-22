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

import common.DocClass
import common.DocType
import internal.GlobalVariable as GlobalVariable
import utils.Consts
import utils.DateUtil

'Login Into Application'
CustomKeywords.'actions.Common.login'()

'Create Document 1 - Reference Object inline result view'
CustomKeywords.'actions.Data.create'(DocClass.REFERENCE_OBJECT_FEATURE, DocType.REF_OBJ_INLINE_RESULT_VIEW, null)

'Create Document 2 - Checkbox event'
CustomKeywords.'actions.Data.create'(DocClass.OBJECT_TABOUT_EVENT, DocType.CHECKBOX_EVENT, null)

'Open second document from recent grid'
CustomKeywords.'actions.Common.openDocumentFromRecentGrid'(2)

'Wait for WMI to load'
WebUI.waitForElementVisible(findTestObject('Page_WMI_NEW/Reference_Object_Feature/Inline_Result_View/span_Information'), GlobalVariable.G_LongTimeout)

'Verify Information text'
String expText = 'This WMI imparts Reference Object features for InlineResultView and disablegridclick'
WebUI.verifyElementText(findTestObject('Page_WMI_NEW/Reference_Object_Feature/Inline_Result_View/span_Information'), expText)

'Click on Tab 2'
WebUI.click(findTestObject('Page_WMI_NEW/Reference_Object_Feature/Inline_Result_View/tab2_InlineResultView'))
WebUI.delay(1)

'Sort records in Inline Result grid'
WebUI.click(findTestObject('Page_WMI_NEW/Reference_Object_Feature/Inline_Result_View/Tab2_Inline_Result_View/tableHeader_DocID'))
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_WMI_NEW/Reference_Object_Feature/Inline_Result_View/Tab2_Inline_Result_View/tableHeader_DocID'))
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)

'Click on first row in inline result view'
CustomKeywords.'actions.Table.clickCell'(findTestObject('Page_WMI_NEW/Reference_Object_Feature/Inline_Result_View/Tab2_Inline_Result_View/table_InlineResultView'), 1, 5)
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)

'Wait for Inline document to load'
WebUI.waitForElementVisible(findTestObject('Page_WMI_NEW/Reference_Object_Feature/Inline_Result_View/Tab2_Inline_Result_View/lbl_Information'), GlobalVariable.G_LongTimeout)

'Scroll to Inline view'
WebUI.scrollToElement(findTestObject('Page_WMI_NEW/Reference_Object_Feature/Inline_Result_View/Tab2_Inline_Result_View/input_StringField'), GlobalVariable.G_LongTimeout)

'Verify Inline document is checkbox event'
String expText1 = 'This WMI imparts - Field Events in CheckBox'
WebUI.verifyElementText(findTestObject('Page_WMI_NEW/Reference_Object_Feature/Inline_Result_View/Tab2_Inline_Result_View/lbl_Information'), expText1)

'Click on Checkbox Control'
WebUI.check(findTestObject('Page_WMI_NEW/Reference_Object_Feature/Inline_Result_View/Tab2_Inline_Result_View/chkbox_Control'))

'Wait for Javascript event to complete'
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)

'Verify Text value in input field reference object'
String inputFieldText = 'Checkbox is checked (Readonly)'
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI_NEW/Reference_Object_Feature/Inline_Result_View/Tab2_Inline_Result_View/input_StringField'), 'value', inputFieldText, GlobalVariable.G_LongTimeout)

'Save Inline Document'
WebUI.click(findTestObject('Page_WMI_NEW/Reference_Object_Feature/Inline_Result_View/Tab2_Inline_Result_View/btn_Save'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Close WMI'
CustomKeywords.'actions.Window.clickElementAndWaitForWindowClose'(findTestObject('Page_WMI_NEW/Reference_Object_Feature/Inline_Result_View/span_Close Window'), GlobalVariable.G_LongTimeout)

'Switch to parent window'
WebUI.switchToWindowIndex(0)

'Clear cookies and Login back into portal'
CustomKeywords.'actions.Common.login'()

'Open first document from recent grid'
CustomKeywords.'actions.Common.openDocumentFromRecentGrid'(1)

'Wait for WMI to load'
WebUI.waitForElementVisible(findTestObject('Page_WMI_NEW/Object Tabout Event/CheckBox Event/lbl_Information'), GlobalVariable.G_LongTimeout)

'Verify Checkbox event document is loaded'
WebUI.verifyElementText(findTestObject('Page_WMI_NEW/Object Tabout Event/CheckBox Event/lbl_Information'), expText1)

'Verify Checkbox control is checked'
WebUI.verifyElementChecked(findTestObject('Page_WMI_NEW/Object Tabout Event/CheckBox Event/chkbox_Control'), GlobalVariable.G_LongTimeout)

'Verify Text in String field'
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI_NEW/Object Tabout Event/CheckBox Event/input_StringField'), 'value', inputFieldText, GlobalVariable.G_LongTimeout)