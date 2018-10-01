package actions

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.awt.Robot
import java.awt.Toolkit
import java.awt.datatransfer.StringSelection
import java.awt.event.KeyEvent

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions
import org.junit.After
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.Keys

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords
import internal.GlobalVariable as GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI
public class FileUpload {
	//	@Keyword
	//	def uploadFile_MultiPageViewer(String filePath, int timeout) {
	//
	//		try {
	//			copyFilePathToClipboard(filePath)
	//			locateDragAndDropDiv()
	//			performRobotAction()
	//			KeywordUtil.markPassed("File upload operation completed.")
	//		}
	//		catch(Exception e) {
	//			KeywordUtil.logInfo(e.toString())
	//			KeywordUtil.markFailedAndStop("File upload operation failed."+e.message)
	//		}
	//	}
	//
	//	private void locateDragAndDropDiv() {
	//		WebDriver driver = DriverFactory.getWebDriver()
	//		WebElement frame = driver.findElement(By.id('ContentPlaceHolder1_iPage'))
	//		driver.switchTo().frame(frame)
	//		WebElement element = driver.findElement(By.className('advancefileupload'))
	//
	//
	//		//WebElement element = WebUI.executeJavaScript('return document.querySelector("#ContentPlaceHolder1_iPage").contentWindow.document.querySelector(".advancefileupload")', null)
	//		WebUI.executeJavaScript('arguments[0].click', Arrays.asList(element))
	//	}
	//
	//	private void clickElement(TestObject to) {
	//		WebUI.click(to)
	//	}
	//
	//	private void openDialogUsingJavaScript() {
	//		WebDriver driver = DriverFactory.getWebDriver()
	//
	//
	//		//JavascriptExecutor jsDriver = (JavascriptExecutor)driver
	//		//String script = "document.querySelector('#mainContainerFrame').contentWindow.document.querySelector('#ContentPlaceHolder1_iPage').contentWindow.document.querySelector('.advancefileupload').click();"
	//		String script = "document.querySelector('#mainContainerFrame').contentWindow.document.querySelector('#ContentPlaceHolder1_iPage').contentWindow.document.querySelector('#eform_mcb67676_phBO_3_BO_dZUpload_hdnfile').click();"
	//
	//		//jsDriver.executeScript(script)
	//		WebUI.executeJavaScript(script, null)
	//		WebUI.delay(3)
	//	}
	//
	//	private void copyFilePathToClipboard(String filePath) {
	//		StringSelection ss = new StringSelection(filePath)
	//		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null)
	//	}
	//
	//
	//
	//
	//	@Keyword
	//	def uploadFileEdge(String filePath, int timeout, String elementXpath, String... framesXpath) {
	//
	//
	//		WebDriver driver = DriverFactory.getWebDriver();
	//
	//		try {
	//			//Switch to IFrames
	//			if(framesXpath != null && framesXpath.size() > 0) {
	//				for(int i = 0; i < framesXpath.size(); i++) {
	//					println "swith to iframe located by Xpath :"+framesXpath[i]
	//					WebElement frame = driver.findElement(By.xpath(framesXpath[i]))
	//					driver.switchTo().frame(frame)
	//				}
	//			}
	//			//
	//			//			//Click on Element
	//			//			List<WebElement> elements = new ArrayList<>()
	//			//			WebElement e1 = driver.findElement(By.xpath(elementXpath))
	//			//			elements.add(e1)
	//			//
	//			//			Actions builder = new Actions(driver)
	//			//			builder.moveToElement(e1).click()
	//			//			builder.perform()
	//
	//			JavascriptExecutor jsDriver = (JavascriptExecutor)driver
	//			jsDriver.executeScript("return document.getElementById('eform_mcb67676_phBO_3_BO_dZUpload').click();")
	//			WebUI.delay(3)
	//
	//
	//
	//			//Perform Robot action to paste file path in Browse dialog
	//			performRobotAction()
	//
	//			WebUI.switchToDefaultContent()
	//
	//			KeywordUtil.markPassed("File upload operation completed.")
	//		}
	//		catch(Exception e) {
	//			KeywordUtil.logInfo(e.toString())
	//			KeywordUtil.markFailedAndStop("File upload operation failed."+e.message);
	//		}
	//	}
	//
	//	@Keyword
	//	def uploadFile(String fileObject, String filePath, int timeout) {
	//		try {
	//			println 'Click on Element to load File upload dialog'
	//			WebUI.click(findTestObject(fileObject))
	//			println 'Copy file path to clipboard'
	//			StringSelection ss = new StringSelection(filePath)
	//			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null)
	//
	//			performRobotAction()
	//
	//			WebUI.switchToDefaultContent()
	//			//Wait for File upload operation to complete
	//			KeywordUtil.markPassed("File upload operation completed.")
	//		}
	//		catch (Exception e) {
	//			KeywordUtil.logInfo(e.toString())
	//			KeywordUtil.markFailedAndStop("File upload operation failed."+e.message);
	//		}
	//	}
	//
	//	@Keyword
	//	def uploadFileUsingAutoIt(String fileObject, String filePath, int timeout) {
	//
	//		try {
	//			println 'Click on Element to load File upload dialog'
	//			WebUI.click(findTestObject(fileObject), FailureHandling.CONTINUE_ON_FAILURE)
	//
	//			println 'Copy file path to clipboard'
	//			StringSelection ss = new StringSelection(filePath)
	//			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null)
	//
	//			//			performRobotAction()
	//			Runtime.getRuntime().exec("C:\\Users\\cshah\\Desktop\\AutoIT\\FileUploadOperation.exe")
	//
	//			WebUI.switchToDefaultContent()
	//			//Wait for File upload operation to complete
	//			KeywordUtil.markPassed("File upload operation completed.")
	//		}
	//		catch (Exception e) {
	//			KeywordUtil.logInfo(e.toString())
	//			KeywordUtil.markFailedAndStop("File upload operation failed."+e.message);
	//		}
	//	}
	//
	//	private void performRobotAction() {
	//
	//		Robot robot = new Robot()
	//		WebUI.delay(2)
	//		println "Press Enter"
	//		robot.keyPress(KeyEvent.VK_ENTER)
	//		robot.keyRelease(KeyEvent.VK_ENTER)
	//		println 'Press Ctrl+V to copy file path'
	//		robot.keyPress(KeyEvent.VK_CONTROL)
	//		robot.keyPress(KeyEvent.VK_V)
	//		robot.keyRelease(KeyEvent.VK_CONTROL)
	//		robot.keyRelease(KeyEvent.VK_V)
	//		WebUI.delay(2)
	//		println 'Press Enter to upload file'
	//		robot.keyPress(KeyEvent.VK_ENTER)
	//		robot.keyRelease(KeyEvent.VK_ENTER)
	//		WebUI.delay(2)
	//	}
}
