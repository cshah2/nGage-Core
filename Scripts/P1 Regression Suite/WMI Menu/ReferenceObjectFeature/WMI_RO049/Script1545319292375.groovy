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

'Click on tab - 16) Reference Grid (fullscreen-No/Resizable).'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Reference_Grid_feature/span_16) Reference Grid (fulls'))
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)

'click on grid first record'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Reference_Grid_feature/tab_16)Reference Grid(fullscreen No Resizable)/tr_tableFirstRow'))
CustomKeywords.'actions.Window.verifyOpenWindowCount'(3)

'verify document opened in window'
CustomKeywords.'actions.Window.verifyOpenWindowCount'(3)
WebUI.switchToWindowIndex(2)

int height_BeforeResize=WebUI.getPageHeight()
int width_BeforeResize=WebUI.getPageWidth()

'verify document is not full screen'
WebUI.verifyNotMatch(height_BeforeResize.toString(), '677', false)
WebUI.verifyNotMatch(width_BeforeResize.toString(), '1366', false)

'verify document window resizable'
'resize document'
WebUI.maximizeWindow()
WebUI.delay(5)

int height_AfterResize=WebUI.getPageHeight()
int width_AfterResize=WebUI.getPageWidth()

'verify window resizable'
WebUI.verifyGreaterThan(height_AfterResize,height_BeforeResize)
WebUI.verifyGreaterThan(width_AfterResize,width_BeforeResize)