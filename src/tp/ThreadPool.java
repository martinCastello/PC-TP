package tp;

import java.util.Date;

public class ThreadPool {
	
	private Buffer buffer;
	private Countdown counter;
	private SortedList sortedList;
	private int quantityWorkers = 0;
	
	public ThreadPool(int quantityWorkers, int capacity, Date initialDate) {
		this.quantityWorkers = quantityWorkers;
		LatinWorker[] workers = new LatinWorker[quantityWorkers];
		this.buffer = new Buffer(capacity); 
		this.counter = new Countdown(capacity);
		this.sortedList = new SortedList();
		for(int i=0; i<quantityWorkers; i++) {
			workers[i] = new LatinWorker(this.buffer, this.counter, this.sortedList, initialDate);
			workers[i].start();
		}
	}
	
	synchronized void launch(Runnable work_unit) throws InterruptedException {
		buffer.push(work_unit);
	}
	
	synchronized void stop() throws InterruptedException {
		for(int i=0;i<quantityWorkers;i++) {
			buffer.push(new PoisonPill());
		}
	}
}
