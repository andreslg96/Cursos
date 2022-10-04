package org.alg.test;

import org.alg.interfaces.*;

public class TestInterface {

	public static void main(String[] args) {
		BaseDatos datos = new ImplementarMySQL();
		datos.insertar();
		datos.actualizar();
	}

}
