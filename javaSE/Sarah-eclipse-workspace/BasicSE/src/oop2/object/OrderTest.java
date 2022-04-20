package oop2.object;

/*
 * 编写Order类，有int型的orderId，String型的orderName，
 * 相应的getter()和setter()方法，两个参数的构造器，
 * 重写父类的equals()方法：public boolean equals(Object obj)，
 * 并判断测试类中创建的两个对象是否相等。
 */

public class OrderTest {

	public static void main(String[] args) {
		Order od = new Order(8, "小拔");
		Order od1 = new Order(8, "小拔");
		System.out.println(od.equals(od1));
	}

}

class Order{
	
	private int orderId;
	private String orderName;
	
	public Order(int orderId, String orderName) {
		super();
		this.orderId = orderId;
		this.orderName = orderName;
	}
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	
	public boolean equals(Object object) {
		if(this == object) {
			return true;
		}
		if(object instanceof Order) {
			if(((Order) object).orderId == orderId && ((Order) object).orderName.equals(orderName)){
				return true;
			}
		}
		return false;
	}
	
}