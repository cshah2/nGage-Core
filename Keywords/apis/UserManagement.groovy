package apis

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.json.simple.JSONObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import utils.ApiUtil
import utils.DateUtil

public class UserManagement {

	private static siteUrl = '/api/UserManagement'

	private ResponseObject patch_SingleUser(int userId, String body, boolean isExpectedToWork) {
		String url = siteUrl+'('+userId+')'
		ResponseObject res = ApiUtil.getResponse(url, body, 'PATCH', null)
		println "Response is "+res.getResponseText()
		if(isExpectedToWork) {
			int statusCode = res.getStatusCode()
			if(!(statusCode == 200 || statusCode == 204)) {
				KeywordUtil.markFailedAndStop('call to patch single user api failed')
			}
		}
		return res
	}

	@Keyword
	def updatePasswordForUser(int userId, String password) {

		JSONObject bodyObj = new JSONObject()
		bodyObj.put('Id', new Integer(userId))
		bodyObj.put('UPwd', password)

		patch_SingleUser(userId, bodyObj.toJSONString(), true)
	}
	
	@Keyword
	def updateLastLoginDate(int userId, String date) {
		JSONObject bodyObj = new JSONObject()
		bodyObj.put('Id', new Integer(userId))
		bodyObj.put('LastLoginDate', DateUtil.getCurrentDateTimeMinusDays(401))

		patch_SingleUser(userId, bodyObj.toJSONString(), true)
	}
}
