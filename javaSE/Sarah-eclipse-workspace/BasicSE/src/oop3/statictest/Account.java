package oop3.statictest;

/*
   编写一个类实现银行账户的概念，包含的属性有“帐号”、“密码”、“存款余额”、“利率”、“最小余额”，
   定义封装这些属性的方法。账号要自动生成。编写主类，使用银行账户类，输入、输出3个储户的上述信息。
	        考虑：哪些属性可以设计成static属性。
 */

public class Account {
	
	private int user;
	private int code;
	private double balance;
	private static double interest;
	private static double minBalance = 1.0;
	private static int userinit = 1001;
	
	public Account(int code, double balance) {
		super();
		this.code = code;
		this.balance = balance;
		user = userinit++;
	}

	public int getUser() {
		return user;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public static double getInterest() {
		return interest;
	}

	public static void setInterest(double interest) {
		Account.interest = interest;
	}

	public static double getMinBalance() {
		return minBalance;
	}

}
