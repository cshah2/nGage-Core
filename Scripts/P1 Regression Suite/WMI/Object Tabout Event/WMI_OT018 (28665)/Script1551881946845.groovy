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

'click on tab inline view'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/tab_InlineView/span_InlineView'))

'Sort DocID'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Textbox with Section Event/tab_InlineView/td_(Header)Doc ID'))
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Textbox with Section Event/tab_InlineView/td_(Header)Doc ID'))
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)

'Click On first Row From Reference Grid'
int inlineRowNo = 1
CustomKeywords.'actions.Table.clickCell'(findTestObject('Page_WMI_NEW/Object Tabout Event/Radio List Event/tab_InlineView/table_InlineResultView'), inlineRowNo, 5)
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)

'Verify document should be opened in Inline view'
CustomKeywords.'actions.Common.waitForElementVisible'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/tab_InlineView/input_Value1'), GlobalVariable.G_LongTimeout)

'Scroll to Inline tab section'
WebUI.scrollToElement(findTestObject('Page_WMI_NEW/Object Tabout Event/Radio List Event/tab_InlineView/input_String Field (Style)_efo'), GlobalVariable.G_LongTimeout)

'Click on Value 3 radio button from Refrence object'
WebUI.check(findTestObject('Page_WMI_NEW/Object Tabout Event/Radio List Event/tab_InlineView/input_Value3'))

'Wait for JQuery event to complete'
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)

'Clear Date field value'
WebUI.clearText(findTestObject('Page_WMI_NEW/Object Tabout Event/Radio List Event/tab_InlineView/input_Date Field (Required)_ef'))
WebUI.sendKeys(findTestObject('Page_WMI_NEW/Object Tabout Event/Radio List Event/tab_InlineView/input_Date Field (Required)_ef'), Keys.chord(Keys.TAB))

'Scroll to Inline tab section'
WebUI.scrollToElement(findTestObject('Page_WMI_NEW/Object Tabout Event/Radio List Event/tab_InlineView/input_String Field (Style)_efo'), GlobalVariable.G_LongTimeout)

'Verify Error message is not displayed for date field'
WebUI.verifyElementNotPresent(findTestObject('Page_WMI_NEW/Object Tabout Event/Radio List Event/tab_InlineView/td_Required'), GlobalVariable.G_LongTimeout)

'Verify Integer field should be visible'
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/tab_InlineView/input_Integer Field (Visible)_'),GlobalVariable.G_LongTimeout)

'Verify String filed should be with back ground color Blue'
CustomKeywords.'actions.Common.verifyCssValue'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/tab_InlineView/input_String Field (Style)_efo'),'background-color', 'rgba(0, 0, 255, 1)')

'Get Font of String Field'
String inputValue = 'Sanyogita'
WebUI.setText(findTestObject('Page_WMI_NEW/Object Tabout Event/Radio List Event/tab_InlineView/input_String Field (Style)_efo'), inputValue)

'Verify font-weight is Normal'
String actualfont= CustomKeywords.'actions.Common.getCssValue'(findTestObject('Page_WMI_NEW/Object Tabout Event/Radio List Event/tab_InlineView/input_String Field (Style)_efo'),'font-weight')

'Verify String filed should be with Font Normal'
WebUI.verifyMatch(actualfont,'400',false)

'Click on Save from Reference Object'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/tab_InlineView/input_Save'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Close Window'
CustomKeywords.'actions.Window.clickElementAndWaitForWindowClose'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/span_Close Window'),GlobalVariable.G_LongTimeout)

'Switch to parent window'
WebUI.switchToWindowIndex(0)

'Clear cookies and Login back into portal'
CustomKeywords.'actions.Common.login'()

'Open document from recents grid'
CustomKeywords.'actions.Common.openDocumentFromRecentGrid'(1)

'Wait for WMI to load'
WebUI.waitForElementVisible(findTestObject('Page_WMI_NEW/Object Tabout Event/Radio List Event/input_Value1_MasterObject'), GlobalVariable.G_LongTimeout)

'Verify Radio3 is selected'
WebUI.verifyElementChecked(findTestObject('Page_WMI_NEW/Object Tabout Event/Radio List Event/input_Value3_MasterObject'), GlobalVariable.G_LongTimeout)

'Verify Integer field should be visible'
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/input_Integer Field (Visible)_'))

'Verify String filed should be with back ground color Blue '
CustomKeywords.'actions.Common.verifyCssValue'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/input_String Field (Style)_efo'), 'background-color','rgba(0, 0, 255, 1)')

'Verify value in Date field'
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI_NEW/Object Tabout Event/Radio List Event/input_Date Field (Required)_ef'), 'value', '', GlobalVariable.G_LongTimeout)

'Verify value in String field'
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI_NEW/Object Tabout Event/Radio List Event/input_String Field (Style)_efo'), 'value', inputValue, GlobalVariable.G_LongTimeout)

'Verify String filed should be with Font Normal'
String actualfontAfter= CustomKeywords.'actions.Common.getCssValue'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/input_String Field (Style)_efo'),'font-weight')
WebUI.verifyMatch(actualfontAfter,'400',false)