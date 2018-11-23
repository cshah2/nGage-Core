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

'Verify the Repository Menu is visible'
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/h3_Repository Menu'))

'Click on Repository Menu'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/h3_Repository Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Click on Business Model in EDM'
WebUI.click(findTestObject('Page_nGage_Dashboard/Repository/Business_Model_Tree/EDM_BusinessModel'))

'Click on EDM to expand. select search class which has fields configured as folder'
WebUI.doubleClick(findTestObject('Page_nGage_Dashboard/Repository/Business_Model_Tree/EDM_BusinessModel'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Click to expand Sub_Menu Business Model'
WebUI.doubleClick(findTestObject('Page_nGage_Dashboard/Repository/Business_Model_Tree/EDM_BusinessModel_SubMenu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Click on Render All Fields Sub Menu'
WebUI.doubleClick(findTestObject('Page_nGage_Dashboard/Repository/Business_Model_Tree/EDM_BusinessModel_RenderAllSubMenu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Click on Chintan from Render All Fields Sub Menu'
WebUI.doubleClick(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/Business_Model_Tree/EDM_Chintan'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Right click on This is test sub menu'
WebUI.rightClick(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/Business_Model_Tree/EDM_This_Is_Test'))

'Click on New Document'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/EDM_NewDocument'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Select  Doc Class and Doc Type'
CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'('Master Object Feature', 'Render All Field Types')

'Click on OK Button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))
WebUI.switchToWindowTitle('(Doc ID: NEW )')
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

'Verify value of the field selected in left panel should appear populated in specific field in wmi.'
WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Page_nGage_Dashboard/Repository/Business_Model_Tree/stringFieldTextBox'), 'value', 'This is Test', GlobalVariable.G_LongTimeout)