package common

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public enum DocType {

	CLOSURE_ACTION("Closure Action"),
	COMPLAINT_TEMPLATE("Complaint Template"),
	WMI_MENU_BOV("WMI Menu BOV"),
	WMI_MENU_BOV_VERTICAL("WMI Menu BOV Vertical"),
	WMI_MENU_DEFAULT("WMI Menu Default"),
	WMI_MENU_DOCTWOROW("WMI Menu DocTwoRow"),
	SM_WEBSERVICE_FILE_1("Storage Server0001 File Object"),						//Encryption ON
	SM_WEBSERVICE_DB_1("Storage Server 0001"),									//Encryption ON
	SM_WEBSERVICE_FILE_2("StorageServer 0002"),									//Encryption OFF
	SM_WEBSERVICE_DB_2("Storage Server 0002"),									//Encryption OFF
	SHOW_VERTICAL_MENU_TRUE("ShowVerticalMenu-True"),							//Loan Application
	MULTIPAGE_VIEWER_WITH_DRAG_DROP("MultipageViewer with drag and drop"),
	REQUIRED_FIELD_DT("Required field DT"),
	ROUTE_FROM_ENTRY_INTERACTIVE_USER("Route from Entry Interactive User"),
	CORRESPONDENCE("Correspondence"),
	EVENT_FOR_REQUIRED_FIELD("Event for req field"),
	RELOAD_ON_POSTBACK_NO_SPLIT_T("ReloadOnPostbackNoSplit T"),
	RENDER_AS_LABEL("Render As Label"),
	REFERENCE_OBJECT_INLINE_CONTENT_VIEW("Reference Object InlineContentView"),
	RENDER_ALL_FIELD_TYPES("Render All Field Types"),
	DATE_DATETIME_DT("Date DateTime DT"),
	DATE_REQUIRED("daterequiredsearch"),
	DATE_RANGE_REQUIRED("daterangerequired"),
	DATETIME_REQUIRED("Datetimerequired"),
	DATETIME_RANGE_REQUIRED("Datetimerangerequired"),
	FIELD_MASK("Field Mask"),
	INTERFACE_TEST_PR_ACTIVITY1("InterfaceTestPRDocTypeActivity1"),
	INTERFACE_TEST_PR_ACTIVITY2("InterfaceTestPRDocTypeActivity2"),
	INTERFACE_TEST_PR_ACTIVITY3("InterfaceTestPRDocTypeActivity3"),
	INTERFACE_TEST_PR_ACTIVITY4("InterfaceTestPRDocTypeActivity4"),
	INTERFACE_TEST_PR_ACTIVITY6("InterfaceTestPRDocTypeActivity6"),
	INTERFACE_TEST_PR_RULES_ITEM_RELATED("InterfaceTestPRDocTypeExecRules_ItemRelated"),
	INTERFACE_TEST_PR_RULES_OTHER("InterfaceTestPRDocTypeExecRules_Other"),
	INTERFACE_TEST_PR_RULES_PROCESS_INSTANCE("InterfaceTestPRDocTypeExecRules_ProcessInstance"),
	INTERFACE_TEST_PR_LIBRARY_ACTIVITY01("InterfaceTestPRLibraryActivity01"),
	WMI_SEGMENT("WMI Segment"),
	WMI_SEGMENT_EXT("WMI Segment ext"),
	WMI_SEGMENT_MASTER_REFERENCE_OBJECT("WMI Segment Master Reference Object"),
	INTERFACE_TEST_PR_RULES_USER_RELATED("InterfaceTestPRDocTypeExecRules_UserRelated"),
	STANDARD_GRID("Standard Grid"),
	TEXTBOX_WITH_SECTION_EVENT("Textbox With Section Event"),
	RADIO_LIST_EVENT("Radio List Event"),
	CHECKBOX_LIST_EVENT("Checkbox List Event"),
	CHECKBOX_EVENT("Checkbox Event"),
	LABEL_EVENT("Label Event"),
	DROPDOWN_EVENT("DropDown Event"),
	NESTED_LOOKUP_EVENT("Nested Lookup Event"),
	ONLOAD_AND_SETFOCUS_EVENT("DoNotSetValueOnLoad and SetFocus Event")

	private final String text

	DocType(String text) {
		this.text = text
	}

	@Override
	public String toString() {
		return text
	}
}
