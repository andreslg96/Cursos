package org.alg.clases;

public class Persona {
	private String nombre;
	private int edad;
	
	public Persona() {
	}
	
	public Persona(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
	}
	
	public void mostrarDatos() {
		System.out.println("Nombre " + nombre);
		System.out.println("Edad: " + edad);
	}

}
