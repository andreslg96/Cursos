package org.alg.hilos.ejemplos.runnable;

import org.alg.hilos.ejemplos.EjemploSincronizacionThread;
import static org.alg.hilos.ejemplos.EjemploSincronizacionThread.imprimirFrases;;

public class ImprimirFrases implements Runnable{
	private String frase1, frase2;

	public ImprimirFrases(String frase1, String frase2) {
		super();
		this.frase1 = frase1;
		this.frase2 = frase2;
	}

	@Override
	public void run() {
		//EjemploSincronizacionThread.imprimirFrases(this.frase1, this.frase2);
		imprimirFrases(this.frase1, this.frase2);
		
	}

}
