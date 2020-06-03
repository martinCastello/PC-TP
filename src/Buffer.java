
/* a) Un buffer (FIFO) de números enteros cuya dimensión está prefijada al momento de su
creación. */

class Buffer {
	
	private int[] data;
	private int N;
	private int begin=0;
	private int end  =0;
	
	public Buffer(int tamano) {
		this.N = tamano;
		this.data = new int[this.N + 1];
	}
	
	public synchronized void write ( int o ) {
		while (isFull())
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		data [ begin ] = o ;
		begin = next ( begin );
		notifyAll ();
	}
	
	public synchronized int read () {
		while ( isEmpty())
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		int result = data[end];
		end = next( end );
		notifyAll();
		return result;
	}
	
	private boolean isEmpty() { return begin == end; }
	private boolean isFull() { return next( begin ) == end; }
	private int next(int i) { return (i+1)%(this.N+1); }

}