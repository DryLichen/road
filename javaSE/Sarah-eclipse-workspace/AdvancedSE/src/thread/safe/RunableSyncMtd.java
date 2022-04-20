package thread.safe;

public class RunableSyncMtd {
	public static void main(String[] args) {
		Ticket r = new Ticket();
		Thread thread1 = new Thread(r, "淘票票");
		Thread thread2 = new Thread(r, "猫眼");
		Thread thread3 = new Thread(r, "丝芭");

		thread1.start();
		thread2.start();
		thread3.start();
	}
}

class Ticket implements Runnable {
	private int total = 100;

	public void run() {
		for (;;) {
			show();
		}
	}
	
	public synchronized void show() {//this
		if (total > 0) {
			try {
				Thread.sleep(50);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(Thread.currentThread().getName() + "提示，出票成功！编码为：" + total);
			total--;
		}
	}
}