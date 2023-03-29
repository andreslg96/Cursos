package org.alg.hilos.ejemplosync.runnable;

import java.util.concurrent.ThreadLocalRandom;

import org.alg.hilos.ejemplosync.Panaderia;

public class Panadero implements Runnable{
	private Panaderia panaderia;

	public Panadero(Panaderia panaderia) {
		super();
		this.panaderia = panaderia;
	}

	@Override
	public void run() {
		for(int i = 0; i < 10; i++ ) {
			panaderia.hornear("Pan #: "+i);
			try {
				Thread.sleep(ThreadLocalRandom.current().nextInt(500, 2000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
