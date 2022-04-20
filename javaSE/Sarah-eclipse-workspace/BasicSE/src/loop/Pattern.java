package loop;

public class Pattern {

	public static void main(String[] args) {
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 4 - i; j++) {
				System.out.print('\s');
			}
			for(int z = 0; z < i + 1; z++) {
				System.out.print("* ");
			}
			System.out.println('\s');
		}
		
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < i + 1; j++) {
				System.out.print('\s');
			}
			for(int z = 0; z < 4 - i; z++) {
				System.out.print("* ");
		    }
			System.out.println('\s');

	    }
	}
}
