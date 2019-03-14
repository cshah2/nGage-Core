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
import static utils.DateUtil.*

'Login Into Application'
CustomKeywords.'actions.Common.login'()

'Create Document'
if(!FLAG_P1_MW_DOC181) {
	CustomKeywords.'actions.Data.create'(DocClass.EVENT_FOR_REQUIRED_FIELD, DocType.EVENT_FOR_REQUIRED_FIELD, P1_MW_DOC181)
	FLAG_P1_MW_DOC181 = true
}

String dropDown = P1_MW_DOC181.get(Fields.DROP_DOWN_CONTROL)
String stringField = P1_MW_DOC181.get(Fields.STRING_FIELD)
String date = P1_MW_DOC181.get(Fields.DATE)

'Click on My Work link from left menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_iframe_105'))

String treeDate = convert(date, FORMAT_DATE, FORMAT_DATE_TREE)

'Verify tree folder is correct'
CustomKeywords.'actions.MenuBar.verifySubMenuPresent'('MY_WORK', stringField, 'Processes','Event for required field','User activity')
CustomKeywords.'actions.MenuBar.verifySubMenuPresent'('MY_WORK', dropDown, 'Processes','Event for required field','User activity', stringField)
CustomKeywords.'actions.MenuBar.verifySubMenuPresent'('MY_WORK', date, 'Processes','Event for required field','User activity', stringField, dropDown)