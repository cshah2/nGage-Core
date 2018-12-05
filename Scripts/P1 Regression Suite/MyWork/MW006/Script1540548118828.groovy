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

'Click on My Work link from left menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_iframe_105'))

'expand loan interactive link from left menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/icon_Expand_LoanInteractive'))

'wait for (option) Loan application visible'
WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/My_Work/a_LoanApplication'), GlobalVariable.G_LongTimeout)

'right click on (option)loan approval(21)'
WebUI.rightClick(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/LoanInteractive_MyWork/a_LoanApproval(21)'))

'click on (option)foldering configuration'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/LoanInteractive_MyWork/a_Foldering Configuration'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'verify labels'
WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Folder_Configuration/Label_ActivityName')), 'Loan Approval', false)
WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Folder_Configuration/Label_ProcessName')), 'Loan Interactive', false)
WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Folder_Configuration/Label_SearchClassID')), '100009', false)

'select drpdown options'
WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Folder_Configuration/Level1_FieldAssigned'),'Assigned User Group/No User Group*',false)
WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Folder_Configuration/Level1_Sorting'), 'Desc by Field',false)

'click submit button'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Folder_Configuration/button_Save'))

'click close button'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Folder_Configuration/button_Close'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'right click on (option)loan approval(21)'
WebUI.rightClick(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/LoanInteractive_MyWork/a_LoanApproval(21)'))

'click on (option)foldering configuration'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/LoanInteractive_MyWork/a_Foldering Configuration'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'verify assigned fields'
WebUI.verifyOptionSelectedByLabel(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Folder_Configuration/Level1_FieldAssigned'), '.*Assigned User Group/No User Group*.*', true, GlobalVariable.G_LongTimeout)
WebUI.verifyOptionSelectedByLabel(findTestObject('Page_nGage_Dashboard/My_Work/Folder_Configuration/Level1_Sorting'), '.*Desc by Field.*', true, GlobalVariable.G_LongTimeout)

'click restore default button'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Folder_Configuration/button_Restore Default'))

'click submit button'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Folder_Configuration/button_Save'))

'click close button'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Folder_Configuration/button_Close'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)