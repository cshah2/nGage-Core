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

'Click on Revision tab'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/BusinessModelView/StandardGrid/a_Revision History'))

'Verify Revision tab is loaded'
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/BusinessModelView/StandardGrid/RevisionHistory/table_Revision History'))

'Verify columns version, title, version date, created by, Comments are loaded'
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/BusinessModelView/StandardGrid/RevisionHistory/td_Title'))
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/BusinessModelView/StandardGrid/RevisionHistory/td_Version'))
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/BusinessModelView/StandardGrid/RevisionHistory/td_Version Date'))
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/BusinessModelView/StandardGrid/RevisionHistory/td_Created By'))
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/BusinessModelView/StandardGrid/RevisionHistory/td_Comments'))

'Verify the bordercolor for grid'
CustomKeywords.'actions.Common.verifyCssValue'(findTestObject('Page_WMI_NEW/BusinessModelView/StandardGrid/RevisionHistory/td1_RevisionHistory'), 'border-top-color', 'rgba(255, 127, 80, 1)')

'Verify the backgroundcolor for grid (backgroundcolor set in wmi is #FAF0E6=linen)'
CustomKeywords.'actions.Common.verifyCssValue'(findTestObject('Page_WMI_NEW/BusinessModelView/StandardGrid/RevisionHistory/table_Revision History'), 'background-color', 'rgba(250, 240, 230, 1)')

'Verify the headerbgcolor for grid (headerbgcolor set in wmi is #E0FFFF=lightcyan)'
CustomKeywords.'actions.Common.verifyCssValue'(findTestObject('Page_WMI_NEW/BusinessModelView/StandardGrid/RevisionHistory/td1_RevisionHistory'), 'background-color', 'rgba(224, 255, 255, 1)')

'Verify the footer "Back to Top" link displayed at the bottom'
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/BusinessModelView/StandardGrid/RevisionHistory/a_ Back to Top'))