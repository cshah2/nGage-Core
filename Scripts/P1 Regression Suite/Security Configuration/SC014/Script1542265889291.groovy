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
String username = 'CNF1_USERC'
int userId = CustomKeywords.'apis.Users.getUserIdFromUserName'(username)
String oldPassword = "A#1"+RandomStringUtils.randomAlphabetic(3)
CustomKeywords.'apis.UserManagement.updatePasswordForUser'(userId, oldPassword)

'Generate random pasword to be set as new password'
String newPassword = "A#1"+RandomStringUtils.randomAlphabetic(3)

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

'Click on change password link'
WebUI.click(findTestObject('Page_Login/link_Change Password'))

'Verify login name field retains input value'
WebUI.verifyElementAttributeValue(findTestObject('Page_ChangePassword/input_Login ID'), 'value', username, GlobalVariable.G_LongTimeout)

'Enter old password value'
WebUI.setText(findTestObject('Page_ChangePassword/input_Old Password'), oldPassword)

'Enter new password value'
WebUI.setText(findTestObject('Page_ChangePassword/input_New Password'), newPassword)

'Enter confirm new password value'
WebUI.setText(findTestObject('Page_ChangePassword/input_Confirm Password'), newPassword)

'Click on change password button'
WebUI.click(findTestObject('Page_ChangePassword/btn_Change_Password'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Verify error message'
WebUI.verifyMatch(WebUI.getText(findTestObject('Page_ChangePassword/label_ErrorMessage')).trim(), 'The username and password entered do not match.', false)