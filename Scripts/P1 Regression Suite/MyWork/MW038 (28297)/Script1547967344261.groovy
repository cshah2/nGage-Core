import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static utils.Consts.*

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable
import static utils.DateUtil.*

'Login Into Application'
CustomKeywords.'actions.Common.login'()

'Create data for filter test'
if (!(FLAG_P1_MW_DOCA)) {
	CustomKeywords.'actions.Common.createDocument_MyWorkDateTime'(DC_DATEREQUIRED, DT_DATEREQUIRED, P1_MW_DOCA_STARTDATE, P1_MW_DOCA_ENDDATE, P1_MW_DOCA_STARTDATETIME, P1_MW_DOCA_ENDDATETIME, '')
    FLAG_P1_MW_DOCA = true
}

if (!(FLAG_P1_MW_DOCB)) {
    CustomKeywords.'actions.Common.createDocument_MyWorkDateTime'(DC_DATEREQUIRED, DT_DATEREQUIRED, P1_MW_DOCB_STARTDATE, P1_MW_DOCB_ENDDATE, P1_MW_DOCB_STARTDATETIME, P1_MW_DOCB_ENDDATETIME, '')
    FLAG_P1_MW_DOCB = true
}

'Click on My Work link from left menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_iframe_105'))

String treeDate = convert(P1_MW_DOCA_STARTDATE, FORMAT_DATE, FORMAT_DATE_TREE)

'Expand Processes by Click on the Expand Icon and Verify Foldered data displayed'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('My_Work','Processes','Date Required','Daterequiredsearch', treeDate)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Click On Search Bar to open'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/h3_Search Bar'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Verify date autopopulated should show in the search panel'
String actualText = WebUI.getAttribute(findTestObject('Page_nGage_Dashboard/My_Work/Process_Date Required/input_StartDate'),'value')
WebUI.verifyMatch(actualText, P1_MW_DOCA_STARTDATE, false)

'Select Date Operator (=)from Dropdown Menu'
WebUI.selectOptionByLabel(findTestObject('Page_nGage_Dashboard/My_Work/Process_Date Required/select_StartDate_operator'), '=', false)

'Enter Date for Document 2'
CustomKeywords.'actions.Common.setText_Date'(findTestObject('Page_nGage_Dashboard/My_Work/Process_Date Required/input_StartDate'), P1_MW_DOCB_STARTDATE)

'Click On Search Button'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/btn_Search'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Sort records in result grid by DocID Desc'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'Doc ID')
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'Doc ID')

'Verify Search Result displays data as per filter'
int colNo_StartTestDate= CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'),'Start test date')
CustomKeywords.'actions.Table.verifyDateFilter'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'), colNo_StartTestDate, P1_MW_DOCB_STARTDATE, '', '=')