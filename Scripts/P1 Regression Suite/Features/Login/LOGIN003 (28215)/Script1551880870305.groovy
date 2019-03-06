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

'Navigate to login page'
CustomKeywords.'actions.Common.navigateToLoginPage'()

'Enter the Credentials'
WebUI.setText(findTestObject('Page_Login/input_UserName'), GlobalVariable.Username)
WebUI.selectOptionByValue(findTestObject("Page_Login/select_Schema"), GlobalVariable.Database, true)

'click on Forgot Password link'
WebUI.verifyElementVisible(findTestObject("Page_Login/link_Forgot Password"))
WebUI.click(findTestObject("Page_Login/link_Forgot Password"))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Verify Back to Login link is present' 
WebUI.verifyElementVisible(findTestObject("Object Repository/Page_Login/Back to Login link"))

'Verify Lost Password link is present'
WebUI.verifyElementVisible(findTestObject("Object Repository/Page_Login/Lost Password link"))

'Verify Submit button is present'
WebUI.verifyElementVisible(findTestObject("Object Repository/Page_Login/Submit button"))