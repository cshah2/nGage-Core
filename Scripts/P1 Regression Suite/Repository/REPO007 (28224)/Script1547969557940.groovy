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

import common.DocClass
import common.DocType
import common.Fields
import internal.GlobalVariable as GlobalVariable
import static utils.Consts.*

'Login into application'
CustomKeywords.'actions.Common.login'()

'Create Document if not present'
if(!FLAG_P1_REPO_DOC121) {
	CustomKeywords.'actions.Data.create'(DocClass.REQUIRED_FIELD_DC, DocType.REQUIRED_FIELD_DT, P1_REPO_DOC121)
	FLAG_P1_REPO_DOC121 = true
}
String bmString = P1_REPO_DOC121.get(Fields.BM_STRING)

'Click on Repository Menu'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/h3_Repository Menu'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Click the EDM to open the opo up window'
CustomKeywords.'actions.MenuBar.doubleClickTreeMenu'('REPO', 'Required Date string field EDM', 'Required field date string search class', 'Chintan Shah')
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Enter data in the pop up window and search'
WebUI.setText(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/EDM_PopUp_BMRequiredField'), bmString)
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/EDM_PopUpSearchButton'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Verify SubMenu is present in tree'
CustomKeywords.'actions.MenuBar.verifySubMenuPresent'('REPO', bmString, 'Required Date string field EDM', 'Required field date string search class', 'Chintan Shah')

'Click on newly searched tree menu'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('REPO', 'Required Date string field EDM', 'Required field date string search class', 'Chintan Shah', bmString)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Repository/BrowseResults Tab/iframe_BROWSETAB_iframe'))

'Verify record counts are matching'
int recordCountInActivity = CustomKeywords.'actions.MenuBar.getRecordCountInActivity'('REPO', 'Required Date string field EDM', 'Required field date string search class', 'Chintan Shah', bmString)
CustomKeywords.'actions.Common.verifyTotalRecordCountFromPageSummary'(findTestObject('Page_nGage_Dashboard/Repository/BrowseResults Tab/Table_PageResults'), recordCountInActivity)