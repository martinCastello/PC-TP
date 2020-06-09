package tp;

public class LatinWorker extends Thread{

	private Buffer work_buffer;
	private Countdown counter; 
	private SortedList sortedList;
	private int number;
	
	public LatinWorker(Buffer buffer, Countdown counter, SortedList sortedList, int i) {
		this.work_buffer = buffer;
		this.counter = counter;
		this.sortedList = sortedList;
		this.number = i;
	}
	
	public void run() {
		try {
			while(true) {
				Runnable task = work_buffer.pop();
				try {
					task.run();
					DummyTask dummyTask = (DummyTask) task;
					System.out.println("LatinWorker[" + this.number + "] ejecutó tarea [" + dummyTask.getNumRow() + "]");
					sortedList.insert(dummyTask.getNumRow());
					counter.dec();
				} catch(NoPerfectException e) {
					DummyTask dummyTask = (DummyTask) task;
					System.out.println("LatinWorker[" + this.number + "] ejecutó tarea [" + dummyTask.getNumRow() + "]");
					counter.dec();
				} catch(PoisonException e) {
					throw new PoisonException();
				}	
			}
		} catch(PoisonException e) {
			System.out.println("LatinWorker[" + this.number + "] terminó");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
