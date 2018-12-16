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

'Verify default header title is "InlineNew"'
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Reference_Object_Inline/span_tab1_title'))
WebUI.verifyMatch(WebUI.getText(findTestObject('Page_WMI_NEW/Reference_Object_Inline/span_tab1_title')).trim(), '1) InlineNew', false)

'Click on tab "2)InlineNew with drag-drop functionality"'
WebUI.click(findTestObject('Page_WMI_NEW/Reference_Object_Inline/tab2_InlineNew with drag-dro'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Verify headertitle is "2)InlineNew with drag-drop functionality"'
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Reference_Object_Inline/span_tab2_title'))
WebUI.verifyMatch(WebUI.getText(findTestObject('Page_WMI_NEW/Reference_Object_Inline/span_tab2_title')).trim(), '2)InlineNew with drag-drop functionality', false)

'Click on tab "3)NewDoc open in dialogue with drag-drop functionality"'
WebUI.click(findTestObject('Page_WMI_NEW/Reference_Object_Inline/tab3_NewDoc open in dialogue'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Verify headertitle is "3)NewDoc open in dialogue with drag-drop functionality"'
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Reference_Object_Inline/span_tab3_title'))
WebUI.verifyMatch(WebUI.getText(findTestObject('Page_WMI_NEW/Reference_Object_Inline/span_tab3_title')).trim(), '3)NewDoc open in dialogue with drag-drop functionality', false)

'Click on tab "4)InlineNew with required content and drag-drop functionality"'
WebUI.click(findTestObject('Page_WMI_NEW/Reference_Object_Inline/tab4_InlineNew with required'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Verify headertitle is "4)InlineNew with required content and drag-drop functionality"'
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Reference_Object_Inline/span_tab4_title'))
WebUI.verifyMatch(WebUI.getText(findTestObject('Page_WMI_NEW/Reference_Object_Inline/span_tab4_title')).trim(), '4)InlineNew with required content and drag-drop functionality', false)

'Click on tab "5)NewDoc open in dialogue with required content and drag-drop functionality"'
WebUI.click(findTestObject('Page_WMI_NEW/Reference_Object_Inline/tab5_NewDoc open in dialogue'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Verify headertitle is "5)NewDoc open in dialogue with required content and drag-drop functionality"'
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Reference_Object_Inline/span_tab5_title'))
WebUI.verifyMatch(WebUI.getText(findTestObject('Page_WMI_NEW/Reference_Object_Inline/span_tab5_title')).trim(), '5)NewDoc open in dialogue with required content and drag-drop functionality', false)

'Click on tab "6)InlineNew with required content and hidecontentupload=true"'
WebUI.click(findTestObject('Page_WMI_NEW/Reference_Object_Inline/tab6_InlineNew with required'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Verify headertitle is "6)InlineNew with required content and hidecontentupload=true"'
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Reference_Object_Inline/span_tab6_title'))
WebUI.verifyMatch(WebUI.getText(findTestObject('Page_WMI_NEW/Reference_Object_Inline/span_tab6_title')).trim(), '6)InlineNew with required content and hidecontentupload=true', false)

'Click on tab "tab7_InlineNew with multiple"'
WebUI.click(findTestObject('Page_WMI_NEW/Reference_Object_Inline/tab7_InlineNew with multiple'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Verify headertitle is "7)InlineNew with multiple doctype list"'
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Reference_Object_Inline/span_tab7_title'))
WebUI.verifyMatch(WebUI.getText(findTestObject('Page_WMI_NEW/Reference_Object_Inline/span_tab7_title')).trim(), '7)InlineNew with multiple doctype list', false)
WebUI.verifyElementText(findTestObject('Page_WMI_NEW/Reference_Object_Inline/span_tab7_title'), '7)InlineNew with multiple doctype list')