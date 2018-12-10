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

'click on new  button to create document'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/input_New'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_iframe_105'))

//creating first document
'Select Document class and Document Type'
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'('DCActivityImport', 'DTProcessImport')

'Click on OK Button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

'switch to new window'
WebUI.switchToWindowTitle('(Doc ID: NEW )')
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'enter customer details'
WebUI.switchToWindowIndex(1)
WebUI.setText(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/input_CustomerDetails'), 'test doc')
WebUI.setText(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/input_CustomerName'), 'test doc')
WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_WMI_NEW/Closure_Action/select_User Account Number'), '01',false)

'Click on Save button'
WebUI.mouseOver(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/li_ActionMenu_SubMenu'))
WebUI.waitForElementVisible(findTestObject('Page_WMI_NEW/MultiPage_Viewer_DD/a_Save'), GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Window.clickElementAndWaitForWindowClose'(findTestObject('Page_WMI_NEW/MultiPage_Viewer_DD/a_Save'), GlobalVariable.G_LongTimeout)

'switch to main window'
WebUI.switchToWindowIndex(0)

'Close "create new" popup dialog'
WebUI.switchToWindowIndex(0)
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/span_ui-button-icon-primary ui'))

'Click on My Work link from left menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_iframe_105'))

'Expand Prcess and click on activity TestSameActivityProcess'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('My_Work','Processes','Test same activity process','Activity C','01')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_iframe_105'))

'Click On Search Bar'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/h3_Search Bar'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))

'verify populated value'
WebUI.verifyOptionSelectedByLabel(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/select_AccountNoUser_search'), '.*01.*', true, GlobalVariable.G_LongTimeout)

'Click On Search Button'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/btn_Search'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))

'Verify Search Result'
int StartTestDateTime_ColumnPosition= CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'Account No User')
CustomKeywords.'actions.Table.verifyAllValuesInColumnMatches'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'), StartTestDateTime_ColumnPosition, '01')