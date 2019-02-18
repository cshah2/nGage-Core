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
import static utils.Consts.*
import static utils.DateUtil.*

'Login into application'
CustomKeywords.'actions.Common.login'()

'Create Docuement'
CustomKeywords.'actions.Common.createDocument_ClosureAction'(SMOKE_MWS004_CUSTOMERNAME, SMOKE_MWS004_CUSTOMERDETAIL)

'Click on "My Work Simplified" link'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/a_My Work Simplified'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/iframe_iframe_110'))

'Select Activity Closure Action - Activity A from Drop down'
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/select_Auto Import Controlled'), GlobalVariable.G_LongTimeout)
WebUI.selectOptionByLabel(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/select_Auto Import Controlled'), 'Closure Action - Activity A', false)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/iframe_iframe_110'))

'Open Search div'
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/h3_Search'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/h3_Search'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/iframe_iframe_110'))

'Enter Process Due Date Start'
String process_Due_Date_Start = getCurrentDateTimeMinusDays(0, FORMAT_DATETIME)
CustomKeywords.'actions.Common.setText_Date'(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/input_Search_ProcessDueDate_Start'), process_Due_Date_Start)
//TODO: Issue pending from Dev for Date format in system field is in 24 hr format instead of 12

'Click on Search button'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/input_Search_btnSearch'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/iframe_iframe_110'))

'Sort records by Doc ID descending'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/tableHeader_SearchResult'), 'Doc ID')
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/tableHeader_SearchResult'), 'Doc ID')

'Verify Records in table are more than start date'
int columnNo = CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/tableHeader_SearchResult'), 'Process Due Date')
CustomKeywords.'actions.Table.verifyDateTimeFilter'(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/table_SearchResult'), columnNo, process_Due_Date_Start, '', '>=')

'Verify search section is hidden'
WebUI.verifyElementNotVisible(findTestObject('Page_nGage_Dashboard/My_Work_Simplified/table_search_section'))