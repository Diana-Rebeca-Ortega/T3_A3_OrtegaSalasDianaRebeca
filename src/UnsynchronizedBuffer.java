/*
 * Esta clase UnsynchronizedBuffer implementa la interfaz Buffer y proporciona un mecanismo
 *  de comunicación entre hilos productor y consumidor utilizando un buffer
 *   compartido, pero sin sincronización.


# Problemas con esta implementación
La falta de sincronización en esta implementación puede causar problemas, como:

- Acceso concurrente: Si el hilo productor y el hilo consumidor acceden al buffer al mismo tiempo, 
   pueden producirse errores de consistencia en los datos.
   
- Pérdida de datos: Si el hilo productor escribe un valor en el buffer y el hilo consumidor lee el
   valor antes de que el productor termine de escribir, el consumidor puede leer un valor incorrecto.


 */
public class UnsynchronizedBuffer implements Buffer {
	private int buffer = -1;
	@Override
	public void blockingPut(int value) throws InterruptedException {
		/*
		  *blockingPut(int value)*
            Este método se utiliza para escribir un valor en el buffer compartido.
		 */
		System.out.printf("El productor esta escribiendo \t%2d", value);
		buffer = value;// Se asigna el valor producido por el hilo productor al buffer compartido.

		
	}

	@Override
	public int blockingGet() throws InterruptedException {
		/*
		 * *blockingGet()*
            Este método se utiliza para leer un valor del buffer compartido.

		 */
		System.out.printf("El consumidor esta leyendo \t%2d", buffer);
		return buffer;// devuelve el valor leido del buffer
	}

}
