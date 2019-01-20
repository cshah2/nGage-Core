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
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'('Business Model View', 'Standard Grid')
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

WebUI.switchToWindowTitle('(Doc ID: NEW )')
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Click on WMI Harness page'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Result_View/span_WMI Harness'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Result_View/iframe_ContentPlaceHolder1_iPage'))

'Click on Save button'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Result_View/span_Save'))

'Verify the record is saved'
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/BusinessModelView/StandardGrid/a_Audit History'))

'Verify Notes tab is loaded'
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/BusinessModelView/StandardGrid/Notes/span_Notes'))

'Verify the border color for Notes grid'
CustomKeywords.'actions.Common.verifyCssValue'(findTestObject('Page_WMI_NEW/BusinessModelView/StandardGrid/Notes/span_Notes'), 'border-top-color', 'rgba(0, 0, 255, 1)')

'Verify the backgroundcolor of Notes grid'
CustomKeywords.'actions.Common.verifyCssValue'(findTestObject('Page_WMI_NEW/BusinessModelView/StandardGrid/Notes/span_Notes'), 'background-color', 'rgba(0, 255, 255, 1)')

'Verify headerbgcolor of Notes grid'
CustomKeywords.'actions.Common.verifyCssValue'(findTestObject('Page_WMI_NEW/BusinessModelView/StandardGrid/Notes/table_NotesTab'), 'background-color', 'rgba(255, 255, 0, 1)')

'Click on New Note button'
WebUI.click(findTestObject('Page_WMI_NEW/BusinessModelView/StandardGrid/Notes/button_NewNote'))

'Verify A pop up with name "Enter Note" should be displayed with test box and save and cancel button'
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/BusinessModelView/StandardGrid/Notes/textarea_PopUpWindow'))
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/BusinessModelView/StandardGrid/Notes/closeButton_PopUpWindow'))
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/BusinessModelView/StandardGrid/Notes/saveButton_PopUpWindow'))

'Enter data in pop up text box'
WebUI.setText(findTestObject('Page_WMI_NEW/BusinessModelView/StandardGrid/Notes/textarea_PopUpWindow'), 'ABCD')

'Click on Save button'
WebUI.click(findTestObject('Page_WMI_NEW/BusinessModelView/StandardGrid/Notes/saveButton_PopUpWindow'))

'Reopen the created notes'
WebUI.click(findTestObject('Page_WMI_NEW/BusinessModelView/StandardGrid/Notes/td_RowNotesTable'))

'Verify the data entered is present in the pop up'
String verifyData = WebUI.getAttribute(findTestObject('Page_WMI_NEW/BusinessModelView/StandardGrid/Notes/textarea_PopUpWindow'), 'value')
WebUI.verifyMatch(verifyData, 'ABCD', false)