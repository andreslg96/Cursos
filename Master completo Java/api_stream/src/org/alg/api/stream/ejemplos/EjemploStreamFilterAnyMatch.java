package org.alg.api.stream.ejemplos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.alg.api.stream.ejemplos.models.Usuario;

public class EjemploStreamFilterAnyMatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean existe = 
				Stream
				.of("Pato Guzman", "Paco Gonzales", "Pepa Gutierrez", "Pepe Mena", "Pepe García")
				.map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
				.peek(System.out::println)
				.anyMatch(u -> u.getId().equals(1))//Solo debe haber un operador terminal
				;
			
			System.out.println(existe);
			
			List<Usuario> lista = Arrays.asList(new Usuario("Pato", "Guzman"), new Usuario("Paco", "Gonzales"), 
					new Usuario("Pepa", "Gutierrez"), new Usuario("Pepe", "Mena"), new Usuario("Pepe", "García"));
			
			boolean resultado = false;
			for(Usuario u: lista) {
				if(u.getId().equals(3)) {
					resultado = true;
					break;
				}
			}
			
			
	}

}
