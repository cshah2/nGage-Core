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

'Click Report User Listing'
CustomKeywords.'actions.Report.clickReport'('Administration', 'Security Management', 'User Listing')

'Click User Group Membership Report'
CustomKeywords.'actions.Report.clickReport'('Administration', 'Security Management', 'User Group Membership')

'Click on User Group Listing Report'
CustomKeywords.'actions.Report.clickReport'('Administration', 'Security Management', 'User Group Listing')

'Click on User Access to Document Classes Report'
CustomKeywords.'actions.Report.clickReport'('Administration', 'Security Management', 'User Access to Document Classes')

'Click on Audit of Standard Document Action Report'
CustomKeywords.'actions.Report.clickReport'('Administration', 'Security Management', 'Audit of Standard Document Action')

'Verify all tabs are open'
WebUI.verifyElementPresent(findTestObject('Page_nGage_Dashboard/Report/tab_User Listing'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementPresent(findTestObject('Page_nGage_Dashboard/Report/tab_User Group Membership'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementPresent(findTestObject('Page_nGage_Dashboard/Report/tab_User Group Listing'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementPresent(findTestObject('Page_nGage_Dashboard/Report/tab_User Access to Document Classes'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementPresent(findTestObject('Page_nGage_Dashboard/Report/tab_Audit of Standard Document Action'), GlobalVariable.G_LongTimeout)

'Right click on the tab'
WebUI.rightClick(findTestObject('Page_nGage_Dashboard/Report/tab_User Access to Document Classes'))

'Verify the list appears after right click'
CustomKeywords.'actions.ContextMenu.verifyAllOptions'(findTestObject('Page_nGage_Dashboard/Report/contextMenu_Tabs'), 'Close all', 'Close all except this', 'Close tabs to right', 'Close tabs to left')

'Click on close tabs to the left option'
CustomKeywords.'actions.ContextMenu.clickOption'(findTestObject('Page_nGage_Dashboard/Report/contextMenu_Tabs'), 'Close tabs to left')

'Verify all tabs on left of selected are closed'
WebUI.verifyElementNotPresent(findTestObject('Page_nGage_Dashboard/Report/tab_Audit of Standard Document Action'), GlobalVariable.G_LongTimeout)

'Verify all tabs on right of selected tab are still present'
WebUI.verifyElementPresent(findTestObject('Page_nGage_Dashboard/Report/tab_User Listing'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementPresent(findTestObject('Page_nGage_Dashboard/Report/tab_User Group Membership'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementPresent(findTestObject('Page_nGage_Dashboard/Report/tab_User Group Listing'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementPresent(findTestObject('Page_nGage_Dashboard/Report/tab_User Access to Document Classes'), GlobalVariable.G_LongTimeout)
