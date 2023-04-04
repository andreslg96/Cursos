package org.alg.api.stream.ejemplos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.alg.api.stream.ejemplos.models.Usuario;

public class EjemploStreamFilterSingle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stream<Usuario> nombres = 
				Stream
				.of("Pato Guzman", "Paco Gonzales", "Pepa Gutierrez", "Pepe Mena", "Pepe García")
//				.map(nombre ->{
//			return nombre.toUpperCase();
//				})
			.map(nombre -> new Usuario(nombre.split(" ")[0], nombre.split(" ")[1]))
			.filter(u -> u.getNombre().equals("Pepex"))
			.peek(System.out::println)
			;
			Optional<Usuario> usuario = nombres.findFirst(); 
			//System.out.println(usuario.orElse(new Usuario("John", "Doe")).getNombre());
			//System.out.println(usuario.orElseGet(()-> new Usuario("John", "Doe")).getNombre());
			//System.out.println(usuario.orElseThrow());
			if(usuario.isPresent()) {
				System.out.println(usuario.get().getNombre());
			}else {
				System.out.println("No se encontró el objeto");
			}
			
			
	}

}
