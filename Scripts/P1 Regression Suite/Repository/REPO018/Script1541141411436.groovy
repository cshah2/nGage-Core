import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import utils.DateUtil
'Login Into Application'
CustomKeywords.'actions.Common.login'()

'Expand Repository Menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/Repository/h3_Repository Menu'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

'Select Repository - Advance Search tab'
WebUI.selectOptionByLabel(findTestObject('Page_nGage_Dashboard/Repository/select_Repository Drop Down'), 'Business Model', false)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

'Selinput_btnSearchect Search For - Advance Search tab'
WebUI.selectOptionByLabel(findTestObject('Page_nGage_Dashboard/Repository/select_Search For Drop Down'), 'Business Model', false)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

'Enter Only End Date in Search field'
WebUI.setText(findTestObject('Page_nGage_Dashboard/Repository/input_BM___Date_From'), '12122018')

'Click on Search button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Repository/input_btnSearch'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

'Wait for table to be visible'
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/Repository/table_SearchResults'), GlobalVariable.G_LongTimeout)

String pageCountAfterFilter = WebUI.getText(findTestObject('Page_nGage_Dashboard/Repository/div_Page_Results'))

'Click save search button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Repository/input_btnSaveSearchAdv'))
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/save_Search_Description'))

'Enter Search critera name'
String now = DateUtil.getCurrentDateTime()
String fileName = 'SAVED_SEARCH_'+now
WebUI.setText(findTestObject('Page_nGage_Dashboard/Repository/input_txtSaveDesc'), fileName)

WebUI.click(findTestObject('Page_nGage_Dashboard/Repository/input_btnSave'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

'Select Saved search filter from the table'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Repository/div_Modified Date'))
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Repository/div_Modified Date'))

'Verify Filter created in last test cases is present in first row'
WebUI.verifyElementText(findTestObject('Page_nGage_Dashboard/Repository/column_Saved Search table first row Search Desc'), fileName)

/*'Verify Filter created in last test cases is present in first row'
WebUI.verifyElementText(findTestObject('Page_nGage_Dashboard/Repository/column_Saved Search table first row Search Desc'), GlobalVariable.FilterName)*/

'Select filter from table'
WebUI.click(findTestObject('Page_nGage_Dashboard/Repository/column_Saved Search table first row Search Desc'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

'Click on Delete button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Repository/input_btnDelete'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

'Click on OK button on confirmation dialog'
WebUI.click(findTestObject('Page_nGage_Dashboard/Repository/span_Delete Dialog Ok Button'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

'Sort Saved search table with Modified Date value - Descending'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Repository/div_Modified Date'))
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Repository/div_Modified Date'))

'Verify filter is no longer displayed in saved search grid'
CustomKeywords.'actions.Table.verifyRecordNotPresentInColumn'(findTestObject('Page_nGage_Dashboard/Repository/table_SavedSearch'), 2, GlobalVariable.FilterName)