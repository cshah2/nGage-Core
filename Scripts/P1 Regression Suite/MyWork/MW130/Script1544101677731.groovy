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

'Login Into Application'
CustomKeywords.'actions.Common.login'()

'Click on My Work link from left menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'expand closure action process'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/icon_Expand_Closure Actions'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'click on activity A'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/a_Activity A'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))

'verify activity count with grid count'
CustomKeywords.'actions.Common.verifyRecordCountInActivityMatchesWithResultGrid'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/a_Activity A'),findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/div_PageCount'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))

int docCreateDate_Position=CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'Doc Create Date')

'sort  column Doc create date (Ascending)'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/tableHeader_DocCreateDate'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))

'verify sorted position of column(Ascending)'
CustomKeywords.'actions.Table.verifyDateTimeIsSorted'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'), docCreateDate_Position,'asc')

'sort  column Doc create date (Descending)'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/tableHeader_DocCreateDate'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))

'verify sorted position of column(Descending)'
CustomKeywords.'actions.Table.verifyDateTimeIsSorted'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'), docCreateDate_Position,'desc')