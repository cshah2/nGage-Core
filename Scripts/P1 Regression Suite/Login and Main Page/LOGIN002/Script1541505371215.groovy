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

'Open Browser'
WebUI.openBrowser('')

'Maximize window'
WebUI.maximizeWindow()

'Delet cookies'
WebUI.deleteAllCookies()

'Open URL'
WebUI.navigateToUrl(WebUI.concatenate(GlobalVariable.BaseURL, '/login.aspx'));

'Get Viewport width'
float viewPortWidth = WebUI.getViewportWidth()
println "Viewport Width = "+viewPortWidth

'get login box width'
float loginBoxWidth = WebUI.getElementWidth(findTestObject('Page_Login/Login_Box'))
println "LoginBox Width = "+loginBoxWidth

'get login box left margin'
float loginBoxLeftMargin = Float.parseFloat(WebUI.getCSSValue(findTestObject('Page_Login/Login_Box'), 'margin-left').replaceAll('px', '').trim())
println "Left margin = "+loginBoxLeftMargin

'get login box right margin'
float loginBoxRightMargin = Float.parseFloat(WebUI.getCSSValue(findTestObject('Page_Login/Login_Box'), 'margin-right').replaceAll('px', '').trim())
println "Right margin = "+loginBoxRightMargin

'Verify left margin and right margin value matches'
WebUI.verifyEqual(loginBoxLeftMargin, loginBoxRightMargin)

'Verify Element width including margin should equal to view port width'
WebUI.verifyEqual(loginBoxWidth+loginBoxLeftMargin+loginBoxRightMargin, viewPortWidth)

'Resize viewport'
WebUI.setViewPortSize(1024, 768)
WebUI.delay(2)

'Get Viewport width'
viewPortWidth = WebUI.getViewportWidth()
println "Viewport Width = "+viewPortWidth

'get login box width'
loginBoxWidth = WebUI.getElementWidth(findTestObject('Page_Login/Login_Box'))
println "LoginBox Width = "+loginBoxWidth

'get login box left margin'
loginBoxLeftMargin = Float.parseFloat(WebUI.getCSSValue(findTestObject('Page_Login/Login_Box'), 'margin-left').replaceAll('px', '').trim())
println "Left margin = "+loginBoxLeftMargin

'get login box right margin'
loginBoxRightMargin = Float.parseFloat(WebUI.getCSSValue(findTestObject('Page_Login/Login_Box'), 'margin-right').replaceAll('px', '').trim())
println "Right margin = "+loginBoxRightMargin

'Verify left margin and right margin value matches'
WebUI.verifyEqual(loginBoxLeftMargin, loginBoxRightMargin)

'Verify Element width including margin should equal to view port width'
WebUI.verifyEqual(loginBoxWidth+loginBoxLeftMargin+loginBoxRightMargin, viewPortWidth)