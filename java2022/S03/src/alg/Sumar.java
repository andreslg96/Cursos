package alg;

import java.util.Scanner;

public class Sumar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Ingrese número 1");
		int n1 = scanner.nextInt();
		System.out.println("Ingrese número 2");
		int n2 = scanner.nextInt();
		
		int r = n1 + n2;
		System.out.printf("La suma de %d + %d = %d\n", n1, n2, r);

	}

}
