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
import utils.Consts
import utils.DateUtil

'Login Into Application'
CustomKeywords.'actions.Common.login'()

'Create Document 1 - Standard Grid'
CustomKeywords.'actions.Data.create'(DocClass.BUSINESS_MODEL_VIEW, DocType.STANDARD_GRID, null)

'Create a new Object Tabout Events Document'
WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))

'Verify Doc class and Doc type dropdowns should be displayed'
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'('Object Tabout Events', 'Radio List Event')
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

'Switch to WMI'
WebUI.switchToWindowIndex(1)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Wait for WMI to load'
WebUI.waitForElementVisible(findTestObject('Page_WMI_NEW/Object Tabout Event/Radio List Event/input_Value1_MasterObject'), GlobalVariable.G_LongTimeout)

'Click on Value 3 radio button from master object'
WebUI.waitForElementVisible(findTestObject('Page_WMI_NEW/Object Tabout Event/Radio List Event/input_Value3_MasterObject'),GlobalVariable.G_LongTimeout)
WebUI.check(findTestObject('Page_WMI_NEW/Object Tabout Event/Radio List Event/input_Value3_MasterObject'))

'Wait for event to complete'
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)

String inputValue = DateUtil.getCurrentDateTime(Consts.FORMAT_DATETIME)
'Clear data from Date field'
WebUI.clearText(findTestObject('Page_WMI_NEW/Object Tabout Event/Radio List Event/input_Date Field (Required)_ef'))

'Verify Integer field should be visible'
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/input_Integer Field (Visible)_'))

'Verify String filed should be with back ground color Blue '
CustomKeywords.'actions.Common.verifyCssValue'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/input_String Field (Style)_efo'), 'background-color','rgba(0, 0, 255, 1)')

'Enter value in String field'
CustomKeywords.'actions.Common.setText_Date'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/input_String Field (Style)_efo'), inputValue)

'Verify String filed should be with Font Normal'
String actualfont= CustomKeywords.'actions.Common.getCssValue'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/input_String Field (Style)_efo'),'font-weight')
WebUI.verifyMatch(actualfont,'400',false)

'Save WMI'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/span_Save'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Close WMI'
CustomKeywords.'actions.Window.clickElementAndWaitForWindowClose'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/span_Close Window'),GlobalVariable.G_LongTimeout)

'Switch to parent window'
WebUI.switchToWindowIndex(0)

'Close "create new" popup dialog'
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/span_ui-button-icon-primary ui'))

'Open document from recents grid'
CustomKeywords.'actions.Common.openDocumentFromRecentGrid'(1)

'Wait for WMI to load'
WebUI.waitForElementVisible(findTestObject('Page_WMI_NEW/Object Tabout Event/Radio List Event/input_Value1_MasterObject'), GlobalVariable.G_LongTimeout)

'Verify Radio3 is selected'
WebUI.verifyElementChecked(findTestObject('Page_WMI_NEW/Object Tabout Event/Radio List Event/input_Value3_MasterObject'), GlobalVariable.G_LongTimeout)

'Verify Integer field should be visible'
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/input_Integer Field (Visible)_'))

'Verify String filed should be with back ground color Blue '
CustomKeywords.'actions.Common.verifyCssValue'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/input_String Field (Style)_efo'), 'background-color','rgba(0, 0, 255, 1)')

'Verify value in Date field'
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI_NEW/Object Tabout Event/Radio List Event/input_Date Field (Required)_ef'), 'value', '', GlobalVariable.G_LongTimeout)

'Verify value in String field'
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI_NEW/Object Tabout Event/Radio List Event/input_String Field (Style)_efo'), 'value', inputValue, GlobalVariable.G_LongTimeout)

'Verify String filed should be with Font Normal'
String actualfontAfter= CustomKeywords.'actions.Common.getCssValue'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/input_String Field (Style)_efo'),'font-weight')
WebUI.verifyMatch(actualfontAfter,'400',false)