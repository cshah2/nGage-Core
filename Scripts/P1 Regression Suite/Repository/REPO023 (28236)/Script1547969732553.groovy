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

'Create Bulk Document'
CustomKeywords.'actions.Common.createBulkDocuments_RenderAllFields'(40)

'Expand Repository Menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/Repository/h3_Repository Menu'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

'Select Repository - Advance Search tab'
WebUI.selectOptionByLabel(findTestObject('Page_nGage_Dashboard/Repository/select_Repository Drop Down'), 'Business Model', false)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

'Selinput_btnSearchect Search For - Advance Search tab'
WebUI.selectOptionByLabel(findTestObject('Page_nGage_Dashboard/Repository/select_Search For Drop Down'), 'Business Model', false)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

'Click on Search button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Repository/input_btnSearch'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

'Verify Records are present in table'
int rowCount = CustomKeywords.'actions.Table.getRowsCount'(findTestObject('Page_nGage_Dashboard/Repository/table_SearchResults'))
WebUI.verifyGreaterThanOrEqual(rowCount, 1)

'Ensure the first page in the table is loaded'
WebUI.verifyMatch(WebUI.getText(findTestObject('Page_nGage_Dashboard/Repository/Table_SearchResult_PageCount')), '.*Showing 1 - 12.*', true)

'Click on next page (>|) icon.'
WebUI.click(findTestObject('Page_nGage_Dashboard/Repository/Table_LastPageButton'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

'Verify Page number'
WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/Table_PageNumberInput'),'value'),WebUI.getText(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/Table_PageNumberDisplayed')) , false)

'Verify element(span_next,span_last) is not clickable'
CustomKeywords.'actions.Common.verifyElementAttributeValueContains'(findTestObject('Page_nGage_Dashboard/Repository/Table_LastPageButton'), 'class', 'ui-state-disabled')
CustomKeywords.'actions.Common.verifyElementAttributeValueContains'(findTestObject('Page_nGage_Dashboard/Repository/Teble_NextPageButton'), 'class', 'ui-state-disabled')