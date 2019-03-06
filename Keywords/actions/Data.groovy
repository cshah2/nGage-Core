package actions

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.apache.commons.lang3.StringUtils

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import utils.Fields
import static utils.Consts.*

public class Data {
	
	@Keyword
	def create(String docClass, String docType, Map<Fields, String> data) {

		//Switch to main window
		WebUI.switchToWindowTitle('Savana nGage')

		//Select DocClass and Doc Type
		WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))
		new Common().selectDocClassAndDocTypeForGlobalNew(docClass, docType)
		
		//Click on OK button
		WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

		//Switch to new Window
		WebUI.switchToWindowIndex(1)
		WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
		
		switch(docType) {
			
			case DT_COMPLAINT_TEMPLATE:
				complaintTemplate(data)
				break

			default:
				WebUI.takeScreenshot()
				KeywordUtil.markFailedAndStop('Unable to create document, Invalid docType provided : '+docType)
				break
		}
		
		//Switch to main window
		WebUI.switchToWindowTitle('Savana nGage')
		
		//Close pop up dialog
		WebUI.click(findTestObject('Page_nGage_Dashboard/Home/span_ui-button-icon-primary ui'))
	}
	
	private void complaintTemplate(Map<Fields, String> data) {
		
		//Get Data from Map
		String templateName = data.get(Fields.TEMPLATE_NAME)
		String templateText = data.get(Fields.TEMPLATE_TEXT)
		
		//Fill form
		if(StringUtils.isNotBlank(templateName))
			WebUI.setText(findTestObject('Page_WMI_NEW/Complaints Templates/Complaint Template/input_Template Name'), templateName)
		if(StringUtils.isNotBlank(templateText))
			WebUI.setText(findTestObject('Page_WMI_NEW/Complaints Templates/Complaint Template/body_Template Text'), templateText)
		//Click on Save button
		new Window().clickElementAndWaitForWindowClose(findTestObject('Page_WMI_NEW/Complaints Templates/Complaint Template/btn_Save'), GlobalVariable.G_LongTimeout)
	}
}
