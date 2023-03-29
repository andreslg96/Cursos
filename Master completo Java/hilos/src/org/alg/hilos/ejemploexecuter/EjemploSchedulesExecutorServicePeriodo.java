package org.alg.hilos.ejemploexecuter;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class EjemploSchedulesExecutorServicePeriodo {

	public static void main(String[] args) throws InterruptedException {
		
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
		
		System.out.println("Alguna tarea en el main ...");
		
		AtomicInteger contador = new AtomicInteger(5);
		//CountDownLatch lock = new CountDownLatch(5);
		//executor.scheduleAtFixedRate(() ->{
		Future<?> future = executor.scheduleAtFixedRate(() ->{
			System.out.println("Hola mundo tarea...");
			try {
				TimeUnit.MILLISECONDS.sleep(1000);
				//lock.countDown();
				contador.getAndDecrement();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println("Hola mundo tarea..."); da igual donde se ponga
		}, 1000, 2000, TimeUnit.MILLISECONDS);
		
		//TimeUnit.SECONDS.sleep(10); una forma para retrasar el shutdown	
		//lock.await();
		//future.cancel(true); //si es false, espera a que la tarea termine de ejecutar
		while(contador.get() >=0) {
			if(contador.get() == 0) {
				future.cancel(true);
				contador.getAndDecrement();
			}
		}
		System.out.println("Alguna otra tarea en el main ...");
		executor.shutdown();

	}

}
