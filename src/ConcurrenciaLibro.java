
//Paso1:Crear una clase que implemente a interfaz RUnable... Se creo la clase Productor 
public class ConcurrenciaLibro {

	public static void main(String[] args) {
		
		//PASO 2: Crear una instancia de la clase THREAD, pasandole como argumento 
		//una instancia de la clase que implementa RUNNABLE
		Producter escribe = new Producter();
		Thread hilo1 = new Thread(escribe);
		hilo1.setPriority(5);

		//PASO 3; Iniciar la ejeucion a traves del metodo START !!!!!!!!!!!!!!!!!!!!!!!!
		hilo1.start();///AQUI SE CREA UN HILO 


	}

}
