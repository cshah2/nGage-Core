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

'Click on BPM History(No system Activity) tab'
WebUI.click(findTestObject('Page_WMI_NEW/BusinessModelView/StandardGrid/a_BPM History(No System Activi'))

'Verify BPM History(No system Activity) tab is loaded'
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/BusinessModelView/StandardGrid/BPM_History(NoSystemActivity)/table_BPM History(No System Ac'))

'Verify the border color BPM History(No system Activity) tab'
CustomKeywords.'actions.Common.verifyCssValue'(findTestObject('Page_WMI_NEW/BusinessModelView/StandardGrid/BPM_History(NoSystemActivity)/table_Header'), 'border-top-color', 'rgba(0, 0, 128, 1)')

'Verify headerbgcolor of PM History(No system Activity) tab'
CustomKeywords.'actions.Common.verifyCssValue'(findTestObject('Page_WMI_NEW/BusinessModelView/StandardGrid/BPM_History(NoSystemActivity)/table_BPM History(No System Ac'), 'background-color', 'rgba(128, 128, 0, 1)')

'Verify the backgroundcolor of PM History(No system Activity) tab'
CustomKeywords.'actions.Common.verifyCssValue'(findTestObject('Page_WMI_NEW/BusinessModelView/StandardGrid/BPM_History(NoSystemActivity)/table_Header'), 'background-color', 'rgba(255, 255, 240, 1)')

'Verify Backto Top link is displayed'
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/BusinessModelView/StandardGrid/BPM_History(NoSystemActivity)/a_ Back to Top'))