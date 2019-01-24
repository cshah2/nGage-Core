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

'Verify Business Model View - DoNotSetValueOnLoad and SetFocus Event doc should be open'
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DoNotSetValueOnLoad SetFocus Event/span_(Title)Business Model View - DoN'))
String actualtext= WebUI.getText(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DoNotSetValueOnLoad SetFocus Event/span_(Title)Business Model View - DoN'))
WebUI.verifyMatch(actualtext, 'Business Model View - DoNotSetValueOnLoad and SetFocus Event', false)

'Verify the tabs SingleresultView and inlineView'
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DoNotSetValueOnLoad SetFocus Event/tab_InlineView'),GlobalVariable.G_LongTimeout)
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DoNotSetValueOnLoad SetFocus Event/tab_SingleResultView'),GlobalVariable.G_LongTimeout)

'Click on SingleresultView tab'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DoNotSetValueOnLoad SetFocus Event/tab_SingleResultView'))

'Verify SingleResultView Tab got Opened'
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DoNotSetValueOnLoad SetFocus Event/SingleResultView_tab/span_(header)SingleResultView'))
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DoNotSetValueOnLoad SetFocus Event/SingleResultView_tab/span_(title)This WMI imparts - Field'))

'Verify All Fields Visible Under SingleResultView Tab'
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DoNotSetValueOnLoad SetFocus Event/SingleResultView_tab/input_Reference Object CheckBox'))
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DoNotSetValueOnLoad SetFocus Event/SingleResultView_tab/input_String Field'))
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DoNotSetValueOnLoad SetFocus Event/SingleResultView_tab/input_Currency Field'))

'Check the reference object checkbox control (checkbox)'
WebUI.check(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DoNotSetValueOnLoad SetFocus Event/SingleResultView_tab/input_Reference Object CheckBox'))
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)

'Verify that reference object checkbox control (checkbox) is checked'
WebUI.verifyElementChecked(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DoNotSetValueOnLoad SetFocus Event/SingleResultView_tab/input_Reference Object CheckBox'),GlobalVariable.G_LongTimeout)

'Verify String Field (text box with view check box is un-checked) is Present'
String textOfStringField = WebUI.getAttribute(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DoNotSetValueOnLoad SetFocus Event/SingleResultView_tab/input_String Field'),'value')
WebUI.verifyMatch(textOfStringField, 'Checkbox is checked', false)

'Verify currency feild text box displayed with Cursor'
CustomKeywords.'actions.Common.verifyElementHasFocus'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DoNotSetValueOnLoad SetFocus Event/SingleResultView_tab/input_Currency Field'))
