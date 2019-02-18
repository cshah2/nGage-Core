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
import utils.Consts

'Login into application'
CustomKeywords.'actions.Common.login'()

'Create Docuement'
CustomKeywords.'actions.Common.createDocument_ClosureAction'(Consts.SMOKE_MWS002_CUSTOMERNAME, Consts.SMOKE_MWS002_CUSTOMERDETAIL)

'Click on "My Work Simplified" link'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/a_My Work Simplified'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/iframe_iframe_110'))

'Select Activity Closure Action - Activity A from Drop down'
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/select_Auto Import Controlled'), GlobalVariable.G_LongTimeout)
WebUI.selectOptionByLabel(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/select_Auto Import Controlled'), 'Closure Action - Activity A', false)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/iframe_iframe_110'))

'Click on DocID Column header to sort records in ascending order'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/tableHeader_SearchResult'), 'Doc ID')

'Verify records are sorted in ascending order'
int colNo_DocID = CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/tableHeader_SearchResult'), 'Doc ID')
CustomKeywords.'actions.Table.verifyColumnIsSortedInteger'(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/table_SearchResult'), colNo_DocID, 'ASC')

'Click again on DocID column to sort records in descending order'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/tableHeader_SearchResult'), 'Doc ID')

'Verify records are sorted in descending order'
CustomKeywords.'actions.Table.verifyColumnIsSortedInteger'(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/table_SearchResult'), colNo_DocID, 'DESC')