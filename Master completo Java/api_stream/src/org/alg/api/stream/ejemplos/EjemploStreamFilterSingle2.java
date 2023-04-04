package org.alg.api.stream.ejemplos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.alg.api.stream.ejemplos.models.Usuario;

public class EjemploStreamFilterSingle2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Usuario usuario = 
				Stream
				.of("Pato Guzman", "Paco Gonzales", "Pepa Gutierrez", "Pepe Mena", "Pepe García")
				.map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
				.peek(System.out::println)
				.filter(u -> u.getId().equals(7))
				.findFirst().orElseGet(()-> new Usuario("John", "Doe"))
				;
			
			System.out.println(usuario);
			
			
	}

}
