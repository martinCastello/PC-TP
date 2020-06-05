package tp;

public class Countdown {
	private int counter;
	
	public Countdown(int counter) {
		this.counter = counter;
	}

	public synchronized void dec() {
		counter--;
	}

	public synchronized void zero() throws InterruptedException { 
		while(counter > 0) wait(); 
	}
}
