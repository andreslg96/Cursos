package org.alg.optional.ejemplo;

import java.util.Optional;

import org.alg.optional.ejemplo.models.Computador;
import org.alg.optional.ejemplo.repositorio.ComputadorRepositorio;
import org.alg.optional.ejemplo.repositorio.Repositorio;

public class EjemploRepositorioMetodosOrElse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Repositorio<Computador> repositorio = new ComputadorRepositorio();
		
		Computador defecto = new Computador("HP Omen", "LA0001");
		Computador pc = repositorio.filtrar("asus").orElse(valorDefecto()); //este orElse creará el objeto de la funcion valorDefecto independientemente
		//de que encuentre o no asus, en este ejemplo
		System.out.println(pc);
		
		pc = repositorio.filtrar("aorus").orElseGet(EjemploRepositorioMetodosOrElse::valorDefecto);
		System.out.println(pc);
		
		

	}
	
	public static Computador valorDefecto() {
		System.out.println("Obteniendo valor por defecto!!");
		return new Computador("HP Omen", "LA0001");
	}

}
