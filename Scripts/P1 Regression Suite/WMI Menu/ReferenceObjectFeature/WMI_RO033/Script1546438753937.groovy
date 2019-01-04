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

'click on save'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Reference Object Import/tab_CategoryMenu-Doc Type/span_Save'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Click on tab -CategoryMenu Doc Type'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Reference Object Import/span_CategoryMenu DocType'))

'verify grid present with new button'
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Reference Object Import/tab_CategoryMenu-Doc Type/table_GVGrid'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Reference Object Import/tab_CategoryMenu-Doc Type/span_New'), GlobalVariable.G_LongTimeout)

'click on new button in order to create new Doc'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Reference Object Import/tab_CategoryMenu-Doc Type/span_New'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'verify doc type displayed under reference grid'
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Reference Object Import/tab_CategoryMenu-Doc Type/NewDoc_input_Currency Field_eform_mcb'))
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Reference Object Import/tab_CategoryMenu-Doc Type/NewDoc_input_Date Field_eform_mcb6767'))
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Reference Object Import/tab_CategoryMenu-Doc Type/NewDoc_input_Integer Field_eform_mcb6'))
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Reference Object Import/tab_CategoryMenu-Doc Type/NewDoc_select_Value 1Value 2Value 3Va'))
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Reference Object Import/tab_CategoryMenu-Doc Type/NewDoc_Submit'))
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Reference Object Import/tab_CategoryMenu-Doc Type/NewDoc_Close'))

'fill values for new document'
WebUI.setText(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Reference Object Import/tab_CategoryMenu-Doc Type/NewDoc_input_Integer Field_eform_mcb6'), '50')
WebUI.setText(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Reference Object Import/tab_CategoryMenu-Doc Type/NewDoc_input_Date Field_eform_mcb6767'), '01-01-2018')
WebUI.setText(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Reference Object Import/tab_CategoryMenu-Doc Type/NewDoc_input_Currency Field_eform_mcb'), '75')

'save and close document'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Reference Object Import/tab_CategoryMenu-Doc Type/NewDoc_Submit'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
//WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Reference Object Import/tab_CategoryMenu-Doc Type/NewDoc_Close'))

WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Reference Object Import/tab_CategoryMenu-Doc Type/span_Close Window'))

'Close "create new" popup dialog'
WebUI.switchToWindowTitle('Savana nGage')
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/span_ui-button-icon-primary ui'))

'Go to Recent Documents tab'
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/a_Recent Documents'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/iframe_iframe_103'))

'Validate atleast 1 record is present in the grid.'
int rowCount = CustomKeywords.'actions.Table.getRowsCount'(findTestObject('Page_nGage_Dashboard/Home/table_MyDocumentResults'))
WebUI.verifyGreaterThanOrEqual(rowCount, 1)

'Sort Record in grid by DocID Descending'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Home/div_Doc ID'))
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Home/div_Doc ID'))

'Open Document'
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/column_RecentDocuments LastAction'))
WebUI.switchToWindowIndex(1)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'verify fields values of opened document'
WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Reference Object Import/tab_CategoryMenu-Doc Type/DocCreated_input_Currency Field_eform_mcb'), 'value', '$75.00', GlobalVariable.G_LongTimeout)
WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Reference Object Import/tab_CategoryMenu-Doc Type/DocCreated_input_Date Field_eform_mcb6767'), 'value', '01-01-2018', GlobalVariable.G_LongTimeout)
WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Reference Object Import/tab_CategoryMenu-Doc Type/DocCreated_input_Integer Field'), 'value', '50', GlobalVariable.G_LongTimeout)