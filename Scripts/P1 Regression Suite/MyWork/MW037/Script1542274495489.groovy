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

'Click on My Work link from left menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_iframe_105'))

'Expand Closure Action process'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/icon_Expand_Closure Actions'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Select Activity A'
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/My_Work/a_Activity A'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_Activity A'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Store total no of records message in result table'
String expectedPagination = WebUI.getText(findTestObject('Page_nGage_Dashboard/My_Work/table_pagination_summary'))

'Open Search bar'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/h3_Search Bar'))

'Enter DocID value for search'
String _docID = '101756'
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/My_Work/search_DocID'), GlobalVariable.G_LongTimeout)
WebUI.setText(findTestObject('Page_nGage_Dashboard/My_Work/search_DocID'), _docID)

'Click on Search button'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/btn_Search'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Verify result in table'
WebUI.verifyElementText(findTestObject('Page_nGage_Dashboard/My_Work/table_pagination_summary'), 'Showing 1 - 1 of 1')

'Open Search bar'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/h3_Search Bar'))

'Click on Reset button'
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/My_Work/btn_Reset'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/btn_Reset'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Verify Result grid displys all the records'
WebUI.verifyElementText(findTestObject('Page_nGage_Dashboard/My_Work/table_pagination_summary'), expectedPagination)