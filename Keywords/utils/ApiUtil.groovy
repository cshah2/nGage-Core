package utils

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.json.simple.JSONObject
import org.junit.After

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class ApiUtil {

	private static RequestObject request
	private static String URL

	private static TestObjectProperty loadAuthHeader() {
		JSONObject headerObject = new JSONObject()
		headerObject.put('userName', GlobalVariable.Username)
		headerObject.put('password', GlobalVariable.Password)
		headerObject.put('schema',GlobalVariable.Database)
		String authHeader = headerObject.toJSONString()
		return new TestObjectProperty("Authorization-Token", ConditionType.EQUALS, authHeader)
	}

	public static ResponseObject getResponse(String siteUrl, String body, String method, TestObjectProperty... headers) {

		request = new RequestObject('objectId')

		URL = GlobalVariable.BaseAdminApiURL + siteUrl
		request.setRestUrl(URL)

		List<TestObjectProperty> headersList = new ArrayList<TestObjectProperty>()
		if(headers != null) {
			headersList = Arrays.asList(headers)
		}

		headersList.add(loadAuthHeader())
		headersList.add(new TestObjectProperty("Content-Type", ConditionType.EQUALS, 'application/json'))
		request.setHttpHeaderProperties(headersList)
		request.setRestRequestMethod(method)

		if(body != '') {
			request.setBodyContent(new HttpTextBodyContent(body))
		}

		return WS.sendRequest(request)
	}
}
