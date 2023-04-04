package org.alg.api.stream.ejemplos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.alg.api.stream.ejemplos.models.Usuario;

public class EjemploStreamReduceInt {

	public static void main(String[] args) {
		 	
				Stream<Integer> nombres = Stream.of(5, 10, 15, 20);
						
				//Integer resultado = nombres.reduce(0, (a, b) -> a + b);
				Integer resultado = nombres.reduce(0, Integer::sum);
				System.out.println(resultado);
			
	}

}
