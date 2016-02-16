package by.iba.shimanski.dates;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DatesDifference {
	
	public static int getDifference(Date inputDate) {
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

}
