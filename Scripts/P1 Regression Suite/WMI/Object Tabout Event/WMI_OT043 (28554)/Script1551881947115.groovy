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

'Click on Global new button'
WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))

//Create Document 1 - Drop down event
'Verify Doc class and Doc type dropdowns should be displayed'
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'('Object Tabout Events', 'DropDown Event')
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

WebUI.switchToWindowTitle('(Doc ID: NEW )')
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Click On Save Button'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/span_Save'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Close Window'
CustomKeywords.'actions.Window.clickElementAndWaitForWindowClose'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/span_Close Window'),GlobalVariable.G_LongTimeout)

'Switch to parent window '
WebUI.switchToWindowIndex(0)

//Create Document 2 - Drop down event
'Verify Doc class and Doc type dropdowns should be displayed'
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'('Object Tabout Events', 'DropDown Event')
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

WebUI.switchToWindowTitle('(Doc ID: NEW )')
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Click On Save Button'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/span_Save'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Close Window'
CustomKeywords.'actions.Window.clickElementAndWaitForWindowClose'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/span_Close Window'),GlobalVariable.G_LongTimeout)

'Switch to parent window '
WebUI.switchToWindowIndex(0)

'Close Global new popup dialog'
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/span_ui-button-icon-primary ui'))

'Click on Recent Document'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('HOME', 'Recent Documents')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/iframe_iframe_103'))

'Sort Record in grid by DocID Descending'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'), 'Doc ID')
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'), 'Doc ID')

'Open Document'
int rowNo = 2
CustomKeywords.'actions.Table.clickCell'(findTestObject('Page_nGage_Dashboard/Home/table_MyDocumentResults'), rowNo, 5)

'Switch to WMI Window'
WebUI.switchToWindowIndex(1)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Verify Business Model View - DropDown Event doc should be open'
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DropDown Event/span_Business Model View - Dro'))
WebUI.verifyElementText(findTestObject('Page_WMI_NEW/Object Tabout Event/DropDown Event/span_Business Model View - Dro'), 'Business Model View - DropDown Event')

'Click on Inline Tab'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DropDown Event/tab_InlineView/span_InlineView'))

'Sort document from Grid'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Textbox with Section Event/tab_InlineView/td_(Header)Doc ID'))
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Textbox with Section Event/tab_InlineView/td_(Header)Doc ID'))
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)

'Click On first row From Reference Grid'
int inlineRowNo = 1
CustomKeywords.'actions.Table.clickCell'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Textbox with Section Event/tab_InlineView/table_GVGrid'), inlineRowNo, 5)
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)

'Verify Elements Present'
WebUI.verifyElementPresent(findTestObject('Page_WMI_NEW/Object Tabout Event/DropDown Event/tab_InlineView/select_Value 1Value 2Value 3Va'), GlobalVariable.G_LongTimeout)

'Scroll to Inline View'
WebUI.scrollToElement(findTestObject('Page_WMI_NEW/Object Tabout Event/DropDown Event/input_Date Field (Visibility C'), GlobalVariable.G_LongTimeout)

'Select Value 3) from DropDown'
String ddOption = 'Value 3'
WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DropDown Event/tab_InlineView/select_Value 1Value 2Value 3Va'), ddOption, false)
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)

'Verify In String Filed value should be "Selected Value (Value 3 or above)"'
String stringField = 'Selected Value (Value 3 or above)'
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI_NEW/Object Tabout Event/DropDown Event/tab_InlineView/input_String Field (Value Change)'), 'value', stringField, GlobalVariable.G_LongTimeout)

'Verify Date Field is Visible'
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DropDown Event/tab_InlineView/input_DateField'),GlobalVariable.G_LongTimeout)

'Set Date in Date Field'
String dateValue = DateUtil.getCurrentDateTime(Consts.FORMAT_DATETIME)
CustomKeywords.'actions.Common.setText_Date'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DropDown Event/input_Date Field (Visibility C'), dateValue)

'Click on Save from Reference Grid'
WebUI.click(findTestObject('Page_WMI_NEW/Object Tabout Event/DropDown Event/tab_InlineView/input_Save'))
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)

'Close Window'
CustomKeywords.'actions.Window.clickElementAndWaitForWindowClose'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/span_Close Window'),GlobalVariable.G_LongTimeout)

'Switch to parent window '
WebUI.switchToWindowIndex(0)

'Click on Recent Document'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('HOME', 'Recent Documents')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/iframe_iframe_103'))

'Sort Record in grid by DocID Descending'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'), 'Doc ID')
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'), 'Doc ID')

'Open Document'
rowNo = 1
CustomKeywords.'actions.Table.clickCell'(findTestObject('Page_nGage_Dashboard/Home/table_MyDocumentResults'), rowNo, 5)

'Switch to WMI Window'
WebUI.switchToWindowIndex(1)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Verify Business Model View - DropDown Event doc should be open'
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DropDown Event/span_Business Model View - Dro'))
WebUI.verifyElementText(findTestObject('Page_WMI_NEW/Object Tabout Event/DropDown Event/span_Business Model View - Dro'), 'Business Model View - DropDown Event')

'Verify Selected drop down value'
WebUI.verifyOptionSelectedByLabel(findTestObject('Page_WMI_NEW/Object Tabout Event/DropDown Event/select_Value 1Value 2Value 3Va'), ddOption, false, GlobalVariable.G_LongTimeout)

'Verify String field value'
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI_NEW/Object Tabout Event/DropDown Event/input_String Field (Value Chan'), 'value', stringField, GlobalVariable.G_LongTimeout)

'Verify Date field value'
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI_NEW/Object Tabout Event/DropDown Event/input_Date Field (Visibility C'), 'value', dateValue, GlobalVariable.G_LongTimeout)