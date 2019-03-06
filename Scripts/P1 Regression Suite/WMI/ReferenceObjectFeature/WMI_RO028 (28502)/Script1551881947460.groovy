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

'Click on tab - New link (default) '
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Reference Object Import/span_New link(Default)'))

'verify new button present/visible'
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Reference Object Import/tab_New Link Default/span_New'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Reference Object Import/tab_New Link Default/span_New'))

'click on new button'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Reference Object Import/tab_New Link Default/span_New'))

'verify dialogue box present'
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Reference Object Import/tab_New Link Default/input_Integer Field_eform_mcb6'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Reference Object Import/tab_New Link Default/input_String Field (with onfoc'))
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Reference Object Import/tab_New Link Default/input_DateField'), GlobalVariable.G_LongTimeout)

'Enter any Date in text box'
CustomKeywords.'actions.Common.setText_Date'(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Reference Object Import/tab_New Link Default/input_DateField'), Consts.P1_WMI_RO028_DATE)

'click on Save button'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Reference Object Import/tab_New Link Default/span_Save'))

'click on close button'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Reference Object Import/tab_New Link Default/span_Close Window'))

'close window'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Reference Object Import/span_Close Window'))

'Close "create new" popup dialog'
WebUI.switchToWindowTitle('Savana nGage')
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/span_ui-button-icon-primary ui'))

'Navigate to Recent Documents'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('HOME', 'Recent Documents')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/iframe_iframe_103'))

'Refresh Recent Document'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/Home/span_Refresh Grid'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/iframe_iframe_103'))

'Sort records DocID Descending'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'), 'Doc ID')
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'), 'Doc ID')

'Open saved doc from recent document'
CustomKeywords.'actions.Table.clickCell'(findTestObject('Object Repository/Page_nGage_Dashboard/Home/table_MyDocumentResults'), 1, 7)
WebUI.switchToWindowIndex(1)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'verify input date'
WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Reference Object Import/tab_DROPDOWN (default)/CreatedDoc_input_Date Field'), 'value', Consts.P1_WMI_RO028_DATE, GlobalVariable.G_LongTimeout)