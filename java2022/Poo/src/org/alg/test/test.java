package org.alg.test;

import org.alg.encapsulamiento.*;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Persona persona1 = new Persona("Alex", 25, false);
		String estado = persona1.toString();
		System.out.println(estado);
		System.out.println(persona1.getNombre());
		persona1.setNombre("Alexander");
		System.out.println(persona1.getNombre());
		
		System.out.println(persona1); //nos regresa la info por el override de toString
		System.out.println(estado);//en estado se guarda la info de persona1 y no se ve modificado por la línea 13 ni por otros cambios subsecuentes.

	}

}
