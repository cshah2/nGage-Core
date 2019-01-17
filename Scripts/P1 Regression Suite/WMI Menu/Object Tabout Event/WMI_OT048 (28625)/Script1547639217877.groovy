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
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'('Object Tabout Events', 'DoNotSetValueOnLoad and SetFocus Event')
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

WebUI.switchToWindowTitle('(Doc ID: NEW )')
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'verify opened document'
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DoNotSetValueOnLoad SetFocus Event/span_(Title)Business Model View - DoN'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DoNotSetValueOnLoad SetFocus Event/span_(Title)Business Model View - DoN'))

'Under the Business Model View, verify the feilds master object checkbox control (checkbox), String feild (text box with view check box is un-checked) and currency feild text box. '
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DoNotSetValueOnLoad SetFocus Event/input_Master Object CheckBox C'))
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DoNotSetValueOnLoad SetFocus Event/input_Currency Field (setfocus'))
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DoNotSetValueOnLoad SetFocus Event/input_String Field (donotsetva'))

'check the master object checkbox control (checkbox)'
WebUI.check(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DoNotSetValueOnLoad SetFocus Event/input_Master Object CheckBox C'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DoNotSetValueOnLoad SetFocus Event/iframe_Close Window_ContentPla'))

'verify master object checkbox should get checked'
WebUI.verifyElementChecked(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DoNotSetValueOnLoad SetFocus Event/input_Master Object CheckBox C'), GlobalVariable.G_LongTimeout)

'verify String feild (text box with view check box is checked) should be dipslyed '
WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DoNotSetValueOnLoad SetFocus Event/input_String Field (donotsetva'), 'value', 'Checkbox is checked', GlobalVariable.G_LongTimeout)

'verify cursor control displayed in currency feild text box '
CustomKeywords.'actions.Common.verifyElementHasFocus'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DoNotSetValueOnLoad SetFocus Event/input_Currency Field (setfocus'))