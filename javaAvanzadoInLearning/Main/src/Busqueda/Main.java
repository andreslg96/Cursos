package Busqueda;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String cadenaA = "Hola";
		String cadenaB = "Hola";
		
		System.out.println(cadenaA.compareTo(cadenaB)); //Si regresa 0 es porque las cadenas son idénticas, menor a 0 si la primera es mayor y mayor a 0 si es al contrario
		
		String cadenaC = "Holo";
		System.out.println(cadenaA.compareTo(cadenaC));
		
		String cadenaD = "HOLA";
		System.out.println(cadenaA.compareTo(cadenaD)); //Dará 32, por el código ascii

	}

}
