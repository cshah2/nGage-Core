import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
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
import utils.Consts

'Login Into Application'
CustomKeywords.'actions.Common.login'()

'Create Docuement'
CustomKeywords.'actions.Common.createDocument_ClosureAction'(Consts.SMOKE_MYWORK003_CUSTOMERNAME, Consts.SMOKE_MYWORK003_CUSTOMERDETAIL)

'Click on My Work link from left menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_iframe_105'))

'Select Activity Closure Action - Activity A'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('MY_WORK', 'Processes', 'Closure Action', 'Activity A')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Select Dashboard tab'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/tab_Dashboard'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/iframe_ASIGNEE'))

'Select New vs In Process tab'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/tab_New vs. In Process'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/iframe_NEWVSINPROC_iframe'))

'Verify Pie chart is displayed'
WebUI.verifyElementVisible(findTestObject('Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/Chart_NewvsInProcess_Summary'))
int slices = CustomKeywords.'actions.Chart.getNumberOfSlices'(findTestObject('Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/Chart_NewvsInProcess_Summary'), GlobalVariable.ChartType['PIE'])
WebUI.verifyGreaterThan(slices, 0)

'Verify tool tip is displayed on performing mouse over on pie slice'
CustomKeywords.'actions.Chart.mousOverOnSlice'(findTestObject('Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/Chart_NewvsInProcess_Summary'), 1, GlobalVariable.ChartType['PIE'])
WebUI.verifyElementVisible(findTestObject('Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/chartToolTip_NewVsInProcess'))

'Click on Slice 1'
CustomKeywords.'actions.Chart.clickSlice'(findTestObject('Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/Chart_NewvsInProcess_Summary'), 1, GlobalVariable.ChartType['PIE'])
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/iframe_BAMActivityWorkIt_NewVsInProcess'))

'Verify table is displayed'
WebUI.verifyElementVisible(findTestObject('Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/table_NewVsInProcess_WorkItems'))
int rowCount = CustomKeywords.'actions.Table.getRowsCount'(findTestObject('Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/table_NewVsInProcess_WorkItems'))
WebUI.verifyGreaterThan(rowCount, 0)

WebUI.refresh()
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Click on My Work link from left menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_iframe_105'))

'Select Activity Closure Action - Activity A'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('MY_WORK', 'Processes', 'Closure Action', 'Activity A')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Select Dashboard tab'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/tab_Dashboard'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/iframe_ASIGNEE'))

'Select New vs In Process tab'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/tab_New vs. In Process'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/iframe_NEWVSINPROC_iframe'))

'Verify Bar chart is displayed'
WebUI.verifyElementVisible(findTestObject('Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/Chart_NewvsInProcess_SLAStatusView'))
slices = CustomKeywords.'actions.Chart.getNumberOfSlices'(findTestObject('Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/Chart_NewvsInProcess_SLAStatusView'), GlobalVariable.ChartType['V_BAR'])
WebUI.verifyGreaterThan(slices, 0)

'Verify tool tip is displayed on performing mouse over on bar chart'
CustomKeywords.'actions.Chart.mousOverOnSlice'(findTestObject('Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/Chart_NewvsInProcess_SLAStatusView'), 4, GlobalVariable.ChartType['V_BAR'])
WebUI.verifyElementVisible(findTestObject('Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/chartToolTip_NewVsInProcess'))

'Click on Bar'
CustomKeywords.'actions.Chart.clickSlice'(findTestObject('Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/Chart_NewvsInProcess_SLAStatusView'), 4, GlobalVariable.ChartType['V_BAR'])
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/iframe_BAMActivityWorkIt_NewVsInProcess'))

'Verify table is displayed'
WebUI.verifyElementVisible(findTestObject('Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/table_NewVsInProcess_WorkItems'))
rowCount = CustomKeywords.'actions.Table.getRowsCount'(findTestObject('Page_nGage_Dashboard/My_Work/TAB_Dashboard_Obj/table_NewVsInProcess_WorkItems'))
WebUI.verifyGreaterThan(rowCount, 0)