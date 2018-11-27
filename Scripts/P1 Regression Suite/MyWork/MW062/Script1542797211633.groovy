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
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/icon_Expand_Closure Actions'), GlobalVariable.G_LongTimeout)

'Expand closure action'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/icon_Expand_Closure Actions'))

'Click on Activity A'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/a_Activity A'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))


'verify grid records present'
CustomKeywords.'actions.Common.verifyRecordCountInActivityMatchesWithResultGrid'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/a_Activity A'),findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/div_PageCount'))

'Open Work Item'
CustomKeywords.'actions.Table.clickCell'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'),1,4)

WebUI.delay(10)
WebUI.switchToWindowIndex(1)

'Verify Closure Action is not Present'
WebUI.verifyElementNotPresent( findTestObject('Object Repository/Page_WMI/Route Advance/span_ClosureAction_RouteAdvance'), 5)

'Click on Customer Information'
WebUI.click(findTestObject('Object Repository/Page_WMI/Closure Action/span_Customer Information'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Verify field Customer Name Present'
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_WMI_NEW/Closure_Action/input_Customer Name'), 5)