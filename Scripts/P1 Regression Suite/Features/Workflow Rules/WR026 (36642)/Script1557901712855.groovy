import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import common.DocClass
import common.DocType
import common.Fields
import internal.GlobalVariable as GlobalVariable
import static utils.Consts.*

import org.apache.commons.lang3.StringUtils

String docID = ''

'Login Into Application'
CustomKeywords.'actions.Common.login'()

'Data Object'
Map<Fields, String> data = P1_WMI_DOC361

'Click on Global New button'
WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))

'Select DocClass and DocType'
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'(DocClass.INTERFACE_TEST_PR.toString(), DocType.INTERFACE_TEST_PR_RULES_ITEM_RELATED.toString())

'Click on OK button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

'Switch to new Window'
WebUI.switchToWindowIndex(1)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
WebUI.waitForElementVisible(findTestObject('Page_WMI_NEW/Interface Test PR/input_TestID'), GlobalVariable.G_LongTimeout)

'Get Data from Map'
String testId = data.get(Fields.TEST_ID)
String testName = data.get(Fields.TEST_NAME)
String testDate = data.get(Fields.TEST_DATE)

'Fill Form'
if(StringUtils.isNotBlank(testId))
	WebUI.setText(findTestObject('Page_WMI_NEW/Interface Test PR/input_TestID'), testId)
if(StringUtils.isNotBlank(testName))
	WebUI.setText(findTestObject('Page_WMI_NEW/Interface Test PR/input_TestName'), testName)
if(StringUtils.isNotBlank(testDate))
	CustomKeywords.'actions.Common.setText_Date'(findTestObject('Page_WMI_NEW/Interface Test PR/input_TestDate'), testDate)

/*'Upload file'
WebUI.uploadFile(findTestObject('Page_WMI/Interface Test PR/File Upload/input_upload_File'), RunConfiguration.getProjectDir().replace('/', '\\')+'\\Data Files\\FileUploads\\timesheet.pdf')
*/
'Click on Save button'
WebUI.click(findTestObject('Page_WMI_NEW/Interface Test PR/btn_Save'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_WMI/Interface Test PR/iframe_ContentPlaceHolder1_iPage'))

'Mouse Hover on Attachments button'
WebUI.mouseOver(findTestObject('Object Repository/Page_WMI/Interface Test PR/Attach New Document/menu_Attachments'))

'Select option Attach new documents'
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_WMI/Interface Test PR/Attach New Document/subMenu_AtttachNewDocument'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Object Repository/Page_WMI/Interface Test PR/Attach New Document/subMenu_AtttachNewDocument'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_WMI/Interface Test PR/Attach New Document/iframe_mainContainerFrame'))

'Select option in Doc Class drop down'
WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_WMI/Interface Test PR/Attach New Document/select_DocClass'), 'InterfaceTestPRDocClass', false)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_WMI/Interface Test PR/Attach New Document/iframe_mainContainerFrame'))

'Select option in Doc Type drop down'
WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_WMI/Interface Test PR/Attach New Document/select_DocType'), 'InterfaceTestPRDocTypeExecRules_ItemRelated', false)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_WMI/Interface Test PR/Attach New Document/iframe_mainContainerFrame'))

'Upload file'
WebUI.uploadFile(findTestObject('Object Repository/Page_WMI/Interface Test PR/Attach New Document/input_FileUpload'), RunConfiguration.getProjectDir().replace('/', '\\')+'\\Data Files\\FileUploads\\timesheet.pdf')


'Click on attach document button'
WebUI.click(findTestObject('Object Repository/Page_WMI/Interface Test PR/Attach New Document/button_Attach Document'))

'click on OK button'
WebUI.click(findTestObject('Object Repository/Page_WMI/Interface Test PR/Attach New Document/btn_Ok'))

'Mouse Hover on Attachments button'
WebUI.mouseOver(findTestObject('Object Repository/Page_WMI/Interface Test PR/Attach New Document/menu_Attachments'))

'Select option Current Attachments'
WebUI.waitForElementVisible(findTestObject('Page_WMI/Interface Test PR/Attach New Document/btn_Current Attachments'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_WMI/Interface Test PR/Attach New Document/btn_Current Attachments'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_WMI/Interface Test PR/Attach New Document/iframe_mainContainerFrame'))


'Verify correct document is attached'
CustomKeywords.'actions.Table.verifyRecordsCount'(findTestObject('Page_WMI/WMI_Menu_BOV/Attachements/table_CurrentAttachements_Documents'), 1)
CustomKeywords.'actions.Table.verifyCellContainsValue'(findTestObject('Page_WMI/WMI_Menu_BOV/Attachements/table_CurrentAttachements_Documents'), 1, 3, docID)

'Click on Loan View button'
WebUI.click(findTestObject('Object Repository/Page_WMI/Interface Test PR_Rules/span_Loan View'))

'Click on Rule'
CustomKeywords.'actions.Window.clickElementAndWaitForWindowClose'(findTestObject('Object Repository/Page_WMI/Interface Test PR_Rules/ExecuteRules_ItemRelatedGroup/btn_ActionCHeckRelatedItemObject'), GlobalVariable.G_LongTimeout)

'Switch to main window'
WebUI.switchToWindowTitle('Savana nGage')

'Close pop up dialog'
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/span_ui-button-icon-primary ui'))

'Click on Recent documents'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('HOME', 'Recent Documents')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/iframe_iframe_103'))

'Verify grid contains atleast 1 record'
int rowCount = CustomKeywords.'actions.Table.getRowsCount'(findTestObject('Page_nGage_Dashboard/Home/table_MyDocumentResults'))
WebUI.verifyGreaterThanOrEqual(rowCount, 1)

/*'Sort records by Doc ID Descending'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'), 'Doc ID')
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'), 'Doc ID')
*/

'Click on refresh button'
WebUI.click(findTestObject('Object Repository/Page_WMI/Interface Test PR_Rules/btn_refresh'))


'Verify Doc Type for the first document'
int colNo_DocType = CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'), 'Doc Type')
CustomKeywords.'actions.Table.verifyCellContainsValue'(findTestObject('Page_nGage_Dashboard/Home/table_MyDocumentResults'), 1, colNo_DocType, DocType.INTERFACE_TEST_PR_RULES_ITEM_RELATED.toString())

'Click on first row to open document'
CustomKeywords.'actions.Table.clickCell'(findTestObject('Page_nGage_Dashboard/Home/table_MyDocumentResults'), 1, colNo_DocType)

'Switch to WMI window'
WebUI.switchToWindowIndex(1)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_WMI/Interface Test PR/iframe_ContentPlaceHolder1_iPage'))

'Perform Mouse over on History menu'
WebUI.mouseOver(findTestObject('Page_WMI/Interface Test PR/btn_History'))

'Select Business Process Audit menu'
WebUI.waitForElementVisible(findTestObject('Page_WMI/Interface Test PR/btn_Business Process Audit'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_WMI/Interface Test PR/btn_Business Process Audit'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_WMI/Interface Test PR/Business Process Audit/iframe_ContentPlaceHolder1_iPage'))

'Verify activities table contains 1 record'
int rowCount_Activities = CustomKeywords.'actions.Table.getRowsCount'(findTestObject('Page_WMI/Interface Test PR/Business Process Audit/table_Activities'))
WebUI.verifyEqual(rowCount_Activities, 1)

'Verify process and activity name in Activities table'
int colNo_ProcessName = CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Page_WMI/Interface Test PR/Business Process Audit/tableHeader_Activities'), 'Process Name')
int colNo_ActivityName = CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Page_WMI/Interface Test PR/Business Process Audit/tableHeader_Activities'), 'Activity Name')
CustomKeywords.'actions.Table.verifyCellContainsValue'(findTestObject('Page_WMI/Interface Test PR/Business Process Audit/table_Activities'), 1, colNo_ProcessName, 'InterfaceTestProcess_28Jan2019')
CustomKeywords.'actions.Table.verifyCellContainsValue'(findTestObject('Page_WMI/Interface Test PR/Business Process Audit/table_Activities'), 1, colNo_ActivityName, 'ExecuteRules_ItemRelatedGroup')

'Click on Activity in the table'
CustomKeywords.'actions.Table.clickCell'(findTestObject('Page_WMI/Interface Test PR/Business Process Audit/table_Activities'), 1, colNo_ProcessName)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_WMI/Interface Test PR/Business Process Audit/iframe_ContentPlaceHolder1_iPage'))

'Sort records in Audit table by column interface name descending'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_WMI/Interface Test PR/Business Process Audit/tableHeader_Audit'), 'Interface Name')
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_WMI/Interface Test PR/Business Process Audit/tableHeader_Audit'), 'Interface Name')

'Verify Interface name and return type value in row number 2'
int colNo_InterfaceName = CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Page_WMI/Interface Test PR/Business Process Audit/tableHeader_Audit'), 'Interface Name')
int colNo_ReturnType = CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Page_WMI/Interface Test PR/Business Process Audit/tableHeader_Audit'), 'Return Type')
CustomKeywords.'actions.Table.verifyCellContainsValue'(findTestObject('Page_WMI/Interface Test PR/Business Process Audit/table_Audit'), 2, colNo_InterfaceName, 'Check Items Related Items Object')
CustomKeywords.'actions.Table.verifyCellContainsValue'(findTestObject('Page_WMI/Interface Test PR/Business Process Audit/table_Audit'), 2, colNo_ReturnType, 'True')
