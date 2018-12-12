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

'Create a new Document in DateTimeRequired activity'
CustomKeywords.'actions.Common.createDocument_MyWorkDateTime'('Datetimerangerequired','Datetimerangerequired','','01012025','01012018','01-01-2018 12:00:00 pm','Test')

'Click on My Work link from left menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'expand datetime range required processes'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/process_DatetimeRangeRequired/icon_Expand_DateTimeRangeRequired'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'right click on Activity datetimerangerequired'
WebUI.rightClick(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/process_DatetimeRangeRequired/a_Activity_DateTimeRangeRequired'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

///
'click on (option)foldering configuration'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/LoanInteractive_MyWork/a_Foldering Configuration'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'select drpdown options'
WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Folder_Configuration/Level1_FieldAssigned'),'End test datetime',false)
WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Folder_Configuration/Level1_Sorting'), 'Asc by Field',false)

'click submit button'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Folder_Configuration/button_Save'))

'click close button'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Folder_Configuration/button_Close'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'right click on Activity datetimerangerequired'
WebUI.rightClick(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/process_DatetimeRangeRequired/a_Activity_DateTimeRangeRequired'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'click on refresh'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/contextMenu_Refresh'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'expand till empty and click on created document submenu'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('My_Work','Processes','Datetime range required','Date time range required','01/01/2018')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))

'expand search bar'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/h3_Search Bar'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))

'enter search value'
WebUI.setText(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/process_DateTimeRequired/input_StartDateTimeRequired'), '01012018')
WebUI.setText(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/process_DatetimeRangeRequired/input_EndTestDateTime_From'),'01-01-2015 12:00:00 pm')
WebUI.setText(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/process_DatetimeRangeRequired/input_EndTestDateTime_To'), '01-01-2019 12:00:00 pm')

'click on search button'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/btn_Search'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))

int ColumnPosition_EndTestDatetime= CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'),'End test datetime')
println ColumnPosition_EndTestDatetime

'verify search result '
CustomKeywords.'actions.Table.verifyRecordsWithinDateRange'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'), ColumnPosition_EndTestDatetime, '01-01-2015 12:00:00 pm', '01-01-2019 12:00:00 pm')

'right click on Activity datetimerangerequired'
WebUI.rightClick(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/process_DatetimeRangeRequired/a_Activity_DateTimeRangeRequired'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'click on (option)foldering configuration'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/LoanInteractive_MyWork/a_Foldering Configuration'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'click restore default button'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Folder_Configuration/button_Restore Default'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'click submit button'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Folder_Configuration/button_Save'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'click close button'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Folder_Configuration/button_Close'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)