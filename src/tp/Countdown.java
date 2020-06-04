package tp;

public class Countdown {
	private int counter;
	
	public Countdown(int counter) {
		this.counter = counter;
	}

	public synchronized void dec() throws InterruptedException {
		while (zero()) wait();
		counter--;
		if(!zero())
			notifyAll();
	}

	public synchronized boolean zero() { return counter > 0; }
}
