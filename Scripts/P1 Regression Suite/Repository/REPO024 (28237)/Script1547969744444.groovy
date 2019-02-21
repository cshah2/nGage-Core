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

'Create document is not present'
if(!FLAG_P1_REPO_DOC10) {
	CustomKeywords.'actions.Common.createDocument_RenderAllField'(P1_REPO_FIELD1_DOC10, P1_REPO_FIELD2_DOC10, '', '', P1_REPO_FIELD5_DOC10, '', '', '', '', '', '')
	FLAG_P1_REPO_DOC10 = true
}

'Expand Repository Menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/Repository/h3_Repository Menu'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Click Repository'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('REPO', 'Business Model', 'Business Model', 'Render All Field Types', 'Chintan Shah')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/BrowseResults Tab/iframe_BROWSETAB_iframe'))

'Get Activity Record counts'
int activityRecordCountBefore = CustomKeywords.'actions.MenuBar.getRecordCountInActivity'('REPO', 'Business Model', 'Business Model', 'Render All Field Types', 'Chintan Shah')

'Verify Record count in actvity matches with record count in grid'
if(activityRecordCountBefore > 500) {
	CustomKeywords.'actions.Common.verifyTotalRecordCountFromPageSummary'(findTestObject('Page_nGage_Dashboard/Repository/BrowseResults Tab/Table_PageResults'), 500)
}
else {
	CustomKeywords.'actions.Common.verifyTotalRecordCountFromPageSummary'(findTestObject('Page_nGage_Dashboard/Repository/BrowseResults Tab/Table_PageResults'), activityRecordCountBefore)
}

'Create another document render all fields'
CustomKeywords.'actions.Common.createDocument_RenderAllField'('20', 'AMirvankar', '', '', '', '', '', '', '', '', '')

'Right click on Render All Field Types Sub Menu'
CustomKeywords.'actions.MenuBar.rightClickTreeMenu'('REPO', 'Business Model', 'Business Model', 'Render All Field Types')
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.ContextMenu.clickOption'(findTestObject('Page_nGage_Dashboard/contextMenuOptions'), 'Refresh')
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Click Repository'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('REPO', 'Business Model', 'Business Model', 'Render All Field Types', 'Chintan Shah')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/BrowseResults Tab/iframe_BROWSETAB_iframe'))

'Get Activity Record counts'
int activityRecordCountAfter = CustomKeywords.'actions.MenuBar.getRecordCountInActivity'('REPO', 'Business Model', 'Business Model', 'Render All Field Types', 'Chintan Shah')

'Verify Record count in actvity matches with record count in grid'
if(activityRecordCountAfter > 500) {
	CustomKeywords.'actions.Common.verifyTotalRecordCountFromPageSummary'(findTestObject('Page_nGage_Dashboard/Repository/BrowseResults Tab/Table_PageResults'), 500)
}
else {
	CustomKeywords.'actions.Common.verifyTotalRecordCountFromPageSummary'(findTestObject('Page_nGage_Dashboard/Repository/BrowseResults Tab/Table_PageResults'), activityRecordCountAfter)
}

'Verify Before and After count'
WebUI.verifyEqual(activityRecordCountAfter, activityRecordCountBefore+1)