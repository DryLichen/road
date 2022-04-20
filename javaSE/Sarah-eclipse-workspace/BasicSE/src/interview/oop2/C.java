package interview.oop2;

public class C extends B implements A {
	
	public static void main(String[] args) {
		
		new C().printX();
	
}
	
	//如何调用父类及接口中同名属性
	public void printX() {
		System.out.println(A.x);
		System.out.println(super.x);
	}
	
}

interface A{
	int x = 1;
}

class B{
	int x = 2;
}