package objecttestone;

public class TestOne {

	public static void main(String[] args) {
		Customerr cus = new Customerr("Jane", "Smith");
		Accountt acc = new Accountt(1000, 2000, 0.0123);
		cus.setAccount(acc);
		
		cus.getAccount().deposit(100);
		cus.getAccount().withdraw(960);
		cus.getAccount().withdraw(2000);
		System.out.println("Customer" + "\t" + "id" + "\t\t" + "balance" + "\t\t" + "annualInterestRate");
		System.out.println(cus.getFirstname() + "\t\t" + cus.getAccount().getId() + "\t\t" + cus.getAccount().getBalance() + "\t\t" + cus.getAccount().getAnnualInterestRate());

	}

}

class Accountt {
	private int id;
	private double balance;
	private double annualInterestRate;
	
	public Accountt() {
		
	}
	public Accountt(int id, double balance, double annualInterestRate) {
		this.id = id;
		this.balance = balance;
		this.annualInterestRate = annualInterestRate;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}
	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}
	
	public void withdraw(double amount) {
		if(amount > balance) {
			System.out.println("余额不足！");
		}else {
			balance = balance - amount;
			System.out.println("取出: " + amount);
		}
	}
	public void deposit(double amount) {
		balance = amount + balance;
		System.out.println("存入: " + amount);
	}
}

class Customerr {
	private String firstname;
	private String lastname;
	private Accountt account;
	
	public Customerr() {
		
	}
	public Customerr(String f, String l) {
		firstname = f;
		lastname = l;
	}
	
	public String getFirstname() {
		return firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public Accountt getAccount() {
		return account;
	}
	public void setAccount(Accountt account) {
		this.account = account;
	}
}

