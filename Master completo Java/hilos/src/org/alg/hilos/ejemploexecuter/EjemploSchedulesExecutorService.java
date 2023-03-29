package org.alg.hilos.ejemploexecuter;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class EjemploSchedulesExecutorService {

	public static void main(String[] args) {
		
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
		
		System.out.println("Alguna tarea en el main ...");
		
		executor.schedule(() ->{
			System.out.println("Hola mundo tarea...");
			try {
				TimeUnit.MILLISECONDS.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println("Hola mundo tarea..."); da igual donde se ponga
		}, 2000, TimeUnit.MILLISECONDS);
		
		System.out.println("Alguna otra tarea en el main ...");
		executor.shutdown();

	}

}
