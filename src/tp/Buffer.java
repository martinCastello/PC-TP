package tp;

class Buffer {
	
	private int n;
	private Runnable[] data;
	private int begin = 0, end = 0;
	
	//Capaz no es necesario asignarle un tamano
	public Buffer(int tamano) {
		this.n = tamano;
		this.data = new Runnable[this.n+1];
	}
	
	public synchronized void push(Runnable o) throws InterruptedException {
		while (isFull()) wait();
		data[begin] = o;
		begin = next(begin);
		notifyAll();
	}
	
	public synchronized Runnable pop() throws InterruptedException {
		while (isEmpty()) wait();
		Runnable result = data[end];
		end = next(end);
		notifyAll();
		return result;
	}
	
	private boolean isEmpty() { return begin == end; }

	private boolean isFull() { return next(begin) == end; }

	private int next(int i) { return (i+1) % (n+1); }

}