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

'Create document Closure Action - Activity A'
CustomKeywords.'actions.Common.createDocument_ClosureAction'('Chintan Shah', 'My Work Simplified - MWS001')

'Click on "My Work Simplified" link'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/a_My Work Simplified'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/iframe_iframe_110'))

'Select Activity "Closure Action - Activity A" from Drop down'
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/select_Auto Import Controlled'), GlobalVariable.G_LongTimeout)
WebUI.selectOptionByLabel(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/select_Auto Import Controlled'), 'Closure Action - Activity A', false)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/iframe_iframe_110'))

'Verify Result grid contains all document whose WFItemActivityName column contains name as "Activity A"'
int colNo_ActivityName = CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/table_SearchResultHeader'), 'WFItemActivityName')
CustomKeywords.'actions.Table.verifyAllValuesInColumnMatches'(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/table_SearchResult'), colNo_ActivityName, 'Activity A')

'click on Search icon to expand search panel'
WebUI.waitForElementClickable(findTestObject("Object Repository/Page_nGage_Dashboard/My_Work_Simplified/h3_Search"), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject("Object Repository/Page_nGage_Dashboard/My_Work_Simplified/h3_Search"))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/iframe_iframe_110'))

'Verify search and reset button is visible'
WebUI.verifyElementVisible(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/input_Search_btnSearch'))
WebUI.verifyElementVisible(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/input_Search_btnReset'))