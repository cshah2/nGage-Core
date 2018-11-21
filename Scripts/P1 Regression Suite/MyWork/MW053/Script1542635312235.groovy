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

'Click on My Work link from left menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_iframe_105'))

'Expand process Process for task'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/icon_Expand_ProcessForTask'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'right click on Activity A'
WebUI.rightClick(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Process_ProcessForTask/a_Activity A'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'click on (option)foldering configuration'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/LoanInteractive_MyWork/a_Foldering Configuration'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'select drpdown options'
WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Folder_Configuration/Level1_FieldAssigned'),'Locked/Unlocked*',false)
WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Folder_Configuration/Level1_Sorting'), 'Asc by Field',false)

'click submit button'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Folder_Configuration/button_Save'))

'click close button'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Folder_Configuration/button_Close'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'click on new  button to create document'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/input_New'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_iframe_105'))

//creating first document
'Select Document class and Document Type'
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'('Closure Action', 'ProcessforTaskDT')

'Click on OK Button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

'switch to new window'
WebUI.switchToWindowTitle('(Doc ID: NEW )')
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'enter customer details'
WebUI.switchToWindowIndex(1)
WebUI.setText(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/input_CustomerDetails'), 'First DOC(UnLocked)')
WebUI.setText(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/input_CustomerName'), 'First DOC(UnLocked)')

'Click on Save button'
WebUI.mouseOver(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/li_ActionMenu_SubMenu'))
WebUI.waitForElementVisible(findTestObject('Page_WMI_NEW/MultiPage_Viewer_DD/a_Save'), GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Window.clickElementAndWaitForWindowClose'(findTestObject('Page_WMI_NEW/MultiPage_Viewer_DD/a_Save'), GlobalVariable.G_LongTimeout)

'switch to main window'
WebUI.switchToWindowIndex(0)
//
//creating second document
'Select Document class and Document Type'
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'('Closure Action', 'ProcessforTaskDT')

'Click on OK Button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))
WebUI.switchToWindowTitle('(Doc ID: NEW )')
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'switch to new window'
WebUI.switchToWindowIndex(1)

'enter customer details'
WebUI.setText(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/input_CustomerDetails'), 'Second DOC(Locked)')
WebUI.setText(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/input_CustomerName'), 'Second DOC(Locked)')

'Click on Save button'
WebUI.mouseOver(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/li_ActionMenu_SubMenu'))
WebUI.waitForElementVisible(findTestObject('Page_WMI_NEW/MultiPage_Viewer_DD/a_Save'), GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Window.clickElementAndWaitForWindowClose'(findTestObject('Page_WMI_NEW/MultiPage_Viewer_DD/a_Save'), GlobalVariable.G_LongTimeout)

'switch to main window'
WebUI.switchToWindowIndex(0)

'Close "create new" popup dialog'
WebUI.switchToWindowIndex(0)
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/span_ui-button-icon-primary ui'))

'right click on Activity A'
WebUI.rightClick(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Process_ProcessForTask/a_Activity A'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'click on refresh'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/contextMenu_Refresh'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'sort DOC ID'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/div_DocID'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_iframe_105'))
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/div_DocID'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_iframe_105'))

int indexDocID=CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'Doc ID')

'verify sorted order of grid (Descending)'
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_iframe_105'))
CustomKeywords.'actions.Table.verifyColumnIsSortedInteger'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'), indexDocID, 'desc')

'click first record from grid'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/table_RecordOne'))

'switch to new window'
WebUI.switchToWindowIndex(1)

'close new window '
WebUI.closeWindowIndex(1)

'switch to main window'
WebUI.switchToWindowIndex(0)

int DocID_LockedRecord=Integer.parseInt(CustomKeywords.'actions.Table.getCellText'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'), 1,indexDocID ))
println DocID_LockedRecord
int DocID_UnLockedRecord=Integer.parseInt(CustomKeywords.'actions.Table.getCellText'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'), 2,indexDocID ))
println DocID_UnLockedRecord

'Expand Activity A'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Process_ProcessForTask/icon_Expand Activity A'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'click on Locked option'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Process_ProcessForTask/a_Locked Activity A'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_iframe_105'))

'sort grid according to column DOC ID'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/div_DocID'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_iframe_105'))
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/div_DocID'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_iframe_105'))

println Integer.parseInt(CustomKeywords.'actions.Table.getCellText'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'), 1,indexDocID ))

'verify locked'
WebUI.verifyMatch(DocID_LockedRecord.toString(),CustomKeywords.'actions.Table.getCellText'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'), 1,indexDocID ) , false)

'click on UnLocked option'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Process_ProcessForTask/a_UnLocked Activity A'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_iframe_105'))

'sort grid according to column DOC ID'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/div_DocID'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_iframe_105'))
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/div_DocID'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_iframe_105'))

println Integer.parseInt(CustomKeywords.'actions.Table.getCellText'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'), 1,indexDocID ))

'verify unlocked'
WebUI.verifyMatch(DocID_UnLockedRecord.toString(), CustomKeywords.'actions.Table.getCellText'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'), 1,indexDocID ), false)