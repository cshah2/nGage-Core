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
import internal.GlobalVariable as GlobalVariable

'Login Into Application'
CustomKeywords.'actions.Common.login'()

'Click on My Work link from left menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_iframe_105'))

'verify all-processes total work items summary graphs, bar graphs, process list and process summary visible to user'
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Charts/Chart_AllProcess_Summary'))
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Charts/Chart_AllProcess_SLAStatusView'))
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Charts/table_AllProcess'))

'verify all process names for which user has admin rights are visible/present in graph '
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
CustomKeywords.'actions.Table.verifyRecordsCount'(findTestObject('Page_nGage_Dashboard/My_Work/Charts/table_AllProcess'), 10)

'Verify correct number of slices are displayed in pie chart'
CustomKeywords.'actions.Chart.verifyNumberOfSlices'(findTestObject('Page_nGage_Dashboard/My_Work/Charts/Chart_AllProcess_Summary'), 10, GlobalVariable.ChartType['PIE'])

'Verify correct number of slices in bar chart'
CustomKeywords.'actions.Chart.verifyNumberOfSlices'(findTestObject('Page_nGage_Dashboard/My_Work/Charts/Chart_AllProcess_SLAStatusView'), 40, GlobalVariable.ChartType['V_BAR'])
