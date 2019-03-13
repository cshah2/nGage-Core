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
import internal.GlobalVariable as GlobalVariable
import static utils.Consts.*

'Login Into Application'
CustomKeywords.'actions.Common.login'()

'Create Documents if not available'
if(!FLAG_P1_MW_DOC081) {
	CustomKeywords.'actions.Data.create'(DocClass.VERTICAL_MENU_WIZARD, DocType.SHOW_VERTICAL_MENU_TRUE, P1_MW_DOC081)
	FLAG_P1_MW_DOC081 = true
}

if(!FLAG_P1_MW_DOC084) {
	CustomKeywords.'actions.Data.create'(DocClass.VERTICAL_MENU_WIZARD, DocType.SHOW_VERTICAL_MENU_TRUE, P1_MW_DOC084)
	FLAG_P1_MW_DOC084 = true
}

if(!FLAG_P1_MW_DOC085) {
	CustomKeywords.'actions.Data.create'(DocClass.VERTICAL_MENU_WIZARD, DocType.SHOW_VERTICAL_MENU_TRUE, P1_MW_DOC085)
	FLAG_P1_MW_DOC085 = true
}

'Click on My Work link from left menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_iframe_105'))

'Click Tree Menu Loan Interactive - Loan application'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('MY_WORK', 'Processes', 'Loan Interactive', 'Loan Application')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Get Record count in Activity from Tree'
int recordCountActivity = CustomKeywords.'actions.MenuBar.getRecordCountInActivity'('MY_WORK', 'Processes', 'Loan Interactive', 'Loan Application')

'Verify record count in Activity matches with record count in tree'
CustomKeywords.'actions.Common.verifyTotalRecordCountFromPageSummary'(findTestObject('Page_nGage_Dashboard/My_Work/table_pagination_summary'), recordCountActivity)

'Expand Search Bar'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/h3_Search Bar'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/process_Loan Interactive/input_Loan Appln_LoanAmtFrom'))
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/process_Loan Interactive/input_LoanAppln_LoanAmtTo'))

'Enter loan amount range values'
WebUI.setText(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/process_Loan Interactive/input_Loan Appln_LoanAmtFrom'), P1_MW_DOC081_AMOUNT_FROM)
WebUI.setText(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/process_Loan Interactive/input_LoanAppln_LoanAmtTo'), P1_MW_DOC081_AMOUNT_TO)

'click on search button'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/btn_Search'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))

int loanAmount_Position=CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'Loan Amount')

'Click Column Header Loan Amount to sort records by Ascending'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'Loan Amount')

'verify grid records according to filter applied'
CustomKeywords.'actions.Table.verifyRecordsWithinRange'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'), loanAmount_Position, Double.parseDouble(P1_MW_DOC081_AMOUNT_FROM), Double.parseDouble(P1_MW_DOC081_AMOUNT_TO))

'Click Column Header Loan Amount to sort records by Descending'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'Loan Amount')

'verify grid records according to filter applied'
CustomKeywords.'actions.Table.verifyRecordsWithinRange'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'), loanAmount_Position, Double.parseDouble(P1_MW_DOC081_AMOUNT_FROM), Double.parseDouble(P1_MW_DOC081_AMOUNT_TO))