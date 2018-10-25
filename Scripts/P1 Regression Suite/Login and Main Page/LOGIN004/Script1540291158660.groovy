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

//Login Into Application
CustomKeywords.'actions.Common.login'()

//Click on Global New button
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/input_btnGlobalNew'))

//Select Document class and Document Type

CustomKeywords.'actions.Common.selectDocClassAndDocTypeForGlobalNew'('WMI Menu', 'WMI Menu BOV Vertical')

//Click on OK Button
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/Home/input_btnsave'))
WebUI.switchToWindowTitle('(Doc ID: NEW )')
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

//Set Data
String filePath = RunConfiguration.getProjectDir().replace('/', '\\')+'\\Data Files\\FileUploads\\50 Pages PDF file.pdf'
WebUI.setText(findTestObject('Page_WMI_NEW/WMI_Menu_BOV_Vertical/input_String field'), 'A')
WebUI.uploadFile(findTestObject('Page_WMI_NEW/WMI_Menu_BOV_Vertical/input__file_upload'), filePath)

//Click on Save button
WebUI.mouseOver(findTestObject('Page_WMI_NEW/WMI_Menu_BOV_Vertical/menu_Standard Actions'))
WebUI.waitForElementVisible(findTestObject('Page_WMI_NEW/WMI_Menu_BOV_Vertical/button_Save'), GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Window.clickElementAndWaitForWindowClose'(findTestObject('Page_WMI_NEW/WMI_Menu_BOV_Vertical/button_Save'), GlobalVariable.G_LongTimeout)

//switch to landing page
WebUI.switchToWindowTitle('Savana nGage')

//close the create new pop up
WebUI.click(findTestObject('Page_nGage_Dashboard/Home/span_ui-button-icon-primary ui'))

//click on recent document link
WebUI.click(findTestObject("Object Repository/Page_nGage_Dashboard/Home/a_Recent Documents"))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/iframe_iframe_103'))

//click on Refresh button
WebUI.click(findTestObject("Object Repository/Page_nGage_Dashboard/Home/span_Refresh Grid"))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/iframe_iframe_103'))

//open newly created document from recent doc
WebUI.verifyElementPresent(findTestObject("Object Repository/Page_nGage_Dashboard/Home/tableRow_recentDocuments_firstRow"), 5)
WebUI.click(findTestObject("Object Repository/Page_nGage_Dashboard/Home/tableRow_recentDocuments_firstRow"))
WebUI.switchToWindowTitle("WMI Menu BOV Vertical")
WebUI.waitForPageLoad(60)

//hover mouse on More
WebUI.verifyElementPresent(findTestObject("Page_WMI/WMI_Menu_BOV_Vertical/menu_MORE .."), GlobalVariable.G_LongTimeout)
WebUI.mouseOver(findTestObject("Page_WMI/WMI_Menu_BOV_Vertical/menu_MORE .."))
WebUI.waitForElementVisible(findTestObject("Page_WMI/WMI_Menu_BOV_Vertical/option_Email  Favorites_1"), GlobalVariable.G_LongTimeout)
WebUI.mouseOver(findTestObject("Page_WMI/WMI_Menu_BOV_Vertical/option_Email  Favorites_1"))
WebUI.waitForElementVisible(findTestObject("Page_WMI/WMI_Menu_BOV_Vertical/option_Show Link"), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject("Page_WMI/WMI_Menu_BOV_Vertical/option_Show Link"))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

WebUI.waitForElementVisible(findTestObject("Page_WMI/WMI_Menu_BOV_Vertical/button_TestLink"), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject("Page_WMI/WMI_Menu_BOV_Vertical/button_TestLink"))


//switch to new login window

WebUI.switchToWindowTitle("..:: Savana nGage - Login Screen ::..")
WebUI.waitForPageLoad(60)

WebUI.waitForElementVisible(findTestObject('Page_Login/input_Login1UserName'), GlobalVariable.G_LongTimeout)
WebUI.setText(findTestObject('Page_Login/input_Login1UserName'), GlobalVariable.Username)
WebUI.setText(findTestObject('Page_Login/input_Login1Password'), GlobalVariable.Password)
WebUI.selectOptionByValue(findTestObject('Page_Login/select_ALLIANCE_50CMDRDRC20160'), GlobalVariable.Database, true)
WebUI.click(findTestObject('Page_Login/input_Login1LoginImageButton'))
WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

WebUI.waitForPageLoad(60)

//verify the data
WebUI.verifyElementAttributeValue(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/input_eform_String_Input_Field'), 'value', 'A', GlobalVariable.G_LongTimeout)

WebUI.closeBrowser()














