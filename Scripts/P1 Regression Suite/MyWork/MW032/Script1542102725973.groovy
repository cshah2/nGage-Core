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

'click on closure action process link'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/a_Closure Action Process'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Charts/iframe_iframe_105'))

'click on bar graph'
CustomKeywords.'actions.Chart.clickSlice'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Charts/Chart_SingleProcess_SLAStatusView'), 3, GlobalVariable.ChartType['V_BAR'])

'verify jquery grid visibility'
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Charts/iframe_iframe_105'))
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Charts/Table_JQGrid WorkItems'), 10)

'record P_ID of first process in grid before refresh'
int processID_before=Integer.parseInt((CustomKeywords.'actions.Table.getCellText'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Charts/Table_JQGrid WorkItems'),1,1)).toString())
println CustomKeywords.'actions.Table.getCellText'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Charts/Table_JQGrid WorkItems'), 1, 1).toString()

'sort grid recore in descending order'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Charts/div_JQueryWorkItem_Process ID'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Charts/iframe_MyIframe'))

'verify sorted grid records'
WebUI.verifyNotMatch(processID_before.toString(), CustomKeywords.'actions.Table.getCellText'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Charts/Table_JQGrid WorkItems'),1,1), false)

'click on refresh grid option'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Charts/td_JQGridWorkItems_btnRefresh'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Charts/iframe_MyIframe'))

println CustomKeywords.'actions.Table.getCellText'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Charts/Table_JQGrid WorkItems'), 1, 1).toString()

''
WebUI.verifyMatch(processID_before.toString(), CustomKeywords.'actions.Table.getCellText'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Charts/Table_JQGrid WorkItems'),1,1), false)
