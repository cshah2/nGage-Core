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

'Click on My Work link from left menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_iframe_105'))

'Get current document counts for Complaint Template'
int currentCount = CustomKeywords.'actions.MenuBar.getRecordCountInActivity'('MY_WORK', MW_LVL0, MW_LVL1_COMPLAINTS_TEMPLATE, MW_LVL2_COMPLAINT_TEMPLATE)

'Create Document'
CustomKeywords.'actions.Data.create'(DocClass.COMPLAINTS_TEMPLATES, DocType.COMPLAINT_TEMPLATE, P1_MW_DOC001)
FLAG_P1_MW_DOC001 = true

WebUI.refresh()

'Click on My Work link from left menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_iframe_105'))

'Get new document counts for Complaint Template'
int newCount = CustomKeywords.'actions.MenuBar.getRecordCountInActivity'('MY_WORK', MW_LVL0, MW_LVL1_COMPLAINTS_TEMPLATE, MW_LVL2_COMPLAINT_TEMPLATE)

'Verify document count is increased by one'
WebUI.verifyEqual(newCount, currentCount+1)

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

String templateName = P1_MW_DOC001.get(Fields.TEMPLATE_NAME)
String templateText = P1_MW_DOC001.get(Fields.TEMPLATE_TEXT)

WebUI.verifyElementAttributeValue(findTestObject('Page_WMI/Complaints Templates/Complaint Template/input_Template Name'), 'value', templateName, GlobalVariable.G_LongTimeout)
WebUI.verifyElementText(findTestObject('Page_WMI/Complaints Templates/Complaint Template/p_Template Text'), templateText)