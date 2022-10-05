package org.alg.excepciones;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestExcepcion {

	public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in); 
	    
	    boolean continuarEjecucion = true;
	    
	    do {
	    	 try {
	 	    	System.out.print("Ingrese N1: ");
	 			int n1 = scanner.nextInt();
	 			System.out.print("Ingrese N2: ");
	 			int n2 = scanner.nextInt();
	 			
	 			//int resultado = n1/n2;
	 			int resultado = dividir(n1, n2);
	 			System.out.println(resultado);
	 			continuarEjecucion = false;
	 	    } catch(InputMismatchException e) {
	 	    	System.err.println("Ocurrió un error: Ingrese solo números enteros");
	 	    	e.printStackTrace(System.out);
	 	    	scanner.nextLine();
	 	    //} catch(ArithmeticException e) {
	 	    } catch(OperadorExcepcion e) {
	 	    	//System.err.println("Error: No se puede dividir entre cero");
	 	    	System.err.println("Error: "+e.getMessage());
	 	    	e.printStackTrace(System.out);
	 	    } catch (Exception e) {
	 	    	e.printStackTrace(System.out);
	 	    } finally {
	 	    	System.out.println("Se revisó la división");
	 	    }
	    	
	    } while(continuarEjecucion);	   
	}
	
	static int dividir(int n, int d){ //throws OperadorExcepcion { esto ya no es necesario por heredar de RuntimeExeption
		if (d == 0) {
			throw new OperadorExcepcion("Dividisión entre cero");
		}
		return n/d;
	}
	
}
