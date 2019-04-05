package actions

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

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
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import utils.WebUtil

public class Report {

	WebDriver driver;
	Map<String, WebElement> lvlOne
	Map<String, WebElement> lvlTwo
	Map<String, WebElement> lvlThree


	private void setLevelOne() {
		driver = DriverFactory.getWebDriver()

		lvlOne = new HashMap<String, WebElement>()

		List<WebElement> elements = driver.findElements(By.xpath("//div[@id='menudiv_108']/ul/li/a"))
		for(WebElement e in elements) {
			String key = e.getText().replace("\u00a0", " ").trim()
			lvlOne.put(key, e)
		}
	}

	private void setLevelTwo(String lvl_one) {
		lvlTwo = new HashMap<String, WebElement>()
		WebElement lvlOneElement = lvlOne.get(lvl_one)
		WebElement parent = lvlOneElement.findElement(By.xpath(".."))
		if(!isAreaExpanded(parent)) {
			Actions actions = new Actions(driver)
			actions.doubleClick(lvlOneElement).build().perform()
			WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
			setLevelOne()
		}
		lvlOneElement = lvlOne.get(lvl_one)
		parent = lvlOneElement.findElement(By.xpath(".."))
		List<WebElement> elements = parent.findElements(By.xpath('./ul/li/a'))
		for(WebElement e in elements) {
			String key = e.getText().replace("\u00a0", " ").trim()
			lvlTwo.put(key, e)
		}
	}

	private void setLevelThree(String lvl_one, String lvl_two) {
		lvlThree = new HashMap<String, WebElement>()
		WebElement lvlTwoElement = lvlTwo.get(lvl_two)
		WebElement parent = lvlTwoElement.findElement(By.xpath(".."))
		if(!isAreaExpanded(parent)) {
			Actions actions = new Actions(driver)
			actions.doubleClick(lvlTwoElement).build().perform()
			WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
			setLevelOne()
			setLevelTwo(lvl_one)
		}
		lvlTwoElement = lvlTwo.get(lvl_two)
		parent = lvlTwoElement.findElement(By.xpath(".."))
		List<WebElement> elements = parent.findElements(By.xpath('./ul/li/a'))
		for(WebElement e in elements) {
			String key = e.getText().replace("\u00a0", " ").trim()
			lvlThree.put(key, e)
		}
	}

	private boolean isAreaExpanded(WebElement e) {
		if(e.getAttribute('aria-expanded').equalsIgnoreCase('true')) {
			return true
		}
		else {
			return false
		}
	}

	/* ############################# KEYWORDS ##################################### */	
//	@Keyword
//	def clickReport(String lvl_one, String lvl_two, String lvl_three) {
//		
//		try {
//			setLevelOne()
//			setLevelTwo(lvl_one)
//			setLevelThree(lvl_one, lvl_two)
//			lvlThree.get(lvl_three).click()
//		}
//		catch(Exception e) {
//			WebUI.takeScreenshot()
//			KeywordUtil.markFailedAndStop('Unable to click report '+lvl_one+' -> '+lvl_two+' -> '+lvl_three+'\n'+e.toString())
//		}
//		new Common().waitForReportToLoad(GlobalVariable.G_ReportTimeout)
//	}

//	@Keyword
//	def rightClickReport(String lvl_one, String lvl_two, String lvl_three) {
//		try {
//			setLevelOne()
//			setLevelTwo(lvl_one)
//			setLevelThree(lvl_one, lvl_two)
//			Actions actions = new Actions(driver)
//			actions.contextClick(lvlThree.get(lvl_three)).build().perform()
//		}
//		catch(Exception e) {
//			WebUI.takeScreenshot()
//			KeywordUtil.markFailedAndStop('Unable to right click report '+lvl_one+' -> '+lvl_two+' -> '+lvl_three+'\n'+e.toString())
//		}
//	}

	@Keyword
	def verifyReportIsPresentUnderSubGroup(String lvl_one, String lvl_two, String reportName) {
		
		boolean isFound = false
		try {
			setLevelOne()
			setLevelTwo(lvl_one)
			setLevelThree(lvl_one, lvl_two)
			if(lvlThree.containsKey(reportName)) {
				isFound = true
			}
		}
		catch(Exception e) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop('Unable to verify sub report is present'+lvl_one+' -> '+lvl_two+' -> '+reportName+'\n'+e.toString())
		}
		if(isFound) {
			KeywordUtil.markPassed('Report '+reportName+' is found under subGroup '+lvl_two)
		}
		else {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop('Report '+reportName+' is not found under subGroup '+lvl_two)
		}
	}

	@Keyword
	def verifyReportIsNotPresentUnderSubGroup(String lvl_one, String lvl_two, String reportName) {
		
		boolean isNotFound = false
		try {
			setLevelOne()
			setLevelTwo(lvl_one)
			setLevelThree(lvl_one, lvl_two)
			if(!lvlThree.containsKey(reportName)) {
				isNotFound = true
			}
		}
		catch(Exception e) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop('Unable to verify sub report is not present'+lvl_one+' -> '+lvl_two+' -> '+reportName+'\n'+e.toString())
		}
		if(isNotFound) {
			KeywordUtil.markPassed('Report '+reportName+' is not found under subGroup '+lvl_two)
		}
		else {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop('Report '+reportName+' is found under subGroup '+lvl_two)
		}
	}

	@Keyword
	def verifySubGroupIsPresentUnderGroup(String lvl_one, String subGroupName) {
		boolean isFound = false
		try {
			setLevelOne()
			setLevelTwo(lvl_one)
			if(lvlTwo.containsKey(subGroupName)) {
				isFound = true
			}
		}
		catch(Exception e) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop('Unable to verify sub group is present'+lvl_one+' -> '+subGroupName+'\n'+e.toString())
		}
		if(isFound) {
			KeywordUtil.markPassed('Sub Group '+subGroupName+' is found under Group '+lvl_one)
		}
		else {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop('Sub Group '+subGroupName+' is not found under Group '+lvl_one)
		}
	}

	@Keyword
	def verifySubGroupIsNotPresentUnderGroup(String lvl_one, String subGroupName) {
		
		boolean isNotFound = false
		try {
			setLevelOne()
			setLevelTwo(lvl_one)
			if(!lvlTwo.containsKey(subGroupName)) {
				isNotFound = true
			}
		}
		catch(Exception e) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop('Unable to verify sub group is not present'+lvl_one+' -> '+subGroupName+'\n'+e.toString())
		}
		if(isNotFound) {
			KeywordUtil.markPassed('Sub Group '+subGroupName+' is not found under Group '+lvl_one)
		}
		else {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop('Sub Group '+subGroupName+' is found under Group '+lvl_one)
		}
	}

	@Keyword
	def verifyAllReportsUnderSubGroup(String lvl_one, String lvl_two, String... reportNames) {
		
		boolean isReportPresent = true
		String notFoundReport = ''
		
		try {
			setLevelOne()
			setLevelTwo(lvl_one)
			setLevelThree(lvl_one, lvl_two)
	
			int actReportCount = lvlThree.size()
			int expReportCount = reportNames.length
			WebUI.verifyEqual(actReportCount, expReportCount)
	
			
			for(String reportName in reportNames) {
				if(!lvlThree.containsKey(reportName)) {
					isReportPresent = false
					notFoundReport = reportName
					break
				}
			}
		}
		catch(Exception e) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop('Exception occured while verifying all reports under sub group \n'+e.toString())
		}

		if(isReportPresent) {
			KeywordUtil.markPassed('All Reports are present in sub group')
		}
		else {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop('Report '+notFoundReport+' is not present in Sub Group '+lvl_two)
		}
	}

	@Keyword
	def verifyAllSubGroupsUnderGroup(String lvl_one, String... subGroups) {
		
		boolean isSubGroupPresent = true
		String notFoundSubGroup = ''

		try {
			setLevelOne()
			setLevelTwo(lvl_one)
	
			int actSubGroupsCount = lvlTwo.size()
			int expSubGroupsCount = subGroups.length
			WebUI.verifyEqual(actSubGroupsCount, expSubGroupsCount)
	
			for(String subGroup in subGroups) {
				if(!lvlTwo.containsKey(subGroup)) {
					isSubGroupPresent = false
					notFoundSubGroup = subGroup
					break
				}
			}
		}
		catch(Exception e) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop('Exception occured while verifying all sub groups under group \n'+e.toString())
		}

		if(isSubGroupPresent) {
			KeywordUtil.markPassed('All Sub Groups are present in group')
		}
		else {
			KeywordUtil.markFailedAndStop('Sub Group '+notFoundSubGroup+' is not present in Group '+lvl_one)
		}
	}

	@Keyword
	def verifyReportIsLoaded(String tabName, String reportName, String reportDescription) {
		//Verify Tab name of opened report
		WebUI.verifyElementText(findTestObject('Page_nGage_Dashboard/Report/Data_CommonFields/tab_visibleReportName'), tabName)

		//Verify Toolbar1 is visible
		WebUI.verifyElementVisible(findTestObject('Page_nGage_Dashboard/Report/Data_CommonFields/ToolBar1'))

		//Verify Tooblar2 is visible
		WebUI.verifyElementVisible(findTestObject('Page_nGage_Dashboard/Report/Data_CommonFields/ToolBar2'))

		//Verify ReportDiv section is visible
		WebUI.verifyElementVisible(findTestObject('Page_nGage_Dashboard/Report/Data_CommonFields/ReportDiv'))

		//Verify report name is set
		if(reportName != null) {
			WebUI.verifyElementText(findTestObject('Page_nGage_Dashboard/Report/Data_CommonFields/ReportDiv_ReportName'), reportName)
		}
		else {
			WebUI.verifyElementNotPresent(findTestObject('Page_nGage_Dashboard/Report/Data_CommonFields/ReportDiv_ReportName'), GlobalVariable.G_LongTimeout)
		}

		//Verify report description is set
		if(reportDescription != null) {
			WebUI.verifyElementText(findTestObject('Page_nGage_Dashboard/Report/Data_CommonFields/ReportDiv_ReportDescription'), reportDescription)
		}
		else {
			WebUI.verifyElementNotPresent(findTestObject('Page_nGage_Dashboard/Report/Data_CommonFields/ReportDiv_ReportDescription'), GlobalVariable.G_LongTimeout)
		}
	}

	@Keyword
	def verifyDesignPageIsLoaded(String expectedDataSource) {

		WebUI.verifyElementVisible(findTestObject('Page_nGage_Dashboard/Report/Design_CommonFields/tab_DataSource'))
		WebUI.verifyElementVisible(findTestObject('Page_nGage_Dashboard/Report/Design_CommonFields/tab_Fields'))
		WebUI.verifyElementVisible(findTestObject('Page_nGage_Dashboard/Report/Design_CommonFields/tab_Summary'))
		WebUI.verifyElementVisible(findTestObject('Page_nGage_Dashboard/Report/Design_CommonFields/tab_Chart'))
		WebUI.verifyElementVisible(findTestObject('Page_nGage_Dashboard/Report/Design_CommonFields/tab_Gauge'))
		WebUI.verifyElementVisible(findTestObject('Page_nGage_Dashboard/Report/Design_CommonFields/tab_Misc'))
		WebUI.verifyElementVisible(findTestObject('Page_nGage_Dashboard/Report/Design_CommonFields/tab_Style'))
		WebUI.verifyElementVisible(findTestObject('Page_nGage_Dashboard/Report/Design_CommonFields/tab_Filters'))
		WebUI.verifyElementVisible(findTestObject('Page_nGage_Dashboard/Report/Design_CommonFields/tab_Preview'))
		
		WebUI.verifyOptionSelectedByLabel(findTestObject('Page_nGage_Dashboard/Report/Design_CommonFields/select_DataSource'), "(?i)"+expectedDataSource+"(?i)", true, GlobalVariable.G_LongTimeout)
	}
}
