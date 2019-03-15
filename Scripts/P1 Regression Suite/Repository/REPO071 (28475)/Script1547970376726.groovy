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

import common.Fields
import internal.GlobalVariable as GlobalVariable
import static utils.Consts.*
import static utils.DateUtil.*

'Login into application'
CustomKeywords.'actions.Common.login'()

'Create all date filter data if not present'
CustomKeywords.'actions.Common.createDateFilterDataRepository'()

'Click on Repository Menu'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/h3_Repository Menu'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

String filter_BM_Date = P1_REPO_DOC243.get(Fields.DATE)

'Select repository and search for value in drop down'
CustomKeywords.'actions.Common.selectRepositoryAndSearchFor'('Date n Date time EDM', 'Date n Date time search class')

'Select operator (=)'
WebUI.selectOptionByLabel(findTestObject('Page_nGage_Dashboard/Repository/select_BM_Date'), '=', false)

'Enter date in DateTime field'
CustomKeywords.'actions.Common.setText_Date'(findTestObject('Page_nGage_Dashboard/Repository/input_BM_Date'), filter_BM_Date)

'Click on Search button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Repository/input_btnSearch'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

'Verify table contains atleast 1 record'
int rowCount = CustomKeywords.'actions.Table.getRowsCount'(findTestObject('Page_nGage_Dashboard/Repository/table_SearchResults'))
WebUI.verifyGreaterThan(rowCount, 0)

'Sort record by DocID desc'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Repository/table_Header_SearchResults'), 'Doc ID')
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Repository/table_Header_SearchResults'), 'Doc ID')

'Get the cell value to verify date format'
int colNo_BMDate = CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Page_nGage_Dashboard/Repository/table_Header_SearchResults'), 'BM Date')
CustomKeywords.'actions.Table.verifyDateFilter'(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/table_SearchResults'), colNo_BMDate, filter_BM_Date, '', '=')
CustomKeywords.'actions.Table.verifyRecordPresentInColumn'(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/table_SearchResults'), colNo_BMDate, filter_BM_Date)