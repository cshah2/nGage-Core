import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.Keys

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

'Create Bulk Document'
CustomKeywords.'actions.Common.createBulkDocuments_RenderAllFields'(40)

'Expand Repository Menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/Repository/h3_Repository Menu'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Select repository and search for value in drop down'
CustomKeywords.'actions.Common.selectRepositoryAndSearchFor'('Business Model', 'Business Model')

'Click on Search button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Repository/input_btnSearch'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

'Verify Records are present in table'
int rowCount = CustomKeywords.'actions.Table.getRowsCount'(findTestObject('Page_nGage_Dashboard/Repository/table_SearchResults'))
WebUI.verifyGreaterThanOrEqual(rowCount, 1)

'Ensure the first page in the table is loaded'
WebUI.verifyMatch(WebUI.getText(findTestObject('Page_nGage_Dashboard/Repository/Table_SearchResult_PageCount')), '.*Showing 1 - 12.*', true)

'Enter page number 3'
WebUI.setText(findTestObject('Page_nGage_Dashboard/Repository/Table_PageNumberInput'), '3')
WebUI.sendKeys(findTestObject('Page_nGage_Dashboard/Repository/Table_PageNumberInput'), Keys.chord(Keys.ENTER))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

'Ensure the first page in the table is loaded'
WebUI.verifyMatch(WebUI.getText(findTestObject('Page_nGage_Dashboard/Repository/Table_SearchResult_PageCount')), '.*Showing 25 - 36.*', true)

'Click on Previous (<<) button'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/Table_PreviousPageButton'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

'Ensure the second page in the table is loaded'
WebUI.verifyMatch(WebUI.getText(findTestObject('Page_nGage_Dashboard/Repository/Table_SearchResult_PageCount')), '.*Showing 13 - 24.*', true)