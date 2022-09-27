package org.alg;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EXTERNA:
		while(true) {
			System.out.println("Conversor de monedas");
			System.out.println("1 - Soles Peruanos a dólares\n"
					+ "2 - Pesos mexicanos a dolares \n"
					+ "3 - Pesos colombianos a dolares \n"
					+ "4 - salir");
			System.out.print("Ingrese una opción: ");
			Scanner scanner = new Scanner(System.in);
			char opcion = scanner.next().charAt(0);
			
			switch(opcion) {
			case'1':
				convertir(3.58, "Soles peruanos");
				break;
			case'2':
				convertir(22.15, "Pesos mexicanos");
				break;
			case'3':
				convertir(3851.90, "Pesos colombianos");
				break;
			case'4':
				System.out.println("Cerrando programa");
				break EXTERNA;
			default:
				System.out.println("Ingrese una opción válida");
				break;
			}
		}

	}
	
	static void convertir(double valorDolar, String pais) {
		Scanner scanner = new Scanner(System.in);
		System.out.printf("Ingrese la cantidad de %s ", pais);
		double cantidadMoneda = scanner.nextDouble();
		
		double dolares = cantidadMoneda / valorDolar;
		dolares = (double) Math.round(dolares*100d)/100;
		
		System.out.println("Tienes $"+dolares+" dolares.");
	}

}
