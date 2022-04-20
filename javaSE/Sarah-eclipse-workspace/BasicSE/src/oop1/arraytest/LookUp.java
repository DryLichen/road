package oop1.arraytest;

import java.util.Scanner;

//二分法查找
//前提：查找对象最好有序
public class LookUp {

	public static void main(String[] args) {
		
		int[] arr = new int[] {-98,-34,-23,0,1,12,25,44,45,54,65};
		int start = 0;
		int end = arr.length - 1;
		int mid = end / 2;
		int loc = 0;
		boolean isFlag = false;
		System.out.print("Please input value: ");
		Scanner scan = new Scanner(System.in);
		int search = scan.nextInt();
		
		while(start <= end && mid < 10) {
			mid = (start + end) / 2;
			if(search == arr[mid]) {
				isFlag = true;
				loc = mid;
				break;
			}
			else if(search < arr[mid]) {
				end = mid - 1;
			}
			else {
				start = mid + 1;
			}
		}

		if(isFlag) {
			System.out.print("The location of the value is: " + (loc + 1));
		}
		else {
			System.out.print("Value is not in it.");
		}
	}

}
