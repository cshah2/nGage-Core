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

'Create document closure action'
CustomKeywords.'actions.Common.createDocument_ClosureAction'('Chintan Shah', 'Description')

'Click on My Work link from left menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_iframe_105'))

'Right Click on Activity A'
CustomKeywords.'actions.MenuBar.rightClickTreeMenu'('My_Work','Processes','Closure Action','Activity A')
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Foldering Configuration Menu should be visible'
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/LoanInteractive_MyWork/a_Foldering Configuration'))

'click on (option)foldering configuration'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/LoanInteractive_MyWork/a_Foldering Configuration'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Verify folder configuration window should launch and the fields should be editable'
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Folder_Configuration/Level1_FieldAssigned'))
WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Folder_Configuration/Level1_FieldAssigned'),'Customer Name',false)
WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Folder_Configuration/Level1_Sorting'), 'Desc by Field',false)

'click save button'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Folder_Configuration/button_Save'))

'click close button'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Folder_Configuration/button_Close'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

//'Expand activity A'
//WebUI.waitForElementVisible(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/a_Activity A'), 0)
//WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Closure Action/icon_Expand ActivityA'))
//WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'verify sorted order of sub menus (Descending by name)'
List<String> subMenusDesc = CustomKeywords.'actions.MenuBar.getAllSubMenus'('My_Work','Processes','Closure Action','Activity A')
CustomKeywords.'actions.MenuBar.verifyAllSubmenuAreSortedByActivityName'(subMenusDesc,'desc')

'right click on field below activity which is foldered'
CustomKeywords.'actions.MenuBar.rightClickTreeMenu'('My_Work','Processes','Closure Action','Activity A','Chintan Shah')
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'click on (option)foldering configuration'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/LoanInteractive_MyWork/a_Foldering Configuration'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'Verify folder configuration window should launch and the fields should be editable'
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Folder_Configuration/Level1_FieldAssigned'))
WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Folder_Configuration/Level1_FieldAssigned'),'Customer Name',false)
WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Folder_Configuration/Level1_Sorting'), 'Asc by Field',false)

'click save button'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Folder_Configuration/button_Save'))

'click close button'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Folder_Configuration/button_Close'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'verify sorted order of sub menus (Descending by name)'
List<String> subMenusAsc = CustomKeywords.'actions.MenuBar.getAllSubMenus'('My_Work','Processes','Closure Action','Activity A')
CustomKeywords.'actions.MenuBar.verifyAllSubmenuAreSortedByActivityName'(subMenusAsc,'asc')

'right click on field below activity which is foldered'
CustomKeywords.'actions.MenuBar.rightClickTreeMenu'('My_Work','Processes','Closure Action','Activity A','Chintan Shah')
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'click on (option)foldering configuration'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/LoanInteractive_MyWork/a_Foldering Configuration'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'click restore default button'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Folder_Configuration/button_Restore Default'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'click submit button'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Folder_Configuration/button_Save'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'click close button'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Folder_Configuration/button_Close'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)