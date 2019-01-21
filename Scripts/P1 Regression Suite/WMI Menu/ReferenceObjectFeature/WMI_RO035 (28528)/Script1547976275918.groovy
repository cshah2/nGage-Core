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

'Create Bulk documents'
CustomKeywords.'actions.Common.createBulkDocuments_RenderAsLabel'(16)

'Create a new Refrence Object Feature Document'
WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'('Reference Object Feature', 'Reference Object Grid Features')
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

WebUI.switchToWindowTitle('(Doc ID: NEW )')
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Verify two tabs Reference grid (Sorting),Reference grid(Pagesize(single page) are visible'
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Reference_Grid_feature/span_1) Reference Grid (Sortin'))
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Reference_Grid_feature/span_2) Reference Grid (Pagesi'))
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Reference_Grid_feature/span_3) Reference Grid (Pagesi'))

'click on 2)Reference grid(Page size(single page))'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Reference_Grid_feature/span_2) Reference Grid (Pagesi'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Reference_Grid_feature/iframe_Close Window_ContentPla'))

'select page number'
WebUI.selectOptionByLabel(findTestObject('Page_WMI_NEW/Reference_Object_Feature/Reference_Grid_feature/tab_2)Reference grid(Page size(single page))/select_PageNumber'), '5', false)
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)

'verify current page number'
WebUI.verifyOptionSelectedByLabel(findTestObject('Page_WMI_NEW/Reference_Object_Feature/Reference_Grid_feature/tab_2)Reference grid(Page size(single page))/select_PageNumber'), '5', false,GlobalVariable.G_LongTimeout)

'click on next page icon'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Reference_Grid_feature/tab_2)Reference grid(Page size(single page))/a_Next'))
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)

'verify page number'
WebUI.verifyOptionSelectedByLabel(findTestObject('Page_WMI_NEW/Reference_Object_Feature/Reference_Grid_feature/tab_2)Reference grid(Page size(single page))/select_PageNumber'), '6', false,GlobalVariable.G_LongTimeout)

'click on last page icon'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Reference_Grid_feature/tab_2)Reference grid(Page size(single page))/a_LastPage'))
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)

int currentPageNumber=Integer.parseInt((WebUI.getText(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Reference_Grid_feature/tab_2)Reference grid(Page size(single page))/span_CurrentPageNumber'))).split('\\ ')[1])
println  currentPageNumber

'verify page number'
WebUI.verifyOptionSelectedByLabel(findTestObject('Page_WMI_NEW/Reference_Object_Feature/Reference_Grid_feature/tab_2)Reference grid(Page size(single page))/select_PageNumber'), currentPageNumber.toString(),false,GlobalVariable.G_LongTimeout)
