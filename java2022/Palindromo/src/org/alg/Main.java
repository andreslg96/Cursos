package org.alg;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("Ingrese un texto: ");
		String cadena = scanner.nextLine();
		
		if (esPalindromo(cadena)) {
			System.out.println("Es palindromo");
		}else {
			System.out.println("No es palindromo");
		}

	}
	
	static boolean esPalindromo(String cadena) {
		
		cadena = cadena.replace(" ", "");
		cadena = cadena.toLowerCase();
		
		StringBuilder cadenaInvertida = new StringBuilder();
		
		for (int i = cadena.length()-1; i >= 0; i--) {
			cadenaInvertida.append(cadena.charAt(i));
		}
		
		return cadena.equals(cadenaInvertida.toString());
	}

}
