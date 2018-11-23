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

'Click on Render All Fields from BM Ref Rotable Demo'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/Business_Model_Tree/EDM_BM_ref_ROTABLE_Demo'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Open Browser tab'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/BrowseResults Tab/a_Browse Results'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/BrowseResults Tab/iframe_BROWSETAB_iframe'))

//int docTypeNameColumnNo_Before = CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/BrowseResults Tab/table_Header_SearchResults'), 'Doc Type Name')

'Drag column Doc Create Date over Account No User'
WebUI.dragAndDropToObject(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/BrowseResults Tab/columnHeader_DocTypeName'), findTestObject('Object Repository/Page_nGage_Dashboard/Repository/BrowseResults Tab/columnHeader_CurrentRevision'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/BrowseResults Tab/iframe_BROWSETAB_iframe'))

int currentRevisionColumnNo_After = CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/BrowseResults Tab/table_Header_SearchResults'), 'Current Revision #')

'Click Reset grid layout button'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/BrowseResults Tab/browseResult_ResetLayout'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/BrowseResults Tab/iframe_BROWSETAB_iframe'))
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/BrowseResults Tab/table_BrowseResultSearch_FirstRow'), GlobalVariable.G_LongTimeout)

int docTypeNameColumnNo_Before = CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/BrowseResults Tab/table_Header_SearchResults'), 'Doc Type Name')
