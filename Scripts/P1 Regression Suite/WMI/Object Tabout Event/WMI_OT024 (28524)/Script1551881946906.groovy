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

'Create Document 1 - Checkbox List Event'
CustomKeywords.'actions.Data.create'(DocClass.OBJECT_TABOUT_EVENT, DocType.CHECKBOX_LIST_EVENT, null)

'Create Document 2 - Checkbox List Event'
CustomKeywords.'actions.Data.create'(DocClass.OBJECT_TABOUT_EVENT, DocType.CHECKBOX_LIST_EVENT, null)

'Open second document from recent grid'
CustomKeywords.'actions.Common.openDocumentFromRecentGrid'(2)

'Wait for page to load'
WebUI.waitForElementVisible(findTestObject('Page_WMI_NEW/Object Tabout Event/CheckboxListEvent/chkbox_Value1'), GlobalVariable.G_LongTimeout)

'Scroll to Single Result View'
WebUI.scrollToElement(findTestObject('Page_WMI_NEW/Object Tabout Event/CheckboxListEvent/tab_SingleResult/select_LookupField'), GlobalVariable.G_LongTimeout)

'Select Value 3 checkbox'
WebUI.check(findTestObject('Page_WMI_NEW/Object Tabout Event/CheckboxListEvent/tab_SingleResult/chkbox_Value3'))

'Wait for JavaScript event to complete'
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)

'Verify value displayed in String field'
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI_NEW/Object Tabout Event/CheckboxListEvent/tab_SingleResult/input_StringField'), 'value', 'You have selected other option', GlobalVariable.G_LongTimeout)

'Verify number of options present in drop down'
int expOptions = 35
WebUI.verifyEqual(WebUI.getNumberOfTotalOption(findTestObject('Page_WMI_NEW/Object Tabout Event/CheckboxListEvent/tab_SingleResult/select_LookupField')), expOptions)

'Select option from Drop down	'
String option = 'Field Mask'
WebUI.selectOptionByLabel(findTestObject('Page_WMI_NEW/Object Tabout Event/CheckboxListEvent/tab_SingleResult/select_LookupField'), option, false)

'Save WMI'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Result_View/span_Save'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Close WMI'
WebUI.click(findTestObject('Page_WMI_NEW/Object Tabout Event/CheckboxListEvent/btn_CloseWindow'))

'Switch to main window'
WebUI.switchToWindowIndex(0)

'Clear cookies and Login back into portal'
CustomKeywords.'actions.Common.login'()

'Open document from recents grid'
CustomKeywords.'actions.Common.openDocumentFromRecentGrid'(1)

'Wait for page to load'
WebUI.waitForElementVisible(findTestObject('Page_WMI_NEW/Object Tabout Event/CheckboxListEvent/chkbox_Value1'), GlobalVariable.G_LongTimeout)

'Verify Checkbox 3 is checked'
WebUI.verifyElementChecked(findTestObject('Page_WMI_NEW/Object Tabout Event/CheckboxListEvent/chkbox_Value3'), GlobalVariable.G_LongTimeout)

'Verify value displayed in String field'
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI_NEW/Object Tabout Event/CheckboxListEvent/input_StringField'), 'value', 'You have selected other option', GlobalVariable.G_LongTimeout)

'Verify number of options present in drop down'
WebUI.verifyEqual(WebUI.getNumberOfTotalOption(findTestObject('Page_WMI_NEW/Object Tabout Event/CheckboxListEvent/select_LookupField')), expOptions)

'Verify selected option in drop down'
WebUI.verifyOptionSelectedByLabel(findTestObject('Page_WMI_NEW/Object Tabout Event/CheckboxListEvent/select_LookupField'), option, false, GlobalVariable.G_LongTimeout)