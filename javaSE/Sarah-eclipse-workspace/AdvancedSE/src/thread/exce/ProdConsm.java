package thread.exce;

import java.util.concurrent.locks.ReentrantLock;

//生产者与消费者问题

public class ProdConsm {
	public static void main(String[] args) {
		Productor pro = new Productor();
		Consumer con = new Consumer();
		Thread tp = new Thread(pro, "Productor");
		Thread tc = new Thread(con, "Consumer");
		Clerk cle = new Clerk(0);

	}
}

class Productor extends Clerk implements Runnable {
	private int prodamount;

	public Productor() {
		super();
	}

	public Productor(int amount, int prodamount) {
		super(amount);
		this.prodamount = prodamount;
	}

	public void run() {
		setAmount(getAmount() + prodamount);
	}
}

class Consumer extends Clerk implements Runnable {
	private int perchamount;

	public Consumer() {
		super();
	}

	public Consumer(int amount, int perchamount) {
		super(amount);
		this.perchamount = perchamount;
	}

	public void run() {
		setAmount(getAmount() - perchamount);
	}
}

class Clerk {
	private int amount;

	public Clerk() {
		super();
	}
	public Clerk(int amount) {
		super();
		this.amount = amount;
	}

	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}

	public void prod() {
		while(true) {
			if(amount < 20) {
				amount++;
				System.out.println("生产第" + amount + "个产品");
			}
			else {
				System.out.println("Too many products.");
				wait();
			}
		}
	}

	public void cons() {
		while(true) {
			if(amount > 0) {
				amount--;
				System.out.println("消费第" + amount + "个产品");
			}
			else {
				
				System.out.println("No product, please wait for a while.");
			}
		}
	}
}