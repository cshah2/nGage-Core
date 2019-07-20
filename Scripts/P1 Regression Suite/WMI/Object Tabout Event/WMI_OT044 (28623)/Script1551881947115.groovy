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

import common.DocClass
import common.DocType
import internal.GlobalVariable as GlobalVariable

TestObject masterSelect1 = findTestObject('Page_WMI_NEW/Object Tabout Event/Nested Lookup Event/select_Level1')
TestObject masterSelect2 = findTestObject('Page_WMI_NEW/Object Tabout Event/Nested Lookup Event/select_Level2')
TestObject masterSelect3 = findTestObject('Page_WMI_NEW/Object Tabout Event/Nested Lookup Event/select_Level3')

'Login Into Application'
CustomKeywords.'actions.Common.login'()

'Click on Global New button'
WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))

'select Doc Class as "Object Tabout Event " and Doc type as "Check Box event" from the dropdowns and click on OK button'
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'(DocClass.OBJECT_TABOUT_EVENT.toString(), DocType.NESTED_LOOKUP_EVENT.toString())
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

'Switch to WMI page'
WebUI.switchToWindowIndex(1)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Wait for WMI to load'
WebUI.waitForElementVisible(findTestObject('Page_WMI_NEW/Object Tabout Event/Nested Lookup Event/select_Level1'), GlobalVariable.G_LongTimeout)

'Select Value 1 from in first drop down'
WebUI.selectOptionByLabel(masterSelect1, 'Value 1', false)

'Wait for Java script option to complete'
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)

'Verify number of options present in drop down 2'
WebUI.verifyEqual(WebUI.getNumberOfTotalOption(masterSelect2), 6)

'Verify correct options are present in drop down 2'
WebUI.verifyOptionPresentByLabel(masterSelect2, 'Value 1', false, GlobalVariable.G_LongTimeout)
WebUI.verifyOptionPresentByLabel(masterSelect2, 'Value 2', false, GlobalVariable.G_LongTimeout)
WebUI.verifyOptionPresentByLabel(masterSelect2, 'Value 3', false, GlobalVariable.G_LongTimeout)
WebUI.verifyOptionPresentByLabel(masterSelect2, 'Value 4', false, GlobalVariable.G_LongTimeout)
WebUI.verifyOptionPresentByLabel(masterSelect2, 'Value 5', false, GlobalVariable.G_LongTimeout)

'Select Value 1 in drop down 2'
WebUI.selectOptionByLabel(masterSelect2, 'Value 1', false)

'Wait for Java script option to complete'
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)

'Verify number of options present in drop down 3'
WebUI.verifyEqual(WebUI.getNumberOfTotalOption(masterSelect3), 3)

'Verify correct options are present in drop down 3'
WebUI.verifyOptionPresentByLabel(masterSelect3, 'True', false, GlobalVariable.G_LongTimeout)
WebUI.verifyOptionPresentByLabel(masterSelect3, 'False', false, GlobalVariable.G_LongTimeout)

'Select True in drop down 3'
WebUI.selectOptionByLabel(masterSelect3, 'True', false)

'Save WMI'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/CheckBox Event/span_Save'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Close WMI'
CustomKeywords.'actions.Window.clickElementAndWaitForWindowClose'(findTestObject('Page_WMI_NEW/Object Tabout Event/Nested Lookup Event/btn_CloseWindow'), GlobalVariable.G_LongTimeout)

'Switch to parent window'
WebUI.switchToWindowIndex(0)

'Close "create new" popup dialog'
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/span_ui-button-icon-primary ui'))

'Open first document from recent grid'
CustomKeywords.'actions.Common.openDocumentFromRecentGrid'(1)

'Wait for WMI to load'
WebUI.waitForElementVisible(findTestObject('Page_WMI_NEW/Object Tabout Event/Nested Lookup Event/select_Level1'), GlobalVariable.G_LongTimeout)

'Verify option selected in Drop down 1'
WebUI.verifyOptionSelectedByLabel(masterSelect1, 'Value 1', false, GlobalVariable.G_LongTimeout)

'Verify option selected in Drop down 2'
WebUI.verifyOptionSelectedByLabel(masterSelect2, 'Value 1', false, GlobalVariable.G_LongTimeout)

'Verify option selected in Drop down 3'
WebUI.verifyOptionSelectedByLabel(masterSelect3, 'True', false, GlobalVariable.G_LongTimeout)