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

//Login into application
CustomKeywords.'actions.Common.login'()

//Click on Global New button
WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))

//Select Document class and Document Type
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'('Reference Object Feature', 'Reference Object InlineNew')

//Click on OK Button
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))
WebUI.switchToWindowTitle('(Doc ID: NEW )')
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

//Verify Fields are displayed for Referenced Objects InlineNew
WebUI.waitForElementPresent(findTestObject('Page_WMI_NEW/Reference_Object_Inline/tab1_InlineNew'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Reference_Object_Inline/span_WMI Harness'))	//WMI Harness button
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Reference_Object_Inline/span_Close Window'))	//Close Window button
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Reference_Object_Inline/span_Save'))	//Save button
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Reference_Object_Inline/span_Delete'))	//Delete button
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Reference_Object_Inline/span_Information'))	//Information span
WebUI.verifyElementText(findTestObject('Page_WMI_NEW/Reference_Object_Inline/span_Information'), 'This WMI imparts Reference Object features for InlineNew')  //Verify Text for information span
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Reference_Object_Inline/tab1_InlineNew'))	//InlineNew Tab
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Reference_Object_Inline/tab2_InlineNew with drag-dro'))	//InlineNew with Drag-Drop functionality tab
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Reference_Object_Inline/tab3_NewDoc open in dialogue'))	//NewDoc open in Dialog with Drag-Drop functionality tab
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Reference_Object_Inline/tab4_InlineNew with required'))	//InlineNew with required content and Drag-Drop functionality tab
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Reference_Object_Inline/tab5_NewDoc open in dialogue'))	//NewDoc open in dialog with required content and drag-drop functionality tab
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Reference_Object_Inline/tab6_InlineNew with required'))	//InlineNew with required content and hidecontentupload=true tab
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Reference_Object_Inline/tab7_InlineNew with multiple'))	//InlineNew with multiple doctype list tab

//Click on New button
WebUI.click(findTestObject('Page_WMI_NEW/Reference_Object_Inline/button_tabInlineNew_New'))
WebUI.delay(10) //TODO: Need to identify correct wait condition
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_WMI_NEW/Reference_Object_Inline/iframe_ContentPlaceHolder1_iPa'))

//Verify NewDocument fields are loaded inline
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Reference_Object_Inline/button_InlineNew_Save'))	//Save button
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Reference_Object_Inline/button_InlineNew_Close'))	//Close button
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Reference_Object_Inline/span_InlineNew_Description'))	//Description
WebUI.verifyElementText(findTestObject('Page_WMI_NEW/Reference_Object_Inline/span_InlineNew_Description'), 'This WMI imparts - Renders all basic type of single value fields')	//Verify text for description
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Reference_Object_Inline/input_InlineNew_Integer Field'))	//Integer Field
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Reference_Object_Inline/input_InlineNew_String Field (with onfocussetcursorattheend attribute)'))	//String Field (with onfocussetcursorattheend attribute)
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Reference_Object_Inline/select_InlineView_String Field With Lookup'))	//String Field With Lookup
def options = ["Value 1", "Value 2", "Value 3", "Value 4", "Value 5"]
WebUI.verifyOptionsPresent(findTestObject('Page_WMI_NEW/Reference_Object_Inline/select_InlineView_String Field With Lookup'), options)
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Reference_Object_Inline/input_InlineView_Currency Field'))	//Currency Field
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Reference_Object_Inline/input_InlineView_Date Field'))	//Date Field
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Reference_Object_Inline/input_InlineView_Float Field (Precision3)'))	//Float Field (Precision:3)
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Reference_Object_Inline/input_InlineView_Small Integer Field'))	//Small Integer Field
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Reference_Object_Inline/input_InlineView_Text Field(with onfocusselectall attribute)'))	//Text Field(with onfocusselectall attribute)
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Reference_Object_Inline/input_InlineView_DateTime Field'))	//DateTime Field
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Reference_Object_Inline/input_InlineView_String Filed'))	//String Filed