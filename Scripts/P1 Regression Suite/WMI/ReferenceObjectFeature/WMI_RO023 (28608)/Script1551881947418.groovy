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

'Create Bulk documents render as label'
CustomKeywords.'actions.Common.createBulkDocuments_RenderAsLabel'(3)

'Create a new Refrence Object Feature Document'
WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'('Reference Object Feature', 'Reference Object CustomButton')
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

WebUI.switchToWindowTitle('(Doc ID: NEW )')
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Click on Save from master object'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/ImportMode_Interactive/span_Save'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
WebUI.switchToWindowIndex(1)

String windowTitle= WebUI.getWindowTitle()
String[] str_array = windowTitle.split("-")
String windowTitleAfterSave = str_array[0].trim()

'Close Window() and If Error Present Document will not get Close'
CustomKeywords.'actions.Window.clickElementAndWaitForWindowClose'(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/ImportMode_Interactive/span_Close Window'), GlobalVariable.G_LongTimeout)

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

'Verify Saved Document Opened'
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/CustomButton/tab1_CustomButtons/span_Business Model View - Ref'),GlobalVariable.G_LongTimeout)
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/CustomButton/tab1_CustomButtons/span_This WMI imparts Referenc'),GlobalVariable.G_LongTimeout)

'Click On Tab 1'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/CustomButton/tab1_CustomButtons/span_1) Custom Buttons'))
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/CustomButton/tab1_CustomButtons/iframe_Close Window_ContentPla'))

'Verify Document should be displayed in reference grid'
WebUI.verifyElementPresent(findTestObject('Page_WMI_NEW/Reference_Object_Feature/CustomButton/tab1_CustomButtons/input_ Google_Button'),GlobalVariable.G_LongTimeout )
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Reference_Object_Feature/CustomButton/tab1_CustomButtons/input_ Google_Button'))

'Select mutiple check boxes from grid'
//WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/CustomButton/tab1_CustomButtons/input_BM Text_eform_mcb67676Ta'))
//WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/CustomButton/tab1_CustomButtons/input_Label Control_eform_mcb6'))
//WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/CustomButton/tab1_CustomButtons/input_You selected Option 1_ef'))
CustomKeywords.'actions.Table.checkRecordInTable'(findTestObject('Page_WMI_NEW/Reference_Object_Feature/CustomButton/tab1_CustomButtons/table_ResultGrid'), 1)
CustomKeywords.'actions.Table.checkRecordInTable'(findTestObject('Page_WMI_NEW/Reference_Object_Feature/CustomButton/tab1_CustomButtons/table_ResultGrid'), 2)
CustomKeywords.'actions.Table.checkRecordInTable'(findTestObject('Page_WMI_NEW/Reference_Object_Feature/CustomButton/tab1_CustomButtons/table_ResultGrid'), 3)


'Verify selected check boxes should be check'
WebUI.verifyElementChecked(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/CustomButton/tab1_CustomButtons/input_BM Text_eform_mcb67676Ta'),GlobalVariable.G_LongTimeout)
WebUI.verifyElementChecked(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/CustomButton/tab1_CustomButtons/input_Label Control_eform_mcb6'),GlobalVariable.G_LongTimeout)
WebUI.verifyElementChecked(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/CustomButton/tab1_CustomButtons/input_You selected Option 1_ef'),GlobalVariable.G_LongTimeout)

'Click on Custom Button Google and Verify New Window Should Open'
WebUI.click(findTestObject('Page_WMI_NEW/Reference_Object_Feature/CustomButton/tab1_CustomButtons/input_ Google_Button'))
WebUI.switchToWindowIndex(2)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)


'Verify Google page should be open in new window'
String googleUrlAfterClick= WebUI.getUrl()
WebUI.verifyMatch(googleUrlAfterClick, '.*https://www.google.com.*', true)

