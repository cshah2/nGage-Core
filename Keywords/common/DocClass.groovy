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

public enum DocClass {
	CLOSURE_ACTION("Closure Action"),
	COMPLAINTS_TEMPLATES("Complaints Templates"),
	WMI_MENU("WMI Menu"),
	SM_WEBSERVICE_FILE_1("StorageSrvr0001"),			//Encryption ON
	SM_WEBSERVICE_DB_1("StorageSrvr0001DbObject"),		//Encryption ON
	SM_WEBSERVICE_FILE_2("StorageSrvr0002 FileObject"),	//Encryption OFF
	SM_WEBSERVICE_DB_2("StorageSrvr0002 Db object")		//Encryption OFF

	private final String text

	DocClass(String text) {
		this.text = text
	}

	@Override
	public String toString() {
		return text
	}
}