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

	@Keyword
	def selectDate(String date,TestObject element) {
		//parse date
		
		if(StringUtils.isBlank(date)) {
			KeywordUtil.markFailedAndStop('Invalid date value provided '+date)
		}
		
		date=date.replaceAll('/','-').subSequence(0, 10)
		
		Date zDate = new SimpleDateFormat('MM-dd-yyyy').parse(date)
		String newFormat = zDate.format('MMM-d-yyyy')
		
		String[] inputDateValue=newFormat.split("\\-")
		String _month=inputDateValue[0]
		String _date=inputDateValue[1]
		String _year=inputDateValue[2]

		TestObject parentObject = element.getParentObject()
		WebUI.click(element)
		(new Common()).waitForFrameToLoad(parentObject)
		
		WebUI.switchToFrame(parentObject, GlobalVariable.G_LongTimeout)
		
		WebDriver driver = DriverFactory.getWebDriver()
		
		//driver.findElement(By.xpath(''))
		Select selYear = new Select(driver.findElement(By.xpath("//div[@id='ui-datepicker-div']//select[@data-handler = 'selectYear']")))
		selYear.selectByVisibleText(_year)
		WebUI.delay(1)
		
		Select selMonth = new Select(driver.findElement(By.xpath("//div[@id='ui-datepicker-div']//select[@data-handler = 'selectMonth']")))
		selMonth.selectByVisibleText(_month)
		WebUI.delay(1)

		driver.findElement(By.xpath("//div[@id='ui-datepicker-div']//td[@data-handler='selectDay']/a[text()='"+_date+"']")).click()
		WebUI.delay(1)
		
		WebUI.switchToDefaultContent()
	}
}
