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
import static utils.Consts.*
import static utils.DateUtil.*

//NOTE: Test case seems duplicate of MW103 - Checked with Amol
'Login Into Application'
CustomKeywords.'actions.Common.login'()

'Create a new Document in DateTimeRequired activity'
if (!(FLAG_P1_MW_DOCA)) {
	CustomKeywords.'actions.Common.createDocument_MyWorkDateTime'(DC_DATEREQUIRED, DT_DATEREQUIRED, P1_MW_DOCA_STARTDATE, P1_MW_DOCA_ENDDATE, P1_MW_DOCA_STARTDATETIME, P1_MW_DOCA_ENDDATETIME, '')
    FLAG_P1_MW_DOCA = true
}

'Click on My Work link from left menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_iframe_105'))

'Verify the foldered date group should be displayed with only Date (not with time) '
CustomKeywords.'actions.MenuBar.verifyAllActivityNamesAreValidDate'('My_Work',FORMAT_DATE_TREE,'Processes','Date Required','Daterequiredsearch')

String treeDate = convert(P1_MW_DOCA_STARTDATE, FORMAT_DATE, FORMAT_DATE_TREE)

'Expand Processes by Click on the Expand Icon and Verify Foldered data displayed'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('My_Work','Processes','Date Required','Daterequiredsearch', treeDate)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Click On Search Bar to open'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/h3_Search Bar'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Verify date autopopulated should show in the search panel'
String actualText = WebUI.getAttribute(findTestObject('Page_nGage_Dashboard/My_Work/Process_Date Required/input_StartDate'),'value')
WebUI.verifyMatch(actualText, P1_MW_DOCA_STARTDATE, false)