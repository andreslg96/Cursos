package com.alg;

import java.util.Scanner;

public class Series {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  Scanner in = new Scanner(System.in);
	        int t=in.nextInt();
	        for(int i=0;i<t;i++){
	            int a = in.nextInt();
	            int b = in.nextInt();
	            int n = in.nextInt();
	            
	            String s = "";
	            for (int j = 0; j<n; j++) {
	            	int k = 0;
	            	int l =(int) (a+((Math.pow(2, j))*b));
	            	k += l ;
	            	k += l - b - a;
	            	s += String.valueOf(k)+" ";
	            	 
	            }
	            System.out.println(s);
	           
	           
	            
	        }
	        in.close();
	        System.out.println((long)(Math.pow(2,63)));

	}

}
