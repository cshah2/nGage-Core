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

'Expand Auto inport controlled batch process'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/icon_Expand_AutoImportControlledBatchProcess'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'click on Activity Batch Exception Partial'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/a_BatchExceptionPartial'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

'verify record count and activity count are same'
CustomKeywords.'actions.Common.verifyRecordCountMatchesInActivityAndGrid'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/a_BatchExceptionPartial'),findTestObject('Page_nGage_Dashboard/My_Work/table_pagination_summary'))

'verify page navigation of the grid.'
int activityCount=CustomKeywords.'actions.MenuBar.getRecordCountInActivity'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/a_BatchExceptionPartial'))
WebUI.verifyMatch('Showing 1 - 25 of '+activityCount.toString().trim(), WebUI.getText(findTestObject('Page_nGage_Dashboard/My_Work/table_pagination_summary')), false)