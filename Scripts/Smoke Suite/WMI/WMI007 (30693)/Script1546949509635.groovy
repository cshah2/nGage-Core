import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import utils.Consts
import utils.DateUtil

'Login into application'
CustomKeywords.'actions.Common.login'()

'Click on Global New button'
WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))

'Select Document class and Document Type'
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'('Reference Object Feature', 'Reference Object Import')

'Click on OK Button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))
WebUI.switchToWindowTitle('(Doc ID: NEW )')
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Verify WMI Section title'
WebUI.verifyElementText(findTestObject('Page_WMI_NEW/Reference_Object_Import/span_WMI_Title'), 'Business Model View - Reference Object Import')

'Verify WMI Information text'
WebUI.verifyElementText(findTestObject('Page_WMI_NEW/Reference_Object_Import/span_WMI_Infomation'), 'This WMI imparts Reference Object Import feature')

'Click on CategoryMenu tab'
WebUI.click(findTestObject('Page_WMI_NEW/Reference_Object_Import/tab_CategoryMenu'))

'Verify Title under tab CategoryMenu'
WebUI.verifyElementText(findTestObject('Page_WMI_NEW/Reference_Object_Import/span_CategoryMenu title'), 'CategoryMenu')

'Perform Mouse over on New button > Others button > More button > and click on Render all fields'
WebUI.mouseOver(findTestObject('Page_WMI_NEW/Reference_Object_Import/CategoryMenu - button_New'))
WebUI.waitForElementVisible(findTestObject('Page_WMI_NEW/Reference_Object_Import/CategoryMenu - button_Others'), GlobalVariable.G_LongTimeout)

WebUI.mouseOver(findTestObject('Page_WMI_NEW/Reference_Object_Import/CategoryMenu - button_Others'))
WebUI.waitForElementVisible(findTestObject('Page_WMI_NEW/Reference_Object_Import/CategoryMenu - button_More'), GlobalVariable.G_LongTimeout)

WebUI.mouseOver(findTestObject('Page_WMI_NEW/Reference_Object_Import/CategoryMenu - button_More'))
WebUI.waitForElementVisible(findTestObject('Page_WMI_NEW/Reference_Object_Import/CategoryMenu - button_RenderAllFields'), GlobalVariable.G_LongTimeout)

WebUI.click(findTestObject('Page_WMI_NEW/Reference_Object_Import/CategoryMenu - button_RenderAllFields'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_WMI_NEW/Reference_Object_Import/NewLinkModalDialog/iframe_ContentPlaceHolder_Inner'))

'Validate title of WMI opened as modal dialog'
WebUI.verifyElementText(findTestObject('Page_WMI_NEW/Reference_Object_Import/NewLinkModalDialog/modal dialog title'), 'Create New Item')

'Validate Business modal view - render all field types WMI is opened'
WebUI.waitForElementPresent(findTestObject('Page_WMI_NEW/Reference_Object_Import/NewLinkModalDialog/modal dialog WMI Title'), GlobalVariable.G_LongTimeout)
WebUI.waitForElementVisible(findTestObject('Page_WMI_NEW/Reference_Object_Import/NewLinkModalDialog/modal dialog WMI Title'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementText(findTestObject('Page_WMI_NEW/Reference_Object_Import/NewLinkModalDialog/modal dialog WMI Title'), 'Business Model View - Render All Field Types')

'Set DateTime value as current date time'
String _format = Consts.FORMAT_DATETIME
Consts.SMOKE_WMI007_FIELD9 = DateUtil.getCurrentDateTime(_format)

'Enter data in all fields in open modal dialog'
WebUI.waitForElementVisible(findTestObject('Page_WMI_NEW/Reference_Object_Import/NewLinkModalDialog/input_Integer field'), GlobalVariable.G_LongTimeout)
WebUI.setText(findTestObject('Page_WMI_NEW/Reference_Object_Import/NewLinkModalDialog/input_Integer field'), Consts.SMOKE_WMI007_FIELD1) //Integer Field
WebUI.setText(findTestObject('Page_WMI_NEW/Reference_Object_Import/NewLinkModalDialog/input_String Field (with onfocussetcursorattheend attribute)'), Consts.SMOKE_WMI007_FIELD2) //String Field (with onfocussetcursorattheend attribute)
WebUI.selectOptionByLabel(findTestObject('Page_WMI_NEW/Reference_Object_Import/NewLinkModalDialog/input_String Field With Lookup'), Consts.SMOKE_WMI007_FIELD3, false) //String Field With Lookup
WebUI.setText(findTestObject('Page_WMI_NEW/Reference_Object_Import/NewLinkModalDialog/input_Currency Field'), Consts.SMOKE_WMI007_FIELD4) //Currency Field
CustomKeywords.'actions.Common.setText_Date'(findTestObject('Page_WMI_NEW/Reference_Object_Import/NewLinkModalDialog/input_Date Field'), Consts.SMOKE_WMI007_FIELD5) //Date Field
WebUI.setText(findTestObject('Page_WMI_NEW/Reference_Object_Import/NewLinkModalDialog/input_Float Field (Precision3minval-10maxval-100)'), Consts.SMOKE_WMI007_FIELD6) //Float Field (Precision:3,minval-10,maxval-100)
WebUI.setText(findTestObject('Page_WMI_NEW/Reference_Object_Import/NewLinkModalDialog/input_Small Integer Field(minval-10maxval-100)'), Consts.SMOKE_WMI007_FIELD7) //Small Integer Field(minval-10,maxval-100)
WebUI.setText(findTestObject('Page_WMI_NEW/Reference_Object_Import/NewLinkModalDialog/input_Text Field(with onfocusselectall attribute)'), Consts.SMOKE_WMI007_FIELD8) //Text Field(with onfocusselectall attribute)
CustomKeywords.'actions.Common.setText_Date'(findTestObject('Page_WMI_NEW/Reference_Object_Import/NewLinkModalDialog/input_DateTime Field'), Consts.SMOKE_WMI007_FIELD9) //DateTime Field
WebUI.setText(findTestObject('Page_WMI_NEW/Reference_Object_Import/NewLinkModalDialog/input_String Filed'), Consts.SMOKE_WMI007_FIELD10) //String Filed
WebUI.setText(findTestObject('Page_WMI_NEW/Reference_Object_Import/NewLinkModalDialog/input_Ext Name Field'), Consts.SMOKE_WMI007_FIELD11) //Ext Name Field

'Click on Save button'
WebUI.click(findTestObject('Page_WMI_NEW/Reference_Object_Import/NewLinkModalDialog/span_Save'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_WMI_NEW/Reference_Object_Import/NewLinkModalDialog/iframe_eform'))

'Close modal dialog'
WebUI.click(findTestObject('Page_WMI_NEW/Reference_Object_Import/NewLinkModalDialog/modal dialog X icon'))

'Close window'
WebUI.closeWindowIndex(WebUI.getWindowIndex())

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
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'), 'Doc ID')
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'), 'Doc ID')

'Verify Column values for 1st Record in Grid.'
WebUI.verifyElementText(findTestObject('Page_nGage_Dashboard/Home/column_RecentDocuments DocumentType'), 'Render All Field Types')
WebUI.verifyElementText(findTestObject('Page_nGage_Dashboard/Home/column_RecentDocuments LastAction'), 'Created')

'Open Document'
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/column_RecentDocuments LastAction'))
WebUI.switchToWindowIndex(1)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Validate field values are same as created in document'
WebUI.verifyElementText(findTestObject('Page_WMI/Master_Object/span_WMI Title'), 'Business Model View - Render All Field Types') //WMI Title
WebUI.verifyElementText(findTestObject('Page_WMI/Master_Object/span_WMI Information'), 'This WMI imparts - Renders all basic type of single value fields') //WMI Information field
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI/Master_Object/input_Integer Field'), 'value', Consts.SMOKE_WMI007_FIELD1, GlobalVariable.G_LongTimeout)
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI/Master_Object/input_String Field (with onfocussetcursorattheend attribute)'), 'value', Consts.SMOKE_WMI007_FIELD2, GlobalVariable.G_LongTimeout)
WebUI.verifyOptionSelectedByLabel(findTestObject('Page_WMI/Master_Object/select_String Field With Lookup'), Consts.SMOKE_WMI007_FIELD3, false, GlobalVariable.G_LongTimeout)
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI/Master_Object/input_Currency Field'), 'value', Consts.SMOKE_WMI007_FIELD4V, GlobalVariable.G_LongTimeout)
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI/Master_Object/input_Date Field'), 'value', Consts.SMOKE_WMI007_FIELD5, GlobalVariable.G_LongTimeout)
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI/Master_Object/input_Float Field (Precision3minval-10maxval-100)'), 'value', Consts.SMOKE_WMI007_FIELD6, GlobalVariable.G_LongTimeout)
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI/Master_Object/input_Small Integer Field(minval-10maxval-100)'), 'value', Consts.SMOKE_WMI007_FIELD7, GlobalVariable.G_LongTimeout)
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI/Master_Object/input_Text Field(with onfocusselectall attribute)'), 'value', Consts.SMOKE_WMI007_FIELD8, GlobalVariable.G_LongTimeout)
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI/Master_Object/input_DateTime Field'), 'value', Consts.SMOKE_WMI007_FIELD9, GlobalVariable.G_LongTimeout)
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI/Master_Object/input_String Field'), 'value', Consts.SMOKE_WMI007_FIELD10, GlobalVariable.G_LongTimeout)
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI/Master_Object/input_Ext Name Field'), 'value', Consts.SMOKE_WMI007_FIELD11, GlobalVariable.G_LongTimeout)