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

'Expand Repository Menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/Repository/h3_Repository Menu'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

'Click Repository'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('REPO', 'Business Model', 'Business Model', 'BM Ref ROTABLE Nested without Tab')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

'Get Activity Record counts'
int activityRecordCountBefore = CustomKeywords.'actions.MenuBar.getRecordCountInActivity'('REPO', 'Business Model', 'Business Model', 'BM Ref ROTABLE Nested without Tab')

'Verify Record count in actvity matches with record count in grid'
CustomKeywords.'actions.Common.verifyTotalRecordCountFromPageSummary'(findTestObject('Page_nGage_Dashboard/Repository/BrowseResults Tab/Table_PageResults'), activityRecordCountBefore)

//TODO: Add new record and check count increases by 1 after refresh

'Right click on BM Ref ROTABLE Nested without Tab from Business Model Sub Menu'
CustomKeywords.'actions.MenuBar.rightClickTreeMenu'('REPO', 'Business Model', 'Business Model', 'BM Ref ROTABLE Nested without Tab')
CustomKeywords.'actions.ContextMenu.clickOption'(findTestObject('Page_nGage_Dashboard/contextMenuOptions'), 'Refresh')

'Get Activity Record counts'
int activityRecordCountAfter = CustomKeywords.'actions.MenuBar.getRecordCountInActivity'('REPO', 'Business Model', 'Business Model', 'BM Ref ROTABLE Nested without Tab')

'Verify Record count in actvity matches with record count in grid'
CustomKeywords.'actions.Common.verifyTotalRecordCountFromPageSummary'(findTestObject('Page_nGage_Dashboard/Repository/BrowseResults Tab/Table_PageResults'), activityRecordCountBefore)

'Verify Before and After count'
WebUI.verifyEqual(activityRecordCountBefore, activityRecordCountAfter)