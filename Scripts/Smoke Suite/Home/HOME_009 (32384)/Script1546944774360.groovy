import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.eclipse.persistence.internal.jpa.parsing.jpql.antlr.JPQLParser.orderByClause_scope

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

'Create 2 documents for verifying sort'
CustomKeywords.'actions.Common.createDocument_MultiPageViewerWithDragAndDrop'(Consts.SMOKE_HOME001_STRINGFIELD, Consts.SMOKE_HOME001_FILENAME, '')
CustomKeywords.'actions.Common.createDocument_MultiPageViewerWithDragAndDrop'(Consts.SMOKE_HOME001_STRINGFIELD, Consts.SMOKE_HOME001_FILENAME, '')

'Go to Recent Documents tab'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('HOME', 'Recent Documents')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/iframe_iframe_103'))

'Validate atleast 1 record is present in the grid.'
int rowCount = CustomKeywords.'actions.Table.getRowsCount'(findTestObject('Page_nGage_Dashboard/Home/table_MyDocumentResults'))
WebUI.verifyGreaterThanOrEqual(rowCount, 1)

'Click on DocID Header to sort records in Ascending order'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Home/div_RecentDocuments_DocID_Header'))

'Verify records in grid are sorted in ascending order'
CustomKeywords.'actions.Table.verifyColumnIsSortedInteger'(findTestObject('Page_nGage_Dashboard/Home/table_MyDocumentResults'), 7, 'ASC')

'Click again on DocID Header to sort records in Descending order'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Home/div_RecentDocuments_DocID_Header'))

'Verify records in grid are sorted in descending order'
CustomKeywords.'actions.Table.verifyColumnIsSortedInteger'(findTestObject('Page_nGage_Dashboard/Home/table_MyDocumentResults'), 7, 'DESC')