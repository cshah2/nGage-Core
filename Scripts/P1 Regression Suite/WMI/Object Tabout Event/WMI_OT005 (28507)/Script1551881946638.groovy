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

'Login Into Application'
CustomKeywords.'actions.Common.login'()

'Create Document 1 - Textbox with section event'
CustomKeywords.'actions.Data.create'(DocClass.OBJECT_TABOUT_EVENT, DocType.TEXTBOX_WITH_SECTION_EVENT, null)

'Create Document 2 - Textbox with section event'
CustomKeywords.'actions.Data.create'(DocClass.OBJECT_TABOUT_EVENT, DocType.TEXTBOX_WITH_SECTION_EVENT, null)

'Open second document from recent grid'
CustomKeywords.'actions.Common.openDocumentFromRecentGrid'(2)

'Wait for WMI to load'
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Textbox with Section Event/tab_SingleResultView/span_(Title)SingleResultView'), GlobalVariable.G_LongTimeout)

'Scroll to input box'
WebUI.scrollToElement(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Textbox with Section Event/tab_SingleResultView/input_Reference Object Event_e'), GlobalVariable.G_LongTimeout)

String inputValue = 'Hide'
'Enter show value in Single result view'
CustomKeywords.'actions.Common.setTextJQuery'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Textbox with Section Event/tab_SingleResultView/input_Reference Object Event_e'), inputValue)
WebUI.sendKeys(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Textbox with Section Event/tab_SingleResultView/input_Reference Object Event_e'), Keys.chord(Keys.ENTER))

'Wait for event to complete'
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)

'verify Sample section isnt visble'
WebUI.verifyElementNotVisible(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Textbox with Section Event/tab_SingleResultView/span_Sample Section - Visible'))

'Save WMI'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Textbox with Section Event/span_Save'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Close WMI'
CustomKeywords.'actions.Window.clickElementAndWaitForWindowClose'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Textbox with Section Event/span_Close Window'),GlobalVariable.G_LongTimeout)
WebUI.switchToWindowIndex(0)

'Switch to parent window'
WebUI.switchToWindowIndex(0)

'Open first document from recent grid'
CustomKeywords.'actions.Common.openDocumentFromRecentGrid'(1)

'Wait for WMI to load'
WebUI.waitForElementVisible(findTestObject('Page_WMI_NEW/Object Tabout Event/Textbox with Section Event/input_Master Object Event_efor'), GlobalVariable.G_LongTimeout)

'Verify value in text field is Show in Master object'
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI_NEW/Object Tabout Event/Textbox with Section Event/input_Master Object Event_efor'), 'value', inputValue, GlobalVariable.G_LongTimeout)

'verify Sample section isnt visble in Master object'
WebUI.verifyElementNotVisible(findTestObject('Page_WMI_NEW/Object Tabout Event/Textbox with Section Event/span_Sample Section - Visible'))