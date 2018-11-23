package utils

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.time.LocalDateTime
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

import org.apache.commons.lang.time.DateUtils

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
import internal.GlobalVariable as GlobalVariable

public class DateUtil {
	public static boolean validateRecordIsBetweenDateRange(String actualValue, String fromDateValue,String toDateValue) {
		def actualDate = new Date().parse("MM-dd-yyyy",actualValue)
		def fromDate = new Date().parse("MM-dd-yyyy",fromDateValue)
		def toDate = new Date().parse("MM-dd-yyyy",toDateValue)

		if((actualDate.after(fromDate) || DateUtils.isSameDay(actualDate, fromDate))   && (actualDate.before(toDate) || DateUtils.isSameDay(actualDate, toDate))) {
			println  "Date "+actualValue+" is between date range"+fromDateValue+" - "+toDateValue
			return true
		}
		else {
			println  "Date "+actualValue+" is not between date range"+fromDateValue+" - "+toDateValue
			return false
		}
	}

	public static boolean isRecordBetweenDateRange(String actualValue, String fromDateValue, String toDateValue) {
		def actualDate = new Date().parse("MM-dd-yyyy",actualValue)
		def fromDate = new Date().parse("MM-dd-yyyy",fromDateValue)
		def toDate = new Date().parse("MM-dd-yyyy",toDateValue)

		if((actualDate.after(fromDate) || DateUtils.isSameDay(actualDate, fromDate)) && (actualDate.before(toDate) || DateUtils.isSameDay(actualDate, toDate))) {
			println  "Date "+actualValue+" is between date range"+fromDateValue+" - "+toDateValue
			return true
		}
		else {
			println  "Date "+actualValue+" is not between date range"+fromDateValue+" - "+toDateValue
			return false
		}
	}

	public static boolean isRecordDateMoreThanFilterDate(String actualValue, String fromDateValue) {
		def actualDate = new Date().parse("MM-dd-yyyy",actualValue)
		def fromDate = new Date().parse("MM-dd-yyyy",fromDateValue)

		if((actualDate.after(fromDate) || DateUtils.isSameDay(actualDate, fromDate))) {
			println  "Date "+actualValue+" is more than or equal to from date "+fromDateValue
			return true
		}
		else {
			println  "Date "+actualValue+" is not more than from date "+fromDateValue
			return false
		}
	}

	public static boolean isRecordDateLessThanFilterDate(String actualValue, String toDateValue) {
		def actualDate = new Date().parse("MM-dd-yyyy",actualValue)
		def toDate = new Date().parse("MM-dd-yyyy",toDateValue)

		if((actualDate.before(toDate) || DateUtils.isSameDay(actualDate, toDate))) {
			println  "Date "+actualValue+" is less than or equal to to date "+toDateValue
			return true
		}
		else {
			println  "Date "+actualValue+" is not less than to date "+toDateValue
			return false
		}
	}

	public static boolean verifyDateFilter(String operator,String actualValue,String referenceDateValue) {
		def actualDate,referenceDate

		if(actualValue=="")
			actualDate="";
		else
			actualDate = new Date().parse("MM-dd-yyyy",actualValue)

		if(referenceDateValue=="")
			referenceDate="";
		else
			referenceDate = new Date().parse("MM-dd-yyyy",referenceDateValue)

		boolean status=false
		switch(operator) {
			case '='://equal to
				if(actualDate.compareTo(referenceDate)==0)
					status=true
				break

			case '>':  //greater than
				if(actualDate.compareTo(referenceDate)>0)
					status= true
				break

			case '<'://less than
				if(actualDate.compareTo(referenceDate)<0)
					status= true
				break

			case '>=':  //greater than or equal
				if(actualDate.compareTo(referenceDate)>=0)
					status= true
				break

			case '<='://less than or equal
				if(actualDate.compareTo(referenceDate)<=0)
					status= true
				break

			case 'null'://less than or equal
				if(actualDate.equals(""))
					status= true
				break
		}
		if(status) {
			println 'date verified success'
			return status
		}
		else
			println 'date not verified'
		return status
	}
	
	@Keyword
	public static boolean verifyDateFilter(String operator,String actualValue,String referenceDateValue,String dateTimeFormat) {
		def actualDate,referenceDate

		if(actualValue=="")
			actualDate="";
		else
			actualDate = new Date().parse(dateTimeFormat,actualValue)

		if(referenceDateValue=="")
			referenceDate="";
		else
			referenceDate = new Date().parse(dateTimeFormat,referenceDateValue)

		boolean status=false
		switch(operator) {
			case '='://equal to
				if(actualDate.compareTo(referenceDate)==0)
					status=true
				break

			case '>':  //greater than
				if(actualDate.compareTo(referenceDate)>0)
					status= true
				break

			case '<'://less than
				if(actualDate.compareTo(referenceDate)<0)
					status= true
				break

			case '>=':  //greater than or equal
				if(actualDate.compareTo(referenceDate)>=0)
					status= true
				break

			case '<='://less than or equal
				if(actualDate.compareTo(referenceDate)<=0)
					status= true
				break

			case 'null'://less than or equal
				if(actualDate.equals(""))
					status= true
				break

			case 'not null':
				if(!actualDate.equals(""))
					status= true
				break
			default:
				status = false
				break
		}
		//		if(status) {
		//			println 'date verified success'
		//			return status
		//		}
		//		else
		//			println 'date not verified'
		return status
	}


	public static String getCurrentDateTime() {
		Date now = new Date()
		return now.format('yyyyMMdd_HHmmss', TimeZone.getTimeZone('UTC')).toString()
	}

	public static String getCurrentDateTime(String _format) {
		Date now = new Date()
		return now.format(_format, TimeZone.getTimeZone('UTC')).toString()
	}

	public static String getCurrentDateTimeMinusDays(int days) {

		ZonedDateTime date = ZonedDateTime.now().minusDays(days)
		String dateString = date.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
		println "Date is :"+dateString
		return dateString
	}
	
	public static String getCurrentDateTime(DateTimeFormatter _format) {
		ZonedDateTime date = ZonedDateTime.now()
		String dateString = date.format(_format)
		return dateString
	}
}
