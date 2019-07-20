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

import common.DocClass
import common.DocType
import internal.GlobalVariable as GlobalVariable

'Login Into Application'
CustomKeywords.'actions.Common.login'()

'Click on Global new button'
WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))

'Select DocType Label Event'
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'(DocClass.OBJECT_TABOUT_EVENT.toString(), DocType.LABEL_EVENT.toString())
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

'Switch to WMI'
WebUI.switchToWindowIndex(1)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Wait for page to load'
WebUI.waitForElementVisible(findTestObject('Page_WMI_NEW/Object Tabout Event/Label Event/lbl_Control1'), GlobalVariable.G_LongTimeout)

'Verify value in Label Control 1'
WebUI.verifyElementText(findTestObject('Page_WMI_NEW/Object Tabout Event/Label Event/lbl_Control1'), 'Condition1')

'Verify value in Label Control 2'
WebUI.verifyElementText(findTestObject('Page_WMI_NEW/Object Tabout Event/Label Event/lbl_Control2'), 'Condition2')

'Verify background color or currency field'
CustomKeywords.'actions.Common.verifyCssValue'(findTestObject('Page_WMI_NEW/Object Tabout Event/Label Event/input_CurrencyField'), 'background-color', 'rgba(255, 0, 0, 1)')

'Verify backgound color of float field'
CustomKeywords.'actions.Common.verifyCssValue'(findTestObject('Page_WMI_NEW/Object Tabout Event/Label Event/input_FloatField'), 'background-color', 'rgba(255, 255, 255, 1)')

'Clear Data from Integer field'
WebUI.clearText(findTestObject('Page_WMI_NEW/Object Tabout Event/Label Event/input_IntegerField'))

'Click on Save Button'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Result_View/span_Save'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_WMI_NEW/Object Tabout Event/Label Event/iframe_Close Window_ContentPla'))

'Verify top error message is displayed'
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Object Tabout Event/Label Event/lbl_TopErrorMessage'))

'Verify floating error message is displayed'
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Object Tabout Event/Label Event/lbl_IntegerField_Required'))

'Enter data in numeric field'
String numericValue = '1000'
WebUI.setText(findTestObject('Page_WMI_NEW/Object Tabout Event/Label Event/input_IntegerField'), numericValue)

'Enter data in String field'
String stringValue = 'Chintan Shah'
WebUI.setText(findTestObject('Page_WMI_NEW/Object Tabout Event/Label Event/input_StringField'), stringValue)

'Click on Save button'
WebUI.click(findTestObject('Page_WMI_NEW/Object Tabout Event/Label Event/btn_Save'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Click on Close Window button'
CustomKeywords.'actions.Window.clickElementAndWaitForWindowClose'(findTestObject('Page_WMI_NEW/Object Tabout Event/Label Event/btn_CloseWindow'), GlobalVariable.G_LongTimeout)

'Switch to main window'
WebUI.switchToWindowIndex(0)

'Close Global new popup dialog'
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/span_ui-button-icon-primary ui'))

'Open first document from recent grid'
CustomKeywords.'actions.Common.openDocumentFromRecentGrid'(1)

'Wait for page to load'
WebUI.waitForElementVisible(findTestObject('Page_WMI_NEW/Object Tabout Event/Label Event/lbl_Control1'), GlobalVariable.G_LongTimeout)

'Verify value in Label Control 1'
WebUI.verifyElementText(findTestObject('Page_WMI_NEW/Object Tabout Event/Label Event/lbl_Control1'), 'Condition1')

'Verify value in Label Control 2'
WebUI.verifyElementText(findTestObject('Page_WMI_NEW/Object Tabout Event/Label Event/lbl_Control2'), 'Condition2')

'Verify background color or currency field'
CustomKeywords.'actions.Common.verifyCssValue'(findTestObject('Page_WMI_NEW/Object Tabout Event/Label Event/input_CurrencyField'), 'background-color', 'rgba(255, 0, 0, 1)')

'Verify backgound color of float field'
CustomKeywords.'actions.Common.verifyCssValue'(findTestObject('Page_WMI_NEW/Object Tabout Event/Label Event/input_FloatField'), 'background-color', 'rgba(255, 255, 255, 1)')

'Verify data in Integer field'
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI_NEW/Object Tabout Event/Label Event/input_IntegerField'), 'Value', numericValue, GlobalVariable.G_LongTimeout)

'Verify data in String field'
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI_NEW/Object Tabout Event/Label Event/input_StringField'), 'Value', stringValue, GlobalVariable.G_LongTimeout)