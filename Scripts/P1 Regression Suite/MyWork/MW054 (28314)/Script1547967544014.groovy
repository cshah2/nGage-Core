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
import static utils.Consts.*

'Login Into Application'
CustomKeywords.'actions.Common.login'()

'Create Documents'
CustomKeywords.'actions.Common.createDocument_ProcessForTaskDT'(P1_MW_PROCESSFORTASK_CUSTOMERNAME_DOC3, P1_MW_PROCESSFORTASK_CUSTOMERDESC_DOC3)
CustomKeywords.'actions.Common.createDocument_ProcessForTaskDT'(P1_MW_PROCESSFORTASK_CUSTOMERNAME_DOC4, P1_MW_PROCESSFORTASK_CUSTOMERDESC_DOC4)

'Click on My Work link from left menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_iframe_105'))

'Click Tree Menu ProcessforTaskDT - Activity A'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('MY_WORK', 'Processes', 'ProcessforTask', 'Activity A')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Sort records by DocID descending'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'Doc ID')
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'Doc ID')

'Store DocID values of both documents'
int colNo_DocID =  CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'Doc ID')
P1_MW_PROCESSFORTASK_DOCID_DOC3 = CustomKeywords.'actions.Table.getCellText'(findTestObject('Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'), 2, colNo_DocID) 
P1_MW_PROCESSFORTASK_DOCID_DOC4 = CustomKeywords.'actions.Table.getCellText'(findTestObject('Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'), 1, colNo_DocID)

'Select Checkbox against document in table'
CustomKeywords.'actions.Table.checkRecordInTable'(findTestObject('Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'), 1)

'Perform Mouser over on Action button'
WebUI.mouseOver(findTestObject('Page_nGage_Dashboard/My_Work/span_Actions Button'))

'Select action "Assign work items"'
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/My_Work/action_AssignWorkItems'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/action_AssignWorkItems'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Select User Groupsand assign it to Global Process Admin group on popup dialog'
WebUI.selectOptionByLabel(findTestObject('Page_nGage_Dashboard/My_Work/actionDialog_selectUsersOrGroups'), 'User Groups', false)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_ProcessingGrid'))

WebUI.selectOptionByLabel(findTestObject('Page_nGage_Dashboard/My_Work/actionDialog_selectUserList'), 'Global Process Admins', false)
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/btn_ProcessingGrid_AssignWorkItem'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Verify Success message'
WebUI.verifyElementPresent(findTestObject('Page_nGage_Dashboard/My_Work/processingGrid_SuccessMessage'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementText(findTestObject('Page_nGage_Dashboard/My_Work/processingGrid_SuccessMessage'), 'Successfully Re-assigned the WorkItems to - Global Process Admins')

'Close Dialog'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/processingGrid_Close Button'))

'Right click ProcessForTaskDT - Activity A'
CustomKeywords.'actions.MenuBar.rightClickTreeMenu'('MY_WORK', 'Processes', 'ProcessforTask', 'Activity A')

'Open Foldering configuration'
CustomKeywords.'actions.ContextMenu.verifyOptionPresent'(findTestObject('Page_nGage_Dashboard/contextMenuOptions'), 'Foldering Configuration')
CustomKeywords.'actions.ContextMenu.clickOption'(findTestObject('Page_nGage_Dashboard/contextMenuOptions'), 'Foldering Configuration')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/Folder_Configuration/iframe_Close_iframe_folderingC'))

'Click on Restore Defaults button'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/Folder_Configuration/button_Restore Default'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/Folder_Configuration/iframe_Close_iframe_folderingC'))

'Select Level 1 Foldering as Locked/Unlocked'
WebUI.selectOptionByLabel(findTestObject('Page_nGage_Dashboard/My_Work/Folder_Configuration/Level1_FieldAssigned'), 'Assigned User Group/No User Group*', false)
WebUI.selectOptionByLabel(findTestObject('Page_nGage_Dashboard/My_Work/Folder_Configuration/Level1_Sorting'), 'Asc by Field', false)

'Click on SAVE button'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/Folder_Configuration/button_Save'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/Folder_Configuration/iframe_Close_iframe_folderingC'))

'Click on CLOSE button'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/Folder_Configuration/button_Close'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Verify Sub Menus present under Activity A'
CustomKeywords.'actions.MenuBar.verifySubMenuPresent'('MY_WORK', 'No User Group', 'Processes', 'ProcessforTask', 'Activity A')
CustomKeywords.'actions.MenuBar.verifySubMenuPresent'('MY_WORK', 'Global Process Admins', 'Processes', 'ProcessforTask', 'Activity A')

'Click Tree Menu - No User Group'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('MY_WORK', 'Processes', 'ProcessforTask', 'Activity A', 'No User Group')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Sort records by DocID descending'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'Doc ID')
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'Doc ID')

'Verify record count in Activity matches with record count in table'
int rowCount_NoUserGroup = CustomKeywords.'actions.MenuBar.getRecordCountInActivity'('MY_WORK', 'Processes', 'ProcessforTask', 'Activity A', 'No User Group')
CustomKeywords.'actions.Common.verifyTotalRecordCountFromPageSummary'(findTestObject('Page_nGage_Dashboard/My_Work/table_pagination_summary'), rowCount_NoUserGroup)

'Verify Correct Document ID is present in grid'
CustomKeywords.'actions.Table.verifyRecordPresentInColumn'(findTestObject('Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'), colNo_DocID, P1_MW_PROCESSFORTASK_DOCID_DOC3)
CustomKeywords.'actions.Table.verifyRecordNotPresentInColumn'(findTestObject('Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'), colNo_DocID, P1_MW_PROCESSFORTASK_DOCID_DOC4)

'Click Tree Menu - Global Process Admins'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('MY_WORK', 'Processes', 'ProcessforTask', 'Activity A', 'Global Process Admins')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Sort records by DocID descending'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'Doc ID')
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'Doc ID')

'Verify record count in Activity matches with record count in table'
int rowCount_GlobalProcessAdmins = CustomKeywords.'actions.MenuBar.getRecordCountInActivity'('MY_WORK', 'Processes', 'ProcessforTask', 'Activity A', 'Global Process Admins')
CustomKeywords.'actions.Common.verifyTotalRecordCountFromPageSummary'(findTestObject('Page_nGage_Dashboard/My_Work/table_pagination_summary'), rowCount_GlobalProcessAdmins)

'Verify Correct Document ID is present in grid'
CustomKeywords.'actions.Table.verifyRecordPresentInColumn'(findTestObject('Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'), colNo_DocID, P1_MW_PROCESSFORTASK_DOCID_DOC4)
CustomKeywords.'actions.Table.verifyRecordNotPresentInColumn'(findTestObject('Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'), colNo_DocID, P1_MW_PROCESSFORTASK_DOCID_DOC3)

'Right click ProcessForTaskDT - Activity A'
CustomKeywords.'actions.MenuBar.rightClickTreeMenu'('MY_WORK', 'Processes', 'ProcessforTask', 'Activity A')

'Open Foldering configuration'
CustomKeywords.'actions.ContextMenu.verifyOptionPresent'(findTestObject('Page_nGage_Dashboard/contextMenuOptions'), 'Foldering Configuration')
CustomKeywords.'actions.ContextMenu.clickOption'(findTestObject('Page_nGage_Dashboard/contextMenuOptions'), 'Foldering Configuration')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/Folder_Configuration/iframe_Close_iframe_folderingC'))

'Click on Restore Defaults button'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/Folder_Configuration/button_Restore Default'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/Folder_Configuration/iframe_Close_iframe_folderingC'))

'Click on SAVE button'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/Folder_Configuration/button_Save'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/Folder_Configuration/iframe_Close_iframe_folderingC'))