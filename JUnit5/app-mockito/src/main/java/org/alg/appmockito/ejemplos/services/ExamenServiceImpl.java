package org.alg.appmockito.ejemplos.services;

import java.util.List;
import java.util.Optional;

import org.alg.appmockito.ejemplos.models.Examen;
import org.alg.appmockito.ejemplos.repositories.ExamenRepository;
import org.alg.appmockito.ejemplos.repositories.PreguntaRepository;

public class ExamenServiceImpl implements ExamenService{
	private ExamenRepository examenRepository;
	private PreguntaRepository preguntaRepository;

	public ExamenServiceImpl(ExamenRepository examenRepository, PreguntaRepository preguntaRepository) {
		this.examenRepository = examenRepository;
		this.preguntaRepository = preguntaRepository;
	}

	@Override
	public Optional<Examen> findExamenPorNombre(String nombre) {
		/*Optional<Examen> examenOptional = */
			return examenRepository.findAll()
				.stream()
				.filter(e -> e.getNombre().contains(nombre))
				.findFirst();
//		Examen examen = null;
//		if(examenOptional.isPresent()) {
//			examen = examenOptional.orElseThrow(); //orElseThrow alternativa a get() pero que aparte lanzara una exepción
//		} //se quita pues al ser un opcional abre la posibilidad de que no haya resultado
		//return examenOptional;
	}

	@Override
	public Examen findExamenPorNombreConPreguntas(String nombre) {
		Optional <Examen> examenOptional = findExamenPorNombre(nombre);
		Examen examen = null;
		if(examenOptional.isPresent()) {
			examen = examenOptional.orElseThrow();
			List<String> preguntas = preguntaRepository.findPreguntasPorExamenId(examen.getId());
			examen.setPreguntas(preguntas);
		}
		return examen;
	}

	@Override
	public Examen guardar(Examen examen) {
		if(!examen.getPreguntas().isEmpty()) {
			preguntaRepository.guardarVarias(examen.getPreguntas());
		}
		return examenRepository.guardar(examen);
	}

}
