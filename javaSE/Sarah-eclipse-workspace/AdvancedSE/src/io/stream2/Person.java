package io.stream2;

import java.io.Serializable;

public class Person implements Serializable {
	public final static long serialVersionUID = 479284243842L;
	
	String name;
	String address;
	int age;
	transient int SSN;
	static boolean gender = false;
	
	
	public Person(String name, String address, int age, int sSN) {
		super();
		this.name = name;
		this.address = address;
		this.age = age;
		SSN = sSN;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSSN() {
		return SSN;
	}
	public void setSSN(int sSN) {
		SSN = sSN;
	}
	public static boolean isGender() {
		return gender;
	}
	public static void setGender(boolean gender) {
		Person.gender = gender;
	}
	
    
	

	@Override
	public String toString() {
		return "String: " + name + " ;Address: " + address + " ;Age: " + age + " ;SSN: " + SSN;
	}

	public String work() {
		return "Be working";
	}
}
