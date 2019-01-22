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

'Click On Save Button'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/span_Save'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Close Window'
CustomKeywords.'actions.Window.clickElementAndWaitForWindowClose'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/span_Close Window'),GlobalVariable.G_LongTimeout)

'Switch to parent window'
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

'Verify Business Model View - Radio List Event doc should be open'
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/span_Business Model View - Rad'))
String actualtext= WebUI.getText(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/span_Business Model View - Rad'))
WebUI.verifyMatch(actualtext, 'Business Model View - Radio List Event', false)

'Click on Value 1 radio button from refrence object'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/tab_SingleResultView/input_Value1_ReferenceObject'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/iframe_Close Window_ContentPla'))

'Verify Elements Present'
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/tab_SingleResultView/td_InformationSingleResultView'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/tab_SingleResultView/span_This WMI imparts - Field'), GlobalVariable.G_LongTimeout)

'Verify Integer field should be visible'
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/tab_SingleResultView/input_Integer Field (Visible)_'))

'Verify date field should be disaply as required filed'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/span_Save'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
String errorMessage = WebUI.getText(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/div_errorMessage'))
WebUI.verifyElementText(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/div_errorMessage'), errorMessage)


/*//TODO: There is a bug (Required Field invisible which was showing before) in application , will work script once bug is resolved
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/tab_SingleResultView/div_Required'),GlobalVariable.G_LongTimeout )
String alertText = WebUI.getText(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/tab_SingleResultView/div_Required'))
println alertText

WebUI.verifyMatch(alertText,'Required', false)*/

'Verify Integer field should be visible'
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/tab_SingleResultView/input_Integer Field (Visible)_'))

'Get Background Color'
String actualColor= CustomKeywords.'actions.Common.getCssValue'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/tab_SingleResultView/input_StringField_ReferenceObject'),'background-color')

'Verify String filed should be with back ground color Red '
CustomKeywords.'actions.Common.verifyCssValue'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/tab_SingleResultView/input_StringField_ReferenceObject'), 'background-color',actualColor)

'Set Text in String Field to Verify Font'
String val = 'Sanyogita - '+DateUtil.getCurrentDateTime('MM-dd-yyyy HH:mm:ss a')
CustomKeywords.'actions.Common.setTextAndSave'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/tab_SingleResultView/input_StringField_ReferenceObject'), val)

'Get Font of String Field'
String actualfont= CustomKeywords.'actions.Common.getCssValue'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/tab_SingleResultView/input_StringField_ReferenceObject'),'font-weight')

//TODO:Bold Font Weight is 700 in 19.1 DB and 400 in 18.2 DB (As Value slection happens as Value 3) in 18.2)
'Verify String filed should be with Font Bold'
WebUI.verifyMatch(actualfont,'700',false)
