package actions

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.util.concurrent.TimeUnit

import org.apache.commons.lang3.StringUtils
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable
import utils.WebUtil

public class Calender {

	@Keyword
	def selectDate(String date,TestObject element) {
		//parse date
		date=date.replaceAll('/','-')
		String[] inputDateValue=date.split("\\-")
		String mm=inputDateValue[0]
		String dd=inputDateValue[1]
		String yyyy=inputDateValue[2]

		TestObject parentObject = element.getParentObject()
		WebUI.click(element)
		(new Common()).waitForFrameToLoad(parentObject)
	}
}
