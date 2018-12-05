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
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/icon_Expand_Closure Actions'), GlobalVariable.G_LongTimeout)

'expand loan interactive process'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/icon_Expand_LoanInteractive'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'click on loan application activity'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_LoanApplication'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))

'verify activity count with grid count'
CustomKeywords.'actions.Common.verifyRecordCountInActivityMatchesWithResultGrid'(findTestObject('Page_nGage_Dashboard/My_Work/a_LoanApplication'),findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/div_PageCount'))

'Expand Search Bar'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/h3_Search Bar'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/process_Loan Interactive/input_Loan Appln_LoanAmtFrom'))
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/process_Loan Interactive/input_LoanAppln_LoanAmtTo'))

'enter loan amount range values'
WebUI.setText(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/process_Loan Interactive/input_Loan Appln_LoanAmtFrom'), '00')
WebUI.setText(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/process_Loan Interactive/input_LoanAppln_LoanAmtTo'), '10')

'click on search button'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/btn_Search'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))

'verify grid records according to filter applied'



WebUI.delay(10)