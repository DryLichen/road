package loop;

public class PrimeNumberNew {

	public static void main(String[] args) {
		
		int count = 0;
		
		label: for (int i = 2; i <= 10000; i++) {
			for (int j = 2; j <= Math.sqrt(i); j++) {
				if (i % j == 0) {
					continue label;
				}
			}
			System.out.println("Prime number: " + i);
			count++;
		}
		System.out.println("count: " + count);
	}

}
