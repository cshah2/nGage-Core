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
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Click BM Ref ROTABLE DEMO tree menu'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('REPO', 'Business Model', 'Business Model', 'BM Ref ROTABLE Demo')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/BrowseResults Tab/iframe_BROWSETAB_iframe'))

'Open Browser tab'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/BrowseResults Tab/a_Browse Results'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/BrowseResults Tab/iframe_BROWSETAB_iframe'))

'Click Reset grid layout button'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/BrowseResults Tab/browseResult_ResetLayout'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/BrowseResults Tab/iframe_BROWSETAB_iframe'))
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/BrowseResults Tab/table_BrowseResultSearch_FirstRow'), GlobalVariable.G_LongTimeout)

int docTypeNameColumnNo_Before = CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/BrowseResults Tab/table_Header_SearchResults'), 'Doc Type Name')

'Drag column Doc Create Date over Account No User'
WebUI.dragAndDropToObject(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/BrowseResults Tab/columnHeader_DocTypeName'), findTestObject('Object Repository/Page_nGage_Dashboard/Repository/BrowseResults Tab/columnHeader_CurrentRevision'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/BrowseResults Tab/iframe_BROWSETAB_iframe'))

int currentRevisionColumnNo_After = CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/BrowseResults Tab/table_Header_SearchResults'), 'Current Revision #')
WebUI.verifyEqual(docTypeNameColumnNo_Before, currentRevisionColumnNo_After)

'Click Set Layout option'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/BrowseResults Tab/browserResult_SetLayout'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/BrowseResults Tab/iframe_BROWSETAB_iframe'))

'Click on another EDM (Render All Field Types)'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('REPO', 'Business Model', 'Business Model', 'Render All Field Types')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/BrowseResults Tab/iframe_BROWSETAB_iframe'))

'Click BM Ref ROTABLE DEMO tree menu'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('REPO', 'Business Model', 'Business Model', 'BM Ref ROTABLE Demo')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/BrowseResults Tab/iframe_BROWSETAB_iframe'))

int docCreateDateColumnNo_After_1 = CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/BrowseResults Tab/table_Header_SearchResults'), 'Current Revision #')
WebUI.verifyEqual(docTypeNameColumnNo_Before, docCreateDateColumnNo_After_1)