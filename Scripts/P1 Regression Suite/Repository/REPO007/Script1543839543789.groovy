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

'Login into application'
CustomKeywords.'actions.Common.login'()

'Click on Repository Menu'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/h3_Repository Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Click the EDM to open the opo up window'
CustomKeywords.'actions.MenuBar.doubleClickTreeMenu'('REPO', 'Required Date string field EDM', 'Required field date string search class', 'Chintan Shah')
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Enter data in the pop up window and search'
WebUI.setText(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/EDM_PopUp_BMRequiredField'), 'test')
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/EDM_PopUpSearchButton'))

'Verify EDM shows test EDM below Chintan'
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/EDM_Test_REPO07'))

'Click on test EDM'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/EDM_Test_REPO07'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/BrowseResults Tab/iframe_BROWSETAB_iframe'))

'Verify the records showing in EDM and table are matching for Test EDM'
CustomKeywords.'actions.Common.verifyRecordCountMatchesInActivityAndGrid'(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/EDM_Test_REPO07'), findTestObject('Object Repository/Page_nGage_Dashboard/Repository/BrowseResults Tab/Table_PageResults'))