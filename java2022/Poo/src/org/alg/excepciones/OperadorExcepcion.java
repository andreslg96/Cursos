package org.alg.excepciones;

//public class OperadorExcepcion extends Exception{ esto ya no es tan recomendable y así nos ahorramos poner el throw dos veces
public class OperadorExcepcion extends RuntimeException{
	public OperadorExcepcion(String mensaje) {
		super(mensaje);
	}

}
