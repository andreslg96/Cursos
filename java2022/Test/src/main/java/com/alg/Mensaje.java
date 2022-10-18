package com.alg;

public class Mensaje {
	private int id;
	private String mensaje;
	private String autor;
	private String fecha;
	
	public Mensaje() {
		super();
	}

	public Mensaje(int id) {
		super();
		this.id = id;
	}

	public Mensaje(String mensaje, String autor) {
		super();
		this.mensaje = mensaje;
		this.autor = autor;
	}

	public Mensaje(int id, String mensaje, String autor) {
		super();
		this.id = id;
		this.mensaje = mensaje;
		this.autor = autor;
	}

	public Mensaje(int id, String mensaje, String autor, String fecha) {
		super();
		this.id = id;
		this.mensaje = mensaje;
		this.autor = autor;
		this.fecha = fecha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Mensaje [id=");
		builder.append(id);
		builder.append(", mensaje=");
		builder.append(mensaje);
		builder.append(", autor=");
		builder.append(autor);
		builder.append(", fecha=");
		builder.append(fecha);
		builder.append("]");
		return builder.toString();
	}
	

}
