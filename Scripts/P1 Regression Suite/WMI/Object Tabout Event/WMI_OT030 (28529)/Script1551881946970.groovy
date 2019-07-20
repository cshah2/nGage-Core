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

'Login Into Application'
CustomKeywords.'actions.Common.login'()

'Create Document 1 - Checkbox event'
CustomKeywords.'actions.Data.create'(DocClass.OBJECT_TABOUT_EVENT, DocType.CHECKBOX_EVENT, null)

'Create Document 2 - Checkbox event'
CustomKeywords.'actions.Data.create'(DocClass.OBJECT_TABOUT_EVENT, DocType.CHECKBOX_EVENT, null)

'Open second document from recent grid'
CustomKeywords.'actions.Common.openDocumentFromRecentGrid'(2)

'Wait for page to load'
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Object Tabout Event/CheckBox Event/chkbox_Control'))

'Scroll to Single Result view'
WebUI.scrollToElement(findTestObject('Page_WMI_NEW/Object Tabout Event/CheckBox Event/tab_SingleResult/input_StringField'), GlobalVariable.G_LongTimeout)

'Select Checkbox'
WebUI.check(findTestObject('Page_WMI_NEW/Object Tabout Event/CheckBox Event/tab_SingleResult/chkbox_Control'))

'Wait for event to complete'
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)

'Verify value in textbox field'
String textValue = 'Checkbox is checked (Readonly)'
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI_NEW/Object Tabout Event/CheckBox Event/tab_SingleResult/input_StringField'), 'value', textValue, GlobalVariable.G_LongTimeout)

'Verify textbox field is disabled'
WebUI.verifyElementHasAttribute(findTestObject('Page_WMI_NEW/Object Tabout Event/CheckBox Event/tab_SingleResult/input_StringField'), 'readonly', GlobalVariable.G_LongTimeout)

'Save WMI'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/CheckBox Event/span_Save'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Close WMI'
CustomKeywords.'actions.Window.clickElementAndWaitForWindowClose'(findTestObject('Page_WMI_NEW/Object Tabout Event/CheckBox Event/span_Close Window'), GlobalVariable.G_LongTimeout)

'switch to main window'
WebUI.switchToWindowIndex('0')

'Clear cookies and Login back into portal'
CustomKeywords.'actions.Common.login'()

'Open first document from recent grid'
CustomKeywords.'actions.Common.openDocumentFromRecentGrid'(1)

'Wait for WMI to load'
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Object Tabout Event/CheckBox Event/chkbox_Control'))

'Verify checkbox is checked'
WebUI.verifyElementChecked(findTestObject('Page_WMI_NEW/Object Tabout Event/CheckBox Event/chkbox_Control'), GlobalVariable.G_LongTimeout)

'Verify value in textbox field'
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI_NEW/Object Tabout Event/CheckBox Event/input_StringField'), 'value', textValue, GlobalVariable.G_LongTimeout)

'Verify textbox field is disabled'
WebUI.verifyElementHasAttribute(findTestObject('Page_WMI_NEW/Object Tabout Event/CheckBox Event/input_StringField'), 'readonly', GlobalVariable.G_LongTimeout)