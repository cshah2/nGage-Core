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
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'('Closure Action', 'Closure Action')

'Click on OK Button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

'switch to new window'
WebUI.switchToWindowTitle('(Doc ID: NEW )')
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'enter customer details'
WebUI.switchToWindowIndex(1)
WebUI.setText(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/input_CustomerDetails'), 'Multivalue field test')
WebUI.setText(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/input_CustomerName'), 'Chintan Shah')

WebUI.setText(findTestObject('Object Repository/Page_WMI_NEW/Closure_Action/input_Customer Phone Number'), '1000')
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Closure_Action/button_AddCustomerPhoneNumber'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_WMI/Closure Action/iframe_ContentPlaceHolder1_iPa'))

'Click on Save button'
WebUI.mouseOver(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/li_ActionMenu_SubMenu'))
WebUI.waitForElementVisible(findTestObject('Page_WMI_NEW/MultiPage_Viewer_DD/a_Save'), GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Window.clickElementAndWaitForWindowClose'(findTestObject('Page_WMI_NEW/MultiPage_Viewer_DD/a_Save'), GlobalVariable.G_LongTimeout)

'switch to main window'
WebUI.switchToWindowIndex(0)

'Close "create new" popup dialog'
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/span_ui-button-icon-primary ui'))

'Click on My Work link from left menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'expand closure action process'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/icon_Expand_Closure Actions'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'right click on Activity A'
WebUI.rightClick(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/a_Activity A'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'click on (option)foldering configuration'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/LoanInteractive_MyWork/a_Foldering Configuration'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'select drpdown options'
WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Folder_Configuration/Level1_FieldAssigned'),'Customer Phone Number',false)
WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Folder_Configuration/Level1_Sorting'), 'Asc by Field',false)

'click submit button'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Folder_Configuration/button_Save'))

'click close button'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Folder_Configuration/button_Close'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'click on submenu'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('My_Work','Processes','Closure Action','Activity A','1000')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))

'expand search bar'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/h3_Search Bar'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))

'verify auto populated field'
WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/input_CustomerPhoneNumber_search'), 'value', '1000', GlobalVariable.G_LongTimeout)

'click on search button'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/h3_Search Bar'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))

int ColumnPosition_CustomerPhoneNumber= CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'),'Customer Phone Number')
println ColumnPosition_CustomerPhoneNumber

'verify search result '
CustomKeywords.'actions.Table.verifyAllValuesInColumnMatches'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/table_MyWorkSearchResults'),ColumnPosition_CustomerPhoneNumber, '1000')

'right click on Activity A'
WebUI.rightClick(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/a_Activity A'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'click on (option)foldering configuration'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/LoanInteractive_MyWork/a_Foldering Configuration'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'click restore default button'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Folder_Configuration/button_Restore Default'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'click submit button'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Folder_Configuration/button_Save'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'click close button'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Folder_Configuration/button_Close'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)