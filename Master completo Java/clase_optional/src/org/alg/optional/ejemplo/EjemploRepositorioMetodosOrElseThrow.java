package org.alg.optional.ejemplo;

import java.util.Optional;

import org.alg.optional.ejemplo.models.Computador;
import org.alg.optional.ejemplo.repositorio.ComputadorRepositorio;
import org.alg.optional.ejemplo.repositorio.Repositorio;

public class EjemploRepositorioMetodosOrElseThrow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Repositorio<Computador> repositorio = new ComputadorRepositorio();
		
		Computador pc = repositorio.filtrar("rog").orElseThrow(IllegalStateException::new); 
		System.out.println(pc);
		
		String archivo = "documento.pdf";
		String extension = Optional.ofNullable(archivo)
				.filter(a -> a.contains("."))
				.map(a -> a.substring(archivo.lastIndexOf(".")+1))
				.orElseThrow();
		System.out.println(extension);

		
		

	}

}
