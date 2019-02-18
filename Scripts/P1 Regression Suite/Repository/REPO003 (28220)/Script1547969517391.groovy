import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.junit.After

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

'Login into application'
CustomKeywords.'actions.Common.login'()

'Verify the Repository Menu is visible'
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/h3_Repository Menu'))

'Click on Repository Menu'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/h3_Repository Menu'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Click Tree menu'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('REPO', 'Business Model', 'Business Model')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_iframe_104'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_visible'))

'Right click on Business Model repository'
CustomKeywords.'actions.MenuBar.rightClickTreeMenu'('REPO', 'Business Model', 'Business Model')
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Select option refresh from Context Menu'
CustomKeywords.'actions.ContextMenu.clickOption'(findTestObject('Page_nGage_Dashboard/contextMenuOptions'), 'Refresh')

'verify daisy(pre loader) status'
CustomKeywords.'actions.Common.verifyJQueryRunningStatus'(null, true)