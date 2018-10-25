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

WebUI.openBrowser('')
WebUI.maximizeWindow()
WebUI.deleteAllCookies()
//open the url
WebUI.navigateToUrl(WebUI.concatenate(GlobalVariable.BaseURL, '/login.aspx'));
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)


//Enter the Credentials
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_Login/input_Login1UserName'), GlobalVariable.G_LongTimeout)
WebUI.setText(findTestObject('Object Repository/Page_Login/input_Login1UserName'), 'apatiln')
WebUI.selectOptionByValue(findTestObject("Object Repository/Page_Login/select_ALLIANCE_50CMDRDRC20160"), GlobalVariable.Database, true)

//click on Forgot Password link
WebUI.verifyElementVisible(findTestObject("Object Repository/Page_Login/Forgot Password Link"))
WebUI.click(findTestObject("Object Repository/Page_Login/Forgot Password Link"))
WebUI.waitForPageLoad(60)

//Verify Back to Login link is present
WebUI.verifyElementVisible(findTestObject("Object Repository/Page_Login/Back to Login link"))

//Verify Lost Password link is present
WebUI.verifyElementVisible(findTestObject("Object Repository/Page_Login/Lost Password link"))

//click on back to Login button

WebUI.verifyElementVisible(findTestObject("Object Repository/Page_Login/Back to Login link"))
WebUI.click(findTestObject("Object Repository/Page_Login/Back to Login link"))

//verify login page

WebUI.verifyElementVisible(findTestObject("Object Repository/Page_Login/input_Login1UserName"))

WebUI.closeBrowser()



