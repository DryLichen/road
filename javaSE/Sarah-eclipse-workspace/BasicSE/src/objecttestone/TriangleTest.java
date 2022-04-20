package objecttestone;

//构造器
//一个类加一个类test，类中声明私有底边长base和高height，公共方法访问私有变量，提供必要的构造器。
//另一个类中使用这些公共方法，计算三角形面积
public class TriangleTest {
	public static void main(String[] args) {
		
		Triangle tri = new Triangle();
		tri.setBase(4.0);
		tri.setHeight(5.0);
		System.out.print(tri.getArea(tri.getBase(), tri.getHeight()));
	}
}

class Triangle{
	
	private double base;
	private double height;
	
	public Triangle() {
		
	}
	
	public Triangle(double b, double h) {
		base = b;
		height = h;
	}
	
	public void setBase(double b) {
		base = b;
	}
	
	public double getBase() {
		return base;
	}
	
	public void setHeight(double h) {
		height = h;
	}
	
	public double getHeight() {
		return height;
	}
	
	public double getArea(double a, double b) {
		return a * b * 0.5;
	}
}
