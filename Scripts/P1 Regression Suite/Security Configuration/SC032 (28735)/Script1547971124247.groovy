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

'Get User ID for user'
String username = 'CNF1_USERE'
int userId = CustomKeywords.'apis.Users.getUserIdFromUserName'(username)

'Unlock user account is already locked'
CustomKeywords.'apis.Users.unlockUserAccount'(userId)

'Update password for user'
String currentPassword = "A#1"+RandomStringUtils.randomAlphabetic(3)
CustomKeywords.'apis.UserManagement.updateUserManagement'(userId, currentPassword, null, null, 0, true, false)


String invalidPassword = "Iv@123"

'Provide invalid credential while login - Attempt 1'
CustomKeywords.'actions.Common.login'(username, invalidPassword, GlobalVariable.Database)

'Verify error message is Present'
WebUI.verifyElementVisible(findTestObject('Page_Login/label_ErrorMessage'))

'Provide invalid credential while login - Attempt 2'
CustomKeywords.'actions.Common.login'(username, invalidPassword, GlobalVariable.Database)

'Verify error message is Present'
WebUI.verifyElementVisible(findTestObject('Page_Login/label_ErrorMessage'))

'Provide invalid credential while login - Attempt 3'
CustomKeywords.'actions.Common.login'(username, invalidPassword, GlobalVariable.Database)

'Verify error message is Present'
WebUI.verifyElementVisible(findTestObject('Page_Login/label_ErrorMessage'))

'Provide invalid credential while login - Attempt 4'
CustomKeywords.'actions.Common.login'(username, invalidPassword, GlobalVariable.Database)

'Verify error message is Present'
WebUI.verifyElementVisible(findTestObject('Page_Login/label_ErrorMessage'))
WebUI.delay(2)

'Verify user account is locked'
CustomKeywords.'apis.Users.verifyIsUserAccountLocked'(userId)

'Verify error message when user enters valid password - Attempt 5'
CustomKeywords.'actions.Common.login'(username, currentPassword, GlobalVariable.Database)

'Verify error message'
WebUI.verifyElementVisible(findTestObject('Page_Login/label_ErrorMessage'))
WebUI.verifyMatch(WebUI.getText(findTestObject('Page_Login/label_ErrorMessage')).trim(), '.*This session has been locked because of too many failed login attempts. Please contact your system administrator..*', true)