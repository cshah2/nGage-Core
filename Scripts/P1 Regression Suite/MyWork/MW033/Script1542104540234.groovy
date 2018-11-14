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

'click on option Activity B in the grid'
CustomKeywords.'actions.Table.clickCell'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Charts/table_SingleProcess'), 2, 2)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Charts/iframe_iframe_105'))

'verify process summary grid fields value '
WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Charts/label_ProcessSummary ActivityID')), '.*100028.*', true)
WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Charts/label_ProcessSummary ActivityName')), '.*Activity B.*', true)
WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Charts/textarea_ProcessSummary ActivityDesc')), '.*Activity B.*', true)
WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Charts/label_ProcessSummary Duration')), '.*5 DAYS.*', true)
WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Charts/label_ProcessSummary AuditEnable')), '.*Enabled.*', true)



