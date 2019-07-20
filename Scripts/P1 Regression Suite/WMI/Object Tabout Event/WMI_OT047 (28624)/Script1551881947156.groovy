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

'Click on Global new button'
WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))

'Create a new Refrence Object Feature Document'
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'(DocClass.OBJECT_TABOUT_EVENT.toString(), DocType.ONLOAD_AND_SETFOCUS_EVENT.toString())
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

'Switch to WMI page'
WebUI.switchToWindowIndex(1)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Wait for Page to load'
WebUI.waitForElementVisible(findTestObject('Page_WMI_NEW/Object Tabout Event/DoNotSetValueOnLoad SetFocus Event/chkbox_Control'), GlobalVariable.G_LongTimeout)

'Uncheck checkbox'
WebUI.uncheck(findTestObject('Page_WMI_NEW/Object Tabout Event/DoNotSetValueOnLoad SetFocus Event/chkbox_Control'))

'Wait for Javascript event to complete'
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)

'Verify text in String field'
String expText = 'Checkbox is un-checked'
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI_NEW/Object Tabout Event/DoNotSetValueOnLoad SetFocus Event/input_StringField'), 'value', expText, GlobalVariable.G_LongTimeout)

'Verify currency field does not have focus'
CustomKeywords.'actions.Common.verifyElementNotHasFocus'(findTestObject('Page_WMI_NEW/Object Tabout Event/DoNotSetValueOnLoad SetFocus Event/input_CurrencyField'))

'Save WMI'
WebUI.click(findTestObject('Page_WMI_NEW/Object Tabout Event/DoNotSetValueOnLoad SetFocus Event/btn_Save'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Close WMI'
CustomKeywords.'actions.Window.clickElementAndWaitForWindowClose'(findTestObject('Page_WMI_NEW/Object Tabout Event/DoNotSetValueOnLoad SetFocus Event/btn_CloseWindow'), GlobalVariable.G_LongTimeout)

'Switch to parent window'
WebUI.switchToWindowIndex(0)

'Close "create new" popup dialog'
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/span_ui-button-icon-primary ui'))

'Open first document from recent grid'
CustomKeywords.'actions.Common.openDocumentFromRecentGrid'(1)

'Verify Checkbox control is unchecked'
WebUI.verifyElementNotChecked(findTestObject('Page_WMI_NEW/Object Tabout Event/DoNotSetValueOnLoad SetFocus Event/chkbox_Control'), GlobalVariable.G_LongTimeout)

'Verify text in String field'
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI_NEW/Object Tabout Event/DoNotSetValueOnLoad SetFocus Event/input_StringField'), 'value', expText, GlobalVariable.G_LongTimeout)