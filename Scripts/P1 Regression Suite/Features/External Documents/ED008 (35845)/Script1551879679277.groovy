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

'Create document is not present already'
if(!FLAG_P1_REPO_DOC006) {
	CustomKeywords.'actions.Data.create'(DocClass.COMPLAINTS_TEMPLATES, DocType.COMPLAINT_TEMPLATE, P1_REPO_DOC006)
	FLAG_P1_REPO_DOC006 = true
}

'Expand Repository Menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/Repository/h3_Repository Menu'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Select Repository and Search For'
CustomKeywords.'actions.Common.selectRepositoryAndSearchFor'(REPO_LVL1_COMPLAINTS_TEMPLATE, REPO_LVL2_COMPLAINT_TEMPLATE)

'Click on Search button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Repository/input_btnSearch'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

'Verify table contains atleast 1 record'
int rowsCount = CustomKeywords.'actions.Table.getRowsCount'(findTestObject('Page_nGage_Dashboard/Repository/table_SearchResults'))
WebUI.verifyGreaterThan(rowsCount, 0)

'Sort records by Template ID descending'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Repository/table_Header_SearchResults'), 'Template ID')
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Repository/table_Header_SearchResults'), 'Template ID')

'Get Template ID of newly created document'
int colNo_TemplateID = CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Page_nGage_Dashboard/Repository/table_Header_SearchResults'), 'Template ID')
String templateID = CustomKeywords.'actions.Table.getCellText'(findTestObject('Page_nGage_Dashboard/Repository/table_SearchResults'), 1, colNo_TemplateID)

'Click on first row in grid'
CustomKeywords.'actions.Table.clickCell'(findTestObject('Page_nGage_Dashboard/Repository/table_SearchResults'), 1, colNo_TemplateID)
WebUI.switchToWindowIndex(1)

'Click on Delete button'
WebUI.click(findTestObject('Page_WMI/Complaints Templates/Complaint Template/btn_Delete'))
WebUI.waitForElementVisible(findTestObject('Page_WMI/Complaints Templates/Complaint Template/dialog_Delete_Message'), GlobalVariable.G_LongTimeout)

'Verify message on delete prompt'
WebUI.verifyElementText(findTestObject('Page_WMI/Complaints Templates/Complaint Template/dialog_Delete_Message'), 'You are about to delete this document! Are you sure?')

'Click on Yes button and wait for window close'
CustomKeywords.'actions.Window.clickElementAndWaitForWindowClose'(findTestObject('Page_WMI/Complaints Templates/Complaint Template/dialog_Delete_Yes'), GlobalVariable.G_LongTimeout)

'Go to dashboard page'
WebUI.switchToWindowIndex(0)
WebUI.refresh()

'Expand Repository Menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/Repository/h3_Repository Menu'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Select Repository and Search For'
CustomKeywords.'actions.Common.selectRepositoryAndSearchFor'(REPO_LVL1_COMPLAINTS_TEMPLATE, REPO_LVL2_COMPLAINT_TEMPLATE)

'Click on Search button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Repository/input_btnSearch'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

'Sort records by Template ID descending'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Repository/table_Header_SearchResults'), 'Template ID')
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Repository/table_Header_SearchResults'), 'Template ID')

'Verify Record not present in grid'
CustomKeywords.'actions.Table.verifyRecordNotPresentInColumn'(findTestObject('Page_nGage_Dashboard/Repository/table_SearchResults'), colNo_TemplateID, templateID)