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

	public static boolean dateTimeFilter(String operator,String actualValue,String filterValue1, String filterValue2) {
		def actualDate,filterDate1,filterDate2

		if(actualValue=="")
			actualDate="";
		else
			actualDate = new Date().parse(Consts.FORMAT_DATETIME,actualValue)

		if(filterValue1=="")
			filterDate1="";
		else
			filterDate1 = new Date().parse(Consts.FORMAT_DATETIME,filterValue1)

		if(filterValue2=="")
			filterDate2="";
		else
			filterDate2 = new Date().parse(Consts.FORMAT_DATETIME,filterValue2)

		boolean status=false
		switch(operator.toLowerCase()) {
			case '='://equal to
				if(actualDate.compareTo(filterDate1)==0)
					status=true
				break

			case '<>'://not equal to
				if(actualDate.compareTo(filterDate1)!=0)
					status=true
				break

			case '>':  //greater than
				if(actualDate.compareTo(filterDate1)>0)
					status= true
				break

			case '<'://less than
				if(actualDate.compareTo(filterDate1)<0)
					status= true
				break

			case '>=':  //greater than or equal
				if(actualDate.compareTo(filterDate1)>=0)
					status= true
				break

			case '<='://less than or equal
				if(actualDate.compareTo(filterDate1)<=0)
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
				
			case 'between'://inclusive range check
				if(filterDate1.compareTo(actualDate) * actualDate.compareTo(filterDate2) >= 0)
					status = true
				break
				
			case 'not between'://excluding range check
				if(!(filterDate1.compareTo(actualDate) * actualDate.compareTo(filterDate2) >= 0))
					status = true
				break

			default:
				status = false
				break

		}
		return status
	}

	public static boolean dateFilter(String operator,String actualValue,String filterValue1, String filterValue2) {
		def actualDate,filterDate1,filterDate2

		if(actualValue=="")
			actualDate="";
		else
			actualValue = actualValue.trim().subSequence(0, 10)
			actualDate = new Date().parse(Consts.FORMAT_DATE,actualValue)

		if(filterValue1=="")
			filterDate1="";
		else
			filterDate1 = new Date().parse(Consts.FORMAT_DATE,filterValue1)

		if(filterValue2=="")
			filterDate2="";
		else
			filterDate2 = new Date().parse(Consts.FORMAT_DATE,filterValue2)

		boolean status=false
		switch(operator.toLowerCase()) {
			case '='://equal to
				if(actualDate.compareTo(filterDate1)==0)
					status=true
				break

			case '<>'://not equal to
				if(actualDate.compareTo(filterDate1)!=0)
					status=true
				break

			case '>':  //greater than
				if(actualDate.compareTo(filterDate1)>0)
					status= true
				break

			case '<'://less than
				if(actualDate.compareTo(filterDate1)<0)
					status= true
				break

			case '>=':  //greater than or equal
				if(actualDate.compareTo(filterDate1)>=0)
					status= true
				break

			case '<='://less than or equal
				if(actualDate.compareTo(filterDate1)<=0)
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
				
			case 'between'://inclusive range check
				if(filterDate1.compareTo(actualDate) * actualDate.compareTo(filterDate2) >= 0)
					status = true
				break
			
			case 'not between'://excluding range check
				if(!(filterDate1.compareTo(actualDate) * actualDate.compareTo(filterDate2) >= 0))
					status = true
				break

			default:
				status = false
				break

		}
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

	public static String convert(String date, String currFormat, String expFormat) {

		def currFormatDate = new Date().parse(currFormat,date)
		return currFormatDate.format(expFormat)
	}


	public static String getBusinessDays(String dateStr, String format, int days){

		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date date = sdf.parse(dateStr);
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DAY_OF_WEEK, days);
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
