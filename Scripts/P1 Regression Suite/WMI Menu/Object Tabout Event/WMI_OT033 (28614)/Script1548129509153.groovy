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
import internal.GlobalVariable as GlobalVariable

'Login Into Application'
CustomKeywords.'actions.Common.login'()

'Select Doc Class as "Object Tab Out Events" and Doc type as "Label Event" from the dropdowns and click on OK button'
WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'('Object Tabout Events', 'Label Event')
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

WebUI.switchToWindowTitle('(Doc ID: NEW )')
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Verify Label Event Documnet Opened in Single Result View'
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Label Event/tab_SingleResultView/span_SingleResultView'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Label Event/tab_SingleResultView/span_This WMI imparts - Field'), GlobalVariable.G_LongTimeout)

'Verify in reference object Label Control 1 value is set Condition 1 '
WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Label Event/tab_SingleResultView/span_MasterObjectLabelControl1')), 'Condition1', false)

'String Field (Required Change) field should be not required' 
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Label Event/tab_SingleResultView/input_StringField'))
WebUI.verifyElementNotPresent(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Label Event/tab_SingleResultView/div_Required'),GlobalVariable.G_LongTimeout)

'Verify Curreny Field background should be red.'
String fieldColor= CustomKeywords.'actions.Common.getCssValue'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Label Event/tab_SingleResultView/input_CurrencyField'), 'background-color')
WebUI.verifyMatch(fieldColor, 'rgba(255, 0, 0, 1)', false)

'Verify in reference object Label Control 2 value is set Condition 2 '
WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Label Event/tab_SingleResultView/span_MasterObjectLabelControl2')), 'Condition2', false)

'Clear Data from Integer field if exists then click'
WebUI.clearText(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Label Event/tab_SingleResultView/input_IntegerField'))
WebUI.clearText(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Label Event/input__IntegerField(RequiredChange)'))
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Label Event/tab_SingleResultView/input_IntegerField'))

'Click on Save Button to verify Required field is present'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Result_View/span_Save'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Verify Integer Field (Required Change) field should be required'
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Label Event/tab_SingleResultView/div_Required'))

'Verify Float Field background should be white'
fieldColor=CustomKeywords.'actions.Common.getCssValue'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Label Event/input_Float Field (Style Change)'), 'background-color')
WebUI.verifyMatch(fieldColor, 'rgba(255, 255, 255, 1)', false)

'Fill up the values in required field'
WebUI.setText(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Label Event/tab_SingleResultView/input_IntegerField'), '100')
String intValueBeforeSave = WebUI.getAttribute(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Label Event/tab_SingleResultView/input_IntegerField'),'value')
WebUI.setText(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Label Event/input__IntegerField(RequiredChange)'), '100')

'Click on Save button'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Result_View/span_Save'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Click on Close Window button'
CustomKeywords.'actions.Window.clickElementAndWaitForWindowClose'(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Result_View/span_Close Window'), GlobalVariable.G_LongTimeout)

'Switch to main window'
WebUI.switchToWindowIndex(0)
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/span_ui-button-icon-primary ui'))

'Click on Recent Document'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('HOME', 'Recent Documents')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/iframe_iframe_103'))

'Sort Record in grid by DocID Descending'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Home/div_Doc ID'))
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Home/div_Doc ID'))

'Open Document'
CustomKeywords.'actions.Table.clickCell'(findTestObject('Page_nGage_Dashboard/Home/table_MyDocumentResults'), 1, 5)

'Switch to WMI Window'
WebUI.switchToWindowIndex(1)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Verify Document Saved and Opening'
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Label Event/span_DocumentTitle'), GlobalVariable.G_LongTimeout)
String intValueAfterSave=WebUI.getAttribute(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Label Event/input__IntegerField(RequiredChange)'), 'value')

'Verify changes got Saved in document'
WebUI.verifyMatch(intValueBeforeSave, intValueAfterSave, false)