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

'Create Bulk document'
CustomKeywords.'actions.Common.createBulkDocuments_ClosureAction'(35)

'Click on My Work link from left menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_iframe_105'))

'Click on Tree Menu'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('MY_WORK', 'Processes', 'Closure Action', 'Activity A')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

'click on toppager next T button'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/span_nextTTopPager'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

'click on toppager next T button'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/span_nextTTopPager'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Get Current page number'
int beforeCount=Integer.parseInt(WebUI.getAttribute(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/table_page_number_input'), 'value'))

'Verify current page number is 3'
WebUI.verifyEqual(beforeCount, 3)

'click on toppager previous T button'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/span_prevTTopPager'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

int afterCount=Integer.parseInt(WebUI.getAttribute(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/table_page_number_input'), 'value'))

'Verify current page number is 2'
WebUI.verifyEqual(afterCount, 2)
