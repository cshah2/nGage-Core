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

'Login Into Application'
CustomKeywords.'actions.Common.login'()

'Create Document'
if(!FLAG_P1_MW_DOC7) {
	CustomKeywords.'actions.Common.createDocument_EventForRequiredField'(P1_MW_DOC7_DROPDOWN, P1_MW_DOC7_TEXT, P1_MW_DOC7_DATE)
	FLAG_P1_MW_DOC7 = true
}

'Create Document'
if(!FLAG_P1_MW_DOC8) {
	CustomKeywords.'actions.Common.createDocument_EventForRequiredField'(P1_MW_DOC8_DROPDOWN, P1_MW_DOC8_TEXT, P1_MW_DOC8_DATE)
	FLAG_P1_MW_DOC8 = true
}

'Click on My Work link from left menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_iframe_105'))

'Verify tree folder is correct'
CustomKeywords.'actions.MenuBar.verifySubMenuPresent'('MY_WORK', P1_MW_DOC7_TEXT, 'Processes','Event for required field','User activity')
CustomKeywords.'actions.MenuBar.verifySubMenuPresent'('MY_WORK', P1_MW_DOC7_DROPDOWN, 'Processes','Event for required field','User activity', P1_MW_DOC7_TEXT)

'Click Tree Menu'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('MY_WORK', 'Processes','Event for required field','User activity', P1_MW_DOC7_TEXT, P1_MW_DOC7_DROPDOWN)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

'keep track of activity count before refresh'
int activityCount1=CustomKeywords.'actions.MenuBar.getRecordCountInActivity'('MY_WORK', 'Processes','Event for required field','User activity', P1_MW_DOC7_TEXT, P1_MW_DOC7_DROPDOWN)
CustomKeywords.'actions.Common.verifyTotalRecordCountFromPageSummary'(findTestObject('Page_nGage_Dashboard/My_Work/table_pagination_summary'), activityCount1)

'Verify tree folder is correct'
CustomKeywords.'actions.MenuBar.verifySubMenuPresent'('MY_WORK', P1_MW_DOC8_TEXT, 'Processes','Event for required field','User activity')
CustomKeywords.'actions.MenuBar.verifySubMenuPresent'('MY_WORK', P1_MW_DOC8_DROPDOWN, 'Processes','Event for required field','User activity', P1_MW_DOC8_TEXT)

'Click Tree Menu'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('MY_WORK', 'Processes','Event for required field','User activity', P1_MW_DOC8_TEXT, P1_MW_DOC8_DROPDOWN)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

'keep track of activity count before refresh'
int activityCount2=CustomKeywords.'actions.MenuBar.getRecordCountInActivity'('MY_WORK', 'Processes','Event for required field','User activity', P1_MW_DOC8_TEXT, P1_MW_DOC8_DROPDOWN)
CustomKeywords.'actions.Common.verifyTotalRecordCountFromPageSummary'(findTestObject('Page_nGage_Dashboard/My_Work/table_pagination_summary'), activityCount2)