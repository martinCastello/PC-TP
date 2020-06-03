package tp;

/* c) Una clase consumidor (que extienda de Thread) que muestre por pantalla los valores que
toma de un buffer pasado al momento de su creación. */

class Consumidor extends Thread {

	private final Buffer buffer ;

	public Consumidor ( Buffer buffer ) {
		this.buffer = buffer;
	}

	public void run () {
		while ( true ) {
			Object o = buffer.read();
			System.out.println ("Leido " + o.toString());
		}
	}
}
