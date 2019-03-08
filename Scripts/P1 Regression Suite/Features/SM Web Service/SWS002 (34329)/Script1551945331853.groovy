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

import common.DocClass
import common.DocType
import internal.GlobalVariable as GlobalVariable
import utils.ImageUtil

import static utils.Consts.*

'Login Into Application'
CustomKeywords.'actions.Common.login'()

'Create document'
CustomKeywords.'actions.Data.create'(DocClass.SM_WEBSERVICE_DB_2, DocType.SM_WEBSERVICE_DB_2, P1_WMI_DOC044)

'Go to Recent Documents tab'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('HOME', 'Recent Documents')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/iframe_iframe_103'))

'Get Column position for DocType column'
int colNo_DocType = CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'), 'Doc Type')

'Validate atleast 1 records are present in the grid.'
int rowCount = CustomKeywords.'actions.Table.getRowsCount'(findTestObject('Page_nGage_Dashboard/Home/table_MyDocumentResults'))
WebUI.verifyGreaterThanOrEqual(rowCount, 1)

'Sort Record in grid by DocID Descending'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'), 'Doc ID')
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'), 'Doc ID')

'Verify DocType of first record'
CustomKeywords.'actions.Table.verifyCellContainsValue'(findTestObject('Page_nGage_Dashboard/Home/table_MyDocumentResults'), 1, colNo_DocType, DocType.SM_WEBSERVICE_DB_2.toString())

'Open Document from recent grid'
CustomKeywords.'actions.Table.clickCell'(findTestObject('Page_nGage_Dashboard/Home/table_MyDocumentResults'), 1, colNo_DocType)

'Switch to WMI and wait for page load'
WebUI.switchToWindowIndex(1)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForImageToRender'(findTestObject('Page_WMI/SM Web Service/DB_0002/iFrame_Image_EPMMultipageViewer'))

'Verify Intial page count summary'
WebUI.verifyMatch(WebUI.getText(findTestObject('Page_WMI/SM Web Service/DB_0001/lbl_PageSummary')).trim(), '.*Page 1/8.*', true)

String image1 =  ImageUtil.captureImage()
String actText = CustomKeywords.'actions.OCR.readTextFromImage'(image1)

WebUI.verifyMatch(actText, '.*PAGE 1.*', true)