package org.alg.test;

import java.util.Date;

import org.alg.herencia.*;

public class TestHerencia {

	public static void main(String[] args) {
		Persona persona1 = new Persona("Alexander", 'M', 28, "Calle Falsa");
		//System.out.println(persona1.obtenerDetalle());
		imprimir(persona1);
		
		Empleado empleado1 = new Empleado("Alex", 3000);
		System.out.println(empleado1.obtenerDetalle());
		
		var fecha = new Date();
		Clientes cliente1 = new Clientes("Alexander", 'M', 28, "Calle Falsa", fecha, true);
		System.out.println(cliente1.obtenerDetalle());
		
		determinarTipo(empleado1);
		
		//Conversión de objetos
		//Downcasting
		Persona persona2 = new Empleado("Alex", 3000);
		Empleado empleado2 = (Empleado) persona2;
		empleado2.getSueldo();
		System.out.println(empleado2.obtenerDetalle());
		
		//Upcasting
		Persona persona3 = empleado2;
		System.out.println(persona3.obtenerDetalle());
		
		Persona p1 = new Persona("Alexander", 'M', 28, "Calle Falsa");
		Persona p2 = new Persona("Alexander", 'M', 28, "Calle Falsa");
		
		System.out.println(p1.equals(p2));
		
		if (p1.hashCode() == p2.hashCode()) {
			System.out.println("Los objetos son iguales");
		}else {
			System.out.println("Los objetos no son iguales");
		}
	}
	
	public static void imprimir(Persona persona) {
		System.out.println(persona.obtenerDetalle());
	}
	
	public static void determinarTipo(Object objeto) {
		if (objeto instanceof Empleado) {
			System.out.println("Es de tipo Empleado");
		}else if(objeto instanceof Clientes) {
			System.out.println("Es de tipo cliente");
		}else if(objeto instanceof Persona) {
			System.out.println("Es de tipo persona");
		}else if(objeto instanceof Object) {
			System.out.println("Es de tipo object");
		}
	}

}
