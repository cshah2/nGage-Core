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
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'('Master Object Feature', 'Render As AjaxDate')

'Click on OK button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))
WebUI.switchToWindowTitle('(Doc ID: NEW )')
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Verify Information Text'
WebUI.verifyElementText(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_Ajaxdate/span_Information'), 'This WMI imparts - Control renderas AJAXDATE')

'Enter valid date in single date field'
String currentDate = DateUtil.getCurrentDateTime('MM-dd-yyyy')
WebUI.setText(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_Ajaxdate/input_RenderAsAjaxdate'), currentDate)

'Enter valid date in multi value field'
WebUI.setText(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_Ajaxdate/input_RenderAsAjaxdate_Multi'), currentDate)

'Click on + icon'
WebUI.click(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_Ajaxdate/button_Add Icon'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_Ajaxdate/iframe_Close Window_ContentPla'))

'Verify combobox contains datetime value which was added'
WebUI.verifyOptionPresentByLabel(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_Ajaxdate/select_MultiValue'), currentDate, false, GlobalVariable.G_LongTimeout)

'Verify Read only field contains valid date value'
CustomKeywords.'actions.Common.verifyDateFormat'(WebUI.getText(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_Ajaxdate/span_AjaxDate_ReadOnly')).replaceAll('/', '-'), 'MM-dd-yyyy HH:mm:ss a')

'Click Save'
WebUI.click(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_Ajaxdate/span_Save'))

'Click close window'
CustomKeywords.'actions.Window.clickElementAndWaitForWindowClose'(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_Ajaxdate/span_Close Window'), GlobalVariable.G_LongTimeout)

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
CustomKeywords.'actions.Table.verifyCellContainsValue'(findTestObject('Page_nGage_Dashboard/Home/table_MyDocumentResults'), 1, 4, 'Render As AjaxDate')
CustomKeywords.'actions.Table.verifyCellContainsValue'(findTestObject('Page_nGage_Dashboard/Home/table_MyDocumentResults'), 1, 5, 'Created')

'Click on 1st Row'
CustomKeywords.'actions.Table.clickCell'(findTestObject('Page_nGage_Dashboard/Home/table_MyDocumentResults'), 1, 3)

'Open document'
WebUI.switchToWindowIndex(1)

'Verify Information Text'
WebUI.verifyElementText(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_Ajaxdate/span_Information'), 'This WMI imparts - Control renderas AJAXDATE')

'Validate date value '
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_Ajaxdate/input_RenderAsAjaxdate'), 'value', currentDate, GlobalVariable.G_LongTimeout)

'Verify combobox contains datetime value which was added'
WebUI.verifyOptionPresentByLabel(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_Ajaxdate/select_MultiValue'), currentDate, false, GlobalVariable.G_LongTimeout)

'Verify Read only field contains valid date value'
CustomKeywords.'actions.Common.verifyDateFormat'(WebUI.getText(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_Ajaxdate/span_AjaxDate_ReadOnly')).replaceAll('/', '-'), 'MM-dd-yyyy HH:mm:ss a')
