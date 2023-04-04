package org.alg.api.stream.ejemplos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.alg.api.stream.ejemplos.models.Usuario;

public class EjemploStreamDistincUsuarioSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntStream largoNombres = 
				Stream
				.of("Pato Guzman", "Paco Gonzales", "Pepa Gutierrez", "Pepe Mena", "Pepe García", "Pato Guzman","Pato Guzman")
				//.distinct()
			.map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
			.distinct()
			.mapToInt(u -> u.toString().length()) //En vez de toString podría ser getNombre o getApellido si solo quisieramos comparar uno
			.peek(System.out::println);
			
		//largoNombres.forEach(System.out::println); se comenta porque sum también es un operador final
		IntSummaryStatistics stats = largoNombres.summaryStatistics();
		System.out.println("total: "+ stats.getSum());
		System.out.println("max: " + stats.getMax());
		System.out.println("min: " + stats.getMin());
		System.out.println("promedio: " + stats.getAverage());
	}

}
