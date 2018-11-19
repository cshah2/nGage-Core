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

'Set Password for user account using Admin API'
String username = 'CNF1_USERA'
int userId = CustomKeywords.'apis.Users.getUserIdFromUserName'(username)
String oldPassword = "A#1"+RandomStringUtils.randomAlphabetic(3)
CustomKeywords.'apis.UserManagement.updatePasswordForUser'(userId, oldPassword)

'Generate random simple password'
String simplePassword = "abc"+RandomStringUtils.randomAlphabetic(3)

'Generate random String pasword to be set as new password'
String strongPassword = "A#1"+RandomStringUtils.randomAlphabetic(3)

'Login with User - {username}'
CustomKeywords.'actions.Common.login'(username, oldPassword, GlobalVariable.Database)

'Click on Change Password link under home menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/ChangePassword/menu_Change Password'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Home/ChangePassword/iframe_103'))

'Verify username in login name input field'
WebUI.verifyElementAttributeValue(findTestObject('Page_nGage_Dashboard/Home/ChangePassword/input_Login Name'), 'value', username, GlobalVariable.G_LongTimeout)

'Enter old password in input field'
WebUI.setText(findTestObject('Page_nGage_Dashboard/Home/ChangePassword/input_Old Password'), oldPassword)

'Enter new password in input field'
WebUI.setText(findTestObject('Page_nGage_Dashboard/Home/ChangePassword/input_New Password'), simplePassword)

'Enter new password in confirm password field'
WebUI.setText(findTestObject('Page_nGage_Dashboard/Home/ChangePassword/input_Confirm Password'), simplePassword)

'Click on Save button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/ChangePassword/button_Save'))

'Verify Error messsage'
WebUI.verifyElementText(findTestObject('Page_nGage_Dashboard/Home/ChangePassword/label_ErrorMessage'), 'Password must contain letter, digit and special character; be between 3 and 6 characters long.')

'Enter old password in input field'
WebUI.setText(findTestObject('Page_nGage_Dashboard/Home/ChangePassword/input_Old Password'), oldPassword)

'Enter new password in input field'
WebUI.setText(findTestObject('Page_nGage_Dashboard/Home/ChangePassword/input_New Password'), strongPassword)

'Enter new password in confirm password field'
WebUI.setText(findTestObject('Page_nGage_Dashboard/Home/ChangePassword/input_Confirm Password'), strongPassword)

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

'Enter username'
WebUI.setText(findTestObject('Page_Login/input_UserName'), username)

'Enter password'
WebUI.setText(findTestObject('Page_Login/input_Password'), strongPassword)

'Select database'
WebUI.selectOptionByLabel(findTestObject('Page_Login/select_Schema'), GlobalVariable.Database, false)

'Click on Login button'
WebUI.click(findTestObject('Page_Login/button_Login'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Verify user is redirected to dashboard page'
actualUrl = WebUI.getUrl().trim()
expectedUrl = GlobalVariable.BaseURL+'/main.aspx'
WebUI.verifyEqual(actualUrl, expectedUrl)
WebUI.verifyElementVisible(findTestObject('Page_nGage_Dashboard/input_btnLogout'))