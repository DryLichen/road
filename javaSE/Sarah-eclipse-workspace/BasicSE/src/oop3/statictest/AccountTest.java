package oop3.statictest;

public class AccountTest {

	public static void main(String[] args) {
		System.out.println("User" + "\t" + "Code" + "\t" + "Balance" + "\t\t" + "Interest" + "\t" + "MinBalance");

		Account user1 = new Account(1231, 31231.0);
		Account user2 = new Account(6450, 31298746.21);
		System.out.println(user1.getUser() + "\t" + user1.getCode() + "\t" + user1.getBalance() + "\t\t" + user1.getInterest() + "\t\t" + user1.getMinBalance());
		System.out.println(user2.getUser() + "\t" + user2.getCode() + "\t" + user2.getBalance() + "\t" + user2.getInterest() + "\t\t" + user2.getMinBalance());
	}

}
