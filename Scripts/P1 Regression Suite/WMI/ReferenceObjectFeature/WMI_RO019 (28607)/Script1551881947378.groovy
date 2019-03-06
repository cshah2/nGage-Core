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
import utils.DateUtil

'Login Into Application'
CustomKeywords.'actions.Common.login'()

'Create a new Refrence Object Feature Document'
WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'('Reference Object Feature', 'Reference Object ExtAppURL')
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

WebUI.switchToWindowTitle('(Doc ID: NEW )')
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Verify the various tabs for Extrappurl displayed'
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/ExtAppURL/tab_1_ExtAppURL/span_Business Model View - Ref'),GlobalVariable.G_LongTimeout )
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/ExtAppURL/tab_1_ExtAppURL/span_This WMI imparts Referenc'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/ExtAppURL/tab_2_ExtAppURL/span_2) Extappurl'), GlobalVariable.G_LongTimeout)

'Verify tab 3)ExtAppURL displayes Reference Grid'

CustomKeywords.'actions.Table.getCellText'(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/AdHoc_Filter/table_GVGrid'), 1,4)

'click on tab 3) ExtAppURL'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/ExtAppURL/tab_3_ExtAppURL/span_3) Extappurl'))
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)

'Verify 1) Extrappurl should be displayed with New dropdown having different Doc types'
CustomKeywords.'actions.Common.verifyElementsCount'(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/ExtAppURL/tab_3_ExtAppURL/list_New'), 95)

'Select Doc Type Render as Label'
WebUI.mouseOver(findTestObject('Page_WMI_NEW/Reference_Object_Feature/ExtAppURL/tab_3_ExtAppURL/div_New'))
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/ExtAppURL/tab_3_ExtAppURL/a_RenderAsLabel'),GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/ExtAppURL/tab_3_ExtAppURL/a_RenderAsLabel'))
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)

'Verify related document should be displayed under reference grid as inline view'
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/ExtAppURL/tab_1_ExtAppURL/span_This is WMI'),GlobalVariable.G_LongTimeout)


'Verify New Chrome Browser with www.google.com URL is Opened simultaneously'
WebUI.switchToWindowIndex(2)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

String actualURL = WebUI.getUrl()
WebUI.verifyMatch(actualURL, '.*https://www.google.com.*', true)
WebUI.closeWindowIndex(2)

'Click on Save from Master Doc'
WebUI.switchToWindowIndex(1)
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/ExtAppURL/tab_3_ExtAppURL/input_Save'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Save Document from Bussiness Model'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/ImportMode_Interactive/span_Save'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

String windowTitle= WebUI.getWindowTitle()
String[] str_array = windowTitle.split("-")
String windowTitleAfterSave = str_array[0].trim()
println windowTitleAfterSave

'Close Window() and If Error Present Document will not get Close'
CustomKeywords.'actions.Window.clickElementAndWaitForWindowClose'(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/ImportMode_Interactive/span_Close Window'), GlobalVariable.G_LongTimeout)

'Switch to parent window'
WebUI.switchToWindowIndex(0)
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/span_ui-button-icon-primary ui'))

'Navigate to Recent Documents'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('HOME', 'Recent Documents')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/iframe_iframe_103'))

'Sort records DocID Descending'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'), 'Doc ID')
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'), 'Doc ID')

int DocTypeColumnPosition =CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'),'Doc Type')
println DocTypeColumnPosition

String docTypeInRecentDocuments = CustomKeywords.'actions.Table.getCellText'(findTestObject('Object Repository/Page_nGage_Dashboard/Home/table_MyDocumentResults'),1,DocTypeColumnPosition)
println docTypeInRecentDocuments

'Open Saved document from Recent Documents'
CustomKeywords.'actions.Table.clickCell'(findTestObject('Object Repository/Page_nGage_Dashboard/Home/table_MyDocumentResults'), 1, DocTypeColumnPosition)
WebUI.switchToWindowIndex(1)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Verify Saved Document got Opened'
WebUI.verifyMatch(docTypeInRecentDocuments, windowTitleAfterSave,false)

'Close Window() and If Error Present Document will not get Close'
CustomKeywords.'actions.Window.clickElementAndWaitForWindowClose'(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/ImportMode_Interactive/span_Close Window'), GlobalVariable.G_LongTimeout)

