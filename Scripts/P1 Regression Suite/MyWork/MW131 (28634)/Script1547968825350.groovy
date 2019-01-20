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
import utils.Consts

'Login Into Application'
CustomKeywords.'actions.Common.login'()

'Create a new BovDocTwoRow Document'
WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'('Datetimerangerequired', 'Datetimerangerequired')
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

'Switch to new Window'
WebUI.switchToWindowTitle('Business Model WMI')
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Enter date value using calender picker'
CustomKeywords.'actions.Calender.selectDate'(Consts.P1_MW083_STARTDATE_DATE, Consts.P1_MW083_STARTDATE_MONTH, Consts.P1_MW083_STARTDATE_YEAR, findTestObject('Page_WMI_NEW/MyWork_DateTime/calender_Start test date'))

'Verify date value'
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI_NEW/MyWork_DateTime/input_Start test date'), 'value', Consts.P1_MW083_STARTDATE, GlobalVariable.G_LongTimeout)

'Enter date time value in calender picker'
CustomKeywords.'actions.Calender.selectDateTime'(Consts.P1_MW083_STARTDATETIME_DATE, Consts.P1_MW083_STARTDATETIME_MONTH, Consts.P1_MW083_STARTDATETIME_YEAR, findTestObject('Page_WMI_NEW/MyWork_DateTime/calender_Start test datetime'))

'Verify date time value'
String datetime = WebUI.getAttribute(findTestObject('Page_WMI_NEW/MyWork_DateTime/input_Start test datetime'), 'value').toUpperCase()
WebUI.verifyMatch(datetime, Consts.P1_MW083_STARTDATETIME, false)
