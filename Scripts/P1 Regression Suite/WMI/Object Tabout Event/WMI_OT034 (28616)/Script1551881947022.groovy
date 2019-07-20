import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.apache.commons.lang3.RandomStringUtils
import org.openqa.selenium.Keys

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import common.DocClass
import common.DocType
import internal.GlobalVariable as GlobalVariable

'Login Into Application'
CustomKeywords.'actions.Common.login'()

'Create Document 1 - Label Event'
CustomKeywords.'actions.Data.create'(DocClass.OBJECT_TABOUT_EVENT, DocType.LABEL_EVENT, null)

'Create Document 2 - Label Event'
CustomKeywords.'actions.Data.create'(DocClass.OBJECT_TABOUT_EVENT, DocType.LABEL_EVENT, null)

'Open second document from recent grid'
CustomKeywords.'actions.Common.openDocumentFromRecentGrid'(2)

'Wait for page to load'
WebUI.waitForElementVisible(findTestObject('Page_WMI_NEW/Object Tabout Event/Label Event/lbl_Control1'), GlobalVariable.G_LongTimeout)

'click on tab inline view'
WebUI.click(findTestObject('Page_WMI_NEW/Object Tabout Event/Label Event/tab_Inline'))

'sort grid records in descending accordindg to docID'
WebUI.click(findTestObject('Page_WMI_NEW/Object Tabout Event/Label Event/tab_InlineView/tableHeader_DocID'))
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_WMI_NEW/Object Tabout Event/Label Event/tab_InlineView/tableHeader_DocID'))
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)

'click on first record in the grid'
CustomKeywords.'actions.Table.clickCell'(findTestObject('Page_WMI_NEW/Object Tabout Event/Label Event/tab_InlineView/table_InlineView'), 1, 5)
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)

'Scroll to Inline Result view'
WebUI.scrollToElement(findTestObject('Page_WMI_NEW/Object Tabout Event/Label Event/tab_InlineView/input_FloatField'), GlobalVariable.G_LongTimeout)

'Verify value in Label Control 1'
WebUI.verifyElementText(findTestObject('Page_WMI_NEW/Object Tabout Event/Label Event/tab_InlineView/lbl_Control1'), 'Condition1')

'Verify value in Label Control 2'
WebUI.verifyElementText(findTestObject('Page_WMI_NEW/Object Tabout Event/Label Event/tab_InlineView/lbl_Control2'), 'Condition2')

'Verify background color or currency field'
CustomKeywords.'actions.Common.verifyCssValue'(findTestObject('Page_WMI_NEW/Object Tabout Event/Label Event/tab_InlineView/input_CurrencyField'), 'background-color', 'rgba(255, 0, 0, 1)')

'Verify backgound color of float field'
CustomKeywords.'actions.Common.verifyCssValue'(findTestObject('Page_WMI_NEW/Object Tabout Event/Label Event/tab_InlineView/input_FloatField'), 'background-color', 'rgba(255, 255, 255, 1)')

'Clear Data from Integer field'
WebUI.clearText(findTestObject('Page_WMI_NEW/Object Tabout Event/Label Event/tab_InlineView/input_IntegerField'))

'Click on Save Button'
WebUI.click(findTestObject('Page_WMI_NEW/Object Tabout Event/Label Event/tab_InlineView/btn_Save'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_WMI_NEW/Object Tabout Event/Label Event/iframe_Close Window_ContentPla'))

'Verify floating error message is displayed'
WebUI.verifyElementVisible(findTestObject('Page_WMI_NEW/Object Tabout Event/Label Event/tab_InlineView/td_IntegerField Required'))

'Enter data in numeric field'
String numericValue = '3000'
WebUI.setText(findTestObject('Page_WMI_NEW/Object Tabout Event/Label Event/tab_InlineView/input_IntegerField'), numericValue)

'Enter data in String field'
String stringValue = 'Amol Patil'
WebUI.setText(findTestObject('Page_WMI_NEW/Object Tabout Event/Label Event/tab_InlineView/input_StringField'), stringValue)

'Click on Save button'
WebUI.click(findTestObject('Page_WMI_NEW/Object Tabout Event/Label Event/tab_InlineView/btn_Save'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Click on Close Window button'
CustomKeywords.'actions.Window.clickElementAndWaitForWindowClose'(findTestObject('Page_WMI_NEW/Object Tabout Event/Label Event/btn_CloseWindow'), GlobalVariable.G_LongTimeout)

'Switch to main window'
WebUI.switchToWindowIndex(0)

'Clear cookies and Login back into portal'
CustomKeywords.'actions.Common.login'()

'Open first document from recent grid'
CustomKeywords.'actions.Common.openDocumentFromRecentGrid'(1)

'Wait for page to load'
WebUI.waitForElementVisible(findTestObject('Page_WMI_NEW/Object Tabout Event/Label Event/lbl_Control1'), GlobalVariable.G_LongTimeout)

'Verify value in Label Control 1'
WebUI.verifyElementText(findTestObject('Page_WMI_NEW/Object Tabout Event/Label Event/lbl_Control1'), 'Condition1')

'Verify value in Label Control 2'
WebUI.verifyElementText(findTestObject('Page_WMI_NEW/Object Tabout Event/Label Event/lbl_Control2'), 'Condition2')

'Verify background color or currency field'
CustomKeywords.'actions.Common.verifyCssValue'(findTestObject('Page_WMI_NEW/Object Tabout Event/Label Event/input_CurrencyField'), 'background-color', 'rgba(255, 0, 0, 1)')

'Verify backgound color of float field'
CustomKeywords.'actions.Common.verifyCssValue'(findTestObject('Page_WMI_NEW/Object Tabout Event/Label Event/input_FloatField'), 'background-color', 'rgba(255, 255, 255, 1)')

'Verify data in Integer field'
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI_NEW/Object Tabout Event/Label Event/input_IntegerField'), 'Value', numericValue, GlobalVariable.G_LongTimeout)

'Verify data in String field'
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI_NEW/Object Tabout Event/Label Event/input_StringField'), 'Value', stringValue, GlobalVariable.G_LongTimeout)