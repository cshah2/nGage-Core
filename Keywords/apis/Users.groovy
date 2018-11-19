package apis

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.json.simple.JSONArray
import org.json.simple.JSONObject
import org.json.simple.parser.JSONParser
import org.junit.After

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import utils.ApiUtil

public class Users {

	static String siteUrl = '/api/Users'
	static Map<String, Integer> allUsers

	private ResponseObject get_AllUsers(boolean isExpectedToWork) {
		ResponseObject res = ApiUtil.getResponse(siteUrl, '', 'GET', null)
		println "Response is = "+res.getResponseText()
		if(isExpectedToWork) {
			int statusCode = res.getStatusCode()
			if(!(statusCode == 200 || statusCode == 201 || statusCode == 204)) {
				KeywordUtil.markFailedAndStop('call to get all user api failed')
			}
		}
		return res
	}
	
	private ResponseObject patch_SinglUser(int userId, String body, boolean isExpectedToWork) {
		String url = siteUrl+'('+userId+')'
		ResponseObject res = ApiUtil.getResponse(url, body, 'PATCH', null)
		println "Response is = "+res.getResponseText()
		if(isExpectedToWork) {
			int statusCode = res.getStatusCode()
			if(!(statusCode == 200 || statusCode == 201 || statusCode == 204)) {
				KeywordUtil.markFailedAndStop('call to update single user api failed')
			}
		}
		return res
	}

	private void mapAllUserIdWithUserName(ResponseObject res) {

		allUsers = new HashMap<String, Integer>()
		Object obj = new JSONParser().parse(res.getResponseText())
		JSONObject jo = (JSONObject) obj

		JSONArray users = (JSONArray) jo.get('value')

		Iterator it = users.iterator()
		while(it.hasNext()) {
			String userObj = (String)it.next()
			Object obj1 = new JSONParser().parse(userObj)
			JSONObject jo1 = (JSONObject) obj1

			int user_id = (int) jo1.get('Id')
			String user_name = (String) jo1.get('UserName')

			allUsers.put(user_name, user_id)
		}
	}

	@Keyword
	def getUserIdFromUserName(String userName) {

		if(!(allUsers != null && allUsers.size() > 0)){
			ResponseObject res = get_AllUsers(true)
			mapAllUserIdWithUserName(res)
		}
		if(!allUsers.containsKey(userName)) {
			KeywordUtil.markFailedAndStop('User ID not found for user '+userName)
		}
		println "User ID is "+allUsers.get(userName)
		return allUsers.get(userName)
	}

	@Keyword
	def unlockUserAccount(int userId) {

		JSONObject bodyObj = new JSONObject()
		bodyObj.put('Id',new Integer(userId))
		bodyObj.put('IsDisabled',new Boolean(false))
		String body = bodyObj.toJSONString()

		ResponseObject res = patch_SinglUser(userId, body, true)
		println res.getResponseText()
	}
}
