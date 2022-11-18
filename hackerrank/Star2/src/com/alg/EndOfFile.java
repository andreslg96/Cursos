package com.alg;

import java.util.Scanner;

public class EndOfFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		//String l = scanner.nextLine();
		//int i = 1;
		for (int i = 1; scanner.hasNext();i++) {
			System.out.println(i+" "+scanner.nextLine());
		}
//		while (scanner.hasNext()) {
//			if (scanner.hasNext()) {
//				System.out.println(i+" "+l);
//			}
//			l = scanner.nextLine();
//			i++;
//		}
		scanner.close();
	}
}
