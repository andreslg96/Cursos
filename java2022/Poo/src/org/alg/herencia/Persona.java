package org.alg.herencia;

import java.util.Objects;

public class Persona {
	protected String nombre;
	protected char genero;
	protected int edad;
	protected String direccion;
	
	public Persona() {
	}

	public Persona(String nombre) {
		super();
		this.nombre = nombre;
	}

	public Persona(String nombre, char genero, int edad, String direccion) {
		super();
		this.nombre = nombre;
		this.genero = genero;
		this.edad = edad;
		this.direccion = direccion;
	}
	
	public String obtenerDetalle() {
		return "Nombre: %s Edad: %d ".formatted(this.nombre, this.edad);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public char getGenero() {
		return genero;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Persona [nombre=");
		builder.append(this.nombre);
		builder.append(", genero=");
		builder.append(this.genero);
		builder.append(", edad=");
		builder.append(this.edad);
		builder.append(", direccion=");
		builder.append(this.direccion);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(direccion, edad, genero, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(direccion, other.direccion) && edad == other.edad && genero == other.genero
				&& Objects.equals(nombre, other.nombre);
	}
	
	
	
	
	
}
