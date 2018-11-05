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

//Report 2
'Click User Group Membership Report'
CustomKeywords.'actions.Report.clickReport'('Administration', 'Security Management', 'User Group Membership')

//Report 3
'Click on User Group Listing Report'
CustomKeywords.'actions.Report.clickReport'('Administration', 'Security Management', 'User Group Listing')

//Report 4
'Click on User Access to Document Classes Report'
CustomKeywords.'actions.Report.clickReport'('Administration', 'Security Management', 'User Access to Document Classes')

//Report 5
'Click on Audit of Standard Document Action Report'
CustomKeywords.'actions.Report.clickReport'('Administration', 'Security Management', 'Audit of Standard Document Action')

//Report 6
'Click on User Security Audit History Report'
CustomKeywords.'actions.Report.clickReport'('Administration', 'Security Management', 'User Security Audit History')

//Report 7
'Click on Organizations Report'
CustomKeywords.'actions.Report.clickReport'('Administration', 'Security Management', 'Organizations')

//Report 8
'Click on User Directory Details Report'
CustomKeywords.'actions.Report.clickReport'('Administration', 'Security Management', 'User Directory Details')

//Report 9
'Click on User Directory Other Attributes Report'
CustomKeywords.'actions.Report.clickReport'('Administration', 'Security Management', 'User Directory Other Attributes')

//Report 10
'Click on Organizations with User Membership Report'
CustomKeywords.'actions.Report.clickReport'('Administration', 'Security Management', 'Organizations with User Membership')

//Report 11
'Click on Category with User Membership Report'
CustomKeywords.'actions.Report.clickReport'('Administration', 'Security Management', 'Category with User Membership')

//Report 12
'Click on User Concurrent Usage Report'
CustomKeywords.'actions.Report.clickReport'('Administration', 'Security Management', 'User Concurrent Usage')

//Report 13
'Click on User Concurrent Usage By Half Hour Report'
CustomKeywords.'actions.Report.clickReport'('Administration', 'Security Management', 'User Concurrent Usage By Half Hour')

//Report 14
'Click on Licensing Report'
CustomKeywords.'actions.Report.clickReport'('Administration', 'Security Management', 'Licensing')

//Report 15
'Click on Field Usage Report'
CustomKeywords.'actions.Report.clickReport'('Administration', 'Field Definition', 'Field Usage')

//Report 16
'Click on Field Lookup List Functions Report'
CustomKeywords.'actions.Report.clickReport'('Administration', 'Field Definition', 'Field Lookup List Functions')

//Report 17
'Click on Lookup Value List Report'
CustomKeywords.'actions.Report.clickReport'('Administration', 'Field Definition', 'Lookup Value List')

//Report 18
'Click on Field Data Dictionary Report'
CustomKeywords.'actions.Report.clickReport'('Administration', 'Field Definition', 'Field Data Dictionary')

//Report 19
'Click on Document Tables Report'
CustomKeywords.'actions.Report.clickReport'('Administration', 'Document Tables', 'Document Tables')

//Report 20
'Click on Doc Table Doc Class Membership Report'
CustomKeywords.'actions.Report.clickReport'('Administration', 'Document Tables', 'Doc Table Doc Class Membership')

//Report 21
'Click on Document Tables Field Design Report'
CustomKeywords.'actions.Report.clickReport'('Administration', 'Document Tables', 'Document Tables Field Design')

//Report 22
'Click on Document Classes Report'
CustomKeywords.'actions.Report.clickReport'('Administration', 'Document Tables', 'Document Classes')

//Report 23
'Click on Document Types Report'
CustomKeywords.'actions.Report.clickReport'('Administration', 'Document Tables', 'Document Types')

//Report 24
'Click on Document Class User Group Security Summary Report'
CustomKeywords.'actions.Report.clickReport'('Administration', 'Document Tables', 'Document Class User Group Security Summary')

//Report 25
'Click on Document Class User to Group Report'
CustomKeywords.'actions.Report.clickReport'('Administration', 'Document Tables', 'Document Class User to Group')

//Report 26
'Click on Document Classes Field Design Report'
CustomKeywords.'actions.Report.clickReport'('Administration', 'Document Tables', 'Document Classes Field Design')

//Report 27
'Click on Search Class Details Report'
CustomKeywords.'actions.Report.clickReport'('Administration', 'Search Management', 'Search Class Details')

//Report 28
'Click on Search Class Design Report'
CustomKeywords.'actions.Report.clickReport'('Administration', 'Search Management', 'Search Class Design')

//Report 29
'Click on Search Class Security Report'
CustomKeywords.'actions.Report.clickReport'('Administration', 'Search Management', 'Search Class Security')

//Report 30
'Click on EDM Details Report'
CustomKeywords.'actions.Report.clickReport'('Administration', 'Search Management', 'EDM Details')

//Report 31
'Click on EDM Search Class Report Report'
CustomKeywords.'actions.Report.clickReport'('Administration', 'Search Management', 'EDM Search Class Report')

//Report 32
'Click on EDM User Group and User Security Report'
CustomKeywords.'actions.Report.clickReport'('Administration', 'Search Management', 'EDM User Group and User Security')

//Report 33
'Click on BPM Activity Assigned Users and UserGroups Report'
CustomKeywords.'actions.Report.clickReport'('Administration', 'Search Management', 'BPM Activity Assigned Users and UserGroups')

//Report 34
'Click on Summary of Documents by Class and Type Report'
CustomKeywords.'actions.Report.clickReport'('System Stat Reports', 'Document Management Statistics', 'Summary of Documents by Class and Type')

//Report 35
'Click on New Document addition for Date Range Report'
CustomKeywords.'actions.Report.clickReport'('System Stat Reports', 'Document Management Statistics', 'New Document addition for Date Range')

//Report 36
'Click on Modified Documents by Date Range Report'
CustomKeywords.'actions.Report.clickReport'('System Stat Reports', 'Document Management Statistics', 'Modified Documents by Date Range')

//Report 37
'Click on Access Summaries by Period Report'
CustomKeywords.'actions.Report.clickReport'('System Stat Reports', 'Document Management Statistics', 'Access Summaries by Period')

//Report 38
'Click on Audit Report for Single Document Report'
CustomKeywords.'actions.Report.clickReport'('System Stat Reports', 'Document Management Statistics', 'Audit Report for Single Document')

//Report 39
'Click on Related Document for Single Doc Report'
CustomKeywords.'actions.Report.clickReport'('System Stat Reports', 'Document Management Statistics', 'Related Document for Single Doc')

//Report 40
'Click on Revision History For Single Document Report'
CustomKeywords.'actions.Report.clickReport'('System Stat Reports', 'Document Management Statistics', 'Revision History For Single Document')

//Report 41
'Click on Deleted Document Waiting for Purge Report'
CustomKeywords.'actions.Report.clickReport'('System Stat Reports', 'Document Management Statistics', 'Deleted Document Waiting for Purge')

//Report 42
'Click on All Work Items in Error Report'
CustomKeywords.'actions.Report.clickReport'('System Management', 'System Health', 'All Work Items in Error')

//Report 43
'Click on All Looping Workitems Report'
CustomKeywords.'actions.Report.clickReport'('System Management', 'System Health', 'All Looping Workitems')

//Report 44
'Click on Engine Activity Status Report'
CustomKeywords.'actions.Report.clickReport'('System Management', 'System Health', 'Engine Activity Status')

//Report 45
'Click on Engine Throughput Today Report'
CustomKeywords.'actions.Report.clickReport'('System Management', 'System Health', 'Engine Throughput Today')
