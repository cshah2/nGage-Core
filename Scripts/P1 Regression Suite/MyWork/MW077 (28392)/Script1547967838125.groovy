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
import static utils.Consts.*

'Login Into Application'
CustomKeywords.'actions.Common.login'()

if(!FLAG_P1_MW_DOC2) {
	CustomKeywords.'actions.Common.createDocument_VerticalMenuWizard'(P1_MW_DOC2_FIRSTNAME, P1_MW_DOC2_LASTNAME, P1_MW_DOC2_AMOUNT, '')
	FLAG_P1_MW_DOC2 = true
}

'Click on My Work link from left menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_iframe_105'))

'Click Loan Interactive - Loan application'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('MY_WORK', 'Processes', 'Loan Interactive', 'Loan Application')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

'click on Dashboard tab'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/tab_Dashboard'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/iframe_Dashboard'))

'click on tab Assignment'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/tab_Assignment'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/iframe_Dashboard'))
WebUI.delay(5) //wait for chart to load

'Verify chart is visible'
int totalSlices = CustomKeywords.'actions.Chart.getNumberOfSlices'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/Chart_Asignee_ActivityDue'), GlobalVariable.ChartType['H_BAR'])
WebUI.verifyGreaterThan(totalSlices, 0)

'click on bar graph slice'
CustomKeywords.'actions.Chart.clickSlice'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/Chart_Asignee_ActivityDue'), 1,GlobalVariable.ChartType['H_BAR'] )
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/iframe_ASIGNEE'))

'check if table is present'
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/table_Assignee_workItem'), GlobalVariable.G_LongTimeout)

'reset layout'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/span_reset layout_Assignee'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/iframe_BAMActivityWorkIt_Assignee'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/tableHeader_DocID_Assignee'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementPresent(findTestObject('Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/tableHeader_DocCreateDate_Assignee'), GlobalVariable.G_LongTimeout)

int DocID_Index_Before= CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/tableHeader_Assignee_WorkItems'), 'Doc ID')
int DocCreateDate_Index_Before= CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/tableHeader_Assignee_WorkItems'), 'Doc Create Date')

'change layout of grid'
WebUI.dragAndDropToObject(findTestObject('Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/tableHeader_DocCreateDate_Assignee'),findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/tableHeader_DocID_Assignee'))

int DocID_Index_After= CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/tableHeader_Assignee_WorkItems'), 'Doc ID')
int DocCreateDate_Index_After= CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/tableHeader_Assignee_WorkItems'), 'Doc Create Date')

'click on set layout'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/span_SetLayout_Assignee'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/iframe_BAMActivityWorkIt_Assignee'))
WebUI.delay(2) //This is needed as Alert is being displayed for 1.5 sec

'verify layout'
WebUI.verifyEqual(DocID_Index_Before, DocCreateDate_Index_After)

'click on refresh'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/span_refresh_Assignee'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/iframe_BAMActivityWorkIt_Assignee'))

int DocCreateDate_Index_AfterRefresh= CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/tableHeader_Assignee_WorkItems'), 'Doc Create Date')

'verify layout'
WebUI.verifyEqual(DocID_Index_Before, DocCreateDate_Index_AfterRefresh)

'Click on Loan Interactive process'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('MY_WORK', 'Processes', 'Loan Interactive')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_iframe_105'))

'Click Loan Interactive - Loan application'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('MY_WORK', 'Processes', 'Loan Interactive', 'Loan Application')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

'click on Dashboard tab'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/tab_Dashboard'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/iframe_Dashboard'))

'click on tab Assignment'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/tab_Assignment'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/iframe_Dashboard'))
WebUI.delay(5) //wait for chart to plot

'Verify chart is visible'
totalSlices = CustomKeywords.'actions.Chart.getNumberOfSlices'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/Chart_Asignee_ActivityDue'), GlobalVariable.ChartType['H_BAR'])
WebUI.verifyGreaterThan(totalSlices, 0)

'click on bar graph slice'
CustomKeywords.'actions.Chart.clickSlice'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/Chart_Asignee_ActivityDue'), 1,GlobalVariable.ChartType['H_BAR'] )
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/iframe_ASIGNEE'))

'check if table is present'
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/table_Assignee_workItem'), GlobalVariable.G_LongTimeout)

int DocCreateDate_Index_AfterProcessSwitch= CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/tableHeader_Assignee_WorkItems'), 'Doc Create Date')

'verify layout'
WebUI.verifyEqual(DocID_Index_Before, DocCreateDate_Index_AfterProcessSwitch)

'reset layout'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/span_reset layout_Assignee'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/iframe_BAMActivityWorkIt_Assignee'))