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
import internal.GlobalVariable as GlobalVariable
import utils.ImageUtil

'Login into application'
CustomKeywords.'actions.Common.login'()

'Pre-Requisite : Create new Document of type WMI Menu Bov Vertical'
String filePath = RunConfiguration.getProjectDir().replace('/', '\\')+'\\Data Files\\FileUploads\\TextPDF.pdf'
CustomKeywords.'actions.Common.createDocument_WMIMenuBovVertical'('FILE - MULTIPAGE VIEWER', filePath)

'Pre-Requisite : Open newly created document from recent grid'
CustomKeywords.'actions.Common.openDocumentFromRecentGrid'('WMI Menu BOV Vertical')
CustomKeywords.'actions.Common.waitForImageToRender'(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/iFrame_Image_EPMMultipageViewer'))

'Open on Thumbnail'
CustomKeywords.'actions.Common.openThumbnail'(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/button_Thumbnail_Toggle'))

'Verify Thumbnail Grid is open now'
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/button_Thumbnail_Toggle'), 'class', 'ui-layout-toggler ui-layout-toggler-west ui-layout-toggler-open ui-layout-toggler-west-open', GlobalVariable.G_LongTimeout)
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/table_Thumbnail_Grid'))

'Clear clipboard'
CustomKeywords.'actions.Common.clearClipBoard'()

List<TestObject> elements = new ArrayList<TestObject>()
elements.add(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/thumbnail_2'))
elements.add(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/thumbnail_4'))

'Click on Multiple Thumbnails Thumbnail 1(Default selected), Thumbnail 2 and Thumbnail 4'
CustomKeywords.'actions.Common.clickMultipleElements'(elements)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForImageToRender'(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/iFrame_Image_EPMMultipageViewer'))

//Add to clipboard
'Click on clipboard menu'
WebUI.click(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/menu_Clipboard'))

'Click on Add to clipboard'
WebUI.waitForElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/subMenu_Clipboard_Add to Clipboard'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/subMenu_Clipboard_Add to Clipboard'))

//'Open Clipboard document'
'Click on clipboard menu'
WebUI.click(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/menu_Clipboard'))

'Click on View clipboard'
WebUI.waitForElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/subMenu_Clipboard_View Clipboard'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/subMenu_Clipboard_View Clipboard'))

//Verify all documents are in clipboard
'Switch to Clipboard window'
WebUI.switchToWindowTitle('Clipboard')
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Open Thumbnail'
CustomKeywords.'actions.Common.openThumbnail'(findTestObject('Page_WMI/Clipboard/Slider_toggler'))

'Verify Thumbnail section is visible'
WebUI.verifyElementVisible(findTestObject('Page_WMI/Clipboard/section_Thumbnail'))

'Drag Thumbnail 1 over Thumbnail 2'
WebUI.dragAndDropToObject(findTestObject('Page_WMI/Clipboard/Thumbnail 1'), findTestObject('Page_WMI/Clipboard/Thumbnail 2'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForImageToRender'(findTestObject('Page_WMI/Clipboard/iFrame_Image_EPMMultipageViewer'))

'Click on Thumbnail 1'
WebUI.click(findTestObject('Page_WMI/Clipboard/Thumbnail 1'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForImageToRender'(findTestObject('Page_WMI/Clipboard/iFrame_Image_EPMMultipageViewer'))

'Verify page count summary'
WebUI.verifyMatch(WebUI.getText(findTestObject('Page_WMI/Clipboard/pagination_summary')).trim(), '.*Page 1/2.*', true)

String image =  ImageUtil.captureImage(findTestObject('Page_WMI/Clipboard/image'))
String actText = CustomKeywords.'actions.OCR.readTextFromImage'(image)

WebUI.verifyMatch(actText, '.*PAGE 4.*', true)

'Click on Thumbnail 2'
WebUI.click(findTestObject('Page_WMI/Clipboard/Thumbnail 2'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForImageToRender'(findTestObject('Page_WMI/Clipboard/iFrame_Image_EPMMultipageViewer'))

'Verify page count summary'
WebUI.verifyMatch(WebUI.getText(findTestObject('Page_WMI/Clipboard/pagination_summary')).trim(), '.*Page 2/2.*', true)

image =  ImageUtil.captureImage(findTestObject('Page_WMI/Clipboard/image'))
actText = CustomKeywords.'actions.OCR.readTextFromImage'(image)

WebUI.verifyMatch(actText, '.*PAGE 2.*', true)



//'Login into application'
//CustomKeywords.'actions.Common.login'()
//
//'Pre-Requisite : Create new Document of type WMI Menu Bov Vertical'
//CustomKeywords.'actions.Common.createDocument_WMIMenuBovVertical'()
//
//'Pre-Requisite : Open newly created document from recent grid'
//CustomKeywords.'actions.Common.openDocumentFromRecentGrid'('WMI Menu BOV Vertical')
//
//'Click on Thumbnail'
//CustomKeywords.'actions.Common.openThumbnail'(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/button_Thumbnail_Toggle'))
//
//'Clear clipboard'
//CustomKeywords.'actions.Common.clearClipBoard'()
//
////Select 3 Thumbnails
//List<TestObject> elements = new ArrayList<TestObject>()
//elements.add(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/thumbnail_2'))
//elements.add(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/thumbnail_4'))
//'Click on Multiple Thumbnails Thumbnail 1(Default selected), Thumbnail 2 and Thumbnail 4'
//CustomKeywords.'actions.Common.clickMultipleElements'(elements)
//WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
//
////Add all 3 thumbnails to clipbpard
//'Click on clipboard menu'
//WebUI.click(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/menu_Clipboard'))
//'Click on Add to clipboard'
//WebUI.click(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/subMenu_Clipboard_Add to Clipboard'))
//
////Open Clipboard document
//'Click on clipboard menu'
//WebUI.click(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/menu_Clipboard'))
//'Click on View clipboard'
//WebUI.click(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/subMenu_Clipboard_View Clipboard'))
//
//'Switch to Clipboard window'
//WebUI.switchToWindowTitle('Clipboard')
//WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
//
//'Drag Thumbnail 2 over Thumbnail 3'
//WebUI.dragAndDropToObject(findTestObject('Page_WMI/Clipboard/Thumbnail 2'), findTestObject('Page_WMI/Clipboard/Thumbnail 3'))
//
//'Verify Page summary'
//WebUI.verifyMatch(WebUI.getText(findTestObject('Page_WMI/Clipboard/pagination_summary')).trim(), '.*Page 3/3.*', true)