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
import utils.FileUtil
import utils.ImageUtil
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

'Clear clipboard'
CustomKeywords.'actions.Common.clearClipBoard'()

List<TestObject> elements = new ArrayList<TestObject>()
elements.add(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/thumbnail_2'))
elements.add(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/thumbnail_3'))
elements.add(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/thumbnail_4'))

'Click on Multiple Thumbnails Thumbnail 1(Default selected), Thumbnail 2, Thumbnail 3 and Thumbnail 4'
CustomKeywords.'actions.Common.clickMultipleElements'(elements)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
WebUI.waitForElementNotVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/image_Processing'), GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForImageRender'(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/image'))

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

List<TestObject> clipboarElements = new ArrayList<TestObject>()
clipboarElements.add(findTestObject('Page_WMI/Clipboard/Thumbnail 1'))
clipboarElements.add(findTestObject('Page_WMI/Clipboard/Thumbnail 2'))

'Click on Multiple Thumbnails Thumbnail 1, Thumbnail 2'
CustomKeywords.'actions.Common.clickMultipleElements'(clipboarElements)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
WebUI.waitForElementNotVisible(findTestObject('Page_WMI/Clipboard/image_Processing'), GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForImageRender'(findTestObject('Page_WMI/Clipboard/image'))

'Click on Page Menu'
WebUI.click(findTestObject('Page_WMI/Clipboard/menu_Page'))

'Click on Delete option'
WebUI.waitForElementVisible(findTestObject('Page_WMI/Clipboard/subMenu_Page_Delete'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_WMI/Clipboard/subMenu_Page_Delete'))

'Verify window.alert message'
WebUI.waitForAlert(GlobalVariable.G_LongTimeout)
String alertText = WebUI.getAlertText().trim()
WebUI.verifyEqual(alertText, 'Are you sure you want to mark page(s) as Remove?')

'Click OK button on alert dialog'
WebUI.acceptAlert()
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Verify Page summary'
WebUI.verifyMatch(WebUI.getText(findTestObject('Page_WMI/Clipboard/pagination_summary')).trim(), '.*Page 1/1.*', true)

'Click on Clipboard Menu'
WebUI.click(findTestObject('Page_WMI/Clipboard/menu_Clipboard'))

'Click on Save back to clipboard'
WebUI.click(findTestObject('Page_WMI/Clipboard/subMenu_Clipboard_Save back to Clipboard'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Close Clipboard window'
WebUI.closeWindowTitle('Clipboard')

'Switch to WMI Document'
WebUI.switchToWindowTitle('WMI Menu BOV Vertical')

//Open Clipboard document
'Click on clipboard menu'
WebUI.click(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/menu_Clipboard'))

'Click on View clipboard'
CustomKeywords.'actions.Common.waitForElementVisible'(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/subMenu_Clipboard_View Clipboard'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/subMenu_Clipboard_View Clipboard'))

'Switch to WMI Document'
WebUI.switchToWindowTitle('Clipboard')
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
WebUI.waitForElementNotVisible(findTestObject('Page_WMI/Clipboard/image_Processing'), GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForImageRender'(findTestObject('Page_WMI/Clipboard/image'))

'Verify Page summary'
WebUI.verifyMatch(WebUI.getText(findTestObject('Page_WMI/Clipboard/pagination_summary')).trim(), '.*Page 1/1.*', true)

String image =  ImageUtil.captureImage(findTestObject('Page_WMI/Clipboard/image'))
String actText = CustomKeywords.'actions.OCR.readTextFromImage'(image)

WebUI.verifyMatch(actText, '.*PAGE 4.*', true)

FileUtil.delete(image)