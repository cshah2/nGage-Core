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

//Login into application
CustomKeywords.'actions.Common.login'()

//Click on "My Work Simplified" link
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/a_My Work Simplified'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/iframe_iframe_110'))

//Select Activity 'Closure Action - Activity A' from Drop down
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/select_Auto Import Controlled'), GlobalVariable.G_LongTimeout)
WebUI.selectOptionByLabel(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/select_Auto Import Controlled'), 'Closure Action - Activity A', false)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/iframe_iframe_110'))

//click on Refresh button

WebUI.click(findTestObject("Object Repository/Page_nGage_Dashboard/My_Work_Simplified/Grid Refresh button"))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject("Object Repository/Page_nGage_Dashboard/My_Work_Simplified/iframe_iframe_110"))

//Click on DOC ID column header
WebUI.click(findTestObject("Object Repository/Page_nGage_Dashboard/My_Work_Simplified/div_DocID Column Header"))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/iframe_iframe_110'))

//Again click on DOC ID column header
WebUI.click(findTestObject("Object Repository/Page_nGage_Dashboard/My_Work_Simplified/div_DocID Column Header"))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/iframe_iframe_110'))

//sort the column in desc order
WebUI.click(findTestObject("Object Repository/Page_nGage_Dashboard/My_Work_Simplified/div_DocID Column Header"))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/iframe_iframe_110'))
CustomKeywords.'actions.Table.verifyColumnIsSortedInteger'(findTestObject("Object Repository/Page_nGage_Dashboard/My_Work_Simplified/div_DocID Column Header"), 6, 'DESC')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject("Object Repository/Page_nGage_Dashboard/My_Work_Simplified/iframe_iframe_110"))

//close browser
WebUI.closeBrowser()





