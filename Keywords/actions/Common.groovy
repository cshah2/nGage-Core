package actions

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Robot
import java.awt.Toolkit
import java.awt.event.KeyEvent

import java.text.SimpleDateFormat
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
				login(GlobalVariable.Username, GlobalVariable.Password, GlobalVariable.Database)
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

	@Keyword
	def login(String username, String password, String database) {
		WebUI.openBrowser('')
		//		if(DriverFactory.getExecutedBrowser().getName() != 'EDGE_DRIVER') {
		//			WebUI.maximizeWindow()
		//		}
		WebUI.maximizeWindow()
		WebUI.deleteAllCookies()
		WebUI.navigateToUrl(WebUI.concatenate(GlobalVariable.BaseURL, '/login.aspx'));
		WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
		WebUI.waitForElementVisible(findTestObject('Page_Login/input_UserName'), GlobalVariable.G_LongTimeout)
		WebUI.setText(findTestObject('Page_Login/input_UserName'), username)
		WebUI.setText(findTestObject('Page_Login/input_Password'), password)
		//WebUI.selectOptionByValue(findTestObject('Page_Login/select_Schema'), database, true)
		WebUI.selectOptionByLabel(findTestObject('Page_Login/select_Schema'), GlobalVariable.Database, false)
		WebUI.click(findTestObject('Page_Login/button_Login'))
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

	@Keyword
	def verifyDateFormat(String inputDate,String inputDateFormat)
	{
		//		Date date=dateFormat.parse(inputDate)
		//
		//		//int dd=12, mm=12, yy=2012;
		//		int dd=date.getDate()
		//		int mm=date.getMonth()
		//		int yy=date.getYear()
		//
		//		String output="";
		//		// check year
		//		if (yy >= 1900 && yy <= 9999) {
		//			// check month
		//			if (mm >= 1 && mm <= 12) {
		//				// check days
		//				if ((dd >= 1 && dd <= 31) && (mm == 1 || mm == 3 || mm == 5 || mm == 7 ||
		//				mm == 8 || mm == 10 || mm == 12))
		//					output+="Date is valid.\n";  //printf("Date is valid.\n");
		//				else if ((dd >= 1 && dd <= 30) &&
		//				(mm == 4 || mm == 6 || mm == 9 || mm == 11))
		//					output+="Date is valid.\n";
		//				else if ((dd >= 1 && dd <= 28) && (mm == 2))
		//					output+="Date is valid.\n";
		//				else if (dd == 29 && mm == 2 &&
		//				(yy % 400 == 0 || (yy % 4 == 0 && yy % 100 != 0)))
		//					output+="Date is valid.\n";
		//				else
		//					output+="Date is invalid.\n";
		//			} else {
		//				output+="Month is not valid\n";
		//			}
		//		} else {
		//			output+="Year is not valid\n";
		//		}
		//		System.out.println(output);
		try {
			SimpleDateFormat dateFormat=new SimpleDateFormat(inputDateFormat)
			dateFormat.parse(inputDate)
			KeywordUtil.markPassed("string is in given date  format")
		} catch (Exception e) {
			e.printStackTrace()
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
}