package by.iba.shimanski.dates;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

public class DatesDifference {
	
	public static int getDiffWithoutTime(Date inputDate) {
		int days = -1;
		if (inputDate != null) {
			Date date = new Date();
			Date date2 = inputDate;
			SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
			
			String d1 = format.format(date);
			String d2 = format.format(date2);
			
			try {
			    date = format.parse(d1);
			    date2 = format.parse(d2);
			} catch (Exception e) {
			    e.printStackTrace();
			}
			
			long difference = date.getTime()  - date2.getTime();
			days = Math.abs((int) (difference/(24*60*60*1000)));
		}
		else {
			System.out.println("No inputed date :( Please, input date.");
		}
		return days;
	}
	
	public static long[] getDiffWithTime(Date inputDate) {
		long[] result = new long[4];
		if (inputDate != null) {
			Date date = new Date();
			Date date2 = inputDate;
			SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
			format.setTimeZone(TimeZone.getTimeZone("GMT"));
			String d1 = format.format(date);
			String d2 = format.format(date2);
			
			try {
			    date = format.parse(d1);
			    date2 = format.parse(d2);
			} catch (Exception e) {
			    e.printStackTrace();
			}
			
			long diff = inputDate.getTime() - date.getTime();
			diff = diff / 1000;
			long secs = diff % 60;
			diff = diff / 60;
			long mins = diff % 60;
			diff = diff / 60;
			long hours = diff % 24;
			diff = diff / 24;
			long days = diff;	
			//System.out.println(days + " days, " + hours + ":" + min + ":" + sec);
			result[0] = Math.abs(days);
			result[1] = Math.abs(hours);
			result[2] = Math.abs(mins);
			result[3] = Math.abs(secs);
		}
		else {
			System.out.println("No inputed date :( Please, input date.");
		}
		return result;
	}

}
