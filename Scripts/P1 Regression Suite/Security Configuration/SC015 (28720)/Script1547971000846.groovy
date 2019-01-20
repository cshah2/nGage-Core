import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.apache.commons.lang3.RandomStringUtils

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

'Get User ID using username'
String username = 'CNF1_USERA'
int userId = CustomKeywords.'apis.Users.getUserIdFromUserName'(username)

'Update password for user'
String currentPassword = "A#1"+RandomStringUtils.randomAlphabetic(3)
CustomKeywords.'apis.UserManagement.updateUserManagement'(userId, currentPassword, null, null, 0, true, false)

'Open Browser'
WebUI.openBrowser('')

'Maximize window'
WebUI.maximizeWindow()

'Delet all cookies'
WebUI.deleteAllCookies()

'Navigate to login page'
WebUI.navigateToUrl(WebUI.concatenate(GlobalVariable.BaseURL, '/login.aspx'));
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
WebUI.waitForElementVisible(findTestObject('Page_Login/input_UserName'), GlobalVariable.G_LongTimeout)

'Enter username'
WebUI.setText(findTestObject('Page_Login/input_UserName'), username)

'Select Database'
WebUI.selectOptionByLabel(findTestObject('Page_Login/select_Schema'), GlobalVariable.Database, false)

'Click on Forgot password link'
WebUI.click(findTestObject('Page_Login/link_Forgot Password'))

'Verify title on the page'
WebUI.verifyElementText(findTestObject('Page_ForgotPassword/label_Title'), 'Lost Password?')

'Click on Submit button'
WebUI.click(findTestObject('Page_ForgotPassword/button_Submit'))

'Verify message'
//TODO: This issue needs to be clarified as Message displayed to user is Success instead of Error