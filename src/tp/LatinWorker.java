package tp;

public class LatinWorker extends Thread{

	private Buffer work_buffer;
	private Countdown counter; 
	
	public LatinWorker(Buffer buffer) {
		this.work_buffer = buffer;	
	}
	
	public void run() {
		try {
			while(true) {
				Runnable task = work_buffer.pop();
				task.run();
				counter.dec();
				//If task.run() == latino sortedList.insert(task.run().indice del cuadrado)
			}
		} catch(InterruptedException e) {
			System.out.println("Termine");
		} 
	}
}
