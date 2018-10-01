package actions

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.util.concurrent.TimeUnit

import org.openqa.selenium.Dimension
import org.openqa.selenium.Point
import org.openqa.selenium.WebDriver

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
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

public class Window {

	@Keyword
	def clickElementAndWaitForWindowClose(TestObject saveButton, int timeout) {
		WebDriver driver = DriverFactory.getWebDriver()
		String currentWindow = driver.getWindowHandle()
		WebUI.click(saveButton)

		def startTime = System.currentTimeMillis()
		def endTime = startTime + TimeUnit.SECONDS.toMillis(timeout)
		def currentTime = System.currentTimeMillis()

		boolean isWindowClosed = false
		Set<String> allWindows = driver.getWindowHandles()
		while(currentTime < endTime) {
			if(!allWindows.contains(currentWindow)) {
				isWindowClosed = true
				break
			}
			WebUI.delay(2)
			currentTime = System.currentTimeMillis()
			allWindows = driver.getWindowHandles()
		}

		if(isWindowClosed) {
			KeywordUtil.markPassed("Pop up window is closed")
		}
		else {
			KeywordUtil.markFailedAndStop("Window did not closed in given timeout period "+timeout)
		}
	}

	@Keyword
	def switchToUrlContains(String text) {
		WebDriver driver = DriverFactory.getWebDriver()
		Set<String> allHandles = driver.getWindowHandles()

		boolean isWindowFound = false

		for(String handle in allHandles) {
			driver.switchTo().window(handle)
			if(driver.getCurrentUrl().contains(text)) {
				isWindowFound = true
				break
			}
		}

		if(isWindowFound) {
			KeywordUtil.markPassed("Switched to window containing URL text "+text)
		}
		else {
			KeywordUtil.markFailedAndStop("Could not find window containing URL text "+text)
		}
	}

	/**
	 * Command to set Browser screen size
	 * @param width
	 * @param height
	 * @return
	 */
	@Keyword
	def setScreenSize(int width, int height) {
		try {
			Dimension resolution = new Dimension(width, height)
			WebDriver driver = DriverFactory.getWebDriver()
			driver.manage().window().setPosition(new Point(0, 0))
			driver.manage().window().setSize(resolution)
			KeywordUtil.markPassed("Screen resolution set to : "+width+" x "+height)
		} catch(Exception e) {
			KeywordUtil.markFailedAndStop("Could not set screen size :"+e.toString())
		}
	}
}
