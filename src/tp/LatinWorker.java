package tp;

import java.util.Date;

public class LatinWorker extends Thread{

	private Buffer work_buffer;
	private Countdown counter; 
	private SortedList sortedList;
	private Date initialDate;
	
	public LatinWorker(Buffer buffer, Countdown counter, SortedList sortedList, Date initialDate) {
		this.work_buffer = buffer;
		this.counter = counter;
		this.sortedList = sortedList;
		this.initialDate = initialDate;
	}
	
	public void run() {
		try {
			while(true) {
				try {
					Runnable task = work_buffer.pop();
					task.run();
					DummyTask dummyTask = (DummyTask) task;
					counter.dec();
					sortedList.insert(dummyTask.getNumRow());
				} catch(NoPerfectException e) {
					counter.dec();
				} catch(PoisonException e) {
					throw new PoisonException();
				}	
			}
		} catch(PoisonException e) {
			try {
				counter.zero();
				System.out.println("Termine");
				System.out.println("SortedList " + sortedList.getResult());
				double seconds = (new Date().getTime() - initialDate.getTime()) / 1000.0;
				System.out.println("Tiempo transcurrido en segundos: " + seconds);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
