package actions

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.awt.Toolkit
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit

import org.apache.commons.lang3.StringUtils
import org.apache.commons.lang3.math.NumberUtils
import org.openqa.selenium.By
import org.openqa.selenium.Dimension
import org.openqa.selenium.Keys
import org.openqa.selenium.Point
import org.openqa.selenium.StaleElementReferenceException
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.FluentWait
import org.openqa.selenium.support.ui.Select

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.exception.StepFailedException
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

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
			DriverFactory.getWebDriver()
		}
		catch(Exception e) {
			WebUtil.openBrowser()
		}

		WebUI.maximizeWindow()
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
	def createDocument_WMIMenuBov() {

		'Switch to main window'
		WebUI.switchToWindowTitle('Savana nGage')

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

		'Switch to main window'
		WebUI.switchToWindowTitle('Savana nGage')

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

		'Switch to main window'
		WebUI.switchToWindowTitle('Savana nGage')

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
	def createDocument_DateTimeDT(String BM_Date, String DateRange, String BM_DateTime, String DateTimeRange) {

		'Switch to main window'
		WebUI.switchToWindowTitle('Savana nGage')

		'Create a new BovDocTwoRow Document'
		WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))
		selectDocClassAndDocTypeForGlobalNew('Date Date Time DC', 'Date DateTime DT')
		WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

		'Switch to new Window'
		WebUI.switchToWindowTitle('Business Model WMI')
		WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

		'Fill the details required'
		setText_Date(findTestObject('Page_WMI_NEW/Date Date Time DT/input_BM Date'), BM_Date)
		setText_Date(findTestObject('Page_WMI_NEW/Date Date Time DT/input_Date range'), DateRange)
		setText_Date(findTestObject('Page_WMI_NEW/Date Date Time DT/input_BM DateTime'), BM_DateTime)
		setText_Date(findTestObject('Page_WMI_NEW/Date Date Time DT/input_Date time range'), DateTimeRange)

		'Save details and close'
		WebUI.click(findTestObject('Page_WMI_NEW/Date Date Time DT/span_Save'))

		WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
		waitForFrameToLoad(findTestObject('Page_WMI/Date Date Time DT/iframe_ContentPlaceHolder1'))
		new Window().clickElementAndWaitForWindowClose(findTestObject('Page_WMI/Date Date Time DT/span_Close Window'), GlobalVariable.G_LongTimeout)

		'Switch to main window and close'
		WebUI.switchToWindowTitle('Savana nGage')
		WebUI.click(findTestObject('Page_nGage_Dashboard/Home/span_ui-button-icon-primary ui'))
	}

	@Keyword
	def createDocument_RequiredFieldDT(String BM_Text, String BM_String_Required, String BM_int, String DateTime_Required, String Date_Required) {

		'Switch to main window'
		WebUI.switchToWindowTitle('Savana nGage')

		'Create a new BovDocTwoRow Document'
		WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))
		selectDocClassAndDocTypeForGlobalNew('Required field DC', 'Required field DT')
		WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

		'Switch to new Window'
		WebUI.switchToWindowTitle('(Doc ID: NEW )')
		WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

		'Fill the details required'
		setText_Date(findTestObject('Page_WMI_NEW/Required_Field_DT/input_BM Text'), BM_Text)
		WebUI.setText(findTestObject('Page_WMI_NEW/Required_Field_DT/input_BM String required'), BM_String_Required)
		WebUI.setText(findTestObject('Page_WMI_NEW/Required_Field_DT/input_BM Int'), BM_int)
		setText_Date(findTestObject('Page_WMI_NEW/Required_Field_DT/input_Date Time Required'), DateTime_Required)
		setText_Date(findTestObject('Page_WMI_NEW/Required_Field_DT/input_Date Required'), Date_Required)

		'Save details and close'
		WebUI.mouseOver(findTestObject('Page_WMI_NEW/Required_Field_DT/span_Standard Actions'))
		WebUI.waitForElementVisible(findTestObject('Page_WMI_NEW/Required_Field_DT/a_Save'), GlobalVariable.G_LongTimeout)
		new Window().clickElementAndWaitForWindowClose(findTestObject('Page_WMI_NEW/Required_Field_DT/a_Save'),GlobalVariable.G_LongTimeout)

		'Switch to main window and close'
		WebUI.switchToWindowTitle('Savana nGage')
		WebUI.click(findTestObject('Page_nGage_Dashboard/Home/span_ui-button-icon-primary ui'))
	}

	@Keyword
	def createDocument_MyWorkDateTime(String docClass, String docType, String startDate, String endDate, String startDateTime, String endDateTime, String BM_Text) {

		'Switch to main window'
		WebUI.switchToWindowTitle('Savana nGage')

		'Create a new BovDocTwoRow Document'
		WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))
		selectDocClassAndDocTypeForGlobalNew(docClass, docType)
		WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

		'Switch to new Window'
		WebUI.switchToWindowTitle('Business Model WMI')
		WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

		'Fill the details required'

		setText_Date(findTestObject('Page_WMI_NEW/MyWork_DateTime/input_Start test date'), startDate)
		setText_Date(findTestObject('Page_WMI_NEW/MyWork_DateTime/input_Endtestdate'), endDate)
		setText_Date(findTestObject('Page_WMI_NEW/MyWork_DateTime/input_Start test datetime'), startDateTime)
		setText_Date(findTestObject('Page_WMI_NEW/MyWork_DateTime/input_End test datetime'), endDateTime)
		WebUI.setText(findTestObject('Page_WMI_NEW/MyWork_DateTime/input_BM Text'), BM_Text)

		'Save details and close'
		WebUI.click(findTestObject('Page_WMI_NEW/MyWork_DateTime/span_Save'))
		WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

		waitForFrameToLoad(findTestObject('Page_WMI/MyWork_DateTime/iframe_ContentPlaceHolder'))
		new Window().clickElementAndWaitForWindowClose(findTestObject('Page_WMI/MyWork_DateTime/span_Close Window'), GlobalVariable.G_LongTimeout)

		'Switch to main window and close'
		WebUI.switchToWindowTitle('Savana nGage')
		WebUI.click(findTestObject('Page_nGage_Dashboard/Home/span_ui-button-icon-primary ui'))
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
	def createDocument_MultiPageViewerWithDragAndDrop(String stringField, String fileName, String filePath) {

		'Switch to main window'
		WebUI.switchToWindowTitle('Savana nGage')

		'Create a new BovDocTwoRow Document'
		WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))
		selectDocClassAndDocTypeForGlobalNew('Business Model View', 'MultipageViewer with drag and drop')
		WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

		'Switch to new Window'
		WebUI.switchToWindowTitle('(Doc ID: NEW )')
		WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

		//Set data in fields
		WebUI.setText(findTestObject('Page_WMI_NEW/MultiPage_Viewer_DD/input_eform_mcb67676phBO_3_BOe'), stringField)
		WebUI.setText(findTestObject('Page_WMI_NEW/MultiPage_Viewer_DD/input_eform_mcb67676phBO_3_BOe_1'), fileName)

		//Click on Save button
		WebUI.mouseOver(findTestObject('Page_WMI_NEW/MultiPage_Viewer_DD/span_standard_actions'))
		WebUI.waitForElementVisible(findTestObject('Page_WMI_NEW/MultiPage_Viewer_DD/a_Save'), GlobalVariable.G_LongTimeout)
		new Window().clickElementAndWaitForWindowClose(findTestObject('Page_WMI_NEW/MultiPage_Viewer_DD/a_Save'), GlobalVariable.G_LongTimeout)

		'Switch to main window and close'
		WebUI.switchToWindowTitle('Savana nGage')
		WebUI.click(findTestObject('Page_nGage_Dashboard/Home/span_ui-button-icon-primary ui'))
	}

	@Keyword
	def createDocument_WMIMenuBovVertical(String BM_String, String filePath) {

		'Switch to main window'
		WebUI.switchToWindowTitle('Savana nGage')

		'Create a new BovDocTwoRow Document'
		WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))
		selectDocClassAndDocTypeForGlobalNew('WMI Menu', 'WMI Menu BOV Vertical')
		WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

		'Switch to new Window'
		WebUI.switchToWindowTitle('(Doc ID: NEW )')
		WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

		'Fill the details required'
		WebUI.setText(findTestObject('Page_WMI_NEW/WMI_Menu_BOV_Vertical/input_String field'), BM_String)
		if(StringUtils.isNotBlank(filePath)) {
			WebUI.uploadFile(findTestObject('Page_WMI_NEW/WMI_Menu_BOV_Vertical/input__file_upload'), filePath)
		}

		'Save details and close'
		WebUI.mouseOver(findTestObject('Object Repository/Page_WMI_NEW/WMI_Menu_BOV/buttonStandardActions'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Page_WMI_NEW/WMI_Menu_BOV/buttonSave'), GlobalVariable.G_LongTimeout)
		new Window().clickElementAndWaitForWindowClose(findTestObject('Object Repository/Page_WMI_NEW/WMI_Menu_BOV/buttonSave'),GlobalVariable.G_LongTimeout)

		'Switch to main window and close'
		WebUI.switchToWindowTitle('Savana nGage')
		WebUI.click(findTestObject('Page_nGage_Dashboard/Home/span_ui-button-icon-primary ui'))
	}

	@Keyword
	def createDocument_ClosureAction(String customerName, String customerDetails) {

		'Switch to main window'
		WebUI.switchToWindowTitle('Savana nGage')

		'Create a new BovDocTwoRow Document'
		WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))
		selectDocClassAndDocTypeForGlobalNew('Closure Action', 'Closure Action')
		WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

		'Switch to new Window'
		WebUI.switchToWindowTitle('(Doc ID: NEW )')
		WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

		'Fill the details required'
		WebUI.setText(findTestObject('Page_WMI_NEW/Closure_Action/input_Customer Name'), customerName)
		WebUI.setText(findTestObject('Page_WMI_NEW/Closure_Action/input_Customer Details'), customerDetails)

		'Save details and close'
		WebUI.mouseOver(findTestObject('Page_WMI_NEW/Closure_Action/span_Actions'))
		WebUI.waitForElementVisible(findTestObject('Page_WMI_NEW/Closure_Action/a_Save'), GlobalVariable.G_LongTimeout)
		new Window().clickElementAndWaitForWindowClose(findTestObject('Page_WMI_NEW/Closure_Action/a_Save'),GlobalVariable.G_LongTimeout)

		'Switch to main window and close'
		WebUI.switchToWindowTitle('Savana nGage')
		WebUI.click(findTestObject('Page_nGage_Dashboard/Home/span_ui-button-icon-primary ui'))
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

		//		if(iframe != null) {
		//			WebUI.switchToFrame(iframe, timeout)
		//		} else {
		//			WebUI.switchToFrame(findTestObject('Page_WMI_NEW/iframe_Close Window_ContentPla'), timeout)
		//		}
		//
		//		WebDriver driver = DriverFactory.getWebDriver()
		//		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		//				.withTimeout(timeout, TimeUnit.SECONDS)
		//				.pollingEvery(3, TimeUnit.SECONDS)
		//				.ignoring(StaleElementReferenceException.class)
		//
		//		wait.until(ExpectedConditions.not(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//img[contains(@src,'orange_daisy.g')]/../../../div[contains(@style,'block')]"))))
		//
		//		WebUI.switchToDefaultContent()
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
	def createDocument_VerticalMenuWizard() {

		'Switch to main window'
		WebUI.switchToWindowTitle('Savana nGage')

		'Create a new BovDocTwoRow Document'
		WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))
		selectDocClassAndDocTypeForGlobalNew('Vertical Menu Wizard', 'ShowVerticalMenu-True')
		WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

		'Switch to new Window'
		WebUI.switchToWindowIndex(1)
		WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

		'Fill the details required'
		WebUI.setText(findTestObject('Page_WMI_NEW/VerticalMenuWizard/ShowVerticalMenu_True/input_First Name'), 'Chintan')
		WebUI.setText(findTestObject('Page_WMI_NEW/VerticalMenuWizard/ShowVerticalMenu_True/input_Last Name'), 'Shah')
		WebUI.setText(findTestObject('Page_WMI_NEW/VerticalMenuWizard/ShowVerticalMenu_True/input_Amount'), '50000')

		'Save details and close'
		WebUI.click(findTestObject('Page_WMI_NEW/VerticalMenuWizard/ShowVerticalMenu_True/span_Save'))
		WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
		waitForFrameToLoad(findTestObject('Page_WMI_NEW/VerticalMenuWizard/ShowVerticalMenu_True/iframe_Menus_ContentPlaceHolde'))

		new Window().clickElementAndWaitForWindowClose(findTestObject('Page_WMI_NEW/VerticalMenuWizard/ShowVerticalMenu_True/a_Close Window'), GlobalVariable.G_LongTimeout)

		'Switch to main window and close'
		WebUI.switchToWindowTitle('Savana nGage')
		WebUI.click(findTestObject('Page_nGage_Dashboard/Home/span_ui-button-icon-primary ui'))

	}

	@Keyword
	def createDocument_VerticalMenuWizard(String firstName, String lastName, String amount) {

		'Switch to main window'
		WebUI.switchToWindowTitle('Savana nGage')

		'Create a new BovDocTwoRow Document'
		WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))
		selectDocClassAndDocTypeForGlobalNew('Vertical Menu Wizard', 'ShowVerticalMenu-True')
		WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

		'Switch to new Window'
		WebUI.switchToWindowIndex(1)
		WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

		'Fill the details required'
		WebUI.setText(findTestObject('Page_WMI_NEW/VerticalMenuWizard/ShowVerticalMenu_True/input_First Name'), firstName)
		WebUI.setText(findTestObject('Page_WMI_NEW/VerticalMenuWizard/ShowVerticalMenu_True/input_Last Name'), lastName)
		WebUI.setText(findTestObject('Page_WMI_NEW/VerticalMenuWizard/ShowVerticalMenu_True/input_Amount'), amount)

		'Save details and close'
		WebUI.click(findTestObject('Page_WMI_NEW/VerticalMenuWizard/ShowVerticalMenu_True/span_Save'))
		WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
		waitForFrameToLoad(findTestObject('Page_WMI_NEW/VerticalMenuWizard/ShowVerticalMenu_True/iframe_Menus_ContentPlaceHolde'))

		new Window().clickElementAndWaitForWindowClose(findTestObject('Page_WMI_NEW/VerticalMenuWizard/ShowVerticalMenu_True/a_Close Window'), GlobalVariable.G_LongTimeout)

		'Switch to main window and close'
		WebUI.switchToWindowTitle('Savana nGage')
		WebUI.click(findTestObject('Page_nGage_Dashboard/Home/span_ui-button-icon-primary ui'))

	}

	@Keyword
	def createDocument_VerticalMenuWizard(String firstName, String lastName, String amount, String filePath) {

		'Switch to main window'
		WebUI.switchToWindowTitle('Savana nGage')

		'Create a new BovDocTwoRow Document'
		WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))
		selectDocClassAndDocTypeForGlobalNew('Vertical Menu Wizard', 'ShowVerticalMenu-True')
		WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

		'Switch to new Window'
		WebUI.switchToWindowIndex(1)
		WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

		'Fill the details required'
		WebUI.setText(findTestObject('Page_WMI_NEW/VerticalMenuWizard/ShowVerticalMenu_True/input_First Name'), firstName)
		WebUI.setText(findTestObject('Page_WMI_NEW/VerticalMenuWizard/ShowVerticalMenu_True/input_Last Name'), lastName)
		WebUI.setText(findTestObject('Page_WMI_NEW/VerticalMenuWizard/ShowVerticalMenu_True/input_Amount'), amount)
		if(StringUtils.isNotBlank(filePath)) {
			WebUI.setText(findTestObject('Page_WMI_NEW/VerticalMenuWizard/ShowVerticalMenu_True/input_File Upload'), filePath)
		}

		'Save details and close'
		WebUI.click(findTestObject('Page_WMI_NEW/VerticalMenuWizard/ShowVerticalMenu_True/span_Save'))
		WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
		waitForFrameToLoad(findTestObject('Page_WMI_NEW/VerticalMenuWizard/ShowVerticalMenu_True/iframe_Menus_ContentPlaceHolde'))

		new Window().clickElementAndWaitForWindowClose(findTestObject('Page_WMI_NEW/VerticalMenuWizard/ShowVerticalMenu_True/a_Close Window'), GlobalVariable.G_LongTimeout)

		'Switch to main window and close'
		WebUI.switchToWindowTitle('Savana nGage')
		WebUI.click(findTestObject('Page_nGage_Dashboard/Home/span_ui-button-icon-primary ui'))

	}


	@Keyword
	def createDocument_RouteAdvance(String description) {

		'Switch to main window'
		WebUI.switchToWindowTitle('Savana nGage')

		'Create a new BovDocTwoRow Document'
		WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))
		selectDocClassAndDocTypeForGlobalNew('Route Advance', 'Route from Entry Interactive User')
		WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

		'Switch to new Window'
		WebUI.switchToWindowIndex(1)
		WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

		'Fill the details required'
		WebUI.setText(findTestObject('Page_WMI_NEW/RouteAdvance/input_Description'), description)

		'Save details and close'
		WebUI.mouseOver(findTestObject('Page_WMI_NEW/RouteAdvance/span_Standard Actions'))
		WebUI.waitForElementVisible(findTestObject('Page_WMI_NEW/RouteAdvance/a_Save'), GlobalVariable.G_LongTimeout)
		new Window().clickElementAndWaitForWindowClose(findTestObject('Page_WMI_NEW/RouteAdvance/a_Save'), GlobalVariable.G_LongTimeout)

		'Switch to main window and close'
		WebUI.switchToWindowTitle('Savana nGage')
		WebUI.click(findTestObject('Page_nGage_Dashboard/Home/span_ui-button-icon-primary ui'))
	}


	@Keyword
	def createDocument_ProcessForTaskDT(String customerName, String customerDetails) {

		'Switch to main window'
		WebUI.switchToWindowTitle('Savana nGage')

		'Create a new BovDocTwoRow Document'
		WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))
		selectDocClassAndDocTypeForGlobalNew('Closure Action', 'ProcessforTaskDT')
		WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

		'Switch to new Window'
		WebUI.switchToWindowTitle('(Doc ID: NEW )')
		WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

		'Fill the details required'
		WebUI.setText(findTestObject('Page_WMI_NEW/ProcessForTaskDT/input_Customer Name'), customerName)
		WebUI.setText(findTestObject('Page_WMI_NEW/ProcessForTaskDT/input_Customer Details'), customerDetails)

		'Save details and close'
		WebUI.mouseOver(findTestObject('Page_WMI_NEW/ProcessForTaskDT/span_Actions'))
		WebUI.waitForElementVisible(findTestObject('Page_WMI_NEW/ProcessForTaskDT/a_Save'), GlobalVariable.G_LongTimeout)
		new Window().clickElementAndWaitForWindowClose(findTestObject('Page_WMI_NEW/ProcessForTaskDT/a_Save'),GlobalVariable.G_LongTimeout)

		'Switch to main window and close'
		WebUI.switchToWindowTitle('Savana nGage')
		WebUI.click(findTestObject('Page_nGage_Dashboard/Home/span_ui-button-icon-primary ui'))
	}

	@Keyword
	def verifyElementsCount(TestObject to, int expCount) {

		List<WebElement> elements = WebUtil.getWebElements(to)
		WebUI.switchToDefaultContent()
		WebUI.verifyEqual(elements.size(), expCount)

	}

	@Keyword
	def createDocument_RenderAllField(String integerField, String stringFieldOnFocusAttr, String stringFieldLookup,
			String currencyField, String dateField, String floatField, String smallIntField, String textField,
			String dateTimeField, String stringField, String extNameField) {

		'Switch to main window'
		WebUI.switchToWindowTitle('Savana nGage')

		'Create a new BovDocTwoRow Document'
		WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))
		selectDocClassAndDocTypeForGlobalNew('Master Object Feature', 'Render All Field Types')
		WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

		'Switch to new Window'
		WebUI.switchToWindowTitle('(Doc ID: NEW )')
		WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

		'Fill the details required'
		WebUI.setText(findTestObject('Page_WMI_NEW/Master_Object/input_Integer Field'), integerField)	//Integer field
		WebUI.setText(findTestObject('Page_WMI_NEW/Master_Object/input_String Field (with onfocussetcursorattheend attribute)'), stringFieldOnFocusAttr)	//String Field (with onfocussetcursorattheend attribute)
		WebUI.selectOptionByLabel(findTestObject('Page_WMI_NEW/Master_Object/select_String Field With Lookup'), stringFieldLookup, false)	//String Field With Lookup
		WebUI.setText(findTestObject('Page_WMI_NEW/Master_Object/input_Currency Field'), currencyField)	//Currency Field
		WebUI.sendKeys(findTestObject('Page_WMI_NEW/Master_Object/input_Currency Field'), Keys.chord(Keys.TAB))
		//WebUI.delay(2)
		WebUtil.delay(100)
		setText_Date(findTestObject('Page_WMI_NEW/Master_Object/input_Date Field'), dateField)
		WebUI.setText(findTestObject('Page_WMI_NEW/Master_Object/input_Float Field (Precision3minval-10maxval-100)'), floatField)	//Float Field (Precision:3,minval-10,maxval-100)
		WebUI.setText(findTestObject('Page_WMI_NEW/Master_Object/input_Small Integer Field(minval-10maxval-100)'), smallIntField)	//Small Integer Field(minval-10,maxval-100)
		WebUI.setText(findTestObject('Page_WMI_NEW/Master_Object/input_Text Field(with onfocusselectall attribute)'), textField)	//Text Field(with onfocusselectall attribute)
		setText_Date(findTestObject('Page_WMI_NEW/Master_Object/input_DateTime Field'), dateTimeField)	//DateTime Field
		WebUI.setText(findTestObject('Page_WMI_NEW/Master_Object/input_String Filed'), stringField)	//String Filed
		WebUI.setText(findTestObject('Page_WMI_NEW/Master_Object/input_Ext Name Field'), extNameField)	//Ext Name Field

		'Save details and close'
		WebUI.click(findTestObject('Page_WMI_NEW/Master_Object/span_Save'))
		WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
		new Window().clickElementAndWaitForWindowClose(findTestObject('Page_WMI_NEW/Master_Object/span_Close Window'),GlobalVariable.G_LongTimeout)

		'Switch to main window and close'
		WebUI.switchToWindowTitle('Savana nGage')
		WebUI.click(findTestObject('Page_nGage_Dashboard/Home/span_ui-button-icon-primary ui'))
	}

	@Keyword
	def waitForImageToRender(TestObject to) {
		waitForFrameToLoad(to)
		WebUI.delay(5)
	}

	@Keyword
	def createDocument_Correspondence(String firstName, String lastName, String toEmail, String template) {

		'Switch to main window'
		WebUI.switchToWindowTitle('Savana nGage')

		'Create a new BovDocTwoRow Document'
		WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))
		selectDocClassAndDocTypeForGlobalNew('Correspondence', 'Correspondence')
		WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

		'Switch to new Window'
		WebUI.switchToWindowIndex(1)
		WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

		'Fill the details required'
		WebUI.setText(findTestObject('Page_WMI_NEW/Correspondence/input_First Name'), firstName)
		WebUI.setText(findTestObject('Page_WMI_NEW/Correspondence/input_Last Name'), lastName)
		WebUI.setText(findTestObject('Page_WMI_NEW/Correspondence/input_To Email'), toEmail)
		WebUI.selectOptionByLabel(findTestObject('Page_WMI_NEW/Correspondence/select_Template'), template, false)
		WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
		WebUI.delay(2)
		waitForFrameToLoad(findTestObject('Page_WMI_NEW/Correspondence/iframe_BodyText'))

		'Save details and close'
		WebUI.click(findTestObject('Page_WMI_NEW/Correspondence/span_Save'))
		WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

		'Click close window'
		WebUI.waitForElementVisible(findTestObject('Page_WMI/Correspondence/span_Close Window'), GlobalVariable.G_LongTimeout)
		new Window().clickElementAndWaitForWindowClose(findTestObject('Page_WMI/Correspondence/span_Close Window'),GlobalVariable.G_LongTimeout)

		'Switch to main window and close'
		WebUI.switchToWindowTitle('Savana nGage')
		WebUI.click(findTestObject('Page_nGage_Dashboard/Home/span_ui-button-icon-primary ui'))
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
				createDocument_ClosureAction('Chintan Shah', 'Document '+i)
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
				createDocument_RenderAllField('10', "Chintan Shah"+i, "", "", "", "", "", "", "", "", "")
			}
		}
		WebUI.refresh()
		WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
		WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
	}

	@Keyword
	def createBulkDocuments_WMIMenuBovVertical(int requiredDocsCount) {

		String filePath = RunConfiguration.getProjectDir().replace('/', '\\')+'\\Data Files\\FileUploads\\50 Pages PDF file.pdf'

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
				createDocument_WMIMenuBovVertical('Chintan Shah '+i, filePath)
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
				createDocument_Correspondence("Chintan", "Shah", "c.s@abc.com", "Template1")
			}
		}
		WebUI.refresh()
		WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
		WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

	}

	@Keyword
	def createDocument_ReloadOnPostBack(String BM_String) {

		'Switch to main window'
		WebUI.switchToWindowTitle('Savana nGage')

		'Create a new BovDocTwoRow Document'
		WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))
		selectDocClassAndDocTypeForGlobalNew('DoNotReloadOnPostback', 'ReloadOnPostbackNoSplit T')
		WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

		'Switch to new Window'
		//WebUI.switchToWindowTitle('(Doc ID: NEW )')
		WebUI.switchToWindowIndex(1)
		WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

		'Fill the details required'
		WebUI.setText(findTestObject('Page_WMI_NEW/DoNotReloadOnPostBack/NoSplit_T/input_BM String'), BM_String)

		'Save details and close'
		WebUI.click(findTestObject('Page_WMI_NEW/DoNotReloadOnPostBack/NoSplit_T/span_Save'))
		WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

		'Click close window'
		WebUI.waitForElementVisible(findTestObject('Page_WMI_NEW/DoNotReloadOnPostBack/NoSplit_T/span_Close'), GlobalVariable.G_LongTimeout)
		new Window().clickElementAndWaitForWindowClose(findTestObject('Page_WMI_NEW/DoNotReloadOnPostBack/NoSplit_T/span_Close'),GlobalVariable.G_LongTimeout)

		'Switch to main window and close'
		WebUI.switchToWindowTitle('Savana nGage')
		WebUI.click(findTestObject('Page_nGage_Dashboard/Home/span_ui-button-icon-primary ui'))
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
				createDocument_ReloadOnPostBack('Chintan Shah '+i)
			}
		}
		WebUI.refresh()
		WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
		WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

	}


	@Keyword
	def verifyElementHasFocus(TestObject toLocator) {
		WebUtil.delay(100)
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
	def createDocument_RenderAsLabel() {

		'Switch to main window'
		WebUI.switchToWindowTitle('Savana nGage')

		'Create a new BovDocTwoRow Document'
		WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))

		selectDocClassAndDocTypeForGlobalNew('Master Object Feature', 'Render As Label')
		WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

		WebUI.switchToWindowIndex(1)
		WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

		'Click Save'
		WebUI.click(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_Label/span_Save'))
		WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

		'Click close window'
		new Window().clickElementAndWaitForWindowClose(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_Label/span_Close Window'), GlobalVariable.G_LongTimeout)

		'Switch to main window and close'
		WebUI.switchToWindowTitle('Savana nGage')
		WebUI.click(findTestObject('Page_nGage_Dashboard/Home/span_ui-button-icon-primary ui'))
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
				createDocument_RenderAsLabel()
			}
		}

		WebUI.refresh()
		WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
		WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
	}

	@Keyword
	def createDocument_ReferenceObjectInlineContentView() {

		'Switch to main window'
		WebUI.switchToWindowTitle('Savana nGage')

		'Create a new BovDocTwoRow Document'
		WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))

		selectDocClassAndDocTypeForGlobalNew('Reference Object Feature', 'Reference Object InlineContentView')
		WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

		WebUI.switchToWindowIndex(1)
		WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

		'Click Save'
		WebUI.click(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_Label/span_Save'))
		WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

		'Click close window'
		new Window().clickElementAndWaitForWindowClose(findTestObject('Page_WMI_NEW/Master_Object_Feature/Render_As_Label/span_Close Window'), GlobalVariable.G_LongTimeout)

		'Switch to main window and close'
		WebUI.switchToWindowTitle('Savana nGage')
		WebUI.click(findTestObject('Page_nGage_Dashboard/Home/span_ui-button-icon-primary ui'))
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
				createDocument_ReferenceObjectInlineContentView()
			}
		}

		WebUI.refresh()
		WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)
		WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
	}


	@Keyword
	def createDocument_EventForRequiredField(String dropDownControl, String textValue, String date) {

		'Switch to main window'
		WebUI.switchToWindowTitle('Savana nGage')

		'Create a new BovDocTwoRow Document'
		WebUI.click(findTestObject('Page_nGage_Dashboard/input_btnGlobalNew'))

		selectDocClassAndDocTypeForGlobalNew('Event for Req Fld', 'Event for req field')
		WebUI.click(findTestObject('Page_nGage_Dashboard/Home/input_btnsave'))

		WebUI.switchToWindowIndex(1)
		WebUI.waitForPageLoad(GlobalVariable.G_LongTimeout)

		'Enter Data'
		WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/process_Event For Required Field/select_MasterObjectDropdownControl'), dropDownControl, false)
		waitForTabLoading(null, GlobalVariable.G_LongTimeout)
		//WebUI.clearText(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/process_Event For Required Field/input_String Field (Value Chan'))
		WebUI.setText(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/process_Event For Required Field/input_String Field (Value Chan'), textValue)
		setText_Date(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/process_Event For Required Field/input_Date Field (Visibility C'), date)

		'Click Save and close window'
		WebUI.mouseOver(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/process_Event For Required Field/span_Actions'))
		WebUI.waitForElementVisible(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/process_Event For Required Field/a_Save'), GlobalVariable.G_LongTimeout)
		new Window().clickElementAndWaitForWindowClose(findTestObject('Object Repository/Page_nGage_Dashboard/My_Work/process_Event For Required Field/a_Save'), GlobalVariable.G_LongTimeout)

		'Switch to main window and close'
		WebUI.switchToWindowTitle('Savana nGage')
		WebUI.click(findTestObject('Page_nGage_Dashboard/Home/span_ui-button-icon-primary ui'))
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
			createDocument_RenderAllField('10', '', '', '', '', '', '', '', '', '', '')
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
		if(!FLAG_P1_DOCA_REPO) {
			createDocument_DateTimeDT(P1_REPO_DOCA_BMDATE, P1_REPO_DOCA_DATERANGE, P1_REPO_DOCA_BMDATETIME, P1_REPO_DOCA_DATETIMERANGE)
			FLAG_P1_DOCA_REPO = true
		}
		
		if(!FLAG_P1_DOCB_REPO) {
			createDocument_DateTimeDT(P1_REPO_DOCB_BMDATE, P1_REPO_DOCB_DATERANGE, P1_REPO_DOCB_BMDATETIME, P1_REPO_DOCB_DATETIMERANGE)
			FLAG_P1_DOCB_REPO = true
		}
		
		if(!FLAG_P1_DOCC_REPO) {
			createDocument_DateTimeDT(P1_REPO_DOCC_BMDATE, P1_REPO_DOCC_DATERANGE, P1_REPO_DOCC_BMDATETIME, P1_REPO_DOCC_DATETIMERANGE)
			FLAG_P1_DOCC_REPO = true
		}
		
		if(!FLAG_P1_DOCD_REPO) {
			createDocument_DateTimeDT(P1_REPO_DOCD_BMDATE, P1_REPO_DOCD_DATERANGE, P1_REPO_DOCD_BMDATETIME, P1_REPO_DOCD_DATETIMERANGE)
			FLAG_P1_DOCD_REPO = true
		}
		
		if(!FLAG_P1_DOCE_REPO) {
			createDocument_DateTimeDT(P1_REPO_DOCE_BMDATE, P1_REPO_DOCE_DATERANGE, P1_REPO_DOCE_BMDATETIME, P1_REPO_DOCE_DATETIMERANGE)
			FLAG_P1_DOCE_REPO = true
		}
		
		if(!FLAG_P1_DOCF_REPO) {
			createDocument_DateTimeDT(P1_REPO_DOCF_BMDATE, P1_REPO_DOCF_DATERANGE, P1_REPO_DOCF_BMDATETIME, P1_REPO_DOCF_DATETIMERANGE)
			FLAG_P1_DOCF_REPO = true
		}
		
	}



}