package by.iba.shimanski.dates;

import java.util.Date;
import java.util.Scanner;

public class Menu {
	private Scanner sc = new Scanner(System.in);
	private Date date;
	
	public void mainMenu() {
		System.out.println("1. Input new date.");
		System.out.println("2. Get difference between dates.");
		System.out.println("3. Exit.\n");
		int choice = getChoice(3);
		switch(choice) {
			case 1:
				date = inputDate();
				mainMenu();
				break;
			case 2:
				showDatesDifference();
				mainMenu();
				break;
			case 3:
				System.out.println("Thank you! Good bye! :)");
				break;
		}
			
	}
	
	private void showDatesDifference() {
		System.out.println("Difference is " + DatesDifference.getDifference(date) + " days.\n");
	}

	private Date inputDate() {
		return MyInput.inputDate();
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
