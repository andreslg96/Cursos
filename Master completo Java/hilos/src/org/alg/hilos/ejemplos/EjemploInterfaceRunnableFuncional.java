package org.alg.hilos.ejemplos;

import org.alg.hilos.ejemplos.runnable.ViajeTarea;

public class EjemploInterfaceRunnableFuncional {

	public static void main(String[] args) throws InterruptedException {
		
		
//		Runnable viaje = new Runnable(){
//
//			@Override
//			public void run() {
		
		Thread main = Thread.currentThread();
		Runnable viaje = ()-> {
				for(int i=0; i<10; i++) {
					System.out.println(i + " - " + Thread.currentThread().getName()); //con métodos de thread cambiamos nombre
					try {
						Thread.sleep( (long)(Math.random()*1000));
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("Finalmente me voy de viaje a: "+ Thread.currentThread().getName());
				System.out.println(main.getState());
		};
		
		//new Thread(new ViajeTarea("Isla de Pascua")).start();
		Thread v1 = new Thread(viaje, "Isla de Pascua");
		Thread v2 =new Thread(viaje, "Robinson Crusoe");
		Thread v3 =new Thread(viaje, "Juan Fernandez");
		Thread v4 =new Thread(viaje, "Isla de Chilos");
		
		v1.start();
		v2.start();
		v3.start();
		v4.start();
		v1.join();
		v2.join();
		v3.join();
		v4.join();
		
		//Thread.sleep(5000); //en este caso el thread principal es el método main, sleep "pausa" mientras que join espera a que finalicen los otros threads
		System.out.println("Continuando con la ejecución del método main: " + main.getName());
	}

}
