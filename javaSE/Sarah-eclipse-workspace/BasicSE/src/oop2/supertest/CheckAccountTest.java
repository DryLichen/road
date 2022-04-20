package oop2.supertest;

public class CheckAccountTest {

	public static void main(String[] args) {
		CheckAccount che = new CheckAccount(1122, 20000, 0.045, 5000);
		
		che.withdraw(5000);
		System.out.println("余额：" + che.getBalance());
		System.out.println("可透支额：" + che.getOverdraft());
		
		che.withdraw(18000);
		System.out.println("余额：" + che.getBalance());
		System.out.println("可透支额：" + che.getOverdraft());
		
		che.withdraw(3000);
		System.out.println("余额：" + che.getBalance());
		System.out.println("可透支额：" + che.getOverdraft());
		
		
	}

}
