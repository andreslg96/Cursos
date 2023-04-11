package org.alg.optional.ejemplo.repositorio;

import java.util.Optional;

import org.alg.optional.ejemplo.models.Computador;

public interface Repositorio<T> {
	Optional<Computador> filtrar(String nombre);

}
