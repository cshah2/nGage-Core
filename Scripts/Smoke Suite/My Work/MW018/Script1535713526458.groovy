import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

//Login Into Application
CustomKeywords.'actions.Common.login'()

//Pre-requisuite : A document should be present in LinQ Process
//Click on Global New button
WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))

//Select Document class and Document Type
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'('LinQ DC','LinQ')

//Click on OK Button
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))
WebUI.switchToWindowTitle('(Doc ID: NEW )')
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

//Fill mandatory form data
WebUI.waitForElementPresent(findTestObject('Page_WMI_NEW/LinQ/input_Customer Name'), GlobalVariable.G_LongTimeout)
WebUI.waitForElementVisible(findTestObject('Page_WMI_NEW/LinQ/input_Customer Name'), GlobalVariable.G_LongTimeout)
WebUI.setText(findTestObject('Page_WMI_NEW/LinQ/input_Customer Name'), 'Chintan Shah')
WebUI.setText(findTestObject('Page_WMI_NEW/LinQ/input_Customer Details'), 'Automation Test')

//Click on Save button
WebUI.mouseOver(findTestObject('Page_WMI_NEW/LinQ/span_Actions'))
WebUI.waitForElementVisible(findTestObject('Page_WMI_NEW/LinQ/a_Save'), GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Window.clickElementAndWaitForWindowClose'(findTestObject('Page_WMI_NEW/LinQ/a_Save'), GlobalVariable.G_LongTimeout)

//Close "create new" popup dialog
WebUI.switchToWindowTitle('Savana nGage')
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/span_ui-button-icon-primary ui'))

//Test
//Click on My Work link from left menu
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_iframe_105'))

//Expand LinQ process
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/icon_Expand_LinQ Process'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

//Select LinQ Activity C
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/My_Work/a_LinQ Activity C'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_LinQ Activity C'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

//Uncheck Show Assigned only checkbox is alredy checked
WebUI.uncheck(findTestObject('Page_nGage_Dashboard/My_Work/chexkbox_ShowAssignedOnly'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

//Validate atleast 1 record is present in the grid.
WebUI.verifyElementPresent(findTestObject('Page_nGage_Dashboard/My_Work/table_RecordOne'), GlobalVariable.G_LongTimeout);

//Sort records in grid descending by DocID
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/My_Work/tableHeader_DocID'))
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/My_Work/tableHeader_DocID'))

//Store DocID value in GlobalVariable
GlobalVariable.MW018_DocID = WebUI.getText(findTestObject('Page_nGage_Dashboard/My_Work/table_Record_One_DocIDColumn'))

//Select Checkbox against document in table
WebUI.check(findTestObject('Page_nGage_Dashboard/My_Work/table_RecoedOne_Checkbox'))

//Perform Mouser over on Action button
WebUI.mouseOver(findTestObject('Page_nGage_Dashboard/My_Work/span_Actions Button'))

//Select action "Assign work items"
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/My_Work/action_AssignWorkItems'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/action_AssignWorkItems'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

//Select User and assign it to self on popup dialog
WebUI.selectOptionByLabel(findTestObject('Page_nGage_Dashboard/My_Work/actionDialog_selectUsersOrGroups'), 'Users', false)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_ProcessingGrid'))
WebUI.selectOptionByLabel(findTestObject('Page_nGage_Dashboard/My_Work/actionDialog_selectUserList'), 'Chintan Shah', false)
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/btn_ProcessingGrid_AssignWorkItem'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))
WebUI.verifyElementPresent(findTestObject('Page_nGage_Dashboard/My_Work/processingGrid_SuccessMessage'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementText(findTestObject('Page_nGage_Dashboard/My_Work/processingGrid_SuccessMessage'), 'Successfully Re-assigned the WorkItems to - Chintan Shah')

//Close popup dialog
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/btn_processingGrid_Close'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

//Select Show Assigned only checkbox
WebUI.check(findTestObject('Page_nGage_Dashboard/My_Work/chexkbox_ShowAssignedOnly'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

//Verify Record is displayed in the grid
WebUI.verifyElementText(findTestObject('Page_nGage_Dashboard/My_Work/table_Record_One_DocIDColumn'), GlobalVariable.MW018_DocID)