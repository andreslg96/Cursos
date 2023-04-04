package org.alg.api.stream.ejemplos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.alg.api.stream.ejemplos.models.Usuario;

public class EjemploStreamFlatMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stream<Usuario> nombres = 
				Stream
				.of("Pato Guzman", "Paco Gonzales", "Pepa Gutierrez", "Pepe Mena", "Pepe García")
//				.map(nombre ->{
//			return nombre.toUpperCase();
//				})
			.map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
			.flatMap(u -> {
				if(u.getNombre().equalsIgnoreCase("Pepe")) {
					return Stream.of(u);
				}
				return Stream.empty();
			})
			.peek(System.out::println);
		
			//List<Usuario> lista = nombres.collect(Collectors.toList()); //método terminal, collect
			//lista.forEach(System.out::println); //con el método to string, vemos que cambió el nombre pero no el apellido
			//nombres.forEach(System.out::println);
		System.out.println(nombres.count());
			
			
	}

}
