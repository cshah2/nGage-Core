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
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import common.DocClass
import common.DocType
import internal.GlobalVariable as GlobalVariable
import static utils.Consts.*

'Login into application'
CustomKeywords.'actions.Common.login'()

'Create Documents if not present'
if(!(FLAG_P1_WMI_DOC021 && FLAG_P1_WMI_DOC022 && FLAG_P1_WMI_DOC023)) {
	CustomKeywords.'actions.Data.create'(DocClass.WMI_MENU, DocType.WMI_MENU_BOV, P1_WMI_DOC021)
	CustomKeywords.'actions.Data.create'(DocClass.WMI_MENU, DocType.WMI_MENU_DEFAULT, P1_WMI_DOC022)
	CustomKeywords.'actions.Data.create'(DocClass.WMI_MENU, DocType.WMI_MENU_DOCTWOROW, P1_WMI_DOC023)
	FLAG_P1_WMI_DOC021 = true
	FLAG_P1_WMI_DOC022 = true
	FLAG_P1_WMI_DOC023 = true
}

'Go to Recent Documents tab'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('HOME', 'Recent Documents')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/iframe_iframe_103'))

'Get Column position for DocType column'
int colNo_DocType = CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'), 'Doc Type')

'Validate atleast 3 records are present in the grid.'
int rowCount = CustomKeywords.'actions.Table.getRowsCount'(findTestObject('Page_nGage_Dashboard/Home/table_MyDocumentResults'))
WebUI.verifyGreaterThanOrEqual(rowCount, 3)

'Sort Record in grid by DocID Descending'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'), 'Doc ID')
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'), 'Doc ID')

'Verify correct documents are loaded in first 3 rows'
String docType1 = CustomKeywords.'actions.Table.getCellText'(findTestObject('Page_nGage_Dashboard/Home/table_MyDocumentResults'), 3, colNo_DocType)
String docType2 = CustomKeywords.'actions.Table.getCellText'(findTestObject('Page_nGage_Dashboard/Home/table_MyDocumentResults'), 2, colNo_DocType)
String docType3 = CustomKeywords.'actions.Table.getCellText'(findTestObject('Page_nGage_Dashboard/Home/table_MyDocumentResults'), 1, colNo_DocType)
if(!docType1.equalsIgnoreCase('WMI Menu BOV')) {
	FLAG_P1_WMI_DOC021 = false
	KeywordUtil.markFailedAndStop('Invalid document present in recent grid')
}
if(!docType2.equalsIgnoreCase('WMI Menu Default')) {
	FLAG_P1_WMI_DOC022 = false
	KeywordUtil.markFailedAndStop('Invalid document present in recent grid')
}
if(!docType3.equalsIgnoreCase('WMI Menu DocTwoRow')) {
	FLAG_P1_WMI_DOC023 = false
	KeywordUtil.markFailedAndStop('Invalid document present in recent grid')
}

//WMI Menu Bov Check
'Open Document from recent grid'
CustomKeywords.'actions.Table.clickCell'(findTestObject('Page_nGage_Dashboard/Home/table_MyDocumentResults'), 3, colNo_DocType)

'Switch to WMI and wait for page load'
WebUI.switchToWindowIndex(1)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Navigate and verify pageSource'
WebUI.waitForElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV/span_MORE'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Object Repository/Page_WMI/WMI_Menu_BOV/div_Capture object_northToggle'))
WebUI.mouseOver(findTestObject('Page_WMI/WMI_Menu_BOV/span_MORE'))
WebUI.waitForElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV/a_Email  Favorites_1'), GlobalVariable.G_LongTimeout)
WebUI.mouseOver(findTestObject('Page_WMI/WMI_Menu_BOV/a_Email  Favorites_1'))
WebUI.waitForElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV/a_Send To Recepient By Email'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_WMI/WMI_Menu_BOV/a_Send To Recepient By Email'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_WMI/WMI_Menu_BOV/iframe_Close_ContentPlaceHolde'))
CustomKeywords.'actions.Common.verifyMatch'(WebUI.getAttribute(findTestObject('Object Repository/Page_WMI/WMI_Menu_BOV/iframe_Close_ContentPlaceHolde'), 'src'), '.*SendEmail.aspx.*', true)
CustomKeywords.'actions.Window.clickElementAndWaitForWindowClose'(findTestObject('Page_WMI/WMI_Menu_BOV/span_Close'), GlobalVariable.G_LongTimeout)
WebUI.switchToWindowIndex(0)

//WMI Menu Bov Default Check
'Pre-Requisite : Create new Document of type WMI Menu Default'
'Open Document from recent grid'
CustomKeywords.'actions.Table.clickCell'(findTestObject('Page_nGage_Dashboard/Home/table_MyDocumentResults'), 2, colNo_DocType)

'Switch to WMI and wait for page load'
WebUI.switchToWindowIndex(1)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Navigate and verify pageSource'
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_WMI/WMI_Menu_BOV_Default/span_MORE'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Object Repository/Page_WMI/WMI_Menu_BOV_Default/div_Capture object_northToggle'))
WebUI.mouseOver(findTestObject('Object Repository/Page_WMI/WMI_Menu_BOV_Default/span_MORE'))
WebUI.waitForElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Default/a_Email  Favorites_1'), GlobalVariable.G_LongTimeout)
WebUI.mouseOver(findTestObject('Page_WMI/WMI_Menu_BOV_Default/a_Email  Favorites_1'))
WebUI.waitForElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Default/a_Send To Recepient By Email'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_WMI/WMI_Menu_BOV_Default/a_Send To Recepient By Email'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_WMI/WMI_Menu_BOV_Default/iframe_Close_ContentPlaceHolde'))
CustomKeywords.'actions.Common.verifyMatch'(WebUI.getAttribute(findTestObject('Object Repository/Page_WMI/WMI_Menu_BOV_Default/iframe_Close_ContentPlaceHolde'), 'src'), '.*SendEmail.aspx.*', true)
CustomKeywords.'actions.Window.clickElementAndWaitForWindowClose'(findTestObject('Object Repository/Page_WMI/WMI_Menu_BOV_Default/span_Close'), GlobalVariable.G_LongTimeout)
WebUI.switchToWindowIndex(0)

//WMI Menu Bov DocTwoRow Check
'Open Document from recent grid'
CustomKeywords.'actions.Table.clickCell'(findTestObject('Page_nGage_Dashboard/Home/table_MyDocumentResults'), 1, colNo_DocType)

'Switch to WMI and wait for page load'
WebUI.switchToWindowIndex(1)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Navigate and verify pageSource'
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_WMI/WMI_Menu_BOV_DocTwoRow/span_MORE'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Object Repository/Page_WMI/WMI_Menu_BOV_DocTwoRow/div_Capture object_northToggle'))
WebUI.mouseOver(findTestObject('Object Repository/Page_WMI/WMI_Menu_BOV_DocTwoRow/span_MORE'))
WebUI.waitForElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_DocTwoRow/a_Email  Favorites_1'), GlobalVariable.G_LongTimeout)
WebUI.mouseOver(findTestObject('Page_WMI/WMI_Menu_BOV_DocTwoRow/a_Email  Favorites_1'))
WebUI.waitForElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_DocTwoRow/a_Send To Recepient By Email'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_WMI/WMI_Menu_BOV_DocTwoRow/a_Send To Recepient By Email'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_WMI/WMI_Menu_BOV_DocTwoRow/iframe_Close_ContentPlaceHolde'))
CustomKeywords.'actions.Common.verifyMatch'(WebUI.getAttribute(findTestObject('Object Repository/Page_WMI/WMI_Menu_BOV_DocTwoRow/iframe_Close_ContentPlaceHolde'), 'src'), '.*SendEmail.aspx.*', true)
CustomKeywords.'actions.Window.clickElementAndWaitForWindowClose'(findTestObject('Object Repository/Page_WMI/WMI_Menu_BOV_DocTwoRow/span_Close'), GlobalVariable.G_LongTimeout)
WebUI.switchToWindowIndex(0)