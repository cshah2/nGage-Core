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

'Login Into Application'
CustomKeywords.'actions.Common.login'()

'Click on My Work link from left menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/i_PostmanProcesses1'), GlobalVariable.G_LongTimeout)

'expand closure action process'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/icon_Expand_Closure Actions'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'click on Activity A'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/a_Activity A'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))

'click on work item tab'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/tab_Dashboard'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/iframe_Dashboard'))

'click on tab Assignment'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/tab_Assignment'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/iframe_Dashboard'))

'click on process_due tab'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/span_ProcessDueType'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/iframe_ASIGNEE'))

'click on bar graph slice'
CustomKeywords.'actions.Chart.clickSlice'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/Chart_Asignee_ActivityDue'), 4,GlobalVariable.ChartType['H_BAR'] )
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/iframe_ASIGNEE'))

'check if table is present'
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/table_Assignee_workItem'), GlobalVariable.G_LongTimeout)

'sort table according to DocID'
//WebUI.rightClick(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/table_Assignee_workItem'))
//
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/tableHeader_DocID_Assignee'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/iframe_BAMActivityWorkIt_Assignee'))
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/tableHeader_DocID_Assignee'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/iframe_BAMActivityWorkIt_Assignee'))

int DocID_index=CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/tableHeader_Assignee_WorkItems'), 'Doc ID')

'verify grid is sorted according to DocID'
CustomKeywords.'actions.Table.verifyColumnIsSortedInteger'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/table_Assignee_workItem'), DocID_index, 'desc')

'click on refresh grid'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/span_refresh_Assignee'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/iframe_BAMActivityWorkIt_Assignee'))

're-sort table according to DocID'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/tableHeader_DocID_Assignee'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/iframe_BAMActivityWorkIt_Assignee'))
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/tableHeader_DocID_Assignee'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/iframe_BAMActivityWorkIt_Assignee'))

DocID_index=CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/tableHeader_Assignee_WorkItems'), 'Doc ID')

'verify grid is sorted according to DocID'
CustomKeywords.'actions.Table.verifyColumnIsSortedInteger'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/table_Assignee_workItem'), DocID_index, 'desc')