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

'Click on Business Model in EDM'
WebUI.click(findTestObject('Page_nGage_Dashboard/Repository/Business_Model_Tree/EDM_BusinessModel'))

'Click on EDM to expand. select search class which has fields configured as folder'
WebUI.doubleClick(findTestObject('Page_nGage_Dashboard/Repository/Business_Model_Tree/EDM_BusinessModel'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Click to expand Sub_Menu Business Model'
WebUI.doubleClick(findTestObject('Page_nGage_Dashboard/Repository/Business_Model_Tree/EDM_BusinessModel_SubMenu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Right click on BM Ref ROTABLE Nested without Tab from Business Model Sub Menu'
WebUI.rightClick(findTestObject('Page_nGage_Dashboard/Repository/Business_Model_Tree/EDM_BM Ref ROTABLE Nested without Tab'))

'Click New Search button'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/EDM_NewSearch'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
WebUI.delay(2)

'Verify Search Panel page on right'
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_iframe_104'))

'Panel should be populated in search panel for the specific field.'
//CustomKeywords.'actions.Common.verifyElementAttributeValueContains'(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/searchBusinessModel_DocTypeName'), "BM Ref ROTABLE without Tab", "BM Ref ROTABLE without Tab")
WebUI.verifyElementAttributeValue(findTestObject('Page_nGage_Dashboard/Repository/NewSearch_WithoutTab/input_DocID_Filter'), 'value', 'BM Ref ROTABLE Nested without Tab', GlobalVariable.G_LongTimeout)