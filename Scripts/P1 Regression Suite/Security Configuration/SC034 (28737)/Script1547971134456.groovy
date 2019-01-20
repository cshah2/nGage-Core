import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.apache.commons.lang.RandomStringUtils

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

'Get User ID for user'
String username = 'CNF2_USERB'
int userId = CustomKeywords.'apis.Users.getUserIdFromUserName'(username)

'Set password 1 for user'
String password1 = "A#1"+RandomStringUtils.randomAlphabetic(12)
CustomKeywords.'apis.UserManagement.updateUserManagement'(userId, password1, null, null, 0, false, false)

'Set password 2 for user'
String password2 = "A#1"+RandomStringUtils.randomAlphabetic(12)
CustomKeywords.'apis.UserManagement.updateUserManagement'(userId, password2, null, null, 0, false, false)

'Login with User - {username}'
CustomKeywords.'actions.Common.login'(username, password2, GlobalVariable.Database)

'Click on Change Password link under home menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/ChangePassword/menu_Change Password'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Home/ChangePassword/iframe_103'))

'Verify username in login name input field'
WebUI.verifyElementAttributeValue(findTestObject('Page_nGage_Dashboard/Home/ChangePassword/input_Login Name'), 'value', username, GlobalVariable.G_LongTimeout)

'Enter old password in input field'
WebUI.setText(findTestObject('Page_nGage_Dashboard/Home/ChangePassword/input_Old Password'), password2)

'Enter new password in input field'
WebUI.setText(findTestObject('Page_nGage_Dashboard/Home/ChangePassword/input_New Password'), password1)

'Enter new password in confirm password field'
WebUI.setText(findTestObject('Page_nGage_Dashboard/Home/ChangePassword/input_Confirm Password'), password1)

'Click on Save button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/ChangePassword/button_Save'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Home/ChangePassword/iframe_103'))

'Verify Success message'
WebUI.verifyElementText(findTestObject('Page_nGage_Dashboard/Home/ChangePassword/dialog_label_SuccessMessage'), 'Password changed. Please Re-Login')

'Click on OK button on dialog'
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/ChangePassword/dialog_button_Ok'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Verify user is now redirected to login page'
String actualUrl = WebUI.getUrl().trim()
String expectedUrl = GlobalVariable.BaseURL+'/login.aspx'
WebUI.verifyEqual(actualUrl, expectedUrl)

'Login with User - {username} and password1'
CustomKeywords.'actions.Common.login'(username, password1, GlobalVariable.Database)

'Verify user is redirected to dashboard page'
actualUrl = WebUI.getUrl().trim()
expectedUrl = GlobalVariable.BaseURL+'/main.aspx'
WebUI.verifyEqual(actualUrl, expectedUrl)
WebUI.verifyElementVisible(findTestObject('Page_nGage_Dashboard/input_btnLogout'))