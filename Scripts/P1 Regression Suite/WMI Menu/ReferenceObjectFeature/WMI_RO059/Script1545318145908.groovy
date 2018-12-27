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
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'('Reference Object Feature', 'Reference Object Grid Features')
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

WebUI.switchToWindowTitle('(Doc ID: NEW )')
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Verify tabs Reference grid (Sorting),Reference grid(Pagesize(single page) are visible'
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Reference_Grid_feature/span_1) Reference Grid (Sortin'))
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Reference_Grid_feature/span_2) Reference Grid (Pagesi'))
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Reference_Grid_feature/span_3) Reference Grid (Pagesi'))
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Reference_Grid_feature/span_4) Reference Grid (Pagesi'))

'Click on tab - 26) Reference Grid (ViewAllContentsTooltip).'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Reference_Grid_feature/span_26) Reference Grid (ViewA'))
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)

'"verify Tooltip for contentfile" icon displayed on grid '
CustomKeywords.'actions.Table.verifyButtonPresentInWMITable'(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Reference_Grid_feature/tab_26) Reference Grid (ViewAllContentsTooltip)/table_GVGrid'), 'verify Tooltip for contentfile')

'check first record of grid'
WebUI.check(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Reference_Grid_feature/tab_26) Reference Grid (ViewAllContentsTooltip)/input_checkFirstRow'))

'verify first record is checked'
WebUI.verifyElementChecked(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Reference_Grid_feature/tab_26) Reference Grid (ViewAllContentsTooltip)/input_checkFirstRow'), GlobalVariable.G_LongTimeout)

'check all records in grid'
WebUI.check(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Reference_Grid_feature/tab_26) Reference Grid (ViewAllContentsTooltip)/input_checkAll'))

'verify all the records in grid are checked'
CustomKeywords.'actions.Table.verifyAllRecordsAreChecked'(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Reference_Grid_feature/tab_26) Reference Grid (ViewAllContentsTooltip)/table_GVGrid'))