package oop3.abstr;

import java.util.Scanner;

public class PayrollSystem {
	
	public static void main(String[] args) {
		
		Employee[] em = new Employee[2];
		em[0] = new SalariedEmployee("sa", 1131, new MyDate(1999, 11, 11), 1291);
		em[1] = new HourlyEmployee("jack", 1002, new MyDate(1987, 2, 23), 200, 7);
		
		System.out.println("Please input the month: ");
		Scanner scan = new Scanner(System.in);
		int month = scan.nextInt();
		
		for(int i = 0;i < em.length;i++) {
			System.out.println(em[i].toString());
			System.out.println(em[i].earnings());
			System.out.println(em[i].add(month));
			
		}
		
	}

}
