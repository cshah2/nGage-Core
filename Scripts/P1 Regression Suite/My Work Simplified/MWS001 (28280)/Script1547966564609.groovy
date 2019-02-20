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

'Login into application'
CustomKeywords.'actions.Common.login'()

'Create closure action document if it is not availble'
CustomKeywords.'actions.Common.createBulkDocuments_ClosureAction'(1)

'Click on "My Work Simplified" link'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/a_My Work Simplified'))
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/table_SearchResult'), GlobalVariable.G_LongTimeout)

'Select Activity "Closure Action - Activity A" from Drop down'
WebUI.selectOptionByLabel(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/select_Auto Import Controlled'), 'Closure Action - Activity A', false)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/iframe_iframe_110'))

'click on Search header to expand search panel'
WebUI.click(findTestObject("Object Repository/Page_nGage_Dashboard/My_Work_Simplified/h3_Search"))
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/table_search_section'), GlobalVariable.G_LongTimeout)

'Verify search and reset button is visible'
WebUI.verifyElementVisible(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/input_Search_btnSearch'))
WebUI.verifyElementVisible(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/input_Search_btnReset'))