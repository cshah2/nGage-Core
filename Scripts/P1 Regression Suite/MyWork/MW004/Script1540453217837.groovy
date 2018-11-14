import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

'Login Into Application'
CustomKeywords.'actions.Common.login'()

'Click on My Work link from left menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_iframe_105'))

'expand loan interactive link from left menu'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/i_LoanInteractive'))

'wait for (option) Loan application visible'
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/a_LoanApplication(59)'), GlobalVariable.G_LongTimeout)

'right click on (Option) Loan_Application(59)'
WebUI.rightClick(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/a_LoanApplication(59)'))

'click on (option)foldering configuration'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/LoanInteractive_MyWork/a_Foldering Configuration'))
WebUI.waitForJQueryLoad(10)

'verify labels'
WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Folder_Configuration/Label_ActivityName')), 'Loan Application', false)
WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Folder_Configuration/Label_ProcessName')), 'Loan Interactive', false)
WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Folder_Configuration/Label_SearchClassID')), '100009', false)

'select drpdown options'
WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Folder_Configuration/Level1_FieldAssigned'),'Assigned User Group/No User Group*',false)
WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Folder_Configuration/Level1_Sorting'), 'Desc by Field',false)
//WebUI.selectOptionByIndex(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Folder_Configuration/Level2_FieldAssigned'), 2)
//WebUI.selectOptionByIndex(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Folder_Configuration/Level2_Sorting'), 2)
//WebUI.selectOptionByIndex(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Folder_Configuration/Level3_FieldAssigned'), 2)
//WebUI.selectOptionByIndex(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Folder_Configuration/Level3_Sorting'), 2)

'click submit button'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Folder_Configuration/button_Save'))

'click close button'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Folder_Configuration/button_Close'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
WebUI.delay(2)

'verify icon presence'
println "1st"+WebUI.getCSSValue(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/i_LoanApplication'), 'background-image')
WebUI.verifyMatch(WebUI.getCSSValue(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/i_LoanApplication'), 'background-image'), '.*jstree_32px.png.*', true)

//WebUI.verifyElementPresent(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/i_LoanApplication'),GlobalVariable.G_LongTimeout)
//WebUI.verifyElementVisible(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/i_LoanApplication'))

//Restore Defaults
'right click on (Option) Loan_Application(59)'
WebUI.rightClick(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/a_LoanApplication(59)'))

'click on (option)foldering configuration'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/LoanInteractive_MyWork/a_Foldering Configuration'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'verify labels'
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Folder_Configuration/Label_ActivityName'), GlobalVariable.G_LongTimeout)
WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Folder_Configuration/Label_ActivityName')), 'Loan Application', false)
WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Folder_Configuration/Label_ProcessName')), 'Loan Interactive', false)
WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Folder_Configuration/Label_SearchClassID')), '100009', false)

'click restore default button'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Folder_Configuration/button_Restore Default'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'verify assigned fields'
WebUI.verifyOptionSelectedByLabel(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Folder_Configuration/Level1_FieldAssigned'), '.*Select a Field.*', true, GlobalVariable.G_LongTimeout)

'click submit button'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Folder_Configuration/button_Save'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'click close button'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Folder_Configuration/button_Close'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'right click on (Option) Loan_Application(59)'
WebUI.rightClick(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/a_LoanApplication(59)'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'click on refresh'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/contextMenu_Refresh'))
WebUI.delay(2)

'verify icon not present'
//WebUI.verifyElementNotVisible(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/i_LoanApplication'))
println "2nd"+WebUI.getCSSValue(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/i_LoanApplication'), 'background-image')
WebUI.verifyMatch(WebUI.getCSSValue(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/i_LoanApplication'), 'background-image'), '.*none.*', true)	