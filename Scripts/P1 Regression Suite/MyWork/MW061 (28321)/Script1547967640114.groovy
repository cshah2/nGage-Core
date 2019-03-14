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

'Login Into Application'
CustomKeywords.'actions.Common.login'()

'Create Document'
if(!FLAG_P1_MW_DOC181) {
	CustomKeywords.'actions.Data.create'(DocClass.EVENT_FOR_REQUIRED_FIELD, DocType.EVENT_FOR_REQUIRED_FIELD, P1_MW_DOC181)
	FLAG_P1_MW_DOC181 = true
}
if(!FLAG_P1_MW_DOC182) {
	CustomKeywords.'actions.Data.create'(DocClass.EVENT_FOR_REQUIRED_FIELD, DocType.EVENT_FOR_REQUIRED_FIELD, P1_MW_DOC182)
	FLAG_P1_MW_DOC182 = true
}

String dropDown1 = P1_MW_DOC181.get(Fields.DROP_DOWN_CONTROL)
String stringField1 = P1_MW_DOC181.get(Fields.STRING_FIELD)

String dropDown2 = P1_MW_DOC182.get(Fields.DROP_DOWN_CONTROL)
String stringField2 = P1_MW_DOC182.get(Fields.STRING_FIELD)

'Click on My Work link from left menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_iframe_105'))

'Verify tree folder is correct'
CustomKeywords.'actions.MenuBar.verifySubMenuPresent'('MY_WORK', stringField1, 'Processes','Event for required field','User activity')
CustomKeywords.'actions.MenuBar.verifySubMenuPresent'('MY_WORK', dropDown1, 'Processes','Event for required field','User activity', stringField1)

'Click Tree Menu'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('MY_WORK', 'Processes','Event for required field','User activity', stringField1, dropDown1)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

'keep track of activity count before refresh'
int activityCount1=CustomKeywords.'actions.MenuBar.getRecordCountInActivity'('MY_WORK', 'Processes','Event for required field','User activity', stringField1, dropDown1)
CustomKeywords.'actions.Common.verifyTotalRecordCountFromPageSummary'(findTestObject('Page_nGage_Dashboard/My_Work/table_pagination_summary'), activityCount1)

'Verify tree folder is correct'
CustomKeywords.'actions.MenuBar.verifySubMenuPresent'('MY_WORK', stringField2, 'Processes','Event for required field','User activity')
CustomKeywords.'actions.MenuBar.verifySubMenuPresent'('MY_WORK', dropDown2, 'Processes','Event for required field','User activity', stringField2)

'Click Tree Menu'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('MY_WORK', 'Processes','Event for required field','User activity', stringField2, dropDown2)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/My_Work/iframe_work_items'))

'keep track of activity count before refresh'
int activityCount2=CustomKeywords.'actions.MenuBar.getRecordCountInActivity'('MY_WORK', 'Processes','Event for required field','User activity', stringField2, dropDown2)
CustomKeywords.'actions.Common.verifyTotalRecordCountFromPageSummary'(findTestObject('Page_nGage_Dashboard/My_Work/table_pagination_summary'), activityCount2)