package com.luv2code.hibernate.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
	public static Date parseDate(String datestr) throws ParseException {
		Date theDate = formatter.parse(datestr);
		
		return theDate;
	}
	
	public static String formatDate(Date theDate) {
		String result = null;
		
		if (theDate != null) {
			result = formatter.format(theDate);
		}
		
		return result;
	}
	
	

}
