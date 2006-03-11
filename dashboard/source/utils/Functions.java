package utils;

import java.io.File;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Functions {

	private static DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	private static DecimalFormat doubleFormat = new DecimalFormat("########.00");
	
	public static Date stringToDate(String s) throws ParseException
	{
		return dateFormat.parse(s);		
	}
	
	
	public static String dateToString(Date d)
	{
		assert d!=null;
		return dateFormat.format(d);		
	}
	
	
	public static Long subDates(Date d1, Date d2)
	{	
		long l1 = d1.getTime();
		long l2 = d2.getTime();		
		long delta = l1-l2;
		long millscdperday = 24*60*60*1000;
		long res = (delta)/millscdperday;
		return res;
	}
	
	public static String doubleToString(Double d)
	{
		return doubleFormat.format(d);
	}
	
	
	

	public static String getFileNameExtension(String s) 
	{
        String ext = null;
        int i = s.lastIndexOf('.');

        if (i > 0 &&  i < s.length() - 1) 
        {
            ext = s.substring(i+1).toLowerCase();
        }
        return ext;
    }
	
	
}
