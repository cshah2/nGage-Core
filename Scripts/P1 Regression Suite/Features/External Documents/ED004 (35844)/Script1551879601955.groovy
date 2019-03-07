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
if(!FLAG_P1_MW_DOC005) {
	CustomKeywords.'actions.Data.create'(DocClass.COMPLAINTS_TEMPLATES, DocType.COMPLAINT_TEMPLATE, P1_MW_DOC005)
	FLAG_P1_MW_DOC005 = true
}

'Click on My Work link from left menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_iframe_105'))

'Go to Tree Menu'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('MY_WORK', MW_LVL0, MW_LVL1_COMPLAINTS_TEMPLATE, MW_LVL2_COMPLAINT_TEMPLATE)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Verify grid contains atleast 1 record'
int rowsCount = CustomKeywords.'actions.Table.getRowsCount'(findTestObject('Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'))
WebUI.verifyGreaterThanOrEqual(rowsCount, 1)

'Sort records in result grid by Template ID'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'Template ID')
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'Template ID')

'Get Template ID of newly created document'
int colNo_TemplateID = CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'Template ID')
String templateID = CustomKeywords.'actions.Table.getCellText'(findTestObject('Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'), 1, colNo_TemplateID)

'Click on first row in grid'
CustomKeywords.'actions.Table.clickCell'(findTestObject('Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'), 1, colNo_TemplateID)
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

'Click on My Work link from left menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_iframe_105'))

'Go to Tree Menu'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('MY_WORK', MW_LVL0, MW_LVL1_COMPLAINTS_TEMPLATE, MW_LVL2_COMPLAINT_TEMPLATE)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Sort records in result grid by Template ID'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'Template ID')
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'Template ID')

'Verify Record not present in grid'
CustomKeywords.'actions.Table.verifyRecordNotPresentInColumn'(findTestObject('Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'), colNo_TemplateID, templateID)