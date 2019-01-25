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

'Select Doc Class as "Event for required field" and Doc type as "Event for required field " from the dropdowns and click on OK button'
WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'('Event for Req Fld', 'Event for req field')
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

'Switch to new window'
WebUI.switchToWindowIndex(1)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'enter values for document'
WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/process_Event For Required Field/select_MasterObjectDropdownControl'), 'Value 1', false)
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)
WebUI.clearText(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/process_Event For Required Field/input_String Field (Value Chan'))
CustomKeywords.'actions.Common.setText_Date'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/process_Event For Required Field/input_Date Field (Visibility C'), '01-01-2018')
WebUI.setText(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/process_Event For Required Field/input_String Field (Value Chan'), 'prasad')

'save document and close'
WebUI.mouseOver(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/process_Event For Required Field/span_Actions'))
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/process_Event For Required Field/a_Save'), GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Window.clickElementAndWaitForWindowClose'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/process_Event For Required Field/a_Save'), GlobalVariable.G_LongTimeout)

'Switch to main window'
WebUI.switchToWindowIndex(0)

'Close "create new" popup dialog'
WebUI.switchToWindowTitle('Savana nGage')
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/span_ui-button-icon-primary ui'))

'Click on My Work link from left menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'navigate to user activity'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('MY_WORK','Processes','Event for required field','User activity','prasad','Value 1','01/01/2018')