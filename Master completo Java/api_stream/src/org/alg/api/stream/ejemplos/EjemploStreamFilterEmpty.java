package org.alg.api.stream.ejemplos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.alg.api.stream.ejemplos.models.Usuario;

public class EjemploStreamFilterEmpty {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long count = 
				Stream
				.of("Pato Guzman", "Paco Gonzales", "", "Pepe Mena", "")
				.filter(String::isEmpty)
				.peek(System.out::println)
				.count();
		System.out.println("count = "+count);
			
	}

}
