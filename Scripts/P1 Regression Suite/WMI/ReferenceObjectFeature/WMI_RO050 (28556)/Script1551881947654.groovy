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

'Click on Global New button'
WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))

'Create a new Refrence Object Feature Document'
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'('Reference Object Feature', 'Reference Object Grid Features')
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

'Switch to WMI page'
WebUI.switchToWindowIndex(1)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Verify tabs Reference grid (Sorting),Reference grid(Pagesize(single page) are visible'
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Reference_Grid_feature/span_1) Reference Grid (Sortin'))
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Reference_Grid_feature/span_2) Reference Grid (Pagesi'))
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Reference_Grid_feature/span_3) Reference Grid (Pagesi'))
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Reference_Grid_feature/span_4) Reference Grid (Pagesi'))

'Click on tab - 17) Reference (Resizable/Height,Width).'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Reference_Grid_feature/span_17) Reference Grid (Resiz'))
CustomKeywords.'actions.Common.waitForTabLoading'(null, GlobalVariable.G_LongTimeout)

'click on first record of grid'
WebUI.click(findTestObject('Object Repository/Page_WMI_NEW/Reference_Object_Feature/Reference_Grid_feature/tab_17) Reference (Resizable Height,Width)/tr_TableFirstRow'))

'Verify new window is opened to load selected document'
CustomKeywords.'actions.Window.verifyOpenWindowCount'(3)

'Switch to new window'
WebUI.switchToWindowIndex(2)
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

int height_BeforeResize=WebUI.getPageHeight()
int width_BeforeResize=WebUI.getPageWidth()

'verify height and width of document as per configuration ' //height = 436 , width 198
println "Height = "+height_BeforeResize+" and Width = "+width_BeforeResize
WebUI.verifyGreaterThanOrEqual(height_BeforeResize, 400)
WebUI.verifyLessThanOrEqual(height_BeforeResize, 500)

WebUI.verifyGreaterThanOrEqual(width_BeforeResize, 150)
WebUI.verifyLessThanOrEqual(width_BeforeResize, 250)

'Maximize window'
WebUI.maximizeWindow()
WebUI.delay(2)


int height_AfterResize=WebUI.getPageHeight()
int width_AfterResize=WebUI.getPageWidth()

'verify window resizable'
println "Height = "+height_AfterResize+" and Width = "+width_AfterResize
WebUI.verifyGreaterThan(height_AfterResize,height_BeforeResize)
WebUI.verifyGreaterThan(width_AfterResize,width_BeforeResize)