package com.alg;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class StaticInit {
	static int B;
	static int H;
	static boolean flag; 
	
	static {
		Scanner scanner = new Scanner(System.in);
		B = scanner.nextInt();
		H = scanner.nextInt();
		if(B>0 & B<100 & H>0 & H<100) {
			flag = true;
		}else {
			System.out.println("java.lang.Exception: Breadth and height must be positive");
		}
	}

	public static void main(String[] args) {
		if(flag){
			int area=B*H;
			System.out.print(area);
		}

	}

}
