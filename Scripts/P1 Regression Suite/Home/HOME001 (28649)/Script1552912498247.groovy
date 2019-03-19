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

import static utils.DateUtil.*
import static utils.Consts.*

String date1 = getCurrentDateTime(FORMAT_DATETIME, EST_TIMEZONE)

'Login into application'
CustomKeywords.'actions.Common.login'()

String date2 = getCurrentDateTime(FORMAT_DATETIME, EST_TIMEZONE)

'Login into application'
CustomKeywords.'actions.Common.login'()

'Click Tree Menu'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('HOME', 'Personalization')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/iframe_iframe_103'))

String actLastLoginDate = WebUI.getText(findTestObject('Page_nGage_Dashboard/Home/lbl_Last Login Date')).trim()
println "Actual Date = "+actLastLoginDate
println "From Date = "+date1
println "To Date = "+date2

'Verify correct date time is displayed'
CustomKeywords.'actions.Common.verifyDateFormat'(actLastLoginDate, FORMAT_DATETIME)
WebUI.verifyEqual(dateTimeFilter('between', actLastLoginDate, date1, date2), true)