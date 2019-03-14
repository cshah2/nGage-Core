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

import common.DocClass
import common.DocType

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import static utils.Consts.*

import org.apache.commons.lang3.StringUtils

'Login Into Application'
CustomKeywords.'actions.Common.login'()

'Verify document created in previous test is present in grid'
boolean isPresent = CustomKeywords.'actions.Common.isRecordPresentInRecentGridTable'(1, 'Doc ID', SMOKE_WMI_DOC101_DOCID)

'Create new Document if document not present'
if(!isPresent) {
	CustomKeywords.'actions.Data.create'(DocClass.BUSINESS_MODEL_VIEW, DocType.MULTIPAGE_VIEWER_WITH_DRAG_DROP, SMOKE_WMI_DOC101)
	WebUI.refresh()
}

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

'Copy Document ID value of 1st Record and Save it for other test cases.'
if(StringUtils.isBlank(SMOKE_WMI_DOC101_DOCID)) {
	SMOKE_WMI_DOC101_DOCID = CustomKeywords.'actions.Table.getCellText'(findTestObject('Page_nGage_Dashboard/Home/table_MyDocumentResults'), 1, colNo_DocID)
}

'Open Document'
CustomKeywords.'actions.Table.clickCell'(findTestObject('Page_nGage_Dashboard/Home/table_MyDocumentResults'), 1, colNo_DocID)

'Switch to Document window'
WebUI.switchToWindowIndex(1)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Add Document to Favorite document list'
WebUI.mouseOver(findTestObject('Page_WMI/MultiPage_Viewer_DD/span_Favorites'));
WebUI.waitForElementClickable(findTestObject('Page_WMI/MultiPage_Viewer_DD/a_Add to Favorites'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_WMI/MultiPage_Viewer_DD/a_Add to Favorites'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Verify Success message'
WebUI.waitForElementVisible(findTestObject('Page_WMI/MultiPage_Viewer_DD/span_Document successfully add'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementText(findTestObject('Page_WMI/MultiPage_Viewer_DD/span_Document successfully add'), 'Document successfully added to Favorite Documents.')