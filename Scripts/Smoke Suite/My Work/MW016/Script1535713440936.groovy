import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.apache.poi.ss.usermodel.Chart

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

'Login Into Application'
CustomKeywords.'actions.Common.login'()

'Click on My Work link from left menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_iframe_105'))

'Select Activity Interactive Process - User ac1'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('MY_WORK', 'Processes', 'Interactive Process', 'User act1 Interactive/adm/Business')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Select Dashboard tab'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/tab_Dashboard'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/iframe_ASIGNEE'))

'Select Activity Event state tab'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/tab_Activity Event State'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/iframe_ACTEVENTSTATE_iframe'))

'Verify No of slices in Pie Chart'
CustomKeywords.'actions.Chart.verifyNumberOfSlices'(findTestObject('Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/Chart_ActivityEventState_Summary'), 3, GlobalVariable.ChartType['PIE'])

'Verify No os slices in Vertical Bar chart'
CustomKeywords.'actions.Chart.verifyNumberOfSlices'(findTestObject('Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/Chart_ActivityEventState_SLAStatusView'), 12, GlobalVariable.ChartType['V_BAR'])

'Verify Correct Chart counts are displayed in tooltip for pie chart'
CustomKeywords.'actions.Chart.verifyToolTipText'(findTestObject('Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/Chart_ActivityEventState_Summary'), 1, 'Open', '16', GlobalVariable.ChartType['PIE'])
CustomKeywords.'actions.Chart.verifyToolTipText'(findTestObject('Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/Chart_ActivityEventState_Summary'), 2, 'Closure', '13', GlobalVariable.ChartType['PIE'])
CustomKeywords.'actions.Chart.verifyToolTipText'(findTestObject('Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/Chart_ActivityEventState_Summary'), 3, 'In Error', '3', GlobalVariable.ChartType['PIE'])

'Verify Correct Chart count s are displayed in tooltip for bar chart'
CustomKeywords.'actions.Chart.verifyToolTipText'(findTestObject('Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/Chart_ActivityEventState_Summary'), 3, 'Open', '16', GlobalVariable.ChartType['V_BAR'])
CustomKeywords.'actions.Chart.verifyToolTipText'(findTestObject('Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/Chart_ActivityEventState_Summary'), 4, 'Open', '16', GlobalVariable.ChartType['V_BAR'])
CustomKeywords.'actions.Chart.verifyToolTipText'(findTestObject('Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/Chart_ActivityEventState_Summary'), 7, 'Closure', '13', GlobalVariable.ChartType['V_BAR'])
CustomKeywords.'actions.Chart.verifyToolTipText'(findTestObject('Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/Chart_ActivityEventState_Summary'), 8, 'Closure', '13', GlobalVariable.ChartType['V_BAR'])
CustomKeywords.'actions.Chart.verifyToolTipText'(findTestObject('Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/Chart_ActivityEventState_Summary'), 11, 'In Error', '3', GlobalVariable.ChartType['V_BAR'])
CustomKeywords.'actions.Chart.verifyToolTipText'(findTestObject('Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/Chart_ActivityEventState_Summary'), 12, 'In Error', '3', GlobalVariable.ChartType['V_BAR'])

'Click on a slice in pie chart and verify count is matching in result grid'
CustomKeywords.'actions.Chart.clickSlice'(findTestObject('Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/Chart_ActivityEventState_Summary'), 1, GlobalVariable.ChartType['PIE'])
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/iframe_BAMActivityWorkIt_ActivityEvent'))
CustomKeywords.'actions.Common.verifyTotalRecordCountFromPageSummary'(findTestObject('Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/table_ActivityEventState_Page_Summary'), 16)

'Click on a bar in Bar chart and verify count is matching in result grid'
CustomKeywords.'actions.Chart.clickSlice'(findTestObject('Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/Chart_ActivityEventState_Summary'), 12, GlobalVariable.ChartType['V_BAR'])
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/iframe_BAMActivityWorkIt_ActivityEvent'))
CustomKeywords.'actions.Common.verifyTotalRecordCountFromPageSummary'(findTestObject('Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/table_ActivityEventState_Page_Summary'), 3)