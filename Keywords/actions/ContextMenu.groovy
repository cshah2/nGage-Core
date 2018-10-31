package actions

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebElement

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
import utils.WebUtil

public class ContextMenu {
	Map<String, WebElement> contextOptions

	private void setContextVariables(TestObject contextMenuOptions) {
		contextOptions = new HashMap<String, WebElement>()
		List<WebElement> allOptions = WebUtil.getWebElements(contextMenuOptions)
		
		for(WebElement e in allOptions) {
			String key = e.getText().replace("\u00a0", " ").trim()
			contextOptions.put(key, e)
		}
	}

	@Keyword
	def verifyAllOptions(TestObject contextMenuOptions, String... options) {

		setContextVariables(contextMenuOptions)

		int actualOptionsSize = this.contextOptions.size()
		int expectedOptionsSize = options.length
		WebUI.verifyEqual(actualOptionsSize, expectedOptionsSize)

		boolean isEntryPresent = true
		String entryNotFound

		for(String option in options) {
			if(!contextOptions.containsKey(option)) {
				isEntryPresent = false
				entryNotFound = option
				break
			}
		}

		WebUI.switchToDefaultContent()

		if(isEntryPresent) {
			KeywordUtil.markPassed("All Entries are present.")
		}
		else {
			KeywordUtil.markFailedAndStop("Entry "+entryNotFound+" is not found in the context Menu")
		}
	}

	@Keyword
	def verifyOptionPresent(TestObject contextMenuOptions, String option) {
		setContextVariables(contextMenuOptions)

		boolean isEntryPresent = true
		if(!contextOptions.containsKey(option)) {
			isEntryPresent = false
		}
		WebUI.switchToDefaultContent()

		if(isEntryPresent) {
			KeywordUtil.markPassed("All Entries are present.")
		}
		else {
			KeywordUtil.markFailedAndStop("Entry "+option+" is not found in the context Menu")
		}
	}

	@Keyword
	def clickOption(TestObject contextMenuOptions,String option) {
		setContextVariables(contextMenuOptions)
		WebElement e = contextOptions.get(option)
		if(e != null) {
			e.click()
		}
		else {
			KeywordUtil.markFailedAndStop("Entry "+option+" is not found in the context Menu")
		}
		WebUI.switchToDefaultContent()
	}
}