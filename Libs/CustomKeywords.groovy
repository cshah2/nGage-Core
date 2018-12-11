
/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */

import com.kms.katalon.core.testobject.TestObject

import java.lang.String

import java.util.List


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

def static "actions.Table.verifyRecordNotPresentInColumn"(
    	TestObject tableLocator	
     , 	int colNo	
     , 	String expValue	) {
    (new actions.Table()).verifyRecordNotPresentInColumn(
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

def static "actions.Table.verifyRecordsWithinDateRange"(
    	TestObject tableLocator	
     , 	int colNo	
     , 	String fromDate	
     , 	String toDate	) {
    (new actions.Table()).verifyRecordsWithinDateRange(
        	tableLocator
         , 	colNo
         , 	fromDate
         , 	toDate)
}

def static "actions.Table.verifyRecordsInTableAreMoreThanStartDate"(
    	TestObject tableLocator	
     , 	int colNo	
     , 	String fromDate	) {
    (new actions.Table()).verifyRecordsInTableAreMoreThanStartDate(
        	tableLocator
         , 	colNo
         , 	fromDate)
}

def static "actions.Table.verifyDateFilter"(
    	TestObject tableLocator	
     , 	int colNo	
     , 	String referenceDate	
     , 	String operator	) {
    (new actions.Table()).verifyDateFilter(
        	tableLocator
         , 	colNo
         , 	referenceDate
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

def static "actions.Table.verifyRecordsInTableAreLessThanEndDate"(
    	TestObject tableLocator	
     , 	int colNo	
     , 	String toDate	) {
    (new actions.Table()).verifyRecordsInTableAreLessThanEndDate(
        	tableLocator
         , 	colNo
         , 	toDate)
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

def static "actions.MenuBar.getRecordCountInActivity"(
    	TestObject element	) {
    (new actions.MenuBar()).getRecordCountInActivity(
        	element)
}

def static "actions.MenuBar.refreshActivityUntilRecordCountIncreases"(
    	TestObject element	
     , 	int timeout	) {
    (new actions.MenuBar()).refreshActivityUntilRecordCountIncreases(
        	element
         , 	timeout)
}

def static "actions.MenuBar.getAllSubMenu"(
    	TestObject menu	) {
    (new actions.MenuBar()).getAllSubMenu(
        	menu)
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
    	String BM_Date	
     , 	String BM_String_Required	
     , 	String BM_int	
     , 	String DateTime_Required	
     , 	String Date_Required	) {
    (new actions.Common()).createDocument_RequiredFieldDT(
        	BM_Date
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

def static "utils.DateUtil.verifyDateFilter"(
    	String operator	
     , 	String actualValue	
     , 	String referenceDateValue	
     , 	String dateTimeFormat	) {
    (new utils.DateUtil()).verifyDateFilter(
        	operator
         , 	actualValue
         , 	referenceDateValue
         , 	dateTimeFormat)
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
