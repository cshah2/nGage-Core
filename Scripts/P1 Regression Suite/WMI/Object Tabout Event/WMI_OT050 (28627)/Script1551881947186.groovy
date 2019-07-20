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

'Create Document 1 - Textbox with section event'
CustomKeywords.'actions.Data.create'(DocClass.OBJECT_TABOUT_EVENT, DocType.ONLOAD_AND_SETFOCUS_EVENT, null)

'Create Document 2 - Textbox with section event'
CustomKeywords.'actions.Data.create'(DocClass.OBJECT_TABOUT_EVENT, DocType.ONLOAD_AND_SETFOCUS_EVENT, null)

'Open second document from recent grid'
CustomKeywords.'actions.Common.openDocumentFromRecentGrid'(2)

'Wait for Page to load'
WebUI.waitForElementVisible(findTestObject('Page_WMI_NEW/Object Tabout Event/DoNotSetValueOnLoad SetFocus Event/chkbox_Control'), GlobalVariable.G_LongTimeout)

'Scroll to Single result view'
WebUI.scrollToElement(findTestObject('Page_WMI_NEW/Object Tabout Event/DoNotSetValueOnLoad SetFocus Event/SingleResultView_tab/input_CurrencyField'), GlobalVariable.G_LongTimeout)

'Check checkbox'
WebUI.check(findTestObject('Page_WMI_NEW/Object Tabout Event/DoNotSetValueOnLoad SetFocus Event/SingleResultView_tab/chkbox_Control'))

'Wait for Javascript event to complete'
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)

'Verify text in String field'
String expText = 'Checkbox is checked'
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI_NEW/Object Tabout Event/DoNotSetValueOnLoad SetFocus Event/SingleResultView_tab/input_StringField'), 'value', expText, GlobalVariable.G_LongTimeout)

'Verify currency field has focus'
CustomKeywords.'actions.Common.verifyElementHasFocus'(findTestObject('Page_WMI_NEW/Object Tabout Event/DoNotSetValueOnLoad SetFocus Event/SingleResultView_tab/input_CurrencyField'))

'Save WMI'
WebUI.click(findTestObject('Page_WMI_NEW/Object Tabout Event/DoNotSetValueOnLoad SetFocus Event/btn_Save'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Close WMI'
CustomKeywords.'actions.Window.clickElementAndWaitForWindowClose'(findTestObject('Page_WMI_NEW/Object Tabout Event/DoNotSetValueOnLoad SetFocus Event/btn_CloseWindow'), GlobalVariable.G_LongTimeout)

'Switch to parent window'
WebUI.switchToWindowIndex(0)

'Clear cookies and Login back into portal'
CustomKeywords.'actions.Common.login'()

'Open first document from recent grid'
CustomKeywords.'actions.Common.openDocumentFromRecentGrid'(1)

'Verify Checkbox control is checked'
WebUI.verifyElementChecked(findTestObject('Page_WMI_NEW/Object Tabout Event/DoNotSetValueOnLoad SetFocus Event/chkbox_Control'), GlobalVariable.G_LongTimeout)

'Verify text in String field'
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI_NEW/Object Tabout Event/DoNotSetValueOnLoad SetFocus Event/input_StringField'), 'value', expText, GlobalVariable.G_LongTimeout)