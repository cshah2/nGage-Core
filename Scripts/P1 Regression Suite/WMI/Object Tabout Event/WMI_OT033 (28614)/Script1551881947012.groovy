import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.apache.commons.lang.RandomStringUtils
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

'Click on Global new button'
WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))

//Create Document 1 - Standard Grid (To ensure no error in single result view)
'Create document'
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'('Business Model View', 'Standard Grid')
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

WebUI.switchToWindowTitle('(Doc ID: NEW )')
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Click on Save button'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Result_View/span_Save'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Click on Close Window button'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Result_View/span_Close Window'))

'Switch to main window'
WebUI.switchToWindowIndex(0)

//Create Document 2 - Label Event with valid data
'Select Doc Class as "Object Tab Out Events" and Doc type as "Label Event" from the dropdowns and click on OK button'
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'('Object Tabout Events', 'Label Event')
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

WebUI.switchToWindowTitle('(Doc ID: NEW )')
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Enter Integer field value'
CustomKeywords.'actions.Common.waitForElementVisible'(findTestObject('Page_WMI_NEW/Object Tabout Event/Label Event/input__IntegerField(RequiredChange)'), GlobalVariable.G_LongTimeout)
String numericValueDoc1 = RandomStringUtils.randomNumeric(5)
WebUI.setText(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Label Event/input__IntegerField(RequiredChange)'), numericValueDoc1)

'Click on Save button'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Result_View/span_Save'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Click on Close Window button'
CustomKeywords.'actions.Window.clickElementAndWaitForWindowClose'(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Result_View/span_Close Window'), GlobalVariable.G_LongTimeout)

'Switch to main window'
WebUI.switchToWindowIndex(0)

//Create Document 3 - Label Event with valid data
'Select Doc Class as "Object Tab Out Events" and Doc type as "Label Event" from the dropdowns and click on OK button'
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'('Object Tabout Events', 'Label Event')
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

WebUI.switchToWindowTitle('(Doc ID: NEW )')
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Enter Integer field value'
CustomKeywords.'actions.Common.waitForElementVisible'(findTestObject('Page_WMI_NEW/Object Tabout Event/Label Event/input__IntegerField(RequiredChange)'), GlobalVariable.G_LongTimeout)
String numericValueDoc2 = RandomStringUtils.randomNumeric(5)
WebUI.setText(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Label Event/input__IntegerField(RequiredChange)'), numericValueDoc2)

'Click on Save button'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Result_View/span_Save'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Click on Close Window button'
CustomKeywords.'actions.Window.clickElementAndWaitForWindowClose'(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Result_View/span_Close Window'), GlobalVariable.G_LongTimeout)

'Switch to main window'
WebUI.switchToWindowIndex(0)

'Close Global new popup dialog'
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/span_ui-button-icon-primary ui'))

'Click on Recent Document'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('HOME', 'Recent Documents')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/iframe_iframe_103'))

'Sort Record in grid by DocID Descending'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'), 'Doc ID')
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'), 'Doc ID')

'Open Document'
int rowNo = 2
CustomKeywords.'actions.Table.clickCell'(findTestObject('Page_nGage_Dashboard/Home/table_MyDocumentResults'), rowNo, 5)

'Switch to WMI Window'
WebUI.switchToWindowIndex(1)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'verify opened document'
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_WMI_NEW/Master_Object_Feature/Render_As_Label/span_Document(Title)'), GlobalVariable.G_LongTimeout)

'Scroll to Single result view'
WebUI.scrollToElement(findTestObject('Page_WMI_NEW/Object Tabout Event/Label Event/tab_SingleResultView/input_FloatField'), GlobalVariable.G_LongTimeout)

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

'Verify Float Field background should be white'
fieldColor=CustomKeywords.'actions.Common.getCssValue'(findTestObject('Page_WMI_NEW/Object Tabout Event/Label Event/tab_SingleResultView/input_FloatField'), 'background-color')
WebUI.verifyMatch(fieldColor, 'rgba(255, 255, 255, 1)', false)

'Clear Data from Integer field if exists then click'
WebUI.clearText(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Label Event/tab_SingleResultView/input_IntegerField'))

'Move focus out of field'
WebUI.sendKeys(findTestObject('Page_WMI_NEW/Object Tabout Event/Label Event/tab_SingleResultView/input_IntegerField'), Keys.chord(Keys.ENTER))

'Verify Integer Field (Required Change) field should be required'
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Label Event/tab_SingleResultView/div_Required'))

'Fill up the values in required field'
String numericValueDocSingleResult = RandomStringUtils.randomNumeric(5)
WebUI.setText(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Label Event/tab_SingleResultView/input_IntegerField'), numericValueDocSingleResult)

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
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'), 'Doc ID')
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'), 'Doc ID')

'Open Document'
CustomKeywords.'actions.Table.clickCell'(findTestObject('Page_nGage_Dashboard/Home/table_MyDocumentResults'), 2, 5)

'Switch to WMI Window'
WebUI.switchToWindowIndex(1)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'verify opened document'
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Label Event/span_DocumentTitle'), GlobalVariable.G_LongTimeout)

'Verify correct integer value is loaded in document'
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI_NEW/Object Tabout Event/Label Event/input__IntegerField(RequiredChange)'), 'Value', numericValueDocSingleResult, GlobalVariable.G_LongTimeout)