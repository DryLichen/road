package oop3.abstr;

public class SalariedEmployee extends Employee {
	private double monthlySalary;

	public SalariedEmployee(String name, int number, MyDate birthday, double monthlySalary) {
		super(name, number, birthday);
		this.monthlySalary = monthlySalary;
	}
	
	public double getMonthlySalary() {
		return monthlySalary;
	}
	public void setMonthlySalary(double monthlySalary) {
		this.monthlySalary = monthlySalary;
	}

	@Override
	public double earnings() {
		return monthlySalary;
	}

	@Override
	public String toString() {
		return "type: salary; " + super.toString();
	}
}
