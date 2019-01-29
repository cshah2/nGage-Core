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

'Create a new Refrence Object Feature Document'
WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'('Reference Object Feature', 'Reference Object InlineContentView')
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

WebUI.switchToWindowTitle('(Doc ID: NEW )')
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Click on Save Button'
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Content_View/iframe_Close Window_ContentPla'))
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Content_View/span_Save'))

'Click on Close window'
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Content_View/span_Close Window'))

'Switch to main window'
WebUI.switchToWindowIndex(0)

'Create a new Refrence Object Feature Document'
WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'('Reference Object Feature', 'Reference Object InlineContentView')
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

WebUI.switchToWindowTitle('(Doc ID: NEW )')
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Verify two tabs 1) InlineContentView-inlineresultview(true) and 2) InlineContentView-inlineresultview(false)'
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Content_View/a_1) InlineContentView-inliner'))
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Content_View/a_2) InlineContentView-inliner'))

'Click on the tab-1) InlineContentView-inlineresultview(true) '
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Content_View/a_1) InlineContentView-inliner'))

'Verify tab 1 is loaded'
WebUI.waitForElementPresent(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Content_View/tab_Inlineresultview(true)/tab_1Title'), GlobalVariable.G_LongTimeout)

'Click on Document icon from 1st row'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Content_View/tab_Inlineresultview(true)/doc_Icon'))

'Wait for page to load'
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Content_View/tab_Inlineresultview(true)/iframe_Close Window_ContentPla'), GlobalVariable.G_LongTimeout)

//'Click on the record from reference table'
//WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Content_View/tab_Inlineresultview(true)/cell_BMStringTab1_Table'))

'Verify the content document is opening'
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Content_View/tab_Inlineresultview(true)/contentDocument'),GlobalVariable.G_LongTimeout)

'Close the window'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Content_View/span_Close Window'))