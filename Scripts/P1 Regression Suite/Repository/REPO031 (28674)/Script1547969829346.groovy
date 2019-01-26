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

'Click on Repository Menu'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/h3_Repository Menu'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Click and open Business Model'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('REPO', 'Business Model', 'Business Model')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/iframe_iframe_104'))

'Click and open TopOneRowSC'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('REPO', 'Business Model', 'TopOneRowSC')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/iframe_iframe_104'))

'Click and open Single Row SC'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('REPO', 'Business Model', 'SingleRowSC')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/iframe_iframe_104'))

'Click and open Closure'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('REPO', 'Closure', 'Closure')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/iframe_iframe_104'))

'Click and open Closure not in use'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('REPO', 'Closure', 'Closure not in use')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/iframe_iframe_104'))

'Verify all tabs are open'
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/Business_Model_Tree/Tab_TopOneRowSC'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/Business_Model_Tree/Tab_Business_Model'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/Business_Model_Tree/Tab_Closure'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/Business_Model_Tree/Tab_ClosureNotInUse'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/Business_Model_Tree/Tab_SingleRowSC'), GlobalVariable.G_LongTimeout)

'Right click on tab'
WebUI.rightClick(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/Business_Model_Tree/Tab_Closure'))

'Verify the list appears after right click'
CustomKeywords.'actions.ContextMenu.verifyAllOptions'(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/contextMenu_Tabs'), 'Close all', 'Close all except this', 'Close tabs to right', 'Close tabs to left')

'Click on Close tabs to left'
CustomKeywords.'actions.ContextMenu.clickOption'(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/contextMenu_Tabs'), 'Close tabs to left')

'Verify the tabs on left are closed'
WebUI.verifyElementNotPresent(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/Business_Model_Tree/Tab_ClosureNotInUse'), GlobalVariable.G_LongTimeout)

'Verify the specific tab and tabs on right are not closed'
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/Business_Model_Tree/Tab_TopOneRowSC'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/Business_Model_Tree/Tab_Business_Model'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/Business_Model_Tree/Tab_Closure'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/Business_Model_Tree/Tab_SingleRowSC'), GlobalVariable.G_LongTimeout)