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
import static utils.DateUtil.*
import static utils.Consts.*

import utils.FileUtil
import utils.ImageUtil

'Login into application'
CustomKeywords.'actions.Common.login'()

'Pre-Requisite : Create new Document of type WMI Menu Bov Vertical'
String isPresent = CustomKeywords.'actions.Common.isRecordPresentInRecentGridTable'(1, 'Doc Type', DocType.WMI_MENU_BOV_VERTICAL.toString())

if(!(FLAG_P1_WMI_DOC061 && isPresent)){
	CustomKeywords.'actions.Data.create'(DocClass.WMI_MENU, DocType.WMI_MENU_BOV_VERTICAL, P1_WMI_DOC061)
	FLAG_P1_WMI_DOC061 = true
	WebUI.refresh()
}

FLAG_P1_WMI_DOC061 = false //NOTE: Setting this value as false to ensure next test case needs to create fresh data

'Pre-Requisite : Open newly created document from recent grid'
CustomKeywords.'actions.Common.openDocumentFromRecentGrid'('WMI Menu BOV Vertical')
WebUI.waitForElementNotVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/image_Processing'), GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForImageRender'(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/image'))

'Open on Thumbnail'
CustomKeywords.'actions.Common.openThumbnail'(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/button_Thumbnail_Toggle'))

'Verify Thumbnail Grid is open now'
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/button_Thumbnail_Toggle'), 'class', 'ui-layout-toggler ui-layout-toggler-west ui-layout-toggler-open ui-layout-toggler-west-open', GlobalVariable.G_LongTimeout)
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/table_Thumbnail_Grid'))

List<TestObject> elements = new ArrayList<TestObject>()
elements.add(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/thumbnail_2'))
elements.add(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/thumbnail_4'))

'Click on Multiple Thumbnails Thumbnail 1(Default selected), Thumbnail 2 and Thumbnail 4'
CustomKeywords.'actions.Common.clickMultipleElements'(elements)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
WebUI.waitForElementNotVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/image_Processing'), GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForImageRender'(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/image'))

'Click on Export Menu'
WebUI.click(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/menu_Export'))

'Click on Sub Menu Split to PDF'
WebUI.waitForElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/subMenu_Export_Split To PDF'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/subMenu_Export_Split To PDF'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/iframe_westContainer'))

'Verify dialog'
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ExportPDF/div_Dialog')) //Dialog
WebUI.verifyMatch(WebUI.getText(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ExportPDF/dialog_Title')), '.*Split To PDF.*', true) //Dialog title

'Select appropriate options on dialog'
WebUI.check(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ExportPDF/radio_Type_PDF'))
WebUI.check(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ExportPDF/radio_Annotation_No'))
WebUI.check(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ExportPDF/radio_Page_Selected'))
WebUI.selectOptionByLabel(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ExportPDF/select_DocClass'), 'WMI Menu', false)
WebUI.selectOptionByLabel(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ExportPDF/select_DocType'), 'WMI Menu BOV Vertical', false)
WebUI.check(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ExportPDF/check_IndexDocument'))

'Click on OK button'
WebUI.click(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ExportPDF/btn_Ok'))

'Switch to New window'
WebUI.switchToWindowIndex(2)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Enter data in text field'
String text  = 'Automation Script '+getCurrentDateTime(FORMAT_DATETIME)
WebUI.setText(findTestObject('Page_WMI_NEW/WMI_Menu_BOV_Vertical/input_String field'), text)

'Save details and close'
WebUI.mouseOver(findTestObject('Object Repository/Page_WMI_NEW/WMI_Menu_BOV/buttonStandardActions'))
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_WMI_NEW/WMI_Menu_BOV/buttonSave'), GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Window.clickElementAndWaitForWindowClose'(findTestObject('Object Repository/Page_WMI_NEW/WMI_Menu_BOV/buttonSave'),GlobalVariable.G_LongTimeout)

'Close previous window as well'
WebUI.closeWindowIndex(1)

'Switch to main window'
WebUI.switchToWindowIndex(0)

'Click Tree Menu - Recent Documents'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('HOME', 'Recent Documents')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/iframe_iframe_103'))

'Verify grid contains atleast 1 record'
WebUI.verifyElementPresent(findTestObject('Page_nGage_Dashboard/Home/tableRow_recentDocuments_firstRow'), GlobalVariable.G_LongTimeout);

'Refresh result grid'
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/span_Refresh Grid'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/iframe_iframe_103'))

'Sort Record in grid by DocID Descending'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'), 'Doc ID')
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'), 'Doc ID')

'Verify Icon displays is PDF for 1st document'
String imgSrc = WebUI.getAttribute(findTestObject('Page_nGage_Dashboard/Home/table_recent_firstrow_col_objectType'), 'src')
WebUI.verifyMatch(imgSrc, '.*i_g_PDF.gif.*', true)

'Open first document from grid'
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/column_RecentDocuments LastAction'))
WebUI.switchToWindowIndex(1)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Verify String field value'
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/input_eform_String_Input_Field'), 'value', text, GlobalVariable.G_LongTimeout)

'Open on Thumbnail'
CustomKeywords.'actions.Common.openThumbnail'(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/button_Thumbnail_Toggle'))

'Verify Thumbnail Grid is open now'
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/button_Thumbnail_Toggle'), 'class', 'ui-layout-toggler ui-layout-toggler-west ui-layout-toggler-open ui-layout-toggler-west-open', GlobalVariable.G_LongTimeout)
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/table_Thumbnail_Grid'))

'Verify thumbnail contains 2 items'
int actThumbnails = CustomKeywords.'actions.Table.getRowsCount'(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/table_Thumbnail_Grid'))
WebUI.verifyEqual(actThumbnails, 2)

'Click on Thumbnail 1'
WebUI.click(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/thumbnail_1'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
WebUI.waitForElementNotVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/image_Processing'), GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForImageRender'(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/image'))

'Verify page count summary'
WebUI.verifyMatch(WebUI.getText(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/pageCount')).trim(), '.*Page 1/2.*', true)

String image1 =  ImageUtil.captureImage()
String actText = CustomKeywords.'actions.OCR.readTextFromImage'(image1)

WebUI.verifyMatch(actText, '.*PAGE 2.*', true)

'Click on Thumbnail 2'
WebUI.click(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/thumbnail_2'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
WebUI.waitForElementNotVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/image_Processing'), GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForImageRender'(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/image'))

'Verify page count summary'
WebUI.verifyMatch(WebUI.getText(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/pageCount')).trim(), '.*Page 2/2.*', true)

String image2 =  ImageUtil.captureImage()
actText = CustomKeywords.'actions.OCR.readTextFromImage'(image2)

WebUI.verifyMatch(actText, '.*PAGE 4.*', true)

FileUtil.delete(image1)
FileUtil.delete(image2)