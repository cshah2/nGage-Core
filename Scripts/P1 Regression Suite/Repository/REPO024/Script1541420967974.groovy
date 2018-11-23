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

'Expand Repository Menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/Repository/h3_Repository Menu'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

'Expand Business Model EDM'
WebUI.doubleClick(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/Business_Model_Tree/EDM_BusinessModel'))

'Expand Business Model SubMenu EDM'
WebUI.doubleClick(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/Business_Model_Tree/EDM_BusinessModel_SubMenu'))

'Get the count of BM Ref ROTABLE Nested without Tab from Business Model Sub Menu'
int beforeCountActivity = CustomKeywords.'actions.MenuBar.getRecordCountInActivity'(findTestObject('Page_nGage_Dashboard/Repository/Business_Model_Tree/EDM_BM Ref ROTABLE Nested without Tab'))

'Click on BM Ref ROTABLE Nested without Tab from Business Model Sub Menu'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/Business_Model_Tree/EDM_BM Ref ROTABLE Nested without Tab'))

'Wait for page to load'
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

'Verify the count of the field which is foldered showing the count for documents. '
CustomKeywords.'actions.Common.verifyRecordCountInActivityMatchesWithResultGrid'(findTestObject('Page_nGage_Dashboard/Repository/Business_Model_Tree/EDM_BM Ref ROTABLE Nested without Tab'), findTestObject('Object Repository/Page_nGage_Dashboard/Repository/BrowseResults Tab/Table_PageResults'))

'Right click on BM Ref ROTABLE Nested without Tab from Business Model Sub Menu'
WebUI.rightClick(findTestObject('Page_nGage_Dashboard/Repository/Business_Model_Tree/EDM_BM Ref ROTABLE Nested without Tab'))

'Click Refresh button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Repository/Business_Model_Tree/EDM_BM Ref ROTABLE Nested without Tab'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
int afterCountActivity = CustomKeywords.'actions.MenuBar.getRecordCountInActivity'(findTestObject('Page_nGage_Dashboard/Repository/Business_Model_Tree/EDM_BM Ref ROTABLE Nested without Tab'))

'Verify Before and After count'
WebUI.verifyEqual(beforeCountActivity, afterCountActivity)