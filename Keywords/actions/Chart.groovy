package actions

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.apache.commons.lang3.StringUtils
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions

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

import internal.GlobalVariable
import utils.WebUtil

public class Chart {


	/* ##################### KEYWORDS ##################### */

	@Keyword
	def verifyNumberOfSlices(TestObject chartLocator, int expCount, String sliceLocator) {
		WebElement chart = WebUtil.getWebElement(chartLocator)
		List<WebElement> slices = chart.findElements(By.xpath(sliceLocator))
		WebUI.switchToDefaultContent()
		int actCount = slices.size()
		WebUI.verifyEqual(actCount, expCount)
	}

	@Keyword
	def getNumberOfSlices(TestObject chartLocator, String sliceLocator) {

		WebElement chart = WebUtil.getWebElement(chartLocator)
		List<WebElement> slices = chart.findElements(By.xpath(sliceLocator))
		WebUI.switchToDefaultContent()
		return slices.size()
	}

	@Keyword
	def verifyToolTipText(TestObject chartLocator, int sliceNo, String expToolTipText, String sliceLocator) {
		WebElement chart = WebUtil.getWebElement(chartLocator)
		List<WebElement> slices = chart.findElements(By.xpath(sliceLocator))

		WebDriver driver = DriverFactory.getWebDriver()
		Actions action = new Actions(driver)
		action.moveToElement(slices[sliceNo-1]).build().perform()
		WebUI.delay(2)
		String actText = driver.findElement(By.className("chart-tooltip")).getText().trim().replaceAll(" ", "").replaceAll(" ", "")
		WebUI.switchToDefaultContent()
		expToolTipText = expToolTipText.trim().replaceAll(" ", "").replaceAll(" ", "")
		if(actText.contains(expToolTipText))
			KeywordUtil.markPassed("Expected Text "+ expToolTipText + " is found actual Text "+actText)
		else
			KeywordUtil.markFailedAndStop("Expected Text "+ expToolTipText + " is not found actual Text "+actText)
	}

	@Keyword
	def verifyToolTipText(TestObject chartLocator, int sliceNo, String expKey, String expValue, String sliceLocator) {
		WebElement chart = WebUtil.getWebElement(chartLocator)
		List<WebElement> slices = chart.findElements(By.xpath(sliceLocator))

		WebDriver driver = DriverFactory.getWebDriver()
		Actions action = new Actions(driver)
		action.moveToElement(slices[sliceNo-1]).build().perform()
		WebUI.delay(2)

		String actKey = driver.findElement(By.xpath("//div[contains(@class, 'nvtooltip')][last()]//td[@class='key']")).getText()
		String actValue = driver.findElement(By.xpath("//div[contains(@class, 'nvtooltip')][last()]//td[@class='value']")).getText()
		WebUI.switchToDefaultContent()

		if(actKey.contains(expKey) && actValue.contains(expValue)) {
			KeywordUtil.markPassed("Tool tip value matched")
		}	else {
			KeywordUtil.markFailedAndStop("Tool tip value not matched")
		}
	}

	@Keyword
	def mousOverOnSlice(TestObject chartLocator, int sliceNo, String sliceLocator) {
		WebElement chart = WebUtil.getWebElement(chartLocator)
		List<WebElement> slices = chart.findElements(By.xpath(sliceLocator))

		WebElement slice
		try {
			slice = slices.get(sliceNo - 1)
		}
		catch(Exception e) {
			KeywordUtil.markFailedAndStop('Required slice not found. Total slices = '+slices.size())
		}

		List<WebElement> argList = new ArrayList<WebElement>()
		argList.add(slice)
		WebUI.executeJavaScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('mouseover',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", argList)

		//		Actions aDriver = new Actions(DriverFactory.getWebDriver())
		//		aDriver.moveToElement(slice).build().perform()
		WebUI.delay(3)
		WebUI.switchToDefaultContent()
	}

	@Keyword
	def clickSlice(TestObject chartLocator, int sliceNo, String sliceLocator) {
		WebElement chart = WebUtil.getWebElement(chartLocator)
		List<WebElement> slices = chart.findElements(By.xpath(sliceLocator))

		WebElement slice
		try {
			slice = slices.get(sliceNo - 1)
		}
		catch(Exception e) {
			KeywordUtil.markFailedAndStop('Required slice not found. Total slices = '+slices.size())
		}

		List<WebElement> argList = new ArrayList<WebElement>()
		argList.add(slice)
		WebUI.executeJavaScript("var evt = document.createEvent('MouseEvents');" + "evt.initMouseEvent('click',true, true, window, 0, 0, 0, 0, 0, false, false, false, false, 0,null);" + "arguments[0].dispatchEvent(evt);", argList)

		//		slice.click()

		WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
		WebUI.switchToDefaultContent()
	}
}
