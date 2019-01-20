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
String currentPassword = "Admin#1"+RandomStringUtils.randomAlphabetic(3)
CustomKeywords.'apis.UserManagement.updateUserManagement'(userId, currentPassword, null, null, 0, true, false)

'Generate random pasword to be set as new password'
String newPassword1 = "Admin#1"+RandomStringUtils.randomAlphabetic(3)

'Generate random pasword to be set as new password'
String newPassword2 = "Admin#2"+RandomStringUtils.randomAlphabetic(3)

'Login with User - {username}'
CustomKeywords.'actions.Common.login'(username, currentPassword, GlobalVariable.Database)

'Click on Change Password link under home menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/ChangePassword/menu_Change Password'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Home/ChangePassword/iframe_103'))

'Verify username in login name input field'
WebUI.verifyElementAttributeValue(findTestObject('Page_nGage_Dashboard/Home/ChangePassword/input_Login Name'), 'value', username, GlobalVariable.G_LongTimeout)

'Enter old password in input field'
WebUI.setText(findTestObject('Page_nGage_Dashboard/Home/ChangePassword/input_Old Password'), newPassword1)

'Enter new password in input field'
WebUI.setText(findTestObject('Page_nGage_Dashboard/Home/ChangePassword/input_New Password'), newPassword2)

'Enter new password in confirm password field'
WebUI.setText(findTestObject('Page_nGage_Dashboard/Home/ChangePassword/input_Confirm Password'), newPassword2)

'Click on Save button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/ChangePassword/button_Save'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Home/ChangePassword/iframe_103'))

'Verify error message'
WebUI.verifyElementText(findTestObject('Page_nGage_Dashboard/Home/ChangePassword/label_ErrorMessage'), 'The username and password entered do not match.')
