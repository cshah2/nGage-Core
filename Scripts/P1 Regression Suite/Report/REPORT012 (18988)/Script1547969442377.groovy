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
CustomKeywords.'actions.MenuBar.rightClickTreeMenu'('REPORT', 'New Group', 'new catagory', COPY_REPORT_NAME)
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Select option DELETE on context menu'
CustomKeywords.'actions.ContextMenu.clickOption'(findTestObject('Page_nGage_Dashboard/contextMenuOptions'), 'Delete')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Report/DeleteReport/iframe_Delete Report'))

'Verify Header on Delete Report page'
WebUI.verifyMatch(WebUI.getText(findTestObject('Page_nGage_Dashboard/Report/DeleteReport/header_Delete Report')).trim(), 'Delete Report', false)

'Verify Current Report name field value'
WebUI.verifyMatch(WebUI.getText(findTestObject('Page_nGage_Dashboard/Report/DeleteReport/label_ReportName')).trim(), COPY_REPORT_NAME, false)

'Click on Delete button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/DeleteReport/button_Delete'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Report/DeleteReport/iframe_Delete Report'))

'Verify success message'
WebUI.verifyMatch(WebUI.getText(findTestObject('Page_nGage_Dashboard/Report/DeleteReport/label_SuccessMessage')).trim(), 'Report Deleted Successfully.', false)

'Verify Report is not displayed in tree'
CustomKeywords.'actions.Report.verifyReportIsNotPresentUnderSubGroup'('New Group', 'new catagory', COPY_REPORT_NAME)