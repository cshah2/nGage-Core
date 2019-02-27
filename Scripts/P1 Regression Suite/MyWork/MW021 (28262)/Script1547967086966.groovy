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

'Click on My Work link from left menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_iframe_105'))

'Click Tree Menu'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('MY_WORK', 'Processes','Event for required field','User activity', P1_MW_DOC7_TEXT)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

'keep track of activity count before refresh'
int activityCount_Before=CustomKeywords.'actions.MenuBar.getRecordCountInActivity'('MY_WORK', 'Processes','Event for required field','User activity', P1_MW_DOC7_TEXT)

'Create new document with same value in text field'
CustomKeywords.'actions.Common.createDocument_EventForRequiredField'(P1_MW_DOC7_DROPDOWN, P1_MW_DOC7_TEXT, P1_MW_DOC7_DATE)

'Right click on Tree'
CustomKeywords.'actions.MenuBar.rightClickTreeMenu'('MY_WORK', 'Processes','Event for required field','User activity')
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Click on Refresh option'
CustomKeywords.'actions.ContextMenu.clickOption'(findTestObject('Page_nGage_Dashboard/contextMenuOptions'), 'Refresh')
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

'keep track of activity count before refresh'
int activityCount_After=CustomKeywords.'actions.MenuBar.getRecordCountInActivity'('MY_WORK', 'Processes','Event for required field','User activity', P1_MW_DOC7_TEXT)

'Verify record count has increased'
WebUI.verifyEqual(activityCount_After, activityCount_Before+1)
