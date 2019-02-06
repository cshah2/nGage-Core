import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import utils.Consts

'Login Into Application'
CustomKeywords.'actions.Common.login'()

'Create new Document'
CustomKeywords.'actions.Common.createDocument_MultiPageViewerWithDragAndDrop'(Consts.SMOKE_HOME005_STRINGFIELD, Consts.SMOKE_HOME005_FILENAME, '')

'Go to Recent Documents tab'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('HOME', 'Recent Documents')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/iframe_iframe_103'))

'Validate atleast 1 record is present in the grid.'
int rowCount = CustomKeywords.'actions.Table.getRowsCount'(findTestObject('Page_nGage_Dashboard/Home/table_MyDocumentResults'))
WebUI.verifyGreaterThanOrEqual(rowCount, 1)

'Sort Record in grid by DocID Descending'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'), 'Doc ID')
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'), 'Doc ID')

'Verify Column values for 1st Record in Grid.'
WebUI.verifyElementText(findTestObject('Page_nGage_Dashboard/Home/column_RecentDocuments DocumentTitle'), 'MultipageViewer with drag and drop')
WebUI.verifyElementText(findTestObject('Page_nGage_Dashboard/Home/column_RecentDocuments DocumentType'), 'MultipageViewer with drag and drop')
WebUI.verifyElementText(findTestObject('Page_nGage_Dashboard/Home/column_RecentDocuments LastAction'), 'Created')

int colNo_DocID = CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'), 'Doc ID')

'Copy Document ID value of 1st Record and Save it for other test cases.'
Consts.SMOKE_HOME005_DOCID = CustomKeywords.'actions.Table.getCellText'(findTestObject('Page_nGage_Dashboard/Home/table_MyDocumentResults'), 1, colNo_DocID)

'Open Document'
CustomKeywords.'actions.Table.clickCell'(findTestObject('Page_nGage_Dashboard/Home/table_MyDocumentResults'), 1, colNo_DocID)

'Switch to Document window'
//WebUI.switchToWindowTitle('MultipageViewer with drag and drop')
WebUI.switchToWindowIndex(1)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Add Document to Favorite document list'
WebUI.mouseOver(findTestObject('Page_WMI/MultiPage_Viewer_DD/span_Favorites'));
WebUI.waitForElementClickable(findTestObject('Page_WMI/MultiPage_Viewer_DD/a_Add to Favorites'), GlobalVariable.G_SmallTimeout)
WebUI.click(findTestObject('Page_WMI/MultiPage_Viewer_DD/a_Add to Favorites'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Verify Success message'
WebUI.waitForElementVisible(findTestObject('Page_WMI/MultiPage_Viewer_DD/span_Document successfully add'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementText(findTestObject('Page_WMI/MultiPage_Viewer_DD/span_Document successfully add'), 'Document successfully added to Favorite Documents.')

'Close WMI'
WebUI.closeWindowIndex(1)

'Switch to parent window'
WebUI.switchToWindowIndex(0)

'Click on Favorite Documents tab'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('HOME', 'Favorite Documents')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/iframe_iframe_103'))

'Verify popup dialog is not displayed'
WebUI.verifyElementNotPresent(findTestObject('Page_nGage_Dashboard/Home/dialog_NoFavoriteDocuments'), GlobalVariable.G_LongTimeout)

'Validate atleast 1 record is present in the grid.'
rowCount = CustomKeywords.'actions.Table.getRowsCount'(findTestObject('Page_nGage_Dashboard/Home/table_MyDocumentResults'))
WebUI.verifyGreaterThanOrEqual(rowCount, 1)

'Sort records in tables based on DOC ID - Descending'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'), 'Doc ID')
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'), 'Doc ID')

'Validate Column data in first row'
WebUI.verifyElementText(findTestObject('Page_nGage_Dashboard/Home/column_favoriteDocuments DocumentTitle'), 'MultipageViewer with drag and drop')
WebUI.verifyElementText(findTestObject('Page_nGage_Dashboard/Home/column_favoriteDocuments DocumentType'), 'MultipageViewer with drag and drop')
WebUI.verifyElementText(findTestObject('Page_nGage_Dashboard/Home/column_favoriteDocuments DocID'), Consts.SMOKE_HOME005_DOCID)

colNo_DocID = CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'), 'Doc ID')

'Open Document'
CustomKeywords.'actions.Table.clickCell'(findTestObject('Page_nGage_Dashboard/Home/table_MyDocumentResults'), 1, colNo_DocID)

WebUI.switchToWindowTitle('MultipageViewer with drag and drop')
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Click on Remove from Favorite list button.'
WebUI.mouseOver(findTestObject('Page_WMI/MultiPage_Viewer_DD/span_Favorites'));
WebUI.waitForElementClickable(findTestObject('Page_WMI/MultiPage_Viewer_DD/a_Remove from Favorites'), GlobalVariable.G_SmallTimeout)
WebUI.click(findTestObject('Page_WMI/MultiPage_Viewer_DD/a_Remove from Favorites'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Verify Message on Removal from favorite list'
WebUI.waitForElementVisible(findTestObject('Page_WMI/MultiPage_Viewer_DD/span_Document successfully add'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementText(findTestObject('Page_WMI/MultiPage_Viewer_DD/span_Document successfully add'), 'Document successfully removed from Favorite Documents.')