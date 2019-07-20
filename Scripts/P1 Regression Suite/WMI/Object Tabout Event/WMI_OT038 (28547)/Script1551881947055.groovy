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

'Create Document 1 - Dropdown Event'
CustomKeywords.'actions.Data.create'(DocClass.OBJECT_TABOUT_EVENT, DocType.DROPDOWN_EVENT, null)

'Create Document 2 - Dropdown Event'
CustomKeywords.'actions.Data.create'(DocClass.OBJECT_TABOUT_EVENT, DocType.DROPDOWN_EVENT, null)

'Open second document from recent grid'
CustomKeywords.'actions.Common.openDocumentFromRecentGrid'(2)

'Wait for WMI to load'
WebUI.waitForElementVisible(findTestObject('Page_WMI_NEW/Object Tabout Event/DropDown Event/select_DropdownControl'), GlobalVariable.G_LongTimeout)

'Scroll to Single Result view'
WebUI.scrollToElement(findTestObject('Page_WMI_NEW/Object Tabout Event/DropDown Event/tab_SingleResultView/input_StringField'), GlobalVariable.G_LongTimeout)

'Select Value 1 in drop down'
String option = 'Value 1'
WebUI.selectOptionByLabel(findTestObject('Page_WMI_NEW/Object Tabout Event/DropDown Event/tab_SingleResultView/select_DropdownControl'), option, false)

'Wait for Javascript event to complete'
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)

'Verify value in String field'
String expText = 'Selected Value (Value 1)'
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI_NEW/Object Tabout Event/DropDown Event/tab_SingleResultView/input_StringField'), 'value', expText, GlobalVariable.G_LongTimeout)

'Verify Date Field is Visible'
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Object Tabout Event/DropDown Event/tab_SingleResultView/input_DateField'))

'Save WMI'
WebUI.click(findTestObject('Page_WMI_NEW/Object Tabout Event/DropDown Event/btn_Save'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Close WMI'
CustomKeywords.'actions.Window.clickElementAndWaitForWindowClose'(findTestObject('Page_WMI_NEW/Object Tabout Event/DropDown Event/btn_CloseWindow'), GlobalVariable.G_LongTimeout)

'Switch to parent window '
WebUI.switchToWindowIndex(0)

'Clear cookies and Login back into portal'
CustomKeywords.'actions.Common.login'()

'Open first document from recent grid'
CustomKeywords.'actions.Common.openDocumentFromRecentGrid'(1)

'Wait for WMI to load'
WebUI.waitForElementVisible(findTestObject('Page_WMI_NEW/Object Tabout Event/DropDown Event/select_DropdownControl'), GlobalVariable.G_LongTimeout)

'Verify option selected in drop down field'
WebUI.verifyOptionSelectedByLabel(findTestObject('Page_WMI_NEW/Object Tabout Event/DropDown Event/select_DropdownControl'), option, false, GlobalVariable.G_LongTimeout)

'Verify value in String field'
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI_NEW/Object Tabout Event/DropDown Event/input_StringField'), 'value', expText, GlobalVariable.G_LongTimeout)

'Verify Date Field is Visible'
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Object Tabout Event/DropDown Event/input_DateField'))