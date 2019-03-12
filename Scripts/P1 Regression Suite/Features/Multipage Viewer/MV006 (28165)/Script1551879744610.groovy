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

WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/div_westContentSplitter'))
WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/div_mainContentSplitter'))
int mainContainerWidth = WebUI.getElementWidth(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/div_mainContentSplitter'))
int westContainerWidth = WebUI.getElementWidth(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/div_westContentSplitter'))
int totalWidth = westContainerWidth + mainContainerWidth
WebUI.verifyGreaterThanOrEqual(westContainerWidth, 5)
WebUI.verifyGreaterThanOrEqual(mainContainerWidth, 5)

'Click on Expand to full view'
WebUI.click(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/splitter_ExpandToFullSize'))

WebUI.verifyElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/div_westContentSplitter'))
WebUI.verifyLessThanOrEqual(WebUI.getElementWidth(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/div_mainContentSplitter')), 5)
