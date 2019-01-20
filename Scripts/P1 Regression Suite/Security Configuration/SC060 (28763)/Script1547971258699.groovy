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
String username = 'CNF2_USERA'
int userId = CustomKeywords.'apis.Users.getUserIdFromUserName'(username)

'Update password for user'
String currentPassword = "A#1"+RandomStringUtils.randomAlphabetic(12)
CustomKeywords.'apis.UserManagement.updateUserManagement'(userId, currentPassword, null, null, 0, true, false)

'password 1 for user'
String password1 = "A#1"+RandomStringUtils.randomAlphabetic(12)

'password 2 for user'
String password2 = "A#1"+RandomStringUtils.randomAlphabetic(12)

'password 3 for user'
String password3 = "A#1"+RandomStringUtils.randomAlphabetic(12)

'password 4 for user'
String password4 = "A#1"+RandomStringUtils.randomAlphabetic(12)

'Change password'
CustomKeywords.'actions.Common.changePasswordPageFormFill_Login'(username, currentPassword, password1, password1)

'Verify user is redirected to dashboard page'
String actualUrl = WebUI.getUrl().trim()
String expectedUrl = GlobalVariable.BaseURL+'/main.aspx'
WebUI.verifyEqual(actualUrl, expectedUrl)
WebUI.verifyElementVisible(findTestObject('Page_nGage_Dashboard/input_btnLogout'))

'Change password'
CustomKeywords.'actions.Common.changePasswordPageFormFill_Login'(username, password1, password2, password2)

'Verify user is redirected to dashboard page'
actualUrl = WebUI.getUrl().trim()
expectedUrl = GlobalVariable.BaseURL+'/main.aspx'
WebUI.verifyEqual(actualUrl, expectedUrl)
WebUI.verifyElementVisible(findTestObject('Page_nGage_Dashboard/input_btnLogout'))

'Change password'
CustomKeywords.'actions.Common.changePasswordPageFormFill_Login'(username, password2, password3, password3)

'Verify user is redirected to dashboard page'
actualUrl = WebUI.getUrl().trim()
expectedUrl = GlobalVariable.BaseURL+'/main.aspx'
WebUI.verifyEqual(actualUrl, expectedUrl)
WebUI.verifyElementVisible(findTestObject('Page_nGage_Dashboard/input_btnLogout'))

'Change password'
CustomKeywords.'actions.Common.changePasswordPageFormFill_Login'(username, password3, password4, password4)

'Verify user is redirected to dashboard page'
actualUrl = WebUI.getUrl().trim()
expectedUrl = GlobalVariable.BaseURL+'/main.aspx'
WebUI.verifyEqual(actualUrl, expectedUrl)
WebUI.verifyElementVisible(findTestObject('Page_nGage_Dashboard/input_btnLogout'))

