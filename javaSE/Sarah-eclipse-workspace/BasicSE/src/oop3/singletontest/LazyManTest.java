package oop3.singletontest;

public class LazyManTest {

	public static void main(String[] args) {
		
		LazyMan lazy1 = LazyMan.getInstance();
		System.out.println(lazy1);
		LazyMan lazy2 = LazyMan.getInstance();
		System.out.println(lazy1 == lazy2);
		
	}
	
}

class LazyMan {
	
	private LazyMan() {}
	
	private static LazyMan lazy = null;
	
	public static LazyMan getInstance() {
		if(lazy == null) {
			lazy = new LazyMan();
		}
		return lazy;
	}
}
