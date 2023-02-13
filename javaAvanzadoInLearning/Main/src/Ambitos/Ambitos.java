package Ambitos;

public class Ambitos {
	//Ambito de clase o global, hasta el método2
	int numeroM;
	String nombre;
	boolean boleano;
	public void metodo() {
		
	}
	
	public void metodo2() {
		
	}
	
	//Ámbito de método
	int sumar() {
		int dato=0;
		return dato;
	}
	
	//Ámbito de bloque, la h está dentro del for y no puede ser asignada fuera
	public void metodo3() {
		for (int i = 0; i<10; i++) {
			int h = 20;
		}
		//h = 90;
	}

}
