import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

'Login into application'
CustomKeywords.'actions.Common.login'()

'Open Reports Menu'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/Reports Menu'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)
CustomKeywords.'actions.Common.waitForFrameToLoad'(findTestObject('Page_nGage_Dashboard/Report/IFrame_108'))

'Expand Security Management section'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/Expand_Security Management'))
WebUI.waitForJQueryLoad(GlobalVariable.G_LongTimeout)

//Report 1
'Click Report User Listing'
CustomKeywords.'actions.Report.clickReport'('Administration', 'Security Management', 'User Listing')
CustomKeywords.'actions.Report.verifyReportIsLoaded'('User Listing', 'User Listing', 'User Listing Details')
'Click Design button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/Data_CommonFields/ToolBar1_Design'))
CustomKeywords.'actions.Common.waitForReportToLoad'(GlobalVariable.G_ReportTimeout)
CustomKeywords.'actions.Report.verifyDesignPageIsLoaded'('V_ADM_USERS_DETAILS')

//Report 2
'Click User Group Membership Report'
CustomKeywords.'actions.Report.clickReport'('Administration', 'Security Management', 'User Group Membership')
CustomKeywords.'actions.Report.verifyReportIsLoaded'('User Group Membership', 'User Group Membership', 'Assigned User and BPM User Groups for a User')
'Click Design button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/Data_CommonFields/ToolBar1_Design'))
CustomKeywords.'actions.Common.waitForReportToLoad'(GlobalVariable.G_ReportTimeout)
CustomKeywords.'actions.Report.verifyDesignPageIsLoaded'('V_ADM_U_GROUP_MBR')

//Report 3
'Click on User Group Listing Report'
CustomKeywords.'actions.Report.clickReport'('Administration', 'Security Management', 'User Group Listing')
CustomKeywords.'actions.Report.verifyReportIsLoaded'('User Group Listing', 'User Group Listing', 'List of users in the user groups')
'Click Design button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/Data_CommonFields/ToolBar1_Design'))
CustomKeywords.'actions.Common.waitForReportToLoad'(GlobalVariable.G_ReportTimeout)
CustomKeywords.'actions.Report.verifyDesignPageIsLoaded'('V_ADM_USERGROUP')

//Report 4
'Click on User Access to Document Classes Report'
CustomKeywords.'actions.Report.clickReport'('Administration', 'Security Management', 'User Access to Document Classes')
CustomKeywords.'actions.Report.verifyReportIsLoaded'('User Access to Document Classes', 'User Access to Document Classes', 'User Access to Document Classes (shows a specific users access to document classes, with rights)')
'Click Design button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/Data_CommonFields/ToolBar1_Design'))
CustomKeywords.'actions.Common.waitForReportToLoad'(GlobalVariable.G_ReportTimeout)
CustomKeywords.'actions.Report.verifyDesignPageIsLoaded'('V_ADM_USER_DOCCLASS')

//Report 5
'Click on Audit of Standard Document Action Report'
CustomKeywords.'actions.Report.clickReport'('Administration', 'Security Management', 'Audit of Standard Document Action')
CustomKeywords.'actions.Report.verifyReportIsLoaded'('Audit of Standard Document Action', 'Audit of Standard Document Action', 'User Audit History of Standard Document Actions (action audit table details)')
'Click Design button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/Data_CommonFields/ToolBar1_Design'))
CustomKeywords.'actions.Common.waitForReportToLoad'(GlobalVariable.G_ReportTimeout)
CustomKeywords.'actions.Report.verifyDesignPageIsLoaded'('V_ADM_USER_AUDIT_HIS')

//Report 6
'Click on User Security Audit History Report'
CustomKeywords.'actions.Report.clickReport'('Administration', 'Security Management', 'User Security Audit History')
CustomKeywords.'actions.Report.verifyReportIsLoaded'('User Security Audit History', 'User Security Audit History', 'User Security Audit History (security audit table details)')
'Click Design button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/Data_CommonFields/ToolBar1_Design'))
CustomKeywords.'actions.Common.waitForReportToLoad'(GlobalVariable.G_ReportTimeout)
CustomKeywords.'actions.Report.verifyDesignPageIsLoaded'('V_ADM_USER_SECURITY')

//Report 7
'Click on Organizations Report'
CustomKeywords.'actions.Report.clickReport'('Administration', 'Security Management', 'Organizations')
CustomKeywords.'actions.Report.verifyReportIsLoaded'('Organizations', 'Organizations', 'Organizations')
'Click Design button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/Data_CommonFields/ToolBar1_Design'))
CustomKeywords.'actions.Common.waitForReportToLoad'(GlobalVariable.G_ReportTimeout)
CustomKeywords.'actions.Report.verifyDesignPageIsLoaded'('V_ADM_ORGANIZATIONS')

//Report 8
'Click on Categories Report'
CustomKeywords.'actions.Report.clickReport'('Administration', 'Security Management', 'Categories')
CustomKeywords.'actions.Report.verifyReportIsLoaded'('Categories', 'Categories', 'Categories')
'Click Design button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/Data_CommonFields/ToolBar1_Design'))
CustomKeywords.'actions.Common.waitForReportToLoad'(GlobalVariable.G_ReportTimeout)
CustomKeywords.'actions.Report.verifyDesignPageIsLoaded'('V_ADM_CATEGORY')

//Report 9
'Click on User Directory Details Report'
CustomKeywords.'actions.Report.clickReport'('Administration', 'Security Management', 'User Directory Details')
CustomKeywords.'actions.Report.verifyReportIsLoaded'('User Directory Details', 'User Directory Details', 'User Directory Details')
'Click Design button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/Data_CommonFields/ToolBar1_Design'))
CustomKeywords.'actions.Common.waitForReportToLoad'(GlobalVariable.G_ReportTimeout)
CustomKeywords.'actions.Report.verifyDesignPageIsLoaded'('V_ADM_USER_DIRECTORY')

//Report 10
'Click on User Directory Other Attributes Report'
CustomKeywords.'actions.Report.clickReport'('Administration', 'Security Management', 'User Directory Other Attributes')
CustomKeywords.'actions.Report.verifyReportIsLoaded'('User Directory Other Attributes', 'User Directory Other Attributes', 'User Directory Other Attributes')
'Click Design button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/Data_CommonFields/ToolBar1_Design'))
CustomKeywords.'actions.Common.waitForReportToLoad'(GlobalVariable.G_ReportTimeout)
CustomKeywords.'actions.Report.verifyDesignPageIsLoaded'('V_ADM_USER_DIR_ATTRIB')

//Report 11
'Click on Organizations with User Membership Report'
CustomKeywords.'actions.Report.clickReport'('Administration', 'Security Management', 'Organizations with User Membership')
CustomKeywords.'actions.Report.verifyReportIsLoaded'('Organizations with User Membership', 'Organizations with User Membership', 'Organizations with User Membership')
'Click Design button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/Data_CommonFields/ToolBar1_Design'))
CustomKeywords.'actions.Common.waitForReportToLoad'(GlobalVariable.G_ReportTimeout)
CustomKeywords.'actions.Report.verifyDesignPageIsLoaded'('V_ADM_ORGAN_PERM')

//Report 12
'Click on Category with User Membership Report'
CustomKeywords.'actions.Report.clickReport'('Administration', 'Security Management', 'Category with User Membership')
CustomKeywords.'actions.Report.verifyReportIsLoaded'('Category with User Membership', 'Category with User Membership', 'Category with User Membership')
'Click Design button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/Data_CommonFields/ToolBar1_Design'))
CustomKeywords.'actions.Common.waitForReportToLoad'(GlobalVariable.G_ReportTimeout)
CustomKeywords.'actions.Report.verifyDesignPageIsLoaded'('V_ADM_CAT_PERM')

//Report 13
'Click on User Concurrent Usage Report'
CustomKeywords.'actions.Report.clickReport'('Administration', 'Security Management', 'User Concurrent Usage')
CustomKeywords.'actions.Report.verifyReportIsLoaded'('User Concurrent Usage', 'User Concurrent Usage', 'User Concurrent Usage Report - the list of users who actively logged in')
'Click Design button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/Data_CommonFields/ToolBar1_Design'))
CustomKeywords.'actions.Common.waitForReportToLoad'(GlobalVariable.G_ReportTimeout)
CustomKeywords.'actions.Report.verifyDesignPageIsLoaded'('V_ADM_USER_CURR_USG')

//Report 14
'Click on User Concurrent Usage By Half Hour Report'
CustomKeywords.'actions.Report.clickReport'('Administration', 'Security Management', 'User Concurrent Usage By Half Hour')
CustomKeywords.'actions.Report.verifyReportIsLoaded'('User Concurrent Usage By Half Hour', null, null)
'Click Design button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/Data_CommonFields/ToolBar1_Design'))
CustomKeywords.'actions.Common.waitForReportToLoad'(GlobalVariable.G_ReportTimeout)
CustomKeywords.'actions.Report.verifyDesignPageIsLoaded'('V_ADM_USER_CURR_HALFHR')

//Report 15
'Click on Licensing Report'
CustomKeywords.'actions.Report.clickReport'('Administration', 'Security Management', 'Licensing')
CustomKeywords.'actions.Report.verifyReportIsLoaded'('Licensing', 'Monthly Licensing', 'Monthly Licensing Report')
'Click Design button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/Data_CommonFields/ToolBar1_Design'))
CustomKeywords.'actions.Common.waitForReportToLoad'(GlobalVariable.G_ReportTimeout)
CustomKeywords.'actions.Report.verifyDesignPageIsLoaded'('V_RPT_Licensing')

//Report 16
'Click on Field Usage Report'
CustomKeywords.'actions.Report.clickReport'('Administration', 'Field Definition', 'Field Usage')
CustomKeywords.'actions.Report.verifyReportIsLoaded'('Field Usage', 'Field Usage', 'Field Usage (shows field usage against document tables)')
'Click Design button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/Data_CommonFields/ToolBar1_Design'))
CustomKeywords.'actions.Common.waitForReportToLoad'(GlobalVariable.G_ReportTimeout)
CustomKeywords.'actions.Report.verifyDesignPageIsLoaded'('V_ADM_FIELD_USAGE')

//Report 17
'Click on Field Lookup List Functions Report'
CustomKeywords.'actions.Report.clickReport'('Administration', 'Field Definition', 'Field Lookup List Functions')
CustomKeywords.'actions.Report.verifyReportIsLoaded'('Field Lookup List Functions', 'Field Lookup (list functions)', 'Field Lookup (list field functions)')
'Click Design button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/Data_CommonFields/ToolBar1_Design'))
CustomKeywords.'actions.Common.waitForReportToLoad'(GlobalVariable.G_ReportTimeout)
CustomKeywords.'actions.Report.verifyDesignPageIsLoaded'('V_ADM_FIELD_LOOKUP')

//Report 18
'Click on Lookup Value List Report'
CustomKeywords.'actions.Report.clickReport'('Administration', 'Field Definition', 'Lookup Value List')
CustomKeywords.'actions.Report.verifyReportIsLoaded'('Lookup Value List', 'Lookup Value List', 'Lookup Value List')
'Click Design button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/Data_CommonFields/ToolBar1_Design'))
CustomKeywords.'actions.Common.waitForReportToLoad'(GlobalVariable.G_ReportTimeout)
CustomKeywords.'actions.Report.verifyDesignPageIsLoaded'('V_ADM_LOOKUP_VALUES')

//Report 19
'Click on Field Data Dictionary Report'
CustomKeywords.'actions.Report.clickReport'('Administration', 'Field Definition', 'Field Data Dictionary')
CustomKeywords.'actions.Report.verifyReportIsLoaded'('Field Data Dictionary', null, null)
'Click Design button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/Data_CommonFields/ToolBar1_Design'))
CustomKeywords.'actions.Common.waitForReportToLoad'(GlobalVariable.G_ReportTimeout)
CustomKeywords.'actions.Report.verifyDesignPageIsLoaded'('V_ADM_FIELD_DATA')

//Report 20
'Click on Document Tables Report'
CustomKeywords.'actions.Report.clickReport'('Administration', 'Document Tables', 'Document Tables')
CustomKeywords.'actions.Report.verifyReportIsLoaded'('Document Tables', 'Document Tables', 'List of Document Tables')
'Click Design button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/Data_CommonFields/ToolBar1_Design'))
CustomKeywords.'actions.Common.waitForReportToLoad'(GlobalVariable.G_ReportTimeout)
CustomKeywords.'actions.Report.verifyDesignPageIsLoaded'('V_ADM_DOCTABLES')

//Report 21
'Click on Doc Table Doc Class Membership Report'
CustomKeywords.'actions.Report.clickReport'('Administration', 'Document Tables', 'Doc Table Doc Class Membership')
CustomKeywords.'actions.Report.verifyReportIsLoaded'('Doc Table Doc Class Membership', 'Doc Table Doc Class Membership', 'Doc Table Doc Class Membership')
'Click Design button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/Data_CommonFields/ToolBar1_Design'))
CustomKeywords.'actions.Common.waitForReportToLoad'(GlobalVariable.G_ReportTimeout)
CustomKeywords.'actions.Report.verifyDesignPageIsLoaded'('V_ADM_DOCTBL_DCCLASS')

//Report 22
'Click on Document Tables Field Design Report'
CustomKeywords.'actions.Report.clickReport'('Administration', 'Document Tables', 'Document Tables Field Design')
CustomKeywords.'actions.Report.verifyReportIsLoaded'('Document Tables Field Design', 'Document Tables Field Design', 'Document Tables Field Design')
'Click Design button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/Data_CommonFields/ToolBar1_Design'))
CustomKeywords.'actions.Common.waitForReportToLoad'(GlobalVariable.G_ReportTimeout)
CustomKeywords.'actions.Report.verifyDesignPageIsLoaded'('V_ADM_DOCTBL_FIELDS')

//Report 23
'Click on Document Classes Report'
CustomKeywords.'actions.Report.clickReport'('Administration', 'Document Tables', 'Document Classes')
CustomKeywords.'actions.Report.verifyReportIsLoaded'('Document Classes', 'Document Classes', 'List of Document Classes')
'Click Design button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/Data_CommonFields/ToolBar1_Design'))
CustomKeywords.'actions.Common.waitForReportToLoad'(GlobalVariable.G_ReportTimeout)
CustomKeywords.'actions.Report.verifyDesignPageIsLoaded'('V_ADM_DOCCLASS_DETAIL')

//Report 24
'Click on Document Types Report'
CustomKeywords.'actions.Report.clickReport'('Administration', 'Document Tables', 'Document Types')
CustomKeywords.'actions.Report.verifyReportIsLoaded'('Document Types', 'Document Types', 'List of Document Types')
'Click Design button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/Data_CommonFields/ToolBar1_Design'))
CustomKeywords.'actions.Common.waitForReportToLoad'(GlobalVariable.G_ReportTimeout)
CustomKeywords.'actions.Report.verifyDesignPageIsLoaded'('V_ADM_DOCTYPES_DETL')

//Report 25
'Click on Document Class User Group Security Summary Report'
CustomKeywords.'actions.Report.clickReport'('Administration', 'Document Tables', 'Document Class User Group Security Summary')
CustomKeywords.'actions.Report.verifyReportIsLoaded'('Document Class User Group Security Summary', 'Document Class User Group Security Summary', 'Document Class User Group Security Summary')
'Click Design button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/Data_CommonFields/ToolBar1_Design'))
CustomKeywords.'actions.Common.waitForReportToLoad'(GlobalVariable.G_ReportTimeout)
CustomKeywords.'actions.Report.verifyDesignPageIsLoaded'('V_ADM_DOCCLASS_PERM')

//Report 26
'Click on Document Class User to Group Report'
CustomKeywords.'actions.Report.clickReport'('Administration', 'Document Tables', 'Document Class User to Group')
CustomKeywords.'actions.Report.verifyReportIsLoaded'('Document Class User to Group', 'Document Class User to Group', 'Document Class with Assigned User to Group Rights')
'Click Design button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/Data_CommonFields/ToolBar1_Design'))
CustomKeywords.'actions.Common.waitForReportToLoad'(GlobalVariable.G_ReportTimeout)
CustomKeywords.'actions.Report.verifyDesignPageIsLoaded'('V_ADM_DOCCLASS_PERM')

//Report 27
'Click on Document Classes Field Design Report'
CustomKeywords.'actions.Report.clickReport'('Administration', 'Document Tables', 'Document Classes Field Design')
CustomKeywords.'actions.Report.verifyReportIsLoaded'('Document Classes Field Design', 'Document Classes Field Design', 'List of field document classes with field design')
'Click Design button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/Data_CommonFields/ToolBar1_Design'))
CustomKeywords.'actions.Common.waitForReportToLoad'(GlobalVariable.G_ReportTimeout)
CustomKeywords.'actions.Report.verifyDesignPageIsLoaded'('V_ADM_DCLASS_FIELD')

//Report 28
'Click on Search Class Details Report'
CustomKeywords.'actions.Report.clickReport'('Administration', 'Search Management', 'Search Class Details')
CustomKeywords.'actions.Report.verifyReportIsLoaded'('Search Class Details', 'Search Class Details', 'Search Class Details')
'Click Design button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/Data_CommonFields/ToolBar1_Design'))
CustomKeywords.'actions.Common.waitForReportToLoad'(GlobalVariable.G_ReportTimeout)
CustomKeywords.'actions.Report.verifyDesignPageIsLoaded'('V_ADM_SEARCHCLASS')

//Report 29
'Click on Search Class Design Report'
CustomKeywords.'actions.Report.clickReport'('Administration', 'Search Management', 'Search Class Design')
CustomKeywords.'actions.Report.verifyReportIsLoaded'('Search Class Design', 'Search Class Design', 'Search Class Design')
'Click Design button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/Data_CommonFields/ToolBar1_Design'))
CustomKeywords.'actions.Common.waitForReportToLoad'(GlobalVariable.G_ReportTimeout)
CustomKeywords.'actions.Report.verifyDesignPageIsLoaded'('V_ADM_SRCHCLASS_DSGN')

//Report 30
'Click on Search Class Security Report'
CustomKeywords.'actions.Report.clickReport'('Administration', 'Search Management', 'Search Class Security')
CustomKeywords.'actions.Report.verifyReportIsLoaded'('Search Class Security', 'Search Class Security', 'Search Class Security')
'Click Design button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/Data_CommonFields/ToolBar1_Design'))
CustomKeywords.'actions.Common.waitForReportToLoad'(GlobalVariable.G_ReportTimeout)
CustomKeywords.'actions.Report.verifyDesignPageIsLoaded'('V_ADM_SRCHCLASS_SEC')

//Report 31
'Click on EDM Details Report'
CustomKeywords.'actions.Report.clickReport'('Administration', 'Search Management', 'EDM Details')
CustomKeywords.'actions.Report.verifyReportIsLoaded'('EDM Details', 'EDM Details', 'EDM Details')
'Click Design button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/Data_CommonFields/ToolBar1_Design'))
CustomKeywords.'actions.Common.waitForReportToLoad'(GlobalVariable.G_ReportTimeout)
CustomKeywords.'actions.Report.verifyDesignPageIsLoaded'('V_ADM_EDM_DETAILS')

//Report 32
'Click on EDM Search Class Report Report'
CustomKeywords.'actions.Report.clickReport'('Administration', 'Search Management', 'EDM Search Class Report')
CustomKeywords.'actions.Report.verifyReportIsLoaded'('EDM Search Class Report', 'EDM Search Class Report', 'EDM Search Class Report')
'Click Design button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/Data_CommonFields/ToolBar1_Design'))
CustomKeywords.'actions.Common.waitForReportToLoad'(GlobalVariable.G_ReportTimeout)
CustomKeywords.'actions.Report.verifyDesignPageIsLoaded'('V_ADM_EDM_SRCHCLASS')

//Report 33
'Click on EDM User Group and User Security Report'
CustomKeywords.'actions.Report.clickReport'('Administration', 'Search Management', 'EDM User Group and User Security')
CustomKeywords.'actions.Report.verifyReportIsLoaded'('EDM User Group and User Security', 'EDM User Group and User Security', 'EDM User Group and User Security')
'Click Design button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/Data_CommonFields/ToolBar1_Design'))
CustomKeywords.'actions.Common.waitForReportToLoad'(GlobalVariable.G_ReportTimeout)
CustomKeywords.'actions.Report.verifyDesignPageIsLoaded'('V_ADM_EDM_UGROUP_SEC')

//Report 34 //NOTE:ReportTitle is displayed twice
'Click on BPM Activity Assigned Users and UserGroups Report'
CustomKeywords.'actions.Report.clickReport'('Administration', 'Search Management', 'BPM Activity Assigned Users and UserGroups')
CustomKeywords.'actions.Report.verifyReportIsLoaded'('BPM Activity Assigned Users and UserGroups', 'BPM Activity Assigned Users and UserGroups', 'BPM Activity Assigned To Users and UserGroups')
'Click Design button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/Data_CommonFields/ToolBar1_Design'))
CustomKeywords.'actions.Common.waitForReportToLoad'(GlobalVariable.G_ReportTimeout)
CustomKeywords.'actions.Report.verifyDesignPageIsLoaded'('V_RPT_BPMACT_U_N_UG')

//Report 35
'Click on Summary of Documents by Class and Type Report'
CustomKeywords.'actions.Report.clickReport'('System Stat Reports', 'Document Management Statistics', 'Summary of Documents by Class and Type')
CustomKeywords.'actions.Report.verifyReportIsLoaded'('Summary of Documents by Class and Type', 'Summary of Documents by Class and Type', 'Summary of Documents by Class and Type')
'Click Design button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/Data_CommonFields/ToolBar1_Design'))
CustomKeywords.'actions.Common.waitForReportToLoad'(GlobalVariable.G_ReportTimeout)
CustomKeywords.'actions.Report.verifyDesignPageIsLoaded'('V_STAT_DCLASS_DTYPE')

//Report 36
'Click on New Document addition for Date Range Report'
CustomKeywords.'actions.Report.clickReport'('System Stat Reports', 'Document Management Statistics', 'New Document addition for Date Range')
CustomKeywords.'actions.Report.verifyReportIsLoaded'('New Document addition for Date Range', 'New Document addition for Date Range', 'New Document addition for Date Range')
'Click Design button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/Data_CommonFields/ToolBar1_Design'))
CustomKeywords.'actions.Common.waitForReportToLoad'(GlobalVariable.G_ReportTimeout)
CustomKeywords.'actions.Report.verifyDesignPageIsLoaded'('V_STAT_NEW_DOC_ADD')

//Report 37
'Click on Modified Documents by Date Range Report'
CustomKeywords.'actions.Report.clickReport'('System Stat Reports', 'Document Management Statistics', 'Modified Documents by Date Range')
CustomKeywords.'actions.Report.verifyReportIsLoaded'('Modified Documents by Date Range', 'Modified Documents by Date Range', 'Modified Documents by Date Range')
'Click Design button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/Data_CommonFields/ToolBar1_Design'))
CustomKeywords.'actions.Common.waitForReportToLoad'(GlobalVariable.G_ReportTimeout)
CustomKeywords.'actions.Report.verifyDesignPageIsLoaded'('V_STAT_MODIFY_DOC')

//Report 38
'Click on Access Summaries by Period Report'
CustomKeywords.'actions.Report.clickReport'('System Stat Reports', 'Document Management Statistics', 'Access Summaries by Period')
CustomKeywords.'actions.Report.verifyReportIsLoaded'('Access Summaries by Period', null, null)
'Click Design button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/Data_CommonFields/ToolBar1_Design'))
CustomKeywords.'actions.Common.waitForReportToLoad'(GlobalVariable.G_ReportTimeout)
CustomKeywords.'actions.Report.verifyDesignPageIsLoaded'('V_STAT_ACCESS_SUM')

//Report 39
'Click on Audit Report for Single Document Report'
CustomKeywords.'actions.Report.clickReport'('System Stat Reports', 'Document Management Statistics', 'Audit Report for Single Document')
CustomKeywords.'actions.Report.verifyReportIsLoaded'('Audit Report for Single Document', null, null)
'Click Design button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/Data_CommonFields/ToolBar1_Design'))
CustomKeywords.'actions.Common.waitForReportToLoad'(GlobalVariable.G_ReportTimeout)
CustomKeywords.'actions.Report.verifyDesignPageIsLoaded'('V_STAT_AUDIT_SNGL_DOC')

//Report 40
'Click on Related Document for Single Doc Report'
CustomKeywords.'actions.Report.clickReport'('System Stat Reports', 'Document Management Statistics', 'Related Document for Single Doc')
CustomKeywords.'actions.Report.verifyReportIsLoaded'('Related Document for Single Doc', null, null)
'Click Design button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/Data_CommonFields/ToolBar1_Design'))
CustomKeywords.'actions.Common.waitForReportToLoad'(GlobalVariable.G_ReportTimeout)
CustomKeywords.'actions.Report.verifyDesignPageIsLoaded'('V_STAT_REL_DOC_SNGL')

//Report 41
'Click on Revision History For Single Document Report'
CustomKeywords.'actions.Report.clickReport'('System Stat Reports', 'Document Management Statistics', 'Revision History For Single Document')
CustomKeywords.'actions.Report.verifyReportIsLoaded'('Revision History For Single Document', null, null)
'Click Design button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/Data_CommonFields/ToolBar1_Design'))
CustomKeywords.'actions.Common.waitForReportToLoad'(GlobalVariable.G_ReportTimeout)
CustomKeywords.'actions.Report.verifyDesignPageIsLoaded'('V_STAT_REV_HSTR_SNGL')

//Report 42
'Click on Deleted Document Waiting for Purge Report'
CustomKeywords.'actions.Report.clickReport'('System Stat Reports', 'Document Management Statistics', 'Deleted Document Waiting for Purge')
CustomKeywords.'actions.Report.verifyReportIsLoaded'('Deleted Document Waiting for Purge', null, null)
'Click Design button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/Data_CommonFields/ToolBar1_Design'))
CustomKeywords.'actions.Common.waitForReportToLoad'(GlobalVariable.G_ReportTimeout)
CustomKeywords.'actions.Report.verifyDesignPageIsLoaded'('V_STAT_DEL_DOC_PURGE')

//Report 43
'Click on All Work Items in Error Report'
CustomKeywords.'actions.Report.clickReport'('System Management', 'System Health', 'All Work Items in Error')
CustomKeywords.'actions.Report.verifyReportIsLoaded'('All Work Items in Error', 'All Work Items in Error', 'All Work Items in Error')
'Click Design button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/Data_CommonFields/ToolBar1_Design'))
CustomKeywords.'actions.Common.waitForReportToLoad'(GlobalVariable.G_ReportTimeout)
CustomKeywords.'actions.Report.verifyDesignPageIsLoaded'('V_RPT_WFAllErrorItems')

//Report 44
'Click on All Looping Workitems Report'
CustomKeywords.'actions.Report.clickReport'('System Management', 'System Health', 'All Looping Workitems')
CustomKeywords.'actions.Report.verifyReportIsLoaded'('All Looping Workitems', 'All Looping Workitems', 'All Looping Workitems since yesterday')
'Click Design button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/Data_CommonFields/ToolBar1_Design'))
CustomKeywords.'actions.Common.waitForReportToLoad'(GlobalVariable.G_ReportTimeout)
CustomKeywords.'actions.Report.verifyDesignPageIsLoaded'('V_RPT_WFAllLoopingItemsPerDay')

//Report 45
'Click on Engine Activity Status Report'
CustomKeywords.'actions.Report.clickReport'('System Management', 'System Health', 'Engine Activity Status')
CustomKeywords.'actions.Report.verifyReportIsLoaded'('Engine Activity Status', null, null)
'Click Design button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/Data_CommonFields/ToolBar1_Design'))
CustomKeywords.'actions.Common.waitForReportToLoad'(GlobalVariable.G_ReportTimeout)
CustomKeywords.'actions.Report.verifyDesignPageIsLoaded'('V_RPT_WFEngineActivityStatus')

//Report 46
'Click on Engine Throughput Today Report'
CustomKeywords.'actions.Report.clickReport'('System Management', 'System Health', 'Engine Throughput Today')
CustomKeywords.'actions.Report.verifyReportIsLoaded'('Engine Throughput Today', null, null)
'Click Design button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/Data_CommonFields/ToolBar1_Design'))
CustomKeywords.'actions.Common.waitForReportToLoad'(GlobalVariable.G_ReportTimeout)
CustomKeywords.'actions.Report.verifyDesignPageIsLoaded'('V_RPT_WFEngineThrougputToday')

//Report 47
'Click on Engine Perf Per Hour Report'
CustomKeywords.'actions.Report.clickReport'('System Management', 'System Health', 'Engine Perf Per Hour')
CustomKeywords.'actions.Report.verifyReportIsLoaded'('Engine Perf Per Hour', null, null)
'Click Design button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/Data_CommonFields/ToolBar1_Design'))
CustomKeywords.'actions.Common.waitForReportToLoad'(GlobalVariable.G_ReportTimeout)
CustomKeywords.'actions.Report.verifyDesignPageIsLoaded'('V_RPT_WFEnginePerfPerHour')

//Report 48
'Click on Engine Throughput Last Hour Report'
CustomKeywords.'actions.Report.clickReport'('System Management', 'System Health', 'Engine Throughput Last Hour')
CustomKeywords.'actions.Report.verifyReportIsLoaded'('Engine Throughput Last Hour', null, null)
'Click Design button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/Data_CommonFields/ToolBar1_Design'))
CustomKeywords.'actions.Common.waitForReportToLoad'(GlobalVariable.G_ReportTimeout)
CustomKeywords.'actions.Report.verifyDesignPageIsLoaded'('V_RPT_WFEngineThrougputLastHr')

//Report 49
'Click on Re-process Work Item in Error Report'
CustomKeywords.'actions.Report.clickReport'('System Management', 'System Health', 'Re-process Work Item in Error')
CustomKeywords.'actions.Report.verifyReportIsLoaded'('Re-process Work Item in Error', null, null)
'Click Design button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/Data_CommonFields/ToolBar1_Design'))
CustomKeywords.'actions.Common.waitForReportToLoad'(GlobalVariable.G_ReportTimeout)
CustomKeywords.'actions.Report.verifyDesignPageIsLoaded'('V_RPT_WFErrorItemDetails')

//Report 50
'Click on Work Items created in last 7 days Report'
CustomKeywords.'actions.Report.clickReport'('System Management', 'System Health', 'Work Items created in last 7 days')
CustomKeywords.'actions.Report.verifyReportIsLoaded'('Work Items created in last 7 days', null, null)
'Click Design button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/Data_CommonFields/ToolBar1_Design'))
CustomKeywords.'actions.Common.waitForReportToLoad'(GlobalVariable.G_ReportTimeout)
CustomKeywords.'actions.Report.verifyDesignPageIsLoaded'('V_RPT_WFItemCreatedInLst7Day')

//Report 51
'Click on Work Items to run Next Day Report'
CustomKeywords.'actions.Report.clickReport'('System Management', 'System Health', 'Work Items to run Next Day')
CustomKeywords.'actions.Report.verifyReportIsLoaded'('Work Items to run Next Day', null, null)
'Click Design button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/Data_CommonFields/ToolBar1_Design'))
CustomKeywords.'actions.Common.waitForReportToLoad'(GlobalVariable.G_ReportTimeout)
CustomKeywords.'actions.Report.verifyDesignPageIsLoaded'('V_RPT_WFItemsToRunNextDay')

//Report 52
'Click on Work items Waiting Report'
CustomKeywords.'actions.Report.clickReport'('System Management', 'System Health', 'Work items Waiting')
CustomKeywords.'actions.Report.verifyReportIsLoaded'('Work items Waiting', null, null)
'Click Design button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/Data_CommonFields/ToolBar1_Design'))
CustomKeywords.'actions.Common.waitForReportToLoad'(GlobalVariable.G_ReportTimeout)
CustomKeywords.'actions.Report.verifyDesignPageIsLoaded'('V_RPT_WFWaitingItems')

//Report 53
'Click on Security Audit Report'
CustomKeywords.'actions.Report.clickReport'('System Management', 'System Health', 'Security Audit')
CustomKeywords.'actions.Report.verifyReportIsLoaded'('Security Audit', 'Security Audit', 'Security Audit')
'Click Design button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/Data_CommonFields/ToolBar1_Design'))
CustomKeywords.'actions.Common.waitForReportToLoad'(GlobalVariable.G_ReportTimeout)
CustomKeywords.'actions.Report.verifyDesignPageIsLoaded'('V_RPT_SecurityAudit')

//Report 54
'Click on Logins Report'
CustomKeywords.'actions.Report.clickReport'('System Management', 'System Health', 'Logins')
CustomKeywords.'actions.Report.verifyReportIsLoaded'('Logins', null, null)
'Click Design button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/Data_CommonFields/ToolBar1_Design'))
CustomKeywords.'actions.Common.waitForReportToLoad'(GlobalVariable.G_ReportTimeout)
CustomKeywords.'actions.Report.verifyDesignPageIsLoaded'('V_RPT_Logins')

//Report 55
'Click on App Exception Log Report'
CustomKeywords.'actions.Report.clickReport'('System Management', 'System Health', 'App Exception Log')
CustomKeywords.'actions.Report.verifyReportIsLoaded'('App Exception Log', null, null)
'Click Design button'
WebUI.click(findTestObject('Page_nGage_Dashboard/Report/Data_CommonFields/ToolBar1_Design'))
CustomKeywords.'actions.Common.waitForReportToLoad'(GlobalVariable.G_ReportTimeout)
CustomKeywords.'actions.Report.verifyDesignPageIsLoaded'('V_RPT_AppExceptionLog')
