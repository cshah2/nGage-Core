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

//Login Into Application
CustomKeywords.'actions.Common.login'()

//click on My Work Simplified

WebUI.click(findTestObject("Object Repository/Page_Savana nGage/MyWorkSimplified_Objects/a_My Work Simplified"))

// Wait for Pageload

WebUI.waitForPageLoad(60)
WebUI.verifyElementPresent(findTestObject("Object Repository/Page_Savana nGage/MyWorkSimplified_Objects/select_Auto Import Controlled"), 5)

//select/click on Auto-Import Activity from dropdown
WebUI.click(findTestObject("Object Repository/Page_Savana nGage/MyWorkSimplified_Objects/select_Auto Import Controlled"))

//select Activity A from dropdown

WebUI.selectOptionByValue(findTestObject("Object Repository/Page_Savana nGage/MyWorkSimplified_Objects/select_Auto Import Controlled"), '100027', false)
//close the browser

WebUI.closeBrowser()

















