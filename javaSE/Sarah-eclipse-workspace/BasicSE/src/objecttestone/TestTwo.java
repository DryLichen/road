package objecttestone;

//综合实验2
public class TestTwo {
	public static void main(String[] args) {
		Bank bank = new Bank();
		bank.addCustomer("Jane", "Smith");
		bank.addCustomer("张", "三");
		System.out.println(bank.getNumberOfCustomers());
		Account acc = new Account(1000);
		bank.getCustomer(1).setAccount(acc);
		bank.getCustomer(1).getAccount().deposit(120);
		bank.getCustomer(1).getAccount().withdraw(2000);
		bank.getCustomer(1).getAccount().withdraw(200);
		System.out.println(bank.getCustomer(1).getAccount().getBalance());
	}
}

class Account{
	private double balance;
	
	public Account() {
		
	}
	public Account(double init_balance) {
		balance = init_balance;
	}
	
	public double getBalance() {
		return balance;
	}
	public void deposit(double amt) {
		balance += amt;
		System.out.println("存入" + amt);
	}
	public void withdraw(double amt) {
		if(amt > balance) {
			System.out.println("余额不足");
		}else {
			System.out.println("取出" + amt);
			balance -=amt;
		}
	}
}

class Customer{
	private String firstName;
	private String lastName;
	private Account account;
	
	public Customer() {
		
	}
	public Customer(String f, String l) {
		firstName = f;
		lastName = l;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
}

class Bank{
	private Customer[] customers;
	private int numberOfCustomers;
	
	public Bank() {
		customers = new Customer[10];
	}
	
	public void addCustomer(String f, String l) {
			customers[numberOfCustomers] = new Customer(f, l);
			numberOfCustomers++;
	}
	public int getNumberOfCustomers() {
		return numberOfCustomers;
	}
	public Customer getCustomer(int index) {
		return customers[index];
	}
}