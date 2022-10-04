package org.alg.herencia;

import java.util.Date;

public class Clientes extends Persona{
	private int idCliente;
	private Date fechaRegistro;
	private boolean vip;
	private static int contadorCliente;
	
	public Clientes(String nombre, char genero, int edad, String direccion, Date fechaRegistro, boolean vip) {
		super(nombre, genero, edad, direccion);
		this.idCliente = ++Clientes.contadorCliente;
		this.fechaRegistro = fechaRegistro;
		this.vip = vip;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public boolean isVip() {
		return vip;
	}

	public void setVip(boolean vip) {
		this.vip = vip;
	}
	
	public String obtenerDetalle() {
		return super.obtenerDetalle() + "Es Vip: " + this.vip;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Clientes [idCliente=");
		builder.append(idCliente);
		builder.append(", fechaRegistro=");
		builder.append(fechaRegistro);
		builder.append(", vip=");
		builder.append(vip);
		builder.append(",").append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
	

}
