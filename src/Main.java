
/* d) Un programa que cree un buffer de dimensión 2 y active concurrentemente un consumidor
y un productor. */

public class Main {

	public static void main ( String [] args ) {
		Buffer buffer = new Buffer(2);
		Productor p = new Productor ( buffer );
		Consumidor c = new Consumidor ( buffer );
		p.start();
		c.start();
	}

}
