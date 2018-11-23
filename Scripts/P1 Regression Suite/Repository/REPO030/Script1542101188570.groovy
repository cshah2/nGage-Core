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

'Verify the Repository Menu is visible'
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/h3_Repository Menu'))

'Click on Repository Menu'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/h3_Repository Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Click and open Business Model tab '
WebUI.doubleClick(findTestObject('Page_nGage_Dashboard/Repository/Business_Model_Tree/EDM_BusinessModel'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Click to expand Sub_Menu Business Model'
WebUI.click(findTestObject('Page_nGage_Dashboard/Repository/Business_Model_Tree/EDM_BusinessModel_SubMenu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Click and open TopOneRowSC'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/Business_Model_Tree/EDM_TopOneRowSC'))

'Click and open Single Row SC'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/Business_Model_Tree/EDM_SingleRowSC'))

'Click on Closure EDM'
WebUI.doubleClick(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/Business_Model_Tree/EDM_Closure'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Click and open Closure submenu'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/Business_Model_Tree/EDM_Closure_SubMenu_Closure'))

'Click and open Closure not in user'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/Business_Model_Tree/EDM_SubMenu_ClosureNotInUse'))
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

'Click on Close tabs to right'
CustomKeywords.'actions.ContextMenu.clickOption'(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/contextMenu_Tabs'), 'Close tabs to right')

'Verify the tabs on right are closed'
WebUI.verifyElementNotPresent(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/Business_Model_Tree/Tab_TopOneRowSC'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementNotPresent(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/Business_Model_Tree/Tab_Business_Model'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementNotPresent(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/Business_Model_Tree/Tab_SingleRowSC'), GlobalVariable.G_LongTimeout)

'Verify the specific tab and tabs on left are not closed'
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/Business_Model_Tree/Tab_Closure'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/Business_Model_Tree/Tab_ClosureNotInUse'), GlobalVariable.G_LongTimeout)