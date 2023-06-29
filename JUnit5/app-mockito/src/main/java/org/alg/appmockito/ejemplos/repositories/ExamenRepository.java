package org.alg.appmockito.ejemplos.repositories;

import java.util.List;

import org.alg.appmockito.ejemplos.models.Examen;

public interface ExamenRepository {
	Examen guardar(Examen examen);
	List<Examen> findAll();
}
