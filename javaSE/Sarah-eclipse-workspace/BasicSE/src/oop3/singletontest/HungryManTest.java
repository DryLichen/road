package oop3.singletontest;

public class HungryManTest {

	public static void main(String[] args) {
		HungryMan.getInstance();
	}

}

class HungryMan {
	
	private HungryMan() {}
	
	private static HungryMan hun = new HungryMan();
	
	public static HungryMan getInstance() {
		return hun;
	}
	
}