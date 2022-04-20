package objecttestone;
//方法值传递机制的练习
public class PassObject {

	public static void main(String[] args) {
		PassObject test = new PassObject();
		Circle c = new Circle();
		test.printAreas(c, 5);
		System.out.print("Now radius is: " + c.radius);
	}
	
	public void printAreas(Circle c, int time) {
		System.out.println("Radius" + "\t\t" + "Area");
		
		for(int i = 1; i <= time; i++) {
			c.radius = i;
			System.out.println(c.radius + "\t\t" + c.findArea());
		}
		
		c.radius = ++time;
	}

}
