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

'Login into application'
CustomKeywords.'actions.Common.login'()

'Click on Global New button'
WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))

'Select Document class and Document Type'
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'('Master Object Feature', 'Render All Field Types')

'Click on OK Button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))
WebUI.switchToWindowTitle('(Doc ID: NEW )')
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Validate all the fields are visible'
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Master_Object/span_WMI Harness'))	//WMI Harness button
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Master_Object/span_Close Window'))	//Close Window button
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Master_Object/span_Save'))	//Save button
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Master_Object/span_Delete'))	//Delete button
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Master_Object/input_Integer Field'))	//Integer field
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Master_Object/input_String Field (with onfocussetcursorattheend attribute)'))	//String Field (with onfocussetcursorattheend attribute)
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Master_Object/select_String Field With Lookup'))	//String Field With Lookup
def options = ["Value 1", "Value 2", "Value 3", "Value 4", "Value 5"]
WebUI.verifyOptionsPresent(findTestObject('Page_WMI_NEW/Master_Object/select_String Field With Lookup'), options)
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Master_Object/input_Currency Field'))	//Currency Field
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Master_Object/input_Float Field (Precision3minval-10maxval-100)'))	//Float Field (Precision:3,minval-10,maxval-100)
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Master_Object/input_Small Integer Field(minval-10maxval-100)'))	//Small Integer Field(minval-10,maxval-100)
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Master_Object/input_Text Field(with onfocusselectall attribute)'))	//Text Field(with onfocusselectall attribute)
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Master_Object/input_DateTime Field'))	//DateTime Field
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Master_Object/input_String Filed'))	//String Filed
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Master_Object/input_Ext Name Field'))	//Ext Name Field