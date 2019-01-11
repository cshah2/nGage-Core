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

'select Doc Class as "Object Tabout Event " and Doc type as "Check Box event" from the dropdowns and click on OK button'
WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'('Object Tabout Events', 'Checkbox Event')
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

WebUI.switchToWindowTitle('(Doc ID: NEW )')
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'verify Business Model View -Checkbox Event doc should be open'
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/CheckBox Event/span_(Title)Business Model View - Che'))

'click on save and close'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/CheckBox Event/span_Save'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/CheckBox Event/iframe_Close Window_ContentPla'))
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/CheckBox Event/span_Close Window'))

'switch to main window'
WebUI.switchToWindowIndex('0')

'Close "create new" popup dialog'
WebUI.switchToWindowTitle('Savana nGage')
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/span_ui-button-icon-primary ui'))
//////////
'Go to Recent Documents tab'
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/a_Recent Documents'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/iframe_iframe_103'))

'Sort Record in grid by DocID Descending'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Home/div_Doc ID'))
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Home/div_Doc ID'))

'Open Document'
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/column_RecentDocuments LastAction'))
WebUI.switchToWindowIndex(1)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'verify Business Model View -Checkbox Event doc should be open'
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/CheckBox Event/span_(Title)Business Model View - Che'))

'Uncheck Master Object CheckBox Control check box'
WebUI.uncheck(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/CheckBox Event/input_Master Object CheckBox C'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/CheckBox Event/iframe_Close Window_ContentPla'))

'verify check box is unchecked'
WebUI.verifyElementNotChecked(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/CheckBox Event/input_Master Object CheckBox C'), GlobalVariable.G_LongTimeout)

'verify textbox is editable'
WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/CheckBox Event/input_String Field (Value Chan'), 'value', 'Checkbox is un-checked(not Read only)', GlobalVariable.G_LongTimeout)
//WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/CheckBox Event/input_String Field (Value Chan'), 'readonly', 'false', GlobalVariable.G_LongTimeout)
WebUI.verifyElementNotHasAttribute(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/CheckBox Event/input_String Field (Value Chan'), 'readonly', GlobalVariable.G_LongTimeout)

'click on save and close'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/CheckBox Event/span_Save'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/CheckBox Event/iframe_Close Window_ContentPla'))
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/CheckBox Event/span_Close Window'))

'switch to main window'
WebUI.switchToWindowIndex('0')

'Go to Recent Documents tab'
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/a_Recent Documents'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/iframe_iframe_103'))

'Sort Record in grid by DocID Descending'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Home/div_Doc ID'))
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Home/div_Doc ID'))

'Open Document'
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/column_RecentDocuments LastAction'))
WebUI.switchToWindowIndex(1)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'verify textbox in the opened document is editable'
WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/CheckBox Event/input_String Field (Value Chan'), 'value', 'Checkbox is un-checked(not Read only)', GlobalVariable.G_LongTimeout)
//WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/CheckBox Event/input_String Field (Value Chan'), 'readonly', 'false', GlobalVariable.G_LongTimeout)
WebUI.verifyElementNotHasAttribute(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/CheckBox Event/input_String Field (Value Chan'), 'readonly', GlobalVariable.G_LongTimeout)