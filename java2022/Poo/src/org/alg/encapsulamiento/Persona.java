package org.alg.encapsulamiento;

public class Persona {
	private String nombre;
	private int edad;
	private boolean eliminado;
	
	public Persona(String nombre, int edad, boolean eliminado) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.eliminado = eliminado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public boolean isEliminado() {
		return eliminado;
	}

	public void setEliminado(boolean eliminado) {
		this.eliminado = eliminado;
	}
	
	@Override
	public String toString() {
		return "Persona: [Nombre: %s, Edad: %d, Eliminado: %b] "
				.formatted(this.nombre, this.edad, this.eliminado);
	}	

}
