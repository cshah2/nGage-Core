package actions

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.util.concurrent.TimeUnit

import org.apache.commons.lang3.StringUtils
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.StaleElementReferenceException
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.SelectorMethod
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class WaitFor {
	
	private static WebDriver jsWaitDriver;
	private static WebDriverWait jsWait;
	private static JavascriptExecutor jsExec;
	
	
	private void setDriver () {
		jsWaitDriver = DriverFactory.getWebDriver();
		jsWait = new WebDriverWait(jsWaitDriver, GlobalVariable.G_LongTimeout);
		jsExec = (JavascriptExecutor) jsWaitDriver;
	}
	
	private By getLocator(TestObject to) {
		
		String cssLocator = to.selectorCollection.get(SelectorMethod.CSS)
		String xpathLocator = to.selectorCollection.get(SelectorMethod.XPATH)
		if(StringUtils.isNotBlank(cssLocator)) {
			return By.cssSelector(cssLocator)
		}
		else if(StringUtils.isNotBlank(xpathLocator)) {
			return By.xpath(xpathLocator)
		}
		else {
			return null
		}
	}
	
	@Keyword
	def elementVisible(TestObject to, int timeout) {
	
		setDriver()
		
		jsWait.pollingEvery(100, TimeUnit.MILLISECONDS)
		jsWait.ignoring(StaleElementReferenceException.class)
		
		By locator = getLocator(to)
		if(locator != null)
			jsWait.until(ExpectedConditions.visibilityOfElementLocated(locator))
		else
			KeywordUtil.markFailedAndStop('Locator is neither XPATH or CSS')
	}
	
	@Keyword
	def ajaxComplete() {
		
		setDriver();
		jsExec.executeScript("var callback = arguments[arguments.length - 1];"
			+ "var xhr = new XMLHttpRequest();" + "xhr.open('GET', '/Ajax_call', true);"
			+ "xhr.onreadystatechange = function() {" + "  if (xhr.readyState == 4) {"
			+ "    callback(xhr.responseText);" + "  }" + "};" + "xhr.send();");
	}
}
