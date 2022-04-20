package thread.exce;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//两个储户同时向一个账户存钱，每次存1000，存3次。每次都打印账余额

public class LockTest {
	public static void main(String[] args) {
		Account acc = new Account();
		Thread user1 = new Thread(acc, "user1");
		Thread user2 = new Thread(acc, "user2");

		user1.start();
		user2.start();
	}
}

//class Account implements Runnable {
//	private int balance = 0;
//	Lock lk = new ReentrantLock();
//
//	public void run() {
//		for (int i = 0; i < 3; i++) {
//			lk.lock();
//			try {
//				Thread.sleep(50);
//				balance += 1000;
//				System.out.println(Thread.currentThread().getName() + ";" + "balance: " + balance);
//			} 
//			catch (InterruptedException e) {
//				e.printStackTrace();
//			} 
//			finally {
//				lk.unlock();
//			}
//		}
//	}
//}

class Account implements Runnable {
	private int balance = 0;

	public void run() {
		for (;;) {
			synchronized (this) {
				if (balance < 3000) {
					try {
						Thread.sleep(100);
						balance += 1000;
						System.out.println(Thread.currentThread().getName() + ";" + "balance: " + balance);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
