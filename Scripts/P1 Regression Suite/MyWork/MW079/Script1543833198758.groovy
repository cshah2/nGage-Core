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

'click on tab activity event state'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/tab_Activity Event State'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/iframe_Dashboard'))

'click on bar graph slice'
CustomKeywords.'actions.Chart.clickSlice'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/Chart_ActivityEventState_SLAStatusView'),4,GlobalVariable.ChartType['V_BAR'])
//CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/iframe_ACTEVENTSTATE_iframe'))

'verify table present'
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/table_ActivityEventState_Page_Summary'),GlobalVariable.G_LongTimeout)
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/table_ActivityEventState_WorkItems'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/tableHeader_DocID_ActivityEventState'), 0)
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/tableHeader_ActivityState_ActivityEventState'), 0)

'reset layout'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/span_reset layout_Activity Event State'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/iframe_BAMActivityWorkIt_ActivityEvent'))

int DocID_Index_Before= CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/table_ActivityEventState_WorkItems'), 'Doc Id')
int ActivityState_Index_Before= CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/table_ActivityEventState_WorkItems'), 'Activity State')

'change layout of grid'
WebUI.dragAndDropToObject(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/tableHeader_ActivityState_ActivityEventState'),findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/tableHeader_DocID_ActivityEventState'))

'click on set layout'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/span_SetLayout_ActivityEventState'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/iframe_BAMActivityWorkIt_ActivityEvent'))

'click on refresh'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/span_refresh_ActivityEventState'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/iframe_BAMActivityWorkIt_ActivityEvent'))

int DocID_Index_After= CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/table_ActivityEventState_WorkItems'), 'Doc Id')
int ActivityState_Index_After= CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/table_ActivityEventState_WorkItems'), 'Activity State')

'verify layout'
WebUI.verifyMatch(DocID_Index_Before.toString(), ActivityState_Index_After.toString(), false)

'click on another process/interactive process'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/a_Interactive Process'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_iframe_105'))

'click on Activity A'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/a_Activity A'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))

'click on work item tab'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/tab_Dashboard'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/iframe_Dashboard'))

'click on tab activity event state'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/tab_Activity Event State'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/iframe_Dashboard'))

'click on bar graph slice'
CustomKeywords.'actions.Chart.clickSlice'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/Chart_ActivityEventState_SLAStatusView'),4,GlobalVariable.ChartType['V_BAR'])
//CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/iframe_ACTEVENTSTATE_iframe'))

'verify table present'
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/table_ActivityEventState_Page_Summary'),GlobalVariable.G_LongTimeout)
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/table_ActivityEventState_WorkItems'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/tableHeader_DocID_ActivityEventState'), 0)
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/tableHeader_ActivityState_ActivityEventState'), 0)

'verify layout'
WebUI.verifyMatch(DocID_Index_Before.toString(), ActivityState_Index_After.toString(), false)

'reset layout'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/span_reset layout_Activity Event State'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/iframe_BAMActivityWorkIt_ActivityEvent'))