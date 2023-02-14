package Equ;

public class Equ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String nombre = "José";
		String nombreA = "José";
		
		if(nombre.equals("José")) { //no será igual si por ejemplo la j fuese minúscula, a menos que usemos equalsIgnoreCase
			System.out.println("Iguales");
		}
		
		if(nombre.equalsIgnoreCase("josé")) {
			System.out.println("Iguales");
		}
		
		if(nombre.equals(nombreA)) {
			System.out.println("Iguales");
		}

	}

}
