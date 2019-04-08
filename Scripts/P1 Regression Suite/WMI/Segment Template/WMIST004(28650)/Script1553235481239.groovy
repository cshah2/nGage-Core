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

'Login Into Application'
CustomKeywords.'actions.Common.login'()

'Click on New button to Create a new WMI Segment Document'
WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))

'Select DocClass WMI Segment and Doc Type WMI Segment'
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'(DocClass.WMI_SEGMENT.toString(), DocType.WMI_SEGMENT.toString())

'Click on OK button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

'Switch to window and wait for page load'
WebUI.switchToWindowIndex(1)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'MouseHover on Standard Actions button and Click on Save button'
WebUI.mouseOver(findTestObject('Object Repository/Page_WMI_NEW/WMI_Menu_BOV/buttonStandardActions'))
WebUI.click(findTestObject('Page_WMI_NEW/WMISegment/button_Save'))

'Verify close button'
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/WMISegment/button_Close'))

'Click on close button and Verify window is closed'
CustomKeywords.'actions.Window.clickElementAndWaitForWindowClose'(findTestObject('Page_WMI_NEW/WMISegment/button_Close'), GlobalVariable.G_LongTimeout)

'Switch to parent window'
WebUI.switchToWindowIndex(0)
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/span_ui-button-icon-primary ui'))

'Navigate to Recent Documents'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('HOME', 'Recent Documents')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/iframe_iframe_103'))

'Sort records DocID Descending'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'), 'Doc ID')
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'), 'Doc ID')

int docTypeColumnPosition =CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'),'Doc Type')
String columnNameDocType = CustomKeywords.'actions.Table.getCellText'(findTestObject('Object Repository/Page_nGage_Dashboard/Home/table_MyDocumentResults'), 1,docTypeColumnPosition)

'verify document is saved'
WebUI.verifyMatch('WMI Segment', columnNameDocType, false)

'Open saved doc from recent document'
CustomKeywords.'actions.Table.clickCell'(findTestObject('Object Repository/Page_nGage_Dashboard/Home/table_MyDocumentResults'), 1, 7)
WebUI.switchToWindowIndex(1)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'MouseHover on History menu > Click on Business process History menu and verify that BPM History is displayed'
WebUI.mouseOver(findTestObject('Page_WMI_NEW/WMISegment/button_History'))
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/WMISegment/subMenu_Business Process History'))
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/WMISegment/subMenu_Business Process History'))
WebUI.verifyElementText(findTestObject('Page_WMI_NEW/WMISegment/title_menu'), 'BPM History')
String src = WebUI.getAttribute(findTestObject('Object Repository/Page_WMI_NEW/WMISegment/iframe_Close_ContentPlaceHolde'), 'src')
WebUI.verifyMatch(src, '.*nid=BPMHISTORY.*', true)

'MouseHover on History menu > Click on Business process Audit menu and verify that Business process audit history is displayed'
WebUI.mouseOver(findTestObject('Page_WMI_NEW/WMISegment/button_History'))
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/WMISegment/subMenu_Business Process Audit'))
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/WMISegment/subMenu_Business Process Audit'))
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/WMISegment/title_Audit Description'))
String src_businessProcessAuditHistory = WebUI.getAttribute(findTestObject('Object Repository/Page_WMI_NEW/WMISegment/iframe_ContentPlaceHolder1'), 'src')
WebUI.verifyMatch(src_businessProcessAuditHistory, '.*nid=BPMAUDIT.*', true)

'MouseHover on History menu > Click on Revision History menu and verify that Revision History is displayed'
WebUI.mouseOver(findTestObject('Page_WMI_NEW/WMISegment/button_History'))
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/WMISegment/subMenu_Revision History'))
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/WMISegment/subMenu_Revision History'))
WebUI.verifyElementText(findTestObject('Page_WMI_NEW/WMISegment/title_menu'), 'Revision History')
String src_RivisionHistory = WebUI.getAttribute(findTestObject('Object Repository/Page_WMI_NEW/WMISegment/iframe_Close_ContentPlaceHolde'), 'src')
WebUI.verifyMatch(src_RivisionHistory, '.*nid=REVHISTORY.*', true)
