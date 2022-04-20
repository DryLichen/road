package thread.safe;

public class Singleton {
	public static void main(String[] args) {
		Bank.getInstance();
	}
}

class Bank {
	private static Bank bank = null;
	
	//方法一：效率不高，因为在new Bank后，其他线程可以直接拿着对象离开，不必一直排队
	public static synchronized Bank getInstance() {
		if(bank == null) {
			bank = new Bank(); 
		}
		return bank;
	}
	
	//方法二：
//	public static Bank getInstance() {
//		if(bank == null) {
//			synchronized (Bank.class) {
//				if(bank == null){
//               	bank = new Bank();
//	            }
//			}
//		}
//		return bank;
//	}
}