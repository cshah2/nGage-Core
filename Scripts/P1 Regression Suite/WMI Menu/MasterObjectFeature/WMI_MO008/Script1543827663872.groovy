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

'Login into application'
CustomKeywords.'actions.Common.login'()

'Click on NEW button'
WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))

'Select DocClass and DocType'
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'('Master Object Feature', 'Render As HtmlEdit')

'Click on OK button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))
WebUI.switchToWindowTitle('(Doc ID: NEW )')
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Verify Information Text'
WebUI.verifyElementText(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_HtmlEdit/span_Information'), 'This WMI imparts - Control renderas HTMLEDIT')

'Verify HTML Controls are visible'
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_HtmlEdit/p_StringField'))
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_HtmlEdit/p_TextField'))
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_HtmlEdit/p_TextField_JS'))

'Enter some text in HTML control fields'
//WebUI.sendKeys(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_HtmlEdit/p_StringField'), 'String Field')
WebUI.sendKeys(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_HtmlEdit/p_TextField'), 'Text Field')
WebUI.sendKeys(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_HtmlEdit/p_TextField_JS'), 'Text Field JS')

'Click Save'
WebUI.click(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_HtmlEdit/span_Save'))

'Click close window'
CustomKeywords.'actions.Window.clickElementAndWaitForWindowClose'(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_HtmlEdit/span_Close Window'), GlobalVariable.G_LongTimeout)

WebUI.switchToWindowTitle('Savana nGage')
'Close create new popup dialog'
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/span_ui-button-icon-primary ui'))

'Go to Recent documents'
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/a_Recent Documents'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/iframe_iframe_103'))

'Verify atleast 1 record is present in grid'
WebUI.verifyElementPresent(findTestObject('Page_nGage_Dashboard/Home/tableRow_recentDocuments_firstRow'), GlobalVariable.G_LongTimeout);

'Sort records in table by DocID Descending'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Home/div_Doc ID'))
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Home/div_Doc ID'))

'Verify Column values in 1st record'
CustomKeywords.'actions.Table.verifyCellContainsValue'(findTestObject('Page_nGage_Dashboard/Home/table_MyDocumentResults'), 1, 4, 'Render As HtmlEdit')
CustomKeywords.'actions.Table.verifyCellContainsValue'(findTestObject('Page_nGage_Dashboard/Home/table_MyDocumentResults'), 1, 5, 'Created')

'Click on 1st Row'
CustomKeywords.'actions.Table.clickCell'(findTestObject('Page_nGage_Dashboard/Home/table_MyDocumentResults'), 1, 3)

'Open document'
WebUI.switchToWindowIndex(1)

'Verify Information Text'
WebUI.verifyElementText(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_RadioList/span_Information'), 'This WMI imparts - Control renderas HTMLEDIT')

'Verify HTML Controls are visible'
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_HtmlEdit/p_StringField'))
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_HtmlEdit/p_TextField'))
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_HtmlEdit/p_TextField_JS'))

'Verify Text in each field'
WebUI.verifyElementText(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_HtmlEdit/p_StringField'), 'Test Text')
WebUI.verifyElementText(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_HtmlEdit/p_TextField'), 'Text Field')
WebUI.verifyElementText(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_HtmlEdit/p_TextField_JS'), 'Text Field JS')
