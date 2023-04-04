package org.alg.api.stream.ejemplos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.alg.api.stream.ejemplos.models.Usuario;

public class EjemploStreamMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stream<Usuario> nombres = 
				Stream
				.of("Pato Guzman", "Paco Gonzales", "Pepa Gutierrez", "Pepe Mena")
//				.map(nombre ->{
//			return nombre.toUpperCase();
//				})
			.map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
			//.peek(e -> System.out.println(e))
			.peek(u -> System.out.println(u.getNombre()))
			.map(usuario -> {
				String nombre = usuario.getNombre().toLowerCase();
				usuario.setNombre(nombre);
				return usuario;
			});;
			List<Usuario> lista = nombres.collect(Collectors.toList()); //método terminal, collect
			lista.forEach(u -> System.out.println(u.getApellido())); //si no tuvieramos el peek, no se va a imprimir con el collect
			lista.forEach(System.out::println); //con el método to string, vemos que cambió el nombre pero no el apellido
		//nombres.forEach(System.out::println);
			
			
	}

}
