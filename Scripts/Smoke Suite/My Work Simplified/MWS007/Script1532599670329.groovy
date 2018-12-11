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

//Click on "My Work Simplified" link
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/a_My Work Simplified'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/iframe_iframe_110'))

//Select Activity 'Closure Action - Activity A' from Drop down
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/select_Auto Import Controlled'), GlobalVariable.G_LongTimeout)
WebUI.selectOptionByLabel(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/select_Auto Import Controlled'), 'Closure Action - Activity A', false)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/iframe_iframe_110'))

//Open Search div
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/h3_Search'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/h3_Search'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/iframe_iframe_110'))

//Select DocID Filter operator as "In"
WebUI.selectOptionByLabel(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/select_Search_DocID_Operator'), 'In', false)

//Enter multiple DocID values to be searched - 101755,101756
String docId_Search = '101755,101756'
WebUI.setText(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/input_Search_DocID'), docId_Search)

//Click on Search button
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/input_Search_btnSearch'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/iframe_iframe_110'))

//Verify Result grid contains 2 record only
CustomKeywords.'actions.Table.verifyRecordsCount'(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/table_SearchResult'), 2)

//Click on Select All icon
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/input_Select_All_Checkbox'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/iframe_iframe_110'))

//Click on Open All Selected Items icon
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/div_Open_All_Selected_Items'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/iframe_iframe_110'))

//Switch to window 1 for DocID = 101756
CustomKeywords.'actions.Window.switchToUrlContains'('WORKFLOW101756')
WebUI.click(findTestObject('Page_WMI/Closure Action/span_Customer Information'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_WMI/Closure Action/iframe_ContentPlaceHolder1_iPa'))

//Verify Customer information in window 1 for DocID = 101756
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI/Closure Action/input_eform_Customer_Name'), 'value', 'Chintan Shah', GlobalVariable.G_LongTimeout)
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI/Closure Action/input_eform_Customer_Details'), 'value', 'Automation Tester - 101756', GlobalVariable.G_LongTimeout)

//Close window 1
WebUI.closeWindowIndex(WebUI.getWindowIndex())

//Switch to window 2 for DocID = 101755
CustomKeywords.'actions.Window.switchToUrlContains'('WORKFLOW101755')
WebUI.click(findTestObject('Page_WMI/Closure Action/span_Customer Information'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_WMI/Closure Action/iframe_ContentPlaceHolder1_iPa'))

//Verify Customer information in Window 2 for DocID = 101755
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI/Closure Action/input_eform_Customer_Name'), 'value', 'newuser', GlobalVariable.G_LongTimeout)
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI/Closure Action/input_eform_Customer_Details'), 'value', 'Automation Tester - 101755', GlobalVariable.G_LongTimeout)

//Close window 2
WebUI.closeWindowIndex(WebUI.getWindowIndex())