package org.alg.api.stream.ejemplos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.alg.api.stream.ejemplos.models.Usuario;

public class EjemploStreamDistinct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				Stream
				.of("Pato Guzman", "Paco Gonzales", "Pepa Gutierrez", "Pepe Mena", "Pepe García", "Paco Gonzales", "Paco Gonzales", "Paco Gonzales")
				.distinct()
				.forEach(System.out::println);
		 	
				Stream<String> nombres =
						Stream
						.of("Pato Guzman", "Paco Gonzales", "Pepa Gutierrez", "Pepe Mena", "Pepe García", "Paco Gonzales", "Paco Gonzales", "Paco Gonzales")
						.distinct();
				nombres.forEach(System.out::println);
			
	}

}
