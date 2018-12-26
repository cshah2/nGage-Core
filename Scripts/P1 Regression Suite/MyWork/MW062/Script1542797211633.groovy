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
import utils.Consts

'Login Into Application'
CustomKeywords.'actions.Common.login'(GlobalVariable.Users['MW062_UN'], GlobalVariable.Password, GlobalVariable.Database)

'Create Closure Action Document'
CustomKeywords.'actions.Common.createDocument_ClosureAction'(Consts.P1_MWORK_CLOSURE_CUSTOMERNAME_DOC1, Consts.P1_MWORK_CLOSURE_CUSTOMERDESC_DOC1)

'Click on My Work link from left menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_iframe_105'))

'Navigate to newly created menu'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('MY_WORK', 'Processes','Closure Action', 'Activity A', 'Atul')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

'verify grid records present'
int activityRecordCount = CustomKeywords.'actions.MenuBar.getRecordCountInActivity'('MY_WORK', 'Processes','Closure Action', 'Activity A', 'Atul')
CustomKeywords.'actions.Common.verifyTotalRecordCountFromPageSummary'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/div_PageCount'), activityRecordCount)

'Open Work Item'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/tableHeader_DocID'))
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/tableHeader_DocID'))

'Open first document'
CustomKeywords.'actions.Table.clickCell'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'),1,4)

'switch to new window'
WebUI.switchToWindowIndex(1)

'Click on Customer Information'
WebUI.click(findTestObject('Object Repository/Page_WMI/Closure Action/span_Customer Information'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Verify Closure Action is not Present'
WebUI.verifyElementNotPresent( findTestObject('Page_WMI/Closure Action/button_CustomerActions'), GlobalVariable.G_LongTimeout)

'Verify field Customer Name Present'
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_WMI_NEW/Closure_Action/input_Customer Name'), GlobalVariable.G_LongTimeout)