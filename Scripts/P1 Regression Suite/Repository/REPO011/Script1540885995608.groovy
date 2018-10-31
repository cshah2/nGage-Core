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

//Login Into Application
CustomKeywords.'actions.Common.login'()

'Expand Repository Menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/Repository/h3_Repository Menu'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

'Select Repository - Advance Search tab'
WebUI.selectOptionByLabel(findTestObject('Page_nGage_Dashboard/Repository/select_Repository Drop Down'), 'Customers', false)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

'Selinput_btnSearchect Search For - Advance Search tab'
WebUI.selectOptionByLabel(findTestObject('Page_nGage_Dashboard/Repository/select_Search For Drop Down'), 'Customers', false)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

//Select DocID Filter operator as "In"
WebUI.selectOptionByLabel((findTestObject('Object Repository/Page_nGage_Dashboard/Repository/select_Search_DocID_Operator')), 'In', false)


'Enter multiple DocID values to be searched - 101755,101756'
String docId_Search = '101755,101756'
WebUI.setText((findTestObject('Object Repository/Page_nGage_Dashboard/Repository/input_Doc___ID')), docId_Search)

'Click on Search button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Repository/input_btnSearch'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/Repository/table_SearchResults'), GlobalVariable.G_LongTimeout)
//WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/Repository/table_AdvanceSearch_FirstRow'), GlobalVariable.G_LongTimeout)

'Verify Result grid contains 2 record only'
CustomKeywords.'actions.Table.verifyRecordsCount'(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/table_SearchResults'), 2)

//Click on Select All icon
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/input_Select_All_Checkbox'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

//Click on Open All Selected Items icon
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/div_Open_All_Selected_Items'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

//Switch to window 1 for DocID = EDM101756
CustomKeywords.'actions.Window.switchToUrlContains'('EDM101756')
WebUI.click(findTestObject('Page_WMI/Closure Action/span_Customer Information'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_WMI/Closure Action/iframe_ContentPlaceHolder1_iPa'))

//Verify Customer information in window 1 for DocID = 101756
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI/Closure Action/input_eform_Customer_Name'), 'value', 'Chintan Shah', GlobalVariable.G_LongTimeout)
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI/Closure Action/input_eform_Customer_Details'), 'value', 'Automation Tester - 101756', GlobalVariable.G_LongTimeout)

//Close window 1
WebUI.closeWindowIndex(WebUI.getWindowIndex())

//Switch to window 2 for DocID = EDM101755
CustomKeywords.'actions.Window.switchToUrlContains'('EDM101755')
WebUI.click(findTestObject('Page_WMI/Closure Action/span_Customer Information'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_WMI/Closure Action/iframe_ContentPlaceHolder1_iPa'))

//Verify Customer information in Window 2 for DocID = EDM101755
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI/Closure Action/input_eform_Customer_Name'), 'value', 'Amol Patil', GlobalVariable.G_LongTimeout)
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI/Closure Action/input_eform_Customer_Details'), 'value', 'Automation Tester - 101755', GlobalVariable.G_LongTimeout)

//Close window 2
WebUI.closeWindowIndex(WebUI.getWindowIndex())