package actions

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.util.concurrent.TimeUnit

import org.apache.commons.lang3.StringUtils
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.By.ByCssSelector

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
import utils.Consts
import utils.DateUtil
import utils.WebUtil

public class Table {

	/**
	 * Method to get All Visible rows of table
	 * @param table
	 * @return
	 */
	private List<WebElement> getAllRows(WebElement table) {

		List<WebElement> visibleRows = new ArrayList<WebElement>()
		return table.findElements(By.xpath("./tbody/tr[contains(@class,'GVRow') or contains(@class,'GVAltRow') or @tabindex]"))

		//		List<WebElement> rows = table.findElements(By.xpath("./tbody/tr"))
		//
		//		for(WebElement row in rows) {
		//			if(isVisibleDataRow(row))
		//				visibleRows.add(row)
		//		}
		//		println "Total Rows Count = "+rows.size()
		//		println "Visible Rows Count = "+visibleRows.size()
		//		return visibleRows
	}

	private boolean isVisibleDataRow(WebElement row) {
		String classValue = row.getAttribute('class').toUpperCase()
		return (row.isDisplayed() && !classValue.contains('GVHEADER'))
	}

	/**
	 * Method to get All Visible cells of a row
	 * @param row
	 * @return
	 */
	private List<WebElement> getAllCells(WebElement row) {
		List<WebElement> visibleCells = new ArrayList<WebElement>()
		return row.findElements(By.xpath("./td[not(@class='hiddencol') and not(contains(@style,'none;'))]"))

		//		List<WebElement> cells = new ArrayList<WebElement>()
		//		cells = row.findElements(By.tagName("td"))
		//		for(WebElement cell in cells) {
		//			if(cell.isDisplayed()) {
		//				visibleCells.add(cell)
		//			}
		//		}
		//		return visibleCells
	}

	private List<String> getAllValuesFromColumn(WebElement table, int colNo) {

		List<String> data = new ArrayList<String>();
		List<WebElement> rows = getAllRows(table)
		colNo = colNo - 1
		for (row in rows) {
			String value = getAllCells(row).get(colNo).getText().trim()
			data.add(value)
		}
		return data;
	}

	private List<Integer> getAllValueFromColumnInteger(WebElement table, int colNo) {
		List<String> cellValuesString = getAllValuesFromColumn(table, colNo)
		List<Integer> cellValuesInteger = cellValuesString.collect {Integer.parseInt(it.trim())}
	}

	private void compareTwoLists(def actList, def expList) {
		if(!actList.equals(expList)) {
			println "Actual List = ${actList}"
			println "Expected List = ${expList}"
			KeywordUtil.markFailedAndStop('Records are not sorted')
		}
		else
			KeywordUtil.markPassed('Records are sorted')
	}

	def getRecordCountInTableSummary(TestObject element) {
		WebUI.waitForElementPresent(element, GlobalVariable.G_LongTimeout)
		WebUI.waitForElementVisible(element, GlobalVariable.G_LongTimeout)
		String pageSummary = WebUI.getText(element).trim()

		try {
			String recordCountInString = pageSummary.split(" of ")[1].trim()
			return Integer.parseInt(recordCountInString)
		} catch (Exception e) {
			return -1
		}
	}

	private List<WebElement> getAllHeaders(WebElement table) {

		return table.findElements(By.xpath("thead/tr[1]/th[not(@class='hiddencol') and not(contains(@style,'none;'))]"))
		//		List<WebElement> allHeaders = table.findElements(By.tagName("th"))
		//		List<WebElement> visibleHeaders = new ArrayList<WebElement>()
		//		for(WebElement header in allHeaders) {
		//			String cssDisplay = header.getCssValue('display')
		//			if(cssDisplay != 'none')
		//				visibleHeaders.add(header)
		//		}
		//		return visibleHeaders
	}

	private int getColumnNumberOfHeader(List<WebElement> headers , String columnName) {

		for(int i = 0; i < headers.size() ; i++) {

			WebDriver driver = DriverFactory.getWebDriver()
			Actions aDriver = new Actions(driver)
			aDriver.moveToElement(headers[i]).build().perform()

			String actColumnName = headers[i].getText().replace('\u00A0',' ').trim()

			if(StringUtils.isNotEmpty(actColumnName) && actColumnName.equalsIgnoreCase(columnName)) {
				i = i+1;
				return i
			}
		}
		return -1;
	}

	public static boolean verifyFilter(String operator,int value,int referenceNum) {
		boolean status=false
		switch(operator) {
			case '='://equal to
				if(value.compareTo(referenceNum)==0)
					status=true
				break

			case '<>'://not equal to
				if(value.compareTo(referenceNum)!=0)
					status=true
				break

			case '>':  //greater than
				if(value.compareTo(referenceNum)>0)
					status= true
				break

			case '<'://less than
				if(value.compareTo(referenceNum)<0)
					status= true
				break

			case '>=':  //greater than or equal
				if(value.compareTo(referenceNum)>=0)
					status= true
				break

			case '<='://less than or equal
				if(value.compareTo(referenceNum)<=0)
					status= true
				break

			case 'null'://less than or equal
				if(value.equals(""))
					status= true
				break

			case 'not null':
				if(!value.equals(""))
					status= true
				break

			default:
				status = false
				break
		}
		return status
	}

	/* ##################### KEYWORDS ##################### */

	@Keyword
	def verifyRecordsCount(TestObject tableLocator, int expCount) {
		WebElement table = WebUtil.getWebElement(tableLocator)
		List<WebElement> rows = getAllRows(table)
		int actCount = rows.size()
		WebUI.verifyEqual(actCount, expCount)
		WebUI.switchToDefaultContent()
	}

	@Keyword
	def verifyRecordPresentInColumn(TestObject tableLocator, int colNo, String expValue) {

		if(isRecordPresentInColumn(tableLocator, colNo, expValue)) {
			KeywordUtil.markPassed('Record found in table')
		}
		else {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop('Record not found in table')
		}
	}

	@Keyword
	def isRecordPresentInColumn(TestObject tableLocator, int colNo, String expValue) {
		WebElement table = WebUtil.getWebElement(tableLocator)
		List<String> cellValues = getAllValuesFromColumn(table, colNo)
		WebUI.switchToDefaultContent()

		boolean isRecordPresent = false
		if(cellValues.size() == 0) {
			println "No Records are available for comparison"
			return false
		}

		if(StringUtils.isBlank(expValue)) {
			println "Search values provided is blank"
			return false
		}

		if(cellValues.contains(expValue)) {
			println "Value "+expValue+" found in column No : "+colNo
			return true
		}
		else {
			println "Value "+expValue+" not found in column No : "+colNo
			return false
		}
	}

	@Keyword
	def verifyRecordNotPresentInColumn(TestObject tableLocator, int colNo, String expValue) {

		if(isRecordNotPresentInColumn(tableLocator, colNo, expValue)) {
			KeywordUtil.markPassed('Record not found in table')
		}
		else {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop('Record found in table')
		}
	}

	@Keyword
	def isRecordNotPresentInColumn(TestObject tableLocator, int colNo, String expValue) {
		WebElement table = WebUtil.getWebElement(tableLocator)
		List<String> cellValues = getAllValuesFromColumn(table, colNo)
		WebUI.switchToDefaultContent()

		if(cellValues.size() == 0) {
			println "No Records are available for comparison"
			return true
		}

		if(StringUtils.isBlank(expValue)) {
			println "Search values provided is blank"
			return false
		}

		if(cellValues.contains(expValue)) {
			println "Value "+expValue+" found in column No : "+colNo
			return false
		}
		else {
			println "Value "+expValue+" not found in column No : "+colNo
			return true
		}
	}

	@Keyword
	def verifyColumnIsSortedInteger(TestObject tableLocator, int colNo, String sortOrder) {
		WebElement table = WebUtil.getWebElement(tableLocator)
		List<Integer> actList = getAllValueFromColumnInteger(table, colNo)

		if(actList.size() == 0) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop('No records available.')
		}

		List<Integer> expList = actList.collect{it}
		WebUI.switchToDefaultContent()

		Collections.sort(expList)
		if(sortOrder.equalsIgnoreCase('DESC'))
			Collections.reverse(expList)
		compareTwoLists(actList, expList)
	}

	@Keyword
	def verifyDateFilter(TestObject tableLocator, int colNo, String filterValue1, String filterValue2, String operator) {
		WebElement table = WebUtil.getWebElement(tableLocator)
		List<String> cellValues = getAllValuesFromColumn(table, colNo)
		WebUI.switchToDefaultContent()

		if(cellValues.size() == 0) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop('No records available for comparison.')
		}

		boolean result

		for(String value in cellValues) {
			result = DateUtil.dateFilter(operator, value, filterValue1, filterValue2)
			if(!result) {
				WebUI.takeScreenshot()
				KeywordUtil.markFailedAndStop("Value : "+value+" does not satisfy filter criteria")
			}
		}
	}

	@Keyword
	def verifyDateTimeFilter(TestObject tableLocator, int colNo, String filterValue1, String filterValue2, String operator) {
		WebElement table = WebUtil.getWebElement(tableLocator)
		List<String> cellValues = getAllValuesFromColumn(table, colNo)
		WebUI.switchToDefaultContent()

		if(cellValues.size() == 0) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop('No records available for comparison.')
		}

		boolean result

		for(String value in cellValues) {
			result = DateUtil.dateTimeFilter(operator, value, filterValue1, filterValue2)
			if(!result) {
				WebUI.takeScreenshot()
				KeywordUtil.markFailedAndStop("Value : "+value+" does not satisfy filter criteria")
			}
		}
	}


	@Keyword
	def verifyFilter(TestObject tableLocator, int colNo, int referenceNum,String operator) {
		WebElement table = WebUtil.getWebElement(tableLocator)
		List<String> cellValues = getAllValuesFromColumn(table, colNo)
		WebUI.switchToDefaultContent()

		if(cellValues.size() == 0) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop('No records available for comparison.')
		}

		for(String value in cellValues) {
			boolean result = verifyFilter(operator, Integer.parseInt(value), referenceNum)
			if(!result) {
				WebUI.takeScreenshot()
				KeywordUtil.markFailedAndStop("Value : "+value+" does not satisfy filter criteria")
			}
		}
	}

	@Keyword
	def verifyAllValuesInColumnMatches(TestObject tableLocator, int colNo, String expValue) {
		WebElement table = WebUtil.getWebElement(tableLocator)
		List<String> cellValues = getAllValuesFromColumn(table, colNo)
		WebUI.switchToDefaultContent()

		if(cellValues.size() == 0) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop('No records available for comparison.')
		}

		for(String value in cellValues) {
			if(!expValue.trim().equalsIgnoreCase(value.trim())) {
				WebUI.takeScreenshot()
				KeywordUtil.markFailedAndStop("Record does not match the expected value in one of the row. Expected Value = "+expValue+" Actual Value ="+value)
			}
		}
	}

	@Keyword
	def getCellText(TestObject tableLocator, int rowNo, int colNo) {
		WebElement table = WebUtil.getWebElement(tableLocator)
		List<WebElement> rows = getAllRows(table)
		List<WebElement> cells = getAllCells(rows.get(rowNo-1))
		WebElement cell = cells.get(colNo-1)
		String value = cell.getText()
		WebUI.switchToDefaultContent()
		return value
	}

	@Keyword
	def checkRecordInTable(TestObject tableLocator, int rowNo) {
		WebElement table = WebUtil.getWebElement(tableLocator)
		List<WebElement> rows = getAllRows(table)
		List<WebElement> cells = getAllCells(rows.get(rowNo-1))
		WebElement cell = cells.get(0)
		WebElement checkboxField = cell.findElement(By.tagName("input"))
		if(!checkboxField.isSelected())
			cell.click()
		WebUI.switchToDefaultContent()
	}

	@Keyword
	def uncheckRecordInTable(TestObject tableLocator, int rowNo) {
		WebElement table = WebUtil.getWebElement(tableLocator)
		List<WebElement> rows = getAllRows(table)
		List<WebElement> cells = getAllCells(rows.get(rowNo-1))
		WebElement cell = cells.get(0)
		WebElement checkboxField = cell.findElement(By.tagName("input"))
		if(checkboxField.isSelected())
			cell.click()
		WebUI.switchToDefaultContent()
	}

	@Keyword
	def verifyAllRecordsAreChecked(TestObject tableLocator) {
		WebElement table = WebUtil.getWebElement(tableLocator)
		List<WebElement> rows = getAllRows(table)
		boolean isAllSelected = true
		int failedRowNo
		for(int i = 0; i < rows.size(); i++) {
			List<WebElement> cells = getAllCells(rows.get(i))
			WebElement cell = cells.get(0)
			WebElement checkboxField = cell.findElement(By.tagName("input"))
			if(!checkboxField.isSelected()) {
				isAllSelected = false
				failedRowNo = i+1
				break;
			}
		}

		if(isAllSelected) {
			KeywordUtil.markPassed('All Records are selected')
		}
		else {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop('Record at row no '+failedRowNo+' is not selected')
		}
	}

	@Keyword
	def clickColumnHeader(TestObject tableHeaderLocator, String columnName) {

		TestObject parentObject = tableHeaderLocator.getParentObject()

		WebElement table = WebUtil.getWebElement(tableHeaderLocator)
		List<WebElement> headers = getAllHeaders(table)

		boolean isColumnClicked = false
		for(int i = 0; i < headers.size() ; i++) {

			WebDriver driver = DriverFactory.getWebDriver()
			Actions aDriver = new Actions(driver)
			aDriver.moveToElement(headers[i]).build().perform()

			String actColumnName = headers[i].getText().replace('\u00A0',' ').trim()

			if(StringUtils.isNotEmpty(actColumnName) && actColumnName.equalsIgnoreCase(columnName)) {
				headers[i].click()
				isColumnClicked = true
				break
			}
		}

		WebUI.switchToDefaultContent()

		if(isColumnClicked) {
			if(parentObject != null) {
				new Common().waitForFrameToLoad(parentObject)
			}
			KeywordUtil.markPassed('Column clicked')
		}
		else {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop('Column '+columnName+' not found')
		}
	}

	@Keyword
	def getColumnNumber(TestObject headerTable, String columnName) {
		WebElement table = WebUtil.getWebElement(headerTable)
		List<WebElement> headers = getAllHeaders(table)
		int columnNo = getColumnNumberOfHeader(headers, columnName)
		WebUI.switchToDefaultContent()
		return columnNo
	}

	@Keyword
	def verifyCellContainsValue(TestObject tableLocator, int rowNo, int colNo, String expText) {
		WebElement table = WebUtil.getWebElement(tableLocator)
		List<WebElement> rows = getAllRows(table)
		List<WebElement> cells = getAllCells(rows.get(rowNo-1))
		WebElement cell = cells.get(colNo-1)
		String actText = cell.getText().trim()
		WebUI.switchToDefaultContent()
		if(actText.contains(expText)) {
			KeywordUtil.markPassed('Expected String '+expText+' is found in actual String '+actText)
		}
		else {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop('Expected String '+expText+' is not found in actual String '+actText)
		}
	}

	@Keyword
	def clickCell(TestObject tableLocator, int rowNo, int colNo) {

		WebElement table = WebUtil.getWebElement(tableLocator)
		List<WebElement> rows = getAllRows(table)
		List<WebElement> cells = getAllCells(rows.get(rowNo-1))
		WebElement cell = cells.get(colNo-1)
		cell.click()
		WebUI.switchToDefaultContent()
	}

	@Keyword
	def verifyRecordsWithinRange(TestObject tableLocator, int colNo, double fromValue, double toValue) {
		WebElement table = WebUtil.getWebElement(tableLocator)
		List<String> cellValues = getAllValuesFromColumn(table, colNo)
		WebUI.switchToDefaultContent()

		if(cellValues.size() == 0) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop('No records available for comparison.')
		}

		for(String value in cellValues) {
			value=value.replaceAll('\\$','').replaceAll(',', '')

			int actualValue=Double.parseDouble(value)
			if(actualValue<fromValue || actualValue>toValue) {
				WebUI.takeScreenshot()
				KeywordUtil.markFailedAndStop("Value : "+value+" is not within  range : "+fromValue+" - "+toValue)
			}
		}
		KeywordUtil.markPassed("all the records values are in given range")
	}

	@Keyword
	def verifyDateTimeIsSorted(TestObject tableLocator, int colNo,String sortOrder) {
		WebElement table = WebUtil.getWebElement(tableLocator)
		List<String> cellValues = getAllValuesFromColumn(table, colNo)
		WebUI.switchToDefaultContent()

		if(cellValues.size() == 0) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop('No records available for comparison.')
		}

		if(sortOrder.equalsIgnoreCase('asc'))
			for(int i=0;i<cellValues.size()-1;i++){
				boolean result = DateUtil.dateTimeFilter('<', cellValues[i], cellValues[i+1], '')
				if(!result) {
					WebUI.takeScreenshot()
					KeywordUtil.markFailedAndStop("table records are not sorted")
				}

			}
		else
			for(int i=0;i<cellValues.size()-1;i++){
				boolean result = DateUtil.dateTimeFilter('>', cellValues[i], cellValues[i+1], '')
				if(!result) {
					WebUI.takeScreenshot()
					KeywordUtil.markFailedAndStop("table records are not sorted")
				}
			}
		KeywordUtil.markPassed("table records are sorted")
	}

	@Keyword
	def getRowsCount(TestObject tableLocator) {
		WebElement table = WebUtil.getWebElement(tableLocator)
		List<WebElement> rows = getAllRows(table)

		WebUI.switchToDefaultContent()

		return rows.size()
	}

	/*
	 * Keywords for WMI Table
	 */

	@Keyword
	def verifyButtonPresentInWMITable(TestObject tableLocator, String expTitleAttr) {

		WebElement table = WebUtil.getWebElement(tableLocator)
		List<WebElement> icons = table.findElements(By.xpath("./tbody/tr[1]//input"))


		boolean isIconFound = false

		for(WebElement icon in icons) {
			String actTitle = icon.getAttribute('title').toUpperCase()
			if(actTitle.contains(expTitleAttr.toUpperCase())) {
				isIconFound = true
				break
			}
		}

		WebUI.switchToDefaultContent()
		if(isIconFound) {
			KeywordUtil.markPassed('Icon found in table')
		}
		else {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop('Icon not found in table')
		}
	}

	@Keyword
	def verifyButtonNotPresentInWMITable(TestObject tableLocator, String expTitleAttr) {

		WebElement table = WebUtil.getWebElement(tableLocator)
		WebDriver driver = DriverFactory.getWebDriver()
		List<WebElement> icons = table.findElements(By.xpath("./tbody/tr[1]//input"))

		boolean isIconFound = false

		for(WebElement icon in icons) {
			String actTitle = icon.getAttribute('title').toUpperCase()
			if(actTitle.contains(expTitleAttr.toUpperCase())) {
				isIconFound = true
				break
			}
		}
		WebUI.switchToDefaultContent()
		if(!isIconFound) {
			KeywordUtil.markPassed('Icon not found in table')
		}
		else {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop('Icon found in table')
		}
	}

	@Keyword
	def getRowNumber(TestObject tableLocator, int colNo, String expText) {

		WebElement table = WebUtil.getWebElement(tableLocator)
		List<WebElement> rows = getAllRows(table)
		int i = 1
		boolean isRowFound = false
		for(WebElement row in rows) {
			List<WebElement> cells = getAllCells(rows.get(i-1))
			WebElement cell = cells.get(colNo-1)
			if(cell.getText().trim().equalsIgnoreCase(expText.trim())) {
				isRowFound = true
				break
			}
			i++
		}
		WebUI.switchToDefaultContent()
		if(isRowFound) {
			return i
		}
		else {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop('Expected Row not found')
		}
	}

	def isCellDisplaysLockIcon(TestObject tableLocator, WebElement row, int colNo) {

		List<WebElement> cells = getAllCells(row)
		WebElement cell = cells.get(colNo-1)

		Boolean isIconDisplayed = false
		try {
			cell.findElement(By.xpath("./img[contains(@title,'Checked Out')]")).isDisplayed()
			isIconDisplayed = true
		}
		catch(Exception e) {
			isIconDisplayed = false
		}
		return isIconDisplayed
	}

	@Keyword
	def verifyCellDisplaysLockIcon(TestObject tableLocator, int rowNo, int colNo) {

		WebElement table = WebUtil.getWebElement(tableLocator)
		List<WebElement> rows = getAllRows(table)

		if(isCellDisplaysLockIcon(tableLocator, rows.get(rowNo-1), colNo)) {
			KeywordUtil.markPassed('Lock icon is displayed')
		}
		else {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop('Lock icon is not displayed')
		}
		WebUI.switchToDefaultContent()
	}

	@Keyword
	def verifyCellDoesNotDisplaysLockIcon(TestObject tableLocator, int rowNo, int colNo) {

		WebElement table = WebUtil.getWebElement(tableLocator)
		List<WebElement> rows = getAllRows(table)

		if(!isCellDisplaysLockIcon(tableLocator, rows.get(rowNo-1), colNo)) {
			KeywordUtil.markPassed('Lock icon is not displayed')
		}
		else {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop('Lock icon displayed')
		}
		WebUI.switchToDefaultContent()
	}

	@Keyword
	def verifyAllRecordsDisplayLockIcon(TestObject tableLocator, int colNo) {

		WebElement table = WebUtil.getWebElement(tableLocator)
		List<WebElement> rows = getAllRows(table)

		int rowNo = 1
		for(WebElement row in rows) {
			if(!isCellDisplaysLockIcon(tableLocator, row, colNo)) {
				WebUI.takeScreenshot()
				KeywordUtil.markFailedAndStop('Lock icon not present in rowNo '+rowNo)
			}
			rowNo++
		}
		WebUI.switchToDefaultContent()

		if(rowNo == 1) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop('No record available in result table for verification')
		}
		else {
			KeywordUtil.markPassed('All records contains lock icon')
		}
	}

	@Keyword
	def verifyAllRecordsDoesNotDisplayLockIcon(TestObject tableLocator, int colNo) {

		WebElement table = WebUtil.getWebElement(tableLocator)
		List<WebElement> rows = getAllRows(table)

		int rowNo = 1
		for(WebElement row in rows) {
			if(isCellDisplaysLockIcon(tableLocator, row, colNo)) {
				WebUI.takeScreenshot()
				KeywordUtil.markFailedAndStop('Lock icon present in rowNo '+rowNo)
			}
			rowNo++
		}
		WebUI.switchToDefaultContent()

		if(rowNo == 1) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop('No record available in result table for verification')
		}
		else {
			KeywordUtil.markPassed('All records does not contains lock icon')
		}
	}

	@Keyword
	def verifyAttributeValueOfAllRows(TestObject tableLocator, String attrName, String attrValue) {

		WebElement table = WebUtil.getWebElement(tableLocator)
		List<WebElement> rows = getAllRows(table)

		boolean isMatches = false
		String actAttrValue

		for(WebElement row in rows) {
			actAttrValue = row.getAttribute(attrName)

			if(actAttrValue.equalsIgnoreCase(attrValue)) {
				isMatches = true
			}
			else {
				isMatches = false
				break
			}
		}

		WebUI.switchToDefaultContent()

		if(isMatches) {
			KeywordUtil.markPassed('Attribute value for all row matches')
		}
		else {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop('Actual value = '+actAttrValue+' does not matches with expected value = '+attrValue)
		}
	}

	@Keyword
	def verifyAttributeValueOfRow(TestObject tableLocator, int rowNo, String attrName, String attrValue) {

		WebElement table = WebUtil.getWebElement(tableLocator)
		List<WebElement> rows = getAllRows(table)

		WebElement row = rows.get(rowNo-1)
		String actAttrValue = row.getAttribute(attrName)
		WebUI.switchToDefaultContent()

		if(actAttrValue.equalsIgnoreCase(attrValue)) {
			KeywordUtil.markPassed('Attribute value matches')
		}
		else {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop('Actual value = '+actAttrValue+' does not matches with expected value = '+attrValue)
		}
	}

	@Keyword
	def getCorrectSliceNumber(TestObject tableLocator, int colNoTotal, int colNoText, String expText) {

		WebElement table = WebUtil.getWebElement(tableLocator)
		List<WebElement> rows = getAllRows(table)

		int i = 1
		boolean isRowFound = false

		for(WebElement row in rows) {
			List<WebElement> cells = getAllCells(row)
			int cellTotal = Integer.parseInt(cells.get(colNoTotal - 1).getText())
			String cellText = cells.get(colNoText - 1).getText()

			if(cellTotal > 0) {
				if(cellText.trim().equalsIgnoreCase(expText)) {
					isRowFound = true
					break
				}
				i++
			}
		}

		WebUI.switchToDefaultContent()
		if(isRowFound) {
			return i
		}
		else {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop('Expected row not found in table')
		}
	}

	@Keyword
	def refreshUntilRecordFoundInTable(TestObject table, TestObject tableHeader, TestObject refresh, String expText, int colNo, int timeout) {

		def startTime = System.currentTimeMillis()
		def endTime = startTime + TimeUnit.SECONDS.toMillis(timeout)
		def currentTime = System.currentTimeMillis()

		boolean isFound = false
		TestObject parentObject = table.getParentObject()

		while(currentTime < endTime) {

			//Sort records by Doc ID descending
			clickColumnHeader(tableHeader, 'Doc ID')
			clickColumnHeader(tableHeader, 'Doc ID')

			if(!isRecordPresentInColumn(table, colNo, expText)) {
				WebUI.delay(5)
				WebUI.click(refresh)
				new Common().waitForFrameToLoad(parentObject)
				currentTime = System.currentTimeMillis()
			}
			else {
				isFound = true
				break
			}
		}

		if(isFound) {
			KeywordUtil.markPassed('Record found in grid after refreshed')
		}
		else {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop('Record '+expText+' not found in grid')
		}
	}
}