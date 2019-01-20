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
import internal.GlobalVariable as GlobalVariable

'Login into application'
CustomKeywords.'actions.Common.login'()

'Click on NEW button'
WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))

'Select DocClass and DocType'
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'('Master Object Feature', 'Render As ChangeDocClass')

'Click on OK button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))
WebUI.switchToWindowTitle('(Doc ID: NEW )')
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Verify Information Text'
WebUI.verifyElementText(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_ChangeDocClass/span_Information'), 'This WMI imparts - Control renderas CHANGEDOCCLASS')

'Verify Drop down has options'
WebUI.verifyOptionSelectedByLabel(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_ChangeDocClass/select_CurrentDocClass'), 'Master Object Feature', false, GlobalVariable.G_LongTimeout)
WebUI.verifyOptionSelectedByLabel(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_ChangeDocClass/select_CurrentDocType'), 'Render As ChangeDocClass', false, GlobalVariable.G_LongTimeout)

'Verify drop down contains options'
WebUI.verifyOptionPresentByLabel(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_ChangeDocClass/select_CurrentDocClass'), 'Auto Import Batch', false, GlobalVariable.G_LongTimeout)
WebUI.verifyOptionPresentByLabel(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_ChangeDocClass/select_CurrentDocClass'), 'Business Model View', false, GlobalVariable.G_LongTimeout)
WebUI.verifyOptionPresentByLabel(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_ChangeDocClass/select_CurrentDocClass'), 'Closure Action', false, GlobalVariable.G_LongTimeout)
WebUI.verifyOptionPresentByLabel(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_ChangeDocClass/select_CurrentDocClass'), 'LinQ DC', false, GlobalVariable.G_LongTimeout)
WebUI.verifyOptionPresentByLabel(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_ChangeDocClass/select_CurrentDocClass'), 'Reference Object Feature', false, GlobalVariable.G_LongTimeout)
WebUI.verifyOptionPresentByLabel(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_ChangeDocClass/select_CurrentDocClass'), 'Route Advance', false, GlobalVariable.G_LongTimeout)
WebUI.verifyOptionPresentByLabel(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_ChangeDocClass/select_CurrentDocClass'), 'WMI Menu', false, GlobalVariable.G_LongTimeout)

'Select WMI Menu Doc class from the list'
WebUI.selectOptionByLabel(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_ChangeDocClass/select_CurrentDocClass'), 'WMI Menu', false)
//WebUI.delay(5)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_ChangeDocClass/iframe_Close Window_ContentPla'))

WebUI.verifyOptionPresentByLabel(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_ChangeDocClass/select_CurrentDocType'), 'WMI Menu BOV', false, GlobalVariable.G_LongTimeout)
WebUI.verifyOptionPresentByLabel(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_ChangeDocClass/select_CurrentDocType'), 'WMI Menu BOV Vertical', false, GlobalVariable.G_LongTimeout)
WebUI.verifyOptionPresentByLabel(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_ChangeDocClass/select_CurrentDocType'), 'WMI Menu Default', false, GlobalVariable.G_LongTimeout)
WebUI.verifyOptionPresentByLabel(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_ChangeDocClass/select_CurrentDocType'), 'WMI Menu DocTwoRow', false, GlobalVariable.G_LongTimeout)
WebUI.verifyOptionPresentByLabel(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_ChangeDocClass/select_CurrentDocType'), 'WMI Menu with visible macro', false, GlobalVariable.G_LongTimeout)

'Select WMI Menu Doc Default type from the list'
WebUI.selectOptionByLabel(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_ChangeDocClass/select_CurrentDocType'), 'WMI Menu Default', false)
WebUI.delay(5)
WebUI.switchToWindowIndex(1)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Fill the details required'
WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_WMI_NEW/WMI_Menu_BOV_Default/customerID'), '200',false)
WebUI.sendKeys(findTestObject('Object Repository/Page_WMI_NEW/WMI_Menu_BOV_Default/BMString'), 'Test')
WebUI.sendKeys(findTestObject('Object Repository/Page_WMI_NEW/WMI_Menu_BOV_Default/customerName'), 'Chintan Shah')

'Save details and close'
WebUI.mouseOver(findTestObject('Object Repository/Page_WMI_NEW/WMI_Menu_BOV_Default/standardActionsUIButton'))
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_WMI_NEW/WMI_Menu_BOV_Default/Save'), GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Window.clickElementAndWaitForWindowClose'(findTestObject('Object Repository/Page_WMI_NEW/WMI_Menu_BOV_Default/Save'),GlobalVariable.G_LongTimeout)

WebUI.switchToWindowTitle('Savana nGage')
'Close create new popup dialog'
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/span_ui-button-icon-primary ui'))

'Go to Recent documents'
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/a_Recent Documents'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/iframe_iframe_103'))

'Verify atleast 1 record is present in grid'
WebUI.verifyElementPresent(findTestObject('Page_nGage_Dashboard/Home/tableRow_recentDocuments_firstRow'), GlobalVariable.G_LongTimeout);

'Sort records in table by DocID Descending'
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Home/div_Doc ID'))
CustomKeywords.'actions.Table.clickColumnHeader'(findTestObject('Page_nGage_Dashboard/Home/div_Doc ID'))

'Verify Column values in 1st record'
CustomKeywords.'actions.Table.verifyCellContainsValue'(findTestObject('Page_nGage_Dashboard/Home/table_MyDocumentResults'), 1, 3, 'WMI Menu Default')
CustomKeywords.'actions.Table.verifyCellContainsValue'(findTestObject('Page_nGage_Dashboard/Home/table_MyDocumentResults'), 1, 4, 'WMI Menu Default')
CustomKeywords.'actions.Table.verifyCellContainsValue'(findTestObject('Page_nGage_Dashboard/Home/table_MyDocumentResults'), 1, 5, 'Created')

'Click on 1st Row'
CustomKeywords.'actions.Table.clickCell'(findTestObject('Page_nGage_Dashboard/Home/table_MyDocumentResults'), 1, 3)

WebUI.switchToWindowTitle('WMI Menu Default')
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

WebUI.verifyOptionSelectedByLabel(findTestObject('Page_WMI/WMI_Menu_BOV_Default/select_CustomerId'), '200', false, GlobalVariable.G_LongTimeout)
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI/WMI_Menu_BOV_Default/textarea_BM String'), 'value', 'Test', GlobalVariable.G_LongTimeout)
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI/WMI_Menu_BOV_Default/textarea_Customer Name'), 'value', 'Chintan Shah', GlobalVariable.G_LongTimeout)


