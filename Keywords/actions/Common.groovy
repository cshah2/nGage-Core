package actions

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.awt.Toolkit
import java.util.concurrent.TimeUnit

import org.openqa.selenium.Dimension
import org.openqa.selenium.Point
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.Select

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

import utils.WebUtil

public class Common {

	/**
	 * Keyword tries to maximize current window, in case any exception occurred, it will try the operation for total of 5 times before throwing StepFailedException
	 * Note : This keyword is required because Edge browser failes to maximize window and throws error "window size operation failed because the window is currently not available"
	 * 
	 * This keyword is not used in the script
	 * @return
	 */
	@Keyword
	def maximizeWindow() {

		Toolkit kit = Toolkit.getDefaultToolkit()
		int height = (int)kit.getScreenSize().getHeight()
		int width = (int) kit.getScreenSize().getWidth()
		Dimension resolution = new Dimension(width, height)

		int timeout = 120 //Seconds
		def startTime = System.currentTimeMillis()
		def endTime = startTime + TimeUnit.SECONDS.toMillis(timeout)
		def currentTime = System.currentTimeMillis()

		boolean isMaximized = false

		while(currentTime < endTime) {
			try {
				WebDriver driver = DriverFactory.getWebDriver()
				driver.manage().window().setPosition(new Point(0,0))
				driver.manage().window().setSize(resolution)
				isMaximized = true
				break;
			} catch (Exception e) {
				e.printStackTrace()
				WebUI.delay(3)
				currentTime = System.currentTimeMillis()
			}
		}

		if(isMaximized) {
			KeywordUtil.markPassed("Window maximized")
		}
		else {
			KeywordUtil.markFailedAndStop("Could not maximize window")
		}
	}

	@Keyword
	def login() {

		int retryAttempt = 0
		while(retryAttempt < 3) {
			try {
				loginAction()
				break
			}
			catch(Exception  e) {
				println "Unable to Login into portal "+e.toString()
				WebUI.closeBrowser()
				killDriverProcesses()
				retryAttempt++
			}
		}
	}


	def loginAction() {
		WebUI.openBrowser('')
		if(DriverFactory.getExecutedBrowser().getName() != 'EDGE_DRIVER') {
			WebUI.maximizeWindow()
		}
		WebUI.deleteAllCookies()
		WebUI.navigateToUrl(WebUI.concatenate(GlobalVariable.BaseURL, '/login.aspx'));
		WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
		WebUI.waitForElementVisible(findTestObject('Page_Login/input_Login1UserName'), GlobalVariable.G_LongTimeout)
		WebUI.setText(findTestObject('Page_Login/input_Login1UserName'), GlobalVariable.Username)
		WebUI.setText(findTestObject('Page_Login/input_Login1Password'), GlobalVariable.Password)
		WebUI.selectOptionByValue(findTestObject('Page_Login/select_ALLIANCE_50CMDRDRC20160'), GlobalVariable.Database, true)
		WebUI.click(findTestObject('Page_Login/input_Login1LoginImageButton'))
		WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
		WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
	}

	@Keyword
	def killDriverProcesses() {
		WebUtil.killProcess("chrome.exe")
		WebUtil.killProcess("chromedriver.exe")

		WebUtil.killProcess("MicrosoftEdge.exe")
		WebUtil.killProcess("MicrosoftEdgeCP.exe")
		WebUtil.killProcess("MicrosoftWebDriver.exe")
	}

	@Keyword
	def verifyRecordCountInActivityMatchesWithResultGrid(TestObject activityFolder, TestObject resultGridPageSummary) {
		int activityCount = new MenuBar().getRecordCountInActivity(activityFolder)
		int resultGridCount = new Table().getRecordCountInTableSummary(resultGridPageSummary)
		if(activityCount >= 0 && resultGridCount >= 0) {
			WebUI.verifyEqual(activityCount, resultGridCount)
		}
		else {
			KeywordUtil.markFailedAndStop("Could not get valid record count from Activity Folder or from Result grid.\n Count of Activity Folder = "+activityCount+"\nCount in Result Grid = "+resultGridCount)
		}
	}

	@Keyword
	def waitForReportToLoad(int timeout) {

		String jScript = "return document.getElementById(\"iframe_108\") != undefined && document.getElementById(\"iframe_108\").contentWindow.document.querySelector(\"div[id*='GROUP_CATEGORY_REPORT'][aria-hidden='false'] > iframe\") != undefined && document.getElementById(\"iframe_108\").contentWindow.document.querySelector(\"div[id*='GROUP_CATEGORY_REPORT'][aria-hidden='false'] > iframe\").contentWindow.jq != undefined && document.getElementById(\"iframe_108\").contentWindow.document.querySelector(\"div[id*='GROUP_CATEGORY_REPORT'][aria-hidden='false'] > iframe\").contentWindow.jq.active === 0"

		boolean isReportLoaded = false
		def startTime = System.currentTimeMillis()
		def endTime = startTime + TimeUnit.SECONDS.toMillis(timeout)
		def currentTime = System.currentTimeMillis()

		while(currentTime < endTime) {
			if((Boolean)WebUI.executeJavaScript(jScript, null)) {
				isReportLoaded = true
				break
			}	else {
				WebUI.delay(2)
				currentTime = System.currentTimeMillis()
			}
		}
		if(isReportLoaded) {
			WebUI.delay(1)
			KeywordUtil.markPassed("Report loaded")
		}
		else {
			KeywordUtil.markFailedAndStop("Report not loaded in given time "+timeout+" Seconds")
		}
	}

	@Keyword
	def waitForFrameToLoad(TestObject iFrame) {
		WebUtil.switchFrameAndWaitForLoad(iFrame, GlobalVariable.G_LongTimeout)
		WebUI.switchToDefaultContent()
	}

	@Keyword
	def selectDocClassAndDocTypeForGlobalNew(String docClass, String docType) {
		waitForFrameToLoad(findTestObject('Page_nGage_Dashboard/iframe_ifrmCreateNew'))
		WebUI.selectOptionByLabel(findTestObject('Page_nGage_Dashboard/Home/select_ Show All AutoImportDCA'), docClass, false)
		waitForFrameToLoad(findTestObject('Page_nGage_Dashboard/iframe_ifrmCreateNew'))
		WebUI.selectOptionByLabel(findTestObject('Page_nGage_Dashboard/Home/select_DefaultExpandedAuto wit'), docType, false)
		waitForFrameToLoad(findTestObject('Page_nGage_Dashboard/iframe_ifrmCreateNew'))
	}
}
