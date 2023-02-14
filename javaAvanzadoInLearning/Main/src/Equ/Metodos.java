package Equ;

public class Metodos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String cadena = "Esta es una cadena para este ejemplo";
		System.out.println(cadena.charAt(2));
		
		char arreglo[] = new char[20];
		
		cadena.getChars(0, 3, arreglo, 0); //Indice del primer caracter a copiar de la cadena, cantidad de caracteres a copiar, arreglo, indice del arreglo a apartir del que se va a copiar
		System.out.println(arreglo);
		
		System.out.println(cadena.substring(6,14));
		System.out.println(cadena.substring(9));

	}

}
