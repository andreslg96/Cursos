package org.alg.test;

import org.alg.enumeraciones.*;

public class TestEnumeraciones {

	public static void main(String[] args) {
		System.out.println(Dias.LUNES);
		
		System.out.println(Continentes.AMERICA);
		System.out.println(Continentes.AMERICA.getPaises());
		
		Continentes continente = Continentes.AMERICA;
		System.out.println(continente.getPaises());
	}

}
