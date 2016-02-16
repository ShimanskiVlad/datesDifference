package by.iba.shimanski.dates;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class MyInput {
	
	private static Scanner sc = new Scanner(System.in);
	
	public static Date inputDate() {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
		System.out.println("Input date (dd.mm.yyyy):");
		while (true) {
			String temp = sc.next();
			if(isValidDate(temp)) {
				try {
					date = format.parse(temp);
					break;
				} catch (ParseException e) {
					e.printStackTrace();
				}	
			}
			else {
				System.out.println("Input valid date (dd.mm.yyyy):");
			}
		}
		return date;
	}

	private static boolean isValidDate (String inputValue) {
        Calendar cal = new GregorianCalendar();
        cal.setLenient(false);
        cal.clear();
        try {
            int d = Integer.parseInt(inputValue.substring (0, 2));
            int m = Integer.parseInt(inputValue.substring (3, 5));
            int y = Integer.parseInt(inputValue.substring (6, 10));
            cal.set (y, m - 1, d);
            Date dt = cal.getTime();
            return true;
        }
        catch (NumberFormatException nfe) {return false;}
        catch (IllegalArgumentException iae) {return false;}
    }
}