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

import common.DocClass
import common.DocType
import common.Fields
import internal.GlobalVariable as GlobalVariable
import static utils.Consts.*

'Login into application'
CustomKeywords.'actions.Common.login'()

'Create Document if not present'
if(!FLAG_P1_REPO_DOC121) {
	CustomKeywords.'actions.Data.create'(DocClass.REQUIRED_FIELD_DC, DocType.REQUIRED_FIELD_DT, P1_REPO_DOC121)
	FLAG_P1_REPO_DOC121 = true
}
String bmString = P1_REPO_DOC121.get(Fields.BM_STRING)
String date = P1_REPO_DOC121.get(Fields.DATE)

'Expand Repository Menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/Repository/h3_Repository Menu'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Select repository and search for value in drop down'
CustomKeywords.'actions.Common.selectRepositoryAndSearchFor'('Required Date string field EDM', 'Required field date string search class')

'Enter data in required field'
WebUI.setText(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/inpur_BM_String_Required'), bmString)

'Enter date in required field'
CustomKeywords.'actions.Common.setText_Date'(findTestObject('Page_nGage_Dashboard/Repository/input_BM_DateFrom_Required'), date)
CustomKeywords.'actions.Common.setText_Date'(findTestObject('Page_nGage_Dashboard/Repository/input_BM_DateTo_Required'), date)

'Click on Search button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Repository/input_btnSearch'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

'Wait for Result Table'
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/Repository/table_SearchResults'), GlobalVariable.G_LongTimeout)

'Sort record by DocID desc'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Repository/table_Header_SearchResults'), 'Doc ID')
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Repository/table_Header_SearchResults'), 'Doc ID')

'Verify records are between the filter dates'
int columnNoDate = CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Page_nGage_Dashboard/Repository/table_Header_SearchResults'), 'Date Required')
CustomKeywords.'actions.Table.verifyDateFilter'(findTestObject('Page_nGage_Dashboard/Repository/table_SearchResults'), columnNoDate, date, date, 'between')

'Verify values for BM String required fielf for all visible rows'
int columnNoString = CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Page_nGage_Dashboard/Repository/table_Header_SearchResults'), 'BM String required')
CustomKeywords.'actions.Table.verifyCellContainsValue'(findTestObject('Page_nGage_Dashboard/Repository/table_SearchResults'), 1, columnNoString, bmString)