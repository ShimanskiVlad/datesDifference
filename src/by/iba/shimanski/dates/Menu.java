package by.iba.shimanski.dates;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Menu {
	private Scanner sc = new Scanner(System.in);
	private Date date;
	
	public void mainMenu() {
		System.out.println("1. Input new date without time.");
		System.out.println("2. Input new date with time.");
		System.out.println("3. Get difference between dates without time.");
		System.out.println("4. Get difference between dates with time.");
		System.out.println("5. Show inputed date.");
		System.out.println("6. Exit.\n");
		int choice = getChoice(6);
		switch(choice) {
			case 1:
				date = inputDateWithoutTime();
				mainMenu();
				break;
			case 2:
				date = inputDateWithTime();
				mainMenu();
				break;
			case 3:
				showDatesDiffWithoutTime();
				mainMenu();
				break;
			case 4:
				showDatesDiffWithTime();
				mainMenu();
				break;
			case 5:
				showInputedDate();
				mainMenu();
				break;
			case 6:
				System.out.println("Thank you! Good bye! :)");
				break;
		}
			
	}
	
	private void showInputedDate() {
		SimpleDateFormat format = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String dateToStr = format.format(date);
		System.out.println(dateToStr);

	}

	private void showDatesDiffWithTime() {
		long[] mas = DatesDifference.getDiffWithTime(date);
		System.out.println("Difference is " + mas[0] + " days, " + mas[1] + ":" + mas[2] + ":" + mas[3] + ".\n");
		
	}

	private Date inputDateWithTime() {		
		return MyInput.inputDateWithTime();
	}

	private void showDatesDiffWithoutTime() {
		System.out.println("Difference is " + DatesDifference.getDiffWithoutTime(date) + " days.\n");
	}

	private Date inputDateWithoutTime() {
		return MyInput.inputDateWithoutTime();
	}

	private int getChoice(int max) {
		int ans = 0;
		while (true) {
			System.out.println("Input your choice:");
			try{
				ans = Integer.parseInt(sc.next());
				if (checkChoice(ans, max)) {
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("Wrong choice :)");
			}
		}
		return ans;
	}
	
	private boolean checkChoice(int ans, int max) {
		if (ans <= max && ans > 0) {
			return true;
		}
		return false;
	}

}
