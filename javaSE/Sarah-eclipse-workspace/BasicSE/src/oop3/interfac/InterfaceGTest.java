package oop3.interfac;

public class InterfaceGTest {

	public static void main(String[] args) {
		
		ComparableCircle comp1 = new ComparableCircle(2);
		ComparableCircle comp2 = new ComparableCircle(3);
		
		System.out.println(comp1.compareTo(comp2));
	}

}

interface CompareObject{
	public int compareTo(Object o);
}

class Circle{
	
	private double radius;

	public Circle(double radius) {
		super();
		this.radius = radius;
	}
	
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
}

class ComparableCircle extends Circle implements CompareObject {

	public ComparableCircle(double radius) {
		super(radius);
	}
	@Override
	public int compareTo(Object o) {
		ComparableCircle comp = (ComparableCircle) o; 
		if(getRadius() > comp.getRadius()) {
			return 1;
		}else if(getRadius() == comp.getRadius()) {
			return 0;
		}else {
			return -1;
		}
	}
	
}