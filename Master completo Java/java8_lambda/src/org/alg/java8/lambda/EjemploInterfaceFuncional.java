package org.alg.java8.lambda;

import java.util.function.BiFunction;

import org.alg.java8.lambda.aritmetica.Aritmetica;
import org.alg.java8.lambda.aritmetica.Calculadora;

public class EjemploInterfaceFuncional {

	public static void main(String[] args) {
		
		//Aritmetica suma = (a, b) -> a + b;
		Aritmetica suma = Double::sum;
		Aritmetica resta = (a, b) -> a - b;
		
		Calculadora cal = new Calculadora();
		
		System.out.println(cal.computar(10, 5, suma));
		System.out.println(cal.computar(10, 5, resta));
		System.out.println(cal.computar(10, 5, (a, b) -> a*b ));
		
		System.out.println(cal.computarConBiFunction(10, 5, (a,b)->a+b));

	}
	
	

}
