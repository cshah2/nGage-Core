import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
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

//WMI Menu Bov Check
'Pre-Requisite : Create new Document of type WMI Menu Bov'
CustomKeywords.'actions.Common.createDocument_WMIMenuBov'()

'Pre-Requisite : Open newly created document from recent grid'
CustomKeywords.'actions.Common.openDocumentFromRecentGrid'('WMI Menu BOV')

'Navigate and verify pageSource'
WebUI.waitForElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV/span_MORE'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Object Repository/Page_WMI/WMI_Menu_BOV/div_Capture object_northToggle'))
WebUI.mouseOver(findTestObject('Page_WMI/WMI_Menu_BOV/span_MORE'))
WebUI.waitForElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV/a_Email  Favorites_1'), GlobalVariable.G_LongTimeout)
WebUI.mouseOver(findTestObject('Page_WMI/WMI_Menu_BOV/a_Email  Favorites_1'))
WebUI.waitForElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV/a_Show Link'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_WMI/WMI_Menu_BOV/a_Show Link'))
WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Object Repository/Page_WMI/WMI_Menu_BOV/iframe_Close_ContentPlaceHolde'), 'src'), '.*showlink.aspx.*', true)
WebUI.click(findTestObject('Object Repository/Page_WMI/WMI_Menu_BOV/span_Close'))


//WMI Menu Bov Default Check
'Pre-Requisite : Create new Document of type WMI Menu Default'
CustomKeywords.'actions.Common.createDocument_WMIMenuBovDefault'()

'Pre-Requisite : Open newly created document from recent grid'
CustomKeywords.'actions.Common.openDocumentFromRecentGrid'('WMI Menu Default')

'Navigate and verify pageSource'
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_WMI/WMI_Menu_BOV_Default/span_MORE'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Object Repository/Page_WMI/WMI_Menu_BOV_Default/div_Capture object_northToggle'))
WebUI.mouseOver(findTestObject('Object Repository/Page_WMI/WMI_Menu_BOV_Default/span_MORE'))
WebUI.waitForElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Default/a_Email  Favorites_1'), GlobalVariable.G_LongTimeout)
WebUI.mouseOver(findTestObject('Page_WMI/WMI_Menu_BOV_Default/a_Email  Favorites_1'))
WebUI.waitForElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_Default/a_Show Link'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_WMI/WMI_Menu_BOV_Default/a_Show Link'))
WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Object Repository/Page_WMI/WMI_Menu_BOV_Default/iframe_Close_ContentPlaceHolde'), 'src'), '.*showlink.aspx.*', true)
WebUI.click(findTestObject('Object Repository/Page_WMI/WMI_Menu_BOV_Default/span_Close'))

//WMI Menu Bov DocTwoRow Check
'Pre-Requisite : Create new Document of type WMI Menu DocTwoRow'
CustomKeywords.'actions.Common.createDocument_WMIMenuBovDocTwoRow'()

'Pre-Requisite : Open newly created document from recent grid'
CustomKeywords.'actions.Common.openDocumentFromRecentGrid'('WMI Menu DocTwoRow')

'Navigate and verify pageSource'
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_WMI/WMI_Menu_BOV_DocTwoRow/span_MORE'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Object Repository/Page_WMI/WMI_Menu_BOV_DocTwoRow/div_Capture object_northToggle'))
WebUI.mouseOver(findTestObject('Object Repository/Page_WMI/WMI_Menu_BOV_DocTwoRow/span_MORE'))
WebUI.waitForElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_DocTwoRow/a_Email  Favorites_1'), GlobalVariable.G_LongTimeout)
WebUI.mouseOver(findTestObject('Page_WMI/WMI_Menu_BOV_DocTwoRow/a_Email  Favorites_1'))
WebUI.waitForElementVisible(findTestObject('Page_WMI/WMI_Menu_BOV_DocTwoRow/a_Show Link'), GlobalVariable.G_LongTimeout)
WebUI.click(findTestObject('Page_WMI/WMI_Menu_BOV_DocTwoRow/a_Show Link'))
WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Object Repository/Page_WMI/WMI_Menu_BOV_DocTwoRow/iframe_Close_ContentPlaceHolde'), 'src'), '.*showlink.aspx.*', true)
WebUI.click(findTestObject('Object Repository/Page_WMI/WMI_Menu_BOV_DocTwoRow/span_Close'))
