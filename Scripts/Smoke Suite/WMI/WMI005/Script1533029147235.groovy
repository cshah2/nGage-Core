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
import utils.DateUtil

//Login into application
CustomKeywords.'actions.Common.login'()

//Click on Global New button
WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))

//Select Document class and Document Type
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'('Reference Object Feature', 'Reference Object Import')

//Click on OK Button
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))
WebUI.switchToWindowTitle('(Doc ID: NEW )')
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

//Verify WMI Section title
WebUI.verifyElementText(findTestObject('Page_WMI_NEW/Reference_Object_Import/span_WMI_Title'), 'Business Model View - Reference Object Import')

//Verify WMI Information text
WebUI.verifyElementText(findTestObject('Page_WMI_NEW/Reference_Object_Import/span_WMI_Infomation'), 'This WMI imparts Reference Object Import feature')

//Click on New Link(Default) tab
WebUI.click(findTestObject('Page_WMI_NEW/Reference_Object_Import/tab_New link(Default)'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_WMI_NEW/Reference_Object_Import/iframe_ContentPlaceHolder1_iPa'))

//Verify Title under tab New Link(Default)
WebUI.verifyElementText(findTestObject('Page_WMI_NEW/Reference_Object_Import/span_New link(Default) title'), 'New link(Default)')

//Click on New button
WebUI.click(findTestObject('Page_WMI_NEW/Reference_Object_Import/button_New link(Default) NEW'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_WMI_NEW/Reference_Object_Import/NewLinkModalDialog/iframe_ContentPlaceHolder_Inner'))

//Validate title of WMI opened as modal dialog
WebUI.verifyElementText(findTestObject('Page_WMI_NEW/Reference_Object_Import/NewLinkModalDialog/modal dialog title'), 'Create New Item')

//Validate Business modal view - render all field types WMI is opened
WebUI.waitForElementPresent(findTestObject('Page_WMI_NEW/Reference_Object_Import/NewLinkModalDialog/modal dialog WMI Title'), GlobalVariable.G_LongTimeout)
WebUI.waitForElementVisible(findTestObject('Page_WMI_NEW/Reference_Object_Import/NewLinkModalDialog/modal dialog WMI Title'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementText(findTestObject('Page_WMI_NEW/Reference_Object_Import/NewLinkModalDialog/modal dialog WMI Title'), 'Business Model View - Render All Field Types')

//Set DateTime value as current date time
String _format = 'MM-dd-yyyy hh:mm:ss a'
GlobalVariable.WMI005['Field9'] = DateUtil.getCurrentDateTime(_format)

//Enter data in all fields in open modal dialog
WebUI.waitForElementVisible(findTestObject('Page_WMI_NEW/Reference_Object_Import/NewLinkModalDialog/input_Integer field'), GlobalVariable.G_LongTimeout)
WebUI.setText(findTestObject('Page_WMI_NEW/Reference_Object_Import/NewLinkModalDialog/input_Integer field'), GlobalVariable.WMI005['Field1']) //Integer Field
WebUI.setText(findTestObject('Page_WMI_NEW/Reference_Object_Import/NewLinkModalDialog/input_String Field (with onfocussetcursorattheend attribute)'), GlobalVariable.WMI005['Field2']) //String Field (with onfocussetcursorattheend attribute)
WebUI.selectOptionByLabel(findTestObject('Page_WMI_NEW/Reference_Object_Import/NewLinkModalDialog/input_String Field With Lookup'), GlobalVariable.WMI005['Field3'], false) //String Field With Lookup
WebUI.setText(findTestObject('Page_WMI_NEW/Reference_Object_Import/NewLinkModalDialog/input_Currency Field'), GlobalVariable.WMI005['Field4']) //Currency Field
WebUI.setText(findTestObject('Page_WMI_NEW/Reference_Object_Import/NewLinkModalDialog/input_Date Field'), GlobalVariable.WMI005['Field5']) //Date Field
WebUI.setText(findTestObject('Page_WMI_NEW/Reference_Object_Import/NewLinkModalDialog/input_Float Field (Precision3minval-10maxval-100)'), GlobalVariable.WMI005['Field6']) //Float Field (Precision:3,minval-10,maxval-100)
WebUI.setText(findTestObject('Page_WMI_NEW/Reference_Object_Import/NewLinkModalDialog/input_Small Integer Field(minval-10maxval-100)'), GlobalVariable.WMI005['Field7']) //Small Integer Field(minval-10,maxval-100)
WebUI.setText(findTestObject('Page_WMI_NEW/Reference_Object_Import/NewLinkModalDialog/input_Text Field(with onfocusselectall attribute)'), GlobalVariable.WMI005['Field8']) //Text Field(with onfocusselectall attribute)
WebUI.setText(findTestObject('Page_WMI_NEW/Reference_Object_Import/NewLinkModalDialog/input_DateTime Field'),GlobalVariable.WMI005['Field9']) //DateTime Field
WebUI.setText(findTestObject('Page_WMI_NEW/Reference_Object_Import/NewLinkModalDialog/input_String Filed'), GlobalVariable.WMI005['Field10']) //String Filed
WebUI.setText(findTestObject('Page_WMI_NEW/Reference_Object_Import/NewLinkModalDialog/input_Ext Name Field'), GlobalVariable.WMI005['Field11']) //Ext Name Field

//Click on Save button
WebUI.click(findTestObject('Page_WMI_NEW/Reference_Object_Import/NewLinkModalDialog/span_Save'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_WMI_NEW/Reference_Object_Import/NewLinkModalDialog/iframe_eform'))

//Close modal dialog
WebUI.click(findTestObject('Page_WMI_NEW/Reference_Object_Import/NewLinkModalDialog/modal dialog X icon'))

//Close window
WebUI.closeWindowIndex(WebUI.getWindowIndex())

//Close "create new" popup dialog
WebUI.switchToWindowTitle('Savana nGage')
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/span_ui-button-icon-primary ui'))

//Go to Recent Documents tab
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/a_Recent Documents'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/iframe_iframe_103'))

//Validate atleast 1 record is present in the grid.
WebUI.verifyElementPresent(findTestObject('Page_nGage_Dashboard/Home/tableRow_recentDocuments_firstRow'), GlobalVariable.G_LongTimeout);

//Verify Column values for 1st Record in Grid.
String _expectedDocTitle = 'Master Object Feature  -  '+GlobalVariable.WMI005['Field9'].toString().substring(0, 10).replace('-', '/')
WebUI.verifyElementText(findTestObject('Page_nGage_Dashboard/Home/column_RecentDocuments DocumentTitle'), _expectedDocTitle)
WebUI.verifyElementText(findTestObject('Page_nGage_Dashboard/Home/column_RecentDocuments DocumentType'), 'Render All Field Types')
WebUI.verifyElementText(findTestObject('Page_nGage_Dashboard/Home/column_RecentDocuments LastAction'), 'Created')

//Open Document
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/column_RecentDocuments LastAction'))
WebUI.switchToWindowIndex(1)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

//Validate field values are same as created in document
WebUI.verifyElementText(findTestObject('Page_WMI/Master_Object/span_WMI Title'), 'Business Model View - Render All Field Types') //WMI Title
WebUI.verifyElementText(findTestObject('Page_WMI/Master_Object/span_WMI Information'), 'This WMI imparts - Renders all basic type of single value fields') //WMI Information field
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI/Master_Object/input_Integer Field'), 'value', GlobalVariable.WMI005['Field1'], GlobalVariable.G_LongTimeout)
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI/Master_Object/input_String Field (with onfocussetcursorattheend attribute)'), 'value', GlobalVariable.WMI005['Field2'], GlobalVariable.G_LongTimeout)
WebUI.verifyOptionSelectedByLabel(findTestObject('Page_WMI/Master_Object/select_String Field With Lookup'), GlobalVariable.WMI005['Field3'], false, GlobalVariable.G_LongTimeout)
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI/Master_Object/input_Currency Field'), 'value', GlobalVariable.WMI005['Field4_View'], GlobalVariable.G_LongTimeout)
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI/Master_Object/input_Date Field'), 'value', GlobalVariable.WMI005['Field5'], GlobalVariable.G_LongTimeout)
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI/Master_Object/input_Float Field (Precision3minval-10maxval-100)'), 'value', GlobalVariable.WMI005['Field6'], GlobalVariable.G_LongTimeout)
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI/Master_Object/input_Small Integer Field(minval-10maxval-100)'), 'value', GlobalVariable.WMI005['Field7'], GlobalVariable.G_LongTimeout)
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI/Master_Object/input_Text Field(with onfocusselectall attribute)'), 'value', GlobalVariable.WMI005['Field8'], GlobalVariable.G_LongTimeout)
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI/Master_Object/input_DateTime Field'), 'value', GlobalVariable.WMI005['Field9'], GlobalVariable.G_LongTimeout)
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI/Master_Object/input_String Field'), 'value', GlobalVariable.WMI005['Field10'], GlobalVariable.G_LongTimeout)
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI/Master_Object/input_Ext Name Field'), 'value', GlobalVariable.WMI005['Field11'], GlobalVariable.G_LongTimeout)