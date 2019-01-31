import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.Keys

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

'Select Doc Class as "Object Tab Out Events" and Doc type as "checkbox list Event" from the dropdowns and click on OK button'
WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'('Object Tabout Events', 'Label Event')
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

WebUI.switchToWindowTitle('(Doc ID: NEW )')
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Fillup the values in required filed'
WebUI.setText(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Label Event/input__IntegerField(RequiredChange)'), '1212')
WebUI.setText(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Label Event/input__IntegerField(RequiredChange)SRV'), '1212')

'Click on Save button'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Result_View/span_Save'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Click on Close Window button'
CustomKeywords.'actions.Window.clickElementAndWaitForWindowClose'(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Result_View/span_Close Window'), GlobalVariable.G_LongTimeout)

'Switch to main window'
WebUI.switchToWindowIndex(0)

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

'verify opened document'
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Label Event/span_DocumentTitle'), GlobalVariable.G_LongTimeout)

'click on tab inline view'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Master_Object_Feature/Render_As_Label/span_tab_InlineView'))

'From refrence object select Inlineview tab >Click on new button from refence object>'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Master_Object_Feature/Render_As_Label/tab_InlineView/span_New'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'verify Label Control 1 value is set Condition 1'
WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/Page_WMI_NEW/Master_Object_Feature/Render_As_Label/tab_InlineView/span_MasterObjectLabelControl1')), 'Condition1', false)

'Curreny Field background should be red'
String fieldColor= CustomKeywords.'actions.Common.getCssValue'(findTestObject('Object Repository/Page_WMI_NEW/Master_Object_Feature/Render_As_Label/tab_InlineView/input_Currency Field (Style Ch'), 'background-color')
WebUI.verifyMatch(fieldColor, 'rgba(255, 0, 0, 1)', false)

'In Inline view under reference object Label Control 2 value is set Condition 2 '
WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/Page_WMI_NEW/Master_Object_Feature/Render_As_Label/tab_InlineView/span_MasterObjectLabelControl2')), 'Condition2', false)

'Float Field background should be white'
fieldColor=CustomKeywords.'actions.Common.getCssValue'(findTestObject('Object Repository/Page_WMI_NEW/Master_Object_Feature/Render_As_Label/tab_InlineView/input_Float Field (Style Chang'), 'background-color')
WebUI.verifyMatch(fieldColor, 'rgba(255, 255, 255, 1)', false)

'Integer Field (Required Change) field should be required'
WebUI.clearText(findTestObject('Object Repository/Page_WMI_NEW/Master_Object_Feature/Render_As_Label/tab_InlineView/input__IntegerFieldRequiredChange'))
WebUI.sendKeys(findTestObject('Object Repository/Page_WMI_NEW/Master_Object_Feature/Render_As_Label/tab_InlineView/input__IntegerFieldRequiredChange'), Keys.chord(Keys.TAB))
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_WMI_NEW/Master_Object_Feature/Render_As_Label/tab_InlineView/td_IntegerField Required'), GlobalVariable.G_LongTimeout)

'Fillup the values in required filed'
WebUI.setText(findTestObject('Object Repository/Page_WMI_NEW/Master_Object_Feature/Render_As_Label/tab_InlineView/input__IntegerFieldRequiredChange'), '101010')

'Click on Save'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Master_Object_Feature/Render_As_Label/tab_InlineView/input_Save'))

'click on close'
CustomKeywords.'actions.Window.clickElementAndWaitForWindowClose'(findTestObject('Object Repository/Page_WMI_NEW/Master_Object_Feature/Render_As_Label/span_Close Window'), GlobalVariable.G_LongTimeout)
WebUI.switchToWindowIndex(0)

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

'verify opened document'
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_WMI_NEW/Master_Object_Feature/Render_As_Label/span_Document(Title)'), GlobalVariable.G_LongTimeout)