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

'Create Document 1 - Standard Grid'
CustomKeywords.'actions.Data.create'(DocClass.BUSINESS_MODEL_VIEW, DocType.STANDARD_GRID, null)

'Create Document 2 - Radio List Event'
CustomKeywords.'actions.Data.create'(DocClass.OBJECT_TABOUT_EVENT, DocType.RADIO_LIST_EVENT, null)

'Create Document 3 - Radio List Event'
CustomKeywords.'actions.Data.create'(DocClass.OBJECT_TABOUT_EVENT, DocType.RADIO_LIST_EVENT, null)

'Open second document from Recent grid'
CustomKeywords.'actions.Common.openDocumentFromRecentGrid'(2)

'Wait for WMI to load'
WebUI.waitForElementVisible(findTestObject('Page_WMI_NEW/Object Tabout Event/Radio List Event/input_Value1_MasterObject'), GlobalVariable.G_LongTimeout)

'Wait for single result view to load'
WebUI.waitForElementVisible(findTestObject('Page_WMI_NEW/Object Tabout Event/Radio List Event/tab_SingleResultView/input_Value1_ReferenceObject'), GlobalVariable.G_LongTimeout)

'Click on Value 1 radio button from refrence object'
WebUI.check(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/tab_SingleResultView/input_Value1_ReferenceObject'))

'Wait for event to complete'
CustomKeywords.'actions.Common.waitForTabLoading'(null,GlobalVariable.G_LongTimeout )

'Scroll to Inline view section'
WebUI.scrollToElement(findTestObject('Page_WMI_NEW/Object Tabout Event/Radio List Event/tab_SingleResultView/input_StringField_ReferenceObject'), GlobalVariable.G_LongTimeout)

'Clear Data in date field Single result view'
WebUI.clearText(findTestObject('Page_WMI_NEW/Object Tabout Event/Radio List Event/tab_SingleResultView/input_DateField_Required'))
WebUI.sendKeys(findTestObject('Page_WMI_NEW/Object Tabout Event/Radio List Event/tab_SingleResultView/input_DateField_Required'), Keys.chord(Keys.ENTER))

'Verify Error message is displayed for date field'
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Object Tabout Event/Radio List Event/tab_SingleResultView/div_Required'))

'Scroll to Inline view section'
WebUI.scrollToElement(findTestObject('Page_WMI_NEW/Object Tabout Event/Radio List Event/tab_SingleResultView/input_StringField_ReferenceObject'), GlobalVariable.G_LongTimeout)

String inputValue = DateUtil.getCurrentDateTime(Consts.FORMAT_DATETIME)
'Set data in date field single result view'
CustomKeywords.'actions.Common.setText_Date'(findTestObject('Page_WMI_NEW/Object Tabout Event/Radio List Event/tab_SingleResultView/input_DateField_Required'), inputValue)

'Verify Integer field should be visible'
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/tab_SingleResultView/input_Integer Field (Visible)_'))

'Verify String filed should be with back ground color Red '
CustomKeywords.'actions.Common.verifyCssValue'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/tab_SingleResultView/input_StringField_ReferenceObject'), 'background-color','rgba(255, 0, 0, 1)')

'Set Text in String Field to Verify Font'
CustomKeywords.'actions.Common.setTextAndSave'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/tab_SingleResultView/input_StringField_ReferenceObject'), inputValue)

'Get Font of String Field'
String actualfont= CustomKeywords.'actions.Common.getCssValue'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/tab_SingleResultView/input_StringField_ReferenceObject'),'font-weight')

'Verify String filed should be with Font Bold'
WebUI.verifyMatch(actualfont,'700',false)

'Save WMI'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/span_Save'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Close WMI'
CustomKeywords.'actions.Window.clickElementAndWaitForWindowClose'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/span_Close Window'),GlobalVariable.G_LongTimeout)

'Switch to parent window'
WebUI.switchToWindowIndex(0)

'Open document from recents grid'
CustomKeywords.'actions.Common.openDocumentFromRecentGrid'(1)

'Wait for WMI to load'
WebUI.waitForElementVisible(findTestObject('Page_WMI_NEW/Object Tabout Event/Radio List Event/input_Value1_MasterObject'), GlobalVariable.G_LongTimeout)

'Verify Radio1 is selected'
WebUI.verifyElementChecked(findTestObject('Page_WMI_NEW/Object Tabout Event/Radio List Event/input_Value1_MasterObject'), GlobalVariable.G_LongTimeout)

'Verify Integer field should be visible'
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/input_Integer Field (Visible)_'))

'Verify String filed should be with back ground color Red '
CustomKeywords.'actions.Common.verifyCssValue'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/input_String Field (Style)_efo'), 'background-color','rgba(255, 0, 0, 1)')

'Verify value in Date field'
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI_NEW/Object Tabout Event/Radio List Event/input_Date Field (Required)_ef'), 'value', inputValue, GlobalVariable.G_LongTimeout)

'Verify value in String field'
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI_NEW/Object Tabout Event/Radio List Event/input_String Field (Style)_efo'), 'value', inputValue, GlobalVariable.G_LongTimeout)

'Verify String filed should be with Font Bold'
String actualfontAfter= CustomKeywords.'actions.Common.getCssValue'(findTestObject('Page_WMI_NEW/Object Tabout Event/Radio List Event/input_String Field (Style)_efo'),'font-weight')
WebUI.verifyMatch(actualfontAfter,'700',false)