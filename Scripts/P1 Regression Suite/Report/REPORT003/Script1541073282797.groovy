import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.junit.After

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

'Login into application'
CustomKeywords.'actions.Common.login'()

'Open Reports Menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/Reports Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Report/IFrame_108'))

'Expand Security Management section'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/Expand_Security Management'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Perform Right click over User Listing Report'
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/Report/Report_User Listing'), GlobalVariable.G_LongTimeout)
WebUI.rightClick(findTestObject('Page_nGage_Dashboard/Report/Report_User Listing'))

'Verify Following options are available in right-click'
CustomKeywords.'actions.ContextMenu.verifyAllOptions'(findTestObject('Page_nGage_Dashboard/contextMenuOptions'), 'Rename', 'Copy', 'Delete', 'Schedule')

'Click Schedule option from ContextMenu'
CustomKeywords.'actions.ContextMenu.clickOption'(findTestObject('Page_nGage_Dashboard/contextMenuOptions'), 'Schedule')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_ScheduleReport/iframe_ScheduleReportTab'))

'Verify Name of filter in first row'
CustomKeywords.'actions.Table.verifyCellContainsValue'(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_ScheduleReport/table_ScheduleReport_Data'), 1, 2, 'standard filter')

'Verify Filter Type of filter in first row'
CustomKeywords.'actions.Table.verifyCellContainsValue'(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_ScheduleReport/table_ScheduleReport_Data'), 1, 4, 'Standard')

'Click on  any cell of first row'
CustomKeywords.'actions.Table.clickCell'(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_ScheduleReport/table_ScheduleReport_Data'), 1, 1)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_ScheduleReport/iframe_ScheduleReportTab'))

'Verify name is displayed in Schedule Name input field'
WebUI.verifyElementAttributeValue(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_ScheduleReport/input_ScheduleName'), 'value', 'standard filter', GlobalVariable.G_LongTimeout)

'Verify Standard filter radio button is selected'
WebUI.verifyElementChecked(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_ScheduleReport/radio_FilterType_Standard'), GlobalVariable.G_LongTimeout)

'Verify Standard filter radio button is disabled'
WebUI.verifyElementNotClickable(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_ScheduleReport/radio_FilterType_Standard'))

'Verify Advance filter radio button is not selected'
WebUI.verifyElementNotChecked(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_ScheduleReport/radio_FilterType_Advance'), GlobalVariable.G_LongTimeout)

'Verify Advance filter radio button is not disabled'
WebUI.verifyElementNotClickable(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_ScheduleReport/radio_FilterType_Advance'))

'Verify Schedule Report tab is enabled'
CustomKeywords.'actions.Common.verifyElementAttributeValueNotContains'(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_ScheduleReport/tab_ScheduleReport'),'class','tabdisable')

'Verify Standard Filter tab is enabled'
CustomKeywords.'actions.Common.verifyElementAttributeValueNotContains'(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_StandardFilter/tab_StandardFilter'), 'class', 'tabdisable')

'Verify Advance Filter tab is disabled'
CustomKeywords.'actions.Common.verifyElementAttributeValueContains'(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_AdvanceFilter/tab_AdvanceFilter'), 'class', 'tabdisable')

'Verify Storage tab is enabled'
CustomKeywords.'actions.Common.verifyElementAttributeValueNotContains'(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_Storage/tab_Storage'), 'class', 'tabdisable')

'Verify Distribution tab is enabled'
CustomKeywords.'actions.Common.verifyElementAttributeValueNotContains'(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_Distribution/tab_Distribution'), 'class', 'tabdisable')
