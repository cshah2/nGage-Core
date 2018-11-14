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

'expand postman process1'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/i_PostmanProcesses1'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'click on new process hold activity(link)'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/a_NewProcessHoldActivity'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_iframe_105'))
//CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

'click on toppager last T button'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/td_LastPageNavigation'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Verify Page number'
//println  WebUI.getText(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/span_DisplayedTotalCount'))
WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/span_DisplayedTotalCount')),WebUI.getAttribute(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/table_page_number_input'), 'value') , false)

'Verify element(span_prev,span_first) is not clickable'
CustomKeywords.'actions.Common.verifyElementAttributeValueContains'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/td_LastPageNavigation'), 'class', 'ui-state-disabled')
//WebUI.verifyElementClickable(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/span_firstTTopPager'))
//WebUI.verifyElementClickable(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/span_prevTTopPager'))
CustomKeywords.'actions.Common.verifyElementAttributeValueContains'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/span_nextTTopPager'), 'class', 'ui-state-disabled')