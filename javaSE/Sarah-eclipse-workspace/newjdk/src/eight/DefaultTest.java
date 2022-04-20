package eight;

public class DefaultTest {
	public static void main(String[] args) {
		Car car = new Car();
		car.prints();
	}
}

interface Vehicle {
	default void print() {
		System.out.println("这是一辆车");
	}
	
	static void blowHorn() {
		System.out.println("按喇叭");
	}
}

interface Wheels {
//	default void print() {
//		System.out.println("四个轮胎");
//	}
	
	static void driver() {
		System.out.println("需要驾驶证");
	}
}

class Car implements Vehicle, Wheels {
	public void prints() {
		print();
//		Wheels.super.print();
		
		Vehicle.blowHorn();
		Wheels.driver();
	}
}