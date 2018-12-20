import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

'Login into application'
CustomKeywords.'actions.Common.login'()

'Pre-Requisite : Create new Document of type WMI Menu Bov Vertical'
CustomKeywords.'actions.Common.createDocument_WMIMenuBovVertical'()

'Pre-Requisite : Open newly created document from recent grid'
CustomKeywords.'actions.Common.openDocumentFromRecentGrid'('WMI Menu BOV Vertical')

'Click on Thumbnail'
CustomKeywords.'actions.Common.openThumbnail'(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/button_Thumbnail_Toggle'))

List<TestObject> elements = new ArrayList<TestObject>()
elements.add(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/thumbnail_2'))
elements.add(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/thumbnail_4'))

'Click on Multiple Thumbnails Thumbnail 1(Default selected), Thumbnail 2 and Thumbnail 4'
CustomKeywords.'actions.Common.clickMultipleElements'(elements)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Click on Page menu'
WebUI.click(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/menu_Page'))

'Click on Delete'
WebUI.click(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/subMenu_Page_Delete'))

'Verify Message on Delete confirmation prompt'
WebUI.verifyMatch(WebUI.getText(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/ConfirmationDialog_message')).replace('&nbsp;',' ').trim(), 'Are you sure you want to mark page(s) as Delete?', false)

'Click on OK button on confirmation prompt'
WebUI.click(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/ConfirmationDialog_Ok_button'))

WebUI.waitForElementNotVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/image_Processing'), GlobalVariable.G_LongTimeout, FailureHandling.STOP_ON_FAILURE)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/iframe_westContainerFrame'))

'Verify Page count is now updated'
WebUI.verifyMatch(WebUI.getText(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/pageCount')).trim(), '.*Page 4/47.*', true)
