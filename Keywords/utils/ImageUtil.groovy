package utils

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.awt.image.BufferedImage

import javax.imageio.ImageIO

import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class ImageUtil {

	public static String captureImage() {

		//Get Start position of Iframe
		TestObject element = findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/image')
		WebElement pIframe = WebUtil.getWebElement(element.getParentObject())
		int xPos = pIframe.getLocation().getX()
		int yPos = pIframe.getLocation().getY()
		println "X-Position = "+xPos+" Y-Position = "+yPos
		WebUI.switchToDefaultContent()

		//Get Height and width of element
		WebElement ele = WebUtil.getWebElement(element)
		int eleHeight = ele.getSize().getHeight()
		int eleWidth = ele.getSize().getWidth()

		println "Element Height = "+eleHeight+" Width = "+eleWidth
		WebUI.switchToDefaultContent()

		//Take screenshot
		String filePath = WebUI.takeScreenshot()
		File image = new File(filePath)
		BufferedImage fullImage = ImageIO.read(image)
		println "Screenshot Height is = "+fullImage.getHeight()
		println "Screenshot width is = "+fullImage.getWidth()

		//Crop image
		eleHeight = fullImage.getHeight() - yPos
		BufferedImage eleImage = fullImage.getSubimage(xPos, yPos, eleWidth, eleHeight)
		ImageIO.write(eleImage, "png", image)

		return filePath
	}

	public static String captureImage(TestObject element) {

		//Get Start position of Iframe
		//TestObject element = findTestObject('Page_WMI/WMI_Menu_BOV_Vertical/ContentFrame/image')
		WebElement pIframe = WebUtil.getWebElement(element.getParentObject())
		int xPos = pIframe.getLocation().getX()
		int yPos = pIframe.getLocation().getY()
		println "X-Position = "+xPos+" Y-Position = "+yPos
		WebUI.switchToDefaultContent()

		//Get Height and width of element
		WebElement ele = WebUtil.getWebElement(element)
		int eleHeight = ele.getSize().getHeight()
		int eleWidth = ele.getSize().getWidth()

		println "Element Height = "+eleHeight+" Width = "+eleWidth
		WebUI.switchToDefaultContent()

		//Take screenshot
		String filePath = WebUI.takeScreenshot()
		File image = new File(filePath)
		BufferedImage fullImage = ImageIO.read(image)
		println "Screenshot Height is = "+fullImage.getHeight()
		println "Screenshot width is = "+fullImage.getWidth()

		//Crop image
		eleHeight = fullImage.getHeight() - yPos
		BufferedImage eleImage = fullImage.getSubimage(xPos, yPos, eleWidth, eleHeight)
		ImageIO.write(eleImage, "png", image)

		return filePath

	}
}
