package com.alg;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method 
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Ingrese un número");
		int numero = scanner.nextInt();
		
		if(esPrimo(numero)) {
			System.out.println("Es número primo");
		}else {
			System.out.println("No es número primo");
		}

	}
	
	/**
	 * <h2>Es primo<h2>
	 * Descripción: Indica si un número es primo o no
	 * @param numero Recibe un número entero
	 * @return Retorna un valor booleano indicando si el número recibido es primo o no
	 */
	static boolean esPrimo(int numero) {
		int contador = 0;
		
		int[] numeros = new int[numero];
		for(int i = 0; i< numeros.length; i++) {
			numeros[i] = i+1;
		}
		
		for(int i : numeros) {
			if (i == 1 || i == numero) {
				continue;
			}
			if(numero%i == 0) {
				contador++;
			}
		}
		return contador == 0;
	}

}
