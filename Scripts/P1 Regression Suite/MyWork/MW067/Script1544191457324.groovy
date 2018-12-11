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
CustomKeywords.'actions.Common.login'('Auto_BO_Uncheck', 'Password1234!', 'IPM_EPM50MASTER_502_AUTOMATION')

//Pre-requisuite : A document should be present in Closure Action - Activity A
//Click on Global New button
WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))

//Select Document class and Document Type
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'('Closure Action','Closure Action')

//Click on OK Button
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))
WebUI.switchToWindowTitle('(Doc ID: NEW )')
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
WebUI.scrollToElement(findTestObject('Page_WMI_NEW/Closure_Action/input_Customer Name'), GlobalVariable.G_LongTimeout)

//Fill mandatory form data
WebUI.setText(findTestObject('Page_WMI_NEW/Closure_Action/input_Customer Name'), 'Chintan Shah')
WebUI.setText(findTestObject('Page_WMI_NEW/Closure_Action/input_Customer Details'), 'Automation Test')

//Click on Save button
WebUI.mouseOver(findTestObject('Page_WMI_NEW/Closure_Action/span_Actions'))
WebUI.waitForElementVisible(findTestObject('Page_WMI_NEW/Closure_Action/a_Save'), GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Window.clickElementAndWaitForWindowClose'(findTestObject('Page_WMI_NEW/Closure_Action/a_Save'), GlobalVariable.G_LongTimeout)

//Close "create new" popup dialog
WebUI.switchToWindowTitle('Savana nGage')
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/span_ui-button-icon-primary ui'))

//Test Steps
//Click on My Work link from left menu
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_iframe_105'))

//Expand Closure Action process
CustomKeywords.'actions.MenuBar.clickTreeMenu'('MY_WORK', 'Processes', 'Closure Action', 'Activity A')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

//Validate atleast 1 record is present in the grid.
WebUI.verifyElementPresent(findTestObject('Page_nGage_Dashboard/My_Work/table_RecordOne'), GlobalVariable.G_LongTimeout);

//Sort record by Doc_Created_Date desc
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/My_Work/tableHeader_DocCreateDate'))
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/My_Work/tableHeader_DocCreateDate'))

int docIdcolumnNumber = CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'Doc ID')
//Save DocID Value for future verification purpose
String DocID = CustomKeywords.'actions.Table.getCellText'(findTestObject('Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'), 1, docIdcolumnNumber)
println "DociD  = :"+DocID

//Select first document from the table (Save DocID value for later use)
CustomKeywords.'actions.Table.checkRecordInTable'(findTestObject('Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'), 1)

//Perform Mouse over on Action button
WebUI.mouseOver(findTestObject('Page_nGage_Dashboard/My_Work/span_Actions Button'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

//Perform Route to activity C action
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/My_Work/action_RouteToActivityC'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/action_RouteToActivityC'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_ProcessingGrid'))

//Wait till Processing Grid displays success message
WebUI.waitForElementPresent(findTestObject('Page_nGage_Dashboard/My_Work/td_RecordProcessingMessage_Success'), GlobalVariable.G_LongTimeout)
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/My_Work/td_RecordProcessingMessage_Success'), GlobalVariable.G_LongTimeout)

//Refresh Closure Action process until record count in tree is updated
CustomKeywords.'actions.MenuBar.refreshActivityUntilRecordCountIncreases'(findTestObject('Page_nGage_Dashboard/My_Work/a_Activity C'), GlobalVariable.G_LongTimeout)

//Select Activity C from left menu
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/My_Work/a_Activity C'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_Activity C'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

//Sort record by Doc_Created_Date desc
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/My_Work/tableHeader_DocCreateDate'))
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/My_Work/tableHeader_DocCreateDate'))

//Verify Document is present in Activity C result table

CustomKeywords.'actions.Table.verifyRecordPresentInColumn'(findTestObject('Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'), docIdcolumnNumber, DocID)

//Pre-requisuite : A document should be present in Closure Action - Activity A
//Click on Global New button
WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))

//Select Document class and Document Type
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'('Closure Action','Closure Action')

//Click on OK Button
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))
WebUI.switchToWindowTitle('(Doc ID: NEW )')
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
WebUI.scrollToElement(findTestObject('Page_WMI_NEW/Closure_Action/input_Customer Name'), GlobalVariable.G_LongTimeout)

//Fill mandatory form data
WebUI.setText(findTestObject('Page_WMI_NEW/Closure_Action/input_Customer Name'), 'Chintan Shah')
WebUI.setText(findTestObject('Page_WMI_NEW/Closure_Action/input_Customer Details'), 'Automation Test')

//Click on Save button
WebUI.mouseOver(findTestObject('Page_WMI_NEW/Closure_Action/span_Actions'))
WebUI.waitForElementVisible(findTestObject('Page_WMI_NEW/Closure_Action/a_Save'), GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Window.clickElementAndWaitForWindowClose'(findTestObject('Page_WMI_NEW/Closure_Action/a_Save'), GlobalVariable.G_LongTimeout)

//Close "create new" popup dialog
WebUI.switchToWindowTitle('Savana nGage')
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/span_ui-button-icon-primary ui'))

//Test Steps
//Click on My Work link from left menu
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_iframe_105'))

//Expand Closure Action process
CustomKeywords.'actions.MenuBar.clickTreeMenu'('MY_WORK', 'Processes', 'Closure Action', 'Activity A')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

//Validate atleast 1 record is present in the grid.
WebUI.verifyElementPresent(findTestObject('Page_nGage_Dashboard/My_Work/table_RecordOne'), GlobalVariable.G_LongTimeout);

//Sort record by Doc_Created_Date desc
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/My_Work/tableHeader_DocCreateDate'))
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/My_Work/tableHeader_DocCreateDate'))

//Save DocID Value for future verification purpose
String DocID1 = CustomKeywords.'actions.Table.getCellText'(findTestObject('Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'), 1, docIdcolumnNumber)
println "DociD  = :"+DocID1

//Open Document
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/table_Record_One_DocIDColumn'))
WebUI.switchToWindowIndex(1)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

//Click on Customer Information tab
WebUI.click(findTestObject('Page_WMI/Closure Action/tab_CustomerInformation'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_WMI/Closure Action/iframe_ContentPlaceHolder1_iPa'))

//Select Closure Action drop down
WebUI.mouseOver(findTestObject('Page_WMI/Closure Action/button_CustomerActions'))

//Select Action route To Activity B
WebUI.waitForElementVisible(findTestObject('Page_WMI/Closure Action/action_RouteToActivityB'), GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Window.clickElementAndWaitForWindowClose'(findTestObject('Page_WMI/Closure Action/action_RouteToActivityB'), GlobalVariable.G_LongTimeout)

//Refresh Activity B to verify count has increased or not
WebUI.switchToWindowTitle('Savana nGage')
CustomKeywords.'actions.MenuBar.refreshActivityUntilRecordCountIncreases'(findTestObject('Page_nGage_Dashboard/My_Work/a_Activity B'), GlobalVariable.G_LongTimeout)

//Select Activity B
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_Activity B'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

//Sort records by Creation Date Desc
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/My_Work/tableHeader_DocCreateDate'))
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/My_Work/tableHeader_DocCreateDate'))

//Verify document is present in Activity B
CustomKeywords.'actions.Table.verifyRecordPresentInColumn'(findTestObject('Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'), docIdcolumnNumber, DocID1)