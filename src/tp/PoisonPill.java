package tp;

class PoisonPill implements Runnable{
	
	public void run() {
		throw new PoisonException();
	}
}
