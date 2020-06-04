package tp;

public class ThreadPool {
	
	private Buffer buffer;
	private int quantityWorkers = 0;
	
	public ThreadPool(int quantityWorkers, long capacity) {
		LatinWorker[] workers = new LatinWorker[quantityWorkers];
		this.buffer = new Buffer((int) capacity); 
		for(int i=0; i<quantityWorkers; i++) {
			workers[i] = new LatinWorker(this.buffer);
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
