package org.alg.hilos.ejemplos;

import org.alg.hilos.ejemplos.runnable.ImprimirFrases;

public class EjemploSincronizacionThread {

	public static void main(String[] args) throws InterruptedException {
		new Thread(new ImprimirFrases("Hola ", "¿Qué tal?")).start();
		new Thread(new ImprimirFrases("¿quién eres ", "tú?")).start();
		Thread.sleep(100);
		Thread h3 = new Thread(new ImprimirFrases("Muchas ", "gracias, amigo!"));
		h3.start();
		Thread.sleep(100);
		System.out.println(h3.getState());
		

	}
	
	public synchronized static void imprimirFrases(String frase1, String frase2) {
		System.out.print(frase1);
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(frase2);
	}

}
