import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.junit.After

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

'Click on My Work link from left menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_iframe_105'))

'expand postman process1'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/i_PostmanProcesses1'))
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/a_NewProcessHoldActivity'), GlobalVariable.G_LongTimeout)

' right click on newProcessHoldActivity'
WebUI.rightClick(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/a_NewProcessHoldActivity'))

'wait for jQuery Loading'
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'click on (option)foldering configuration'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/LoanInteractive_MyWork/a_Foldering Configuration'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'select drpdown options'
WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Folder_Configuration/Level1_FieldAssigned'),'To Activity State',false)
WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Folder_Configuration/Level1_Sorting'), 'Asc by Field',false)

'click submit button'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Folder_Configuration/button_Save'))

'click close button'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Folder_Configuration/button_Close'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'expand new Process Hold Activity'
WebUI.doubleClick(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/a_NewProcessHoldActivity'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'verify count (total count and activity count)'
CustomKeywords.'actions.Common.verifyRecordCountInActivityMatchesWithResultGrid'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/a_NewProcessHoldActivity'),findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/div_PageCount'))

'verify sorted order of sub menus'
CustomKeywords.'actions.MenuBar.verifyAllSubmenuAreSortedByActivityName'(CustomKeywords.'actions.MenuBar.getAllSubMenu'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/a_NewProcessHoldActivity')),'asc')

'click on submenu closure'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/a_SubMenuClosure'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_iframe_105'))

'verify count (total count and activity count)'
CustomKeywords.'actions.Common.verifyRecordCountInActivityMatchesWithResultGrid'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/a_SubMenuClosure'),findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/div_PageCount'))