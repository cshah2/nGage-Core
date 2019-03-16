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
import common.Fields
import internal.GlobalVariable as GlobalVariable
import static utils.DateUtil.*

'Login Into Application'
CustomKeywords.'actions.Common.login'()

'Create Closure Action document'
String primary_CustName = 'Chintan Shah - PWCA011'
String primary_CustDesc = 'Workflow closure action - PWCA011'

Map<Fields, String> primary = new HashMap<Fields, String>()
primary.put(Fields.CUSTOMER_NAME, primary_CustName)
primary.put(Fields.CUSTOMER_DETAIL, primary_CustDesc)

CustomKeywords.'actions.Data.create'(DocClass.CLOSURE_ACTION, DocType.CLOSURE_ACTION, primary)

'Click on My Work link from left menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_iframe_105'))

'Click on Tree Menu'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('MY_WORK', 'Processes', 'Closure Action', 'Activity A')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Get column number of Doc ID column'
int colNo_DocID = CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'Doc ID')

'Sort records by Doc ID descending'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'Doc ID')
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'Doc ID')

'Store DocID value of primary document'
String docIDPrimary = CustomKeywords.'actions.Table.getCellText'(findTestObject('Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'), 1, colNo_DocID)

'Store record count for Activity A'
int originalCount = CustomKeywords.'actions.MenuBar.getRecordCountInActivity'('MY_WORK', 'Processes', 'Closure Action', 'Activity A')

'Open first document from the grid'
CustomKeywords.'actions.Table.clickCell'(findTestObject('Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'), 1, colNo_DocID)

'Switch to WMI'
WebUI.switchToWindowIndex(1)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Click on Customer information tab'
WebUI.click(findTestObject('Page_WMI/Closure Action/tab_CustomerInformation'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_WMI/Closure Action/iframe_ContentPlaceHolder1_iPa'))

'Mouse over on menu Customer Actions'
WebUI.mouseOver(findTestObject('Page_WMI/Closure Action/button_CustomerActions'))

'Select option Update item field value'
CustomKeywords.'actions.Common.waitForElementVisible'(findTestObject('Page_WMI/Closure Action/list_CustomerActions'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_WMI/Closure Action/subMenu_CustActions_Update Item field value'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Verify success message on dialog'
WebUI.waitForElementVisible(findTestObject('Page_WMI/Closure Action/dialog_BPM'), GlobalVariable.G_LongTimeout)
String message = WebUI.getText(findTestObject('Page_WMI/Closure Action/dialog_BPM_message')).trim()
WebUI.verifyMatch(message, '.*Field updated.*', true)

'Click on OK button'
CustomKeywords.'actions.Window.clickElementAndWaitForWindowClose'(findTestObject('Page_WMI/Closure Action/dialog_BPM_btn_Ok'), GlobalVariable.G_LongTimeout)

'Switch back to parent window'
WebUI.switchToWindowIndex(0)

'Refresh web page'
WebUI.refresh()
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Click on My Work link from left menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_iframe_105'))

'Click on Tree Menu'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('MY_WORK', 'Processes', 'Closure Action', 'Activity A')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Wait for action to complete'
TestObject table = findTestObject('Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults')
TestObject tableHeader = findTestObject('Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult')
TestObject refresh = findTestObject('Page_nGage_Dashboard/My_Work/table_refreshButton')

CustomKeywords.'actions.Table.refreshUntilRecordFoundInTable'(table, tableHeader, refresh, docIDPrimary, colNo_DocID, GlobalVariable.G_LongTimeout)

'Re-open primary document'
CustomKeywords.'actions.Table.clickCell'(findTestObject('Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'), 1, colNo_DocID)

'Switch to WMI'
WebUI.switchToWindowIndex(1)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Click on Customer information tab'
WebUI.click(findTestObject('Page_WMI/Closure Action/tab_CustomerInformation'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_WMI/Closure Action/iframe_ContentPlaceHolder1_iPa'))

'Mouse over on menu History'
WebUI.mouseOver(findTestObject('Page_WMI/Closure Action/menu_History'))

'Select option Business process audit'
WebUI.waitForElementVisible(findTestObject('Page_WMI/Closure Action/subMenu_History_Business Process Audit'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_WMI/Closure Action/subMenu_History_Business Process Audit'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_WMI/Closure Action/BPMProcessAudit/iframe_Close Window_ContentPla'))

'Verify activity table contains atleast 1 record'
int activityTableRecordCount = CustomKeywords.'actions.Table.getRowsCount'(findTestObject('Page_WMI/Closure Action/BPMProcessAudit/table_Activities'))
WebUI.verifyGreaterThan(activityTableRecordCount, 0)

'Click on first row'
CustomKeywords.'actions.Table.clickCell'(findTestObject('Page_WMI/Closure Action/BPMProcessAudit/table_Activities'), 1, 2)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_WMI/Closure Action/BPMProcessAudit/iframe_Close Window_ContentPla'))

'Verify audit table contains atleast 1 record'
int auditTableRecordCount = CustomKeywords.'actions.Table.getRowsCount'(findTestObject('Page_WMI/Closure Action/BPMProcessAudit/table_Audit'))
WebUI.verifyGreaterThan(auditTableRecordCount, 0)

'Sort records by Interface Name column descending'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_WMI/Closure Action/BPMProcessAudit/tableHeader_Audit'), 'Interface Name')
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_WMI/Closure Action/BPMProcessAudit/tableHeader_Audit'), 'Interface Name')

'Verify Entry for first row'
CustomKeywords.'actions.Table.verifyCellContainsValue'(findTestObject('Page_WMI/Closure Action/BPMProcessAudit/table_Audit'), 1, 7, 'Updates Item  Field Values')

'Verify action return type is true'
CustomKeywords.'actions.Table.verifyCellContainsValue'(findTestObject('Page_WMI/Closure Action/BPMProcessAudit/table_Audit'), 1, 6, 'True')

'Click on Customer information tab'
WebUI.click(findTestObject('Page_WMI/Closure Action/tab_CustomerInformation'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_WMI/Closure Action/iframe_ContentPlaceHolder1_iPa'))

'Verify Customer name values is updated'
String expBusinessDay = 'abc'
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI/Closure Action/input_eform_Customer_Name'), 'value', expBusinessDay, GlobalVariable.G_LongTimeout)