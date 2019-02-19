package utils

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.util.concurrent.TimeUnit

import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.StaleElementReferenceException
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.FluentWait

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.exception.StepFailedException
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

public class WebUtil {

	public static WebElement getWebElement(TestObject element) {
		TestObject parentFrame = element.getParentObject()
		if(parentFrame != null)
			switchFrameAndWaitForLoad(parentFrame, GlobalVariable.G_LongTimeout)

		return WebUiCommonHelper.findWebElement(element, GlobalVariable.G_LongTimeout)
	}

	public static List<WebElement> getWebElements(TestObject elements) {
		TestObject parentFrame = elements.getParentObject()
		if(parentFrame != null)
			switchFrameAndWaitForLoad(parentFrame, GlobalVariable.G_LongTimeout)

		return WebUiCommonHelper.findWebElements(elements, GlobalVariable.G_LongTimeout)
	}

	/**
	 * Method to switch to Iframes and wait for Frames to load
	 * @param frame
	 */
	public static void switchFrameAndWaitForLoad(TestObject frame , int timeout) {

		WebUI.switchToFrame(frame, timeout)
		WebUI.waitForPageLoad(timeout)
		WebUI.waitForJQueryLoad(timeout)
		//WebUI.delay(1)
	}

	public static void killProcess(String processName) {

		String command = "TASKKILL /F /IM "+processName+" /T"
		Process process = Runtime.getRuntime().exec(command)
		process.destroy()
	}

	public static void delay(int milliSeconds) {
		try {
			Thread.sleep(milliSeconds)
		}catch(Exception e) {
			println "Exception occured while waiting for "+milliSeconds+" milliseconds"
			println e.toString()
		}
	}

	public static void waitForAjax(WebDriver driver, String action) {
		driver.manage().timeouts().setScriptTimeout(GlobalVariable.G_LongTimeout, TimeUnit.SECONDS);
		((JavascriptExecutor) driver).executeAsyncScript(
				"var callback = arguments[arguments.length - 1];" +
				"var xhr = new XMLHttpRequest();" +
				"xhr.open('POST', '/" + action + "', true);" +
				"xhr.onreadystatechange = function() {" +
				"  if (xhr.readyState == 4) {" +
				"    callback(xhr.responseText);" +
				"  }" +
				"};" +
				"xhr.send();");
	}

	public static void closeAllPopUpWindows() {

		WebDriver driver = DriverFactory.getWebDriver()
		String originalHandle = Consts.ORIGINAL_WINDOW_HANDLE

		for(String handle : driver.getWindowHandles()) {
			if (!handle.equals(originalHandle)) {
				driver.switchTo().window(handle);
				driver.close();
			}
		}

		driver.switchTo().window(originalHandle);
	}


	public static String getCurrentWindowHandle() {
		WebDriver driver = DriverFactory.getWebDriver()
		return driver.getWindowHandle();
	}
	
	public static void openBrowser() {
		WebUI.openBrowser('')
		WebUI.maximizeWindow()
		Consts.ORIGINAL_WINDOW_HANDLE = getCurrentWindowHandle()
	}
}
