package Equ;

public class StartEnd {
	
	public static void main(String[] arg) {
		
		String cadena = new String("Hola José, esta es una cadena");
		
		if(cadena.startsWith("Hole")) { //prueba con Hol
			System.out.println("Sí");
		}else {
			System.out.println("no");
		}
		
		if(cadena.endsWith("ena")) {
			System.out.println("Si");
		}else {
			System.out.println("No");
		}
		
	}

}
