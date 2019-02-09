import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
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

String docID = ''

'Login into application'
CustomKeywords.'actions.Common.login'()

'Create new Document'
CustomKeywords.'actions.Common.createDocument_MultiPageViewerWithDragAndDrop'('Chintan Shah', 'No File', '')

'Go to Recent Documents tab'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('HOME', 'Recent Documents')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/iframe_iframe_103'))

'Validate atleast 1 record is present in the grid.'
int rowCount = CustomKeywords.'actions.Table.getRowsCount'(findTestObject('Page_nGage_Dashboard/Home/table_MyDocumentResults'))
WebUI.verifyGreaterThanOrEqual(rowCount, 1)

'Sort Record in grid by DocID Descending'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'), 'Doc ID')
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'), 'Doc ID')

int colNo_DocID = CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'), 'Doc ID')

'Open Document'
CustomKeywords.'actions.Table.clickCell'(findTestObject('Page_nGage_Dashboard/Home/table_MyDocumentResults'), 1, colNo_DocID)

'Switch to Document window'
WebUI.switchToWindowTitle('MultipageViewer with drag and drop')
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Add Document to Favorite document list'
WebUI.mouseOver(findTestObject('Page_WMI/MultiPage_Viewer_DD/span_Favorites'));
WebUI.waitForElementClickable(findTestObject('Page_WMI/MultiPage_Viewer_DD/a_Add to Favorites'), GlobalVariable.G_SmallTimeout)
WebUI.click(findTestObject('Page_WMI/MultiPage_Viewer_DD/a_Add to Favorites'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Verify Success message'
WebUI.waitForElementVisible(findTestObject('Page_WMI/MultiPage_Viewer_DD/span_Document successfully add'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementText(findTestObject('Page_WMI/MultiPage_Viewer_DD/span_Document successfully add'), 'Document successfully added to Favorite Documents.')

'Close WMI Window'
WebUI.closeWindowIndex(1)

'Switch to parent window'
WebUI.switchToWindowIndex(0)

'Refresh parent window'
WebUI.refresh()
WebUI.delay(3)

//WMI Menu Bov Check
'Pre-Requisite : Create new Document of type WMI Menu Bov'
CustomKeywords.'actions.Common.createDocument_WMIMenuBov'()

'Pre-Requisite : Open newly created document from recent grid'
CustomKeywords.'actions.Common.openDocumentFromRecentGrid'('WMI Menu BOV')

'Navigate and verify pageSource'
WebUI.waitForElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV/span_Attachments'), GlobalVariable.G_LongTimeout)
WebUI.mouseOver(findTestObject('Page_WMI/WMI_Menu_BOV/span_Attachments'))
WebUI.waitForElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV/a_AttachFromFavorites'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_WMI/WMI_Menu_BOV/a_AttachFromFavorites'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Object Repository/Page_WMI/WMI_Menu_BOV/iframe_Close_ContentPlaceHolde'), 'src'), '.*AttachFavorite.aspx.*', true)

'Select 1st Document in the table and attache it'
docID = CustomKeywords.'actions.Table.getCellText'(findTestObject('Page_WMI/WMI_Menu_BOV/Attachements/table_AttachFromFavorite_Documents'), 1, 6)
CustomKeywords.'actions.Table.checkRecordInTable'(findTestObject('Page_WMI/WMI_Menu_BOV/Attachements/table_AttachFromFavorite_Documents'), 1)
WebUI.click(findTestObject('Page_WMI/WMI_Menu_BOV/Attachements/btn_AttacheDocument'))

'Go to current attachements menu'
WebUI.mouseOver(findTestObject('Object Repository/Page_WMI/WMI_Menu_BOV/span_Attachments'))
WebUI.waitForElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV/a_Current Attachments'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_WMI/WMI_Menu_BOV/a_Current Attachments'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Verify correct document is attached'
CustomKeywords.'actions.Table.verifyRecordsCount'(findTestObject('Page_WMI/WMI_Menu_BOV/Attachements/table_CurrentAttachements_Documents'), 1)
CustomKeywords.'actions.Table.verifyCellContainsValue'(findTestObject('Page_WMI/WMI_Menu_BOV/Attachements/table_CurrentAttachements_Documents'), 1, 3, docID)

'Close Document'
WebUI.click(findTestObject('Object Repository/Page_WMI/WMI_Menu_BOV/span_Close'))


//WMI Menu Bov Default Check
'Pre-Requisite : Create new Document of type WMI Menu Bov Default'
CustomKeywords.'actions.Common.createDocument_WMIMenuBovDefault'()

'Pre-Requisite : Open newly created document from recent grid'
CustomKeywords.'actions.Common.openDocumentFromRecentGrid'('WMI Menu Default')

'Navigate and verify pageSource'
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_WMI/WMI_Menu_BOV_Default/span_Attachments'), GlobalVariable.G_LongTimeout)
WebUI.mouseOver(findTestObject('Object Repository/Page_WMI/WMI_Menu_BOV_Default/span_Attachments'))
WebUI.waitForElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Default/a_AttachFromFavorites'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_WMI/WMI_Menu_BOV_Default/a_AttachFromFavorites'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Object Repository/Page_WMI/WMI_Menu_BOV_Default/iframe_Close_ContentPlaceHolde'), 'src'), '.*AttachFavorite.aspx.*', true)

'Select 1st Document in the table and attache it'
docID = CustomKeywords.'actions.Table.getCellText'(findTestObject('Page_WMI/WMI_Menu_BOV_Default/Attachements/table_AttachFromFavorite_Documents'), 1, 6)
CustomKeywords.'actions.Table.checkRecordInTable'(findTestObject('Page_WMI/WMI_Menu_BOV_Default/Attachements/table_AttachFromFavorite_Documents'), 1)
WebUI.click(findTestObject('Page_WMI/WMI_Menu_BOV_Default/Attachements/btn_AttacheDocument'))

'Go to current attachements menu'
WebUI.mouseOver(findTestObject('Object Repository/Page_WMI/WMI_Menu_BOV_Default/span_Attachments'))
WebUI.waitForElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Default/a_Current Attachments'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_WMI/WMI_Menu_BOV_Default/a_Current Attachments'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Verify correct document is attached'
CustomKeywords.'actions.Table.verifyRecordsCount'(findTestObject('Page_WMI/WMI_Menu_BOV_Default/Attachements/table_CurrentAttachements_Documents'), 1)
CustomKeywords.'actions.Table.verifyCellContainsValue'(findTestObject('Page_WMI/WMI_Menu_BOV_Default/Attachements/table_CurrentAttachements_Documents'), 1, 3, docID)

'Close Document'
WebUI.click(findTestObject('Object Repository/Page_WMI/WMI_Menu_BOV_Default/span_Close'))

//WMI Menu Bov DocTwoRow Check
'Pre-Requisite : Create new Document of type WMI Menu Bov DocTwoRow'
CustomKeywords.'actions.Common.createDocument_WMIMenuBovDocTwoRow'()

'Pre-Requisite : Open newly created document from recent grid'
CustomKeywords.'actions.Common.openDocumentFromRecentGrid'('WMI Menu DocTwoRow')

'Navigate and verify pageSource'
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_WMI/WMI_Menu_BOV_DocTwoRow/span_Attachments'), GlobalVariable.G_LongTimeout)
WebUI.mouseOver(findTestObject('Object Repository/Page_WMI/WMI_Menu_BOV_DocTwoRow/span_Attachments'))
WebUI.waitForElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_DocTwoRow/a_AttachFromFavorites'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_WMI/WMI_Menu_BOV_DocTwoRow/a_AttachFromFavorites'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Object Repository/Page_WMI/WMI_Menu_BOV_DocTwoRow/iframe_Close_ContentPlaceHolde'), 'src'), '.*AttachFavorite.aspx.*', true)

'Select 1st Document in the table and attache it'
docID = CustomKeywords.'actions.Table.getCellText'(findTestObject('Page_WMI/WMI_Menu_BOV_DocTwoRow/Attachements/table_AttachFromFavorite_Documents'), 1, 6)
CustomKeywords.'actions.Table.checkRecordInTable'(findTestObject('Page_WMI/WMI_Menu_BOV_DocTwoRow/Attachements/table_AttachFromFavorite_Documents'), 1)
WebUI.click(findTestObject('Page_WMI/WMI_Menu_BOV_DocTwoRow/Attachements/btn_AttacheDocument'))

'Go to current attachements menu'
WebUI.mouseOver(findTestObject('Object Repository/Page_WMI/WMI_Menu_BOV_DocTwoRow/span_Attachments'))
WebUI.waitForElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_DocTwoRow/a_Current Attachments'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_WMI/WMI_Menu_BOV_DocTwoRow/a_Current Attachments'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Verify correct document is attached'
CustomKeywords.'actions.Table.verifyRecordsCount'(findTestObject('Page_WMI/WMI_Menu_BOV_DocTwoRow/Attachements/table_CurrentAttachements_Documents'), 1)
CustomKeywords.'actions.Table.verifyCellContainsValue'(findTestObject('Page_WMI/WMI_Menu_BOV_DocTwoRow/Attachements/table_CurrentAttachements_Documents'), 1, 3, docID)

'Close Document'
WebUI.click(findTestObject('Object Repository/Page_WMI/WMI_Menu_BOV_DocTwoRow/span_Close'))