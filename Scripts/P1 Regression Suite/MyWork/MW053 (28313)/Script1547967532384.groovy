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

'Login Into Application'
CustomKeywords.'actions.Common.login'()

'Create Data for verifying Folder configuarion'
CustomKeywords.'actions.Common.createFolderingDataMyWork'()

'Create Additional document and lock the same'
CustomKeywords.'actions.Data.create'(DocClass.VERTICAL_MENU_WIZARD, DocType.SHOW_VERTICAL_MENU_TRUE, P1_MW_DOC086)
FLAG_P1_MW_DOC086 = true

'Click on My Work link from left menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_iframe_105'))

'Click Tree Menu Loan Interactive - Loan application'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('MY_WORK', 'Processes', 'Loan Interactive', 'Loan Application')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Sort records by DocID descending'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'Doc ID')
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'Doc ID')

'Open first record from the document'
int colNo_DocID =  CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'Doc ID')
CustomKeywords.'actions.Table.clickCell'(findTestObject('Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'), 1, colNo_DocID)

'Switch to WMI and close window'
WebUI.switchToWindowIndex(1)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
WebUI.closeWindowIndex(1)

//Test Steps
'Switch to parent window'
WebUI.switchToWindowIndex(0)

'right click on (option)loan approval'
CustomKeywords.'actions.MenuBar.rightClickTreeMenu'('MY_WORK', 'Processes', 'Loan Interactive', 'Loan Application')
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Select Foldering configuration option from context menu'
CustomKeywords.'actions.ContextMenu.clickOption'(findTestObject('Page_nGage_Dashboard/contextMenuOptions'), 'Foldering Configuration')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/Folder_Configuration/iframe_Close_iframe_folderingC'))

'Click on Restore defaults'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/Folder_Configuration/button_Restore Default'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/Folder_Configuration/iframe_Close_iframe_folderingC'))

'Select Level 1 Foldering as Locked/Unlocked'
WebUI.selectOptionByLabel(findTestObject('Page_nGage_Dashboard/My_Work/Folder_Configuration/Level1_FieldAssigned'), 'Locked/Unlocked*', false)
WebUI.selectOptionByLabel(findTestObject('Page_nGage_Dashboard/My_Work/Folder_Configuration/Level1_Sorting'), 'Asc by Field', false)

'Click on SAVE button'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/Folder_Configuration/button_Save'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/Folder_Configuration/iframe_Close_iframe_folderingC'))

'Click on CLOSE button'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/Folder_Configuration/button_Close'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Verify Sub Menus present under Activity A'
CustomKeywords.'actions.MenuBar.verifySubMenuPresent'('MY_WORK', 'Locked', 'Processes', 'Loan Interactive', 'Loan Application')
CustomKeywords.'actions.MenuBar.verifySubMenuPresent'('MY_WORK', 'UnLocked', 'Processes', 'Loan Interactive', 'Loan Application')

'Click Tree Menu - Locked'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('MY_WORK', 'Processes', 'Loan Interactive', 'Loan Application', 'Locked')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Sort records by DocID descending'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'Doc ID')
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'Doc ID')

'Verify record count in Activity matches with record count in table'
int rowCount_Locked = CustomKeywords.'actions.MenuBar.getRecordCountInActivity'('MY_WORK', 'Processes', 'Loan Interactive', 'Loan Application', 'Locked') 
CustomKeywords.'actions.Common.verifyTotalRecordCountFromPageSummary'(findTestObject('Page_nGage_Dashboard/My_Work/table_pagination_summary'), rowCount_Locked)

'Verify all records displays Lock icon'
CustomKeywords.'actions.Table.verifyAllRecordsDisplayLockIcon'(findTestObject('Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'), 3)

'Click Tree Menu - Unlocked'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('MY_WORK', 'Processes', 'Loan Interactive', 'Loan Application', 'UnLocked')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Sort records by DocID descending'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'Doc ID')
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'Doc ID')

'Verify record count in Activity matches with record count in table'
int rowCount_UnLocked = CustomKeywords.'actions.MenuBar.getRecordCountInActivity'('MY_WORK', 'Processes', 'Loan Interactive', 'Loan Application', 'UnLocked')
CustomKeywords.'actions.Common.verifyTotalRecordCountFromPageSummary'(findTestObject('Page_nGage_Dashboard/My_Work/table_pagination_summary'), rowCount_UnLocked)

'Verify all records does not displays Lock icon'
CustomKeywords.'actions.Table.verifyAllRecordsDoesNotDisplayLockIcon'(findTestObject('Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'), 3)

'right click on (option)loan approval'
CustomKeywords.'actions.MenuBar.rightClickTreeMenu'('MY_WORK', 'Processes', 'Loan Interactive', 'Loan Application')
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Select Foldering configuration option from context menu'
CustomKeywords.'actions.ContextMenu.clickOption'(findTestObject('Page_nGage_Dashboard/contextMenuOptions'), 'Foldering Configuration')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/Folder_Configuration/iframe_Close_iframe_folderingC'))

'Click on Restore defaults'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/Folder_Configuration/button_Restore Default'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/Folder_Configuration/iframe_Close_iframe_folderingC'))

'Click on SAVE button'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/Folder_Configuration/button_Save'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/Folder_Configuration/iframe_Close_iframe_folderingC'))