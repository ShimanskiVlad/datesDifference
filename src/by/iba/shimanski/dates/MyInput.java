package by.iba.shimanski.dates;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class MyInput {
	
	private static Scanner sc = new Scanner(System.in);
	
	public static Date inputDateWithoutTime() {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
		System.out.println("Input date (dd.mm.yyyy):");
		while (true) {
			String temp = sc.next();
			if(isValidDateWithoutTime(temp)) {
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
	
	public static Date inputDateWithTime() {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
		System.out.println("Input date (dd.mm.yyyy hh:mm:ss):");
		while (true) {
			String temp = sc.nextLine();
			if(isValidDateWithTime(temp)) {
				try {
					date = format.parse(temp);
					break;
				} catch (ParseException e) {
					e.printStackTrace();
				}	
			}
			else {
				System.out.println("Input valid date (dd.mm.yyyy hh:mm:ss):");
			}
		}
		return date;
	}

	private static boolean isValidDateWithTime(String inputValue) {
		Calendar cal = new GregorianCalendar();
        cal.setLenient(false);
        cal.clear();
        System.out.println(inputValue);
        try {
            int day = Integer.parseInt(inputValue.substring (0, 2));
            int month = Integer.parseInt(inputValue.substring (3, 5));
            int year = Integer.parseInt(inputValue.substring (6, 10));
            int hour = Integer.parseInt(inputValue.substring(11, 13));
            int min = Integer.parseInt(inputValue.substring(14, 16));
            int sec = Integer.parseInt(inputValue.substring(17, 19));
            cal.set (year, month - 1, day, hour, min, sec);
            Date dt = cal.getTime();
            return true;
        }
        catch (NumberFormatException nfe) {return false;}
        catch (IllegalArgumentException iae) {return false;}
        catch (StringIndexOutOfBoundsException siobe) {return false;}
	}

	private static boolean isValidDateWithoutTime(String inputValue) {
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
        catch (StringIndexOutOfBoundsException siobe) {return false;}
    }

	
}
