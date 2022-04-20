package thread.test;
//卖100张票

public class RunableTest {
	
	public static void main(String[] args) {
		Tickets r = new Tickets();
		Thread thread1 = new Thread(r, "淘票票"); 
		Thread thread2 = new Thread(r, "猫眼"); 
		Thread thread3 = new Thread(r, "丝芭"); 
		
		thread1.start();
		thread2.start();
		thread3.start();
	}
}

class Tickets implements Runnable {
	private int total = 100;
	
	@Override
	public void run() {
		for(;;) {
			if(total > 0) {
				System.out.println(Thread.currentThread().getName() + "提示，出票成功！编码为：" + total);
				total--;
			}else {
				break;
			}
		}
	}
	
//	public void start() {
//		System.out.println("启动线程：" + threadName);
//		if(t == null) {
//			t = new Thread(this, threadName);
//			t.start();
//		}
//	}
}