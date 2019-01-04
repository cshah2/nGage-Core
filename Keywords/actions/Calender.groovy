package actions

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.concurrent.TimeUnit

import org.apache.commons.lang3.StringUtils
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.ui.Select

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable
import utils.DateUtil
import utils.WebUtil

public class Calender {

	static final String YEAR_XPATH = "//div[@id='ui-datepicker-div']//select[@data-handler = 'selectYear']"
	static final String MONTH_XPATH = "//div[@id='ui-datepicker-div']//select[@data-handler = 'selectMonth']"
	static final String DONE_XPATH = "//div[@id='ui-datepicker-div']//button[text()='Done']"
	
	
	@Keyword
	def selectDate(String date, String month, String year, TestObject element) {

		try {
			TestObject parentObject = element.getParentObject()
			WebUI.click(element)
			(new Common()).waitForFrameToLoad(parentObject)
			WebUI.switchToFrame(parentObject, GlobalVariable.G_LongTimeout)
	
			WebDriver driver = DriverFactory.getWebDriver()
			Select selYear = new Select(driver.findElement(By.xpath(YEAR_XPATH)))
			selYear.selectByVisibleText(year)
			WebUI.delay(1)
	
			Select selMonth = new Select(driver.findElement(By.xpath(MONTH_XPATH)))
			selMonth.selectByVisibleText(month)
			WebUI.delay(1)
	
			driver.findElement(By.xpath("//div[@id='ui-datepicker-div']//td[@data-handler='selectDay']/a[text()='"+date+"']")).click()
			WebUI.delay(1)
		}
		catch(Exception e) {
			KeywordUtil.markFailedAndStop('Unable to select date from Calender picker \n'+e.toString())
		}
		WebUI.switchToDefaultContent()
	}
	
	@Keyword
	def selectDateTime(String date, String month, String year, TestObject element) {
		TestObject parentObject = element.getParentObject()
		WebUI.click(element)
		(new Common()).waitForFrameToLoad(parentObject)
		WebUI.switchToFrame(parentObject, GlobalVariable.G_LongTimeout)

		WebDriver driver = DriverFactory.getWebDriver()
		Select selYear = new Select(driver.findElement(By.xpath(YEAR_XPATH)))
		selYear.selectByVisibleText(year)
		WebUI.delay(1)

		Select selMonth = new Select(driver.findElement(By.xpath(MONTH_XPATH)))
		selMonth.selectByVisibleText(month)
		WebUI.delay(1)

		driver.findElement(By.xpath("//div[@id='ui-datepicker-div']//td[@data-handler='selectDay']/a[text()='"+date+"']")).click()
		WebUI.delay(1)

		'Click on Done button'
		driver.findElement(By.xpath(DONE_XPATH)).click()
		
		WebUI.switchToDefaultContent()
	}
}
