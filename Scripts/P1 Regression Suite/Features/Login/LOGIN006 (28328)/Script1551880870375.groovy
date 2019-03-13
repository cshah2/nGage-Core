import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import common.DocClass
import common.DocType
import common.Fields
import internal.GlobalVariable as GlobalVariable
import static utils.Consts.*

'Login Into Application'
CustomKeywords.'actions.Common.login'()

'Create document'
CustomKeywords.'actions.Data.create'(DocClass.WMI_MENU, DocType.WMI_MENU_BOV_VERTICAL, P1_WMI_DOC062)

'click on recent document link'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('HOME', 'Recent Documents')
WebUI.click(findTestObject("Object Repository/Page_nGage_Dashboard/Home/a_Recent Documents"))
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/Home/table_MyDocumentResults'), GlobalVariable.G_LongTimeout)

'Click on first row in table to open document'
int colNo_DocID = CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'), 'Doc ID')
CustomKeywords.'actions.Table.clickCell'(findTestObject('Page_nGage_Dashboard/Home/table_MyDocumentResults'), 1, colNo_DocID)
WebUI.switchToWindowIndex(1)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'hover mouse on More'
WebUI.verifyElementPresent(findTestObject("Page_WMI/WMI_Menu_BOV_Vertical/menu_MORE .."), GlobalVariable.G_LongTimeout)
WebUI.mouseOver(findTestObject("Page_WMI/WMI_Menu_BOV_Vertical/menu_MORE .."))
WebUI.waitForElementVisible(findTestObject("Page_WMI/WMI_Menu_BOV_Vertical/option_Email  Favorites_1"), GlobalVariable.G_LongTimeout)
WebUI.mouseOver(findTestObject("Page_WMI/WMI_Menu_BOV_Vertical/option_Email  Favorites_1"))
WebUI.waitForElementVisible(findTestObject("Page_WMI/WMI_Menu_BOV_Vertical/option_Show Link"), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject("Page_WMI/WMI_Menu_BOV_Vertical/option_Show Link"))

WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
WebUI.waitForElementVisible(findTestObject("Page_WMI/WMI_Menu_BOV_Vertical/button_TestLink"), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject("Page_WMI/WMI_Menu_BOV_Vertical/button_TestLink"))

'switch to new login window'
WebUI.switchToWindowIndex(2)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

WebUI.waitForElementVisible(findTestObject('Page_Login/input_UserName'), GlobalVariable.G_LongTimeout)
WebUI.setText(findTestObject('Page_Login/input_UserName'), GlobalVariable.Username)
WebUI.setText(findTestObject('Page_Login/input_Password'), GlobalVariable.Password)
WebUI.selectOptionByValue(findTestObject('Page_Login/select_Schema'), GlobalVariable.Database, true)
WebUI.click(findTestObject('Page_Login/button_Login'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'verify the data'
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/input_eform_String_Input_Field'), 'value', P1_WMI_DOC062.get(Fields.STRING_FIELD), GlobalVariable.G_LongTimeout)