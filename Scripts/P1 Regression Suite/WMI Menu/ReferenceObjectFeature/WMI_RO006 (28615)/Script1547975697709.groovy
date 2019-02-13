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

'Click on the tab-2) InlineContentView-inlineresultview(true) '
WebUI.click(findTestObject('Page_WMI_NEW/Reference_Object_Feature/Inline_Content_View/a_2) InlineContentView-inliner'))

'Verify tab 2 is loaded'
WebUI.waitForElementPresent(findTestObject('Page_WMI_NEW/Reference_Object_Feature/Inline_Content_View/tab_Inlineresultview(false)/tab_2Title'), GlobalVariable.G_LongTimeout)

'Click on PDF icon'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Content_View/tab_Inlineresultview(false)/doc_Icon'))

'Switch to new Window'
WebUI.switchToWindowIndex(2)

'Wait for page to load'
WebUI.waitForElementVisible(findTestObject('Page_WMI_NEW/Reference_Object_Feature/Inline_Content_View/tab_Inlineresultview(false)/newWindow_BusinessModelView'), GlobalVariable.G_LongTimeout)

CustomKeywords.'actions.Window.verifyOpenWindowCount'(3)

'Click on Close button to close the PDF window'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Content_View/tab_Inlineresultview(false)/newWindow_Close Window'))

'Switch to Parent Window'
WebUI.switchToWindowIndex(1)

'Wait for page load'
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Verify the PDF window is closed'
CustomKeywords.'actions.Window.verifyOpenWindowCount'(2)
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Content_View/a_2) InlineContentView-inliner'))

'Click on tab 2'
WebUI.click(findTestObject('Page_WMI_NEW/Reference_Object_Feature/Inline_Content_View/a_2) InlineContentView-inliner'))

'Click on any of the part of the doc in the reference grid. other than PDF icon.'
CustomKeywords.'actions.Table.clickCell'(findTestObject('Page_WMI_NEW/Reference_Object_Feature/Inline_Content_View/tab_Inlineresultview(false)/table_BMStringTab2'), 1, 3)
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)

'Verify the document is opening'
WebUI.switchToWindowIndex(2)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_WMI_NEW/Reference_Object_Feature/Inline_Content_View/tab_Inlineresultview(false)/iframe_Close Window_ContentPla'))
WebUI.click(findTestObject('Page_WMI_NEW/Reference_Object_Feature/Inline_Content_View/a_2) InlineContentView-inliner'))
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Reference_Object_Feature/Inline_Content_View/tab_Inlineresultview(false)/span_Information'))

'Close the window'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Content_View/span_Close Window'))