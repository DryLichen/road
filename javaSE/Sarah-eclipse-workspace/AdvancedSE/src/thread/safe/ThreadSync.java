package thread.safe;

public class ThreadSync {
	
	public static void main(String[] args) {
		Window t1 = new Window("淘票票");
		Window t2 = new Window("猫眼");
		Window t3 = new Window("丝芭");
		
		t1.start();
		t2.start();
		t3.start();
	}
	
}

class Window extends Thread {
	
	private static int total = 100;
	//用static修饰后无论new多少个对象都只有一个obj，因为是类的东西。
	private static Object obj = new Object();
	private String windowName;
	
	public Window(String windowName) {
		super();
		this.windowName = windowName;
	}

	public void run() {
		
		for (;;) {
			synchronized (obj) {//这里也可以写synchronized(Window.class),它只会加载一次
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
		
	}
	
}