package oop2;

public class KidsTest {

	public static void main(String[] args) {
		Kids someKid = new Kids();
		someKid.setGender(0);
		someKid.setSalary(1);
		someKid.manOrWoman();
		someKid.employed();
	}

}

class Mankind{
	private int gender;
	private int salary;
	
	public Mankind() {
	}

	public Mankind(int gender, int salary) {
		this.gender = gender;
		this.salary = salary;
	}
	
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public void manOrWoman(){
		if(gender == 1) {
			System.out.println("Man");
		}else {
			System.out.println("Woman");
		}
	}
	public void employed(){
		if(salary == 0) {
			System.out.println("no job");
		}else {
			System.out.println("job");
		}
	}
}

class Kids extends Mankind{
	private int yearsOld;
	
	
	public Kids() {
		
	}
	public Kids(int yearsOld) {
		this.yearsOld = yearsOld;
	}

	public int getYearsOld() {
		return yearsOld;
	}
	public void setYearsOld(int yearsOld) {
		this.yearsOld = yearsOld;
	}

	public void printAge() {
		System.out.println(yearsOld);
	}
}