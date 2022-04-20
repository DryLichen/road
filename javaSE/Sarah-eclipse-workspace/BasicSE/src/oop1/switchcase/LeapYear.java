package oop1.switchcase;

import java.util.Scanner;

public class LeapYear {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please input year: ");
		int year = scan.nextInt();
		System.out.println("Please input month: ");
		int month = scan.nextInt();
		System.out.println("Please input date: ");
		int date = scan.nextInt();
		
		int sumDays = 0;
		int dateIn2;
		
		//examine whether it's a leap year
		if((year%4 == 0 && year%100 != 0) || (year%400 == 0)) {
			dateIn2 = 29;
		}
		else {
			dateIn2 = 28;
		}

		//calculate the sum of days
		switch(month){
		case 12:
			sumDays = sumDays + 30;
		case 11:
			sumDays = sumDays + 31;
		case 10:
			sumDays = sumDays + 30;
		case 9:
			sumDays = sumDays + 31;
		case 8:
			sumDays = sumDays + 31;
		case 7:
			sumDays = sumDays + 30;
		case 6:
			sumDays = sumDays + 31;
		case 5:
			sumDays = sumDays + 30;
		case 4:
			sumDays = sumDays + 31;
		case 3:
			sumDays = sumDays + dateIn2;
		case 2:
			sumDays = sumDays + 31;
		case 1:
			sumDays = sumDays + date;
		default:
			break;
		}
		System.out.println("the sum of days is: " + sumDays);
	}

}
