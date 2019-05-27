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

'Create Document Correspondence Generation -> Correspondence'
CustomKeywords.'actions.Common.createBulkDocuments_Correpondence'(30)

'Click on "My Work Simplified" link'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/a_My Work Simplified'))
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/select_Auto Import Controlled'), GlobalVariable.G_LongTimeout)

'Select Activity "Correspondence Generation - Correspondence" from Drop down'
WebUI.selectOptionByLabel(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/select_Auto Import Controlled'), 'Correspondence Generation - Correspondence', false)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/iframe_iframe_110'))

'Get Rows count'
int rowsCount = CustomKeywords.'actions.Table.getRowsCount'(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/table_SearchResult'))

'Verify pagination summary'
String expPageSummary
if(rowsCount > 999) {
	 expPageSummary = 'Showing 1 - 999'
}
else {
	expPageSummary = 'Showing 1 - '+rowsCount+' of '+rowsCount
}

String pageSummary = WebUI.getText(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/table_PaginationSummary'))
WebUI.verifyMatch(pageSummary, '.*'+expPageSummary+'.*', true)