package org.alg.appmockito.ejemplos.repositories;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.alg.appmockito.ejemplos.models.Examen;

public class ExamenRepositoryOtro implements ExamenRepository{

	@Override
	public List<Examen> findAll() {
		try {
			System.out.println("ExamenReposirotyrOtro");
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Examen guardar(Examen examen) {
		// TODO Auto-generated method stub
		return null;
	}

}
