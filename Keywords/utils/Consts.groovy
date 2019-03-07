package utils

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import common.Fields

public class Consts {

	public static final String SMOKE_HOME001_STRINGFIELD = 'Chintan Shah'
	public static final String SMOKE_HOME001_FILENAME = 'Automation test document'
	public static String SMOKE_HOME001_DOCID

	public static final String SMOKE_HOME002_STRINGFIELD = 'Chintan Shah'
	public static final String SMOKE_HOME002_FILENAME = 'Automation test document'
	public static String SMOKE_HOME002_DOCID

	public static final String SMOKE_HOME003_STRINGFIELD = 'Chintan Shah'
	public static final String SMOKE_HOME003_FILENAME = 'Automation test document'
	public static String SMOKE_HOME003_DOCID

	public static final String SMOKE_HOME005_STRINGFIELD = 'Chintan Shah'
	public static final String SMOKE_HOME005_FILENAME = 'Automation test document'
	public static String SMOKE_HOME005_DOCID

	public static final String SMOKE_HOME007_BMSTRING = 'Automation test document'
	public static String SMOKE_HOME007_DOCID

	public static final String SMOKE_HOME008_BMSTRING = 'Automation test document - Document HOME008'
	public static String SMOKE_HOME008_DOCID

	public static final String SMOKE_MYWORK003_CUSTOMERNAME = 'Chintan Shah'
	public static final String SMOKE_MYWORK003_CUSTOMERDETAIL = 'Automation test document'
	public static String SMOKE_MYWORK003_DOCID

	public static final String SMOKE_CORRESPONDENCE_FIRSTNAME = 'Chintan'
	public static final String SMOKE_CORRESPONDENCE_LASTNAME = 'Shah'
	public static final String SMOKE_CORRESPONDENCE_TOEMAIL = 'c.s@abc.com'
	public static final String SMOKE_CORRESPONDENCE_TEMPLATE = 'Template1'


	public static final String SMOKE_MWS003_FILTER_DOCID = '106845'
	public static final String SMOKE_MWS003_FILTER_STARTDATETIME = '01-01-2018 12:00:00 AM'
	public static final String SMOKE_MWS003_FILTER_ENDDATETIME = '02-28-2018 12:00:00 AM'



	public static final String SMOKE_MW001_FILTERDATE = '12-12-2018'

	public static final String SMOKE_MYWORK009_CUSTOMERNAME1 = 'Chintan Shah'
	public static final String SMOKE_MYWORK009_CUSTOMERDETAIL1 = 'Automation test document'

	public static final String SMOKE_MYWORK009_CUSTOMERNAME2 = 'Atul Mirvankar'
	public static final String SMOKE_MYWORK009_CUSTOMERDETAIL2 = 'Automation test document'

	public static final String SMOKE_MYWORK018_CUSTOMERNAME = 'Chintan Shah'
	public static final String SMOKE_MYWORK018_CUSTOMERDETAIL = 'Automation test document - MYWORK018'
	public static String SMOKE_MYWORK018_DOCID

	public static final String SMOKE_MYWORK021_CUSTOMERNAME = 'Chintan Shah'
	public static final String SMOKE_MYWORK021_CUSTOMERDETAIL = 'Automation test document - MYWORK021'

	public static final String SMOKE_MYWORK022_CUSTOMERNAME = 'Chintan Shah'
	public static final String SMOKE_MYWORK022_CUSTOMERDETAIL = 'Automation test document - MYWORK022'
	public static String SMOKE_MYWORK022_DOCID

	public static final String SMOKE_MYWORK023_CUSTOMERNAME = 'Chintan Shah'
	public static final String SMOKE_MYWORK023_CUSTOMERDETAIL = 'Automation test document - MYWORK023'
	public static String SMOKE_MYWORK023_DOCID

	public static final String SMOKE_REPO001_STRINGFIELD = 'Chintan Shah'
	public static final String SMOKE_REPO001_FILENAME = 'Automation test document'

	public static String SMOKE_REPO006_SAVEDFILTER_RECORDCOUNT
	public static String SMOKE_REPO006_SAVEDFILTERNAME

	public static final String SMOKE_MWS002_CUSTOMERNAME = 'Chintan Shah'
	public static final String SMOKE_MWS002_CUSTOMERDETAIL = 'Automation test document - MWS002'
	public static String SMOKE_MWS002_DOCID

	public static final String SMOKE_MWS004_CUSTOMERNAME = 'Chintan Shah'
	public static final String SMOKE_MWS004_CUSTOMERDETAIL = 'Automation test document - MWS004'

	public static final String SMOKE_MWS007_CUSTOMERNAME = 'Chintan Shah'
	public static final String SMOKE_MWS007_CUSTOMERDETAIL = 'Automation test document - MWS007'
	public static String SMOKE_MWS007_DOCID

	public static final String SMOKE_WMI005_FIELD1 = '50'
	public static final String SMOKE_WMI005_FIELD2 = 'WMI005-Automation'
	public static final String SMOKE_WMI005_FIELD3 = 'Value 2'
	public static final String SMOKE_WMI005_FIELD4 = '20'
	public static final String SMOKE_WMI005_FIELD4V = '$20.00'
	public static final String SMOKE_WMI005_FIELD5 = '08-10-2018'
	public static final String SMOKE_WMI005_FIELD6 = '60.129'
	public static final String SMOKE_WMI005_FIELD7 = '25'
	public static final String SMOKE_WMI005_FIELD8 = 'Text Field'
	public static String SMOKE_WMI005_FIELD9
	public static final String SMOKE_WMI005_FIELD10 = 'String Field'
	public static final String SMOKE_WMI005_FIELD11 = 'Last Name'

	public static final String SMOKE_WMI006_FIELD1 = '40'
	public static final String SMOKE_WMI006_FIELD2 = 'WMI006-Automation'
	public static final String SMOKE_WMI006_FIELD3 = 'Value 3'
	public static final String SMOKE_WMI006_FIELD4 = '10'
	public static final String SMOKE_WMI006_FIELD4V = '$10.00'
	public static final String SMOKE_WMI006_FIELD5 = '08-10-2018'
	public static final String SMOKE_WMI006_FIELD6 = '70.854'
	public static final String SMOKE_WMI006_FIELD7 = '60'
	public static final String SMOKE_WMI006_FIELD8 = 'Text Field'
	public static String SMOKE_WMI006_FIELD9
	public static final String SMOKE_WMI006_FIELD10 = 'String Field'
	public static final String SMOKE_WMI006_FIELD11 = 'Middle Name'

	public static final String SMOKE_WMI007_FIELD1 = '90'
	public static final String SMOKE_WMI007_FIELD2 = 'WMI007-Automation'
	public static final String SMOKE_WMI007_FIELD3 = 'Value 1'
	public static final String SMOKE_WMI007_FIELD4 = '30'
	public static final String SMOKE_WMI007_FIELD4V = '$30.00'
	public static final String SMOKE_WMI007_FIELD5 = '08-10-2018'
	public static final String SMOKE_WMI007_FIELD6 = '90.113'
	public static final String SMOKE_WMI007_FIELD7 = '80'
	public static final String SMOKE_WMI007_FIELD8 = 'Text Field'
	public static String SMOKE_WMI007_FIELD9
	public static final String SMOKE_WMI007_FIELD10 = 'String Field'
	public static final String SMOKE_WMI007_FIELD11 = 'First Name'

	public static final String SMOKE_REPO002_DOCID = '100003'
	public static final String SMOKE_REPO002_START_FILTER = '12-12-2018'
	public static final String SMOKE_REPO002_END_FILTER = '01-01-2019'

	public static final String SMOKE_REPO_BMDATE_DOC1 = '12-01-2018'
	public static final String SMOKE_REPO_DATERANGE_DOC1 = '12-05-2018'
	public static final String SMOKE_REPO_BMDATETIME_DOC1 = '12-10-2018 12:00:00 PM'
	public static final String SMOKE_REPO_DATETIMERANGE_DOC1 = '12-10-2018 12:00:00 PM'
	public static final String SMOKE_REPO_DATERANGE_DOC1_START_FILTER = '12-03-2018'
	public static final String SMOKE_REPO_DATERANGE_DOC1_END_FILTER = '12-07-2018'


	/* ######################## Refactored Documents ######################## */
	//Document 0 - Date time DT
	public static final String P1_REPO_BMDATE_DOC0 = '02-10-2019'
	public static final String P1_REPO_DATERANGE_DOC0 = '02-11-2019'
	public static final String P1_REPO_BMDATETIME_DOC0 = '02-13-2019 01:00:00 AM'
	public static final String P1_REPO_DATETIMERANGE_DOC0 = '02-14-2019 03:00:00 AM'
	public static final String P1_REPO_DATERANGE_DOC0_FILTER_TO = '02-09-2019'
	public static final String P1_REPO_DATERANGE_DOC0_FILTER_FROM = '02-13-2019'

	//Document 4 & 5 - Date time DT - Calender picker tests
	public static final String P1_REPO_BMDATE_DOC4 = ''
	public static final String P1_REPO_DATERANGE_DOC4 = ''
	public static final String P1_REPO_BMDATETIME_DOC4 = ''
	public static final String P1_REPO_DATETIMERANGE_DOC4 = '09-01-2018 12:00:00 AM'

	public static final String P1_REPO_BMDATE_DOC5 = '01-20-2018'
	public static final String P1_REPO_DATERANGE_DOC5 = '03-20-2018'
	public static final String P1_REPO_BMDATETIME_DOC5 = '06-20-2018 01:00:00 AM'
	public static final String P1_REPO_DATETIMERANGE_DOC5 = '09-20-2018 03:00:00 AM'

	public static final String P1_REPO_DATETIMERANGEFROM_DATE_DOC4 = '31'
	public static final String P1_REPO_DATETIMERANGEFROM_MONTH_DOC4 = 'Aug'
	public static final String P1_REPO_DATETIMERANGEFROM_YEAR_DOC4 = '2018'
	public static final String P1_REPO_DATETIMERANGEFROM_DOC4 = '08-31-2018 12:00:00 AM'
	public static final String P1_REPO_DATETIMERANGETO_DATE_DOC4 = '2'
	public static final String P1_REPO_DATETIMERANGETO_MONTH_DOC4 = 'Sep'
	public static final String P1_REPO_DATETIMERANGETO_YEAR_DOC4 = '2018'
	public static final String P1_REPO_DATETIMERANGETO_DOC4 = '09-02-2018 12:00:00 AM'

	//Document 10 - Render All Field types
	public static final String P1_REPO_FIELD1_DOC10 = '10'
	public static final String P1_REPO_FIELD2_DOC10 = 'CShah'
	public static final String P1_REPO_FIELD5_DOC10 = '01-01-2020'

	//Document 11 - Required field DT
	public static final String P1_REPO_BMTEXT_DOC11 = 'TEXT'
	public static final String P1_REPO_BMSTRING_DOC11 = 'STRING REQ'
	public static final String P1_REPO_INT_DOC11 = '30'
	public static final String P1_REPO_DATETIMEREQ_DOC11 = '07-01-2018 03:00:00 AM'
	public static final String P1_REPO_DATEREQ_DOC11 = '10-01-2018'

	//Document A-F - Date time DT - Filter test
	public static final String P1_REPO_DOCA_BMDATE = '01-01-2018'
	public static final String P1_REPO_DOCA_DATERANGE = '02-01-2018'
	public static final String P1_REPO_DOCA_BMDATETIME = '03-01-2018 01:00:00 AM'
	public static final String P1_REPO_DOCA_DATETIMERANGE = '04-01-2018 01:00:00 AM'

	public static final String P1_REPO_DOCB_BMDATE = '01-03-2018'
	public static final String P1_REPO_DOCB_DATERANGE = '02-03-2018'
	public static final String P1_REPO_DOCB_BMDATETIME = '03-03-2018 01:00:00 AM'
	public static final String P1_REPO_DOCB_DATETIMERANGE = '04-03-2018 03:00:00 AM'

	public static final String P1_REPO_DOCC_BMDATE = '01-05-2018'
	public static final String P1_REPO_DOCC_DATERANGE = '02-05-2018'
	public static final String P1_REPO_DOCC_BMDATETIME = '03-05-2018 01:00:00 AM'
	public static final String P1_REPO_DOCC_DATETIMERANGE = '04-05-2018 03:00:00 AM'

	public static final String P1_REPO_DOCD_BMDATE = '01-07-2018'
	public static final String P1_REPO_DOCD_DATERANGE = '02-07-2018'
	public static final String P1_REPO_DOCD_BMDATETIME = '03-07-2018 01:00:00 AM'
	public static final String P1_REPO_DOCD_DATETIMERANGE = '04-07-2018 03:00:00 AM'

	public static final String P1_REPO_DOCE_BMDATE = '01-09-2018'
	public static final String P1_REPO_DOCE_DATERANGE = '02-09-2018'
	public static final String P1_REPO_DOCE_BMDATETIME = '03-09-2018 01:00:00 AM'
	public static final String P1_REPO_DOCE_DATETIMERANGE = '04-09-2018 03:00:00 AM'

	public static final String P1_REPO_DOCF_BMDATE = ''
	public static final String P1_REPO_DOCF_DATERANGE = ''
	public static final String P1_REPO_DOCF_BMDATETIME = ''
	public static final String P1_REPO_DOCF_DATETIMERANGE = ''

	//Document for testing Folder configuration  (NO EDIT UNCHECKED)
	//Document 0 - Loan Application Has document
	public static final String P1_MW_DOC0_FIRSTNAME = 'Chintan'
	public static final String P1_MW_DOC0_LASTNAME = 'Shah'
	public static final String P1_MW_DOC0_AMOUNT = '5000'

	//Document 1 - Loan Application no document
	public static final String P1_MW_DOC1_FIRSTNAME = 'Chintan'
	public static final String P1_MW_DOC1_LASTNAME = 'Shah'
	public static final String P1_MW_DOC1_AMOUNT = '1000'

	//Document 2 - Loan Application no document
	public static final String P1_MW_DOC2_FIRSTNAME = 'Atul'
	public static final String P1_MW_DOC2_LASTNAME = 'Mirvankar'
	public static final String P1_MW_DOC2_AMOUNT = '2000'

	//Document 3 - Loan Application no document //Lock Document
	public static final String P1_MW_DOC3_FIRSTNAME = 'Prasad'
	public static final String P1_MW_DOC3_LASTNAME = 'Patil'
	public static final String P1_MW_DOC3_AMOUNT = '2500'

	//Document 4 - Loan Application no document // Assigned to User Group
	public static final String P1_MW_DOC4_FIRSTNAME = 'Sanyogita'
	public static final String P1_MW_DOC4_LASTNAME = 'Apte'
	public static final String P1_MW_DOC4_AMOUNT = '3000'
	public static String P1_MW_DOC4_DOCID = ''

	//Document 5 - Loan Application no document // Assign to User
	public static final String P1_MW_DOC5_FIRSTNAME = 'Manoj'
	public static final String P1_MW_DOC5_LASTNAME = 'Gosavi'
	public static final String P1_MW_DOC5_AMOUNT = '0'
	public static String P1_MW_DOC5_DOCID = ''

	//Document 6 - Loan Application no document // Assign to User
	public static final String P1_MW_DOC6_FIRSTNAME = 'Amol'
	public static final String P1_MW_DOC6_LASTNAME = 'Patil'
	public static final String P1_MW_DOC6_AMOUNT = '6000'
	public static String P1_MW_DOC6_DOCID = ''

	//Document 7 - Event for Required Field
	public static final String P1_MW_DOC7_DROPDOWN = 'Value 1'
	public static final String P1_MW_DOC7_TEXT = 'prasad'
	public static final String P1_MW_DOC7_DATE = '01-01-2018'

	//Document 8 - Event for Required Field
	public static final String P1_MW_DOC8_DROPDOWN = 'Value 2'
	public static final String P1_MW_DOC8_TEXT = 'chintan'
	public static final String P1_MW_DOC8_DATE = '01-01-2019'

	//Document for charts testing
	//Document 9 - Closure Action
	public static final String P1_MW_DOC9_CUSTNAME = 'Chintan Shah'
	public static final String P1_MW_DOC9_CUSTDESC = 'Automation test document'

	//Document 10 - Closure Action
	public static final String P1_MW_DOC10_CUSTNAME = 'Amol Patil'
	public static final String P1_MW_DOC10_CUSTDESC = 'Automation test document'

	//Documents for Date Filter (Date Required)
	public static final String P1_MW_DOCA_STARTDATE = '01-01-2018'
	public static final String P1_MW_DOCA_ENDDATE = '02-01-2018'
	public static final String P1_MW_DOCA_STARTDATETIME = '03-01-2018 01:00:00 AM'
	public static final String P1_MW_DOCA_ENDDATETIME = '04-01-2018 03:00:00 AM'

	public static final String P1_MW_DOCB_STARTDATE = '01-03-2018'
	public static final String P1_MW_DOCB_ENDDATE = '02-03-2018'
	public static final String P1_MW_DOCB_STARTDATETIME = '03-03-2018 01:00:00 AM'
	public static final String P1_MW_DOCB_ENDDATETIME = '04-03-2018 03:00:00 AM'

	public static final String P1_MW_DOCC_STARTDATE = '01-05-2018'
	public static final String P1_MW_DOCC_ENDDATE = '02-05-2018'
	public static final String P1_MW_DOCC_STARTDATETIME = '03-05-2018 01:00:00 AM'
	public static final String P1_MW_DOCC_ENDDATETIME = '04-05-2018 03:00:00 AM'

	public static final String P1_MW_DOCD_STARTDATE = '01-05-2018'
	public static final String P1_MW_DOCD_ENDDATE = ''
	public static final String P1_MW_DOCD_STARTDATETIME = '03-05-2018 01:00:00 AM'
	public static final String P1_MW_DOCD_ENDDATETIME = '04-05-2018 03:00:00 AM'

	public static final String P1_MW_DOCE_STARTDATE = ''
	public static final String P1_MW_DOCE_ENDDATE = ''
	public static final String P1_MW_DOCE_STARTDATETIME = ''
	public static final String P1_MW_DOCE_ENDDATETIME = ''

	//Documents for Date Range Filter (Date Range Required)
	public static final String P1_MW_DOCF_STARTDATE = '01-01-2018'
	public static final String P1_MW_DOCF_ENDDATE = '02-01-2018'
	public static final String P1_MW_DOCF_STARTDATETIME = '03-01-2018 01:00:00 AM'
	public static final String P1_MW_DOCF_ENDDATETIME = '04-01-2018 03:00:00 AM'

	public static final String P1_MW_DOCG_STARTDATE = '01-03-2018'
	public static final String P1_MW_DOCG_ENDDATE = '02-03-2018'
	public static final String P1_MW_DOCG_STARTDATETIME = '03-03-2018 01:00:00 AM'
	public static final String P1_MW_DOCG_ENDDATETIME = '04-03-2018 03:00:00 AM'

	public static final String P1_MW_DOCH_STARTDATE = '01-05-2018'
	public static final String P1_MW_DOCH_ENDDATE = '02-05-2018'
	public static final String P1_MW_DOCH_STARTDATETIME = '03-05-2018 01:00:00 AM'
	public static final String P1_MW_DOCH_ENDDATETIME = '04-05-2018 03:00:00 AM'

	public static final String P1_MW_DOCI_STARTDATE = '01-07-2018'
	public static final String P1_MW_DOCI_ENDDATE = '02-07-2018'
	public static final String P1_MW_DOCI_STARTDATETIME = '03-07-2018 01:00:00 AM'
	public static final String P1_MW_DOCI_ENDDATETIME = '04-07-2018 03:00:00 AM'

	public static final String P1_MW_DOCJ_STARTDATE = '01-09-2018'
	public static final String P1_MW_DOCJ_ENDDATE = '02-09-2018'
	public static final String P1_MW_DOCJ_STARTDATETIME = '03-09-2018 01:00:00 AM'
	public static final String P1_MW_DOCJ_ENDDATETIME = '04-09-2018 03:00:00 AM'

	public static final String P1_MW_DOCK_STARTDATE = ''
	public static final String P1_MW_DOCK_ENDDATE = ''
	public static final String P1_MW_DOCK_STARTDATETIME = ''
	public static final String P1_MW_DOCK_ENDDATETIME = ''

	//Documents for Date Time Filter (Date Required)
	public static final String P1_MW_DOCL_STARTDATE = '01-01-2018'
	public static final String P1_MW_DOCL_ENDDATE = '02-01-2018'
	public static final String P1_MW_DOCL_STARTDATETIME = '03-01-2018 01:00:00 AM'
	public static final String P1_MW_DOCL_ENDDATETIME = '04-01-2018 03:00:00 AM'

	public static final String P1_MW_DOCM_STARTDATE = '01-03-2018'
	public static final String P1_MW_DOCM_ENDDATE = '02-03-2018'
	public static final String P1_MW_DOCM_STARTDATETIME = '03-03-2018 01:00:00 AM'
	public static final String P1_MW_DOCM_ENDDATETIME = '04-03-2018 03:00:00 AM'

	public static final String P1_MW_DOCN_STARTDATE = '01-05-2018'
	public static final String P1_MW_DOCN_ENDDATE = '02-05-2018'
	public static final String P1_MW_DOCN_STARTDATETIME = '03-05-2018 01:00:00 AM'
	public static final String P1_MW_DOCN_ENDDATETIME = '04-05-2018 03:00:00 AM'

	public static final String P1_MW_DOCO_STARTDATE = '01-05-2018'
	public static final String P1_MW_DOCO_ENDDATE = '02-05-2018'
	public static final String P1_MW_DOCO_STARTDATETIME = '03-05-2018 01:00:00 AM'
	public static final String P1_MW_DOCO_ENDDATETIME = ''

	public static final String P1_MW_DOCP_STARTDATE = ''
	public static final String P1_MW_DOCP_ENDDATE = ''
	public static final String P1_MW_DOCP_STARTDATETIME = ''
	public static final String P1_MW_DOCP_ENDDATETIME = ''

	//Documents for Date Time Range Filter (Date Range Required)

	public static final String P1_MW_DOCQ_STARTDATE = '01-01-2018'
	public static final String P1_MW_DOCQ_ENDDATE = '02-01-2018'
	public static final String P1_MW_DOCQ_STARTDATETIME = '03-01-2018 01:00:00 AM'
	public static final String P1_MW_DOCQ_ENDDATETIME = '04-01-2018 03:00:00 AM'
	public static final String P1_MW_DOCQ_STARTDATE_DATE = '1'
	public static final String P1_MW_DOCQ_STARTDATE_MONTH = 'Jan'
	public static final String P1_MW_DOCQ_STARTDATE_YEAR = '2018'
	public static final String P1_MW_DOCQ_STARTDATETIME_DATE = '1'
	public static final String P1_MW_DOCQ_STARTDATETIME_MONTH = 'Mar'
	public static final String P1_MW_DOCQ_STARTDATETIME_YEAR = '2018'

	public static final String P1_MW_DOCR_STARTDATE = '01-03-2018'
	public static final String P1_MW_DOCR_ENDDATE = '02-03-2018'
	public static final String P1_MW_DOCR_STARTDATETIME = '03-03-2018 01:00:00 AM'
	public static final String P1_MW_DOCR_ENDDATETIME = '04-03-2018 03:00:00 AM'

	public static final String P1_MW_DOCS_STARTDATE = '01-05-2018'
	public static final String P1_MW_DOCS_ENDDATE = '02-05-2018'
	public static final String P1_MW_DOCS_STARTDATETIME = '03-05-2018 01:00:00 AM'
	public static final String P1_MW_DOCS_ENDDATETIME = '04-05-2018 03:00:00 AM'

	public static final String P1_MW_DOCT_STARTDATE = '01-07-2018'
	public static final String P1_MW_DOCT_ENDDATE = '02-07-2018'
	public static final String P1_MW_DOCT_STARTDATETIME = '03-07-2018 01:00:00 AM'
	public static final String P1_MW_DOCT_ENDDATETIME = '04-07-2018 03:00:00 AM'

	public static final String P1_MW_DOCU_STARTDATE = '01-09-2018'
	public static final String P1_MW_DOCU_ENDDATE = '02-09-2018'
	public static final String P1_MW_DOCU_STARTDATETIME = '03-09-2018 01:00:00 AM'
	public static final String P1_MW_DOCU_ENDDATETIME = '04-09-2018 03:00:00 AM'

	public static final String P1_MW_DOCV_STARTDATE = ''
	public static final String P1_MW_DOCV_ENDDATE = ''
	public static final String P1_MW_DOCV_STARTDATETIME = ''
	public static final String P1_MW_DOCV_ENDDATETIME = ''






	//	public static final String P1_REPO_FILTER_DATE = P1_REPO_DOCC_BMDATE
	//	public static final String P1_REPO_FILTER_DATE_FROM = P1_REPO_DOCC_BMDATETIME
	//	public static final String P1_REPO_FILTER_DATE_TO = P1_REPO_DOCB_BMDATE
	//	public static final String P1_REPO_FILTER_DATETIME = P1_REPO_DOCD_BMDATE
	//	public static final String P1_REPO_FILTER_DATETIME_FROM = P1_REPO_DOCB_BMDATETIME
	//	public static final String P1_REPO_FILTER_DATETIME_TO = P1_REPO_DOCD_BMDATETIME

	//	public static final String P1_REPO_BMDATE_DOC1 = '01-01-2018'
	//	public static final String P1_REPO_DATERANGE_DOC1 = '03-01-2018'
	//	public static final String P1_REPO_BMDATETIME_DOC1 = '06-01-2018 01:00:00 AM'
	//	public static final String P1_REPO_DATETIMERANGE_DOC1 = '09-01-2018 03:00:00 AM'

	//	public static final String P1_REPO_BMDATE_DOC2 = '01-15-2018'
	//	public static final String P1_REPO_DATERANGE_DOC2 = '03-15-2018'
	//	public static final String P1_REPO_BMDATETIME_DOC2 = '06-15-2018 01:00:00 AM'
	//	public static final String P1_REPO_DATETIMERANGE_DOC2 = '09-15-2018 03:00:00 AM'

	//	public static final String P1_REPO_BMDATE_DOC6 = '12-01-2018'
	//	public static final String P1_REPO_DATERANGE_DOC6 = '12-05-2018'
	//	public static final String P1_REPO_BMDATETIME_DOC6 = '12-10-2018 11:00:00 AM'
	//	public static final String P1_REPO_DATETIMERANGE_DOC6 = '12-10-2018 11:00:00 AM'
	//	public static final String P1_REPO_DATERANGE_FILTER_END = '12-07-2018'
	//	public static final String P1_REPO_DATERANGE_FILTER_START = '12-03-2018'

	//	public static final String P1_REPO_BMDATE_DOC3 = ''
	//	public static final String P1_REPO_DATERANGE_DOC3 = ''
	//	public static final String P1_REPO_BMDATETIME_DOC3 = ''
	//	public static final String P1_REPO_DATETIMERANGE_DOC3 = ''

	//	public static final String P1_REPO_RENDERALL_INTERGER_DOC1 = '10'
	//	public static final String P1_REPO_RENDERALL_STRING_DOC1 = 'CShah'
	//	public static final String P1_REPO_RENDERALL_DATE_DOC1 = '01-01-2020'

	//	public static final String P1_REPO_BMTEXT_DOC1 = 'TEXT'
	//	public static final String P1_REPO_BMSTRING_DOC1 = 'STRING REQ'
	//	public static final String P1_REPO_INT_DOC1 = '30'
	//	public static final String P1_REPO_DATETIMEREQ_DOC1 = '07-01-2018 03:00:00 AM'
	//	public static final String P1_REPO_DATEREQ_DOC1 = '10-01-2018'

	public static final String P1_REPO_CLOSURE_CUSTOMERNAME_DOC1 = 'Chintan Shah'
	public static final String P1_REPO_CLOSURE_CUSTOMERDESC_DOC1 = 'P1 - REPO - OPEN ALL DOCUMENTS'

	public static String P1_REPO014_SAVEDFILTER_RECORDCOUNT
	public static String P1_REPO014_SAVEDFILTERNAME

	public static final String P1_REPO_DATERANGEFROM_DATE_DOC4 = '31'
	public static final String P1_REPO_DATERANGEFROM_MONTH_DOC4 = 'Aug'
	public static final String P1_REPO_DATERANGEFROM_YEAR_DOC4 = '2018'
	public static final String P1_REPO_DATERANGEFROM_DOC4 = '08-31-2018'

	public static final String P1_MW084_STARTDATE = '01-01-2018'
	public static final String P1_MW084_ENDDATE = '12-31-2025'
	public static final String P1_MW084_STARTDATETIME = '06-01-2018 01:00:00 AM'
	public static final String P1_MW084_ENDDATETIME = '05-31-2025 11:00:00 PM'
	public static String P1_MW084_BMTEXT


	public static final String P1_MW087_STARTDATE = '01-15-2019'
	public static final String P1_MW087_ENDDATE = '12-15-2024'
	public static final String P1_MW087_STARTDATETIME = '06-15-2019 08:00:00 AM'
	public static final String P1_MW087_ENDDATETIME = '05-15-2024 05:00:00 PM'
	public static String P1_MW087_BMTEXT
	public static final String P1_MW035_FILTER_START = '01-14-2019'
	public static final String P1_MW035_FILTER_END = '01-16-2019'


	public static final String P1_MW_STARTDATE_DOC3 = '01-20-2019'
	public static final String P1_MW_ENDDATE_DOC3 = '12-20-2024'
	public static final String P1_MW_STARTDATETIME_DOC3 = '06-20-2019 08:00:00 AM'
	public static final String P1_MW_ENDDATETIME_DOC3 = '05-20-2024 05:00:00 PM'
	public static String P1_MW_BMTEXT_DOC3

	public static final String P1_MW095_STARTDATE = ''
	public static final String P1_MW095_ENDDATE = ''
	public static final String P1_MW095_STARTDATETIME = ''
	public static final String P1_MW095_ENDDATETIME = ''
	public static String P1_MW095_BMTEXT

	public static final String P1_MW097_STARTDATE = ''
	public static final String P1_MW097_ENDDATE = ''
	public static final String P1_MW097_STARTDATETIME = '06-01-2018 01:00:00 AM'
	public static final String P1_MW097_ENDDATETIME = ''
	public static String P1_MW097_BMTEXT

	public static final String P1_MW117_STARTDATE = '01-01-2018'
	public static final String P1_MW117_ENDDATE = ''
	public static final String P1_MW117_STARTDATETIME = ''
	public static final String P1_MW117_ENDDATETIME = ''
	public static String P1_MW117_BMTEXT






	public static final String P1_MWORK_CLOSURE_CUSTOMERNAME_DOC1 = 'Chintan Shah'
	public static final String P1_MWORK_CLOSURE_CUSTOMERDESC_DOC1 = 'Automation test document'

	public static final String P1_MW_PROCESSFORTASK_CUSTOMERNAME_DOC1 = 'Chintan Shah'
	public static final String P1_MW_PROCESSFORTASK_CUSTOMERDESC_DOC1 = 'Unlocked Document'

	public static final String P1_MW_PROCESSFORTASK_CUSTOMERNAME_DOC2 = 'Atul Mirvankar'
	public static final String P1_MW_PROCESSFORTASK_CUSTOMERDESC_DOC2 = 'Locked Document'

	public static final String P1_MW_PROCESSFORTASK_CUSTOMERNAME_DOC3 = 'Chintan Shah'
	public static final String P1_MW_PROCESSFORTASK_CUSTOMERDESC_DOC3 = 'No User Group'
	public static String P1_MW_PROCESSFORTASK_DOCID_DOC3

	public static final String P1_MW_PROCESSFORTASK_CUSTOMERNAME_DOC4 = 'Chintan Shah'
	public static final String P1_MW_PROCESSFORTASK_CUSTOMERDESC_DOC4 = 'Global Process Admin User Group'
	public static String P1_MW_PROCESSFORTASK_DOCID_DOC4

	public static final String P1_MW_PROCESSFORTASK_CUSTOMERNAME_DOC5 = 'Chintan Shah'
	public static final String P1_MW_PROCESSFORTASK_CUSTOMERDESC_DOC5 = 'No User'
	public static String P1_MW_PROCESSFORTASK_DOCID_DOC5

	public static final String P1_MW_PROCESSFORTASK_CUSTOMERNAME_DOC6 = 'Chintan Shah'
	public static final String P1_MW_PROCESSFORTASK_CUSTOMERDESC_DOC6 = 'cshah_admin user'
	public static String P1_MW_PROCESSFORTASK_DOCID_DOC6

	public static final String P1_MW_PROCESSFORTASK_CUSTOMERNAME_DOC7 = 'Chintan Shah'
	public static final String P1_MW_PROCESSFORTASK_CUSTOMERDESC_DOC7 = 'UnAssigned'
	public static String P1_MW_PROCESSFORTASK_DOCID_DOC7

	public static final String P1_MW_PROCESSFORTASK_CUSTOMERNAME_DOC8 = 'Chintan Shah'
	public static final String P1_MW_PROCESSFORTASK_CUSTOMERDESC_DOC8 = 'Assigned'
	public static String P1_MW_PROCESSFORTASK_DOCID_DOC8

	public static final String P1_MW083_STARTDATE = '01-01-2020'
	public static final String P1_MW083_STARTDATETIME = '03-30-2017 12:00:00 AM'
	public static final String P1_MW083_STARTDATE_DATE = '1'
	public static final String P1_MW083_STARTDATE_MONTH = 'Jan'
	public static final String P1_MW083_STARTDATE_YEAR = '2020'
	public static final String P1_MW083_STARTDATETIME_DATE = '30'
	public static final String P1_MW083_STARTDATETIME_MONTH = 'Mar'
	public static final String P1_MW083_STARTDATETIME_YEAR = '2017'

	public static final String P1_LOANAPPL_FIRSTNAME_DOC1 = 'Chintan'
	public static final String P1_LOANAPPL_LASTNAME_DOC1 = 'Shah'
	public static final String P1_LOANAPPL_AMOUNT_DOC1 = '30000'
	public static final String P1_LOANAPPL_AMOUNT_FILTER_FROM = '20000'
	public static final String P1_LOANAPPL_AMOUNT_FILTER_TO = '40000'


	public static final String P1_LOANAPPL_FIRSTNAME_DOC2 = 'Atul'
	public static final String P1_LOANAPPL_LASTNAME_DOC2 = 'Mirvankar'
	public static final String P1_LOANAPPL_AMOUNT_DOC2 = '10000'

	public static final String P1_LOANAPPL_FIRSTNAME_DOC3 = 'Prasad'
	public static final String P1_LOANAPPL_LASTNAME_DOC3 = 'Patil'
	public static final String P1_LOANAPPL_AMOUNT_DOC3 = '5000'

	public static final String P1_EVENTFOREQ_DROPDOWN_DOC1 = 'Value 1'
	public static final String P1_EVENTFOREQ_TEXT_DOC1 = 'prasad'
	public static final String P1_EVENTFOREQ_DATE_DOC1 = '01-01-2018'

	public static final String P1_EVENTFOREQ_DROPDOWN_DOC2 = 'Value 2'
	public static final String P1_EVENTFOREQ_TEXT_DOC2 = 'chintan'
	public static final String P1_EVENTFOREQ_DATE_DOC2 = '01-01-2019'

	public static final String P1_WMI_RO028_DATE = '01-01-2018'


	public static final String P1_WCA008_PROCESSDUETIME = '12:00:00 AM'

	public static final String P1_TIME_START = '12:00:00 AM'
	public static final String P1_TIME_END = '11:59:59 PM'

	/*
	 * Doc Class and Doc Type Variables
	 */

	public static final String DC_DATEREQUIRED = 'daterequiredsearch'
	public static final String DT_DATEREQUIRED = 'daterequiredsearch'

	public static final String DC_DATERANGEREQUIRED = 'daterangerequired'
	public static final String DT_DATERANGEREQUIRED = 'daterangerequired'

	public static final String DC_DATETIMEREQUIRED = 'Datetimerequired'
	public static final String DT_DATETIMEREQUIRED = 'Datetimerequired'

	public static final String DC_DATETIMERANGEREQUIRED = 'Datetimerangerequired'
	public static final String DT_DATETIMERANGEREQUIRED = 'Datetimerangerequired'

	public static final String TREE_EMPTY = '[Empty]'

	//DATE - TIME FORMAT
	public static final String DATETIME_APPLICATION = 'MM-dd-yyyy HH:mm:ss a'
	public static final String DATE_APPLICATION_TREE = 'MM/dd/yyyy'

	public static final String FORMAT_DATETIME = 'MM-dd-yyyy hh:mm:ss a' //TODO: Code should be done such that this value should remain fixed
	public static final String FORMAT_DATE = 'MM-dd-yyyy' //TODO: Code should be done such that this value should remain fixed
	public static final String FORMAT_TIME = 'hh:mm:ss a' //TODO: Code should be done such that this value should remain fixed

	public static final String FORMAT_DATE_TREE = 'MM-dd-yyyy' //TODO: To be deleted once code is fixed.

	public static String ORIGINAL_WINDOW_HANDLE //Not to be deleted



	/* All variable listed below are flag representing documents are successfully created.
	 *  These flags are useful for test cases which are dependent on data created in another test case*/

	public static boolean FLAG_SMOKE_MWS004 	= false
	public static boolean FLAG_SMOKE_MW003 		= false
	public static boolean FLAG_SMOKE_REPO003 	= false

	public static boolean FLAG_P1_REPO_DOC0		= false
	public static boolean FLAG_P1_REPO_DOC10	= false
	public static boolean FLAG_P1_REPO_DOC11	= false
	public static boolean FLAG_P1_DOCA_REPO		= false
	public static boolean FLAG_P1_DOCB_REPO		= false
	public static boolean FLAG_P1_DOCC_REPO		= false
	public static boolean FLAG_P1_DOCD_REPO		= false
	public static boolean FLAG_P1_DOCE_REPO		= false
	public static boolean FLAG_P1_DOCF_REPO		= false

	public static boolean FLAG_P1_MW_DOC0 		= false
	public static boolean FLAG_P1_MW_DOC1 		= false
	public static boolean FLAG_P1_MW_DOC2 		= false
	public static boolean FLAG_P1_MW_DOC3 		= false
	public static boolean FLAG_P1_MW_DOC4 		= false
	public static boolean FLAG_P1_MW_DOC5 		= false
	public static boolean FLAG_P1_MW_DOC6 		= false
	public static boolean FLAG_P1_MW_DOC7 		= false
	public static boolean FLAG_P1_MW_DOC8 		= false
	public static boolean FLAG_P1_MW_DOC9 		= false
	public static boolean FLAG_P1_MW_DOC10 		= false
	public static boolean FLAG_P1_MW_DOCA 		= false
	public static boolean FLAG_P1_MW_DOCB 		= false
	public static boolean FLAG_P1_MW_DOCC 		= false
	public static boolean FLAG_P1_MW_DOCD 		= false
	public static boolean FLAG_P1_MW_DOCE 		= false
	public static boolean FLAG_P1_MW_DOCF 		= false
	public static boolean FLAG_P1_MW_DOCG 		= false
	public static boolean FLAG_P1_MW_DOCH 		= false
	public static boolean FLAG_P1_MW_DOCI 		= false
	public static boolean FLAG_P1_MW_DOCJ 		= false
	public static boolean FLAG_P1_MW_DOCK 		= false
	public static boolean FLAG_P1_MW_DOCL 		= false
	public static boolean FLAG_P1_MW_DOCM 		= false
	public static boolean FLAG_P1_MW_DOCN 		= false
	public static boolean FLAG_P1_MW_DOCO 		= false
	public static boolean FLAG_P1_MW_DOCP 		= false
	public static boolean FLAG_P1_MW_DOCQ 		= false
	public static boolean FLAG_P1_MW_DOCR 		= false
	public static boolean FLAG_P1_MW_DOCS 		= false
	public static boolean FLAG_P1_MW_DOCT 		= false
	public static boolean FLAG_P1_MW_DOCU 		= false
	public static boolean FLAG_P1_MW_DOCV 		= false








	/* ####################### REFACTORED DATA ####################### */

	/* -------- TREE --------*/
	public static final String MW_LVL0 = 'Processes'
	public static final String MW_LVL1_COMPLAINTS_TEMPLATE = "Complaints Template"
	public static final String MW_LVL2_COMPLAINT_TEMPLATE = "Complaint Template"

	public static final String REPO_LVL1_COMPLAINTS_TEMPLATE = "Complaint Templates"
	public static final String REPO_LVL2_COMPLAINT_TEMPLATE = "Complaint Templates"




	/* -------- DATA --------*/

	//001 - 020 For Complaint Template
	public static final Map<Fields, String> P1_MW_DOC001 //Used in Data Creation and Validation
	public static boolean FLAG_P1_MW_DOC001 = false
	static {
		P1_MW_DOC001 = new HashMap<Fields, String>()
		P1_MW_DOC001.put(Fields.TEMPLATE_NAME, 'Template1_Automation')
		P1_MW_DOC001.put(Fields.TEMPLATE_TEXT, 'Template Text - Automation')
	}

	public static final Map<Fields, String> P1_REPO_DOC002 //Used in Data Creation and Validation
	public static boolean FLAG_P1_REPO_DOC002 = false
	static {
		P1_REPO_DOC002 = new HashMap<Fields, String>()
		P1_REPO_DOC002.put(Fields.TEMPLATE_NAME, 'Template1_Automation')
		P1_REPO_DOC002.put(Fields.TEMPLATE_TEXT, 'Template Text - Automation')
	}

	public static final Map<Fields, String> P1_REPO_DOC003 //Used in Filter Testing
	public static boolean FLAG_P1_REPO_DOC003 = false
	static {
		P1_REPO_DOC003 = new HashMap<Fields, String>()
		P1_REPO_DOC003.put(Fields.TEMPLATE_NAME, 'Template2_Automation')
		P1_REPO_DOC003.put(Fields.TEMPLATE_TEXT, 'Template Text - Automation')
	}

	public static final Map<Fields, String> P1_MW_DOC004 //Used in Filter Testing
	public static boolean FLAG_P1_MW_DOC004 = false
	static {
		P1_MW_DOC004 = new HashMap<Fields, String>()
		P1_MW_DOC004.put(Fields.TEMPLATE_NAME, 'Template2_Automation')
		P1_MW_DOC004.put(Fields.TEMPLATE_TEXT, 'Template Text - Automation')
	}

	public static final Map<Fields, String> P1_MW_DOC005 //Used in Delete operation
	public static boolean FLAG_P1_MW_DOC005 = false
	static {
		P1_MW_DOC005 = new HashMap<Fields, String>()
		P1_MW_DOC005.put(Fields.TEMPLATE_NAME, 'Template3_Automation')
		P1_MW_DOC005.put(Fields.TEMPLATE_TEXT, 'Template Text - Automation')
	}

	public static final Map<Fields, String> P1_REPO_DOC006 //Used in Delete operation
	public static boolean FLAG_P1_REPO_DOC006 = false
	static {
		P1_REPO_DOC006 = new HashMap<Fields, String>()
		P1_REPO_DOC006.put(Fields.TEMPLATE_NAME, 'Template3_Automation')
		P1_REPO_DOC006.put(Fields.TEMPLATE_TEXT, 'Template Text - Automation')
	}
	
	//021 - 040 For WMI Menu Bov, WMI Menu Default, WMI Menu DocTwoRow
	public static final Map<Fields, String> P1_WMI_DOC021 //Used in WMI Menu Testing
	public static boolean FLAG_P1_WMI_DOC021 = false
	static {
		P1_WMI_DOC021 = new HashMap<Fields, String>()
		P1_WMI_DOC021.put(Fields.CUSTOMER_ID, '200')
		P1_WMI_DOC021.put(Fields.BM_STRING, 'Test1')
		P1_WMI_DOC021.put(Fields.CUSTOMER_NAME, 'Roshan')
		P1_WMI_DOC021.put(Fields.UPLOAD_FILE, RunConfiguration.getProjectDir().replace('/', '\\')+'\\Data Files\\FileUploads\\50 Pages PDF file.pdf')
	}

	public static final Map<Fields, String> P1_WMI_DOC022 //Used in WMI Menu Testing
	public static boolean FLAG_P1_WMI_DOC022 = false
	static {
		P1_WMI_DOC022 = new HashMap<Fields, String>()
		P1_WMI_DOC022.put(Fields.CUSTOMER_ID, '200')
		P1_WMI_DOC022.put(Fields.BM_STRING, 'Test1')
		P1_WMI_DOC022.put(Fields.CUSTOMER_NAME, 'Roshan')
		P1_WMI_DOC022.put(Fields.UPLOAD_FILE, RunConfiguration.getProjectDir().replace('/', '\\')+'\\Data Files\\FileUploads\\50 Pages PDF file.pdf')
	}

	public static final Map<Fields, String> P1_WMI_DOC023 //Used in WMI Menu Testing
	public static boolean FLAG_P1_WMI_DOC023 = false
	static {
		P1_WMI_DOC023 = new HashMap<Fields, String>()
		P1_WMI_DOC023.put(Fields.CUSTOMER_ID, '200')
		P1_WMI_DOC023.put(Fields.BM_STRING, 'Test1')
		P1_WMI_DOC023.put(Fields.CUSTOMER_NAME, 'Roshan')
		P1_WMI_DOC023.put(Fields.UPLOAD_FILE, RunConfiguration.getProjectDir().replace('/', '\\')+'\\Data Files\\FileUploads\\50 Pages PDF file.pdf')
	}
	
}

