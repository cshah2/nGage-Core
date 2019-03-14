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
import static utils.DateUtil.*

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

'Verify atleast 1 record is present in result'
int rowCount = CustomKeywords.'actions.Table.getRowsCount'(findTestObject('Page_nGage_Dashboard/Repository/table_SearchResults'))
WebUI.verifyGreaterThan(rowCount, 0)

String pageCountAfterFilter = WebUI.getText(findTestObject('Page_nGage_Dashboard/Repository/div_Page_Results'))

'Click save search button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Repository/input_btnSaveSearchAdv'))
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/save_Search_Description'))

'Enter Search critera name'
String now = getCurrentDateTime()
String fileName = 'SAVED_SEARCH_'+now
WebUI.setText(findTestObject('Page_nGage_Dashboard/Repository/input_txtSaveDesc'), fileName)

WebUI.click(findTestObject('Page_nGage_Dashboard/Repository/input_btnSave'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

'Select Saved search filter from the table'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Repository/table_Header_SavedSearch'), 'Modified Date')
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Repository/table_Header_SavedSearch'), 'Modified Date')

'Verify Filter created in last test cases is present in first row'
WebUI.verifyElementText(findTestObject('Page_nGage_Dashboard/Repository/column_Saved Search table first row Search Desc'), fileName)

'Select filter from table'
WebUI.click(findTestObject('Page_nGage_Dashboard/Repository/column_Saved Search table first row Search Desc'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

'Click on Recall button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Repository/input_btnRecall'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

'Wait for Element Visible'
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/Repository/div_Page_Results'), GlobalVariable.G_LongTimeout)

'Validate Record count in filter'
WebUI.verifyElementText(findTestObject('Page_nGage_Dashboard/Repository/div_Page_Results'), pageCountAfterFilter)