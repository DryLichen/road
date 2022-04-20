package thread.safe;

public class ThreadSyncMtd {
	public static void main(String[] args) {
		Window1 t1 = new Window1("淘票票");
		Window1 t2 = new Window1("猫眼");
		Window1 t3 = new Window1("丝芭");

		t1.start();
		t2.start();
		t3.start();
	}
}

class Window1 extends Thread {
	private static int total = 100;
	private String Window1Name;

	public Window1(String Window1Name) {
		super();
		this.Window1Name = Window1Name;
	}

	public void run() {
		for (;;) {
			show();
		}
	}

	private static synchronized void show() {//Window1.class
		if (total > 0) {
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("出票成功！票号为：" + total);
			total--;
		}
	}
}