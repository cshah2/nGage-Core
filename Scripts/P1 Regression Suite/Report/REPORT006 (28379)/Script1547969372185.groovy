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

'Login into application'
CustomKeywords.'actions.Common.login'()

'Open Reports Menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/Reports Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Report/IFrame_108'))

'Expand Security Management section'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/Expand_Security Management'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Click Report User Listing'
CustomKeywords.'actions.Report.clickReport'('Administration', 'Security Management', 'User Listing')

'Verify Report is loaded'
WebUI.verifyElementVisible(findTestObject('Page_nGage_Dashboard/Report/User Listing/ToolBar_1'))
WebUI.verifyElementVisible(findTestObject('Page_nGage_Dashboard/Report/User Listing/ToolBar_2'))
WebUI.verifyElementVisible(findTestObject('Page_nGage_Dashboard/Report/User Listing/Design Button'))

'Verify Report Title'
WebUI.verifyElementText(findTestObject('Page_nGage_Dashboard/Report/User Listing/ReportTitle'), 'User Listing')

'Verify Report Description'
WebUI.verifyElementText(findTestObject('Page_nGage_Dashboard/Report/User Listing/ReportDescription'), 'User Listing Details')

'Verify Report Table is present'
WebUI.verifyElementVisible(findTestObject('Page_nGage_Dashboard/Report/User Listing/ReportTable'))