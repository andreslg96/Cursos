package com.alg;

import java.util.Scanner;

public class InToString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		   int n = scanner.nextInt();
		   String s = String.valueOf(n);
		   scanner.close();
		   System.out.println("El string es: "+s);

	}

}
