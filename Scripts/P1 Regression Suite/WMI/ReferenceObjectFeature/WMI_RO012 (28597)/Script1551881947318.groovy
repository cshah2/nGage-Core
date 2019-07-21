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
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

'Login Into Application'
CustomKeywords.'actions.Common.login'()

'Click on Global New button'
WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))

'Create a new Refrence Object Feature Document'
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'('Reference Object Feature', 'Reference Object ImportMode Interactive')
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

'Switch to WMI page'
WebUI.switchToWindowIndex(1)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Wait for page to load'
WebUI.waitForElementVisible(findTestObject('Page_WMI_NEW/Reference_Object_Feature/ImportMode_Interactive/lbl_Information'), GlobalVariable.G_LongTimeout)

'Verify information text'
String expText = 'This WMI imparts Reference Object features for ImportMode Interactive'
WebUI.verifyElementText(findTestObject('Page_WMI_NEW/Reference_Object_Feature/ImportMode_Interactive/lbl_Information'), expText)

'Save WMI'
WebUI.click(findTestObject('Page_WMI_NEW/Reference_Object_Feature/ImportMode_Interactive/btn_Save'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Close WMI'
CustomKeywords.'actions.Window.clickElementAndWaitForWindowClose'(findTestObject('Page_WMI_NEW/Reference_Object_Feature/ImportMode_Interactive/btn_CloseWindow'),GlobalVariable.G_LongTimeout)

'Switch to parent window'
WebUI.switchToWindowIndex(0)

'Close "create new" popup dialog'
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/span_ui-button-icon-primary ui'))

'Open first document from recent grid'
CustomKeywords.'actions.Common.openDocumentFromRecentGrid'(1)

'Wait for page to load'
WebUI.waitForElementVisible(findTestObject('Page_WMI_NEW/Reference_Object_Feature/ImportMode_Interactive/lbl_Information'), GlobalVariable.G_LongTimeout)

'Click on tab 4) Interactive'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/ImportMode_Interactive/tab4_Interactive/span_4) INTERACTIVE'))
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)

'Mouse hover On Dropdown New'
WebUI.mouseOver(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/ImportMode_Interactive/tab4_Interactive/span_New'))
WebUI.delay(2)

'Verify Options with filter="Include" in Dropdown'
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/ImportMode_Interactive/tab4_Interactive/a_Render As CheckBox'))
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/ImportMode_Interactive/tab4_Interactive/a_Render As Label'))

'Select from DropDown'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/ImportMode_Interactive/tab4_Interactive/a_Render As CheckBox'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Close WMI'
CustomKeywords.'actions.Window.clickElementAndWaitForWindowClose'(findTestObject('Page_WMI_NEW/Reference_Object_Feature/ImportMode_Interactive/btn_CloseWindow'), GlobalVariable.G_LongTimeout)

'Switch to parent window'
WebUI.switchToWindowIndex(0)

'Open first document from recent grid'
CustomKeywords.'actions.Common.openDocumentFromRecentGrid'(1)

'Verify Small Int checkbox is visible'
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_Checkbox/checkbox_SmallInt'))

'Verify Small Int checkbox is not checked'
WebUI.verifyElementNotChecked(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_Checkbox/checkbox_SmallInt'), GlobalVariable.G_LongTimeout)

'Verify String type checkbox is visible'
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_Checkbox/checkbox_String'))

'Verify String type checkbox is not checked'
WebUI.verifyElementNotChecked(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_Checkbox/checkbox_String'), GlobalVariable.G_LongTimeout)