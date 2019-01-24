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

'Select Doc Class as "Object Tab Out Events" and Doc type as "checkbox list Event" from the dropdowns and click on OK button'
WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'('Object Tabout Events', 'Checkbox List Event')
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

WebUI.switchToWindowTitle('(Doc ID: NEW )')
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Click on WMI Harness page'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Result_View/span_WMI Harness'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Result_View/iframe_ContentPlaceHolder1_iPage'))

'Click on Save button'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Result_View/span_Save'))

'Click on Close Window button'
CustomKeywords.'actions.Window.clickElementAndWaitForWindowClose'(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Result_View/span_Close Window'), GlobalVariable.G_LongTimeout)

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
CustomKeywords.'actions.Table.clickCell'(findTestObject('Page_nGage_Dashboard/Home/table_MyDocumentResults'), 1, colNo_DocID)

'Switch to WMI Window'
WebUI.switchToWindowIndex(1)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Click on Value 3 or Value 4 or Value 5 check box from refrence object'
WebUI.uncheck(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/CheckboxListEvent/chkbox1_ReferenceObjectSelectOption'))
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)

WebUI.check(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/CheckboxListEvent/chkbox3_ReferenceObjectSelectOption'))
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)

'String Field(Value Change) text box value should be change as You selected Option 2 '
String fieldValue = WebUI.getAttribute(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/CheckboxListEvent/input_StringField_ReferenceObject'), 'value')
println "Field value is "+fieldValue
WebUI.verifyMatch(fieldValue, 'You have selected other option', false)

'verify Lookup field(Override Lookup)dropdowns value should be change '
WebUI.verifyElementPresent(findTestObject('Page_WMI_NEW/Object Tabout Event/CheckboxListEvent/option_Lookup Field_Reference Object Import'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementPresent(findTestObject('Page_WMI_NEW/Object Tabout Event/CheckboxListEvent/option_Lookup Field_Reference Object Grid Features'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementPresent(findTestObject('Page_WMI_NEW/Object Tabout Event/CheckboxListEvent/option_Lookup Field_Reference Object InlineResultView'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementPresent(findTestObject('Page_WMI_NEW/Object Tabout Event/CheckboxListEvent/option_Lookup Field_Reference Object InlineNew'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementPresent(findTestObject('Page_WMI_NEW/Object Tabout Event/CheckboxListEvent/option_Lookup Field_Reference Object InlineContentView'), GlobalVariable.G_LongTimeout)