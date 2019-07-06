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

'Click on a Global new button'
WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))

//create doc 2 times
//1.
'Create a new Nested lookup event document'
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'('Object Tabout Events', 'Nested Lookup Event')
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

WebUI.switchToWindowTitle('(Doc ID: NEW )')
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'save and close window'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Textbox with Section Event/span_Save'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Window.clickElementAndWaitForWindowClose'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Textbox with Section Event/span_Close Window'),GlobalVariable.G_LongTimeout)
WebUI.switchToWindowIndex(0)

//2.
'Create a new Nested lookup event document'
WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'('Object Tabout Events', 'Nested Lookup Event')
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

WebUI.switchToWindowTitle('(Doc ID: NEW )')
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'save and close window'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Textbox with Section Event/span_Save'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Window.clickElementAndWaitForWindowClose'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Textbox with Section Event/span_Close Window'),GlobalVariable.G_LongTimeout)

'Switch to parent window '
WebUI.switchToWindowIndex(0)
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/span_ui-button-icon-primary ui'))

'Navigate to Recent Documents'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('HOME', 'Recent Documents')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/iframe_iframe_103'))

'Sort records DocID Descending'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'), 'Doc ID')
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'), 'Doc ID')

'Open second document'
int rowNo = 2
CustomKeywords.'actions.Table.clickCell'(findTestObject('Object Repository/Page_nGage_Dashboard/Home/table_MyDocumentResults'), rowNo, 7)
WebUI.switchToWindowIndex(1)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'verify opened document type'
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Nested Lookup Event/span_(Title)Business Model View - Nes'))

'click on tab inline view'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Nested Lookup Event/tab_InlineView'))

'sort records according to Doc ID in inline table'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Nested Lookup Event/tab_Inline View/a_Column Doc ID'))
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Nested Lookup Event/tab_Inline View/a_Column Doc ID'))
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)

'Click on first document in the grid'
int inlineRowNo = 1
CustomKeywords.'actions.Table.clickCell'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Nested Lookup Event/tab_Inline View/table_GVGrid'), inlineRowNo, 5)
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)

'From Inline View of refrence object value 1 from Nested Level 1 dropdown'
String ddOptionlvl1 = 'Value 1'
WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Nested Lookup Event/tab_Inline View/select_Master Object Nest Level 1'), ddOptionlvl1, false)
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)

'verify In Nested level 2 drop down value1, value2,value3, value4,value5 should be fillup'
WebUI.verifyOptionPresentByLabel(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Nested Lookup Event/tab_Inline View/select_Master Object Nest Level 2'), 'Value 1', false, GlobalVariable.G_LongTimeout)
WebUI.verifyOptionPresentByLabel(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Nested Lookup Event/tab_Inline View/select_Master Object Nest Level 2'), 'Value 2', false, GlobalVariable.G_LongTimeout)
WebUI.verifyOptionPresentByLabel(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Nested Lookup Event/tab_Inline View/select_Master Object Nest Level 2'), 'Value 3', false, GlobalVariable.G_LongTimeout)
WebUI.verifyOptionPresentByLabel(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Nested Lookup Event/tab_Inline View/select_Master Object Nest Level 2'), 'Value 4', false, GlobalVariable.G_LongTimeout)
WebUI.verifyOptionPresentByLabel(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Nested Lookup Event/tab_Inline View/select_Master Object Nest Level 2'), 'Value 5', false, GlobalVariable.G_LongTimeout)

'From master object select value 1 from Nested Level 2 dropdown'
String ddOptionlvl2 = 'Value 1'
WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Nested Lookup Event/tab_Inline View/select_Master Object Nest Level 2'), ddOptionlvl2, false)
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)

'In Nested level 3 drop down values -true ,false should be fill up'
WebUI.verifyOptionPresentByLabel(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Nested Lookup Event/tab_Inline View/select_Master Object Nest Level 3'), 'True', false, GlobalVariable.G_LongTimeout)
WebUI.verifyOptionPresentByLabel(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Nested Lookup Event/tab_Inline View/select_Master Object Nest Level 3'), 'False', false, GlobalVariable.G_LongTimeout)

'From master object select True from Nested Level 3 dropdown'
String ddOptionlvl3 = 'True'
WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Nested Lookup Event/tab_Inline View/select_Master Object Nest Level 3'), ddOptionlvl3, false)
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)

'Click on Save from refence object'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Nested Lookup Event/tab_Inline View/input_Nested Lookup Event  Save'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Close WMI'
CustomKeywords.'actions.Window.clickElementAndWaitForWindowClose'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Textbox with Section Event/span_Close Window'),GlobalVariable.G_LongTimeout)

'Switch to parent window'
WebUI.switchToWindowIndex(0)

'Navigate to Recent Documents'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('HOME', 'Recent Documents')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/iframe_iframe_103'))

'Sort records DocID Descending'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'), 'Doc ID')
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'), 'Doc ID')

'Open second document'
rowNo = 1
CustomKeywords.'actions.Table.clickCell'(findTestObject('Object Repository/Page_nGage_Dashboard/Home/table_MyDocumentResults'), rowNo, 7)
WebUI.switchToWindowIndex(1)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'verify opened document type'
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Nested Lookup Event/span_(Title)Business Model View - Nes'))

'Verify correct value is selected in drop down 1'
WebUI.verifyOptionSelectedByLabel(findTestObject('Page_WMI_NEW/Object Tabout Event/Nested Lookup Event/select_Master Object Nest Level 1'), ddOptionlvl1, false, GlobalVariable.G_LongTimeout)

'Verify correct value is selected in drop down 2'
WebUI.verifyOptionSelectedByLabel(findTestObject('Page_WMI_NEW/Object Tabout Event/Nested Lookup Event/select_Master Object Nest Level 2'), ddOptionlvl2, false, GlobalVariable.G_LongTimeout)

'Verify correct value is selected in drop down 3'
WebUI.verifyOptionSelectedByLabel(findTestObject('Page_WMI_NEW/Object Tabout Event/Nested Lookup Event/select_Master Object Nest Level 3'), ddOptionlvl3, false, GlobalVariable.G_LongTimeout)