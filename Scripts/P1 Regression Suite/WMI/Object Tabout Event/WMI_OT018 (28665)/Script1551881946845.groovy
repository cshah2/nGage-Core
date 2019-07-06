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
import utils.DateUtil

'Login Into Application'
CustomKeywords.'actions.Common.login'()

//Create Document 1
'Create a new Object Tabout Events Document'
WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))

'Verify Doc class and Doc type dropdowns should be displayed'
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'('Object Tabout Events', 'Radio List Event')
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

WebUI.switchToWindowTitle('(Doc ID: NEW )')
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Set Date in Date field Required'
String dateRequired1 = DateUtil.getCurrentDateTime(Consts.FORMAT_DATETIME)
CustomKeywords.'actions.Common.setText_Date'(findTestObject('Page_WMI_NEW/Object Tabout Event/Radio List Event/input_Date Field (Required)_ef'), dateRequired1)

'Click On Save Button'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/span_Save'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Close Window'
CustomKeywords.'actions.Window.clickElementAndWaitForWindowClose'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/span_Close Window'),GlobalVariable.G_LongTimeout)

'Switch to parent window'
WebUI.switchToWindowIndex(0)

//Create Document 2
'Verify Doc class and Doc type dropdowns should be displayed'
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'('Object Tabout Events', 'Radio List Event')
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

WebUI.switchToWindowTitle('(Doc ID: NEW )')
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Set Date in Date field Required'
String dateRequired2 = DateUtil.getCurrentDateTime(Consts.FORMAT_DATETIME)
CustomKeywords.'actions.Common.setText_Date'(findTestObject('Page_WMI_NEW/Object Tabout Event/Radio List Event/input_Date Field (Required)_ef'), dateRequired2)

'Click On Save Button'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/span_Save'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Close Window'
CustomKeywords.'actions.Window.clickElementAndWaitForWindowClose'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/span_Close Window'),GlobalVariable.G_LongTimeout)

'Switch to parent window'
WebUI.switchToWindowIndex(0)

'Close popup dialog for create new document'
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/span_ui-button-icon-primary ui'))

'Navigate to Recent Documents'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('HOME', 'Recent Documents')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/iframe_iframe_103'))

'Sort records DocID Descending'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'), 'Doc ID')
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'), 'Doc ID')

'Open recent document'
int rowNo = 2
CustomKeywords.'actions.Table.clickCell'(findTestObject('Object Repository/Page_nGage_Dashboard/Home/table_MyDocumentResults'), rowNo, 7)
WebUI.switchToWindowIndex(1)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Verify Business Model View - Radio List Event doc should be open'
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/span_Business Model View - Rad'))
WebUI.verifyElementText(findTestObject('Page_WMI_NEW/Object Tabout Event/Radio List Event/span_Business Model View - Rad'), 'Business Model View - Radio List Event')

'click on tab inline view'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/tab_InlineView/span_InlineView'))

'Verify grid has atleast 2 records'
int rowCount = CustomKeywords.'actions.Table.getRowsCount'(findTestObject('Page_WMI_NEW/Object Tabout Event/Radio List Event/tab_InlineView/table_InlineResultView'))
WebUI.verifyGreaterThanOrEqual(rowCount, 2)

'Sort DocID'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Textbox with Section Event/tab_InlineView/td_(Header)Doc ID'))
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Textbox with Section Event/tab_InlineView/td_(Header)Doc ID'))
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)

'Click On first Row From Reference Grid'
int inlineRowNo = 1
CustomKeywords.'actions.Table.clickCell'(findTestObject('Page_WMI_NEW/Object Tabout Event/Radio List Event/tab_InlineView/table_InlineResultView'), inlineRowNo, 5)
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)

'Verify document should be opened in Inline view'
CustomKeywords.'actions.Common.waitForElementVisible'(findTestObject('Page_WMI_NEW/Object Tabout Event/Radio List Event/tab_InlineView/input_Value2'), GlobalVariable.G_LongTimeout)

'Scroll to Value 3 radio element'
WebUI.scrollToElement(findTestObject('Page_WMI_NEW/Object Tabout Event/Radio List Event/tab_InlineView/input_Value3'), GlobalVariable.G_LongTimeout)

'Click on Value 3 radio button from Refrence object'
WebUI.check(findTestObject('Page_WMI_NEW/Object Tabout Event/Radio List Event/tab_InlineView/input_Value3'))
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)

'Verify Integer field should be visible'
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/tab_InlineView/input_Integer Field (Visible)_'),GlobalVariable.G_LongTimeout)

'Verify String filed should be with back ground color Blue'
CustomKeywords.'actions.Common.verifyCssValue'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/tab_InlineView/input_String Field (Style)_efo'),'background-color', 'rgba(0, 0, 255, 1)')

'Get Font of String Field'
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/tab_InlineView/input_String Field (Style)_efo'), GlobalVariable.G_LongTimeout )
WebUI.setText(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/tab_InlineView/input_StringField'), 'Sanyogita')

'Verify font-weight is Normal'
String actualfont= CustomKeywords.'actions.Common.getCssValue'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/tab_SingleResultView/input_StringField_ReferenceObject'),'font-weight')

'Verify String filed should be with Font Normal'
WebUI.verifyMatch(actualfont,'400',false)

'Clear Date field value'
WebUI.clearText(findTestObject('Page_WMI_NEW/Object Tabout Event/Radio List Event/tab_InlineView/input_Date Field (Required)_ef'))

'Click on Save from Reference Object'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/tab_InlineView/input_Save'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Close Window'
CustomKeywords.'actions.Window.clickElementAndWaitForWindowClose'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/span_Close Window'),GlobalVariable.G_LongTimeout)

'Go back to parent window'
WebUI.switchToWindowIndex(0)

'Navigate to Recent Documents'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('HOME', 'Recent Documents')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/iframe_iframe_103'))

'Sort records DocID Descending'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'), 'Doc ID')
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'), 'Doc ID')

'Open recent document'
rowNo = 1
CustomKeywords.'actions.Table.clickCell'(findTestObject('Object Repository/Page_nGage_Dashboard/Home/table_MyDocumentResults'), rowNo, 7)
WebUI.switchToWindowIndex(1)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_WMI_NEW/Object Tabout Event/Radio List Event/iframe_Close Window_ContentPla'))

WebUI.delay(10)

'Verify Business Model View - Radio List Event doc should be open'
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/span_Business Model View - Rad'))
WebUI.verifyElementText(findTestObject('Page_WMI_NEW/Object Tabout Event/Radio List Event/span_Business Model View - Rad'), 'Business Model View - Radio List Event')

'Verify radio 3 value is selected'
WebUI.verifyElementChecked(findTestObject('Page_WMI_NEW/Object Tabout Event/Radio List Event/input_Value3_MasterObject'), GlobalVariable.G_LongTimeout)

'Verify date value is matching'
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI_NEW/Object Tabout Event/Radio List Event/input_Date Field (Required)_ef'), 'value', '', GlobalVariable.G_LongTimeout)