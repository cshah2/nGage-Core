
/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */

import java.lang.String

import com.kms.katalon.core.testobject.TestObject

import java.util.List


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

def static "actions.Common.maximizeWindow"() {
    (new actions.Common()).maximizeWindow()
}

def static "actions.Common.login"() {
    (new actions.Common()).login()
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

def static "actions.Window.setScreenSize"(
    	int width	
     , 	int height	) {
    (new actions.Window()).setScreenSize(
        	width
         , 	height)
}

def static "actions.MenuBar.refreshActivityUntilRecordCountIncreases"(
    	TestObject element	
     , 	int timeout	) {
    (new actions.MenuBar()).refreshActivityUntilRecordCountIncreases(
        	element
         , 	timeout)
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
