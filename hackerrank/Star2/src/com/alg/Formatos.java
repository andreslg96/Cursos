package com.alg;

import java.util.Scanner;

public class Formatos {
	public static void main(String[] args) {
	      Scanner sc = new Scanner(System.in);
	      System.out.println("============================");
	      for(int i=0;i<3;i++){
	          String s1 = sc.next();
	          int x = sc.nextInt();
	          sc.nextLine();
	          System.out.printf("%-13s %03d",s1,x);
	     }
	      System.out.println("");
	      double n =1.25036;
	      System.out.printf("%.3f %n", n);
	      
	      int x=10;
	      System.out.printf("%d %n",x);
	      System.out.printf("%15d %n",x);
	      
	      String v ="Hola Iktan";
	      System.out.printf("%15s %n", v);
	      System.out.printf("%-15s %n", v);
	      
	      System.out.printf("n = %.2f x = %d %n", n, x);
	      
	      double m = 123.4567;
	      System.out.printf("El cuadarado de %.2f es %.2f\n", m, m*m);
	      
	      double l = 1.25036;
	      System.out.printf("%+10.2f %n", l);
	      System.out.printf("%+010.2f %n", l);
	      System.out.printf("%10s %n","Total:");
	      
	      double q =1.0/3.0;
	      System.out.printf("1.0/3.0 = %5.3f %n",q);
	      System.out.printf("1.0/3.0 = %7.5f %n",q);
	      q = 1.0/2.0;
	      System.out.printf("1.0/2.0 = %09.3f %n",q);
	      q = 1000.0/3.0;
	      
	      int r =15;
	      System.out.printf("El valor de la Variable es: %015d %n",r);
	      
	      double y=3.1415;
	      System.out.printf("El valor de la Variable es: %-15.7f %n",y);
	      
	      String p = "Hola Mundo";
	      
	      System.out.printf("%20s %20s %20s %n","Numero de Control","Alumno","Calificacion");
	      System.out.printf("%20s %20s %20s %n","No.","Alumno","Calificacion");
	      System.out.printf("%-20s %-20s %-20s %n","No.","Alumno","Calificacion");
	      System.out.println("================================");
	    }

}
