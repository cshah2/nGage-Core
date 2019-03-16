package actions

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.apache.commons.lang3.StringUtils
import org.openqa.selenium.Keys

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
import utils.WebUtil
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

			case DocType.SM_WEBSERVICE_FILE_1:
				smWebServiceFile0001(data)
				break

			case DocType.SM_WEBSERVICE_DB_1:
				smWebServiceDb0001(data)
				break

			case DocType.SM_WEBSERVICE_FILE_2:
				smWebServiceFile0002(data)
				break

			case DocType.SM_WEBSERVICE_DB_2:
				smWebServiceDb0002(data)
				break

			case DocType.WMI_MENU_BOV_VERTICAL:
				wmiMenuBovVertical(data)
				break

			case DocType.SHOW_VERTICAL_MENU_TRUE:
				showVerticalMenuTrue(data)
				break

			case DocType.MULTIPAGE_VIEWER_WITH_DRAG_DROP:
				multiPageViewerWithDragAndDrop(data)
				break

			case DocType.REQUIRED_FIELD_DT:
				requiredFieldDT(data)
				break

			case DocType.ROUTE_FROM_ENTRY_INTERACTIVE_USER:
				routeFromEntryInteractiveUser(data)
				break

			case DocType.CORRESPONDENCE:
				correspondence(data)
				break

			case DocType.EVENT_FOR_REQUIRED_FIELD:
				eventForRequiredField(data)
				break

			case DocType.RELOAD_ON_POSTBACK_NO_SPLIT_T:
				reloadOnPostBackNoSplitT(data)
				break

			case DocType.RENDER_AS_LABEL:
				renderAsLabel(data)
				break

			case DocType.REFERENCE_OBJECT_INLINE_CONTENT_VIEW:
				referenceObjectInlineContentView(data)
				break

			case DocType.RENDER_ALL_FIELD_TYPES:
				renderAllFieldTypes(data)
				break

			case DocType.DATE_DATETIME_DT:
				dateDateTimeDT(data)
				break

			case DocType.DATE_REQUIRED:
			case DocType.DATE_RANGE_REQUIRED:
			case DocType.DATETIME_REQUIRED:
			case DocType.DATETIME_RANGE_REQUIRED:
				myWorkDateTime(data)
				break

			case DocType.CLOSURE_ACTION:
				closureAction(data)
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
		if(StringUtils.isNotBlank(custId))
			WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_WMI_NEW/WMI_Menu_BOV/selectCustomerId'), custId,false)
		if(StringUtils.isNotBlank(bmString))
			WebUI.sendKeys(findTestObject('Object Repository/Page_WMI_NEW/WMI_Menu_BOV/inputBMString'), bmString)
		if(StringUtils.isNotBlank(custName))
			WebUI.sendKeys(findTestObject('Object Repository/Page_WMI_NEW/WMI_Menu_BOV/inputCustomerName'), custName)
		if(StringUtils.isNotBlank(file))
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
		if(StringUtils.isNotBlank(custId))
			WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_WMI_NEW/WMI_Menu_BOV_Default/customerID'), custId,false)
		if(StringUtils.isNotBlank(bmString))
			WebUI.sendKeys(findTestObject('Object Repository/Page_WMI_NEW/WMI_Menu_BOV_Default/BMString'), bmString)
		if(StringUtils.isNotBlank(custName))
			WebUI.sendKeys(findTestObject('Object Repository/Page_WMI_NEW/WMI_Menu_BOV_Default/customerName'), custName)
		if(StringUtils.isNotBlank(file))
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
		if(StringUtils.isNotBlank(custId))
			WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_WMI_NEW/WMI_Menu_BOV_DocTwoRow/customerId'), custId,false)
		if(StringUtils.isNotBlank(bmString))
			WebUI.sendKeys(findTestObject('Object Repository/Page_WMI_NEW/WMI_Menu_BOV_DocTwoRow/BMString'), bmString)
		if(StringUtils.isNotBlank(custName))
			WebUI.sendKeys(findTestObject('Object Repository/Page_WMI_NEW/WMI_Menu_BOV_DocTwoRow/customerName'), custName)
		if(StringUtils.isNotBlank(file))
			WebUI.uploadFile(findTestObject('Object Repository/Page_WMI_NEW/WMI_Menu_BOV_DocTwoRow/chooseFile'), file)

		//Save and Close window
		WebUI.mouseOver(findTestObject('Object Repository/Page_WMI_NEW/WMI_Menu_BOV_DocTwoRow/dropdownStandardActions'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Page_WMI_NEW/WMI_Menu_BOV_DocTwoRow/Save'), GlobalVariable.G_LongTimeout)
		new Window().clickElementAndWaitForWindowClose(findTestObject('Object Repository/Page_WMI_NEW/WMI_Menu_BOV_DocTwoRow/Save'),GlobalVariable.G_LongTimeout)
	}

	private void smWebServiceFile0001(Map<Fields, String> data) {

		//Get Data from Map
		String stringField = data.get(Fields.STRING_FIELD)
		String fileName = data.get(Fields.FILE_NAME)
		String file = data.get(Fields.UPLOAD_FILE)

		//Fill Form
		if(StringUtils.isNotBlank(stringField))
			WebUI.setText(findTestObject('Page_WMI_NEW/SM Web Service/FILE_0001/input_String field'), stringField)
		if(StringUtils.isNotBlank(fileName))
			WebUI.setText(findTestObject('Page_WMI_NEW/SM Web Service/FILE_0001/input_File Name'), fileName)
		if(StringUtils.isNotBlank(file))
			WebUI.uploadFile(findTestObject('Page_WMI_NEW/SM Web Service/FILE_0001/input_File Upload'), file)

		//Save and Close window
		WebUI.mouseOver(findTestObject('Page_WMI_NEW/SM Web Service/FILE_0001/menu_Standard Actions'))
		WebUI.waitForElementVisible(findTestObject('Page_WMI_NEW/SM Web Service/FILE_0001/submenu_Save'), GlobalVariable.G_LongTimeout)
		new Window().clickElementAndWaitForWindowClose(findTestObject('Page_WMI_NEW/SM Web Service/FILE_0001/submenu_Save'),GlobalVariable.G_LongTimeout)
	}

	private void smWebServiceDb0001(Map<Fields, String> data) {

		//Get Data from Map
		String stringField = data.get(Fields.STRING_FIELD)
		String fileName = data.get(Fields.FILE_NAME)
		String file = data.get(Fields.UPLOAD_FILE)

		//Fill Form
		if(StringUtils.isNotBlank(stringField))
			WebUI.setText(findTestObject('Page_WMI_NEW/SM Web Service/DB_0001/input_String field'), stringField)
		if(StringUtils.isNotBlank(fileName))
			WebUI.setText(findTestObject('Page_WMI_NEW/SM Web Service/DB_0001/input_File Name'), fileName)
		if(StringUtils.isNotBlank(file))
			WebUI.uploadFile(findTestObject('Page_WMI_NEW/SM Web Service/DB_0001/input_File Upload'), file)

		//Save and Close window
		WebUI.mouseOver(findTestObject('Page_WMI_NEW/SM Web Service/DB_0001/menu_Standard Actions'))
		WebUI.waitForElementVisible(findTestObject('Page_WMI_NEW/SM Web Service/DB_0001/submenu_Save'), GlobalVariable.G_LongTimeout)
		new Window().clickElementAndWaitForWindowClose(findTestObject('Page_WMI_NEW/SM Web Service/DB_0001/submenu_Save'),GlobalVariable.G_LongTimeout)
	}

	private void smWebServiceFile0002(Map<Fields, String> data) {

		//Get Data from Map
		String stringField = data.get(Fields.STRING_FIELD)
		String fileName = data.get(Fields.FILE_NAME)
		String file = data.get(Fields.UPLOAD_FILE)

		//Fill Form
		if(StringUtils.isNotBlank(stringField))
			WebUI.setText(findTestObject('Page_WMI_NEW/SM Web Service/FILE_0002/input_String field'), stringField)
		if(StringUtils.isNotBlank(fileName))
			WebUI.setText(findTestObject('Page_WMI_NEW/SM Web Service/FILE_0002/input_File Name'), fileName)
		if(StringUtils.isNotBlank(file))
			WebUI.uploadFile(findTestObject('Page_WMI_NEW/SM Web Service/FILE_0002/input_File Upload'), file)

		//Save and Close window
		WebUI.mouseOver(findTestObject('Page_WMI_NEW/SM Web Service/FILE_0002/menu_Standard Actions'))
		WebUI.waitForElementVisible(findTestObject('Page_WMI_NEW/SM Web Service/FILE_0002/submenu_Save'), GlobalVariable.G_LongTimeout)
		new Window().clickElementAndWaitForWindowClose(findTestObject('Page_WMI_NEW/SM Web Service/FILE_0002/submenu_Save'),GlobalVariable.G_LongTimeout)
	}

	private void smWebServiceDb0002(Map<Fields, String> data) {

		//Get Data from Map
		String stringField = data.get(Fields.STRING_FIELD)
		String fileName = data.get(Fields.FILE_NAME)
		String file = data.get(Fields.UPLOAD_FILE)

		//Fill Form
		if(StringUtils.isNotBlank(stringField))
			WebUI.setText(findTestObject('Page_WMI_NEW/SM Web Service/DB_0002/input_String field'), stringField)
		if(StringUtils.isNotBlank(fileName))
			WebUI.setText(findTestObject('Page_WMI_NEW/SM Web Service/DB_0002/input_File Name'), fileName)
		if(StringUtils.isNotBlank(file))
			WebUI.uploadFile(findTestObject('Page_WMI_NEW/SM Web Service/DB_0002/input_File Upload'), file)

		//Save and Close window
		WebUI.mouseOver(findTestObject('Page_WMI_NEW/SM Web Service/DB_0002/menu_Standard Actions'))
		WebUI.waitForElementVisible(findTestObject('Page_WMI_NEW/SM Web Service/DB_0002/submenu_Save'), GlobalVariable.G_LongTimeout)
		new Window().clickElementAndWaitForWindowClose(findTestObject('Page_WMI_NEW/SM Web Service/DB_0002/submenu_Save'),GlobalVariable.G_LongTimeout)
	}

	private void wmiMenuBovVertical(Map<Fields, String> data) {

		//Get Data from Map
		String stringField = data.get(Fields.STRING_FIELD)
		String file = data.get(Fields.UPLOAD_FILE)

		//Fill Form
		if(StringUtils.isNotBlank(file))
			WebUI.setText(findTestObject('Page_WMI_NEW/WMI_Menu_BOV_Vertical/input_String field'), stringField)
		if(StringUtils.isNotBlank(file))
			WebUI.uploadFile(findTestObject('Page_WMI_NEW/WMI_Menu_BOV_Vertical/input__file_upload'), file)

		'Save details and close'
		WebUI.mouseOver(findTestObject('Page_WMI_NEW/WMI_Menu_BOV/buttonStandardActions'))
		WebUI.waitForElementVisible(findTestObject('Page_WMI_NEW/WMI_Menu_BOV/buttonSave'), GlobalVariable.G_LongTimeout)
		new Window().clickElementAndWaitForWindowClose(findTestObject('Page_WMI_NEW/WMI_Menu_BOV/buttonSave'),GlobalVariable.G_LongTimeout)
	}

	private void showVerticalMenuTrue(Map<Fields, String> data) {

		//Get Data from Map
		String firstName = data.get(Fields.FIRST_NAME)
		String lastName = data.get(Fields.LAST_NAME)
		String amount = data.get(Fields.AMOUNT)
		String file = data.get(Fields.UPLOAD_FILE)

		//Fill Form
		if(StringUtils.isNotBlank(firstName))
			WebUI.setText(findTestObject('Page_WMI_NEW/VerticalMenuWizard/ShowVerticalMenu_True/input_First Name'), firstName)
		if(StringUtils.isNotBlank(lastName))
			WebUI.setText(findTestObject('Page_WMI_NEW/VerticalMenuWizard/ShowVerticalMenu_True/input_Last Name'), lastName)
		if(StringUtils.isNotBlank(file))
			WebUI.setText(findTestObject('Page_WMI_NEW/VerticalMenuWizard/ShowVerticalMenu_True/input_Amount'), amount)
		if(StringUtils.isNotBlank(file))
			WebUI.uploadFile(findTestObject('Page_WMI_NEW/WMI_Menu_BOV_Vertical/input__file_upload'), file)

		'Save details and close'
		WebUI.click(findTestObject('Page_WMI_NEW/VerticalMenuWizard/ShowVerticalMenu_True/span_Save'))
		WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
		new Common().waitForFrameToLoad(findTestObject('Page_WMI_NEW/VerticalMenuWizard/ShowVerticalMenu_True/iframe_Menus_ContentPlaceHolde'))
		new Window().clickElementAndWaitForWindowClose(findTestObject('Page_WMI_NEW/VerticalMenuWizard/ShowVerticalMenu_True/a_Close Window'), GlobalVariable.G_LongTimeout)
	}

	private void multiPageViewerWithDragAndDrop(Map<Fields, String> data) {

		//Get Data from Map
		String stringField = data.get(Fields.STRING_FIELD)
		String fileName = data.get(Fields.FILE_NAME)

		//Fill Form
		if(StringUtils.isNotBlank(stringField))
			WebUI.setText(findTestObject('Page_WMI_NEW/MultiPage_Viewer_DD/input_eform_mcb67676phBO_3_BOe'), stringField)
		if(StringUtils.isNotBlank(fileName))
			WebUI.setText(findTestObject('Page_WMI_NEW/MultiPage_Viewer_DD/input_eform_mcb67676phBO_3_BOe_1'), fileName)

		//Click on Save button
		WebUI.mouseOver(findTestObject('Page_WMI_NEW/MultiPage_Viewer_DD/span_standard_actions'))
		WebUI.waitForElementVisible(findTestObject('Page_WMI_NEW/MultiPage_Viewer_DD/a_Save'), GlobalVariable.G_LongTimeout)
		new Window().clickElementAndWaitForWindowClose(findTestObject('Page_WMI_NEW/MultiPage_Viewer_DD/a_Save'), GlobalVariable.G_LongTimeout)
	}

	private void requiredFieldDT(Map<Fields, String> data) {

		//Get Data from Map
		String bmText = data.get(Fields.BM_TEXT)
		String bmString = data.get(Fields.BM_STRING)
		String bmInt = data.get(Fields.BM_INT)
		String dateTime = data.get(Fields.DATE_TIME)
		String date = data.get(Fields.DATE)

		//Fill Form
		if(StringUtils.isNotBlank(bmText))
			WebUI.setText(findTestObject('Page_WMI_NEW/Required_Field_DT/input_BM Text'), bmText)
		if(StringUtils.isNotBlank(bmString))
			WebUI.setText(findTestObject('Page_WMI_NEW/Required_Field_DT/input_BM String required'), bmString)
		if(StringUtils.isNotBlank(bmInt))
			WebUI.setText(findTestObject('Page_WMI_NEW/Required_Field_DT/input_BM Int'), bmInt)
		if(StringUtils.isNotBlank(dateTime))
			new Common().setText_Date(findTestObject('Page_WMI_NEW/Required_Field_DT/input_Date Time Required'), dateTime)
		if(StringUtils.isNotBlank(date))
			new Common().setText_Date(findTestObject('Page_WMI_NEW/Required_Field_DT/input_Date Required'), date)

		//Click on Save button
		WebUI.mouseOver(findTestObject('Page_WMI_NEW/Required_Field_DT/span_Standard Actions'))
		WebUI.waitForElementVisible(findTestObject('Page_WMI_NEW/Required_Field_DT/a_Save'), GlobalVariable.G_LongTimeout)
		new Window().clickElementAndWaitForWindowClose(findTestObject('Page_WMI_NEW/Required_Field_DT/a_Save'),GlobalVariable.G_LongTimeout)
	}

	private void routeFromEntryInteractiveUser(Map<Fields, String> data) {

		//Get Data from Map
		String description = data.get(Fields.DESCRIPTION)

		//Fill Form
		if(StringUtils.isNotBlank(description))
			WebUI.setText(findTestObject('Page_WMI_NEW/RouteAdvance/input_Description'), description)

		//Click on Save button
		WebUI.mouseOver(findTestObject('Page_WMI_NEW/RouteAdvance/span_Standard Actions'))
		WebUI.waitForElementVisible(findTestObject('Page_WMI_NEW/RouteAdvance/a_Save'), GlobalVariable.G_LongTimeout)
		new Window().clickElementAndWaitForWindowClose(findTestObject('Page_WMI_NEW/RouteAdvance/a_Save'), GlobalVariable.G_LongTimeout)
	}

	private void correspondence(Map<Fields, String> data) {

		//Get Data from Map
		String firstName = data.get(Fields.FIRST_NAME)
		String lastName = data.get(Fields.LAST_NAME)
		String toEmail = data.get(Fields.TO_EMAIL)
		String template = data.get(Fields.TEMPLATE)

		//Fill Form
		if(StringUtils.isNotBlank(firstName))
			WebUI.setText(findTestObject('Page_WMI_NEW/Correspondence/input_First Name'), firstName)
		if(StringUtils.isNotBlank(lastName))
			WebUI.setText(findTestObject('Page_WMI_NEW/Correspondence/input_Last Name'), lastName)
		if(StringUtils.isNotBlank(toEmail))
			WebUI.setText(findTestObject('Page_WMI_NEW/Correspondence/input_To Email'), toEmail)
		if(StringUtils.isNotBlank(template)) {
			WebUI.selectOptionByLabel(findTestObject('Page_WMI_NEW/Correspondence/select_Template'), template, false)
			WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
			WebUI.delay(2)
			new Common().waitForFrameToLoad(findTestObject('Page_WMI_NEW/Correspondence/iframe_BodyText'))
		}

		//Click on Save button and close window button
		WebUI.click(findTestObject('Page_WMI_NEW/Correspondence/span_Save'))
		WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
		WebUI.waitForElementVisible(findTestObject('Page_WMI/Correspondence/span_Close Window'), GlobalVariable.G_LongTimeout)
		new Window().clickElementAndWaitForWindowClose(findTestObject('Page_WMI/Correspondence/span_Close Window'),GlobalVariable.G_LongTimeout)
	}

	private void eventForRequiredField(Map<Fields, String> data) {

		//Get Data from Map
		String dropDownControl = data.get(Fields.DROP_DOWN_CONTROL)
		String stringField = data.get(Fields.STRING_FIELD)
		String date = data.get(Fields.DATE)

		//Fill Form
		if(StringUtils.isNotBlank(dropDownControl)) {
			WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/process_Event For Required Field/select_MasterObjectDropdownControl'), dropDownControl, false)
			new Common().waitForTabLoading(null, GlobalVariable.G_LongTimeout)
		}
		if(StringUtils.isNotBlank(stringField))
			WebUI.setText(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/process_Event For Required Field/input_String Field (Value Chan'), stringField)
		if(StringUtils.isNotBlank(date))
			new Common().setText_Date(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/process_Event For Required Field/input_Date Field (Visibility C'), date)

		//Click on Save button and close window button
		WebUI.mouseOver(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/process_Event For Required Field/span_Actions'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/process_Event For Required Field/a_Save'), GlobalVariable.G_LongTimeout)
		new Window().clickElementAndWaitForWindowClose(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/process_Event For Required Field/a_Save'), GlobalVariable.G_LongTimeout)
	}

	private void reloadOnPostBackNoSplitT(Map<Fields, String> data) {

		//Get Data from Map
		String bmString = data.get(Fields.BM_STRING)

		//Fill Form
		if(StringUtils.isNotBlank(bmString))
			WebUI.setText(findTestObject('Page_WMI_NEW/DoNotReloadOnPostBack/NoSplit_T/input_BM String'), bmString)

		//Click on Save button and close window button
		WebUI.click(findTestObject('Page_WMI_NEW/DoNotReloadOnPostBack/NoSplit_T/span_Save'))
		WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
		WebUI.waitForElementVisible(findTestObject('Page_WMI_NEW/DoNotReloadOnPostBack/NoSplit_T/span_Close'), GlobalVariable.G_LongTimeout)
		new Window().clickElementAndWaitForWindowClose(findTestObject('Page_WMI_NEW/DoNotReloadOnPostBack/NoSplit_T/span_Close'),GlobalVariable.G_LongTimeout)
	}

	private void renderAsLabel(Map<Fields, String> data) {

		//Get Data from Map

		//Fill Form

		//Click on Save button and close window button
		WebUI.click(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_Label/span_Save'))
		WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
		new Window().clickElementAndWaitForWindowClose(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_Label/span_Close Window'), GlobalVariable.G_LongTimeout)
	}

	private void referenceObjectInlineContentView(Map<Fields, String> data) {

		//Get Data from Map

		//Fill Form

		//Click on Save button and close window button
		WebUI.click(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_Label/span_Save'))
		WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
		new Window().clickElementAndWaitForWindowClose(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_Label/span_Close Window'), GlobalVariable.G_LongTimeout)
	}

	private void renderAllFieldTypes(Map<Fields, String> data) {

		//Get Data from Map
		String integerField = data.get(Fields.INTEGER_FIELD)
		String stringFieldOnFocusAttr = data.get(Fields.STRING_FIELD_ON_FOCUS)
		String stringFieldLookup = data.get(Fields.STRING_FIELD_LOOKUP)
		String currencyField = data.get(Fields.CURRENCY_FIELD)
		String dateField = data.get(Fields.DATE)
		String floatField = data.get(Fields.FLOAT_FIELD)
		String smallIntField = data.get(Fields.SMALL_INT_FIELD)
		String textField = data.get(Fields.TEXT_FIELD)
		String dateTimeField = data.get(Fields.DATE_TIME)
		String stringField = data.get(Fields.STRING_FIELD)
		String extNameField = data.get(Fields.EXT_NAME_FIELD)

		//Fill Form
		if(StringUtils.isNotBlank(integerField))
			WebUI.setText(findTestObject('Page_WMI_NEW/Master_Object/input_Integer Field'), integerField)
		if(StringUtils.isNotBlank(stringFieldOnFocusAttr))
			WebUI.setText(findTestObject('Page_WMI_NEW/Master_Object/input_String Field (with onfocussetcursorattheend attribute)'), stringFieldOnFocusAttr)
		if(StringUtils.isNotBlank(stringFieldLookup))
			WebUI.selectOptionByLabel(findTestObject('Page_WMI_NEW/Master_Object/select_String Field With Lookup'), stringFieldLookup, false)
		if(StringUtils.isNotBlank(currencyField)) {
			WebUI.setText(findTestObject('Page_WMI_NEW/Master_Object/input_Currency Field'), currencyField)
			WebUI.sendKeys(findTestObject('Page_WMI_NEW/Master_Object/input_Currency Field'), Keys.chord(Keys.TAB))
			WebUtil.delay(100)
		}
		if(StringUtils.isNotBlank(dateField))
			new Common().setText_Date(findTestObject('Page_WMI_NEW/Master_Object/input_Date Field'), dateField)
		if(StringUtils.isNotBlank(floatField))
			WebUI.setText(findTestObject('Page_WMI_NEW/Master_Object/input_Float Field (Precision3minval-10maxval-100)'), floatField)
		if(StringUtils.isNotBlank(smallIntField))
			WebUI.setText(findTestObject('Page_WMI_NEW/Master_Object/input_Small Integer Field(minval-10maxval-100)'), smallIntField)
		if(StringUtils.isNotBlank(textField))
			WebUI.setText(findTestObject('Page_WMI_NEW/Master_Object/input_Text Field(with onfocusselectall attribute)'), textField)
		if(StringUtils.isNotBlank(dateTimeField))
			new Common().setText_Date(findTestObject('Page_WMI_NEW/Master_Object/input_DateTime Field'), dateTimeField)
		if(StringUtils.isNotBlank(stringField))
			WebUI.setText(findTestObject('Page_WMI_NEW/Master_Object/input_String Filed'), stringField)
		if(StringUtils.isNotBlank(extNameField))
			WebUI.setText(findTestObject('Page_WMI_NEW/Master_Object/input_Ext Name Field'), extNameField)

		//Save details and close
		WebUI.click(findTestObject('Page_WMI_NEW/Master_Object/span_Save'))
		WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
		new Window().clickElementAndWaitForWindowClose(findTestObject('Page_WMI_NEW/Master_Object/span_Close Window'),GlobalVariable.G_LongTimeout)
	}

	private void dateDateTimeDT(Map<Fields, String> data) {

		//Get Data from Map
		String date = data.get(Fields.DATE)
		String dateRange = data.get(Fields.DATE_RANGE)
		String dateTime = data.get(Fields.DATE_TIME)
		String dateTimeRange = data.get(Fields.DATE_TIME_RANGE)

		//Fill Form
		if(StringUtils.isNotBlank(date))
			new Common().setText_Date(findTestObject('Page_WMI_NEW/Date Date Time DT/input_BM Date'), date)
		if(StringUtils.isNotBlank(dateRange))
			new Common().setText_Date(findTestObject('Page_WMI_NEW/Date Date Time DT/input_Date range'), dateRange)
		if(StringUtils.isNotBlank(dateTime))
			new Common().setText_Date(findTestObject('Page_WMI_NEW/Date Date Time DT/input_BM DateTime'), dateTime)
		if(StringUtils.isNotBlank(dateTimeRange))
			new Common().setText_Date(findTestObject('Page_WMI_NEW/Date Date Time DT/input_Date time range'), dateTimeRange)

		//Save details and close
		WebUI.click(findTestObject('Page_WMI_NEW/Date Date Time DT/span_Save'))
		WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
		new Common().waitForFrameToLoad(findTestObject('Page_WMI/Date Date Time DT/iframe_ContentPlaceHolder1'))
		new Window().clickElementAndWaitForWindowClose(findTestObject('Page_WMI/Date Date Time DT/span_Close Window'), GlobalVariable.G_LongTimeout)
	}

	private void myWorkDateTime(Map<Fields, String> data) {

		//Date Required, Date Range Required, Date Time Required, Date Time Range Required

		//Get Data from Map
		String startDate = data.get(Fields.START_DATE)
		String endDate = data.get(Fields.END_DATE)
		String startDateTime = data.get(Fields.START_DATE_TIME)
		String endDateTime = data.get(Fields.END_DATE_TIME)
		String bmText = data.get(Fields.BM_TEXT)

		//Fill Form
		if(StringUtils.isNotBlank(startDate))
			new Common().setText_Date(findTestObject('Page_WMI_NEW/MyWork_DateTime/input_Start test date'), startDate)
		if(StringUtils.isNotBlank(endDate))
			new Common().setText_Date(findTestObject('Page_WMI_NEW/MyWork_DateTime/input_Endtestdate'), endDate)
		if(StringUtils.isNotBlank(startDateTime))
			new Common().setText_Date(findTestObject('Page_WMI_NEW/MyWork_DateTime/input_Start test datetime'), startDateTime)
		if(StringUtils.isNotBlank(endDateTime))
			new Common().setText_Date(findTestObject('Page_WMI_NEW/MyWork_DateTime/input_End test datetime'), endDateTime)
		if(StringUtils.isNotBlank(bmText))
			WebUI.setText(findTestObject('Page_WMI_NEW/MyWork_DateTime/input_BM Text'), bmText)

		//Save details and close
		WebUI.click(findTestObject('Page_WMI_NEW/MyWork_DateTime/span_Save'))
		WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
		new Common().waitForFrameToLoad(findTestObject('Page_WMI/MyWork_DateTime/iframe_ContentPlaceHolder'))
		new Window().clickElementAndWaitForWindowClose(findTestObject('Page_WMI/MyWork_DateTime/span_Close Window'), GlobalVariable.G_LongTimeout)
	}
	
	private void closureAction(Map<Fields, String> data) {
		
		//Get Data from Map
		String custName = data.get(Fields.CUSTOMER_NAME)
		String custDetail = data.get(Fields.CUSTOMER_DETAIL)
		
		//Fill Form
		if(StringUtils.isNotBlank(custName))
			WebUI.setText(findTestObject('Page_WMI_NEW/Closure_Action/input_Customer Name'), custName)
		if(StringUtils.isNotBlank(custDetail))
			WebUI.setText(findTestObject('Page_WMI_NEW/Closure_Action/input_Customer Details'), custDetail)

		//Save details and close
		WebUI.mouseOver(findTestObject('Page_WMI_NEW/Closure_Action/span_Actions'))
		WebUI.waitForElementVisible(findTestObject('Page_WMI_NEW/Closure_Action/a_Save'), GlobalVariable.G_LongTimeout)
		new Window().clickElementAndWaitForWindowClose(findTestObject('Page_WMI_NEW/Closure_Action/a_Save'),GlobalVariable.G_LongTimeout)
	}
}