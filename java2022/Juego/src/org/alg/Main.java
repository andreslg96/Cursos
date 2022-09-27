package org.alg;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OUTER:
		while(true) {
			System.out.println("   Juego adivina el número");
			System.out.println("1 - Fácil\n"
					+"2 - Medio\n"
					+"3 - Difícil\n"
					+"4 - Salir");
			Scanner scanner = new Scanner(System.in);
			System.out.print("Ingrese una opción: ");
			int opcion = scanner.nextInt();
			
			switch(opcion) {
			case 1:
				jugar(10);
				break;
			case 2:
				jugar(7);
				break;
			case 3:
				jugar(5);
				break;
			case 4:
				System.out.println("Cerrando programa");
				break OUTER;
			default:
				System.out.println("Opción no válida");
			}
		}
	}
	
	static void jugar(int vidas) {
		int numeroRandom = (int)(Math.random()*101);
		int numeroElegido = -1;
		
		Scanner scanner = new Scanner(System.in);
		
		while(numeroElegido != numeroRandom) {
			System.out.print("Ingrese un número entre 1 y 100: ");
			numeroElegido = scanner.nextInt();
			
			if(numeroRandom < numeroElegido) {
				System.out.println("El número es más pequeño");
				vidas--;
			}else if(numeroRandom> numeroElegido) {
				System.out.println("El número es más grande");
				vidas--;
			}
			
			if(vidas == 0) {
				System.out.println("--------------");
				System.out.println("You died");
				System.out.println("--------------");
				break;
			}
			System.out.println("--------------");
			System.out.printf("Te quedan %d vidas \n",vidas);
			System.out.println("--------------");
		}
		
		if (numeroElegido == numeroRandom) {
			System.out.println("--------------");
			System.out.println("Ganaste");
			System.out.println("--------------");
		}
	}

}
