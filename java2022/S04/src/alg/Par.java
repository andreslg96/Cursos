package alg;

import java.util.Scanner;

public class Par {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Estructura selectiva simple: solo un if. Estructura selectiva doble: if, else. Estructura selectiva anidada
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Ingrese un número: ");
		int n = scanner.nextInt();
		
		if (n != 0) {
			if (n > 0) {
				if(n%2 == 0) {
					System.out.printf("El número %d es par positivo", n);
				}else {
					System.out.printf("El número %d es impar positivo", n);
				}
			}else {
				if(n%2 == 0) {
					System.out.printf("El número %d es par negativo", n);
				}else {
					System.out.printf("El número %d es impar negativo", n);
				}
			}
		}else {
			System.out.printf("El número %d es neutro", n);
		}

	}

}
