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
import utils.Consts

'Login Into Application'
CustomKeywords.'actions.Common.login'()

'Create document for render all field types'
CustomKeywords.'actions.Common.createDocument_RenderAllField'('10', '', '', '', '', '', '', '', '', '', '')

'Create a new Refrence Object Feature Document'
WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'('Reference Object Feature', 'Reference Object Import')
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

'switch to new window'
WebUI.switchToWindowTitle('(Doc ID: NEW )')
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'verify Various Tabs are displayed depending on reference object import feature'
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Reference Object Import/span_CategoryMenu DocType'))
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Reference Object Import/span_CategoryMenu with more do'))
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Reference Object Import/span_CategoryMenu'))
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Reference Object Import/span_DropDown(Default)'))
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Reference Object Import/span_DropDown'))
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Reference Object Import/span_New link(Default)'))
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Reference Object Import/span_Reference Object'))

'Click on tab reference object'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Reference Object Import/span_Reference Object'))

'verify reference grid is present'
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Reference Object Import/tab_Reference Object/table_GVGrid'), GlobalVariable.G_LongTimeout)

'click on first row of grid '
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Reference Object Import/tab_Reference Object/tr_Grid First Row'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'verify document opened'
WebUI.waitForElementPresent(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Reference Object Import/tab_Reference Object/dialog_span_Doc Type Label'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Reference Object Import/tab_Reference Object/dialog_span_Doc Type Label'))

'enter date for document'
CustomKeywords.'actions.Common.setText_Date'(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Reference Object Import/tab_Reference Object/dialog_input_renderastextbox'), Consts.P1_WMI_RO028_DATE)

'save and close document'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Reference Object Import/tab_Reference Object/dialog_span_Save'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Reference Object Import/tab_Reference Object/dialog_span_Close Window'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Reference Object Import/tab_Reference Object/span_Close Window'))

'Close "create new" popup dialog'
WebUI.switchToWindowTitle('Savana nGage')
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/span_ui-button-icon-primary ui'))

'Go to Recent Documents tab'
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/a_Recent Documents'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/iframe_iframe_103'))

'Validate atleast 1 record is present in the grid.'
int rowCount = CustomKeywords.'actions.Table.getRowsCount'(findTestObject('Page_nGage_Dashboard/Home/table_MyDocumentResults'))
WebUI.verifyGreaterThanOrEqual(rowCount, 1)

'open created document'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/tr_MyDocumentResults_First Row'))
WebUI.switchToWindowIndex(1)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'verify opened document'
WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Reference Object Import/tab_Reference Object/input_Date'), 'value', Consts.P1_WMI_RO028_DATE, GlobalVariable.G_LongTimeout)