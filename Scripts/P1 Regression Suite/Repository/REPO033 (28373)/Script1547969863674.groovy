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

'Login Into Application'
CustomKeywords.'actions.Common.login'()

'Create closure action document if it is not availble'
CustomKeywords.'actions.Common.createBulkDocuments_ClosureAction'(1)

'Expand Repository Menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/Repository/h3_Repository Menu'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Select repository and search for value in drop down'
CustomKeywords.'actions.Common.selectRepositoryAndSearchFor'('Closure', 'Closure')

'Click on Search button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Repository/input_btnSearch'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

'Wait for table to be visible'
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/Repository/table_SearchResults'), GlobalVariable.G_LongTimeout)

'Records in Table'
WebUI.verifyMatch(WebUI.getText(findTestObject('Page_nGage_Dashboard/Repository/Table_SearchResult_PageCount')), '.*Showing 1 - .*', true)

'Verify record summary is displayed above result gird'
String recordCount = WebUI.getText(findTestObject('Page_nGage_Dashboard/Repository/Table_SearchResult_PageCount')).split(' of ')[1].trim().replaceAll(",", "")
WebUI.verifyElementText(findTestObject('Page_nGage_Dashboard/Repository/span_RecordCountMessage'), 'Total '+recordCount+' unique items found')

'Open Closure tab from EDM'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('REPO', 'Closure', 'Closure')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/Closure_Tab/iframe_Closure'))

'Verify Closure tab is opened'
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/Business_Model_Tree/Tab_Closure'), GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/iframe_iframe_104'))

'Click on Search button on closure tab'
WebUI.click(findTestObject('Page_nGage_Dashboard/Repository/Closure_Tab/searchButton_ClosureTab'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/Closure_Tab/iframe_Closure'))

'Wait for Result Table'
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/Repository/Closure_Tab/table_SearchResultCount_ClosureTab'), GlobalVariable.G_LongTimeout)

'Verify records in table'
WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/Closure_Tab/table_SearchResultCount_ClosureTab')), '.*Showing 1 - .*', true)

'Verify record summary is displayed above result gird'
String recordCountEDM = WebUI.getText(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/Closure_Tab/table_SearchResultCount_ClosureTab')).split(' of ')[1].trim().replaceAll(",", "")
WebUI.verifyElementText(findTestObject('Page_nGage_Dashboard/Repository/span_RecordCountMessage'), 'Total '+recordCountEDM+' unique items found')
