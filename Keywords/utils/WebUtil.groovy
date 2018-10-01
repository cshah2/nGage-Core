package utils

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.StaleElementReferenceException
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
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

public class WebUtil {

	public static WebElement getWebElement(TestObject element) {
		TestObject parentFrame = element.getParentObject()
		switchFrameAndWaitForLoad(parentFrame, GlobalVariable.G_LongTimeout)

		return WebUiCommonHelper.findWebElement(element, GlobalVariable.G_LongTimeout)
	}

	/**
	 * Method to switch to Iframes and wait for Frames to load
	 * @param frame
	 */
	public static void switchFrameAndWaitForLoad(TestObject frame , int timeout) {

		WebUI.switchToFrame(frame, timeout)
		WebUI.waitForPageLoad(timeout)
		WebUI.waitForJQueryLoad(timeout)
		WebUI.delay(1)
	}

	public static void killProcess(String processName) {

		String command = "TASKKILL /F /IM "+processName+" /T"
		Process process = Runtime.getRuntime().exec(command)
		process.destroy()
	}
}
