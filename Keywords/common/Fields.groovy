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

public enum Fields {
	TEMPLATE_NAME,				//Complaint Template
	TEMPLATE_TEXT,				//Complaint Template
	CUSTOMER_ID,				//WMI Menu Bov, WMI Menu Default, WMI Menu DocTwoRow
	BM_STRING,					//WMI Menu Bov, WMI Menu Default, WMI Menu DocTwoRow, Required Field DT
	CUSTOMER_NAME,				//WMI Menu Bov, WMI Menu Default, WMI Menu DocTwoRow
	UPLOAD_FILE,				//WMI Menu Bov, WMI Menu Default, WMI Menu DocTwoRow, SM WEB SERVICE, Vertical Menu Wizard
	STRING_FIELD,				//SM WEB SERVICE, Event For Required Field, Render All Field Types
	FILE_NAME,					//SM WEB SERVICE
	FIRST_NAME,					//Vertical Menu Wizard, Correspondence
	LAST_NAME,					//Vertical Menu Wizard, Correspondence
	AMOUNT,						//Vertical Menu Wizard
	BM_TEXT,					//Required Field DT
	BM_INT,						//Required Field DT
	DATE_TIME,					//Required Field DT, Render All Field Types, Date DateTime DT
	DATE,						//Required Field DT, Event For Required Field, Render All Field Types, Date DateTime DT
	DESCRIPTION,				//Route Advance
	TO_EMAIL,					//Correspondece
	TEMPLATE,					//Correspondece
	DROP_DOWN_CONTROL,			//Event For Required Field
	INTEGER_FIELD,				//Render All Field Types
	STRING_FIELD_ON_FOCUS,		//Render All Field Types
	STRING_FIELD_LOOKUP,		//Render All Field Types
	CURRENCY_FIELD,				//Render All Field Types
	FLOAT_FIELD,				//Render All Field Types
	SMALL_INT_FIELD,			//Render All Field Types
	TEXT_FIELD,					//Render All Field Types
	EXT_NAME_FIELD,				//Render All Field Types
	DATE_RANGE,					//Date DateTime DT
	DATE_TIME_RANGE				//Date DateTime DT

}
