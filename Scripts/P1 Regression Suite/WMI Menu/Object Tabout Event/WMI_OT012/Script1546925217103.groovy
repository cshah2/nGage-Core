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

'Create a new Object Tabout Events Document'
WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))

'Verify Doc class and Doc type dropdowns should be displayed'
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'('Object Tabout Events', 'Radio List Event')
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

WebUI.switchToWindowTitle('(Doc ID: NEW )')
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Verify Business Model View - Radio List Event doc should be open'
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/span_Business Model View - Rad'))
String actualtext= WebUI.getText(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/span_Business Model View - Rad'))
WebUI.verifyMatch(actualtext, 'Business Model View - Radio List Event', false)

'Click on Value 3 radio button from master object'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/input_Value3_MasterObject'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/iframe_Close Window_ContentPla'))

'Verify date field should not be disaply as required filed'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/input_Date Field (Required)_ef'))
WebUI.verifyElementNotPresent(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/td_Required'),GlobalVariable.G_LongTimeout)

'Verify Integer field should be visible'
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/input_Integer Field (Visible)_'))

'Get Background Color'
String actualColor= CustomKeywords.'actions.Common.getCssValue'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/input_String Field (Style)_efo'),'background-color')

'Verify String filed should be with back ground color Red '
CustomKeywords.'actions.Common.verifyCssValue'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/input_String Field (Style)_efo'), 'background-color',actualColor)

String dateRequired = DateUtil.getCurrentDateTime('MM-dd-yyyy HH:mm:ss a')

'Set Date in Date field Required '
CustomKeywords.'actions.Common.setText_Date'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/input_Date Field (Required)_ef'), dateRequired)

String actualfont= CustomKeywords.'actions.Common.getCssValue'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/input_String Field (Style)_efo'),'font-weight')

'Verify String filed should be with Font Normal'
WebUI.verifyMatch(actualfont,'400',false)

'Click On Save Button'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/span_Save'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Close Window() and If Error Present Document will not get Close'
CustomKeywords.'actions.Window.clickElementAndWaitForWindowClose'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/span_Close Window'),GlobalVariable.G_LongTimeout)

'Switch to parent window '
WebUI.switchToWindowIndex(0)
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/span_ui-button-icon-primary ui'))

'Navigate to Recent Documents'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('HOME', 'Recent Documents')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/iframe_iframe_103'))

'Sort records DocID Descending'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Object Repository/Page_nGage_Dashboard/Home/column_RecentDocuments DocID'))
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Object Repository/Page_nGage_Dashboard/Home/column_RecentDocuments DocID'))

'Open recent document'
CustomKeywords.'actions.Table.clickCell'(findTestObject('Object Repository/Page_nGage_Dashboard/Home/table_MyDocumentResults'), 1, 7)
WebUI.switchToWindowIndex(1)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Verify Changes Saved in Document'
WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/input_Date Field (Required)_ef'), 'value',dateRequired,GlobalVariable.G_LongTimeout)

'Close Window() and If Error Present Document will not get Close'
CustomKeywords.'actions.Window.clickElementAndWaitForWindowClose'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/span_Close Window'),GlobalVariable.G_LongTimeout)
