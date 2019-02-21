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

'Select repository and search for value in drop down'
CustomKeywords.'actions.Common.selectRepositoryAndSearchFor'('Business Model', 'Business Model')

'Enter Only End Date in Search field'
CustomKeywords.'actions.Common.setText_Date'(findTestObject('Page_nGage_Dashboard/Repository/input_BM___Date_From'), P1_REPO_FIELD5_DOC10)

'Click on Search button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Repository/input_btnSearch'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

'Wait for table to be visible'
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/Repository/table_SearchResults'), GlobalVariable.G_LongTimeout)

'Verify Browser tab tool tip'
WebUI.mouseOver(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/a_Advanced Search Tab'))
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/BrowseResults Tab/Browser_ToolTip'), GlobalVariable.G_LongTimeout)

String toolTipValue = WebUI.getText(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/BrowseResults Tab/Browser_ToolTip')).trim()
WebUI.verifyMatch(toolTipValue, '.*Business Model - Business Model.*', true)
String expValueLine2 = '.*BM Date >= '+P1_REPO_FIELD5_DOC10+'.*'
WebUI.verifyMatch(toolTipValue, expValueLine2, true)