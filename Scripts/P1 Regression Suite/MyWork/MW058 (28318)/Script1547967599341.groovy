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
import static utils.Consts.*

'Login Into Application'
CustomKeywords.'actions.Common.login'()

'Create Documents'
CustomKeywords.'actions.Common.createDocument_VerticalMenuWizard'(P1_LOANAPPL_FIRSTNAME_DOC1, P1_LOANAPPL_LASTNAME_DOC1, P1_LOANAPPL_AMOUNT_DOC1)

'Click on My Work link from left menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_iframe_105'))

'Click Tree Menu Loan Interactive - Loan application'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('MY_WORK', 'Processes', 'Loan Interactive', 'Loan Application')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

'right click on (option)loan approval'
CustomKeywords.'actions.MenuBar.rightClickTreeMenu'('MY_WORK', 'Processes', 'Loan Interactive', 'Loan Application')
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Select Foldering configuration option from context menu'
CustomKeywords.'actions.ContextMenu.clickOption'(findTestObject('Page_nGage_Dashboard/contextMenuOptions'), 'Foldering Configuration')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/Folder_Configuration/iframe_Close_iframe_folderingC'))

'Click on Restore defaults'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/Folder_Configuration/button_Restore Default'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/Folder_Configuration/iframe_Close_iframe_folderingC'))

'select drpdown options'
WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Folder_Configuration/Level1_FieldAssigned'),'SLA Indicator*',false)

'click submit button'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Folder_Configuration/button_Save'))

'click close button'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Folder_Configuration/button_Close'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Verify Folders are configured as per Firstname value'
CustomKeywords.'actions.MenuBar.verifySubMenuPresent'('MY_WORK', 'On Time', 'Processes', 'Loan Interactive', 'Loan Application')

'Click on Foldered Menu under Loan application'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('MY_WORK', 'Processes', 'Loan Interactive', 'Loan Application', 'On Time')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

'get record count displayed in tree'
int recordCountActivity = CustomKeywords.'actions.MenuBar.getRecordCountInActivity'('MY_WORK', 'Processes', 'Loan Interactive', 'Loan Application', 'On Time')

'Verify record count in activity tree and grid matches'
CustomKeywords.'actions.Common.verifyTotalRecordCountFromPageSummary'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/div_PageCount'), recordCountActivity)

'right click on (option)loan approval'
CustomKeywords.'actions.MenuBar.rightClickTreeMenu'('MY_WORK', 'Processes', 'Loan Interactive', 'Loan Application')
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Select Foldering configuration option from context menu'
CustomKeywords.'actions.ContextMenu.clickOption'(findTestObject('Page_nGage_Dashboard/contextMenuOptions'), 'Foldering Configuration')
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/Folder_Configuration/iframe_Close_iframe_folderingC'))

'Click on Restore defaults'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/Folder_Configuration/button_Restore Default'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/Folder_Configuration/iframe_Close_iframe_folderingC'))

'click submit button'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Folder_Configuration/button_Save'))

'click close button'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Folder_Configuration/button_Close'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)