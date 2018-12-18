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
WebUI.verifyElementVisible(findTestObject('Object Repository/BusinessModelView/StandardGrid/a_Audit History'))

/*'Click on New Notes tab'
WebUI.click(findTestObject('Object Repository/BusinessModelView/StandardGrid/button_NewNote'))
*/
'Verify Notes tab is loaded'
WebUI.verifyElementVisible(findTestObject('Object Repository/BusinessModelView/StandardGrid/span_Notes'))

'Verify the border color for Notes grid'
/*String borderTop = WebUI.getCSSValue(findTestObject('Object Repository/BusinessModelView/StandardGrid/span_Notes'), 'border-top')
WebUI.verifyMatch(borderTop, '#0000FF', false)*/
CustomKeywords.'actions.Common.verifyCssValue'(findTestObject('Object Repository/BusinessModelView/StandardGrid/span_Notes'), 'border-top-color', 'rgba(0, 0, 255, 1)')

'Verify the backgroundcolor of Notes grid'
String backgraoundColor = WebUI.getCSSValue(findTestObject('Object Repository/BusinessModelView/StandardGrid/span_Notes'), 'background-color')
WebUI.verifyMatch(backgraoundColor, '#FFFF00', false)

'Verify'