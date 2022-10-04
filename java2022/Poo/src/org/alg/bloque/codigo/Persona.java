package org.alg.bloque.codigo;

public class Persona {
	private final int idPersona;
	private static int contadorPersona;
	
	static {
		System.out.println("Ejecución bloque estático");
		++Persona.contadorPersona;
	}
	
	{
		System.out.println("Ejecución bloque de código");
		this.idPersona = Persona.contadorPersona++;
	}

	public Persona() {
		System.out.println("Ejecución del constructor");
	}
	
	public int getIdPersona() {
		return idPersona;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Persona [idPersona=");
		builder.append(idPersona);
		builder.append("]");
		return builder.toString();
	}
	
	

}
