package oop2.supertest;

public class CheckAccount extends Account {
	private double overdraft;
	
	public CheckAccount() {
		super();
	}
	public CheckAccount(int id, double balance, double annualInterestRate, double overdraft) {
		super(id, balance, annualInterestRate);
		this.overdraft = overdraft;
	}

	public double getOverdraft() {
		return overdraft;
	}
	public void setOverdraft(double overdraft) {
		this.overdraft = overdraft;
	}
	
	@Override
	public void withdraw(double am) {
		if(getBalance() > am) {
			super.withdraw(am);
		}else if(getBalance() < am && getBalance() + overdraft > am ) {
			overdraft -= (am - getBalance());
		    setBalance(0);
			System.out.println("取出：" + am);
		}else {
			System.out.println("透支额度不足");
		}	
	}
	
}
