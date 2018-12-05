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
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/i_PostmanProcesses1'), GlobalVariable.G_LongTimeout)

'expand postman process1'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/i_PostmanProcesses1'))
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/a_NewProcessHoldActivity'), GlobalVariable.G_LongTimeout)

'click on newProcessHoldActivity'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/a_NewProcessHoldActivity'))

'wait for jQuery Loading'
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'reset layout'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/td_ResetLayout'))

//println 'DocID_PositionBefore : '+CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'Doc ID')
//println 'ToActivityState_PositionAfter :'+CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'To Activity State')

int DocID_PositionBefore=CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'Doc ID')

'drag and drop item/Change Layout'
WebUI.dragAndDropToObject(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/div_ToActivityState'), findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/div_DocID'))

'click on set layout'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/span_SetLayout'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))

'click on refresh'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/td_refreshGrid MyWorkSearchResult'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_work_items'))

//println 'DocID_PositionBefore : '+CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'Doc ID')
//println 'ToActivityState_PositionAfter :'+CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'To Activity State')

int ToActivityState_PositionAfter=CustomKeywords.'actions.Table.getColumnNumber'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/tableHeader_MyWorkSearchResult'), 'To Activity State')

'verify column index'
WebUI.verifyMatch(DocID_PositionBefore.toString().trim(), ToActivityState_PositionAfter.toString().trim(), false)

'click on another process (Closure action)'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/a_Closure Action Process'))
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/iframe_iframe_105'))

'click on newProcessHoldActivity'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/a_NewProcessHoldActivity'))

'wait for jQuery Loading'
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

'verify column index'
WebUI.verifyMatch(DocID_PositionBefore.toString().trim(), ToActivityState_PositionAfter.toString().trim(), false)

'reset layout'
WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/td_ResetLayout'))