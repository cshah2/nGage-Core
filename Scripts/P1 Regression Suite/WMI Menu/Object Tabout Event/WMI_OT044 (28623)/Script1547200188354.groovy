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

'From master object select value 1 from Nested Level 1 dropdown'
WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Nested Lookup Event/select_Master Object Nest Level 1'), 'Value 1', false)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Nested Lookup Event/iframe_Close Window_ContentPla'))

'verify In Nested level 2 drop down value1, value2,value3, value4,value5 fillup'
WebUI.verifyElementPresent(findTestObject('Page_WMI_NEW/Object Tabout Event/Nested Lookup Event/option_Master Obj Level2_Value1'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementPresent(findTestObject('Page_WMI_NEW/Object Tabout Event/Nested Lookup Event/option_Master Obj Level2_Value2'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementPresent(findTestObject('Page_WMI_NEW/Object Tabout Event/Nested Lookup Event/option_Master Obj Level2_Value3'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementPresent(findTestObject('Page_WMI_NEW/Object Tabout Event/Nested Lookup Event/option_Master Obj Level2_Value4'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementPresent(findTestObject('Page_WMI_NEW/Object Tabout Event/Nested Lookup Event/option_Master Obj Level2_Value5'), GlobalVariable.G_LongTimeout)

'From single result view of refrence object select value 1 from Nested Level 2 dropdown'
WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Nested Lookup Event/select_Master Object Nest Level 2'), 'Value 1', false)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Nested Lookup Event/iframe_Close Window_ContentPla'))

'verify In Nested level 3 drop down values -true ,false should be fill up'
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Nested Lookup Event/option_Master Obj Level3_Value True'), GlobalVariable.G_LongTimeout)
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Nested Lookup Event/option_Master Obj Level3_Value False'), GlobalVariable.G_LongTimeout)

'From single result view of refrence object select True from Nested Level 3 dropdown'
WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Nested Lookup Event/select_Master Object Nest Level 3'),'True', false)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Nested Lookup Event/iframe_Close Window_ContentPla'))

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
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Home/div_Doc ID'))
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Home/div_Doc ID'))

'Open Document'
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/column_RecentDocuments LastAction'))
WebUI.switchToWindowIndex(1)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'verify opened document'
WebUI.verifyOptionSelectedByLabel(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Nested Lookup Event/select_Master Object Nest Level 1'), 'Value 1', false, GlobalVariable.G_LongTimeout)
WebUI.verifyOptionSelectedByLabel(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Nested Lookup Event/select_Master Object Nest Level 2'), 'Value 1', false, GlobalVariable.G_LongTimeout)
WebUI.verifyOptionSelectedByLabel(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Nested Lookup Event/select_Master Object Nest Level 3'), 'True', false, GlobalVariable.G_LongTimeout)