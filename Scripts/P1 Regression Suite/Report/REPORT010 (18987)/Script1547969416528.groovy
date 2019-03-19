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
import utils.DateUtil
import static utils.Consts.*

'Login into application'
CustomKeywords.'actions.Common.login'()

'Open Reports Menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/Reports Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Report/IFrame_108'))

'Right click on report'
CustomKeywords.'actions.MenuBar.rightClickTreeMenu'('REPORT', 'New Group', 'new catagory', 'BASE REPORT')
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Select option COPY on context menu'
CustomKeywords.'actions.ContextMenu.clickOption'(findTestObject('Page_nGage_Dashboard/contextMenuOptions'), 'Copy')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Report/CopyReport/iframe_Copy_Report'))

'Verify Header on Copy Report page'
WebUI.verifyMatch(WebUI.getText(findTestObject('Page_nGage_Dashboard/Report/CopyReport/header_Copy Report')).trim(), '.*Copy Report.*', true)

'Verify Current Report name field value'
WebUI.verifyMatch(WebUI.getText(findTestObject('Page_nGage_Dashboard/Report/CopyReport/label_CurrentReportName')).trim(), '.*BASE REPORT.*', true)

COPY_REPORT_NAME = 'COPY:'+DateUtil.getCurrentDateTime('yyyyMMdd:HHmmss')

'Provide new report name'
WebUI.setText(findTestObject('Page_nGage_Dashboard/Report/CopyReport/input_NewReportName'), COPY_REPORT_NAME)

'Click on Save button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/CopyReport/button_Save'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Report/CopyReport/iframe_Copy_Report'))

'Verify success message'
WebUI.verifyMatch(WebUI.getText(findTestObject('Page_nGage_Dashboard/Report/CopyReport/label_SuccessMessage')).trim(), COPY_REPORT_NAME+' has been created successfully.', false)

'Verify new report is now displayed in the tree'
CustomKeywords.'actions.Report.verifyReportIsPresentUnderSubGroup'('New Group', 'new catagory', COPY_REPORT_NAME)