package org.alg.appmockito.ejemplos.repositories;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.alg.appmockito.ejemplos.models.Examen;

public class ExamenRepositoryImpl  implements ExamenRepository{

	@Override
	public List<Examen> findAll() {
		return Collections.emptyList(); /*Arrays.asList(new Examen(5L, "Matemáticas"), new Examen(6L, "Lenguaje"),
				new Examen(7L, "Historia"));*/
	}

	@Override
	public Examen guardar(Examen examen) {
		// TODO Auto-generated method stub
		return null;
	}

}
