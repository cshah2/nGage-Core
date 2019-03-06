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

'Navigate to Closure Action Menu and get the document count'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('My_Work', 'Processes', 'Closure Action', 'Activity A')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Get Record count in Activity A and Activity B'
int initialCount = CustomKeywords.'actions.MenuBar.getRecordCountInActivity'('My_Work', 'Processes', 'Closure Action', 'Activity A')
int initialCountActivityB = CustomKeywords.'actions.MenuBar.getRecordCountInActivity'('My_Work', 'Processes', 'Closure Action', 'Activity B')

'Verify record count in table matches with activity'
CustomKeywords.'actions.Common.verifyTotalRecordCountFromPageSummary'(findTestObject('Page_nGage_Dashboard/My_Work/table_pagination_summary'), initialCount)

'Create Closure Action document'
CustomKeywords.'actions.Common.createDocument_ClosureAction'('TestName', 'TestDescription')

WebUI.refresh()

'Click on My Work link from left menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_iframe_105'))

'Navigate to Closure Action Menu and get the document count'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('My_Work', 'Processes', 'Closure Action', 'Activity A')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Get Record count in activity'
int newCount = CustomKeywords.'actions.MenuBar.getRecordCountInActivity'('My_Work', 'Processes', 'Closure Action', 'Activity A')

'Verify record count in table matches with activity'
CustomKeywords.'actions.Common.verifyTotalRecordCountFromPageSummary'(findTestObject('Page_nGage_Dashboard/My_Work/table_pagination_summary'), newCount)

WebUI.verifyEqual(initialCount + 1, newCount)

'Sort the table to click on new doc'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'Doc ID')
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'Doc ID')

'Click and open the record from Table'
CustomKeywords.'actions.Table.clickCell'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'), 1, 5)

'Switch to WMI window'
WebUI.switchToWindowIndex(1)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Click on Customer Information'
WebUI.click(findTestObject('Page_WMI/Closure Action/span_Customer Information'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_WMI/Closure Action/iframe_ContentPlaceHolder1_iPa'))

'Click on Route to another Activity B from Customer Actions menu'
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_WMI/Closure Action/button_CustomerActions'), GlobalVariable.G_LongTimeout)
WebUI.mouseOver(findTestObject('Object Repository/Page_WMI/Closure Action/button_CustomerActions'))

'Click on Route to Activity B'
WebUI.click(findTestObject('Object Repository/Page_WMI/Closure Action/action_RouteToActivityB'))

'Switch to main window'
WebUI.switchToWindowIndex(0)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Refresh until record count increases'
CustomKeywords.'actions.MenuBar.refreshActivityUntilRecordCountIncreases'(initialCountActivityB, GlobalVariable.G_LongTimeout, 'My_Work', 'Processes', 'Closure Action', 'Activity B')

'Verify the count for Activity B as it should increase by 1'
int newCountActivityB = CustomKeywords.'actions.MenuBar.getRecordCountInActivity'('My_Work', 'Processes', 'Closure Action', 'Activity B')

WebUI.verifyEqual(initialCountActivityB + 1, newCountActivityB)