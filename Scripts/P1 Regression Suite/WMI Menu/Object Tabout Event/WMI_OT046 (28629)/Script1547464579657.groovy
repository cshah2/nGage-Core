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

//create doc 2 times
//1.
'Create a new Refrence Object Feature Document'
WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))
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
'Create a new Refrence Object Feature Document'
WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'('Object Tabout Events', 'Nested Lookup Event')
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

WebUI.switchToWindowTitle('(Doc ID: NEW )')
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'save and close window'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Textbox with Section Event/span_Save'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Window.clickElementAndWaitForWindowClose'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Textbox with Section Event/span_Close Window'),GlobalVariable.G_LongTimeout)
WebUI.switchToWindowIndex(0)

'Switch to parent window '
WebUI.switchToWindowIndex(0)
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/span_ui-button-icon-primary ui'))

'Navigate to Recent Documents'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('HOME', 'Recent Documents')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/iframe_iframe_103'))

'Sort records DocID Descending'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/Home/column_RecentDocuments DocID'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/iframe_iframe_103'))
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/Home/column_RecentDocuments DocID'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/iframe_iframe_103'))

'Open recent document'
CustomKeywords.'actions.Table.clickCell'(findTestObject('Object Repository/Page_nGage_Dashboard/Home/table_MyDocumentResults'), 1, 7)
WebUI.switchToWindowIndex(1)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'verify opened document type'
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Nested Lookup Event/span_(Title)Business Model View - Nes'))

'click on tab inline view'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Nested Lookup Event/tab_InlineView'))

'sort GVGrid records according to Doc ID'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Nested Lookup Event/tab_Inline View/a_Column Doc ID'))
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Nested Lookup Event/tab_Inline View/a_Column Doc ID'))
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)

'Click on same documnt from refrence object grid '
CustomKeywords.'actions.Table.clickCell'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Nested Lookup Event/tab_Inline View/table_GVGrid'), 2, 5)
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)

'From Inline View of refrence object value 1 from Nested Level 1 dropdown'
WebUI.selectOptionByValue(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Nested Lookup Event/tab_Inline View/select_Master Object Nest Level 1'), '1', false)
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)

'verify In Nested level 2 drop down value1, value2,value3, value4,value5 should be fillup'
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Nested Lookup Event/tab_Inline View/option_Master Obj Level2_Value1'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Nested Lookup Event/tab_Inline View/option_Master Obj Level2_Value2'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Nested Lookup Event/tab_Inline View/option_Master Obj Level2_Value3'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Nested Lookup Event/tab_Inline View/option_Master Obj Level2_Value4'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Nested Lookup Event/tab_Inline View/option_Master Obj Level2_Value5'), GlobalVariable.G_LongTimeout)

'From master object select value 1 from Nested Level 2 dropdown'
WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Nested Lookup Event/tab_Inline View/select_Master Object Nest Level 2'), 'Value 1', false)
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)

'In Nested level 3 drop down values -true ,false should be fill up'
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Nested Lookup Event/tab_Inline View/option_Master Obj Level3_Value False'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Nested Lookup Event/tab_Inline View/option_Master Obj Level3_Value True'), GlobalVariable.G_LongTimeout)

'From master object select True from Nested Level 3 dropdown'
WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Nested Lookup Event/tab_Inline View/select_Master Object Nest Level 3'), 'True', false)
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)

'Click on Save from refence object'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Nested Lookup Event/tab_Inline View/input_Nested Lookup Event  Save'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'verify document saved'
String docType= CustomKeywords.'actions.Table.getCellText'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Nested Lookup Event/tab_Inline View/table_GVGrid'), 2, 6)
WebUI.verifyMatch(docType, 'Nested Lookup Event', false)

////TODO: There is a bug in application , will work on script once bug is resolved
//'verify document opened' 
//WebUI.verifyOptionSelectedByValue(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Nested Lookup Event/tab_Inline View/select_Master Object Nest Level 1'), '1', false,GlobalVariable.G_LongTimeout )
//WebUI.verifyOptionSelectedByValue(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Nested Lookup Event/tab_Inline View/select_Master Object Nest Level 2'), '1', false,GlobalVariable.G_LongTimeout )
//WebUI.verifyOptionSelectedByValue(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Nested Lookup Event/tab_Inline View/select_Master Object Nest Level 3'), '1', false,GlobalVariable.G_LongTimeout )