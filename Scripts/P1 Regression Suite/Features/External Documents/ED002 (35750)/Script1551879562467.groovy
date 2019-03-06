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
import utils.DateUtil

import static utils.Consts.*

'Login Into Application'
CustomKeywords.'actions.Common.login'()

'Create document is not present already'
if(!FLAG_P1_MW_DOC001) {
	CustomKeywords.'actions.Data.create'(DC_COMPLAINTS_TEMPLATES, DT_COMPLAINT_TEMPLATE, P1_MW_DOC001)
	FLAG_P1_MW_DOC001 = true
}

'Click on My Work link from left menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_iframe_105'))

'Get current document counts for Complaint Template'
int currentCount = CustomKeywords.'actions.MenuBar.getRecordCountInActivity'('MY_WORK', MW_LVL0, MW_LVL1_COMPLAINTS_TEMPLATE, MW_LVL2_COMPLAINT_TEMPLATE)
WebUI.verifyGreaterThanOrEqual(currentCount, 1)

'Go to Tree Menu'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('MY_WORK', MW_LVL0, MW_LVL1_COMPLAINTS_TEMPLATE, MW_LVL2_COMPLAINT_TEMPLATE)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Verify grid contains atleast 1 record'
int rowsCount = CustomKeywords.'actions.Table.getRowsCount'(findTestObject('Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'))
WebUI.verifyGreaterThanOrEqual(rowsCount, 1)

'Sort records by Template ID descending'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'Template ID')
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'Template ID')

'Click on first row in grid'
int colNo_TemplateID = CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'Template ID')
CustomKeywords.'actions.Table.clickCell'(findTestObject('Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'), 1, colNo_TemplateID)
WebUI.switchToWindowIndex(1)

String templateName = 'Template Name updated'
String templateText = 'Updated_'+DateUtil.getCurrentDateTimeMinusDays(0)

'Update Template name'
WebUI.setText(findTestObject('Page_WMI/Complaints Templates/Complaint Template/input_Template Name'), templateName)
WebUI.setText(findTestObject('Page_WMI/Complaints Templates/Complaint Template/body_Template Text'), templateText)

'Click on Save button'
WebUI.click(findTestObject('Page_WMI/Complaints Templates/Complaint Template/btn_Save'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Click on close button'
WebUI.click(findTestObject('Page_WMI/Complaints Templates/Complaint Template/btn_Close'))

'Refresh web page'
WebUI.switchToWindowIndex(0)
WebUI.refresh()

'Click on My Work link from left menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_iframe_105'))

'Go to Tree Menu'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('MY_WORK', MW_LVL0, MW_LVL1_COMPLAINTS_TEMPLATE, MW_LVL2_COMPLAINT_TEMPLATE)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Sort records by Template ID descending'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'Template ID')
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'Template ID')

'Click on first row in grid'
CustomKeywords.'actions.Table.clickCell'(findTestObject('Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'), 1, colNo_TemplateID)
WebUI.switchToWindowIndex(1)

'Verify updated values are saved.'
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI/Complaints Templates/Complaint Template/input_Template Name'), 'value', templateName, GlobalVariable.G_LongTimeout)
WebUI.verifyElementText(findTestObject('Page_WMI/Complaints Templates/Complaint Template/p_Template Text'), templateText)