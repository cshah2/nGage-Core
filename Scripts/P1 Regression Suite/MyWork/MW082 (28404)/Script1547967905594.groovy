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
import utils.DateUtil

'Login Into Application'
CustomKeywords.'actions.Common.login'()

'Create two document in DateTimeRequired activity'
CustomKeywords.'actions.Common.createDocument_MyWorkDateTime'(Consts.DC_DATERANGEREQUIRED, Consts.DT_DATERANGEREQUIRED, Consts.P1_MW084_STARTDATE, Consts.P1_MW084_ENDDATE, Consts.P1_MW084_STARTDATETIME, Consts.P1_MW084_ENDDATETIME, '')
CustomKeywords.'actions.Common.createDocument_MyWorkDateTime'(Consts.DC_DATETIMERANGEREQUIRED, Consts.DT_DATETIMERANGEREQUIRED, Consts.P1_MW084_STARTDATE, Consts.P1_MW084_ENDDATE, Consts.P1_MW084_STARTDATETIME, Consts.P1_MW084_ENDDATETIME, '')

'Click on My Work link from left menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

//Date Range
'Expand Processes and Verify Foldered Document Displayed'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('My_Work','Processes','DateRange required','Date range required')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Click on Search bar to open'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/h3_Search Bar'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Click On Search Button'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/btn_Search'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Verify Required message is visible against both From and To Date field'
WebUI.verifyElementVisible(findTestObject('Page_nGage_Dashboard/My_Work/Process_DateRangeRequired/span_DateRangeRequired_From_required'))
WebUI.verifyElementVisible(findTestObject('Page_nGage_Dashboard/My_Work/Process_DateRangeRequired/span_DateRangeRequired_To_Required'))


//Date time Range
'Expand Processes and Verify Foldered Document Displayed'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('My_Work','Processes','Datetime range required','Date time range required')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Click on Search bar to open'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/h3_Search Bar'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Click On Search Button'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/btn_Search'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Verify Required message is visible against both From and To Date field'
WebUI.verifyElementVisible(findTestObject('Page_nGage_Dashboard/My_Work/process_DatetimeRangeRequired/span_StartDateTime_From_Required'))
WebUI.verifyElementVisible(findTestObject('Page_nGage_Dashboard/My_Work/process_DatetimeRangeRequired/span_StartDateTime_To_Required'))