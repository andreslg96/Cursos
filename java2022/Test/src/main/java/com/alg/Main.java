package com.alg;

import java.sql.SQLException;
import java.util.*;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//Conexion.getConexion();
		//System.out.println("Conexion exitosa");
		MensajeDao mensajeDao = new MensajeDao();
		
//		Mensaje msm = new Mensaje("hola desde main", "Main");
//		int registro = mensajeDao.insertar(msm);
//		System.out.println("Se inserto "+registro+" registro");
		
//		Mensaje msm = new Mensaje(1, "Hola desde java Web", "Java Web");
//		int registro = mensajeDao.editar(msm);
//		System.out.println("Se editó "+registro+" registro");
		
		Mensaje msm = new Mensaje(6);
		int registro = mensajeDao.eliminar(msm);
		System.out.println("Se eliminó "+registro+" registro");
		
		List<Mensaje> mensajes = mensajeDao.seleccionar();
		
		for (Mensaje mensaje : mensajes) {
			System.out.println(mensaje);
		}

	}

}
