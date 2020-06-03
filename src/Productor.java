
/* b) Una clase productor (que extienda de Thread) que agregue números naturales consecutivos
a un buffer dado al momento de creación. */


class Productor extends Thread {
	
	private final Buffer buffer ;
	
	public Productor(Buffer buffer) {
		this.buffer = buffer;
	}
	
	public void run() {
		int i = 0;
		while (true) {
			buffer.write(i);
			i++;
		}
	}
}