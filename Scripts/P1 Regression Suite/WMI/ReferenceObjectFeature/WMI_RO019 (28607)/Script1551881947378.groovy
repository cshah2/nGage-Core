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
import utils.DateUtil

'Login Into Application'
CustomKeywords.'actions.Common.login'()

'Click on Global New button'
WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))

'Create a new Refrence Object Feature Document'
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'('Reference Object Feature', 'Reference Object ExtAppURL')
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

'Switch to WMI Page'
WebUI.switchToWindowIndex(1)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Wait for page to load'
WebUI.waitForElementVisible(findTestObject('Page_WMI_NEW/Reference_Object_Feature/ExtAppURL/lbl_Information'), GlobalVariable.G_LongTimeout)

'Verify Information Text of WMI'
String expText = 'This WMI imparts Reference Object features for ExtAppURL'
WebUI.verifyElementText(findTestObject('Page_WMI_NEW/Reference_Object_Feature/ExtAppURL/lbl_Information'), expText)

'Verify the various tabs for Extrappurl displayed'
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/ExtAppURL/tab_1_ExtAppURL/span_Business Model View - Ref'),GlobalVariable.G_LongTimeout )
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/ExtAppURL/tab_1_ExtAppURL/span_This WMI imparts Referenc'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/ExtAppURL/tab_2_ExtAppURL/span_2) Extappurl'), GlobalVariable.G_LongTimeout)

'Save WMI'
WebUI.click(findTestObject('Page_WMI_NEW/Reference_Object_Feature/ExtAppURL/btn_Save'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Close WMI'
CustomKeywords.'actions.Window.clickElementAndWaitForWindowClose'(findTestObject('Page_WMI_NEW/Reference_Object_Feature/ExtAppURL/btn_CloseWindow'), GlobalVariable.G_LongTimeout)

'Switch to parent window'
WebUI.switchToWindowIndex(0)

'Close "create new" popup dialog'
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/span_ui-button-icon-primary ui'))

'Open first document from Recent Grid'
CustomKeywords.'actions.Common.openDocumentFromRecentGrid'(1)

'Wait for page to load'
WebUI.waitForElementVisible(findTestObject('Page_WMI_NEW/Reference_Object_Feature/ExtAppURL/lbl_Information'), GlobalVariable.G_LongTimeout)

'Verify Information Text of WMI'
WebUI.verifyElementText(findTestObject('Page_WMI_NEW/Reference_Object_Feature/ExtAppURL/lbl_Information'), expText)

'click on tab 3) ExtAppURL'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/ExtAppURL/tab_3_ExtAppURL/span_3) Extappurl'))

'Peform Mouse over on New button'
WebUI.mouseOver(findTestObject('Page_WMI_NEW/Reference_Object_Feature/ExtAppURL/tab_3_ExtAppURL/div_New'))
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/ExtAppURL/tab_3_ExtAppURL/a_RenderAsLabel'),GlobalVariable.G_LongTimeout)

'Verify count of options displayed in menu'
CustomKeywords.'actions.Common.verifyElementsCount'(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/ExtAppURL/tab_3_ExtAppURL/list_New'), 95)

'Click on option Render As Label'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/ExtAppURL/tab_3_ExtAppURL/a_RenderAsLabel'))
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)

'Switch to new popup window'
WebUI.switchToWindowIndex(2)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Verify page url of new window contains google'
WebUI.verifyMatch(WebUI.getUrl(), '.*google.*', true)

'Close window'
WebUI.closeWindowIndex(2)

'Switch to WMI'
WebUI.switchToWindowIndex(1)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Wait for Inline doc to load'
WebUI.waitForElementVisible(findTestObject('Page_WMI_NEW/Reference_Object_Feature/ExtAppURL/tab_3_ExtAppURL/lbl_Information_InlineDoc'), GlobalVariable.G_LongTimeout)

'Verify infomation text of inline doc'
String expText2 = 'This WMI imparts - Control renderas Label'
WebUI.verifyElementText(findTestObject('Page_WMI_NEW/Reference_Object_Feature/ExtAppURL/tab_3_ExtAppURL/lbl_Information_InlineDoc'), expText2)

'Click on Save button'
WebUI.click(findTestObject('Page_WMI_NEW/Reference_Object_Feature/ExtAppURL/tab_3_ExtAppURL/btn_Save'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Close WMI'
CustomKeywords.'actions.Window.clickElementAndWaitForWindowClose'(findTestObject('Page_WMI_NEW/Reference_Object_Feature/ExtAppURL/btn_CloseWindow'), GlobalVariable.G_LongTimeout)

'Switch to parent window'
WebUI.switchToWindowIndex(0)

'Open first document from Recent Grid'
CustomKeywords.'actions.Common.openDocumentFromRecentGrid'(1)

'Wait for page to load'
WebUI.waitForElementVisible(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_Label/span_Information'), GlobalVariable.G_LongTimeout)

'Verify Information Text of WMI'
WebUI.verifyElementText(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_Label/span_Information'), expText2)