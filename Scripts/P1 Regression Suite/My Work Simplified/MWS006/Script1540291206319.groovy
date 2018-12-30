import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.apache.poi.ss.formula.functions.Columns

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
CustomKeywords.'actions.Common.createDocument_ClosureAction'('Chintan Shah', 'My Work Simplified - MWS006')

'Click on "My Work Simplified" link'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/a_My Work Simplified'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/iframe_iframe_110'))

'Select Activity "Closure Action - Activity A" from Drop down'
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/select_Auto Import Controlled'), GlobalVariable.G_LongTimeout)
WebUI.selectOptionByLabel(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/select_Auto Import Controlled'), 'Closure Action - Activity A', false)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/iframe_iframe_110'))

'Click on Reset layout'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/Reset Layout'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/iframe_iframe_110'))
WebUI.delay(5)

'Get colNo before drag and drop'
int colNo_DocCreateDate_Before = CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/table_SearchResultHeader'), 'Doc Create Date')
int colNo_ActivityState_Before =  CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/table_SearchResultHeader'), 'Activity State')

'Drag and drop columns'
WebUI.dragAndDropToObject(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/tableHeader_DocCreateDate'), findTestObject('Page_nGage_Dashboard/My_Work_Simplified/tableHeader_ActivityState'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/iframe_iframe_110'))

'Get colNo after drag and drop'
int colNo_DocCreateDate_After = CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/table_SearchResultHeader'), 'Doc Create Date')
int colNo_ActivityState_After =  CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/table_SearchResultHeader'), 'Activity State')

'Click on Set layout'
WebUI.click(findTestObject("Page_nGage_Dashboard/My_Work_Simplified/Set Layout"))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/iframe_iframe_110'))
WebUI.delay(5)

'Verify columns are switched'
WebUI.verifyEqual(colNo_DocCreateDate_After, colNo_ActivityState_Before)

'Click on Reset layout'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/Reset Layout'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/iframe_iframe_110'))
WebUI.delay(5)

'Get colNo after reset'
int colNo_DocCreateDate_AfterReset = CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/table_SearchResultHeader'), 'Doc Create Date')
int colNo_ActivityState_AfterReset =  CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/table_SearchResultHeader'), 'Activity State')

'Verify column positon are reset'
WebUI.verifyEqual(colNo_DocCreateDate_AfterReset, colNo_DocCreateDate_Before)
WebUI.verifyEqual(colNo_ActivityState_AfterReset, colNo_ActivityState_Before)