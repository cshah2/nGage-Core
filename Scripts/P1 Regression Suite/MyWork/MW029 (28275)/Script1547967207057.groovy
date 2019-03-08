import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.junit.After

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import common.ChartType
import internal.GlobalVariable as GlobalVariable
import static utils.Consts.*

'Login Into Application'
CustomKeywords.'actions.Common.login'()

'Create Docuement if not present'
if(!FLAG_P1_MW_DOC9) {
	CustomKeywords.'actions.Common.createDocument_ClosureAction'(P1_MW_DOC9_CUSTNAME, P1_MW_DOC9_CUSTDESC)
	FLAG_P1_MW_DOC9 = true
}

'Click on My Work link from left menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_iframe_105'))

'Click Processes'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('MY_WORK', 'Processes')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_iframe_105'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
WebUI.delay(5)

'Verify Chart sections and its contents'
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/My_Work/Charts/Bar Chart - Header'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementText(findTestObject('Page_nGage_Dashboard/My_Work/Charts/Bar Chart - Header'), 'All Processes - SLA Status View')
WebUI.verifyElementText(findTestObject('Page_nGage_Dashboard/My_Work/Charts/Pie Chart - Header'), 'All Processes - Summary')
WebUI.verifyElementText(findTestObject('Page_nGage_Dashboard/My_Work/Charts/td_Activity Summary'), 'Process Summary')
WebUI.verifyElementVisible(findTestObject('Page_nGage_Dashboard/My_Work/Charts/button_Show All Workitems'))
WebUI.verifyElementText(findTestObject('Page_nGage_Dashboard/My_Work/Charts/button_Show All Workitems'), 'Show All Work Items')
WebUI.verifyElementVisible(findTestObject('Page_nGage_Dashboard/My_Work/Charts/button_Show Due Soon Work Item'))
WebUI.verifyElementText(findTestObject('Page_nGage_Dashboard/My_Work/Charts/button_Show Due Soon Work Item'), 'Show Due Soon Work Items')
WebUI.verifyElementVisible(findTestObject('Page_nGage_Dashboard/My_Work/Charts/button_Show On Time Work Items'))
WebUI.verifyElementText(findTestObject('Page_nGage_Dashboard/My_Work/Charts/button_Show On Time Work Items'), 'Show On Time Work Items')
WebUI.verifyElementVisible(findTestObject('Page_nGage_Dashboard/My_Work/Charts/button_Show Overdue Workitems'))
WebUI.verifyElementText(findTestObject('Page_nGage_Dashboard/My_Work/Charts/button_Show Overdue Workitems'), 'Show Overdue Work Items')

'Verify activity count in table'
int totalRecords = CustomKeywords.'actions.Table.getRowsCount'(findTestObject('Page_nGage_Dashboard/My_Work/Charts/table_AllProcess'))
WebUI.verifyGreaterThan(totalRecords, 0)

'Verify correct number of slices are displayed in pie chart'
WebUI.verifyElementVisible(findTestObject('Page_nGage_Dashboard/My_Work/Charts/Chart_AllProcess_Summary'))
int allProcess_PieSlices = CustomKeywords.'actions.Chart.getNumberOfSlices'(findTestObject('Page_nGage_Dashboard/My_Work/Charts/Chart_AllProcess_Summary'), ChartType.PIE)
WebUI.verifyGreaterThan(allProcess_PieSlices, 0)

'Verify correct number of slices in bar chart'
WebUI.verifyElementVisible(findTestObject('Page_nGage_Dashboard/My_Work/Charts/Chart_AllProcess_SLAStatusView'))
int allProcess_BarSlices = CustomKeywords.'actions.Chart.getNumberOfSlices'(findTestObject('Page_nGage_Dashboard/My_Work/Charts/Chart_AllProcess_SLAStatusView'), ChartType.BAR_VERTICAL)
WebUI.verifyGreaterThan(allProcess_BarSlices, 0)

'Get Row Number for closure activity process'
int rowNo = CustomKeywords.'actions.Table.getRowNumber'(findTestObject('Page_nGage_Dashboard/My_Work/Charts/table_AllProcess'), 2, 'Closure Action') 
println 'Expected Row No is :'+rowNo

'Get Slice Number for closure activity process'
int sliceNo = CustomKeywords.'actions.Table.getCorrectSliceNumber'(findTestObject('Page_nGage_Dashboard/My_Work/Charts/table_AllProcess'), 6, 2, 'Closure Action')
println 'Expected Row No is :'+sliceNo

'Get Total record count from table for Closure Action activity'
int totalDocs = Integer.parseInt(CustomKeywords.'actions.Table.getCellText'(findTestObject('Page_nGage_Dashboard/My_Work/Charts/table_AllProcess'), rowNo, 6))

'Click on Slice in Bar graph'
CustomKeywords.'actions.Chart.clickSlice'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Charts/Chart_AllProcess_SLAStatusView'), sliceNo*4, ChartType.BAR_VERTICAL)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Charts/iframe_iframe_105'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/Charts/iframe_MyIframe'))

'Get total no of records displayed in table'
int rowCount = CustomKeywords.'actions.Table.getRowsCount'(findTestObject('Page_nGage_Dashboard/My_Work/Charts/Table_JQGrid WorkItems'))

'Verify total record counts with number of records displayed in table'
if(totalDocs > 100)
	WebUI.verifyEqual(rowCount, 100)
else
	WebUI.verifyEqual(rowCount, totalDocs)
	
'Verify pagination summary'
CustomKeywords.'actions.Common.verifyTotalRecordCountFromPageSummary'(findTestObject('Page_nGage_Dashboard/My_Work/Charts/Table_PaginationSummary'), totalDocs)