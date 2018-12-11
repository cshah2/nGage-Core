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

//Login Into Application
CustomKeywords.'actions.Common.login'()

//Click on My Work link from left menu
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_iframe_105'))

//Expand Closure Action process
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/icon_Expand_Closure Actions'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

//Select Activity A
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/My_Work/a_Activity A'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_Activity A'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

//Verify Count displayed in folder structure and pagination summary in result table matches
CustomKeywords.'actions.Common.verifyRecordCountInActivityMatchesWithResultGrid'(findTestObject('Page_nGage_Dashboard/My_Work/a_Activity A'), findTestObject('Page_nGage_Dashboard/My_Work/table_pagination_summary'))

//Select Activity B
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/My_Work/a_Activity B'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_Activity B'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

//Verify Count displayed in folder structure and pagination summary in result table matches
CustomKeywords.'actions.Common.verifyRecordCountInActivityMatchesWithResultGrid'(findTestObject('Page_nGage_Dashboard/My_Work/a_Activity B'), findTestObject('Page_nGage_Dashboard/My_Work/table_pagination_summary'))

//Select Activity C
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/My_Work/a_Activity C'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_Activity C'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

//Verify Count displayed in folder structure and pagination summary in result table matches
CustomKeywords.'actions.Common.verifyRecordCountInActivityMatchesWithResultGrid'(findTestObject('Page_nGage_Dashboard/My_Work/a_Activity C'), findTestObject('Page_nGage_Dashboard/My_Work/table_pagination_summary'))

//Perform Context click on Acitivy A
CustomKeywords.'actions.MenuBar.clickTreeMenu'('My_Work','Processes', 'Correspondence Generation', 'Correspondence')
WebUI.rightClick(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/a_Correspondance Activity'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

//Verify "Foldering Configuration" option is not present
WebUI.verifyElementNotPresent(findTestObject('Page_nGage_Dashboard/My_Work/contextMenu_Folder Configuration'), GlobalVariable.G_LongTimeout)