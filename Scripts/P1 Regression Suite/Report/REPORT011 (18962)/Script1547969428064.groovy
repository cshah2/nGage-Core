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

'Verify new report is now displayed in the tree'
CustomKeywords.'actions.Report.verifyReportIsPresentUnderSubGroup'('New Group', 'new catagory', COPY_REPORT_NAME)

'Right click on report'
CustomKeywords.'actions.Report.rightClickReport'('New Group', 'new catagory', COPY_REPORT_NAME)
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Select option RENAME on context menu'
CustomKeywords.'actions.ContextMenu.clickOption'(findTestObject('Page_nGage_Dashboard/contextMenuOptions'), 'Rename')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Report/RenameReport/iframe_Rename Report'))

'Verify Header on Rename Report page'
WebUI.verifyMatch(WebUI.getText(findTestObject('Page_nGage_Dashboard/Report/RenameReport/header_Rename Report')).trim(), 'Rename Report', false)

'Verify Current Report name field value'
WebUI.verifyMatch(WebUI.getText(findTestObject('Page_nGage_Dashboard/Report/RenameReport/label_CurrentReportName')).trim(), COPY_REPORT_NAME, false)

'Verify Current Report Type is public'
WebUI.verifyMatch(WebUI.getText(findTestObject('Page_nGage_Dashboard/Report/RenameReport/label_CurrentReportType')).trim(), 'Public', false)

String oldName = COPY_REPORT_NAME
COPY_REPORT_NAME = 'RENAME:'+DateUtil.getCurrentDateTime('yyyyMMdd:HHmmss')

'Enter new Report name'
WebUI.setText(findTestObject('Page_nGage_Dashboard/Report/RenameReport/input_Rename To'), COPY_REPORT_NAME)

'Click on Save button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/RenameReport/button_Save'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Report/RenameReport/iframe_Rename Report'))

'Verify success message'
WebUI.verifyMatch(WebUI.getText(findTestObject('Page_nGage_Dashboard/Report/RenameReport/label_SuccessMessage')).trim(), 'Report Renamed successfully.', false)

'Verify new report is now displayed in the tree'
CustomKeywords.'actions.Report.verifyReportIsPresentUnderSubGroup'('New Group', 'new catagory', COPY_REPORT_NAME)

'Verify Report with old name is not present in tree'
CustomKeywords.'actions.Report.verifyReportIsNotPresentUnderSubGroup'('New Group', 'new catagory', oldName)