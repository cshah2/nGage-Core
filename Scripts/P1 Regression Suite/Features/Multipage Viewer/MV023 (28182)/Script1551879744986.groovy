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

'Click on Thumbnail 3'
WebUI.click(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/thumbnail_3'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
WebUI.waitForElementNotVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/image_Processing'), GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForImageRender'(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/image'))

'Verify page count value in summary'
WebUI.verifyMatch(WebUI.getText(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/pageCount')).trim(), '.*Page 3/8.*', true)

'Click on Page menu'
WebUI.click(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/menu_Page'))

'Click on Delete'
WebUI.waitForElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/subMenu_Page_Delete'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/subMenu_Page_Delete'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/iframe_westContainer'))

'Verify Message on Delete confirmation prompt'
WebUI.verifyMatch(WebUI.getText(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/ConfirmationDialog_message')).replace('&nbsp;',' ').trim(), 'Are you sure you want to mark page(s) as Delete?', false)

'Click on OK button on confirmation prompt'
WebUI.click(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/ConfirmationDialog_Ok_button'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/iframe_westContainerFrame'))
WebUI.waitForElementNotVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/image_Processing'), GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForImageRender'(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/image'))

'Click on Thumbnail 3'
WebUI.click(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/thumbnail_3'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
WebUI.waitForElementNotVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/image_Processing'), GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForImageRender'(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/image'))

'Verify page count summary'
WebUI.verifyMatch(WebUI.getText(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/pageCount')).trim(), '.*Page 3/7.*', true)

String image =  ImageUtil.captureImage()
String actText = CustomKeywords.'actions.OCR.readTextFromImage'(image)

WebUI.verifyMatch(actText, '.*PAGE 4.*', true)

FileUtil.delete(image)