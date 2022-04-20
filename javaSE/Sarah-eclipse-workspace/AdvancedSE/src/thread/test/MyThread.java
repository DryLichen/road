package thread.test;

public class MyThread {

	public static void main(String[] args) {
		Thread1 t1 = new Thread1();
		t1.start();
		new Thread() {
			public void run() {
				for(int i = 0;i < 1000;i++) {
					if(i % 2 != 0 ) {
						System.out.println(Thread.currentThread().getName() + ":" + i);
					}
				}
			}
		}.start();
	}

}

class Thread1 extends Thread {
	public void run() {
		for(int i = 0;i < 1000;i++) {
			if(i % 2 == 0 ) {
				System.out.println(getName() + ":" + i);
			}
		}
	}
}