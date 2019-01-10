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

'Create a new Object Tabout Events Document'
WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))

'Verify Doc class and Doc type dropdowns should be displayed'
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'('Object Tabout Events', 'DropDown Event')
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

WebUI.switchToWindowTitle('(Doc ID: NEW )')
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Set Date'
CustomKeywords.'actions.Common.setText_Date'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DropDown Event/input_Date Field (Visibility C'), DateUtil.getCurrentDateTime('MM-dd-yyyy HH:mm:ss a'))

'Click On Save Button'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/span_Save'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Close Window'
CustomKeywords.'actions.Window.clickElementAndWaitForWindowClose'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/span_Close Window'),GlobalVariable.G_LongTimeout)

'Switch to parent window '
WebUI.switchToWindowIndex(0)
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/span_ui-button-icon-primary ui'))

'Create a new Object Tabout Events Document'
WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))

'Verify Doc class and Doc type dropdowns should be displayed'
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'('Object Tabout Events', 'DropDown Event')
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

WebUI.switchToWindowTitle('(Doc ID: NEW )')
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Set Date'
CustomKeywords.'actions.Common.setText_Date'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DropDown Event/input_Date Field (Visibility C'), DateUtil.getCurrentDateTime('MM-dd-yyyy HH:mm:ss a'))

'Click On Save Button'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/span_Save'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Close Window'
CustomKeywords.'actions.Window.clickElementAndWaitForWindowClose'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Radio List Event/span_Close Window'),GlobalVariable.G_LongTimeout)

'Switch to parent window '
WebUI.switchToWindowIndex(0)
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/span_ui-button-icon-primary ui'))


'Navigate to Recent Documents'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('HOME', 'Recent Documents')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/iframe_iframe_103'))

'Sort records DocID Descending'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Object Repository/Page_nGage_Dashboard/Home/column_RecentDocuments DocID'))
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Object Repository/Page_nGage_Dashboard/Home/column_RecentDocuments DocID'))

'Open recent document'
CustomKeywords.'actions.Table.clickCell'(findTestObject('Object Repository/Page_nGage_Dashboard/Home/table_MyDocumentResults'), 1, 7)
WebUI.switchToWindowIndex(1)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Verify Business Model View - DropDown Event doc should be open'
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DropDown Event/span_Business Model View - Dro'))
String actualtext= WebUI.getText(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DropDown Event/span_Business Model View - Dro'))
WebUI.verifyMatch(actualtext, 'Business Model View - DropDown Event', false)

'Click on Inline Tab'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DropDown Event/tab_InlineView/span_InlineView'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DropDown Event/tab_InlineView/iframe_Close Window_ContentPla'))

'Sort DocID'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DropDown Event/tab_InlineView/a_Doc ID'))
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DropDown Event/tab_InlineView/a_Doc ID'))

'Click First Row'
//WebUI.click(findTestObject('Page_WMI_NEW/Object Tabout Event/DropDown Event/tab_InlineView/tr_FirstRow_TableGVGrid'))
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DropDown Event/tab_InlineView/tr_ThirdRow_TableGVGrid'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DropDown Event/tab_InlineView/iframe_Close Window_ContentPla'))

'Verify Elements Present'
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DropDown Event/tab_InlineView/span_This WMI imparts - Field'), GlobalVariable.G_LongTimeout)

'Select Value 1) from DropDown'
WebUI.selectOptionByValue(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DropDown Event/tab_InlineView/select_Value 1Value 2Value 3Va'), '1', false)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DropDown Event/tab_InlineView/iframe_Close Window_ContentPla'))

'Verify In String Filed value should be "Selected Value (Value 1)"'
String getText = WebUI.getAttribute(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DropDown Event/tab_InlineView/input_String Field (Value Change)'),'value')
WebUI.verifyMatch(getText,'Selected Value (Value 1)', false)

'Verify Date Field is Visible'
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DropDown Event/tab_InlineView/input_DateField'),GlobalVariable.G_LongTimeout)

'Set Date in Date Field'
CustomKeywords.'actions.Common.setText_Date'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DropDown Event/input_Date Field (Visibility C'), DateUtil.getCurrentDateTime('MM-dd-yyyy HH:mm:ss a'))

'Click on Save from Reference Grid'
WebUI.click(findTestObject('Page_WMI_NEW/Object Tabout Event/DropDown Event/tab_InlineView/input_Save'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DropDown Event/tab_InlineView/iframe_Close Window_ContentPla'))

'Open same document from refrence grid which is saved'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DropDown Event/tab_InlineView/a_Doc ID'))
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DropDown Event/tab_InlineView/a_Doc ID'))

//TODO : Will execute Correct, once bug (another document getting open) will be fix
'Verify Document should get opened with latest changes and No Error Present'
String valBMtext=CustomKeywords.'actions.Table.getCellText'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/DropDown Event/tab_InlineView/table_GVGrid'), 1, 7)
println valBMtext
WebUI.verifyMatch(valBMtext, 'Selected Value (Value 1)', false)


