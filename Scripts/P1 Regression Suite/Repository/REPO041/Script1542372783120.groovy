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

'Expand Repository Menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/Repository/h3_Repository Menu'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

'Select Repository - Advance Search tab'
WebUI.selectOptionByLabel(findTestObject('Page_nGage_Dashboard/Repository/select_Repository Drop Down'), 'Customers', false)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

'Selinput_btnSearchect Search For - Advance Search tab'
WebUI.selectOptionByLabel(findTestObject('Page_nGage_Dashboard/Repository/select_Search For Drop Down'), 'Customers', false)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

'Click on Search button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Repository/input_btnSearch'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

'Get Column number for Doc ID column'
int columnID = CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/table_Header_SearchResults'), 'Doc ID')

'Click on Doc ID header'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/columnHeader_DocID'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

'Verify records are sorted in ascending order'
CustomKeywords.'actions.Table.verifyColumnIsSortedInteger'(findTestObject('Page_nGage_Dashboard/Repository/table_SearchResults'), columnID, 'ASC')

'Click on refresh button'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/browseResult_Refresh'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

'Click on Doc ID header'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/columnHeader_DocID'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

'Verify records are sorted in ascending order'
CustomKeywords.'actions.Table.verifyColumnIsSortedInteger'(findTestObject('Page_nGage_Dashboard/Repository/table_SearchResults'), columnID, 'ASC')

'Click on Doc ID column'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/columnHeader_DocID'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

'Verify records are sorted in decending order'
CustomKeywords.'actions.Table.verifyColumnIsSortedInteger'(findTestObject('Page_nGage_Dashboard/Repository/table_SearchResults'), columnID, 'DESC')