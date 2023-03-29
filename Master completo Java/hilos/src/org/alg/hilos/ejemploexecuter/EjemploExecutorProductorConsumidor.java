package org.alg.hilos.ejemploexecuter;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.alg.hilos.ejemplosync.Panaderia;
import org.alg.hilos.ejemplosync.runnable.Consumidor;
import org.alg.hilos.ejemplosync.runnable.Panadero;

public class EjemploExecutorProductorConsumidor {

	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
		
		//ExecutorService executor = Executors.newSingleThreadExecutor();
		//ExecutorService executor = Executors.newFixedThreadPool(3);
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
		
		//executor.set
		System.out.println("Tamaño del pool: "+ executor.getPoolSize());
		System.out.println("Cantidad de tareas en cola: "+ executor.getQueue().size());
	
		Panaderia p = new Panaderia();
		Runnable productor = new Panadero(p);
		Runnable consumidor = new Consumidor(p);
		Future<?> futuro1 = executor.submit(productor);
		Future<?> futuro2 = executor.submit(consumidor);

		
		System.out.println("Tamaño del pool: "+ executor.getPoolSize());
		System.out.println("Cantidad de tareas en cola: "+ executor.getQueue().size());
		
		executor.shutdown();
		System.out.println("Continuando con la ejecución del método main");
		
		
	}

}
