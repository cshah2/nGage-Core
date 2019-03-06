import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.Keys

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

'Create a new Refrence Object Feature Document'
WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'('Object Tabout Events', 'Textbox With Section Event')
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

WebUI.switchToWindowTitle('(Doc ID: NEW )')
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'verify Business Model View - Textbox With Section event is open'
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Textbox with Section Event/tab_SingleResultView/span_(Title)SingleResultView'), GlobalVariable.G_LongTimeout)

' enter value (Background) in text box Master Object Event'
CustomKeywords.'actions.Common.setTextJQuery'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Textbox with Section Event/tab_SingleResultView/input_Reference Object Event_e'), 'Background')
WebUI.sendKeys(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Textbox with Section Event/tab_SingleResultView/input_Reference Object Event_e'), Keys.chord(Keys.ENTER))
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)

'verify background color'
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Textbox with Section Event/tab_SingleResultView/span_Sample Section - Visible'), GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.verifyCssValue'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Textbox with Section Event/tab_SingleResultView/div_Sample Section'), 'background-color', 'rgba(255, 165, 0, 1)')

'save and close window'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Textbox with Section Event/span_Save'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Window.clickElementAndWaitForWindowClose'(findTestObject('Object Repository/Page_WMI_NEW/Object Tabout Event/Textbox with Section Event/span_Close Window'),GlobalVariable.G_LongTimeout)
WebUI.switchToWindowIndex(0)

'Close "create new" popup dialog'
WebUI.switchToWindowTitle('Savana nGage')
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/span_ui-button-icon-primary ui'))

'Go to Recent Documents tab'
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/a_Recent Documents'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/iframe_iframe_103'))

'Validate atleast 1 record is present in the grid.'
int rowCount = CustomKeywords.'actions.Table.getRowsCount'(findTestObject('Page_nGage_Dashboard/Home/table_MyDocumentResults'))
WebUI.verifyGreaterThanOrEqual(rowCount, 1)

'Sort Record in grid by DocID Descending'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'), 'Doc ID')
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'), 'Doc ID')

'verify opened document'
String docType= CustomKeywords.'actions.Table.getCellText'(findTestObject('Object Repository/Page_nGage_Dashboard/Home/table_MyDocumentResults'),1 ,4)
WebUI.verifyMatch(docType, 'Textbox With Section Event', false)