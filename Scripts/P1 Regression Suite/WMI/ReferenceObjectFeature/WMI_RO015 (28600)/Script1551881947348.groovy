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

'Click on Global New button'
WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))

'Create a new Refrence Object Feature Document'
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'('Reference Object Feature', 'Reference Object ImportMode Autocreate')
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

'Switch to WMI page'
WebUI.switchToWindowIndex(1)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Wait for WMI to load'
WebUI.waitForElementVisible(findTestObject('Page_WMI_NEW/Reference_Object_Feature/ImportMode_AutoCreate/lbl_Information'), GlobalVariable.G_LongTimeout)

'Verify Information text of WMI'
String expText = 'This WMI imparts Reference Object features for ImportMode Autocreate'
WebUI.verifyElementText(findTestObject('Page_WMI_NEW/Reference_Object_Feature/ImportMode_AutoCreate/lbl_Information'), expText)

'Save WMI'
WebUI.click(findTestObject('Page_WMI_NEW/Reference_Object_Feature/ImportMode_Interactive/btn_Save'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Close WMI'
CustomKeywords.'actions.Window.clickElementAndWaitForWindowClose'(findTestObject('Page_WMI_NEW/Reference_Object_Feature/ImportMode_Interactive/btn_CloseWindow'), GlobalVariable.G_LongTimeout)

'Switch to parent window'
WebUI.switchToWindowIndex(0)

'Close Global new popup dialog'
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/span_ui-button-icon-primary ui'))

'Open first document from recent grid'
CustomKeywords.'actions.Common.openDocumentFromRecentGrid'(1)

'Wait for WMI to load'
WebUI.waitForElementVisible(findTestObject('Page_WMI_NEW/Reference_Object_Feature/ImportMode_AutoCreate/lbl_Information'), GlobalVariable.G_LongTimeout)

'Verify Information text of WMI'
WebUI.verifyElementText(findTestObject('Page_WMI_NEW/Reference_Object_Feature/ImportMode_AutoCreate/lbl_Information'), expText)

'Click on tab 3) Autocreate'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/ImportMode_AutoCreate/span_3) AUTOCREATE'))

'Peform mouse over on New button'
WebUI.mouseOver(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/ImportMode_AutoCreate/tab3)AutoCreate/span_New'))
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/ImportMode_AutoCreate/tab3)AutoCreate/a_Render All Field Types'), GlobalVariable.G_LongTimeout)

'verify total document type list'
CustomKeywords.'actions.Common.verifyElementsCount'(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/ImportMode_AutoCreate/tab3)AutoCreate/list_NewButton'), 95)

'Click on Redner All Field Types'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/ImportMode_AutoCreate/tab3)AutoCreate/a_Render All Field Types'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Close WMI'
CustomKeywords.'actions.Window.clickElementAndWaitForWindowClose'(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/ImportMode_AutoCreate/span_Close Window'), GlobalVariable.G_LongTimeout)

'switch to main window'
WebUI.switchToWindowIndex(0)

'Open First document from recent grid'
CustomKeywords.'actions.Common.openDocumentFromRecentGrid'(1)

'Wait for WMI to load'
WebUI.waitForElementVisible(findTestObject('Page_WMI/Master_Object/lbl_Information'), GlobalVariable.G_LongTimeout)

'Verify Information text of WMI'
String expText2 = 'This WMI imparts - Renders all basic type of single value fields'
WebUI.verifyElementText(findTestObject('Page_WMI/Master_Object/lbl_Information'), expText2)