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

//Create Document 1
'Click on New button'
WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))

'Select Doc Class as "Object Tab Out Events" and Doc type as "checkbox list Event" from the dropdowns and click on OK button'
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'('Object Tabout Events', 'Checkbox List Event')
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

'Switch to new window'
WebUI.switchToWindowIndex(1)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Click on Save'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Result_View/span_Save'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'close WMI'
CustomKeywords.'actions.Window.clickElementAndWaitForWindowClose'(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Result_View/span_Close Window'), GlobalVariable.G_LongTimeout)

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
int rowNo = 1
CustomKeywords.'actions.Table.clickCell'(findTestObject('Page_nGage_Dashboard/Home/table_MyDocumentResults'), rowNo, 5)

'Switch to WMI Window'
WebUI.switchToWindowIndex(1)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Wait for Single Result view to load'
WebUI.waitForElementPresent(findTestObject('Page_WMI_NEW/Object Tabout Event/CheckboxListEvent/chkbox1_ReferenceObjectSelectOption'), GlobalVariable.G_LongTimeout)

'Scroll to element'
WebUI.scrollToElement(findTestObject('Page_WMI_NEW/Object Tabout Event/CheckboxListEvent/chkbox1_ReferenceObjectSelectOption'), GlobalVariable.G_LongTimeout)

'Select checkbox option 1 in Single Result View'
WebUI.check(findTestObject('Page_WMI_NEW/Object Tabout Event/CheckboxListEvent/chkbox1_ReferenceObjectSelectOption'))
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)

'Verify value in input field'
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI_NEW/Object Tabout Event/CheckboxListEvent/input_StringField_ReferenceObject'), 'value', 'You selected Option 1', GlobalVariable.G_LongTimeout)

'Verify drop down does not contains option'
WebUI.verifyOptionNotPresentByLabel(findTestObject('Page_WMI_NEW/Object Tabout Event/CheckboxListEvent/select_LookupField_ReferenceObject'), 'Reference Object ImportMode Interactive', false, GlobalVariable.G_LongTimeout)