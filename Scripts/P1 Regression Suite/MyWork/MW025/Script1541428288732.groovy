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

'Create Docuement'
CustomKeywords.'actions.Common.createDocument_ClosureAction'('Chintan Shah', 'P1 - MYWORK025')

'Click on My Work link from left menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_iframe_105'))

'Click Closure Action - Activity A'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('MY_WORK', 'Processes', 'Closure Action', 'Activity A')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Uncheck Show Assigned only checkbox if already checked'
WebUI.uncheck(findTestObject('Page_nGage_Dashboard/My_Work/chexkbox_ShowAssignedOnly'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Validate atleast 1 record is present in the grid.'
int rowCount = CustomKeywords.'actions.Table.getRowsCount'(findTestObject('Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'))
WebUI.verifyGreaterThanOrEqual(rowCount, 1)

'Sort records in grid descending by DocID'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/My_Work/tableHeader_DocID'))
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/My_Work/tableHeader_DocID'))

int docIDColumnNo = CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'Doc ID')

'Get DOCID of newly created document'
String _docId = CustomKeywords.'actions.Table.getCellText'(findTestObject('Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'), 1, docIDColumnNo)

'Open Document'
CustomKeywords.'actions.Table.clickCell'(findTestObject('Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'), 1, docIDColumnNo)

WebUI.switchToWindowIndex(1)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Click on Customer Information tab'
WebUI.click(findTestObject('Page_WMI/Closure Action/tab_CustomerInformation'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_WMI/Closure Action/iframe_ContentPlaceHolder1_iPa'))

'Close popup window'
WebUI.closeWindowIndex(1)

WebUI.switchToWindowTitle('Savana nGage')

'Verify Lock Icon is displayed against document'
WebUI.verifyElementPresent(findTestObject('Page_nGage_Dashboard/My_Work//table_Record_One_LockIcon_Column'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementVisible(findTestObject('Page_nGage_Dashboard/My_Work//table_Record_One_LockIcon_Column'))

'Select Checkbox against document in table'
CustomKeywords.'actions.Table.checkRecordInTable'(findTestObject('Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'), 1)

'Perform Mouser over on Action button'
WebUI.mouseOver(findTestObject('Page_nGage_Dashboard/My_Work/span_Actions Button'))

'Select action "Unlock work items"'
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/My_Work/action_UnlockWorkItems'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/action_UnlockWorkItems'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Verify Success message'
WebUI.verifyElementPresent(findTestObject('Page_nGage_Dashboard/My_Work/processingGrid_SuccessMessage'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementText(findTestObject('Page_nGage_Dashboard/My_Work/processingGrid_SuccessMessage'), 'Work item(s) unlocked successfully')

'Close popup dialog'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/btn_processingGrid_Close'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Verify lock icon is no longer present against document'
WebUI.verifyElementNotPresent(findTestObject('Page_nGage_Dashboard/My_Work//table_Record_One_LockIcon_Column'), GlobalVariable.G_LongTimeout)

'verify checkbox not checked after grid refresh'
WebUI.verifyElementNotChecked(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/table_Record_One_Checkbox'), GlobalVariable.G_LongTimeout)