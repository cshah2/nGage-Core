package actions

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.awt.Toolkit
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit

import org.apache.commons.lang3.StringUtils
import org.apache.commons.lang3.math.NumberUtils
import org.openqa.selenium.By
import org.openqa.selenium.Dimension
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.Keys
import org.openqa.selenium.Point
import org.openqa.selenium.StaleElementReferenceException
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.FluentWait
import org.openqa.selenium.support.ui.Select
import org.openqa.selenium.support.ui.WebDriverWait

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.exception.StepFailedException
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import common.DocClass
import common.DocType

import com.google.common.base.Predicate

import internal.GlobalVariable as GlobalVariable
import utils.WebUtil
import static utils.Consts.*

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
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop("Could not maximize window")
		}
	}

	@Keyword
	def login() {
		login(GlobalVariable.Username, GlobalVariable.Password, GlobalVariable.Database)
	}

	@Keyword
	def login(String username, String password, String database) {

		navigateToLoginPage()
		WebUI.setText(findTestObject('Page_Login/input_UserName'), username)
		WebUI.setText(findTestObject('Page_Login/input_Password'), password)
		WebUI.selectOptionByLabel(findTestObject('Page_Login/select_Schema'), GlobalVariable.Database, false)
		WebUI.click(findTestObject('Page_Login/button_Login'))
		WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
		WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
		WebUI.verifyElementVisible(findTestObject('Page_nGage_Dashboard/input_btnLogout'))
	}

	@Keyword
	def navigateToLoginPage() {

		try{
			WebUI.switchToWindowIndex(0)
			WebUI.maximizeWindow()
		}
		catch(Exception e) {
			WebUtil.openBrowser()
			WebUI.maximizeWindow()
		}

		WebUI.deleteAllCookies()
		WebUI.navigateToUrl(WebUI.concatenate(GlobalVariable.BaseURL, '/login.aspx'));
		WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
		WebUI.waitForElementVisible(findTestObject('Page_Login/input_UserName'), GlobalVariable.G_LongTimeout)
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
			WebUI.takeScreenshot()
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
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop("Report not loaded in given time "+timeout+" Seconds")
		}
	}

	@Keyword
	def waitForFrameToLoad(TestObject iFrame) {
		WebUtil.waitForAjax(DriverFactory.getWebDriver(), "MicrosoftAjax")
		WebUtil.switchFrameAndWaitForLoad(iFrame, GlobalVariable.G_LongTimeout)
		WebUI.switchToDefaultContent()
		WebUtil.delay(100)
	}

	@Keyword
	def dragAndDropByXOffset(TestObject to, int xOffset) {
		WebElement source = WebUtil.getWebElement(to)

		int lPosition = source.getLocation().getX()
		int tPosition = source.getLocation().getY()

		int height = source.getSize().getHeight()
		int width = source.getSize().getWidth()

		println "Element position is = "+lPosition+","+tPosition
		println "Element size is = "+width+","+height

		WebDriver driver = DriverFactory.getWebDriver()
		Actions actions = new Actions(driver)
		int heightOffset = (int)height / 4
		int widthOffset = lPosition + (int)width / 2
		actions.moveToElement(source).moveByOffset(0, heightOffset).clickAndHold().moveByOffset(xOffset, heightOffset).release().build().perform()
		WebUI
	}

	/* ############################  Common Action Keywords ############################ */
	@Keyword
	def selectDocClassAndDocTypeForGlobalNew(String docClass, String docType) {
		waitForFrameToLoad(findTestObject('Page_nGage_Dashboard/iframe_ifrmCreateNew'))
		WebUI.selectOptionByLabel(findTestObject('Page_nGage_Dashboard/Home/select_ Show All AutoImportDCA'), docClass, false)
		waitForFrameToLoad(findTestObject('Page_nGage_Dashboard/iframe_ifrmCreateNew'))
		WebUI.selectOptionByLabel(findTestObject('Page_nGage_Dashboard/Home/select_DefaultExpandedAuto wit'), docType, false)
		waitForFrameToLoad(findTestObject('Page_nGage_Dashboard/iframe_ifrmCreateNew'))
	}

	@Keyword
	def openDocumentFromRecentGrid(String documentTitle) {
		WebUI.click(findTestObject('Page_nGage_Dashboard/Home/a_Recent Documents'))
		waitForFrameToLoad(findTestObject('Page_nGage_Dashboard/iframe_iframe_103'))

		//Validate atleast 1 record is present in the grid.
		WebUI.verifyElementPresent(findTestObject('Page_nGage_Dashboard/Home/tableRow_recentDocuments_firstRow'), GlobalVariable.G_LongTimeout);

		//Sort Record in grid by DocID Descending
		new Table().clickColumnHeader(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'), 'Doc ID')
		new Table().clickColumnHeader(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'), 'Doc ID')

		WebUI.click(findTestObject('Page_nGage_Dashboard/Home/column_RecentDocuments LastAction'))
		WebUI.switchToWindowTitle(documentTitle)
		WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
		//waitForFrameToLoad(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/iframe_westContainerFrame'))

		WebUI.maximizeWindow()
		WebUI.delay(1)

		WebUI.switchToDefaultContent()
	}

	@Keyword
	def clearClipBoard() {

		//Clear clipboard items
		'Click on clipboard menu'
		WebUI.click(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/menu_Clipboard'))

		'Click on Clear clipboard'
		WebUI.click(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/subMenu_Clipboard_Clear Clipboard'))
		waitForFrameToLoad(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/iframe_westContainerFrame'))

		'Click OK on confirmation dialog'
		String confirmPrompt = WebUI.getText(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/ConfirmationDialog_message')).trim()
		if(confirmPrompt.contains('Are you sure you want to Clear ClipBoard?'))
			WebUI.click(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/ConfirmationDialog_Ok_button'))
		else
			WebUI.click(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/alertDialog_Ok_button'))
		waitForFrameToLoad(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/iframe_westContainerFrame'))
	}

	@Keyword
	def clickMultipleElements(List<TestObject> elements) {

		TestObject firstElement = elements.get(0)
		TestObject parentElement = firstElement.getParentObject()

		WebUI.click(firstElement)
		WebUI.delay(3)
		//waitForImageToRender(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/iFrame_Image_EPMMultipageViewer'))

		elements.remove(0)

		if(parentElement != null)
			WebUtil.switchFrameAndWaitForLoad(parentElement, GlobalVariable.G_LongTimeout)

		List<WebElement> selElements = new ArrayList<WebElement>()
		for(TestObject to in elements) {
			selElements.add(WebUiCommonHelper.findWebElement(to, GlobalVariable.G_LongTimeout))
		}

		Actions actions = new Actions(DriverFactory.getWebDriver())
		actions.keyDown(Keys.CONTROL)
		for(WebElement e in selElements) {
			actions.click(e)
		}
		actions.keyUp(Keys.CONTROL)
		actions.build().perform()

		WebUI.switchToDefaultContent()
	}

	@Keyword
	def verifyRecordCountMatchesInActivityAndGrid(TestObject activity, TestObject gridSummary) {
		int activityCount = new MenuBar().getRecordCountInActivity(activity)
		String pageSummaryText=WebUI.getText(gridSummary)
		int gridCount=Integer.parseInt(pageSummaryText.split(' of ')[1].trim())
		WebUI.verifyEqual(activityCount, gridCount)
	}

	@Keyword
	def verifyElementAttributeValueContains(TestObject element, String attrName, String expValue) {
		String actualValue= WebUI.getAttribute(element, attrName)
		if(actualValue.contains(expValue))
		{
			KeywordUtil.markPassed("atribute contains expected value")
		}
		else
		{
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop("attribute: "+actualValue +" not contains "+expValue)
		}
	}

	@Keyword
	def verifyElementAttributeValueNotContains(TestObject element, String attrName, String expValue) {
		String actualValue= WebUI.getAttribute(element, attrName)
		if(!actualValue.contains(expValue))
		{
			KeywordUtil.markPassed("attribute: "+actualValue +" not contains "+expValue)
		}
		else
		{
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop("attribute: "+actualValue +" contains "+expValue)
		}
	}

	@Keyword
	def verifyDateFormat(String inputDate,String inputDateFormat)
	{
		try {
			SimpleDateFormat dateFormat=new SimpleDateFormat(inputDateFormat)
			dateFormat.parse(inputDate)
			KeywordUtil.markPassed("string is in given date  format")
		} catch (Exception e) {
			e.printStackTrace()
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop("string isnt in given  date format")
		}
	}


	@Keyword
	def changePasswordPageFormFill(String username, String currentPassword, String newPassword, String confirmPassword) {
		'Click on Change Password link under home menu'
		WebUI.click(findTestObject('Page_nGage_Dashboard/Home/ChangePassword/menu_Change Password'))
		waitForFrameToLoad(findTestObject('Page_nGage_Dashboard/Home/ChangePassword/iframe_103'))

		'Verify username in login name input field'
		WebUI.verifyElementAttributeValue(findTestObject('Page_nGage_Dashboard/Home/ChangePassword/input_Login Name'), 'value', username, GlobalVariable.G_LongTimeout)

		'Enter old password in input field'
		WebUI.setText(findTestObject('Page_nGage_Dashboard/Home/ChangePassword/input_Old Password'), currentPassword)

		'Enter new password in input field'
		WebUI.setText(findTestObject('Page_nGage_Dashboard/Home/ChangePassword/input_New Password'), newPassword)

		'Enter new password in confirm password field'
		WebUI.setText(findTestObject('Page_nGage_Dashboard/Home/ChangePassword/input_Confirm Password'), confirmPassword)

		'Click on Save button'
		WebUI.click(findTestObject('Page_nGage_Dashboard/Home/ChangePassword/button_Save'))
		waitForFrameToLoad(findTestObject('Page_nGage_Dashboard/Home/ChangePassword/iframe_103'))
	}

	@Keyword
	def changePasswordPageFormFill_Login(String username, String currentPassword, String newPassword, String confirmPassword) {

		'Open Browser'
		WebUI.openBrowser('')

		'Maximize window'
		WebUI.maximizeWindow()

		'Delet all cookies'
		WebUI.deleteAllCookies()

		'Navigate to login page'
		WebUI.navigateToUrl(WebUI.concatenate(GlobalVariable.BaseURL, '/login.aspx'));
		WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
		WebUI.waitForElementVisible(findTestObject('Page_Login/input_UserName'), GlobalVariable.G_LongTimeout)

		'Enter username'
		WebUI.setText(findTestObject('Page_Login/input_UserName'), username)

		'Select Database'
		WebUI.selectOptionByLabel(findTestObject('Page_Login/select_Schema'), GlobalVariable.Database, false)

		'Click on ChangePassword link'
		WebUI.click(findTestObject('Page_Login/link_Change Password'))
		WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

		'Set old password'
		WebUI.setText(findTestObject('Page_ChangePassword/input_Old Password'), currentPassword)

		'Set new password'
		WebUI.setText(findTestObject('Page_ChangePassword/input_New Password'), newPassword)

		'Set confirm password'
		WebUI.setText(findTestObject('Page_ChangePassword/input_Confirm Password'), confirmPassword)

		'Click on Change Password button'
		WebUI.click(findTestObject('Page_ChangePassword/btn_Change_Password'))
		WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
		WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
	}

	@Keyword
	def verifyTotalRecordCountFromPageSummary(TestObject to, int expCount) {
		String text = WebUI.getText(to).trim()
		if(expCount < 0) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop('Expected record count is less than 0')
		}

		int actCount
		try {
			//actCount = Integer.parseInt(text.split(' of ')[1].trim())
			actCount = Integer.parseInt(text.split(' of ')[1].trim().replaceAll(',', ''))
		}
		catch(Exception e) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop('Could not get total record counts from page summary '+text)
		}

		if(actCount == expCount) {
			KeywordUtil.markPassed('Expected count and actual counts are matching')
		}
		else {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop('Expected count '+expCount+' does not match with actual count '+actCount)
		}
	}

	@Keyword
	def setText_Date(TestObject to, String text) {

		WebElement e = WebUtil.getWebElement(to)
		List<WebElement> list = new ArrayList<WebElement>()
		list.add(e)
		WebUI.executeJavaScript('arguments[0].value = "'+text+'"', list)
		WebUI.switchToDefaultContent()
		WebUI.click(to)
		WebUI.sendKeys(to, Keys.chord(Keys.TAB))
		WebUtil.delay(100)
	}

	@Keyword
	def setTextJQuery(TestObject to, String text) {

		WebElement e = WebUtil.getWebElement(to)
		List<WebElement> list = new ArrayList<WebElement>()
		list.add(e)
		WebUI.executeJavaScript('arguments[0].value = "'+text+'"', list)
		WebUI.switchToDefaultContent()
	}


	@Keyword
	def getPageSource() {
		WebDriver driver = DriverFactory.getWebDriver()
		return driver.getPageSource()
	}

	@Keyword
	def verifyJQueryRunningStatus(TestObject iframe, Boolean isExpectedToBeRunning) {
		if(iframe != null) {
			WebUI.switchToFrame(iframe, GlobalVariable.G_LongTimeout)
		}

		Boolean isJqueryRunning = (Boolean) WebUI.executeJavaScript("return !!window.jQuery && window.jQuery.active > 0", null)
		if(isJqueryRunning == isExpectedToBeRunning) {
			KeywordUtil.markPassed('Actual JQuery status = '+isJqueryRunning.toString()+' ,Expected JQuery status = '+isExpectedToBeRunning.toString())
		}
		else {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop('Actual JQuery status = '+isJqueryRunning.toString()+' ,Expected JQuery status = '+isExpectedToBeRunning.toString())
		}
	}

	@Keyword
	def waitForElementVisible(TestObject to, int timeout) {

		def startTime = System.currentTimeMillis()
		def endTime = startTime + TimeUnit.SECONDS.toMillis(timeout)
		def currentTime = System.currentTimeMillis()

		boolean isVisible = false
		Exception lastException
		while(currentTime < endTime) {
			try {
				WebUI.waitForElementVisible(to, 10)
				isVisible = true
				break
				println "Element Found and Visible"
			}
			catch(StepFailedException e) {
				println "StaleElement Reference Exception occurred "+e.toString()
				lastException = e
				WebUI.delay(3)
				currentTime = System.currentTimeMillis()
			}
		}

		if(isVisible) {
			KeywordUtil.markPassed('Element visible')
		}
		else {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop('Element not visible \n'+lastException.toString)
		}

	}

	@Keyword
	def waitForTabLoading(TestObject iframe, int timeout) {

		WebUI.waitForElementPresent(findTestObject('Page_WMI_NEW/visibleLoader'), 5)
		WebUI.waitForElementNotPresent(findTestObject('Page_WMI_NEW/visibleLoader'), timeout)
	}

	@Keyword
	def setTextAndSave(TestObject to, String text) {

		WebUI.clearText(to)
		WebUI.sendKeys(to, Keys.chord(Keys.TAB))
		waitForTabLoading(null, GlobalVariable.G_LongTimeout)

		WebUI.sendKeys(to, text)
		WebUI.sendKeys(to, Keys.chord(Keys.TAB))
		waitForTabLoading(null, GlobalVariable.G_LongTimeout)
	}

	@Keyword
	def getCssValue(TestObject to, String css) {
		WebElement e = WebUtil.getWebElement(to)
		String cssValue = e.getCssValue(css).trim()
		WebUI.switchToDefaultContent()
		return cssValue
	}

	@Keyword
	def verifyCssValue(TestObject to, String css, String expCssValue) {
		WebUI.verifyMatch(getCssValue(to, css), expCssValue.trim(), false)
	}

	@Keyword
	def openThumbnail(TestObject toggler) {
		TestObject parent = toggler.getParentObject()
		String titleAttr = WebUI.getAttribute(toggler, 'title').trim()
		if(!titleAttr.equalsIgnoreCase('Close')) {
			WebUI.click(toggler)
			if(parent != null) {
				waitForFrameToLoad(parent)
			}
			else {
				WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
			}
		}
		WebUI.delay(3)
	}

	@Keyword
	def closeThumbnail(TestObject toggler) {
		TestObject parent = toggler.getParentObject()
		String titleAttr = WebUI.getAttribute(toggler, 'title').trim()
		if(titleAttr.equalsIgnoreCase('Close')) {
			WebUI.click(toggler)
			if(parent != null) {
				waitForFrameToLoad(parent)
			}
			else {
				WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
			}
		}
		WebUI.delay(3)
	}

	@Keyword
	def verifyElementsCount(TestObject to, int expCount) {

		List<WebElement> elements = WebUtil.getWebElements(to)
		WebUI.switchToDefaultContent()
		WebUI.verifyEqual(elements.size(), expCount)

	}

	@Keyword
	def createBulkDocuments_ClosureAction(int requiredDocsCount){

		'Click on My Work link from left menu'
		WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
		WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
		waitForFrameToLoad(findTestObject('Page_nGage_Dashboard/My_Work/iframe_iframe_105'))

		int recordCount = 0

		if(new MenuBar().isSubMenuPresent('MY_WORK', 'Activity A', 'Processes', 'Closure Action')) {
			recordCount = new MenuBar().getRecordCountInActivity('MY_WORK', 'Processes', 'Closure Action', 'Activity A')
		}

		if(recordCount < requiredDocsCount) {
			int extraDocsRequired = requiredDocsCount-recordCount
			for(int i = 1; i <= extraDocsRequired; i++) {
				new Data().create(DocClass.CLOSURE_ACTION, DocType.CLOSURE_ACTION, P1_WMI_DOC341)
			}
		}
		WebUI.refresh()
		WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
		WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
	}


	@Keyword
	def createBulkDocuments_VerticalMenuWizard(int requiredDocsCount){

		'Click on My Work link from left menu'
		WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
		WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
		waitForFrameToLoad(findTestObject('Page_nGage_Dashboard/My_Work/iframe_iframe_105'))

		int recordCount = 0

		if(new MenuBar().isSubMenuPresent('MY_WORK', 'Loan Application', 'Processes', 'Loan Interactive')) {
			recordCount = new MenuBar().getRecordCountInActivity('MY_WORK', 'Processes', 'Loan Interactive', 'Loan Application')
		}

		if(recordCount < requiredDocsCount) {
			int extraDocsRequired = requiredDocsCount-recordCount
			for(int i = 1; i <= extraDocsRequired; i++) {
				new Data().create(DocClass.VERTICAL_MENU_WIZARD, DocType.SHOW_VERTICAL_MENU_TRUE, P1_MW_DOC081)
			}
		}
		WebUI.refresh()
		WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
		WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
	}

	@Keyword
	def createBulkDocuments_RenderAllFields(int requiredDocsCount) {

		'Expand Repository Menu'
		WebUI.click(findTestObject('Page_nGage_Dashboard/Repository/h3_Repository Menu'))
		waitForFrameToLoad(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

		int recordCount = 0

		if(new MenuBar().isSubMenuPresent('REPO', 'Render All Field Types', 'Business Model', 'Business Model')) {
			recordCount = new MenuBar().getRecordCountInActivity('REPO', 'Business Model', 'Business Model', 'Render All Field Types')
		}

		if(recordCount < requiredDocsCount) {
			int extraDocsRequired = requiredDocsCount-recordCount
			for(int i = 1; i <= extraDocsRequired; i++) {
				new Data().create(DocClass.MASTER_OBJECT_FEATURE, DocType.RENDER_ALL_FIELD_TYPES, P1_REPO_DOC221)
			}
		}
		WebUI.refresh()
		WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
		WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
	}

	@Keyword
	def createBulkDocuments_WMIMenuBovVertical(int requiredDocsCount) {

		'Expand Repository Menu'
		WebUI.click(findTestObject('Page_nGage_Dashboard/Repository/h3_Repository Menu'))
		waitForFrameToLoad(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

		int recordCount = 0

		if(new MenuBar().isSubMenuPresent('REPO', 'WMI Menu BOV Vertical', 'WMI Menu', 'WMI Menu')) {
			recordCount = new MenuBar().getRecordCountInActivity('REPO', 'WMI Menu', 'WMI Menu', 'WMI Menu BOV Vertical')
		}

		if(recordCount < requiredDocsCount) {
			int extraDocsRequired = requiredDocsCount-recordCount
			for(int i = 1; i <= extraDocsRequired; i++) {
				new Data().create(DocClass.WMI_MENU, DocType.WMI_MENU_BOV_VERTICAL, P1_WMI_DOC062)
			}
		}
		WebUI.refresh()
		WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
		WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
	}

	@Keyword
	def createBulkDocuments_Correpondence(int requiredDocsCount) {

		'Click on My Work link from left menu'
		WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
		WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
		waitForFrameToLoad(findTestObject('Page_nGage_Dashboard/My_Work/iframe_iframe_105'))

		int recordCount = 0

		if(new MenuBar().isSubMenuPresent('MY_WORK', 'Correspondence', 'Processes', 'Correspondence Generation')) {
			recordCount = new MenuBar().getRecordCountInActivity('MY_WORK', 'Processes', 'Correspondence Generation', 'Correspondence')
		}

		if(recordCount < requiredDocsCount) {
			int extraDocsRequired = requiredDocsCount-recordCount
			for(int i = 1; i <= extraDocsRequired; i++) {
				new Data().create(DocClass.CORRESPONDENCE, DocType.CORRESPONDENCE, P1_MW_DOC161)
			}
		}
		WebUI.refresh()
		WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
		WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

	}

	@Keyword
	def createBulkDocuments_ReloadOnPostBack(int requiredDocsCount) {

		'Click on My Work link from left menu'
		WebUI.click(findTestObject('Page_nGage_Dashboard/My_Work/a_My Work Left Menu'))
		WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
		waitForFrameToLoad(findTestObject('Page_nGage_Dashboard/My_Work/iframe_iframe_105'))

		int recordCount = 0

		if(new MenuBar().isSubMenuPresent('MY_WORK', 'Activity1', 'Processes', 'ReloadOnPostback')) {
			recordCount = new MenuBar().getRecordCountInActivity('MY_WORK', 'Processes', 'ReloadOnPostback', 'Activity1')
		}

		if(recordCount < requiredDocsCount) {
			int extraDocsRequired = requiredDocsCount-recordCount
			for(int i = 1; i <= extraDocsRequired; i++) {
				new Data().create(DocClass.DO_NOT_RELOAD_ON_POSTBACK, DocType.RELOAD_ON_POSTBACK_NO_SPLIT_T, P1_MW_DOC201)
			}
		}
		WebUI.refresh()
		WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
		WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
	}

	@Keyword
	def verifyElementHasFocus(TestObject toLocator) {
		WebUtil.delay(500)
		WebElement element = WebUtil.getWebElement(toLocator)
		WebDriver driver = DriverFactory.getWebDriver()
		if(!element.equals(driver.switchTo().activeElement())) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop('Provided element does not have focus')
		}
		WebUI.switchToDefaultContent()
	}

	@Keyword
	def verifyElementNotHasFocus(TestObject toLocator) {
		WebElement element = WebUtil.getWebElement(toLocator)
		WebDriver driver = DriverFactory.getWebDriver()
		if(element.equals(driver.switchTo().activeElement())) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop('Provided element  has focus')
		}
		WebUI.switchToDefaultContent()
	}

	@Keyword
	def createBulkDocuments_RenderAsLabel(int requiredDocsCount) {

		'Expand Repository Menu'
		WebUI.click(findTestObject('Page_nGage_Dashboard/Repository/h3_Repository Menu'))
		waitForFrameToLoad(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

		int recordCount = 0

		if(new MenuBar().isSubMenuPresent('REPO', 'Render As Label', 'Business Model', 'Business Model')) {
			recordCount = new MenuBar().getRecordCountInActivity('REPO', 'Business Model', 'Business Model', 'Render As Label')
		}

		if(recordCount < requiredDocsCount) {
			int extraDocsRequired = requiredDocsCount-recordCount
			for(int i = 1; i <= extraDocsRequired; i++) {
				new Data().create(DocClass.MASTER_OBJECT_FEATURE, DocType.RENDER_AS_LABEL, null)
			}
		}

		WebUI.refresh()
		WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
		WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
	}

	@Keyword
	def createBulkDocuments_ReferenceObjectInlineContentView(int requiredDocsCount) {

		'Expand Repository Menu'
		WebUI.click(findTestObject('Page_nGage_Dashboard/Repository/h3_Repository Menu'))
		waitForFrameToLoad(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

		int recordCount = 0

		if(new MenuBar().isSubMenuPresent('REPO', 'Reference Object InlineContentView', 'Business Model', 'Business Model')) {
			recordCount = new MenuBar().getRecordCountInActivity('REPO', 'Business Model', 'Business Model', 'Reference Object InlineContentView')
		}

		if(recordCount < requiredDocsCount) {
			int extraDocsRequired = requiredDocsCount-recordCount
			for(int i = 1; i <= extraDocsRequired; i++) {
				new Data().create(DocClass.REFERENCE_OBJECT_FEATURE, DocType.REFERENCE_OBJECT_INLINE_CONTENT_VIEW, null)
			}
		}

		WebUI.refresh()
		WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
		WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
	}

	@Keyword
	def createDocument_ForSingleResultView() {

		'Expand Repository Menu'
		WebUI.click(findTestObject('Page_nGage_Dashboard/Repository/h3_Repository Menu'))
		waitForFrameToLoad(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))
		WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

		'Select Repository - Advance Search tab'
		WebUI.selectOptionByLabel(findTestObject('Page_nGage_Dashboard/Repository/select_Repository Drop Down'), 'Business Model', false)
		waitForFrameToLoad(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

		'Selinput_btnSearchect Search For - Advance Search tab'
		WebUI.selectOptionByLabel(findTestObject('Page_nGage_Dashboard/Repository/select_Search For Drop Down'), 'TopOneRowSC', false)
		waitForFrameToLoad(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

		'Click on Search button'
		WebUI.click(findTestObject('Page_nGage_Dashboard/Repository/input_btnSearch'))
		waitForFrameToLoad(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))

		'Verify table contains atleast 1 record'
		int rowCount = new Table().getRowsCount(findTestObject('Page_nGage_Dashboard/Repository/table_SearchResults'))
		if(rowCount <= 0) {
			new Data().create(DocClass.MASTER_OBJECT_FEATURE, DocType.RENDER_ALL_FIELD_TYPES, P1_REPO_DOC221)
		}

		WebUI.refresh()
		WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
		WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
	}

	@Keyword
	def waitUntilDropDownHasOption(TestObject to, int timeout) {

		def startTime = System.currentTimeMillis()
		def endTime = startTime + TimeUnit.SECONDS.toMillis(timeout)
		def currentTime = System.currentTimeMillis()
		boolean isLoaded = false

		while(currentTime < endTime) {
			try {
				WebElement dropDown = WebUtil.getWebElement(to)
				Select selElement = new Select(dropDown)
				List<WebElement> allOptions = selElement.getOptions()
				if(allOptions.size() > 0) {
					isLoaded = true
					break
				}
				else {
					WebUI.switchToDefaultContent()
					WebUI.delay(1)
					currentTime = System.currentTimeMillis()
				}
			}
			catch(Exception e) {
				WebUI.switchToDefaultContent()
				WebUI.delay(1)
				currentTime = System.currentTimeMillis()
			}
		}

		WebUI.switchToDefaultContent()
		if(isLoaded) {
			KeywordUtil.markPassed("Drop down is loaded and it has one option")
		}
		else {
			KeywordUtil.markFailedAndStop("Drop down is not loaded in time "+timeout)
		}
	}

	@Keyword
	def selectRepositoryAndSearchFor(String repository, String searchFor) {

		'Wait for drop downs to be visible'
		WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/Repository/select_Repository Drop Down'), GlobalVariable.G_LongTimeout)

		'Select Repository - Advance Search tab'
		WebUI.selectOptionByLabel(findTestObject('Page_nGage_Dashboard/Repository/select_Repository Drop Down'), repository, false)
		waitForFrameToLoad(findTestObject('Page_nGage_Dashboard/Repository/iframe_ADVMAINTAB_iframe'))
		waitUntilDropDownHasOption(findTestObject('Page_nGage_Dashboard/Repository/select_Search For Drop Down'), GlobalVariable.G_LongTimeout)

		'Select Search For - Advance Search tab'
		WebUI.selectOptionByLabel(findTestObject('Page_nGage_Dashboard/Repository/select_Search For Drop Down'), searchFor, false)
		WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/Repository/filtersTable'), GlobalVariable.G_LongTimeout)
	}

	@Keyword
	def waitUntilDropDownHasOption(TestObject to, String option, int timeout) {

		def startTime = System.currentTimeMillis()
		def endTime = startTime + TimeUnit.SECONDS.toMillis(timeout)
		def currentTime = System.currentTimeMillis()

		boolean isFound = false

		while(currentTime < endTime) {
			try {
				WebElement element = WebUtil.getWebElement(to)
				Select select = new Select(element)
				List<WebElement> options = select.getOptions()
				for (opt in options) {
					if(opt.getText().trim().equalsIgnoreCase(option.trim())) {
						isFound = true
						break
					}
				}

				if(isFound) {
					break
				}
				WebUI.switchToDefaultContent()
				WebUI.delay(1)
				currentTime = System.currentTimeMillis()

			}
			catch(Exception e) {

				WebUI.switchToDefaultContent()
				WebUI.delay(1)
				currentTime = System.currentTimeMillis()
			}
		}

		WebUI.switchToDefaultContent()
		if(isFound) {
			KeywordUtil.markPassed('Drop down has option present')
		}
		else {
			KeywordUtil.markFailedAndStop('Drop down does not have provided option in given time '+GlobalVariable.G_LongTimeout)
		}
	}

	@Keyword
	def createDateFilterDataRepository() {
		if(!FLAG_P1_REPO_DOC241) {
			new Data().create(DocClass.DATE_DATETIME_DC, DocType.DATE_DATETIME_DT, P1_REPO_DOC241)
			FLAG_P1_REPO_DOC241 = true
		}
		if(!FLAG_P1_REPO_DOC242) {
			new Data().create(DocClass.DATE_DATETIME_DC, DocType.DATE_DATETIME_DT, P1_REPO_DOC242)
			FLAG_P1_REPO_DOC242 = true
		}
		if(!FLAG_P1_REPO_DOC243) {
			new Data().create(DocClass.DATE_DATETIME_DC, DocType.DATE_DATETIME_DT, P1_REPO_DOC243)
			FLAG_P1_REPO_DOC243 = true
		}
		if(!FLAG_P1_REPO_DOC244) {
			new Data().create(DocClass.DATE_DATETIME_DC, DocType.DATE_DATETIME_DT, P1_REPO_DOC244)
			FLAG_P1_REPO_DOC244 = true
		}
		if(!FLAG_P1_REPO_DOC245) {
			new Data().create(DocClass.DATE_DATETIME_DC, DocType.DATE_DATETIME_DT, P1_REPO_DOC245)
			FLAG_P1_REPO_DOC245 = true
		}
		if(!FLAG_P1_REPO_DOC246) {
			new Data().create(DocClass.DATE_DATETIME_DC, DocType.DATE_DATETIME_DT, P1_REPO_DOC246)
			FLAG_P1_REPO_DOC246 = true
		}
	}

	@Keyword
	def createFolderingDataMyWork() {

		if(!FLAG_P1_MW_DOC082) {
			new Data().create(DocClass.VERTICAL_MENU_WIZARD, DocType.SHOW_VERTICAL_MENU_TRUE, P1_MW_DOC082)
			FLAG_P1_MW_DOC082 = true
		}

		if(!FLAG_P1_MW_DOC083) {
			new Data().create(DocClass.VERTICAL_MENU_WIZARD, DocType.SHOW_VERTICAL_MENU_TRUE, P1_MW_DOC083)
			FLAG_P1_MW_DOC083 = true
		}

		if(!FLAG_P1_MW_DOC081) {
			new Data().create(DocClass.VERTICAL_MENU_WIZARD, DocType.SHOW_VERTICAL_MENU_TRUE, P1_MW_DOC081)
			FLAG_P1_MW_DOC081 = true
		}
	}

	@Keyword
	def createDateFilterDataMyWork() {

		if(!FLAG_P1_MW_DOC261) {
			new Data().create(DocClass.DATE_REQUIRED, DocType.DATE_REQUIRED, P1_MW_DOC261)
			FLAG_P1_MW_DOC261 = true
		}
		if(!FLAG_P1_MW_DOC262) {
			new Data().create(DocClass.DATE_REQUIRED, DocType.DATE_REQUIRED, P1_MW_DOC262)
			FLAG_P1_MW_DOC262 = true
		}
		if(!FLAG_P1_MW_DOC263) {
			new Data().create(DocClass.DATE_REQUIRED, DocType.DATE_REQUIRED, P1_MW_DOC263)
			FLAG_P1_MW_DOC263 = true
		}
		if(!FLAG_P1_MW_DOC264) {
			new Data().create(DocClass.DATE_REQUIRED, DocType.DATE_REQUIRED, P1_MW_DOC264)
			FLAG_P1_MW_DOC264 = true
		}
		if(!FLAG_P1_MW_DOC265) {
			new Data().create(DocClass.DATE_REQUIRED, DocType.DATE_REQUIRED, P1_MW_DOC265)
			FLAG_P1_MW_DOC265 = true
		}
	}

	@Keyword
	def createDateRangeFilterDataMyWork() {

		if(!FLAG_P1_MW_DOC281) {
			new Data().create(DocClass.DATE_RANGE_REQUIRED, DocType.DATE_RANGE_REQUIRED, P1_MW_DOC281)
			FLAG_P1_MW_DOC281 = true
		}
		if(!FLAG_P1_MW_DOC282) {
			new Data().create(DocClass.DATE_RANGE_REQUIRED, DocType.DATE_RANGE_REQUIRED, P1_MW_DOC282)
			FLAG_P1_MW_DOC282 = true
		}
		if(!FLAG_P1_MW_DOC283) {
			new Data().create(DocClass.DATE_RANGE_REQUIRED, DocType.DATE_RANGE_REQUIRED, P1_MW_DOC283)
			FLAG_P1_MW_DOC283 = true
		}
		if(!FLAG_P1_MW_DOC284) {
			new Data().create(DocClass.DATE_RANGE_REQUIRED, DocType.DATE_RANGE_REQUIRED, P1_MW_DOC284)
			FLAG_P1_MW_DOC284 = true
		}
		if(!FLAG_P1_MW_DOC285) {
			new Data().create(DocClass.DATE_RANGE_REQUIRED, DocType.DATE_RANGE_REQUIRED, P1_MW_DOC285)
			FLAG_P1_MW_DOC285 = true
		}
		if(!FLAG_P1_MW_DOC286) {
			new Data().create(DocClass.DATE_RANGE_REQUIRED, DocType.DATE_RANGE_REQUIRED, P1_MW_DOC286)
			FLAG_P1_MW_DOC286 = true
		}
	}

	@Keyword
	def createDateTimeFilterDataMyWork() {

		if(!FLAG_P1_MW_DOC301) {
			new Data().create(DocClass.DATETIME_REQUIRED, DocType.DATETIME_REQUIRED, P1_MW_DOC301)
			FLAG_P1_MW_DOC301 = true
		}
		if(!FLAG_P1_MW_DOC302) {
			new Data().create(DocClass.DATETIME_REQUIRED, DocType.DATETIME_REQUIRED, P1_MW_DOC302)
			FLAG_P1_MW_DOC302 = true
		}
		if(!FLAG_P1_MW_DOC303) {
			new Data().create(DocClass.DATETIME_REQUIRED, DocType.DATETIME_REQUIRED, P1_MW_DOC303)
			FLAG_P1_MW_DOC303 = true
		}
		if(!FLAG_P1_MW_DOC304) {
			new Data().create(DocClass.DATETIME_REQUIRED, DocType.DATETIME_REQUIRED, P1_MW_DOC304)
			FLAG_P1_MW_DOC304 = true
		}
		if(!FLAG_P1_MW_DOC305) {
			new Data().create(DocClass.DATETIME_REQUIRED, DocType.DATETIME_REQUIRED, P1_MW_DOC305)
			FLAG_P1_MW_DOC305 = true
		}
	}

	@Keyword
	def createDateTimeRangeFilterDataMyWork() {

		if(!FLAG_P1_MW_DOC321) {
			new Data().create(DocClass.DATETIME_RANGE_REQUIRED, DocType.DATETIME_RANGE_REQUIRED, P1_MW_DOC321)
			FLAG_P1_MW_DOC321 = true
		}
		if(!FLAG_P1_MW_DOC322) {
			new Data().create(DocClass.DATETIME_RANGE_REQUIRED, DocType.DATETIME_RANGE_REQUIRED, P1_MW_DOC322)
			FLAG_P1_MW_DOC322 = true
		}
		if(!FLAG_P1_MW_DOC323) {
			new Data().create(DocClass.DATETIME_RANGE_REQUIRED, DocType.DATETIME_RANGE_REQUIRED, P1_MW_DOC323)
			FLAG_P1_MW_DOC323 = true
		}
		if(!FLAG_P1_MW_DOC324) {
			new Data().create(DocClass.DATETIME_RANGE_REQUIRED, DocType.DATETIME_RANGE_REQUIRED, P1_MW_DOC324)
			FLAG_P1_MW_DOC324 = true
		}
		if(!FLAG_P1_MW_DOC325) {
			new Data().create(DocClass.DATETIME_RANGE_REQUIRED, DocType.DATETIME_RANGE_REQUIRED, P1_MW_DOC325)
			FLAG_P1_MW_DOC325 = true
		}
		if(!FLAG_P1_MW_DOC326) {
			new Data().create(DocClass.DATETIME_RANGE_REQUIRED, DocType.DATETIME_RANGE_REQUIRED, P1_MW_DOC326)
			FLAG_P1_MW_DOC326 = true
		}
	}

	@Keyword
	def isRecordPresentInRecentGridTable(int rowNo, String columnName, String expText) {

		try {
			WebUI.click(findTestObject('Page_nGage_Dashboard/Home/Home Menu'))
			WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

			WebUI.click(findTestObject('Page_nGage_Dashboard/Home/a_Recent Documents'))
			waitForFrameToLoad(findTestObject('Page_nGage_Dashboard/iframe_iframe_103'))

			//Validate atleast 1 record is present in the grid.
			WebUI.verifyElementPresent(findTestObject('Page_nGage_Dashboard/Home/tableRow_recentDocuments_firstRow'), GlobalVariable.G_LongTimeout);

			int colNo = new Table().getColumnNumber(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'), columnName)

			//Sort Record in grid by DocID Descending
			new Table().clickColumnHeader(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'), 'Doc ID')
			new Table().clickColumnHeader(findTestObject('Page_nGage_Dashboard/Home/tableHeader_RecentDocuments'), 'Doc ID')

			return new Table().isRecordPresentInTable(findTestObject('Page_nGage_Dashboard/Home/table_MyDocumentResults'), rowNo, colNo, expText)
		}
		catch(Exception e) {
			return false
		}
	}

	@Keyword
	def waitForImageRender(TestObject to) {

		WebElement image
		List<WebElement> list
		boolean isLoaded = false
		def startTime = System.currentTimeMillis()
		def endTime = startTime + TimeUnit.SECONDS.toMillis(GlobalVariable.G_LongTimeout)
		def currentTime = System.currentTimeMillis()
		int i = 0

		while(currentTime < endTime) {

			println "Inside loop "+i
			image = WebUtil.getWebElement(to)
			list = new ArrayList<WebElement>()
			list.add(image)

			isLoaded = (Boolean)WebUI.executeJavaScript('return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0', list)
			WebUI.switchToDefaultContent()

			if(isLoaded) {
				break
			}
			else {
				WebUtil.delay(500)
				currentTime = System.currentTimeMillis()
			}
			i++

		}

		if(isLoaded) {
			KeywordUtil.markPassed('Wait complete')
		}
		else {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop('Image not rendered within 120 sec')
		}

		WebUI.switchToDefaultContent()
	}

	@Keyword
	def verifyMatch(String actualText, String expectedText, boolean isRegex) {

		try {
			WebUI.verifyMatch(actualText, expectedText, isRegex)
		}
		catch(Exception e) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop(e.toString())
		}
	}

	@Keyword
	def verifyElementMaskedProperty(TestObject to, boolean isMasked, String expMask) {

		String jScriptMasked = 'return arguments[0].MaskedEditBehavior != undefined && arguments[0].MaskedEditBehavior._EmptyMask == "'+expMask+'"'
		String jScriptNoMasked = 'return arguments[0].MaskedEditBehavior == undefined'
		boolean isMatching = false

		WebElement e = WebUtil.getWebElement(to)
		List<WebElement> list = new ArrayList<WebElement>()
		list.add(e)


		if(isMasked) {
			isMatching = (Boolean)WebUI.executeJavaScript(jScriptMasked, list)
		}
		else {
			isMatching = (Boolean)WebUI.executeJavaScript(jScriptNoMasked, list)
		}
		WebUI.verifyEqual(isMatching, true)
		WebUI.switchToDefaultContent()
	}
}