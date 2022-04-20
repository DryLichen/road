package loop;

import java.util.Scanner;

public class CommonFactor {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please input m: ");
		int m = scan.nextInt();
		System.out.println("Please input n: ");
		int n = scan.nextInt();
		int factor = 1;
		int multiple = 0;
		
		for(int i = 1; i <= m; i++) {
			if(m % i == 0 && n % i == 0) {
				factor = i;
			}
		}
		
		for(int j = 1; j <= m * n; j++) {
			if(j % m == 0 && j % n == 0) {
				multiple = j;
				break;
			}
		}

		System.out.println("the max common factor = " + factor + " ; " + "the min common multiple = " + multiple);
	}

}
