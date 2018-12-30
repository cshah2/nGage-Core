import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

'Login into application'
CustomKeywords.'actions.Common.login'()

'Click on Global New button'
WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))

'Select Document class and Document Type'
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'('Reference Object Feature', 'Reference Object InlineNew')

'Click on OK Button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))
WebUI.switchToWindowTitle('(Doc ID: NEW )')
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Click on tab "2)InlineNew with drag-drop functionality"'
WebUI.click(findTestObject('Page_WMI_NEW/Reference_Object_Inline/tab2_InlineNew with drag-dro'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Verify headertitle is "2)InlineNew with drag-drop functionality"'
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Reference_Object_Inline/span_tab2_title'))
WebUI.verifyMatch(WebUI.getText(findTestObject('Page_WMI_NEW/Reference_Object_Inline/span_tab2_title')).trim(), '2)InlineNew with drag-drop functionality', false)

'Save Value of BM String from first row'
String BMStringValue = WebUI.getText(findTestObject('Page_WMI_NEW/Reference_Object_Inline/Grid2_firstRow_BMStringColumn')).trim()
println "BM String value for first row in grid is : "+BMStringValue

'Click on first row'
WebUI.click(findTestObject('Page_WMI_NEW/Reference_Object_Inline/Grid2_firstRow_BMStringColumn'))
CustomKeywords.'actions.Common.waitForTabLoading'(findTestObject('Page_WMI_NEW/Reference_Object_Inline/iframe_ContentPlaceHolder1_iPa'), GlobalVariable.G_LongTimeout)

'Validate Values in BM String and File Upload'
WebUI.waitForElementVisible(findTestObject('Page_WMI_NEW/Reference_Object_Inline/input_tab2_BMString'), GlobalVariable.G_LongTimeout)

String inputFieldValue = WebUI.getAttribute(findTestObject('Page_WMI_NEW/Reference_Object_Inline/input_tab2_BMString'), 'value')
WebUI.verifyMatch(inputFieldValue, BMStringValue, false)