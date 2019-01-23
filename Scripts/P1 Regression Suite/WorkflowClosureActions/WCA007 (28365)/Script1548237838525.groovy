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

'Login Into Application'
CustomKeywords.'actions.Common.login'()

'Create Closure Action document'
CustomKeywords.'actions.Common.createDocument_ClosureAction'('TestName', 'TestDescription')

WebUI.refresh()

'Click on My Work link from left menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_iframe_105'))

'Navigate to Closure Action Menu and get the document count'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('My_Work', 'Processes', 'Closure Action', 'Activity A')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Sort the table to click on new doc'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'Doc ID')
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'Doc ID')

'Click and open the record from Table'
CustomKeywords.'actions.Table.clickCell'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'), 1, 5)

'Switch to WMI window'
WebUI.switchToWindowIndex(1)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Click on Customer Information'
WebUI.click(findTestObject('Page_WMI/Closure Action/span_Customer Information'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_WMI/Closure Action/iframe_ContentPlaceHolder1_iPa'))

'Hover over Customer Actions menu'
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_WMI/Closure Action/button_CustomerActions'), GlobalVariable.G_LongTimeout)
WebUI.mouseOver(findTestObject('Object Repository/Page_WMI/Closure Action/button_CustomerActions'))

'Click on Show custom message'
WebUI.click(findTestObject('Object Repository/Page_WMI/Closure Action/subMenu_CustActions_Show Custom message'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Verify the message'
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI/Closure Action/customMessageBox'))
String expectedText = WebUI.getText(findTestObject('Object Repository/Page_WMI/Closure Action/customMessageBoxText'))
WebUI.verifyMatch(expectedText, 'Verify message window', false)

'Click on OK button'
WebUI.click(findTestObject('Object Repository/Page_WMI/Closure Action/customMessageBoxOkButton'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_WMI/Closure Action/iframe_Close Window_ContentPla'))

'Hover over History menu and click on Business Process Audit'
WebUI.mouseOver(findTestObject('Object Repository/Page_WMI/Closure Action/menu_History'))
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_WMI/Closure Action/subMenu_History_Business Process Audit'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Object Repository/Page_WMI/Closure Action/subMenu_History_Business Process Audit'))

'Click on Activity Table'
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_WMI/Closure Action/table_Activity'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Object Repository/Page_WMI/Closure Action/table_Activity'))

'Verify Audit table is loaded'
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI/Closure Action/table_Audit'))

'Click 2 times on Interface Name to sort the table records'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Object Repository/Page_WMI/Closure Action/table_HeaderAuditTable'), 'Interface Name')
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Object Repository/Page_WMI/Closure Action/table_HeaderAuditTable'), 'Interface Name')

'Get cell number'
CustomKeywords.'actions.Table.verifyCellContainsValue'(findTestObject('Page_WMI/Closure Action/BPMProcessAudit/table_Audit'), 1, 7, 'True')