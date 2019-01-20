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
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'('Master Object Feature', 'Render As CheckBox List')

'Click on OK button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))
WebUI.switchToWindowTitle('(Doc ID: NEW )')
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Verify Information Text'
WebUI.verifyElementText(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_CheckboxList/span_Information'), 'This WMI imparts - Control renderas CheckBoxList')

'Verify All checkbox fields are visible'
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_CheckboxList/checkbox_Value1_Multivalue'))
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_CheckboxList/checkbox_Value1_Readonly'))
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_CheckboxList/checkbox_Value1_String'))
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_CheckboxList/checkbox_Value2_Multivalue'))
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_CheckboxList/checkbox_Value2_Readonly'))
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_CheckboxList/checkbox_Value2_String'))
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_CheckboxList/checkbox_Value3_Multivalue'))
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_CheckboxList/checkbox_Value3_Readonly'))
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_CheckboxList/checkbox_Value3_String'))
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_CheckboxList/checkbox_Value4_Multivalue'))
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_CheckboxList/checkbox_Value4_Readonly'))
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_CheckboxList/checkbox_Value4_String'))
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_CheckboxList/checkbox_Value5_Multivalue'))
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_CheckboxList/checkbox_Value5_Readonly'))
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_CheckboxList/checkbox_Value5_String'))

'Select few checkboxes'
WebUI.check(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_CheckboxList/checkbox_Value2_Multivalue'))
WebUI.check(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_CheckboxList/checkbox_Value2_String'))
WebUI.check(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_CheckboxList/checkbox_Value3_Multivalue'))
WebUI.check(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_CheckboxList/checkbox_Value3_String'))


'Verify checkboxes are readonly'
WebUI.verifyElementHasAttribute(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_CheckboxList/checkbox_Value1_Readonly'), 'disabled', GlobalVariable.G_LongTimeout)
WebUI.verifyElementHasAttribute(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_CheckboxList/checkbox_Value2_Readonly'), 'disabled', GlobalVariable.G_LongTimeout)
WebUI.verifyElementHasAttribute(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_CheckboxList/checkbox_Value3_Readonly'), 'disabled', GlobalVariable.G_LongTimeout)
WebUI.verifyElementHasAttribute(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_CheckboxList/checkbox_Value4_Readonly'), 'disabled', GlobalVariable.G_LongTimeout)
WebUI.verifyElementHasAttribute(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_CheckboxList/checkbox_Value5_Readonly'), 'disabled', GlobalVariable.G_LongTimeout)

'Click Save'
WebUI.click(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_CheckboxList/span_Save'))

'Click close window'
CustomKeywords.'actions.Window.clickElementAndWaitForWindowClose'(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_CheckboxList/span_Close Window'), GlobalVariable.G_LongTimeout)

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
CustomKeywords.'actions.Table.verifyCellContainsValue'(findTestObject('Page_nGage_Dashboard/Home/table_MyDocumentResults'), 1, 4, 'Render As CheckBox List')
CustomKeywords.'actions.Table.verifyCellContainsValue'(findTestObject('Page_nGage_Dashboard/Home/table_MyDocumentResults'), 1, 5, 'Created')

'Click on 1st Row'
CustomKeywords.'actions.Table.clickCell'(findTestObject('Page_nGage_Dashboard/Home/table_MyDocumentResults'), 1, 3)

'Open document'
WebUI.switchToWindowIndex(1)

'Verify All checkbox fields are visible'
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_CheckboxList/checkbox_Value1_Multivalue'))
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_CheckboxList/checkbox_Value1_Readonly'))
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_CheckboxList/checkbox_Value1_String'))
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_CheckboxList/checkbox_Value2_Multivalue'))
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_CheckboxList/checkbox_Value2_Readonly'))
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_CheckboxList/checkbox_Value2_String'))
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_CheckboxList/checkbox_Value3_Multivalue'))
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_CheckboxList/checkbox_Value3_Readonly'))
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_CheckboxList/checkbox_Value3_String'))
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_CheckboxList/checkbox_Value4_Multivalue'))
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_CheckboxList/checkbox_Value4_Readonly'))
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_CheckboxList/checkbox_Value4_String'))
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_CheckboxList/checkbox_Value5_Multivalue'))
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_CheckboxList/checkbox_Value5_Readonly'))
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_CheckboxList/checkbox_Value5_String'))

'Verify checkboxes are readonly'
WebUI.verifyElementHasAttribute(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_CheckboxList/checkbox_Value1_Readonly'), 'disabled', GlobalVariable.G_LongTimeout)
WebUI.verifyElementHasAttribute(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_CheckboxList/checkbox_Value2_Readonly'), 'disabled', GlobalVariable.G_LongTimeout)
WebUI.verifyElementHasAttribute(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_CheckboxList/checkbox_Value3_Readonly'), 'disabled', GlobalVariable.G_LongTimeout)
WebUI.verifyElementHasAttribute(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_CheckboxList/checkbox_Value4_Readonly'), 'disabled', GlobalVariable.G_LongTimeout)
WebUI.verifyElementHasAttribute(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_CheckboxList/checkbox_Value5_Readonly'), 'disabled', GlobalVariable.G_LongTimeout)

'Verify correct checkboxes are selected'
WebUI.verifyElementChecked(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_CheckboxList/checkbox_Value2_Multivalue'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementChecked(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_CheckboxList/checkbox_Value2_String'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementChecked(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_CheckboxList/checkbox_Value3_Multivalue'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementChecked(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_CheckboxList/checkbox_Value3_String'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementNotChecked(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_CheckboxList/checkbox_Value1_Multivalue'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementNotChecked(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_CheckboxList/checkbox_Value1_String'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementNotChecked(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_CheckboxList/checkbox_Value4_Multivalue'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementNotChecked(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_CheckboxList/checkbox_Value4_String'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementNotChecked(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_CheckboxList/checkbox_Value5_Multivalue'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementNotChecked(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_CheckboxList/checkbox_Value5_String'), GlobalVariable.G_LongTimeout)
