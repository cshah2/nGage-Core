package actions

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.text.Collator
import java.text.RuleBasedCollator
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
import static utils.Consts.*

public class MenuBar {

	/**
	 * Method will return record count displayed for Activity in left menu
	 * For Ex: if Left menu activity name is "Activity A(100)", then it will return value 100 as a String"
	 * @param element
	 * @return
	 */

	@Keyword
	def getRecordCountInActivity(TestObject element) {
		try {
			WebUI.waitForElementPresent(element, GlobalVariable.G_LongTimeout)
			WebUI.waitForElementVisible(element, GlobalVariable.G_LongTimeout)
			String nodeText = WebUI.getText(element)

			int startIndex = nodeText.lastIndexOf('(')+1
			int lastIndex = nodeText.length()-1
			String recordCountInString = nodeText.substring(startIndex, lastIndex).trim()
			return Integer.parseInt(recordCountInString)
		}
		catch(Exception e) {

			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop('Coult not get record count '+e.toString())
		}
	}


	@Keyword
	def refreshActivityUntilRecordCountIncreases(int originalCount, int timeout, String moduleName, String... modulePath) {
		int currentCount = originalCount
		boolean hasRecordCountIncreased = false

		def startTime = System.currentTimeMillis()
		def endTime = startTime + TimeUnit.SECONDS.toMillis(timeout)
		def currentTime = System.currentTimeMillis()

		String[] parentPath = Arrays.copyOf(modulePath, modulePath.length - 1)

		clickTreeMenu(moduleName, parentPath)
		new Common().waitForFrameToLoad(findTestObject('Page_nGage_Dashboard/iframe_main_visible'))

		while(currentTime < endTime) {
			println "Original Count = "+originalCount+"currentCount = "+currentCount
			if(currentCount < 0 || currentCount <= originalCount) {

				rightClickTreeMenu(moduleName, parentPath)
				WebUI.waitForElementVisible(findTestObject('Page_nGage_Dashboard/contextMenu'), GlobalVariable.G_SmallTimeout)
				new ContextMenu().clickOption(findTestObject('Page_nGage_Dashboard/contextMenuOptions'), 'Refresh')
				WebUI.waitForJQueryLoad(GlobalVariable.G_SmallTimeout)
				WebUI.delay(3)
				currentCount = getRecordCountInActivity(moduleName, modulePath)
				currentTime = System.currentTimeMillis()
			}
			else {
				hasRecordCountIncreased = true
				break
			}
		}

		if(hasRecordCountIncreased) {
			KeywordUtil.markPassed("Activity count refreshed")
		}
		else {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop("Activity count not refreshed in given time "+timeout+" Seconds")
		}
	}

	@Keyword
	def getAllSubMenus(String moduleName, String... menuPath) {

		List<String> treePath = new ArrayList<String>(Arrays.asList(menuPath))
		expandTree(moduleName, treePath)

		treeXpath.append("/ul/li/a")
		WebDriver driver = DriverFactory.getWebDriver()
		List<WebElement> elements = driver.findElements(By.xpath(treeXpath.toString()))
		List<String> subMenu=new ArrayList()
		for(WebElement element in elements) {
			subMenu.add(element.getText().trim())
		}
		return subMenu
	}

	@Keyword
	def verifyAllSubmenuAreSortedByActivityCount(List<String> subMenus,String sortOrder) {
		boolean isSorted;
		List<Integer> activityCounts=new ArrayList<Integer>()
		for(String subMenuText in subMenus) {
			try {
				int startIndex = subMenuText.lastIndexOf('(')+1
				int lastIndex = subMenuText.length()-1
				String recordCountInString = subMenuText.substring(startIndex, lastIndex).trim()
				activityCounts.add(Integer.parseInt(recordCountInString))
			}
			catch(Exception e) {
				println "Coult not get record count "+e.toString()
				KeywordUtil.markFailedAndStop('Cannot fetch activity record count. Activity name = '+subMenuText)
			}
		}

		List<Integer> sortedActivityCountsList=new ArrayList<Integer>()
		sortedActivityCountsList.addAll(activityCounts)
		Collections.sort(sortedActivityCountsList)

		if(sortOrder.equalsIgnoreCase('desc'))
			Collections.reverse(sortedActivityCountsList)

		isSorted=activityCounts.equals(sortedActivityCountsList)
		if(!isSorted)
			KeywordUtil.markErrorAndStop("submenus are not sorted")
		else
			KeywordUtil.markPassed("submenus are in sorted order")
	}

	@Keyword
	def verifyAllSubmenuAreSortedByActivityName(List<String> subMenus,String sortOrder) {
		//converting sub menu items to lower case
		List<String> subMenusWithoutCount=new ArrayList<String>()
		for(String subMenu in subMenus)
		{
			//subMenusLowerCase.add(subMenu.toLowerCase())
			String text = subMenu.substring(0, subMenu.lastIndexOf(" ("))
			subMenusWithoutCount.add(text)
		}
		subMenus.clear()
		subMenus.addAll(subMenusWithoutCount)

		if(sortOrder.equalsIgnoreCase('asc'))
			subMenus.remove(0)
		else
			subMenus.remove(subMenus.size()-1)

		boolean isSorted;
		List<String> sortedActivityNameList=new ArrayList<String>()
		sortedActivityNameList.addAll(subMenus)

		Collator coll = Collator.getInstance(Locale.US);
		coll.setStrength(Collator.IDENTICAL);

		RuleBasedCollator defaultCollator = (RuleBasedCollator) coll
		final String rules = defaultCollator.getRules()

		RuleBasedCollator coll1 = new RuleBasedCollator(rules.replaceAll("<'\u005f'", "<' '<'\u005f'"))
		coll1.setStrength(Collator.IDENTICAL);

		Collections.sort(sortedActivityNameList, coll1)

		if(sortOrder.equalsIgnoreCase('desc'))
			Collections.reverse(sortedActivityNameList)

		println 'Actual: '+subMenus
		println 'Exp: '+sortedActivityNameList
		isSorted=subMenus.equals(sortedActivityNameList)
		if(!isSorted)
			KeywordUtil.markFailedAndStop("submenus are not sorted")
		else
			KeywordUtil.markPassed("submenus are in sorted order")
	}

	StringBuilder treeXpath;


	@Keyword
	def clickTreeMenu(String moduleName, String... menuPath) {

		try {
			int size = menuPath.length

			List<String> treePath = new ArrayList<String>(Arrays.asList(menuPath))
			int lastIndex = treePath.size()-1
			treePath.remove(lastIndex)
			expandTree(moduleName, treePath)

			String appendBrace = ""
			if(!moduleName.equalsIgnoreCase('REPORT'))
				appendBrace = lastIndex>1?" (":""

			treeXpath.append(xpathText(menuPath[size-1]+appendBrace))

			WebDriver driver = DriverFactory.getWebDriver()
			driver.findElement(By.xpath(treeXpath.toString())).click()

		}
		catch(Exception e) {

			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop('Could not click on Tree menu'+e.toString())
		}
	}

	@Keyword
	def doubleClickTreeMenu(String moduleName, String... menuPath) {

		try {
			int size = menuPath.length

			List<String> treePath = new ArrayList<String>(Arrays.asList(menuPath))
			int lastIndex = treePath.size()-1
			treePath.remove(lastIndex)
			expandTree(moduleName, treePath)

			String appendBrace = ""
			if(!moduleName.equalsIgnoreCase('REPORT'))
				appendBrace = lastIndex>1?" (":""

			//treeXpath.append("/ul/li/a[starts-with(normalize-space(text()),'"+menuPath[size-1]+appendBrace+"')]")
			treeXpath.append(xpathText(menuPath[size-1]+appendBrace))
			WebDriver driver = DriverFactory.getWebDriver()
			WebElement e = driver.findElement(By.xpath(treeXpath.toString()))

			Actions aDriver = new Actions(driver)
			aDriver.doubleClick(e).build().perform()
		}
		catch(Exception e) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop('Could not double click on Tree menu'+e.toString())
		}
	}

	@Keyword
	def rightClickTreeMenu(String moduleName, String... menuPath) {

		try {
			int size = menuPath.length

			List<String> treePath = new ArrayList<String>(Arrays.asList(menuPath))
			int lastIndex = treePath.size()-1
			treePath.remove(lastIndex)
			expandTree(moduleName, treePath)

			String appendBrace = ""
			if(!moduleName.equalsIgnoreCase('REPORT'))
				appendBrace = lastIndex>1?" (":""

			//treeXpath.append("/ul/li/a[starts-with(normalize-space(text()),'"+menuPath[size-1]+appendBrace+"')]")
			treeXpath.append(xpathText(menuPath[size-1]+appendBrace))
			WebDriver driver = DriverFactory.getWebDriver()
			WebElement e = driver.findElement(By.xpath(treeXpath.toString()))

			Actions aDriver = new Actions(driver)
			aDriver.contextClick(e).build().perform()

		}
		catch(Exception e) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop('Could not right click on Tree menu'+e.toString())
		}
	}

	@Keyword
	def getRecordCountInActivity(String moduleName, String... menuPath) {

		int size = menuPath.length

		List<String> treePath = new ArrayList<String>(Arrays.asList(menuPath))
		int lastIndex = treePath.size()-1
		treePath.remove(lastIndex)
		expandTree(moduleName, treePath)

		try {
			String appendBrace = ""
			if(!moduleName.equalsIgnoreCase('REPORT'))
				appendBrace = lastIndex>1?" (":""

			//treeXpath.append("/ul/li/a[starts-with(normalize-space(text()),'"+menuPath[size-1]+appendBrace+"')]")
			treeXpath.append(xpathText(menuPath[size-1]+appendBrace))
			WebDriver driver = DriverFactory.getWebDriver()
			String nodeText = driver.findElement(By.xpath(treeXpath.toString())).getText()


			int startIndex = nodeText.lastIndexOf('(')+1
			int endIndex = nodeText.length()-1
			String recordCountInString = nodeText.substring(startIndex, endIndex).trim()
			return Integer.parseInt(recordCountInString)
		}
		catch(Exception e) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop('Could not get record count in activity'+e.toString())
		}
	}

	@Keyword
	def verifyAllActivityNamesAreValidDate(String moduleName, String dateFormat, String... menuPath) {

		int size = menuPath.length

		List<String> treePath = new ArrayList<String>(Arrays.asList(menuPath))
		expandTree(moduleName, treePath)

		WebDriver driver = DriverFactory.getWebDriver()
		treeXpath.append("/ul/li/a")
		List<WebElement> eleList = driver.findElements(By.xpath(treeXpath.toString()))

		for(WebElement e in eleList) {
			String dateValue = e.getText().split(' \\(')[0].trim()
			if(!dateValue.equalsIgnoreCase(TREE_EMPTY))
				(new Common()).verifyDateFormat(dateValue, dateFormat)
		}
	}

	/**
	 * 
	 * @param treePath
	 */
	private void expandTree(String moduleName, List<String> treePath) {
		WebDriver driver = DriverFactory.getWebDriver()


		switch(moduleName.toUpperCase()) {
			case 'REPO':
				treeXpath = new StringBuilder("//div[@id='menudiv_104']")
				break
			case 'MY_WORK':
				treeXpath = new StringBuilder("//div[@id='menudiv_105']")
				break
			case 'HOME':
				treeXpath = new StringBuilder("//div[@id='menudiv_103']")
				break
			case 'REPORT':
				treeXpath = new StringBuilder("//div[@id='menudiv_108']")
				break
			default:
				KeywordUtil.markFailedAndStop("no such module exist: "+moduleName)
				break
		}


		WebElement a
		WebElement li

		int i = 0
		for(String path in treePath) {

			String appendBrace = ""
			if(!moduleName.equalsIgnoreCase('REPORT'))
				appendBrace = i>1?" (":""
			//treeXpath.append("/ul/li/a[starts-with(normalize-space(text()),'"+path+appendBrace+"')]")
			treeXpath.append(xpathText(path+appendBrace))
			a = driver.findElement(By.xpath(treeXpath.toString()))
			treeXpath.append("/..")
			li = a.findElement(By.xpath(".."))

			if(!isAreaExpanded(li)) {
				Actions asDriver = new Actions(driver)
				asDriver.doubleClick(a).build().perform()
				WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
				WebUI.delay(1)
			}
			i++
		}
	}

	/**
	 * 
	 * @param li
	 * @return
	 */
	private boolean isAreaExpanded(WebElement li) {
		return Boolean.parseBoolean(li.getAttribute("aria-expanded"))
	}


	@Keyword
	def verifySubMenuPresent(String moduleName, String expMenu, String... menuPath) {

		int size = menuPath.length

		List<String> treePath = new ArrayList<String>(Arrays.asList(menuPath))
		expandTree(moduleName, treePath)

		WebDriver driver = DriverFactory.getWebDriver()
		treeXpath.append("/ul/li/a")
		List<WebElement> eleList = driver.findElements(By.xpath(treeXpath.toString()))
		List<String> subNodeNames = new ArrayList<String>()

		for(WebElement e in eleList) {
			String dateValue = e.getText().trim()
			int startIndex = 0
			int endIndex = dateValue.lastIndexOf(' (')+1
			subNodeNames.add(dateValue.substring(startIndex, endIndex).trim().toLowerCase())
		}

		if(subNodeNames.contains(expMenu.trim().toLowerCase()))
			KeywordUtil.markPassed('Sub Node '+expMenu+' found in list')
		else
			KeywordUtil.markFailedAndStop('Sub Node '+expMenu+' not found in list'+subNodeNames)

	}

	@Keyword
	def isSubMenuPresent(String moduleName, String expMenu, String... menuPath) {

		int size = menuPath.length

		List<String> treePath = new ArrayList<String>(Arrays.asList(menuPath))
		expandTree(moduleName, treePath)

		WebDriver driver = DriverFactory.getWebDriver()
		treeXpath.append("/ul/li/a")
		List<WebElement> eleList = driver.findElements(By.xpath(treeXpath.toString()))
		List<String> subNodeNames = new ArrayList<String>()

		for(WebElement e in eleList) {
			String dateValue = e.getText().trim()
			int startIndex = 0
			int endIndex = dateValue.lastIndexOf(' (')+1
			subNodeNames.add(dateValue.substring(startIndex, endIndex).trim().toLowerCase())
		}

		return subNodeNames.contains(expMenu.trim().toLowerCase())
	}

	@Keyword
	def verifyTreeIsSelected(String moduleName, String... menuPath) {

		int size = menuPath.length

		List<String> treePath = new ArrayList<String>(Arrays.asList(menuPath))
		int lastIndex = treePath.size()-1
		treePath.remove(lastIndex)
		expandTree(moduleName, treePath)

		String appendBrace = ""
		if(!moduleName.equalsIgnoreCase('REPORT'))
			appendBrace = lastIndex>1?" (":""

		//treeXpath.append("/ul/li/a[starts-with(text(),'"+menuPath[size-1]+appendBrace+"')]")
		treeXpath.append(xpathText(menuPath[size-1]+appendBrace))
		WebDriver driver = DriverFactory.getWebDriver()
		WebElement e = driver.findElement(By.xpath(treeXpath.toString()))

		String classAttr = e.getAttribute('class')
		if(classAttr.contains('jstree-clicked')) {
			KeywordUtil.markPassed('Tree path is selected')
		}
		else {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop('Tree path is not selected')
		}
	}

	@Keyword
	def verifyTreeDoesNotHaveExpandIcon(String moduleName, String... menuPath) {
		int size = menuPath.length

		List<String> treePath = new ArrayList<String>(Arrays.asList(menuPath))
		int lastIndex = treePath.size()-1
		treePath.remove(lastIndex)
		expandTree(moduleName, treePath)

		String appendBrace = ""
		if(!moduleName.equalsIgnoreCase('REPORT'))
			appendBrace = lastIndex>1?" (":""

		//treeXpath.append("/ul/li/a[starts-with(text(),'"+menuPath[size-1]+appendBrace+"')]/../i")
		treeXpath.append(xpathText(menuPath[size-1]+appendBrace)+"/../i")
		WebDriver driver = DriverFactory.getWebDriver()
		WebElement e = driver.findElement(By.xpath(treeXpath.toString()))

		String bkgImage = e.getCssValue('background-image')

		if(bkgImage.equals('none')) {
			KeywordUtil.markPassed('Expand Icon not visible against the last tree node')
		}
		else {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop('Expand Icon is visible against the last tree node')
		}

	}

	private String xpathText(String activityName) {
		String text = "/ul/li/a[starts-with(translate(normalize-space(text()),'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'"+activityName.toLowerCase()+"')]"
	}
}