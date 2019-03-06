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

'select Doc Class as "Object Tabout Event " and Doc type as "Check Box event" from the dropdowns and click on OK button'
WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'('Object Tabout Events', 'Nested Lookup Event')
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

WebUI.switchToWindowTitle('(Doc ID: NEW )')
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'verify opened document'
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Nested Lookup Event/span_(Title)Business Model View - Nes'))

'click on tab single result view'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Nested Lookup Event/tab_SingleResultView'))

'From single result view of refrence object select value 1 from Nested Level 1 dropdown'
WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Nested Lookup Event/tab_Single Result View/select_Master Object Nest Level1'), 'Value 1', false)
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)

'In Nested level 2 drop down value1, value2,value3, value4,value5 should be fillup'
WebUI.verifyOptionPresentByLabel(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Nested Lookup Event/tab_Single Result View/select_Master Object Nest Level2'), 'Value 1', false, GlobalVariable.G_LongTimeout)
WebUI.verifyOptionPresentByLabel(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Nested Lookup Event/tab_Single Result View/select_Master Object Nest Level2'), 'Value 2', false, GlobalVariable.G_LongTimeout)
WebUI.verifyOptionPresentByLabel(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Nested Lookup Event/tab_Single Result View/select_Master Object Nest Level2'), 'Value 3', false, GlobalVariable.G_LongTimeout)
WebUI.verifyOptionPresentByLabel(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Nested Lookup Event/tab_Single Result View/select_Master Object Nest Level2'), 'Value 4', false, GlobalVariable.G_LongTimeout)
WebUI.verifyOptionPresentByLabel(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Nested Lookup Event/tab_Single Result View/select_Master Object Nest Level2'), 'Value 5', false, GlobalVariable.G_LongTimeout)

'From single result view of refrence object select value 1 from Nested Level 2 dropdown'
WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Nested Lookup Event/tab_Single Result View/select_Master Object Nest Level2'), 'Value 1', false)
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)

'In Nested level 3 drop down values -true ,false should be fill up'
WebUI.verifyOptionPresentByLabel(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Nested Lookup Event/tab_Single Result View/select_Master Object Nest Level3'), 'True', false, GlobalVariable.G_LongTimeout)
WebUI.verifyOptionPresentByLabel(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Nested Lookup Event/tab_Single Result View/select_Master Object Nest Level3'), 'False', false, GlobalVariable.G_LongTimeout)

'From single result view of refrence object select True from Nested Level 3 dropdown'
WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Nested Lookup Event/tab_Single Result View/select_Master Object Nest Level3'), 'True', false)
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)

'click on save and close'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/CheckBox Event/span_Save'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/CheckBox Event/iframe_Close Window_ContentPla'))
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/CheckBox Event/span_Close Window'))

'switch to main window'
WebUI.switchToWindowIndex('0')

'Close "create new" popup dialog'
WebUI.switchToWindowTitle('Savana nGage')
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/span_ui-button-icon-primary ui'))

'Go to Recent Documents tab'
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/a_Recent Documents'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/iframe_iframe_103'))

'Sort Record in grid by DocID Descending'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'), 'Doc ID')
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'), 'Doc ID')

'verify opened document'
String docType= CustomKeywords.'actions.Table.getCellText'(findTestObject('Object Repository/Page_nGage_Dashboard/Home/table_MyDocumentResults'),1 ,4)
WebUI.verifyMatch(docType, 'Nested Lookup Event', false)