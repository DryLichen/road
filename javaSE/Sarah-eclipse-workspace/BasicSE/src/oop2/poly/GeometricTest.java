package oop2.poly;

public class GeometricTest {

	public static void main(String[] args) {
		GeometricTest geo = new GeometricTest();
		geo.equalArea(new Circle("red", 2, 3), new MyRectangle("blue", 3, 2, 1));
		geo.dispalyGeometricObject(new Circle("red", 2, 3)); 
		geo.dispalyGeometricObject(new MyRectangle("blue", 3, 2, 1)); 
	}

	public void equalArea(GeometricObject c, GeometricObject r) {
		if(c.findArea() == r.findArea()) {
			System.out.println("Their areas are equal.");
		}else {
			System.out.println("Their areas are not equal.");
		}
	}
	
	public void dispalyGeometricObject(GeometricObject g) {
		System.out.println(g.findArea());
	}
}

class GeometricObject{
	private String color;
	private double weight;
	
	public GeometricObject(String color, double weight) {
		super();
		this.color = color;
		this.weight = weight;
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public double findArea() {
		return 0;
	}
}

class Circle extends GeometricObject{
	private double radius;

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public Circle(String color, double weight, double radius) {
		super(color, weight);
		this.radius = radius;
	}

	@Override
	public double findArea() {

		return Math.PI * radius * radius;
	}
}

class MyRectangle extends GeometricObject{
	private double width;
	private double height;
	
	public MyRectangle(String color, double weight, double width, double height) {
		super(color, weight);
		this.width = width;
		this.height = height;
	}

	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public double findArea() {
		return width * height;
	}
}