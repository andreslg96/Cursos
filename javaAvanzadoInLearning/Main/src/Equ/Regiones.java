package Equ;

public class Regiones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String cadena = "Esta es la cadena que vamos a comparar";
		
		System.out.println(cadena.regionMatches(true, 11, "Cad", 0, 3)); //(true= considerar min/mayus, toofset inidca el indice a partir del cual se compara, cadena, indice del caracter de la cadena con la que comparamos

	}

}
