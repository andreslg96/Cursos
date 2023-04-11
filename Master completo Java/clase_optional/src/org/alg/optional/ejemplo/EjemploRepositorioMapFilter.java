package org.alg.optional.ejemplo;

import java.util.Optional;

import org.alg.optional.ejemplo.models.Computador;
import org.alg.optional.ejemplo.models.Fabricante;
import org.alg.optional.ejemplo.models.Procesador;
import org.alg.optional.ejemplo.repositorio.ComputadorRepositorio;
import org.alg.optional.ejemplo.repositorio.Repositorio;

public class EjemploRepositorioMapFilter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Repositorio<Computador> repositorio = new ComputadorRepositorio();
		
	
		String f = repositorio.filtrar("asus")
				.flatMap(Computador::getProcesador)
				.flatMap(Procesador::getFabricante)
				.filter(fab -> "intel".equalsIgnoreCase(fab.getNombre()))
				.map(Fabricante::getNombre)
				.orElse("Desconocido");
		
		System.out.println(f);
		

		
		

	}

}
