import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.configuration.RunConfiguration
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
import static utils.Consts.*

'Login into application'
CustomKeywords.'actions.Common.login'()

'Pre-Requisite : Create new Document of type WMI Menu Bov Vertical'
String isPresent = CustomKeywords.'actions.Common.isRecordPresentInRecentGridTable'(1, 'Doc Type', DocType.WMI_MENU_BOV_VERTICAL.toString())

if(!(FLAG_P1_WMI_DOC061 && isPresent)){
	CustomKeywords.'actions.Data.create'(DocClass.WMI_MENU, DocType.WMI_MENU_BOV_VERTICAL, P1_WMI_DOC061)
	FLAG_P1_WMI_DOC061 = true
	WebUI.refresh()
}

'Pre-Requisite : Open newly created document from recent grid'
CustomKeywords.'actions.Common.openDocumentFromRecentGrid'('WMI Menu BOV Vertical')
WebUI.waitForElementNotVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/image_Processing'), GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForImageRender'(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/image'))

'Open on Thumbnail'
CustomKeywords.'actions.Common.openThumbnail'(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/button_Thumbnail_Toggle'))

'Verify Thumbnail Grid is open now'
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/button_Thumbnail_Toggle'), 'class', 'ui-layout-toggler ui-layout-toggler-west ui-layout-toggler-open ui-layout-toggler-west-open', GlobalVariable.G_LongTimeout)
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/table_Thumbnail_Grid'))

'Click on Export Menu'
WebUI.click(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/menu_Export'))

'Click on Sub Menu Export PDF without Annotation'
WebUI.waitForElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/subMenu_Export_PDF without annotations'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/subMenu_Export_PDF without annotations'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/iframe_westContainer'))

'Verify Dialog'
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ExportPDF/div_Dialog')) //Dialog
WebUI.verifyMatch(WebUI.getText(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ExportPDF/dialog_Title')), '.*Export PDF Without Annotations.*', true) //Dialog title

WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ExportPDF/radio_Type_PDF')) //Radio - Type PDF
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ExportPDF/radio_Type_TIFF')) //Radio - Type TIFF
WebUI.verifyElementChecked(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ExportPDF/radio_Type_PDF'), GlobalVariable.G_LongTimeout) // Radio - Type PDF checked
WebUI.verifyElementNotChecked(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ExportPDF/radio_Type_TIFF'), GlobalVariable.G_LongTimeout) //Radio - Type TIFF unchecked
WebUI.verifyElementNotHasAttribute(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ExportPDF/radio_Type_PDF'), 'disabled', GlobalVariable.G_LongTimeout) //Radio - Type PDF disabled
WebUI.verifyElementHasAttribute(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ExportPDF/radio_Type_TIFF'), 'disabled', GlobalVariable.G_LongTimeout) //Radio - Type TIFF disabled

WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ExportPDF/radio_Annotation_No')) //Radio - Annotation No
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ExportPDF/radio_Annotation_Yes')) //Radio - Annotation Yes
WebUI.verifyElementChecked(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ExportPDF/radio_Annotation_No'), GlobalVariable.G_LongTimeout) // Radio - Annotation No Checked
WebUI.verifyElementNotChecked(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ExportPDF/radio_Annotation_Yes'), GlobalVariable.G_LongTimeout) //Radio - Annotation Yes Unchecked
WebUI.verifyElementNotHasAttribute(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ExportPDF/radio_Annotation_No'), 'disabled', GlobalVariable.G_LongTimeout) //Radio - Annotation No disabled
WebUI.verifyElementHasAttribute(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ExportPDF/radio_Annotation_Yes'), 'disabled', GlobalVariable.G_LongTimeout) //Radio - Annotation Yes disabled

WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ExportPDF/radio_Page_Selected')) //Radio - Page option selected
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ExportPDF/radio_Page_All')) //Radio - Page option All
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ExportPDF/radio_Page_PageNumbers')) //Radio - Page option pages
WebUI.verifyElementChecked(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ExportPDF/radio_Page_Selected'), GlobalVariable.G_LongTimeout) // Radio - Page option selected Checked
WebUI.verifyElementNotChecked(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ExportPDF/radio_Page_All'), GlobalVariable.G_LongTimeout) //Radio - Page option All Unchecked
WebUI.verifyElementNotChecked(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ExportPDF/radio_Page_PageNumbers'), GlobalVariable.G_LongTimeout) //Radio - Page option pages Unchecked
WebUI.verifyElementNotHasAttribute(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ExportPDF/radio_Page_Selected'), 'disabled', GlobalVariable.G_LongTimeout) //Radio - Page option selected not disabled
WebUI.verifyElementNotHasAttribute(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ExportPDF/radio_Page_All'), 'disabled', GlobalVariable.G_LongTimeout) //Radio - Page option yes not disabled
WebUI.verifyElementNotHasAttribute(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ExportPDF/radio_Page_PageNumbers'), 'disabled', GlobalVariable.G_LongTimeout) //Radio - Page option pages not disabled

WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ExportPDF/input_Page_Number')) //input field - page number
WebUI.verifyElementHasAttribute(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ExportPDF/input_Page_Number'), 'disabled', GlobalVariable.G_LongTimeout) //input field - page number disabled

WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ExportPDF/btn_Ok')) //OK button
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ExportPDF/btn_Close')) //Close button

'Click on Close button'
WebUI.click(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ExportPDF/btn_Close'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/iframe_westContainer'))

'Verify dialog is not present'
WebUI.verifyElementNotVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ExportPDF/div_Dialog'))
