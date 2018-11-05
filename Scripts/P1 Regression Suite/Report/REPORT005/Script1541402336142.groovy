import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import javax.persistence.criteria.CriteriaBuilder

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
import utils.DateUtil

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

'Check on New button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_ScheduleReport/btn_CreateNew'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_ScheduleReport/iframe_ScheduleReportTab'))

'Verify Schedule ID value is set to <New>'
WebUI.verifyElementText(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_ScheduleReport/label_ScheduleID'), '<New>')

String scheduleName = 'AUTO_SCHEDULE_NAME_'+DateUtil.getCurrentDateTime()
'Enter ScheduleName'
WebUI.setText(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_ScheduleReport/input_ScheduleName'), scheduleName)

'Select Filter Type'
WebUI.check(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_ScheduleReport/radio_FilterType_Standard'))

'Select Schedule frequency'
WebUI.check(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_ScheduleReport/radio_ScheduleFrequency_Daily'))

'Click on Save'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_ScheduleReport/btn_UpdateSave'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_ScheduleReport/iframe_ScheduleReportTab'))

'Click on ID column header to sort record by Descending'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_ScheduleReport/tableHeader_ID'))

'Verify name of the first record'
CustomKeywords.'actions.Table.verifyCellContainsValue'(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_ScheduleReport/table_ScheduleReport_Data'), 1, 2, scheduleName)

'Click First record in table'
CustomKeywords.'actions.Table.clickCell'(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_ScheduleReport/table_ScheduleReport_Data'), 1, 2)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_ScheduleReport/iframe_ScheduleReportTab'))

'Verify Schedule name input field contains proper value'
WebUI.verifyElementAttributeValue(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_ScheduleReport/input_ScheduleName'), 'value', scheduleName, GlobalVariable.G_LongTimeout)

'Go to Standard Filter tab'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_StandardFilter/tab_StandardFilter'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_StandardFilter/iframe_StandardFilterTab'))

'Verify Filter table is Empty'
CustomKeywords.'actions.Table.verifyRecordsCount'(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_StandardFilter/table_Filter'), 0)
//WebUI.verifyElementNotPresent(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_StandardFilter/table_Filter'), GlobalVariable.G_LongTimeout)

//Add New Filter
'Click on New Report Filter'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_StandardFilter/btn_NewReportFilter'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_StandardFilter/iframe_StandardFilterTab'))

String FilterName = 'AUTO_FILTERNAME_'+DateUtil.getCurrentDateTime()
'Enter FilterName'
WebUI.setText(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_StandardFilter/input_FilterName'), FilterName)

'Click on Save button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_StandardFilter/btn_UpdateSave'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_StandardFilter/iframe_StandardFilterTab'))

'Verify success message'
WebUI.verifyElementText(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_StandardFilter/lablel_SuccessMessage'), 'Request saved successfully.')

'Verify Filtername table contains 1 record'
CustomKeywords.'actions.Table.verifyRecordsCount'(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_StandardFilter/table_Filter'), 1)

'Verify Filtername in table'
CustomKeywords.'actions.Table.verifyCellContainsValue'(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_StandardFilter/table_Filter'), 1, 2, FilterName)

'Click First record in table'
CustomKeywords.'actions.Table.clickCell'(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_StandardFilter/table_Filter'), 1, 2)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_StandardFilter/iframe_StandardFilterTab'))

'Verify Filter Criteria table is Emptry'
//WebUI.verifyElementNotPresent(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_StandardFilter/table_FilterCriteria'), GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Table.verifyRecordsCount'(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_StandardFilter/table_FilterCriteria'), 0)

//Clear Filter Criteria
'Select Field in filter criteria'
WebUI.selectOptionByLabel(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_StandardFilter/select_FilterCriteria_Field'), 'User Name', false)

'Select Operator in filter criteria'
WebUI.selectOptionByLabel(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_StandardFilter/select_FilterCriteria_Operator'), 'Like', false)

'Enter Value in filter criteria'
WebUI.setText(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_StandardFilter/input_FilterCriteria_Values'), 'abc')

'Click on clear button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_StandardFilter/btn_FilterCriteria_Clear'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_StandardFilter/iframe_StandardFilterTab'))

'Verify Field in filter criteria is reset'
WebUI.verifyOptionSelectedByLabel(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_StandardFilter/select_FilterCriteria_Field'), 'Select Field', false, GlobalVariable.G_LongTimeout)

'Verify Operator in filter criteria is reset'
WebUI.verifyOptionSelectedByLabel(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_StandardFilter/select_FilterCriteria_Operator'), 'Select Operator', false, GlobalVariable.G_LongTimeout)

'Verify Value in filter criteria is reset'
WebUI.verifyElementAttributeValue(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_StandardFilter/input_FilterCriteria_Values'), 'value', '', GlobalVariable.G_LongTimeout)

//Add Filter Criteria
'Select Field in filter criteria'
WebUI.selectOptionByLabel(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_StandardFilter/select_FilterCriteria_Field'), 'User Name', false)

'Select Operator in filter criteria'
WebUI.selectOptionByLabel(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_StandardFilter/select_FilterCriteria_Operator'), 'Like', false)

'Enter Value in filter criteria'
WebUI.setText(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_StandardFilter/input_FilterCriteria_Values'), 'abc')

'Click on Add button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_StandardFilter/btn_FilterCriteria_AddUpdate'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_StandardFilter/iframe_StandardFilterTab'))

'Click on Update/Save button on Filter'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_StandardFilter/btn_UpdateSave'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_StandardFilter/iframe_StandardFilterTab'))

'Verify Success message'
WebUI.verifyElementText(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_StandardFilter/lablel_SuccessMessage'), 'Request saved successfully.')

'Click First record in table'
CustomKeywords.'actions.Table.clickCell'(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_StandardFilter/table_Filter'), 1, 2)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_StandardFilter/iframe_StandardFilterTab'))

'Verify Filter Criteria table contains 1 record'
CustomKeywords.'actions.Table.verifyRecordsCount'(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_StandardFilter/table_FilterCriteria'), 1)

'Verify Field name in Filter criteria table'
CustomKeywords.'actions.Table.verifyCellContainsValue'(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_StandardFilter/table_FilterCriteria'), 1, 2, 'User Name')

'Verify Field operator in Filter criteria table'
CustomKeywords.'actions.Table.verifyCellContainsValue'(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_StandardFilter/table_FilterCriteria'), 1, 4, 'Like')

'Verify Value in Filter criteria table'
CustomKeywords.'actions.Table.verifyCellContainsValue'(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_StandardFilter/table_FilterCriteria'), 1, 5, 'abc')

//Update Filter Criteria
'Click on First Record in filter criteria table'
CustomKeywords.'actions.Table.clickCell'(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_StandardFilter/table_FilterCriteria'), 1, 2)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_StandardFilter/iframe_StandardFilterTab'))

'Verify Field in filter criteria contains proper text'
WebUI.verifyOptionSelectedByLabel(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_StandardFilter/select_FilterCriteria_Field'), 'User Name', false, GlobalVariable.G_LongTimeout)

'Verify Operator in filter criteria contains proper text'
WebUI.verifyOptionSelectedByLabel(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_StandardFilter/select_FilterCriteria_Operator'), 'Like', false, GlobalVariable.G_LongTimeout)

'Verify Value in filter criteria contains proper text'
WebUI.verifyElementAttributeValue(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_StandardFilter/input_FilterCriteria_Values'), 'value', 'abc', GlobalVariable.G_LongTimeout)

'Update Field in filter criteria'
WebUI.selectOptionByLabel(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_StandardFilter/select_FilterCriteria_Field'), 'Domain', false)

'Update Operator in filter criteria'
WebUI.selectOptionByLabel(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_StandardFilter/select_FilterCriteria_Operator'), 'BeginsWith', false)

'Update Value in filter criteria'
WebUI.setText(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_StandardFilter/input_FilterCriteria_Values'), 'pqr')

'Click on Add button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_StandardFilter/btn_FilterCriteria_AddUpdate'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_StandardFilter/iframe_StandardFilterTab'))

'Click on Update/Save button on Filter'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_StandardFilter/btn_UpdateSave'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_StandardFilter/iframe_StandardFilterTab'))

'Verify Success message'
WebUI.verifyElementText(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_StandardFilter/lablel_SuccessMessage'), 'Request saved successfully.')

'Click First record in table'
CustomKeywords.'actions.Table.clickCell'(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_StandardFilter/table_Filter'), 1, 2)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_StandardFilter/iframe_StandardFilterTab'))

'Verify Filter Criteria table contains 1 record'
CustomKeywords.'actions.Table.verifyRecordsCount'(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_StandardFilter/table_FilterCriteria'), 1)

'Verify Field name in Filter criteria table'
CustomKeywords.'actions.Table.verifyCellContainsValue'(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_StandardFilter/table_FilterCriteria'), 1, 2, 'Domain')

'Verify Field operator in Filter criteria table'
CustomKeywords.'actions.Table.verifyCellContainsValue'(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_StandardFilter/table_FilterCriteria'), 1, 4, 'BeginsWith')

'Verify Value in Filter criteria table'
CustomKeywords.'actions.Table.verifyCellContainsValue'(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_StandardFilter/table_FilterCriteria'), 1, 5, 'pqr')

//Delete Filter CriteriaBuilder
'Click on First Record in filter criteria table'
CustomKeywords.'actions.Table.clickCell'(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_StandardFilter/table_FilterCriteria'), 1, 2)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_StandardFilter/iframe_StandardFilterTab'))

'Verify Field in filter criteria contains proper text'
WebUI.verifyOptionSelectedByLabel(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_StandardFilter/select_FilterCriteria_Field'), 'Domain', false, GlobalVariable.G_LongTimeout)

'Verify Operator in filter criteria contains proper text'
WebUI.verifyOptionSelectedByLabel(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_StandardFilter/select_FilterCriteria_Operator'), 'BeginsWith', false, GlobalVariable.G_LongTimeout)

'Verify Value in filter criteria contains proper text'
WebUI.verifyElementAttributeValue(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_StandardFilter/input_FilterCriteria_Values'), 'value', 'pqr', GlobalVariable.G_LongTimeout)

'Click on Remove button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_StandardFilter/btn_FilterCriteria_Remove'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_StandardFilter/iframe_StandardFilterTab'))

'Verify Message on Prompt dialog'
WebUI.verifyElementText(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_StandardFilter/ConfirmationDialog - Message'), 'Are you sure you want to delete selected row?')

'Click on OK button on confirmation prompt'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_StandardFilter/ConfirmationDialog - Ok Button'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_StandardFilter/iframe_StandardFilterTab'))

'Click on Update/Save button on Filter'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_StandardFilter/btn_UpdateSave'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_StandardFilter/iframe_StandardFilterTab'))

'Verify Success message'
WebUI.verifyElementText(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_StandardFilter/lablel_SuccessMessage'), 'Request saved successfully.')

'Click First record in table'
CustomKeywords.'actions.Table.clickCell'(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_StandardFilter/table_Filter'), 1, 2)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_StandardFilter/iframe_StandardFilterTab'))

'Verify Filter Criteria table contains 0 record'
CustomKeywords.'actions.Table.verifyRecordsCount'(findTestObject('Page_nGage_Dashboard/Report/ScheduleReport/TAB_StandardFilter/table_FilterCriteria'), 0)
