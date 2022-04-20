package reflect;

public class StProxyTest {
	
	public static void main(String[] args) {
		
		ClothFactory brand = new Nike();
		ClothFactory proxy = new ClothProxy(brand);
		proxy.produce();
	}
	
}

interface ClothFactory {
	
	void produce();
	
}

class ClothProxy implements ClothFactory {
	
	private ClothFactory factory;
	
	public ClothProxy(ClothFactory factory) {
		this.factory = factory;
	}
	
	public void produce() {
		System.out.println("代工厂接单");
		
		factory.produce();
		
		System.out.println("代工厂出货");
	}
	
}

class Nike implements ClothFactory {

	@Override
	public void produce() {
		System.out.println("Nike产品");
	}
	
}