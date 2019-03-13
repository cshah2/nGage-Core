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

		def startTime = System.currentTimeMillis()
		def endTime = startTime + TimeUnit.SECONDS.toMillis(timeout)
		def currentTime = System.currentTimeMillis()
		boolean isWindowClosed = false
		
		try {
			WebDriver driver = DriverFactory.getWebDriver()
			String currentWindow = driver.getWindowHandle()
			WebUI.click(saveButton)
	
			
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
		}
		catch(Exception e) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop("Exception occurred while processing command "+e.toString())
		}

		if(isWindowClosed) {
			KeywordUtil.markPassed("Pop up window is closed")
		}
		else {
			WebUI.takeScreenshot()
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
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop("Could not find window containing URL text "+text)
		}
	}

	@Keyword
	def verifyOpenWindowCount(int expCount) {
		WebDriver driver = DriverFactory.getWebDriver()
		int actCount = driver.getWindowHandles().size()
		WebUI.verifyEqual(actCount, expCount)
	}

	@Keyword
	def switchToUrlContains(String url, int timeout) {

		def startTime = System.currentTimeMillis()
		def endTime = startTime + TimeUnit.SECONDS.toMillis(timeout)
		def currentTime = System.currentTimeMillis()

		boolean isWindowFound = false

		while(currentTime < endTime) {
			try {
				WebDriver driver = DriverFactory.getWebDriver()
				Set<String> handles = driver.getWindowHandles()
				for (handle in handles) {
					driver.switchTo().window(handle)

					if(driver.getCurrentUrl().trim().toLowerCase().contains(url.trim().toLowerCase())) {
						isWindowFound = true
						break
					}
				}
				if(isWindowFound) {
					break
				}
				WebUI.delay(1)
				currentTime = System.currentTimeMillis()
			}
			catch(Exception e) {
				WebUI.delay(1)
				currentTime = System.currentTimeMillis()
			}
		}

		if(isWindowFound) {
			KeywordUtil.markPassed('Window found and switched to')
		}
		else {
			KeywordUtil.markFailedAndStop('Could not found window in given time '+GlobalVariable.G_LongTimeout)
		}
	}
}
