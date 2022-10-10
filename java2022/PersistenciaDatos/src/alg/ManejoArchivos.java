package alg;

import java.io.*;

public class ManejoArchivos {
	
	public static void crearArchivo(String nombreArchivo) {
		File archivo = new File(nombreArchivo);
		
		try {
			PrintWriter salida = new PrintWriter(archivo);
			salida.close();
			System.out.println("Se creó el archivo");
		} catch (FileNotFoundException ex) {
			ex.printStackTrace(System.out);
		}
	}
	
	public static void escribirArchivo(String nombreArchivo, String contenido) {
		File archivo = new File(nombreArchivo);
		
		try {
			PrintWriter salida = new PrintWriter(new FileWriter(archivo, true));
			salida.println(contenido);
			salida.close();
			System.out.println("Se escrbió en el archivo");
		} catch (FileNotFoundException ex) {
			ex.printStackTrace(System.out);
		} catch (IOException ex) {
			ex.printStackTrace(System.out);
		}
	}
	
	public static void leerArchivo(String nombreArchivo) {
		File archivo = new File(nombreArchivo);
		
		try {
			BufferedReader entrada = new BufferedReader(new FileReader(archivo));
			String lectura = entrada.readLine();
			while(lectura != null) {
				System.out.println(lectura);
				lectura = entrada.readLine();				
			}
			entrada.close();
		} catch (FileNotFoundException ex) {
			ex.printStackTrace(System.out);
		} catch (IOException ex) {
			ex.printStackTrace(System.out);
		}
	}
	
	public static void eliminarArchivo(String nombreArchivo) {
		File archivo = new File(nombreArchivo);
		System.out.println(archivo.exists()); //con esto se verifica si el archivo existe
		archivo.delete();
		System.out.println("Se eliminó el archivo");
	}

}
