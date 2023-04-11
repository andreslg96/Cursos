package org.alg.optional.ejemplo;

import java.util.Optional;

import org.alg.optional.ejemplo.models.Computador;
import org.alg.optional.ejemplo.repositorio.ComputadorRepositorio;
import org.alg.optional.ejemplo.repositorio.Repositorio;

public class EjemploRepositorio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Repositorio<Computador> repositorio = new ComputadorRepositorio();
		
		repositorio.filtrar("asus").ifPresentOrElse(System.out::println, ()-> System.out.println("No se encontró"));
		//Optional<Computador> pc = repositorio.filtrar("asus rog");
		
		/*if(pc.isPresent()) {
			System.out.println(pc.get());
		} else {
			System.out.println("No se encontró");
		}*/

	}

}
