package oop2.supertest;

public class Account {
	private int id;
	private double balance;
	private double annualInterestRate;
	
	public Account() {
		
	}
	public Account(int id, double balance, double annualInterestRate) {
		super();
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
	
	public void withdraw(double amt) {
		if(amt > balance && amt >= 0) {
			System.out.println("余额不足");
		}else if(amt < 0) {
			System.out.println("错误的金额");
		}else{
			balance -= amt;
			System.out.println("取出金额为：" + amt);
		}
	}
	
	public void deposit(double amt) {
		if(amt < 0) {
			System.out.println("错误数据");
		}else {
			balance += amt; 
			System.out.println("存入：" + amt);
		}
	}
}
