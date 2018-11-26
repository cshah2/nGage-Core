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

//WMI Menu Bov Check
'Pre-Requisite : Create new Document of type WMI Menu Bov'
CustomKeywords.'actions.Common.createDocument_WMIMenuBov'()

'Pre-Requisite : Open newly created document from recent grid'
CustomKeywords.'actions.Common.openDocumentFromRecentGrid'('WMI Menu BOV')

'Expand Fields section'
WebUI.waitForElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV/span_MORE'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Object Repository/Page_WMI/WMI_Menu_BOV/div_Capture object_northToggle'))

'Verify all menus are visible'
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV/span_Doc Info1'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV/span_CheckOut'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV/span_eForms'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV/span_History'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV/span_Favorites'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV/span_Attachments'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV/span_MORE'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV/span_Close'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV/span_Standard Actions'))

'Verify all submenus under checkout'
WebUI.mouseOver(findTestObject('Page_WMI/WMI_Menu_BOV/span_CheckOut'))
WebUI.waitForElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV/a_Check Out'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV/a_Check Out'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV/a_Check In as New Revision'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV/a_Check In as Replacement'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV/a_Check In'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV/a_Checkout and Edit'))

'Verify all submenus under History'
WebUI.mouseOver(findTestObject('Page_WMI/WMI_Menu_BOV/span_History'))
WebUI.waitForElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV/a_AuditHistory'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV/a_AuditHistory'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV/a_BusinessProcessHistory'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV/a_BusinessProcessAudit'))

'Verify all submenus under Favorites'
WebUI.mouseOver(findTestObject('Page_WMI/WMI_Menu_BOV/span_Favorites'))
WebUI.waitForElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV/a_AddToFavorites'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV/a_AddToFavorites'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV/a_Remove from Favorites'))

'Verify all submenus under Attachements'
WebUI.mouseOver(findTestObject('Page_WMI/WMI_Menu_BOV/span_Attachments'))
WebUI.waitForElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV/a_Current Attachments'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV/a_Current Attachments'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV/a_AttachNewDocument'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV/a_AttachFromFavorites'))

'Verify all submenus under More'
WebUI.mouseOver(findTestObject('Page_WMI/WMI_Menu_BOV/span_MORE'))
WebUI.waitForElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV/a_Reindex Document Type'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV/a_Reindex Document Type'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV/a_COPY'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV/a_Search documents'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV/a_External Sites'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV/a_Notes'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV/a_Delete'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV/a_Print Header Sheet'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV/a_View Contents'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV/a_Import'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV/a_View Image_1'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV/a_Search documents in Tab'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV/a_Index Export'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV/a_Reindex'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV/a_Split Page'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV/a_Property MenuContainer'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV/a_Email  Favorites_1'))
WebUI.mouseOver(findTestObject('Page_WMI/WMI_Menu_BOV/a_Email  Favorites_1'))
WebUI.waitForElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV/a_Send To Recepient By Email'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV/a_Send To Recepient By Email'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV/a_Show Link'))

'Verify all submenus under Standard Actions'
WebUI.mouseOver(findTestObject('Page_WMI/WMI_Menu_BOV/span_Standard Actions'))
WebUI.waitForElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV/a_Change Doc Class'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV/a_Change Doc Class'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV/a_Save'))

//WMI Menu Bov Default Check
'Pre-Requisite : Create new Document of type WMI Menu Default'
CustomKeywords.'actions.Common.createDocument_WMIMenuBovDefault'()

'Pre-Requisite : Open newly created document from recent grid'
CustomKeywords.'actions.Common.openDocumentFromRecentGrid'('WMI Menu Default')

'Expand Fields section'
WebUI.waitForElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Default/span_MORE'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Object Repository/Page_WMI/WMI_Menu_BOV_Default/div_Capture object_northToggle'))

'Verify all menus are visible'
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Default/span_Doc Info1'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Default/span_CheckOut'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Default/span_eForms'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Default/span_History'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Default/span_Favorites'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Default/span_Attachments'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Default/span_MORE'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Default/span_Close'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Default/span_Standard Actions'))

'Verify all submenus under checkout'
WebUI.mouseOver(findTestObject('Page_WMI/WMI_Menu_BOV_Default/span_CheckOut'))
WebUI.waitForElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Default/a_Check Out'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Default/a_Check Out'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Default/a_Check In as New Revision'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Default/a_Check In as Replacement'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Default/a_Check In'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Default/a_Checkout and Edit'))

'Verify all submenus under History'
WebUI.mouseOver(findTestObject('Page_WMI/WMI_Menu_BOV_Default/span_History'))
WebUI.waitForElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Default/a_AuditHistory'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Default/a_AuditHistory'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Default/a_BusinessProcessHistory'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Default/a_BusinessProcessAudit'))

'Verify all submenus under Favorites'
WebUI.mouseOver(findTestObject('Page_WMI/WMI_Menu_BOV_Default/span_Favorites'))
WebUI.waitForElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Default/a_AddToFavorites'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Default/a_AddToFavorites'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Default/a_Remove from Favorites'))

'Verify all submenus under Attachements'
WebUI.mouseOver(findTestObject('Page_WMI/WMI_Menu_BOV_Default/span_Attachments'))
WebUI.waitForElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Default/a_Current Attachments'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Default/a_Current Attachments'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Default/a_AttachNewDocument'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Default/a_AttachFromFavorites'))

'Verify all submenus under More'
WebUI.mouseOver(findTestObject('Page_WMI/WMI_Menu_BOV_Default/span_MORE'))
WebUI.waitForElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Default/a_Reindex Document Type'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Default/a_Reindex Document Type'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Default/a_COPY'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Default/a_Search documents'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Default/a_External Sites'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Default/a_Notes'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Default/a_Delete'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Default/a_Print Header Sheet'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Default/a_View Contents'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Default/a_Import'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Default/a_View Image_1'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Default/a_Search documents in Tab'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Default/a_Index Export'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Default/a_Reindex'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Default/a_Split Page'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Default/a_Property MenuContainer'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Default/a_Email  Favorites_1'))
WebUI.mouseOver(findTestObject('Page_WMI/WMI_Menu_BOV_Default/a_Email  Favorites_1'))
WebUI.waitForElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Default/a_Send To Recepient By Email'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Default/a_Send To Recepient By Email'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Default/a_Show Link'))

'Verify all submenus under Standard Actions'
WebUI.mouseOver(findTestObject('Page_WMI/WMI_Menu_BOV_Default/span_Standard Actions'))
WebUI.waitForElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Default/a_Change Doc Class'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Default/a_Change Doc Class'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Default/a_Save'))

//WMI Menu Bov DocTwoRow Check
'Pre-Requisite : Create new Document of type WMI Menu DocTwoRow'
CustomKeywords.'actions.Common.createDocument_WMIMenuBovDocTwoRow'()

'Pre-Requisite : Open newly created document from recent grid'
CustomKeywords.'actions.Common.openDocumentFromRecentGrid'('WMI Menu DocTwoRow')

'Expand Fields section'
WebUI.waitForElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_DocTwoRow/span_MORE'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Object Repository/Page_WMI/WMI_Menu_BOV_DocTwoRow/div_Capture object_northToggle'))

'Verify all menus are visible'
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_DocTwoRow/span_Doc Info'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_DocTwoRow/span_CheckOut'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_DocTwoRow/span_eForms'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_DocTwoRow/span_History'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_DocTwoRow/span_Favorites'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_DocTwoRow/span_Attachments'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_DocTwoRow/span_MORE'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_DocTwoRow/span_Close'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_DocTwoRow/span_Standard Actions'))

'Verify all submenus under checkout'
WebUI.mouseOver(findTestObject('Page_WMI/WMI_Menu_BOV_DocTwoRow/span_CheckOut'))
WebUI.waitForElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_DocTwoRow/a_Check Out'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_DocTwoRow/a_Check Out'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_DocTwoRow/a_Check In as New Revision'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_DocTwoRow/a_Check In as Replacement'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_DocTwoRow/a_Check In'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_DocTwoRow/a_Checkout and Edit'))

'Verify all submenus under History'
WebUI.mouseOver(findTestObject('Page_WMI/WMI_Menu_BOV_DocTwoRow/span_History'))
WebUI.waitForElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_DocTwoRow/a_AuditHistory'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_DocTwoRow/a_AuditHistory'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_DocTwoRow/a_BusinessProcessHistory'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_DocTwoRow/a_BusinessProcessAudit'))

'Verify all submenus under Favorites'
WebUI.mouseOver(findTestObject('Page_WMI/WMI_Menu_BOV_DocTwoRow/span_Favorites'))
WebUI.waitForElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_DocTwoRow/a_AddToFavorites'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_DocTwoRow/a_AddToFavorites'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_DocTwoRow/a_Remove from Favorites'))

'Verify all submenus under Attachements'
WebUI.mouseOver(findTestObject('Page_WMI/WMI_Menu_BOV_DocTwoRow/span_Attachments'))
WebUI.waitForElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_DocTwoRow/a_Current Attachments'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_DocTwoRow/a_Current Attachments'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_DocTwoRow/a_AttachNewDocument'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_DocTwoRow/a_AttachFromFavorites'))

'Verify all submenus under More'
WebUI.mouseOver(findTestObject('Page_WMI/WMI_Menu_BOV_DocTwoRow/span_MORE'))
WebUI.waitForElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_DocTwoRow/a_Reindex Document Type'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_DocTwoRow/a_Reindex Document Type'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_DocTwoRow/a_COPY'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_DocTwoRow/a_Search documents'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_DocTwoRow/a_External Sites'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_DocTwoRow/a_Notes'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_DocTwoRow/a_Delete'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_DocTwoRow/a_Print Header Sheet'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_DocTwoRow/a_View Contents'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_DocTwoRow/a_Import'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_DocTwoRow/a_View Image_1'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_DocTwoRow/a_Search documents in Tab'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_DocTwoRow/a_Index Export'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_DocTwoRow/a_Reindex'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_DocTwoRow/a_Split Page'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_DocTwoRow/a_Property MenuContainer'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_DocTwoRow/a_Email  Favorites_1'))
WebUI.mouseOver(findTestObject('Page_WMI/WMI_Menu_BOV_DocTwoRow/a_Email  Favorites_1'))
WebUI.waitForElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_DocTwoRow/a_Send To Recepient By Email'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_DocTwoRow/a_Send To Recepient By Email'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_DocTwoRow/a_Show Link'))

'Verify all submenus under Standard Actions'
WebUI.mouseOver(findTestObject('Page_WMI/WMI_Menu_BOV_DocTwoRow/span_Standard Actions'))
WebUI.waitForElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_DocTwoRow/a_Change Doc Class'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_DocTwoRow/a_Change Doc Class'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_DocTwoRow/a_Save'))
