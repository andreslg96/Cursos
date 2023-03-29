package org.alg.appmockito.ejemplos.services;

import java.util.Optional;

import org.alg.appmockito.ejemplos.models.Examen;
import org.alg.appmockito.ejemplos.repositories.ExamenRepository;

public class ExamenServiceImpl implements ExamenService{
	private ExamenRepository examenRepository;

	public ExamenServiceImpl(ExamenRepository examenRepository) {
		this.examenRepository = examenRepository;
	}

	@Override
	public Examen findExamenPorNombre(String nombre) {
		Optional<Examen> examenOptional = examenRepository.findAll()
				.stream()
				.filter(e -> e.getNombre().contains(nombre))
				.findFirst();
		Examen examen = null;
		if(examenOptional.isPresent()) {
			examen = examenOptional.orElseThrow(); //orElseThrow alternativa a get() pero que aparte lanzara una exepción
		}
		return null;
	}

}
