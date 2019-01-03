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

'Create a new Refrence Object Feature Document'
WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'('Business Model View', 'Standard Grid')
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

WebUI.switchToWindowTitle('(Doc ID: NEW )')
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Click on WMI Harness page'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Result_View/span_WMI Harness'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Result_View/iframe_ContentPlaceHolder1_iPage'))

'Click on Save button'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Result_View/span_Save'))

'Verify the record is saved'
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/BusinessModelView/StandardGrid/a_Audit History'))

'Click on Related documents (Parent) tab'
WebUI.click(findTestObject('Page_WMI_NEW/BusinessModelView/StandardGrid/a_Related Documents(Parent)'))

'Verify Related documents (Parent) tab is loaded'
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/BusinessModelView/StandardGrid/Related_Document(Parent)/span_Related Documents(Parent)'))

'Verify the bordercolor for Notes grid.(border color set in wmi is #DA70D6=orchid)'
CustomKeywords.'actions.Common.verifyCssValue'(findTestObject('Page_WMI_NEW/BusinessModelView/StandardGrid/Related_Document(Parent)/td_Related Documents(Parent)'), 'border-top-color', 'rgba(218, 112, 214, 1)')

'Verify the backgroundcolor for Notes grid (backgroundcolor set in wmi is #2E8B57=seagreen)'
CustomKeywords.'actions.Common.verifyCssValue'(findTestObject('Page_WMI_NEW/BusinessModelView/StandardGrid/Related_Document(Parent)/table_Related Documents(Parent)'), 'background-color', 'rgba(46, 139, 87, 1)')

'Verify the headerbgcolor for Notes grid (headerbgcolor set in wmi is #ADD8E6=lightblue)'
CustomKeywords.'actions.Common.verifyCssValue'(findTestObject('Page_WMI_NEW/BusinessModelView/StandardGrid/Related_Document(Parent)/td_Related Documents(Parent)'), 'background-color', 'rgba(173, 216, 230, 1)')

'Create document for Related Document (Child)'

'Open New Document UI'
WebUI.mouseOver(findTestObject('Object Repository/Page_WMI_NEW/BusinessModelView/StandardGrid/Related_Document(Child)/menu_Attachments'))
CustomKeywords.'actions.Common.waitForElementVisible'(findTestObject('Object Repository/Page_WMI_NEW/BusinessModelView/StandardGrid/Related_Document(Child)/subMenu_AttachNewDocument'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/BusinessModelView/StandardGrid/Related_Document(Child)/subMenu_AttachNewDocument'))

'Select Doc Class and Doc Type'
CustomKeywords.'actions.Common.waitForElementVisible'(findTestObject('Object Repository/Page_WMI_NEW/BusinessModelView/StandardGrid/Related_Document(Child)/select_DocClass'), GlobalVariable.G_LongTimeout)
WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_WMI_NEW/BusinessModelView/StandardGrid/Related_Document(Child)/select_DocClass'), 'Business Model View', false)
WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_WMI_NEW/BusinessModelView/StandardGrid/Related_Document(Child)/select_DocType'), 'Standard Grid', false)

'Save the document'
CustomKeywords.'actions.Common.waitForElementVisible'(findTestObject('Object Repository/Page_WMI_NEW/BusinessModelView/StandardGrid/Related_Document(Child)/textbox_BMString'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/BusinessModelView/StandardGrid/Related_Document(Child)/button_AttachDocument'))

CustomKeywords.'actions.Common.waitForElementVisible'(findTestObject('Object Repository/Page_WMI_NEW/BusinessModelView/StandardGrid/Related_Document(Child)/popUp_Message'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/BusinessModelView/StandardGrid/Related_Document(Child)/popUp_Ok'))

'Click on WMI Harness page'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Result_View/span_WMI Harness'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Result_View/iframe_ContentPlaceHolder1_iPage'))

'Click on Related documents (Child) tab'
WebUI.click(findTestObject('Page_WMI_NEW/BusinessModelView/StandardGrid/a_Related Documents(Child)'))

'Click on Close Window button'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Inline_Result_View/span_Close Window'))

'Switch to main window'
WebUI.switchToWindowIndex(0)

'Verify main window is loaded'
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_nGage_Dashboard/input_btnLogout'))

'Open Recent Document page'
'Click Tree Menu - Recent Documents'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('HOME', 'Recent Documents')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/iframe_iframe_103'))

'Verify grid contains atleast 1 record'
WebUI.verifyElementPresent(findTestObject('Page_nGage_Dashboard/Home/tableRow_recentDocuments_firstRow'), GlobalVariable.G_LongTimeout);

'Open first document from grid'
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/column_RecentDocuments LastAction'))
WebUI.switchToWindowIndex(1)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Click on Related documents (Parent) tab'
WebUI.click(findTestObject('Page_WMI_NEW/BusinessModelView/StandardGrid/a_Related Documents(Parent)'))

'Verify Related documents (Parent) tab is loaded'
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/BusinessModelView/StandardGrid/Related_Document(Parent)/span_Related Documents(Parent)'))

'Verify table has 1 row'
int expectedRows = 1
int rowCount = CustomKeywords.'actions.Table.getRowsCount'(findTestObject('Page_WMI_NEW/BusinessModelView/StandardGrid/Related_Document(Parent)/table_ActualRow'))
WebUI.verifyEqual(rowCount, expectedRows)