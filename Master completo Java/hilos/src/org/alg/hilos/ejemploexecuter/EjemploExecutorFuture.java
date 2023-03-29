package org.alg.hilos.ejemploexecuter;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class EjemploExecutorFuture {

	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
		
		ExecutorService executor = Executors.newSingleThreadExecutor();
		
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
		//Future<?> resultado= executor.submit(tarea);
		Future<String> resultado= executor.submit(tarea);
		executor.shutdown();
		System.out.println("Continuando con la ejecución del método main");
		//System.out.println(resultado.isDone());
		while(!resultado.isDone()) {
			System.out.println("ejecutando tarea...");
			TimeUnit.MILLISECONDS.sleep(1500);
		}
		//System.out.println("Continuamos ...");
		//System.out.println("Obtenemos el resultado de la tarea " +resultado.get(5, TimeUnit.SECONDS)); //el método get queda bloqueado
		System.out.println("Obtenemos el resultado de la tarea: " +resultado.get()); 
		System.out.println("Finaliza la tarea: " + resultado.isDone());
		
	}

}
