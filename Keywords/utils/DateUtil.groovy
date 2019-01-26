package utils

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

import org.apache.commons.lang.time.DateUtils
import org.apache.commons.lang3.StringUtils

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
		fromDateValue.replaceAll('/', '-')
		toDateValue.replaceAll('/', '-')

		def actualDate
		def fromDate
		def toDate

		try {
			actualDate = new Date().parse("MM-dd-yyyy",actualValue)
			fromDate = new Date().parse("MM-dd-yyyy",fromDateValue)
			toDate = new Date().parse("MM-dd-yyyy",toDateValue)
		}
		catch(Exception e) {
			println "Unable to parse date " +e.toString()+"\n actual date = "+actualValue+"\n from date = "+fromDateValue+"\n to date ="+toDateValue
			return false
		}

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

			case '<>'://not equal to
				if(actualDate.compareTo(referenceDate)!=0)
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
		switch(operator.toUpperCase()) {
			case '='://equal to
				if(actualDate.compareTo(referenceDate)==0)
					status=true
				break

			case '<>'://not equal to
				if(actualDate.compareTo(referenceDate)!=0)
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

			case 'NULL'://less than or equal
				if(actualDate.equals(""))
					status= true
				break

			case 'NOT NULL':
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

	public static String getCurrentDateTimeMinusDays(int days, String format) {

		ZonedDateTime date = ZonedDateTime.now().minusDays(days)
		String dateString = DateTimeFormatter.ofPattern(format).format(date)
		println "Date is :"+dateString
		return dateString
	}

	public static String getCurrentDateTimeMinusDays(int days, DateTimeFormatter format) {

		ZonedDateTime date = ZonedDateTime.now().minusDays(days)
		String dateString = date.format(format)
		println "Date is :"+dateString
		return dateString
	}

	public static String getCurrentDateTime(DateTimeFormatter _format) {
		ZonedDateTime date = ZonedDateTime.now()
		String dateString = date.format(_format)
		return dateString
	}

	public static String formatDate_Slash(String date) {
		if(StringUtils.isNotBlank(date) && date.length() >= 10) {
			return date.trim().substring(0, 10).replaceAll('-', '/')
		} else {
			return date
		}
	}

	public static String formatDate_Hyphen(String date) {
		if(StringUtils.isNotBlank(date) && date.length() >= 10) {
			return date.trim().substring(0, 10).replaceAll('/', '-')
		} else {
			return date
		}
	}

	public static String convert(String date, String currFormat, String expFormat) {

		def currFormatDate = new Date().parse(currFormat,date)
		return currFormatDate.format(expFormat)
	}
	
	
	public static String getBusinessDays(String dateStr, String format, int days){
		// format of date is passed as an argument
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		// base date which will be incremented
		Date date = sdf.parse(dateStr);
		Calendar c = Calendar.getInstance();
		// set calendar time with given date
		c.setTime(date);
		// number of days to increment
		c.add(Calendar.DAY_OF_WEEK, days);
		// check if the date after addition is a working day.
		// If not then keep on incrementing it till it is a working day
		while(!isWorkingDay(c.getTime(), c)) {
			c.add(Calendar.DAY_OF_WEEK, 1);
		}
		  return sdf.format(c.getTime());
	}
	
	private static boolean isWorkingDay(Date date, Calendar calendar) {
		calendar.setTime(date);
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		if ((dayOfWeek == 7) || (dayOfWeek == 1)) {
			return false;
		}
		return true;
	 }
}
