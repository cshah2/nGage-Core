package actions

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.util.concurrent.TimeUnit

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
import internal.GlobalVariable as GlobalVariable

public class MenuBar {

	/**
	 * Method will return record count displayed for Activity in left menu
	 * For Ex: if Left menu activity name is "Activity A(100)", then it will return value 100 as a String"
	 * @param element
	 * @return
	 */
	def getRecordCountInActivity(TestObject element) {
		WebUI.waitForElementPresent(element, GlobalVariable.G_LongTimeout)
		WebUI.waitForElementVisible(element, GlobalVariable.G_LongTimeout)
		String nodeText = WebUI.getText(element)
		try {
			int startIndex = nodeText.lastIndexOf('(')+1
			int lastIndex = nodeText.length()-1
			String recordCountInString = nodeText.substring(startIndex, lastIndex).trim()
			return Integer.parseInt(recordCountInString)
		}
		catch(Exception e) {
			println "Coult not get record count "+e.toString()
			return -1;
		}
	}

	@Keyword
	def refreshActivityUntilRecordCountIncreases(TestObject element, int timeout) {
		int originalCount = getRecordCountInActivity(element)
		int currentCount = originalCount
		boolean hasRecordCountIncreased = false

		def startTime = System.currentTimeMillis()
		def endTime = startTime + TimeUnit.SECONDS.toMillis(timeout)
		def currentTime = System.currentTimeMillis()

		while(currentTime < endTime) {
			println "Original Count = "+originalCount+"currentCount = "+currentCount
			if(originalCount < 0 || currentCount < 0 || currentCount <= originalCount) {
				WebUI.rightClick(element)
				WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/My_Work/contextMenu_Refresh'), GlobalVariable.G_SmallTimeout)
				WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/contextMenu_Refresh'))
				WebUI.waitForJQueryLoad(GlobalVariable.G_SmallTimeout)
				WebUI.delay(5)
				currentCount = getRecordCountInActivity(element)
				currentTime = System.currentTimeMillis()
			}
			else {
				hasRecordCountIncreased = true
				break
			}
		}

		if(hasRecordCountIncreased) {
			KeywordUtil.markPassed("Activity count refreshed")
		}
		else {
			KeywordUtil.markFailedAndStop("Activity count not refreshed in given time "+timeout+" Seconds")
		}
	}
}
