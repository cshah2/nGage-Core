package actions

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.awt.Robot
import java.awt.Toolkit
import java.awt.event.KeyEvent
import java.util.concurrent.TimeUnit

import org.openqa.selenium.Dimension
import org.openqa.selenium.Keys
import org.openqa.selenium.Point
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.ui.Select

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.configuration.RunConfiguration
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
		//		if(DriverFactory.getExecutedBrowser().getName() != 'EDGE_DRIVER') {
		//			WebUI.maximizeWindow()
		//		}
		WebUI.maximizeWindow()
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
	def createDocument_WMIMenuBovVertical() {

		WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))
		selectDocClassAndDocTypeForGlobalNew('WMI Menu', 'WMI Menu BOV Vertical')
		WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

		WebUI.switchToWindowTitle('(Doc ID: NEW )')
		WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

		String filePath = RunConfiguration.getProjectDir().replace('/', '\\')+'\\Data Files\\FileUploads\\50 Pages PDF file.pdf'
		WebUI.setText(findTestObject('Page_WMI_NEW/WMI_Menu_BOV_Vertical/input_String field'), 'New Document with Attachement')
		WebUI.uploadFile(findTestObject('Page_WMI_NEW/WMI_Menu_BOV_Vertical/input__file_upload'), filePath)

		WebUI.mouseOver(findTestObject('Page_WMI_NEW/WMI_Menu_BOV_Vertical/menu_Standard Actions'))
		WebUI.waitForElementVisible(findTestObject('Page_WMI_NEW/WMI_Menu_BOV_Vertical/button_Save'), GlobalVariable.G_LongTimeout)
		new Window().clickElementAndWaitForWindowClose(findTestObject('Page_WMI_NEW/WMI_Menu_BOV_Vertical/button_Save'), GlobalVariable.G_LongTimeout)

		WebUI.switchToWindowTitle('Savana nGage')
		WebUI.click(findTestObject('Page_nGage_Dashboard/Home/span_ui-button-icon-primary ui'))
	}

	@Keyword
	def openDocumentFromRecentGrid(String documentTitle) {
		WebUI.click(findTestObject('Page_nGage_Dashboard/Home/a_Recent Documents'))
		waitForFrameToLoad(findTestObject('Page_nGage_Dashboard/iframe_iframe_103'))

		//Validate atleast 1 record is present in the grid.
		WebUI.verifyElementPresent(findTestObject('Page_nGage_Dashboard/Home/tableRow_recentDocuments_firstRow'), GlobalVariable.G_LongTimeout);

		//Sort Record in grid by DocID Descending
		new Table().clickColumnHeader(findTestObject('Page_nGage_Dashboard/Home/div_Doc ID'))
		new Table().clickColumnHeader(findTestObject('Page_nGage_Dashboard/Home/div_Doc ID'))

		WebUI.click(findTestObject('Page_nGage_Dashboard/Home/column_RecentDocuments LastAction'))
		WebUI.switchToWindowTitle(documentTitle)
		WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
		waitForFrameToLoad(findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/iframe_westContainerFrame'))

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

		boolean isException = false
		TestObject firstElement = elements.get(0)
		TestObject parentElement = firstElement.getParentObject()
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
			KeywordUtil.markFailedAndStop("attribute: "+actualValue +" contains "+expValue)
		}
	}
	
	@Keyword
	def createDocument_WMIMenuBov() {

		'Create a new BovDocTwoRow Document'
		WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))
		selectDocClassAndDocTypeForGlobalNew('WMI Menu', 'WMI Menu BOV')
		WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

		'Switch to new Window'
		WebUI.switchToWindowTitle('(Doc ID: NEW )')
		WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

		'Fill the details required'
		String filePath = RunConfiguration.getProjectDir().replace('/', '\\')+'\\Data Files\\FileUploads\\50 Pages PDF file.pdf'
		WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_WMI_NEW/WMI_Menu_BOV/selectCustomerId'), '200',false)
		WebUI.sendKeys(findTestObject('Object Repository/Page_WMI_NEW/WMI_Menu_BOV/inputBMString'), 'Test1')
		WebUI.sendKeys(findTestObject('Object Repository/Page_WMI_NEW/WMI_Menu_BOV/inputCustomerName'), 'Roshan')
		WebUI.uploadFile(findTestObject('Object Repository/Page_WMI_NEW/WMI_Menu_BOV/inputUpload'), filePath)

		'Save details and close'
		WebUI.mouseOver(findTestObject('Object Repository/Page_WMI_NEW/WMI_Menu_BOV/buttonStandardActions'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Page_WMI_NEW/WMI_Menu_BOV/buttonSave'), GlobalVariable.G_LongTimeout)
		new Window().clickElementAndWaitForWindowClose(findTestObject('Object Repository/Page_WMI_NEW/WMI_Menu_BOV/buttonSave'),GlobalVariable.G_LongTimeout)

		'Switch to main window and close'
		WebUI.switchToWindowTitle('Savana nGage')
		WebUI.click(findTestObject('Page_nGage_Dashboard/Home/span_ui-button-icon-primary ui'))
	}

	@Keyword
	def createDocument_WMIMenuBovDefault() {

		'Create a new BovDefault Document'
		WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))
		selectDocClassAndDocTypeForGlobalNew('WMI Menu', 'WMI Menu Default')
		WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

		'Switch to new Window'
		WebUI.switchToWindowTitle('(Doc ID: NEW )')
		WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

		'Fill the details required'
		String filePath = RunConfiguration.getProjectDir().replace('/', '\\')+'\\Data Files\\FileUploads\\50 Pages PDF file.pdf'
		WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_WMI_NEW/WMI_Menu_BOV_Default/customerID'), '200',false)
		WebUI.sendKeys(findTestObject('Object Repository/Page_WMI_NEW/WMI_Menu_BOV_Default/BMString'), 'Test1')
		WebUI.sendKeys(findTestObject('Object Repository/Page_WMI_NEW/WMI_Menu_BOV_Default/customerName'), 'Roshan')
		WebUI.uploadFile(findTestObject('Object Repository/Page_WMI_NEW/WMI_Menu_BOV_Default/chooseFile'), filePath)

		'Save details and close'
		WebUI.mouseOver(findTestObject('Object Repository/Page_WMI_NEW/WMI_Menu_BOV_Default/standardActionsUIButton'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Page_WMI_NEW/WMI_Menu_BOV_Default/Save'), GlobalVariable.G_LongTimeout)
		new Window().clickElementAndWaitForWindowClose(findTestObject('Object Repository/Page_WMI_NEW/WMI_Menu_BOV_Default/Save'),GlobalVariable.G_LongTimeout)

		'Switch to main window and close'
		WebUI.switchToWindowTitle('Savana nGage')
		WebUI.click(findTestObject('Page_nGage_Dashboard/Home/span_ui-button-icon-primary ui'))
	}

	@Keyword
	def createDocument_WMIMenuBovDocTwoRow() {

		'Create a new BovDocTwoRow Document'
		WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))
		selectDocClassAndDocTypeForGlobalNew('WMI Menu', 'WMI Menu DocTwoRow')
		WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

		'Switch to new Window'
		WebUI.switchToWindowTitle('(Doc ID: NEW )')
		WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

		'Fill the details required'
		String filePath = RunConfiguration.getProjectDir().replace('/', '\\')+'\\Data Files\\FileUploads\\50 Pages PDF file.pdf'
		WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_WMI_NEW/WMI_Menu_BOV_DocTwoRow/customerId'), '200',false)
		WebUI.sendKeys(findTestObject('Object Repository/Page_WMI_NEW/WMI_Menu_BOV_DocTwoRow/BMString'), 'Test1')
		WebUI.sendKeys(findTestObject('Object Repository/Page_WMI_NEW/WMI_Menu_BOV_DocTwoRow/customerName'), 'Roshan')
		WebUI.uploadFile(findTestObject('Object Repository/Page_WMI_NEW/WMI_Menu_BOV_DocTwoRow/chooseFile'), filePath)

		'Save details and close'
		WebUI.mouseOver(findTestObject('Object Repository/Page_WMI_NEW/WMI_Menu_BOV_DocTwoRow/dropdownStandardActions'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Page_WMI_NEW/WMI_Menu_BOV_DocTwoRow/Save'), GlobalVariable.G_LongTimeout)
		new Window().clickElementAndWaitForWindowClose(findTestObject('Object Repository/Page_WMI_NEW/WMI_Menu_BOV_DocTwoRow/Save'),GlobalVariable.G_LongTimeout)

		'Switch to main window and close'
		WebUI.switchToWindowTitle('Savana nGage')
		WebUI.click(findTestObject('Page_nGage_Dashboard/Home/span_ui-button-icon-primary ui'))
	}

}
