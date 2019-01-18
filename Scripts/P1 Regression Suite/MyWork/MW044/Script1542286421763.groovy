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

//TODO: This test cases is marked as Yes, and there are no steps related to Runtime in Test case???

'Login Into Application'
CustomKeywords.'actions.Common.login'()

'Create Document - Correspondence Generation'
CustomKeywords.'actions.Common.createDocument_Correspondence'('Chintan', 'Shah', 'c.s@abc.com', 'Template1')

'Click on My Work link from left menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_iframe_105'))

'Expand Correspondence Generation process'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/icon_Expand_Correspondance Generation Process'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'click on correspondence activity'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/a_Correspondance Activity'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Open Search bar'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/h3_Search Bar'))

'Enter DocID(s) value for search'
WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/search_selectDDL DocID'), 'In', false)
String _docID = '107197,107163'
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/My_Work/search_DocID'), GlobalVariable.G_LongTimeout)
WebUI.setText(findTestObject('Page_nGage_Dashboard/My_Work/search_DocID'), _docID)

'Click on Search button'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/btn_Search'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

'verify result grid'
WebUI.verifyMatch(WebUI.getText(findTestObject('Page_nGage_Dashboard/My_Work/table_pagination_summary')),'Showing 1 - 2 of 2' , false)