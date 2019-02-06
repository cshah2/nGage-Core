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
import internal.GlobalVariable as GlobalVariable

'Login Into Application'
CustomKeywords.'actions.Common.login'()

//No. 1
'Select Doc Class as "Object Tab Out Events" and Doc type as "DoNotSetValueOnLoad and SetFocus Event" from the dropdowns and click on OK button'
WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'('Object Tabout Events', 'DoNotSetValueOnLoad and SetFocus Event')
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

'Switch to new window'
WebUI.switchToWindowIndex(1)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Click on Save button'
WebUI.click(findTestObject('Page_WMI_NEW/Object Tabout Event/DoNotSetValueOnLoad SetFocus Event/InlineView/span_Save'))

'Click on Close Window button'
WebUI.click(findTestObject('Page_WMI_NEW/Object Tabout Event/DoNotSetValueOnLoad SetFocus Event/InlineView/span_Close Window'))

'Switch to main window'
WebUI.switchToWindowIndex(0)

//No. 2
'Select Doc Class as "Object Tab Out Events" and Doc type as "DoNotSetValueOnLoad and SetFocus Event" from the dropdowns and click on OK button'
WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'('Object Tabout Events', 'DoNotSetValueOnLoad and SetFocus Event')
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

'Switch to new window'
WebUI.switchToWindowIndex(1)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Click on Save button'
WebUI.click(findTestObject('Page_WMI_NEW/Object Tabout Event/DoNotSetValueOnLoad SetFocus Event/InlineView/span_Save'))

'Click on Close Window button'
WebUI.click(findTestObject('Page_WMI_NEW/Object Tabout Event/DoNotSetValueOnLoad SetFocus Event/InlineView/span_Close Window'))

'Switch to main window'
WebUI.switchToWindowIndex(0)

'Click on Recent Document'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('HOME', 'Recent Documents')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/iframe_iframe_103'))

'Sort Record in grid by DocID Descending'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Home/div_Doc ID'))
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Home/div_Doc ID'))

'Open Document'
int colNo_DocID = CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'), 'Doc ID')
CustomKeywords.'actions.Table.clickCell'(findTestObject('Page_nGage_Dashboard/Home/table_MyDocumentResults'), 2, colNo_DocID)

'Switch to WMI Window'
WebUI.switchToWindowIndex(1)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Verify the tabs SingleresultView and inlineView, click on InlineView tab'
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DoNotSetValueOnLoad SetFocus Event/InlineView/a_SingleResultView'))
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DoNotSetValueOnLoad SetFocus Event/InlineView/a_InlineView'))

WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DoNotSetValueOnLoad SetFocus Event/InlineView/a_InlineView'))

'Verify the reference grid with documents in grid'
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DoNotSetValueOnLoad SetFocus Event/InlineView/cell_DocID'))

'Click and open doc with doc type name "Donotsetvalueonload and setfocus Event"'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DoNotSetValueOnLoad SetFocus Event/InlineView/cell_DocID'))

'Inline document should get opened with save and button'
CustomKeywords.'actions.Common.waitForTabLoading'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DoNotSetValueOnLoad SetFocus Event/InlineView/iframe_Close Window_ContentPla'), GlobalVariable.G_LongTimeout)

'Verify the fields reference object checkbox control (checkbox), String field (text box with view check box is un-checked) and currency field text box.'
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DoNotSetValueOnLoad SetFocus Event/InlineView/input_ReferenceObjectCheckBox'))
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DoNotSetValueOnLoad SetFocus Event/InlineView/input_StringField'))
WebUI.verifyElementNotChecked(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DoNotSetValueOnLoad SetFocus Event/InlineView/input_StringField'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DoNotSetValueOnLoad SetFocus Event/InlineView/input_CurrencyField'))

'Verify that reference object checkbox control (checkbox) is unchecked'
WebUI.verifyElementNotChecked(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DoNotSetValueOnLoad SetFocus Event/InlineView/input_ReferenceObjectCheckBox'), GlobalVariable.G_LongTimeout)

'String field (text box with view check box is un-checked)'
String stringField = WebUI.getAttribute(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DoNotSetValueOnLoad SetFocus Event/InlineView/input_StringField'), 'value')
WebUI.verifyMatch('Checkbox is unchecked', stringField, false)
 
'No cursor control in currency field text box.'
CustomKeywords.'actions.Common.verifyElementNotHasFocus'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DoNotSetValueOnLoad SetFocus Event/InlineView/input_CurrencyField'))