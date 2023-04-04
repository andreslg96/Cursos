package org.alg.api.stream.ejemplos.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Usuario {
	private String nombre;
	private String apellido;
	private Integer id; 
	private static int ultimoId;
	
	private List<Factura> facturas;
	
	public Usuario(String nombre, String apellido) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.id = ++ultimoId;
		this.facturas = new ArrayList<>();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public List<Factura> getFacturas() {
		return facturas;
	}
	public void addFactura(Factura factura) {
		this.facturas.add(factura);
		factura.setUsuario(this);
	}
	@Override
	public String toString() {
		return nombre + " " + apellido ;
	}
	@Override
	public int hashCode() {
		return Objects.hash(apellido, nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(apellido, other.apellido) && Objects.equals(nombre, other.nombre);
	}
	
	

}
