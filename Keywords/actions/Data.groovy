package actions

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.apache.commons.lang3.StringUtils

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.configuration.RunConfiguration
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
import common.DocClass
import common.DocType
import common.Fields
import static utils.Consts.*

public class Data {

	@Keyword
	def create(DocClass docClass, DocType docType, Map<Fields, String> data) {

		//Switch to main window
		WebUI.switchToWindowTitle('Savana nGage')

		//Select DocClass and Doc Type
		WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))
		new Common().selectDocClassAndDocTypeForGlobalNew(docClass.toString(), docType.toString())

		//Click on OK button
		WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

		//Switch to new Window
		WebUI.switchToWindowIndex(1)
		WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

		switch(docType) {

			case DocType.COMPLAINT_TEMPLATE:
				complaintTemplate(data)
				break

			case DocType.WMI_MENU_BOV:
				wmiMenuBov(data)
				break
				
			case DocType.WMI_MENU_DEFAULT:
				wmiMenuDefault(data)
				break
			
			case DocType.WMI_MENU_DOCTWOROW:
				wmiMenuDocTwoRow(data)
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
	
	private void wmiMenuBov(Map<Fields, String> data) {

		//Get Data from Map
		String custId = data.get(Fields.CUSTOMER_ID)
		String bmString = data.get(Fields.BM_STRING)
		String custName = data.get(Fields.CUSTOMER_NAME)
		String file = data.get(Fields.UPLOAD_FILE)

		//Fill Form
		WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_WMI_NEW/WMI_Menu_BOV/selectCustomerId'), custId,false)
		WebUI.sendKeys(findTestObject('Object Repository/Page_WMI_NEW/WMI_Menu_BOV/inputBMString'), bmString)
		WebUI.sendKeys(findTestObject('Object Repository/Page_WMI_NEW/WMI_Menu_BOV/inputCustomerName'), custName)
		WebUI.uploadFile(findTestObject('Object Repository/Page_WMI_NEW/WMI_Menu_BOV/inputUpload'), file)

		//Save and Close window
		WebUI.mouseOver(findTestObject('Object Repository/Page_WMI_NEW/WMI_Menu_BOV/buttonStandardActions'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Page_WMI_NEW/WMI_Menu_BOV/buttonSave'), GlobalVariable.G_LongTimeout)
		new Window().clickElementAndWaitForWindowClose(findTestObject('Object Repository/Page_WMI_NEW/WMI_Menu_BOV/buttonSave'),GlobalVariable.G_LongTimeout)
	}
	
	private void wmiMenuDefault(Map<Fields, String> data) {
		
		//Get Data from Map
		String custId = data.get(Fields.CUSTOMER_ID)
		String bmString = data.get(Fields.BM_STRING)
		String custName = data.get(Fields.CUSTOMER_NAME)
		String file = data.get(Fields.UPLOAD_FILE)

		//Fill Form
		WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_WMI_NEW/WMI_Menu_BOV_Default/customerID'), custId,false)
		WebUI.sendKeys(findTestObject('Object Repository/Page_WMI_NEW/WMI_Menu_BOV_Default/BMString'), bmString)
		WebUI.sendKeys(findTestObject('Object Repository/Page_WMI_NEW/WMI_Menu_BOV_Default/customerName'), custName)
		WebUI.uploadFile(findTestObject('Object Repository/Page_WMI_NEW/WMI_Menu_BOV_Default/chooseFile'), file)

		//Save and Close window
		WebUI.mouseOver(findTestObject('Object Repository/Page_WMI_NEW/WMI_Menu_BOV_Default/standardActionsUIButton'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Page_WMI_NEW/WMI_Menu_BOV_Default/Save'), GlobalVariable.G_LongTimeout)
		new Window().clickElementAndWaitForWindowClose(findTestObject('Object Repository/Page_WMI_NEW/WMI_Menu_BOV_Default/Save'),GlobalVariable.G_LongTimeout)
	}
	
	private void wmiMenuDocTwoRow(Map<Fields, String> data) {

		//Get Data from Map
		String custId = data.get(Fields.CUSTOMER_ID)
		String bmString = data.get(Fields.BM_STRING)
		String custName = data.get(Fields.CUSTOMER_NAME)
		String file = data.get(Fields.UPLOAD_FILE)

		//Fill Form
		WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_WMI_NEW/WMI_Menu_BOV_DocTwoRow/customerId'), custId,false)
		WebUI.sendKeys(findTestObject('Object Repository/Page_WMI_NEW/WMI_Menu_BOV_DocTwoRow/BMString'), bmString)
		WebUI.sendKeys(findTestObject('Object Repository/Page_WMI_NEW/WMI_Menu_BOV_DocTwoRow/customerName'), custName)
		WebUI.uploadFile(findTestObject('Object Repository/Page_WMI_NEW/WMI_Menu_BOV_DocTwoRow/chooseFile'), file)

		//Save and Close window
		WebUI.mouseOver(findTestObject('Object Repository/Page_WMI_NEW/WMI_Menu_BOV_DocTwoRow/dropdownStandardActions'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Page_WMI_NEW/WMI_Menu_BOV_DocTwoRow/Save'), GlobalVariable.G_LongTimeout)
		new Window().clickElementAndWaitForWindowClose(findTestObject('Object Repository/Page_WMI_NEW/WMI_Menu_BOV_DocTwoRow/Save'),GlobalVariable.G_LongTimeout)
	}
}
