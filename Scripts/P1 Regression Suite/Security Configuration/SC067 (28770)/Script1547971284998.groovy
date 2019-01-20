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
//Minimum length set is 10

'Generate random pasword to be set as new password'
String newPasswordWrong = "Abc#1"+RandomStringUtils.randomAlphabetic(2)

'Generate random pasword to be set as new password'
String newPassword = "Abcd#1"+RandomStringUtils.randomAlphabetic(3)

CustomKeywords.'actions.Common.changePasswordPageFormFill_Login'(username, currentPassword, newPasswordWrong, newPasswordWrong)

'Verify error message'
WebUI.verifyMatch(WebUI.getText(findTestObject('Page_ChangePassword/label_ErrorMessage2')).trim(), '.*Password must contain letter, digit and special character; start with letter or digit; be between 10 and 15 characters long..*', true)
