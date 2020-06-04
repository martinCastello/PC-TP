package tp;

public class DummyTask implements Runnable{

	private int id;
	
	public DummyTask(String s) {
		this.id = id;
	}
	
	@Override
	public void run() {
		
		System.out.println("Task ["+ this.id + "] running");
		//Realizar la matriz y verificar si es latino? o la tarea de verificar es del worker? Aca es el output de las OK (1,4,7,9)?
	}

}
