package com.ashok.util.date;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static String format(Timestamp timeStamp,String format)
	{
		SimpleDateFormat sd= new SimpleDateFormat(format);
		return sd.format(timeStamp);
	}
	
	public static Date parse(String dateString,String format) throws ParseException
	{
		try {
			SimpleDateFormat sd= new SimpleDateFormat(format);
			return sd.parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}
	
	public static boolean isValidDateFormat(String strDate, String format)
	{
	    try
	    {
	    	SimpleDateFormat sdfrmt = new SimpleDateFormat(format);
	    	sdfrmt.setLenient(false);
	    	Date date =sdfrmt.parse(strDate); 
	    }
	    catch (ParseException e)
	    {
	        return false;
	    }
	    return true;
	}
}
