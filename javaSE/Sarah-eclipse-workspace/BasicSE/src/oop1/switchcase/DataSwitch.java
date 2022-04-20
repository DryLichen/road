package oop1.switchcase;
import java.util.Scanner;

public class DataSwitch {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please input month: ");
		int month = scan.nextInt();
		System.out.println("Please input day: ");
		int day = scan.nextInt();
		int date = 0;
		
		switch(month){
		case 12:
			date = date + 30;
		case 11:
			date = date + 31;
		case 10:
			date = date + 30;
		case 9:
			date = date + 31;
		case 8:
			date = date + 31;
		case 7:
			date = date + 30;
		case 6:
			date = date + 31;
		case 5:
			date = date + 30;
		case 4:
			date = date + 31;
		case 3:
			date = date + 28;
		case 2:
			date = date + 31;
		case 1:
			date = date + day;
		default:
			break;
		}
		System.out.println("sum of days: " + date);
	}

}
