
/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */

import java.lang.String

import com.kms.katalon.core.testobject.TestObject

import java.util.List

import java.lang.Boolean


def static "actions.Calender.selectDate"(
    	String date	
     , 	String month	
     , 	String year	
     , 	TestObject element	) {
    (new actions.Calender()).selectDate(
        	date
         , 	month
         , 	year
         , 	element)
}

def static "actions.Calender.selectDateTime"(
    	String date	
     , 	String month	
     , 	String year	
     , 	TestObject element	) {
    (new actions.Calender()).selectDateTime(
        	date
         , 	month
         , 	year
         , 	element)
}

def static "actions.Table.verifyRecordsCount"(
    	TestObject tableLocator	
     , 	int expCount	) {
    (new actions.Table()).verifyRecordsCount(
        	tableLocator
         , 	expCount)
}

def static "actions.Table.verifyRecordPresentInColumn"(
    	TestObject tableLocator	
     , 	int colNo	
     , 	String expValue	) {
    (new actions.Table()).verifyRecordPresentInColumn(
        	tableLocator
         , 	colNo
         , 	expValue)
}

def static "actions.Table.isRecordPresentInColumn"(
    	TestObject tableLocator	
     , 	int colNo	
     , 	String expValue	) {
    (new actions.Table()).isRecordPresentInColumn(
        	tableLocator
         , 	colNo
         , 	expValue)
}

def static "actions.Table.verifyRecordNotPresentInColumn"(
    	TestObject tableLocator	
     , 	int colNo	
     , 	String expValue	) {
    (new actions.Table()).verifyRecordNotPresentInColumn(
        	tableLocator
         , 	colNo
         , 	expValue)
}

def static "actions.Table.isRecordNotPresentInColumn"(
    	TestObject tableLocator	
     , 	int colNo	
     , 	String expValue	) {
    (new actions.Table()).isRecordNotPresentInColumn(
        	tableLocator
         , 	colNo
         , 	expValue)
}

def static "actions.Table.verifyColumnIsSortedInteger"(
    	TestObject tableLocator	
     , 	int colNo	
     , 	String sortOrder	) {
    (new actions.Table()).verifyColumnIsSortedInteger(
        	tableLocator
         , 	colNo
         , 	sortOrder)
}

def static "actions.Table.verifyDateFilter"(
    	TestObject tableLocator	
     , 	int colNo	
     , 	String filterValue1	
     , 	String filterValue2	
     , 	String operator	) {
    (new actions.Table()).verifyDateFilter(
        	tableLocator
         , 	colNo
         , 	filterValue1
         , 	filterValue2
         , 	operator)
}

def static "actions.Table.verifyDateTimeFilter"(
    	TestObject tableLocator	
     , 	int colNo	
     , 	String filterValue1	
     , 	String filterValue2	
     , 	String operator	) {
    (new actions.Table()).verifyDateTimeFilter(
        	tableLocator
         , 	colNo
         , 	filterValue1
         , 	filterValue2
         , 	operator)
}

def static "actions.Table.verifyFilter"(
    	TestObject tableLocator	
     , 	int colNo	
     , 	int referenceNum	
     , 	String operator	) {
    (new actions.Table()).verifyFilter(
        	tableLocator
         , 	colNo
         , 	referenceNum
         , 	operator)
}

def static "actions.Table.verifyAllValuesInColumnMatches"(
    	TestObject tableLocator	
     , 	int colNo	
     , 	String expValue	) {
    (new actions.Table()).verifyAllValuesInColumnMatches(
        	tableLocator
         , 	colNo
         , 	expValue)
}

def static "actions.Table.getCellText"(
    	TestObject tableLocator	
     , 	int rowNo	
     , 	int colNo	) {
    (new actions.Table()).getCellText(
        	tableLocator
         , 	rowNo
         , 	colNo)
}

def static "actions.Table.checkRecordInTable"(
    	TestObject tableLocator	
     , 	int rowNo	) {
    (new actions.Table()).checkRecordInTable(
        	tableLocator
         , 	rowNo)
}

def static "actions.Table.uncheckRecordInTable"(
    	TestObject tableLocator	
     , 	int rowNo	) {
    (new actions.Table()).uncheckRecordInTable(
        	tableLocator
         , 	rowNo)
}

def static "actions.Table.verifyAllRecordsAreChecked"(
    	TestObject tableLocator	) {
    (new actions.Table()).verifyAllRecordsAreChecked(
        	tableLocator)
}

def static "actions.Table.clickColumnHeader"(
    	TestObject column	) {
    (new actions.Table()).clickColumnHeader(
        	column)
}

def static "actions.Table.clickColumnHeader"(
    	TestObject tableHeaderLocator	
     , 	String columnName	) {
    (new actions.Table()).clickColumnHeader(
        	tableHeaderLocator
         , 	columnName)
}

def static "actions.Table.getColumnNumber"(
    	TestObject headerTable	
     , 	String columnName	) {
    (new actions.Table()).getColumnNumber(
        	headerTable
         , 	columnName)
}

def static "actions.Table.verifyCellContainsValue"(
    	TestObject tableLocator	
     , 	int rowNo	
     , 	int colNo	
     , 	String expText	) {
    (new actions.Table()).verifyCellContainsValue(
        	tableLocator
         , 	rowNo
         , 	colNo
         , 	expText)
}

def static "actions.Table.clickCell"(
    	TestObject tableLocator	
     , 	int rowNo	
     , 	int colNo	) {
    (new actions.Table()).clickCell(
        	tableLocator
         , 	rowNo
         , 	colNo)
}

def static "actions.Table.verifyRecordsWithinRange"(
    	TestObject tableLocator	
     , 	int colNo	
     , 	double fromValue	
     , 	double toValue	) {
    (new actions.Table()).verifyRecordsWithinRange(
        	tableLocator
         , 	colNo
         , 	fromValue
         , 	toValue)
}

def static "actions.Table.verifyDateTimeIsSorted"(
    	TestObject tableLocator	
     , 	int colNo	
     , 	String sortOrder	) {
    (new actions.Table()).verifyDateTimeIsSorted(
        	tableLocator
         , 	colNo
         , 	sortOrder)
}

def static "actions.Table.getRowsCount"(
    	TestObject tableLocator	) {
    (new actions.Table()).getRowsCount(
        	tableLocator)
}

def static "actions.Table.verifyButtonPresentInWMITable"(
    	TestObject tableLocator	
     , 	String expTitleAttr	) {
    (new actions.Table()).verifyButtonPresentInWMITable(
        	tableLocator
         , 	expTitleAttr)
}

def static "actions.Table.verifyButtonNotPresentInWMITable"(
    	TestObject tableLocator	
     , 	String expTitleAttr	) {
    (new actions.Table()).verifyButtonNotPresentInWMITable(
        	tableLocator
         , 	expTitleAttr)
}

def static "actions.Table.getRowNumber"(
    	TestObject tableLocator	
     , 	int colNo	
     , 	String expText	) {
    (new actions.Table()).getRowNumber(
        	tableLocator
         , 	colNo
         , 	expText)
}

def static "actions.Table.verifyCellDisplaysLockIcon"(
    	TestObject tableLocator	
     , 	int rowNo	
     , 	int colNo	) {
    (new actions.Table()).verifyCellDisplaysLockIcon(
        	tableLocator
         , 	rowNo
         , 	colNo)
}

def static "actions.Table.verifyCellDoesNotDisplaysLockIcon"(
    	TestObject tableLocator	
     , 	int rowNo	
     , 	int colNo	) {
    (new actions.Table()).verifyCellDoesNotDisplaysLockIcon(
        	tableLocator
         , 	rowNo
         , 	colNo)
}

def static "actions.Table.verifyAllRecordsDisplayLockIcon"(
    	TestObject tableLocator	
     , 	int colNo	) {
    (new actions.Table()).verifyAllRecordsDisplayLockIcon(
        	tableLocator
         , 	colNo)
}

def static "actions.Table.verifyAllRecordsDoesNotDisplayLockIcon"(
    	TestObject tableLocator	
     , 	int colNo	) {
    (new actions.Table()).verifyAllRecordsDoesNotDisplayLockIcon(
        	tableLocator
         , 	colNo)
}

def static "actions.Table.verifyAttributeValueOfAllRows"(
    	TestObject tableLocator	
     , 	String attrName	
     , 	String attrValue	) {
    (new actions.Table()).verifyAttributeValueOfAllRows(
        	tableLocator
         , 	attrName
         , 	attrValue)
}

def static "actions.Table.verifyAttributeValueOfRow"(
    	TestObject tableLocator	
     , 	int rowNo	
     , 	String attrName	
     , 	String attrValue	) {
    (new actions.Table()).verifyAttributeValueOfRow(
        	tableLocator
         , 	rowNo
         , 	attrName
         , 	attrValue)
}

def static "actions.Table.getCorrectSliceNumber"(
    	TestObject tableLocator	
     , 	int colNoTotal	
     , 	int colNoText	
     , 	String expText	) {
    (new actions.Table()).getCorrectSliceNumber(
        	tableLocator
         , 	colNoTotal
         , 	colNoText
         , 	expText)
}

def static "actions.Table.refreshUntilRecordFoundInTable"(
    	TestObject table	
     , 	TestObject tableHeader	
     , 	TestObject refresh	
     , 	String expText	
     , 	int colNo	
     , 	int timeout	) {
    (new actions.Table()).refreshUntilRecordFoundInTable(
        	table
         , 	tableHeader
         , 	refresh
         , 	expText
         , 	colNo
         , 	timeout)
}

def static "actions.MenuBar.getRecordCountInActivity"(
    	TestObject element	) {
    (new actions.MenuBar()).getRecordCountInActivity(
        	element)
}

def static "actions.MenuBar.refreshActivityUntilRecordCountIncreases"(
    	int originalCount	
     , 	int timeout	
     , 	String moduleName	
     , 	String[] modulePath	) {
    (new actions.MenuBar()).refreshActivityUntilRecordCountIncreases(
        	originalCount
         , 	timeout
         , 	moduleName
         , 	modulePath)
}

def static "actions.MenuBar.getAllSubMenu"(
    	TestObject menu	) {
    (new actions.MenuBar()).getAllSubMenu(
        	menu)
}

def static "actions.MenuBar.getAllSubMenus"(
    	String moduleName	
     , 	String[] menuPath	) {
    (new actions.MenuBar()).getAllSubMenus(
        	moduleName
         , 	menuPath)
}

def static "actions.MenuBar.verifyAllSubmenuAreSortedByActivityCount"(
    	java.util.List<String> subMenus	
     , 	String sortOrder	) {
    (new actions.MenuBar()).verifyAllSubmenuAreSortedByActivityCount(
        	subMenus
         , 	sortOrder)
}

def static "actions.MenuBar.verifyAllSubmenuAreSortedByActivityName"(
    	java.util.List<String> subMenus	
     , 	String sortOrder	) {
    (new actions.MenuBar()).verifyAllSubmenuAreSortedByActivityName(
        	subMenus
         , 	sortOrder)
}

def static "actions.MenuBar.clickTreeMenu"(
    	String moduleName	
     , 	String[] menuPath	) {
    (new actions.MenuBar()).clickTreeMenu(
        	moduleName
         , 	menuPath)
}

def static "actions.MenuBar.doubleClickTreeMenu"(
    	String moduleName	
     , 	String[] menuPath	) {
    (new actions.MenuBar()).doubleClickTreeMenu(
        	moduleName
         , 	menuPath)
}

def static "actions.MenuBar.rightClickTreeMenu"(
    	String moduleName	
     , 	String[] menuPath	) {
    (new actions.MenuBar()).rightClickTreeMenu(
        	moduleName
         , 	menuPath)
}

def static "actions.MenuBar.getRecordCountInActivity"(
    	String moduleName	
     , 	String[] menuPath	) {
    (new actions.MenuBar()).getRecordCountInActivity(
        	moduleName
         , 	menuPath)
}

def static "actions.MenuBar.verifyAllActivityNamesAreValidDate"(
    	String moduleName	
     , 	String dateFormat	
     , 	String[] menuPath	) {
    (new actions.MenuBar()).verifyAllActivityNamesAreValidDate(
        	moduleName
         , 	dateFormat
         , 	menuPath)
}

def static "actions.MenuBar.verifySubMenuPresent"(
    	String moduleName	
     , 	String expMenu	
     , 	String[] menuPath	) {
    (new actions.MenuBar()).verifySubMenuPresent(
        	moduleName
         , 	expMenu
         , 	menuPath)
}

def static "actions.MenuBar.isSubMenuPresent"(
    	String moduleName	
     , 	String expMenu	
     , 	String[] menuPath	) {
    (new actions.MenuBar()).isSubMenuPresent(
        	moduleName
         , 	expMenu
         , 	menuPath)
}

def static "actions.MenuBar.verifyTreeIsSelected"(
    	String moduleName	
     , 	String[] menuPath	) {
    (new actions.MenuBar()).verifyTreeIsSelected(
        	moduleName
         , 	menuPath)
}

def static "actions.MenuBar.verifyTreeDoesNotHaveExpandIcon"(
    	String moduleName	
     , 	String[] menuPath	) {
    (new actions.MenuBar()).verifyTreeDoesNotHaveExpandIcon(
        	moduleName
         , 	menuPath)
}

def static "actions.OCR.readTextFromImage"(
    	String imgPath	) {
    (new actions.OCR()).readTextFromImage(
        	imgPath)
}

def static "actions.Report.clickReport"(
    	String lvl_one	
     , 	String lvl_two	
     , 	String lvl_three	) {
    (new actions.Report()).clickReport(
        	lvl_one
         , 	lvl_two
         , 	lvl_three)
}

def static "actions.Report.rightClickReport"(
    	String lvl_one	
     , 	String lvl_two	
     , 	String lvl_three	) {
    (new actions.Report()).rightClickReport(
        	lvl_one
         , 	lvl_two
         , 	lvl_three)
}

def static "actions.Report.verifyReportIsPresentUnderSubGroup"(
    	String lvl_one	
     , 	String lvl_two	
     , 	String reportName	) {
    (new actions.Report()).verifyReportIsPresentUnderSubGroup(
        	lvl_one
         , 	lvl_two
         , 	reportName)
}

def static "actions.Report.verifyReportIsNotPresentUnderSubGroup"(
    	String lvl_one	
     , 	String lvl_two	
     , 	String reportName	) {
    (new actions.Report()).verifyReportIsNotPresentUnderSubGroup(
        	lvl_one
         , 	lvl_two
         , 	reportName)
}

def static "actions.Report.verifySubGroupIsPresentUnderGroup"(
    	String lvl_one	
     , 	String subGroupName	) {
    (new actions.Report()).verifySubGroupIsPresentUnderGroup(
        	lvl_one
         , 	subGroupName)
}

def static "actions.Report.verifySubGroupIsNotPresentUnderGroup"(
    	String lvl_one	
     , 	String subGroupName	) {
    (new actions.Report()).verifySubGroupIsNotPresentUnderGroup(
        	lvl_one
         , 	subGroupName)
}

def static "actions.Report.verifyAllReportsUnderSubGroup"(
    	String lvl_one	
     , 	String lvl_two	
     , 	String[] reportNames	) {
    (new actions.Report()).verifyAllReportsUnderSubGroup(
        	lvl_one
         , 	lvl_two
         , 	reportNames)
}

def static "actions.Report.verifyAllSubGroupsUnderGroup"(
    	String lvl_one	
     , 	String[] subGroups	) {
    (new actions.Report()).verifyAllSubGroupsUnderGroup(
        	lvl_one
         , 	subGroups)
}

def static "actions.Report.verifyReportIsLoaded"(
    	String tabName	
     , 	String reportName	
     , 	String reportDescription	) {
    (new actions.Report()).verifyReportIsLoaded(
        	tabName
         , 	reportName
         , 	reportDescription)
}

def static "actions.Report.verifyDesignPageIsLoaded"(
    	String expectedDataSource	) {
    (new actions.Report()).verifyDesignPageIsLoaded(
        	expectedDataSource)
}

def static "apis.UserManagement.updateUserManagement"(
    	int userId	
     , 	String password	
     , 	String pwdChangedDate	
     , 	String lastLoginDate	
     , 	int invalidLoginCount	
     , 	boolean pwdNeverExpires	
     , 	boolean mustChangePwd	) {
    (new apis.UserManagement()).updateUserManagement(
        	userId
         , 	password
         , 	pwdChangedDate
         , 	lastLoginDate
         , 	invalidLoginCount
         , 	pwdNeverExpires
         , 	mustChangePwd)
}

def static "apis.UserManagement.updatePasswordForUser"(
    	int userId	
     , 	String password	) {
    (new apis.UserManagement()).updatePasswordForUser(
        	userId
         , 	password)
}

def static "apis.UserManagement.updateLastLoginDate"(
    	int userId	
     , 	String date	) {
    (new apis.UserManagement()).updateLastLoginDate(
        	userId
         , 	date)
}

def static "actions.Common.maximizeWindow"() {
    (new actions.Common()).maximizeWindow()
}

def static "actions.Common.login"() {
    (new actions.Common()).login()
}

def static "actions.Common.login"(
    	String username	
     , 	String password	
     , 	String database	) {
    (new actions.Common()).login(
        	username
         , 	password
         , 	database)
}

def static "actions.Common.killDriverProcesses"() {
    (new actions.Common()).killDriverProcesses()
}

def static "actions.Common.verifyRecordCountInActivityMatchesWithResultGrid"(
    	TestObject activityFolder	
     , 	TestObject resultGridPageSummary	) {
    (new actions.Common()).verifyRecordCountInActivityMatchesWithResultGrid(
        	activityFolder
         , 	resultGridPageSummary)
}

def static "actions.Common.waitForReportToLoad"(
    	int timeout	) {
    (new actions.Common()).waitForReportToLoad(
        	timeout)
}

def static "actions.Common.waitForFrameToLoad"(
    	TestObject iFrame	) {
    (new actions.Common()).waitForFrameToLoad(
        	iFrame)
}

def static "actions.Common.dragAndDropByXOffset"(
    	TestObject to	
     , 	int xOffset	) {
    (new actions.Common()).dragAndDropByXOffset(
        	to
         , 	xOffset)
}

def static "actions.Common.selectDocClassAndDocTypeForGlobalNew"(
    	String docClass	
     , 	String docType	) {
    (new actions.Common()).selectDocClassAndDocTypeForGlobalNew(
        	docClass
         , 	docType)
}

def static "actions.Common.createDocument_WMIMenuBovVertical"() {
    (new actions.Common()).createDocument_WMIMenuBovVertical()
}

def static "actions.Common.openDocumentFromRecentGrid"(
    	String documentTitle	) {
    (new actions.Common()).openDocumentFromRecentGrid(
        	documentTitle)
}

def static "actions.Common.clearClipBoard"() {
    (new actions.Common()).clearClipBoard()
}

def static "actions.Common.clickMultipleElements"(
    	java.util.List<TestObject> elements	) {
    (new actions.Common()).clickMultipleElements(
        	elements)
}

def static "actions.Common.verifyRecordCountMatchesInActivityAndGrid"(
    	TestObject activity	
     , 	TestObject gridSummary	) {
    (new actions.Common()).verifyRecordCountMatchesInActivityAndGrid(
        	activity
         , 	gridSummary)
}

def static "actions.Common.verifyElementAttributeValueContains"(
    	TestObject element	
     , 	String attrName	
     , 	String expValue	) {
    (new actions.Common()).verifyElementAttributeValueContains(
        	element
         , 	attrName
         , 	expValue)
}

def static "actions.Common.verifyElementAttributeValueNotContains"(
    	TestObject element	
     , 	String attrName	
     , 	String expValue	) {
    (new actions.Common()).verifyElementAttributeValueNotContains(
        	element
         , 	attrName
         , 	expValue)
}

def static "actions.Common.createDocument_WMIMenuBov"() {
    (new actions.Common()).createDocument_WMIMenuBov()
}

def static "actions.Common.createDocument_WMIMenuBovDefault"() {
    (new actions.Common()).createDocument_WMIMenuBovDefault()
}

def static "actions.Common.createDocument_WMIMenuBovDocTwoRow"() {
    (new actions.Common()).createDocument_WMIMenuBovDocTwoRow()
}

def static "actions.Common.verifyDateFormat"(
    	String inputDate	
     , 	String inputDateFormat	) {
    (new actions.Common()).verifyDateFormat(
        	inputDate
         , 	inputDateFormat)
}

def static "actions.Common.changePasswordPageFormFill"(
    	String username	
     , 	String currentPassword	
     , 	String newPassword	
     , 	String confirmPassword	) {
    (new actions.Common()).changePasswordPageFormFill(
        	username
         , 	currentPassword
         , 	newPassword
         , 	confirmPassword)
}

def static "actions.Common.changePasswordPageFormFill_Login"(
    	String username	
     , 	String currentPassword	
     , 	String newPassword	
     , 	String confirmPassword	) {
    (new actions.Common()).changePasswordPageFormFill_Login(
        	username
         , 	currentPassword
         , 	newPassword
         , 	confirmPassword)
}

def static "actions.Common.createDocument_DateTimeDT"(
    	String BM_Date	
     , 	String DateRange	
     , 	String BM_DateTime	
     , 	String DateTimeRange	) {
    (new actions.Common()).createDocument_DateTimeDT(
        	BM_Date
         , 	DateRange
         , 	BM_DateTime
         , 	DateTimeRange)
}

def static "actions.Common.createDocument_RequiredFieldDT"(
    	String BM_Text	
     , 	String BM_String_Required	
     , 	String BM_int	
     , 	String DateTime_Required	
     , 	String Date_Required	) {
    (new actions.Common()).createDocument_RequiredFieldDT(
        	BM_Text
         , 	BM_String_Required
         , 	BM_int
         , 	DateTime_Required
         , 	Date_Required)
}

def static "actions.Common.createDocument_MyWorkDateTime"(
    	String docClass	
     , 	String docType	
     , 	String startDate	
     , 	String endDate	
     , 	String startDateTime	
     , 	String endDateTime	
     , 	String BM_Text	) {
    (new actions.Common()).createDocument_MyWorkDateTime(
        	docClass
         , 	docType
         , 	startDate
         , 	endDate
         , 	startDateTime
         , 	endDateTime
         , 	BM_Text)
}

def static "actions.Common.verifyTotalRecordCountFromPageSummary"(
    	TestObject to	
     , 	int expCount	) {
    (new actions.Common()).verifyTotalRecordCountFromPageSummary(
        	to
         , 	expCount)
}

def static "actions.Common.setText_Date"(
    	TestObject to	
     , 	String text	) {
    (new actions.Common()).setText_Date(
        	to
         , 	text)
}

def static "actions.Common.setTextJQuery"(
    	TestObject to	
     , 	String text	) {
    (new actions.Common()).setTextJQuery(
        	to
         , 	text)
}

def static "actions.Common.getPageSource"() {
    (new actions.Common()).getPageSource()
}

def static "actions.Common.verifyJQueryRunningStatus"(
    	TestObject iframe	
     , 	Boolean isExpectedToBeRunning	) {
    (new actions.Common()).verifyJQueryRunningStatus(
        	iframe
         , 	isExpectedToBeRunning)
}

def static "actions.Common.createDocument_MultiPageViewerWithDragAndDrop"(
    	String stringField	
     , 	String fileName	
     , 	String filePath	) {
    (new actions.Common()).createDocument_MultiPageViewerWithDragAndDrop(
        	stringField
         , 	fileName
         , 	filePath)
}

def static "actions.Common.createDocument_WMIMenuBovVertical"(
    	String BM_String	
     , 	String filePath	) {
    (new actions.Common()).createDocument_WMIMenuBovVertical(
        	BM_String
         , 	filePath)
}

def static "actions.Common.createDocument_ClosureAction"(
    	String customerName	
     , 	String customerDetails	) {
    (new actions.Common()).createDocument_ClosureAction(
        	customerName
         , 	customerDetails)
}

def static "actions.Common.waitForElementVisible"(
    	TestObject to	
     , 	int timeout	) {
    (new actions.Common()).waitForElementVisible(
        	to
         , 	timeout)
}

def static "actions.Common.waitForTabLoading"(
    	TestObject iframe	
     , 	int timeout	) {
    (new actions.Common()).waitForTabLoading(
        	iframe
         , 	timeout)
}

def static "actions.Common.setTextAndSave"(
    	TestObject to	
     , 	String text	) {
    (new actions.Common()).setTextAndSave(
        	to
         , 	text)
}

def static "actions.Common.getCssValue"(
    	TestObject to	
     , 	String css	) {
    (new actions.Common()).getCssValue(
        	to
         , 	css)
}

def static "actions.Common.verifyCssValue"(
    	TestObject to	
     , 	String css	
     , 	String expCssValue	) {
    (new actions.Common()).verifyCssValue(
        	to
         , 	css
         , 	expCssValue)
}

def static "actions.Common.openThumbnail"(
    	TestObject toggler	) {
    (new actions.Common()).openThumbnail(
        	toggler)
}

def static "actions.Common.closeThumbnail"(
    	TestObject toggler	) {
    (new actions.Common()).closeThumbnail(
        	toggler)
}

def static "actions.Common.createDocument_VerticalMenuWizard"() {
    (new actions.Common()).createDocument_VerticalMenuWizard()
}

def static "actions.Common.createDocument_VerticalMenuWizard"(
    	String firstName	
     , 	String lastName	
     , 	String amount	) {
    (new actions.Common()).createDocument_VerticalMenuWizard(
        	firstName
         , 	lastName
         , 	amount)
}

def static "actions.Common.createDocument_VerticalMenuWizard"(
    	String firstName	
     , 	String lastName	
     , 	String amount	
     , 	String filePath	) {
    (new actions.Common()).createDocument_VerticalMenuWizard(
        	firstName
         , 	lastName
         , 	amount
         , 	filePath)
}

def static "actions.Common.createDocument_RouteAdvance"(
    	String description	) {
    (new actions.Common()).createDocument_RouteAdvance(
        	description)
}

def static "actions.Common.createDocument_ProcessForTaskDT"(
    	String customerName	
     , 	String customerDetails	) {
    (new actions.Common()).createDocument_ProcessForTaskDT(
        	customerName
         , 	customerDetails)
}

def static "actions.Common.verifyElementsCount"(
    	TestObject to	
     , 	int expCount	) {
    (new actions.Common()).verifyElementsCount(
        	to
         , 	expCount)
}

def static "actions.Common.createDocument_RenderAllField"(
    	String integerField	
     , 	String stringFieldOnFocusAttr	
     , 	String stringFieldLookup	
     , 	String currencyField	
     , 	String dateField	
     , 	String floatField	
     , 	String smallIntField	
     , 	String textField	
     , 	String dateTimeField	
     , 	String stringField	
     , 	String extNameField	) {
    (new actions.Common()).createDocument_RenderAllField(
        	integerField
         , 	stringFieldOnFocusAttr
         , 	stringFieldLookup
         , 	currencyField
         , 	dateField
         , 	floatField
         , 	smallIntField
         , 	textField
         , 	dateTimeField
         , 	stringField
         , 	extNameField)
}

def static "actions.Common.waitForImageToRender"(
    	TestObject to	) {
    (new actions.Common()).waitForImageToRender(
        	to)
}

def static "actions.Common.createDocument_Correspondence"(
    	String firstName	
     , 	String lastName	
     , 	String toEmail	
     , 	String template	) {
    (new actions.Common()).createDocument_Correspondence(
        	firstName
         , 	lastName
         , 	toEmail
         , 	template)
}

def static "actions.Common.createBulkDocuments_ClosureAction"(
    	int requiredDocsCount	) {
    (new actions.Common()).createBulkDocuments_ClosureAction(
        	requiredDocsCount)
}

def static "actions.Common.createBulkDocuments_RenderAllFields"(
    	int requiredDocsCount	) {
    (new actions.Common()).createBulkDocuments_RenderAllFields(
        	requiredDocsCount)
}

def static "actions.Common.createBulkDocuments_WMIMenuBovVertical"(
    	int requiredDocsCount	) {
    (new actions.Common()).createBulkDocuments_WMIMenuBovVertical(
        	requiredDocsCount)
}

def static "actions.Common.createBulkDocuments_Correpondence"(
    	int requiredDocsCount	) {
    (new actions.Common()).createBulkDocuments_Correpondence(
        	requiredDocsCount)
}

def static "actions.Common.createDocument_ReloadOnPostBack"(
    	String BM_String	) {
    (new actions.Common()).createDocument_ReloadOnPostBack(
        	BM_String)
}

def static "actions.Common.createBulkDocuments_ReloadOnPostBack"(
    	int requiredDocsCount	) {
    (new actions.Common()).createBulkDocuments_ReloadOnPostBack(
        	requiredDocsCount)
}

def static "actions.Common.verifyElementHasFocus"(
    	TestObject toLocator	) {
    (new actions.Common()).verifyElementHasFocus(
        	toLocator)
}

def static "actions.Common.verifyElementNotHasFocus"(
    	TestObject toLocator	) {
    (new actions.Common()).verifyElementNotHasFocus(
        	toLocator)
}

def static "actions.Common.createDocument_RenderAsLabel"() {
    (new actions.Common()).createDocument_RenderAsLabel()
}

def static "actions.Common.createBulkDocuments_RenderAsLabel"(
    	int requiredDocsCount	) {
    (new actions.Common()).createBulkDocuments_RenderAsLabel(
        	requiredDocsCount)
}

def static "actions.Common.createDocument_ReferenceObjectInlineContentView"() {
    (new actions.Common()).createDocument_ReferenceObjectInlineContentView()
}

def static "actions.Common.createBulkDocuments_ReferenceObjectInlineContentView"(
    	int requiredDocsCount	) {
    (new actions.Common()).createBulkDocuments_ReferenceObjectInlineContentView(
        	requiredDocsCount)
}

def static "actions.Common.createDocument_EventForRequiredField"(
    	String dropDownControl	
     , 	String textValue	
     , 	String date	) {
    (new actions.Common()).createDocument_EventForRequiredField(
        	dropDownControl
         , 	textValue
         , 	date)
}

def static "actions.Window.clickElementAndWaitForWindowClose"(
    	TestObject saveButton	
     , 	int timeout	) {
    (new actions.Window()).clickElementAndWaitForWindowClose(
        	saveButton
         , 	timeout)
}

def static "actions.Window.switchToUrlContains"(
    	String text	) {
    (new actions.Window()).switchToUrlContains(
        	text)
}

def static "actions.Window.verifyOpenWindowCount"(
    	int expCount	) {
    (new actions.Window()).verifyOpenWindowCount(
        	expCount)
}

def static "apis.Users.getUserIdFromUserName"(
    	String userName	) {
    (new apis.Users()).getUserIdFromUserName(
        	userName)
}

def static "apis.Users.unlockUserAccount"(
    	int userId	) {
    (new apis.Users()).unlockUserAccount(
        	userId)
}

def static "apis.Users.verifyIsUserAccountLocked"(
    	int userId	) {
    (new apis.Users()).verifyIsUserAccountLocked(
        	userId)
}

def static "apis.Users.verifyIsUserAccountUnlocked"(
    	int userId	) {
    (new apis.Users()).verifyIsUserAccountUnlocked(
        	userId)
}

def static "actions.Chart.verifyNumberOfSlices"(
    	TestObject chartLocator	
     , 	int expCount	
     , 	String sliceLocator	) {
    (new actions.Chart()).verifyNumberOfSlices(
        	chartLocator
         , 	expCount
         , 	sliceLocator)
}

def static "actions.Chart.getNumberOfSlices"(
    	TestObject chartLocator	
     , 	String sliceLocator	) {
    (new actions.Chart()).getNumberOfSlices(
        	chartLocator
         , 	sliceLocator)
}

def static "actions.Chart.verifyToolTipText"(
    	TestObject chartLocator	
     , 	int sliceNo	
     , 	String expToolTipText	
     , 	String sliceLocator	) {
    (new actions.Chart()).verifyToolTipText(
        	chartLocator
         , 	sliceNo
         , 	expToolTipText
         , 	sliceLocator)
}

def static "actions.Chart.verifyToolTipText"(
    	TestObject chartLocator	
     , 	int sliceNo	
     , 	String expKey	
     , 	String expValue	
     , 	String sliceLocator	) {
    (new actions.Chart()).verifyToolTipText(
        	chartLocator
         , 	sliceNo
         , 	expKey
         , 	expValue
         , 	sliceLocator)
}

def static "actions.Chart.mousOverOnSlice"(
    	TestObject chartLocator	
     , 	int sliceNo	
     , 	String sliceLocator	) {
    (new actions.Chart()).mousOverOnSlice(
        	chartLocator
         , 	sliceNo
         , 	sliceLocator)
}

def static "actions.Chart.clickSlice"(
    	TestObject chartLocator	
     , 	int sliceNo	
     , 	String sliceLocator	) {
    (new actions.Chart()).clickSlice(
        	chartLocator
         , 	sliceNo
         , 	sliceLocator)
}

def static "actions.ContextMenu.verifyAllOptions"(
    	TestObject contextMenuOptions	
     , 	String[] options	) {
    (new actions.ContextMenu()).verifyAllOptions(
        	contextMenuOptions
         , 	options)
}

def static "actions.ContextMenu.verifyOptionPresent"(
    	TestObject contextMenuOptions	
     , 	String option	) {
    (new actions.ContextMenu()).verifyOptionPresent(
        	contextMenuOptions
         , 	option)
}

def static "actions.ContextMenu.clickOption"(
    	TestObject contextMenuOptions	
     , 	String option	) {
    (new actions.ContextMenu()).clickOption(
        	contextMenuOptions
         , 	option)
}
