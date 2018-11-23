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
import utils.DateUtil

'Set Password for user account using Admin API'
String username = 'Auto_Test4'
int userId = CustomKeywords.'apis.Users.getUserIdFromUserName'(username)

'Set password for user'
String currentPassword = "Admin#1"+RandomStringUtils.randomAlphabetic(3)
CustomKeywords.'apis.UserManagement.updatePasswordForUser'(userId, currentPassword)

'Set Last login time as current date - 366 days'
//String loginDate = DateUtil.getCurrentDateTimeMinusDays(366)
//CustomKeywords.'apis.UserManagement.updateLastLoginDate'(userId, loginDate)

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

'Enter password'
WebUI.setText(findTestObject('Page_Login/input_Password'), currentPassword)

'Select Database'
WebUI.selectOptionByLabel(findTestObject('Page_Login/select_Schema'), GlobalVariable.Database, false)

'Click on Login'
WebUI.click(findTestObject('Page_Login/button_Login'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Verify error message'
WebUI.verifyElementText(findTestObject('Page_Login/label_ErrorMessage'), 'Account suspended due to inactivity. Please contact system administrator.')