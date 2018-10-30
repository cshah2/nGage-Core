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

'Login into application'
CustomKeywords.'actions.Common.login'()

'Open Reports Menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/Reports Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Report/IFrame_108'))

'Expand Security Management section'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/Expand_Security Management'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Perform Right click over User Listing Report'
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/Report/Report_User Listing'), GlobalVariable.G_LongTimeout)
WebUI.rightClick(findTestObject('Page_nGage_Dashboard/Report/Report_User Listing'))

'Verify Following options are available in right-click'
CustomKeywords.'actions.ContextMenu.verifyAllOptions'('Rename', 'Copy', 'Delete', 'Schedule')

'Click Schedule option from ContextMenu'
CustomKeywords.'actions.ContextMenu.clickOption'('Schedule')
WebUI.delay(10)