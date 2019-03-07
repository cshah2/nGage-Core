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
import common.DocClass
import common.DocType
import common.Fields

import static utils.Consts.*

'Login Into Application'
CustomKeywords.'actions.Common.login'()

'Create document if not already present'
if(!FLAG_P1_REPO_DOC002) {
	CustomKeywords.'actions.Data.create'(DocClass.COMPLAINTS_TEMPLATES, DocType.COMPLAINT_TEMPLATE, P1_REPO_DOC002)
	FLAG_P1_REPO_DOC002 = true
}
if(!FLAG_P1_REPO_DOC003) {
	CustomKeywords.'actions.Data.create'(DocClass.COMPLAINTS_TEMPLATES, DocType.COMPLAINT_TEMPLATE, P1_REPO_DOC003)
	FLAG_P1_REPO_DOC003 = true
}

String templateName = P1_REPO_DOC003.get(Fields.TEMPLATE_NAME)
String templateText = P1_REPO_DOC003.get(Fields.TEMPLATE_TEXT)

'Expand Repository Menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/Repository/h3_Repository Menu'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Select Repository and Search For'
CustomKeywords.'actions.Common.selectRepositoryAndSearchFor'(REPO_LVL1_COMPLAINTS_TEMPLATE, REPO_LVL2_COMPLAINT_TEMPLATE)

'Enter search criteria'
WebUI.setText(findTestObject('Page_nGage_Dashboard/Repository/input_Template Name'), templateName)

'Click on Search button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Repository/input_btnSearch'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

'Verify table contains atleast 1 record'
int rowsCount = CustomKeywords.'actions.Table.getRowsCount'(findTestObject('Page_nGage_Dashboard/Repository/table_SearchResults'))
WebUI.verifyGreaterThan(rowsCount, 0)

'Sort records by Template ID descending'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Repository/table_Header_SearchResults'), 'Template ID')
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Repository/table_Header_SearchResults'), 'Template ID')

'Verify correct records are displayed as per filter criteria'
int colNo_TemplateName = CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Page_nGage_Dashboard/Repository/table_Header_SearchResults'), 'Template Name')
CustomKeywords.'actions.Table.verifyAllValuesInColumnMatches'(findTestObject('Page_nGage_Dashboard/Repository/table_SearchResults'), colNo_TemplateName, templateName)