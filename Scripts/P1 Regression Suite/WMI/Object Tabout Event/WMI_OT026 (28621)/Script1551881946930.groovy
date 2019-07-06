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

'Click on New button'
WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))

//Create Document 1
'Select Doc Class as "Object Tab Out Events" and Doc type as "checkbox list Event" from the dropdowns and click on OK button'
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'('Object Tabout Events', 'Checkbox List Event')
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

'Switch to new window'
WebUI.switchToWindowIndex(1)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Click on Save button'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Result_View/span_Save'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Click on Close Window button'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Result_View/span_Close Window'))

'Switch to main window'
WebUI.switchToWindowIndex(0)

//Create Document 2
'Select Doc Class as "Object Tab Out Events" and Doc type as "checkbox list Event" from the dropdowns and click on OK button'
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'('Object Tabout Events', 'Checkbox List Event')
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

'Switch to new window'
WebUI.switchToWindowIndex(1)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Click on Save button'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Result_View/span_Save'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Click on Close Window button'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Result_View/span_Close Window'))

'Switch to main window'
WebUI.switchToWindowIndex(0)

'Close popup dialog for create new document'
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/span_ui-button-icon-primary ui'))

'Click on Recent Document'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('HOME', 'Recent Documents')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/iframe_iframe_103'))

'Sort Record in grid by DocID Descending'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'), 'Doc ID')
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'), 'Doc ID')

'Open Document'
int rowNo = 2
int colNo_DocID = CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'), 'Doc ID')
CustomKeywords.'actions.Table.clickCell'(findTestObject('Page_nGage_Dashboard/Home/table_MyDocumentResults'), rowNo, colNo_DocID)

'Switch to WMI Window'
WebUI.switchToWindowIndex(1)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Click on Inline View Tab'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/CheckboxListEvent/tab_InlineView'))

'Click twice on DocID column header to sort the doc'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/CheckboxListEvent/td_(Header)DocID'))
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/CheckboxListEvent/td_(Header)DocID'))
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)

'Click on First row to open the doc'
int inlineRowNo = 1
CustomKeywords.'actions.Table.clickCell'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/CheckboxListEvent/table_Grid'), inlineRowNo, 4)
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)

'Select checkbox value 2'
WebUI.check(findTestObject('Page_WMI_NEW/Object Tabout Event/CheckboxListEvent/checkbox2_InlineTab'))
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)

'Scroll to Inline View'
WebUI.scrollToElement(findTestObject('Page_WMI_NEW/Object Tabout Event/CheckboxListEvent/select_LookupField_InlineTab'), GlobalVariable.G_LongTimeout)

'verify textbox value'
WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/CheckboxListEvent/input_StringField_InlineView'), 'value', 'You selected Option 2', GlobalVariable.G_LongTimeout)

'Verify drop down does not contains option'
WebUI.verifyOptionNotPresentByLabel(findTestObject('Page_WMI_NEW/Object Tabout Event/CheckboxListEvent/select_LookupField_InlineTab'), 'Render As Label', false, GlobalVariable.G_LongTimeout)

'Click on Save button in Inline tab'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/CheckboxListEvent/save_InlineTab'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_WMI_NEW/Object Tabout Event/CheckboxListEvent/iframe_Close Window_ContentPla'))

'Verify save operation completed'
WebUI.verifyElementNotVisible(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/CheckboxListEvent/save_InlineTab'))

'Click on Close Window button'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Result_View/span_Close Window'))

'Switch to main window'
WebUI.switchToWindowIndex(0)

'Click on Recent Document'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('HOME', 'Recent Documents')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/iframe_iframe_103'))

'Sort Record in grid by DocID Descending'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'), 'Doc ID')
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'), 'Doc ID')

'Open Document'
rowNo = 1
CustomKeywords.'actions.Table.clickCell'(findTestObject('Page_nGage_Dashboard/Home/table_MyDocumentResults'), rowNo, colNo_DocID)

'Switch to WMI Window'
WebUI.switchToWindowIndex(1)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Verify checkbox 2 is selected'
WebUI.verifyElementChecked(findTestObject('Page_WMI_NEW/Object Tabout Event/CheckboxListEvent/chkbox2_MasterObjectSelectOption'), GlobalVariable.G_LongTimeout)