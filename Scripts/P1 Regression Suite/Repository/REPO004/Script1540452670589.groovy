import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.junit.After

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

'Login into application'
CustomKeywords.'actions.Common.login'()

'Verify the Repository Menu is visible'
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/h3_Repository Menu'))

'Click on Repository Menu'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/h3_Repository Menu'))

'Click on Cutomer in EDM'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/EDM_Customer'))

'Click on EDM to expand. select search class which has fields configured as folder'
WebUI.doubleClick(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/EDM_Customer'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Click on field in EDM list'
WebUI.doubleClick(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/EDM-Customer_SubItem'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

WebUI.click(findTestObject('Page_nGage_Dashboard/Repository/EDM_Customer_SubMenu_100019'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/BrowseResults Tab/iframe_BROWSETAB_iframe'))

'Verify 10 Records are present in table'
CustomKeywords.'actions.Table.verifyRecordsCount'(findTestObject('Page_nGage_Dashboard/Repository/BrowseResults Tab/Table_ResultGrid'), 10)

'Verify the Search result grid '
WebUI.verifyElementText(findTestObject('Page_nGage_Dashboard/Repository/BrowseResults Tab/Table_PageResults'), "Showing 1 - 10 of 14")

