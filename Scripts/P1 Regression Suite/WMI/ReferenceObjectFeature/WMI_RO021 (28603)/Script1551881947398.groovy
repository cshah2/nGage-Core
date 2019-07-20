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

'Create a new Refrence Object Feature Document'
WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'('Reference Object Feature', 'Reference Object AdhocFilter')
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

WebUI.switchToWindowTitle('(Doc ID: NEW )')
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Click on Save from master object'
WebUI.click(findTestObject('Page_WMI_NEW/Reference_Object_Feature/ImportMode_Interactive/btn_Save'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
WebUI.switchToWindowIndex(1)

String windowTitle= WebUI.getWindowTitle()
String[] str_array = windowTitle.split("-")
String windowTitleAfterSave = str_array[0].trim()

'Close Window() and If Error Present Document will not get Close'
CustomKeywords.'actions.Window.clickElementAndWaitForWindowClose'(findTestObject('Page_WMI_NEW/Reference_Object_Feature/ImportMode_Interactive/btn_CloseWindow'), GlobalVariable.G_LongTimeout)

'Switch to parent window'
WebUI.switchToWindowIndex(0)
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/span_ui-button-icon-primary ui'))

'Navigate to Recent Documents'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('HOME', 'Recent Documents')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/iframe_iframe_103'))

'Sort records DocID Descending'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'), 'Doc ID')
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'), 'Doc ID')

int docTypeColumnPosition =CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'),'Doc Type')

String docTypeInRecentDoc = CustomKeywords.'actions.Table.getCellText'(findTestObject('Object Repository/Page_nGage_Dashboard/Home/table_MyDocumentResults'), 1,docTypeColumnPosition)

'Verify Document Saved in Recent Documents'
WebUI.verifyMatch(docTypeInRecentDoc, windowTitleAfterSave,false)

'Open recent document'
CustomKeywords.'actions.Table.clickCell'(findTestObject('Object Repository/Page_nGage_Dashboard/Home/table_MyDocumentResults'), 1, 7)
WebUI.switchToWindowIndex(1)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Verify Saved Document Opened in Another Window'
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/AdHoc_Filter/span_This WMI imparts Referenc'),GlobalVariable.G_LongTimeout)
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/AdHoc_Filter/span_Business Model View - Ref'),GlobalVariable.G_LongTimeout)

'Click On tab 1) AdHoc Filter'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/AdHoc_Filter/tab1_AdHoc_Filter/span_1) AdHoc Filter'))
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)

String gridCountBeforeFilterApply = Integer.parseInt((WebUI.getText(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/AdHoc_Filter/tab1_AdHoc_Filter/span_GridCount'))).split('\\ ')[1])
println gridCountBeforeFilterApply

'Click on Search'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/AdHoc_Filter/tab1_AdHoc_Filter/span_Search'))

'Select (=)Operator from Dropdown'
WebUI.selectOptionByValue(findTestObject('Page_WMI_NEW/Reference_Object_Feature/AdHoc_Filter/tab1_AdHoc_Filter/select_Operator'), '=', false)

'Select Valid Doc ID from Grid'
String setDocID = CustomKeywords.'actions.Table.getCellText'(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/AdHoc_Filter/table_GVGrid'),1,4)

'Provide DocID to filter results '
WebUI.setText(findTestObject('Page_WMI_NEW/Reference_Object_Feature/AdHoc_Filter/tab1_AdHoc_Filter/input_Doc ID'), setDocID)

'Click On Filter Button'
WebUI.click(findTestObject('Page_WMI_NEW/Reference_Object_Feature/AdHoc_Filter/tab1_AdHoc_Filter/input_Filter'))
CustomKeywords.'actions.Common.waitForTabLoading'(null,GlobalVariable.G_LongTimeout)


int rowCount =CustomKeywords.'actions.Table.getRowsCount'(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/AdHoc_Filter/table_GVGrid'))

'Verify According to filter set record should be displaying in reference grid '
CustomKeywords.'actions.Table.verifyRecordsCount'(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/AdHoc_Filter/table_GVGrid'),rowCount)

'Click on clear button from AdHoc filter'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/AdHoc_Filter/tab1_AdHoc_Filter/input_Clear'))
CustomKeywords.'actions.Common.waitForTabLoading'(null,GlobalVariable.G_LongTimeout)

String gridCountAfterReset = Integer.parseInt((WebUI.getText(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/AdHoc_Filter/tab1_AdHoc_Filter/span_GridCount'))).split('\\ ')[1])
println gridCountAfterReset

'Verify value text box should be clear and operator should be set on "=" operator'
WebUI.verifyOptionPresentByValue(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/AdHoc_Filter/tab1_AdHoc_Filter/select_Operator'),'=', false, GlobalVariable.G_LongTimeout)

'Verify all records should be display in reference grid'
WebUI.verifyMatch(gridCountBeforeFilterApply,gridCountAfterReset,false)