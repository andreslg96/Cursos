package org.alg.hilos.ejemploexecuter;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class EjemploExecutorFuture2 {

	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
		
		//ExecutorService executor = Executors.newSingleThreadExecutor();
		//ExecutorService executor = Executors.newFixedThreadPool(3);
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
		
		//executor.set
		System.out.println("Tamaño del pool: "+ executor.getPoolSize());
		System.out.println("Cantidad de tareas en cola: "+ executor.getQueue().size());
		//Runnable tarea = () -> {
		Callable<String> tarea = () -> {
			System.out.println("Inicio de la tarea...");
			try {
				System.out.println("Nombre del thread" + Thread.currentThread().getName());
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				e.printStackTrace();
			}
			System.out.println("Finaliza la tarea");
			return "Algún restultado importante de la tarea";
		};
		
		Callable<Integer> tarea2 = () -> {
			System.out.println("Iniciando tarea 3");
			TimeUnit.SECONDS.sleep(3);
			return 10;
		};
		//Future<?> resultado= executor.submit(tarea);
		Future<String> resultado= executor.submit(tarea);
		Future<String> resultado2 = executor.submit(tarea);
		Future<Integer> resultado3 = executor.submit(tarea2);
		
		System.out.println("Tamaño del pool: "+ executor.getPoolSize());
		System.out.println("Cantidad de tareas en cola: "+ executor.getQueue().size());
		
		executor.shutdown();
		System.out.println("Continuando con la ejecución del método main");
		//System.out.println(resultado.isDone());
		while(!(resultado.isDone() && resultado2.isDone() && resultado3.isDone()) ) {
			System.out.println(String.format("resultado1: %s - Resultado2: %s - resultado3: %s", 
					resultado.isDone()? "Finalizó": "en proceso",
					resultado2.isDone()? "Finalizó": "en proceso",
					resultado3.isDone()? "Finalizó": "en proceso"));
			TimeUnit.MILLISECONDS.sleep(1000);
		}
		//System.out.println("Continuamos ...");
		//System.out.println("Obtenemos el resultado de la tarea " +resultado.get(5, TimeUnit.SECONDS)); //el método get queda bloqueado
		System.out.println("Obtenemos el resultado1 de la tarea: " +resultado.get()); 
		System.out.println("Finaliza la tarea1: " + resultado.isDone());
		
		System.out.println("Obtenemos el resultado2 de la tarea: " +resultado2.get()); 
		System.out.println("Finaliza la tarea2: " + resultado2.isDone());
		
		System.out.println("Obtenemos el resultado3 de la tarea: " +resultado3.get()); 
		System.out.println("Finaliza la tarea3: " + resultado3.isDone());
		
		
	}

}
