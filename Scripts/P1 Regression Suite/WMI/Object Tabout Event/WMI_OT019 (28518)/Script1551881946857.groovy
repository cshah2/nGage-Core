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

'Click Global New button'
WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))

'Select DocType CheckboxList Event'
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'(DocClass.OBJECT_TABOUT_EVENT.toString(), DocType.CHECKBOX_LIST_EVENT.toString())
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

'Switch to WMI window'
WebUI.switchToWindowIndex(1)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Wait for page to load'
WebUI.waitForElementVisible(findTestObject('Page_WMI_NEW/Object Tabout Event/CheckboxListEvent/chkbox_Value1'), GlobalVariable.G_LongTimeout)

'Select Value 1 checkbox'
WebUI.check(findTestObject('Page_WMI_NEW/Object Tabout Event/CheckboxListEvent/chkbox_Value1'))

'Wait for JavaScript event to complete'
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)

'Verify value displayed in String field'
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI_NEW/Object Tabout Event/CheckboxListEvent/input_StringField'), 'value', 'You selected Option 1', GlobalVariable.G_LongTimeout)

'Verify number of options present in drop down'
int expOptions = 23
WebUI.verifyEqual(WebUI.getNumberOfTotalOption(findTestObject('Page_WMI_NEW/Object Tabout Event/CheckboxListEvent/select_LookupField')), expOptions)

'Select option Render As Label from Drop down	'
String option = 'Render As Label'
WebUI.selectOptionByLabel(findTestObject('Page_WMI_NEW/Object Tabout Event/CheckboxListEvent/select_LookupField'), option, false)

'Save WMI'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Result_View/span_Save'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Close WMI'
WebUI.click(findTestObject('Page_WMI_NEW/Object Tabout Event/CheckboxListEvent/btn_CloseWindow'))

'Switch to main window'
WebUI.switchToWindowIndex(0)

'Close "create new" popup dialog'
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/span_ui-button-icon-primary ui'))

'Open document from recents grid'
CustomKeywords.'actions.Common.openDocumentFromRecentGrid'(1)

'Wait for page to load'
WebUI.waitForElementVisible(findTestObject('Page_WMI_NEW/Object Tabout Event/CheckboxListEvent/chkbox_Value1'), GlobalVariable.G_LongTimeout)

'Verify Checkbox 1 is checked'
WebUI.verifyElementChecked(findTestObject('Page_WMI_NEW/Object Tabout Event/CheckboxListEvent/chkbox_Value1'), GlobalVariable.G_LongTimeout)

'Verify value displayed in String field'
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI_NEW/Object Tabout Event/CheckboxListEvent/input_StringField'), 'value', 'You selected Option 1', GlobalVariable.G_LongTimeout)

'Verify number of options present in drop down'
WebUI.verifyEqual(WebUI.getNumberOfTotalOption(findTestObject('Page_WMI_NEW/Object Tabout Event/CheckboxListEvent/select_LookupField')), expOptions)

'Verify selected option in drop down'
WebUI.verifyOptionSelectedByLabel(findTestObject('Page_WMI_NEW/Object Tabout Event/CheckboxListEvent/select_LookupField'), option, false, GlobalVariable.G_LongTimeout)