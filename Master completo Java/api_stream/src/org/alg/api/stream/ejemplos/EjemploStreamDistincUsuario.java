package org.alg.api.stream.ejemplos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.alg.api.stream.ejemplos.models.Usuario;

public class EjemploStreamDistincUsuario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stream<Usuario> nombres = 
				Stream
				.of("Pato Guzman", "Paco Gonzales", "Pepa Gutierrez", "Pepe Mena", "Pepe García", "Pato Guzman","Pato Guzman")
				//.distinct()
			.map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
			.distinct();
			
		nombres.forEach(System.out::println);
	}

}
