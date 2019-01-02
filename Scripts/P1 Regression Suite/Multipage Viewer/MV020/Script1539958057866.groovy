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

'Click on Thumbnail 2'
WebUI.click(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/thumbnail_2'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForImageToRender'(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/iFrame_Image_EPMMultipageViewer'))

'Verify page count summary'
WebUI.verifyMatch(WebUI.getText(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/pageCount')).trim(), '.*Page 2/8.*', true)

'Click on Page menu'
WebUI.click(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/menu_Page'))

'Click on Insert before page'
WebUI.waitForElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/subMenu_Page_Insert Before..'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/subMenu_Page_Insert Before..'))

String filePathUpd = RunConfiguration.getProjectDir().replace('/', '\\')+'\\Data Files\\FileUploads\\InsertTextPDF.pdf'
'Select file to upload'
WebUI.waitForElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/fileUpload_Field'), GlobalVariable.G_LongTimeout)
WebUI.uploadFile(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/fileUpload_Field'), filePathUpd)

'Click on OK button to upload file'
WebUI.click(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/fileUpload_OK_button'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/iframe_westContainerFrame'))
CustomKeywords.'actions.Common.waitForImageToRender'(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/iFrame_Image_EPMMultipageViewer'))

'Verify Page count is now updated'
WebUI.verifyMatch(WebUI.getText(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/pageCount')).trim(), '.*Page 2/10.*', true)

'Open on Thumbnail'
CustomKeywords.'actions.Common.openThumbnail'(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/button_Thumbnail_Toggle'))

'Click on Thumbnail 2'
WebUI.click(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/thumbnail_2'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForImageToRender'(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/iFrame_Image_EPMMultipageViewer'))

'Verify page count summary'
WebUI.verifyMatch(WebUI.getText(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/pageCount')).trim(), '.*Page 2/10.*', true)

String image =  ImageUtil.captureImage()
String actText = CustomKeywords.'actions.OCR.readTextFromImage'(image)

WebUI.verifyMatch(actText, '.*INSERT 1.*', true)

'Open on Thumbnail'
CustomKeywords.'actions.Common.openThumbnail'(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/button_Thumbnail_Toggle'))

'Click on Thumbnail 3'
WebUI.click(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/thumbnail_3'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForImageToRender'(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/iFrame_Image_EPMMultipageViewer'))

'Verify page count summary'
WebUI.verifyMatch(WebUI.getText(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/pageCount')).trim(), '.*Page 3/10.*', true)

image =  ImageUtil.captureImage()
actText = CustomKeywords.'actions.OCR.readTextFromImage'(image)

WebUI.verifyMatch(actText, '.*INSERT 2.*', true)

'Click on Thumbnail 4'
WebUI.click(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/thumbnail_4'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForImageToRender'(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/iFrame_Image_EPMMultipageViewer'))

'Verify page count summary'
WebUI.verifyMatch(WebUI.getText(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/pageCount')).trim(), '.*Page 4/10.*', true)

image =  ImageUtil.captureImage()
actText = CustomKeywords.'actions.OCR.readTextFromImage'(image)

WebUI.verifyMatch(actText, '.*PAGE 2.*', true)
