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
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'('Reference Object Feature', 'Reference Object SingleResultView')
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

WebUI.switchToWindowTitle('(Doc ID: NEW )')
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

//WebUI.clearText(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Single_Result_view/tab_SingleResultView/input_Reference Object Event_e'))
//WebUI.setText(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Single_Result_view/tab_SingleResultView/input_Reference Object Event_e'),'Document Saved')


String beforeSave=WebUI.getAttribute(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Single_Result_view/tab_SingleResultView/input_Reference Object Event_e'),'value')
println beforeSave


'Click on Save from master object'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Single_Result_view/span_Save'))


'Close Window button'
CustomKeywords.'actions.Window.clickElementAndWaitForWindowClose'(null, 0)

//WebUI.closeWindowTitle('(Doc ID: NEW )')
WebUI.switchToWindowIndex(0)

'Verify Document get Saved'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('HOME', 'Recent Documents')
//Wait for frame

//WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/Home/a_Recent Documents'))
//WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/Home/span_Refresh Grid'))

CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Object Repository/Page_nGage_Dashboard/Home/column_RecentDocuments DocID'))
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Object Repository/Page_nGage_Dashboard/Home/column_RecentDocuments DocID'))


//WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/Home/column_RecentDocuments DocID'))
//WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/Home/column_RecentDocuments DocID'))
CustomKeywords.'actions.Table.clickCell'(findTestObject('Object Repository/Page_nGage_Dashboard/Home/table_MyDocumentResults'), 1, 3)
WebUI.switchToWindowIndex(1)

'Click on tab 1) SingleResultView'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Single_Result_view/tab_SingleResultView/span_1) SingleResultView'))

String afterSave=WebUI.getAttribute(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Single_Result_view/tab_SingleResultView/input_Reference Object Event_e'),'value')
println afterSave

'Verify Single document should be disaply in Inline mode'
WebUI.verifyMatch(afterSave, beforeSave, false)
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Single_Result_view/tab_SingleResultView/span_This WMI imparts - Events'),GlobalVariable.G_LongTimeout)