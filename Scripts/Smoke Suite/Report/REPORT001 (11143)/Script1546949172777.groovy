import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.lang.management.ManagementFactory

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

'Click on Report link from left menu'
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/Report/Reports Menu'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/Reports Menu'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Report/IFrame_108'))

'Click on Report Security Management - User Listing'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('REPORT', 'Administration', 'Security Management', 'User Listing')

'Wait For Report to load'
CustomKeywords.'actions.Common.waitForReportToLoad'(GlobalVariable.G_ReportTimeout)
WebUI.verifyElementVisible(findTestObject('Page_nGage_Dashboard/Report/User Listing/ToolBar_1'))
WebUI.verifyElementVisible(findTestObject('Page_nGage_Dashboard/Report/User Listing/ToolBar_2'))

'Click on Report Security Management - User Listing'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('REPORT', 'Administration', 'Security Management', 'Categories')

'Wait For Report to load'
CustomKeywords.'actions.Common.waitForReportToLoad'(GlobalVariable.G_ReportTimeout)
WebUI.verifyElementVisible(findTestObject('Page_nGage_Dashboard/Report/Categories/ToolBar_1'))
WebUI.verifyElementVisible(findTestObject('Page_nGage_Dashboard/Report/Categories/ToolBar_2'))