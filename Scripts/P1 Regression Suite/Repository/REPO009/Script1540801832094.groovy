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

'Click Reset grid layout button'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/resultGrid_ResetLayout'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/Repository/table_AdvanceSearch_FirstRow'), GlobalVariable.G_LongTimeout)

int colNo_Original_DocCreateDate = CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/table_Header_SearchResults'), 'Doc Create Date')
int colNo_Original_AccountNoUser = CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/table_Header_SearchResults'), 'Account No User')

'Drag column Doc Create Date over Account No User'
WebUI.dragAndDropToObject(findTestObject('Page_nGage_Dashboard/Repository/columnheader_DocCreateDate'), findTestObject('Page_nGage_Dashboard/Repository/columnHeader_AccountNoUser'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

int colNo_AfterSet_DocCreateDate = CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/table_Header_SearchResults'), 'Doc Create Date')
int colNo_AfterSet_AccountNoUser = CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/table_Header_SearchResults'), 'Account No User')
WebUI.verifyNotEqual(colNo_Original_DocCreateDate, colNo_AfterSet_DocCreateDate)
WebUI.verifyNotEqual(colNo_Original_AccountNoUser, colNo_AfterSet_AccountNoUser)

'Click Set Layout option'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/resultGrid_SetLayout'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/Repository/table_AdvanceSearch_FirstRow'), GlobalVariable.G_LongTimeout)

'Click Reset grid layout button'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/resultGrid_ResetLayout'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/Repository/table_AdvanceSearch_FirstRow'), GlobalVariable.G_LongTimeout)

int colNo_AfterReset_DocCreateDate = CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/table_Header_SearchResults'), 'Doc Create Date')
int colNo_AfterReset_AccountNoUser = CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/table_Header_SearchResults'), 'Account No User')
WebUI.verifyEqual(colNo_Original_DocCreateDate, colNo_AfterReset_DocCreateDate)
WebUI.verifyEqual(colNo_Original_AccountNoUser, colNo_AfterReset_AccountNoUser)