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
import utils.Fields

import static utils.Consts.*

'Login Into Application'
CustomKeywords.'actions.Common.login'()

'Create document is not present already'
if(!FLAG_P1_MW_DOC001) {
	CustomKeywords.'actions.Data.create'(DC_COMPLAINTS_TEMPLATES, DT_COMPLAINT_TEMPLATE, P1_MW_DOC001)
	FLAG_P1_MW_DOC001 = true
}
if(!FLAG_P1_MW_DOC004) {
	CustomKeywords.'actions.Data.create'(DC_COMPLAINTS_TEMPLATES, DT_COMPLAINT_TEMPLATE, P1_MW_DOC004)
	FLAG_P1_MW_DOC004 = true
}

String templateName = P1_MW_DOC004.get(Fields.TEMPLATE_NAME)
String templateText = P1_MW_DOC004.get(Fields.TEMPLATE_TEXT)

'Click on My Work link from left menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_iframe_105'))

'Go to Tree Menu'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('MY_WORK', MW_LVL0, MW_LVL1_COMPLAINTS_TEMPLATE, MW_LVL2_COMPLAINT_TEMPLATE)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Verify grid contains atleast 2 record'
int rowsCount = CustomKeywords.'actions.Table.getRowsCount'(findTestObject('Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'))
WebUI.verifyGreaterThanOrEqual(rowsCount, 2)

'Expand Search bar'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/h3_Search Bar'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Enter search criteria'
WebUI.setText(findTestObject('Page_nGage_Dashboard/My_Work/search_Template Name'), templateName)

'Click On Search Button'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/btn_Search'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Sort records in result grid by Template ID'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'Template ID')
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'Template ID')

'Verify records are displayed as per filter criteria'
int colNo_TemplateName = CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'Template Name')
CustomKeywords.'actions.Table.verifyAllValuesInColumnMatches'(findTestObject('Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'), colNo_TemplateName, templateName)