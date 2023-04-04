package org.alg.api.stream.ejemplos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.alg.api.stream.ejemplos.models.Usuario;

public class EjemploStreamReduce {

	public static void main(String[] args) {
		 	
				Stream<String> nombres =
						Stream
						.of("Pato Guzman", "Paco Gonzales", "Pepa Gutierrez", "Pepe Mena", "Pepe García", "Paco Gonzales", "Paco Gonzales", "Paco Gonzales")
						.distinct();
				String resultado = nombres.reduce("resultado concatenacion", (a, b) -> a + ", " + b);
				System.out.println(resultado);
			
	}

}
