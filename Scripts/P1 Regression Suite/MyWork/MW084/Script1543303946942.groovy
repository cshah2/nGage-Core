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

'Create new Document in DateTimeRequired activity'
CustomKeywords.'actions.Common.createDocument_MyWorkDateTime'('Datetimerequired','Datetimerequired','01012018','01012025','01012018 05:08:14 PM','08-30-2002 09:29:45 AM','Test')

'Verify all activity names are valid Date'
//CustomKeywords.'actions.MenuBar.verifyAllActivityNamesAreValidDate'('My_Work','MM/DD/YYYY','Processes','Datetimerequired','Datetimerequired')

'Expand Processes and select Activity'
CustomKeywords.'actions.MenuBar.clickTreeMenu'('My_Work','Processes','Datetimerequired','Datetimerequired','01/01/2018')
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)



//'Verify DateTimeRequired activity with Expandable Icon is present'
//WebUI.click(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/process_DateTimeRequired/icon_DateTimeRequired_ExpandAgain'))
//
//'Verify Date format present with MM/DD/YYYY format(No time)'
//CustomKeywords.'actions.Common.verifyDateFormat'(WebUI.getText(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/Process_Date Required/a_06-06-2017_DateRequiredSearch')).split('[(]')[0].trim(), 'MM/DD/YYYY')
//

