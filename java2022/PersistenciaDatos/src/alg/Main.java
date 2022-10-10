package alg;

import java.util.*;
import static alg.ManejoArchivos.*;

public class Main {

	public static void main(String[] args) {
		
		List lista1 = new ArrayList();
		
		lista1.add(1);
		lista1.add("Alex");
		lista1.add(1.67);
		lista1.add(true);
		
//		for (Object dato : lista1) {
//			System.out.println(dato);
//		}
		
		lista1.forEach(dato -> {
			System.out.println(dato);
		});
		
		System.out.println(lista1.get(0));
		
		lista1.remove(0);
		System.out.println(lista1);
		
		lista1.set(0, "Alex D");
		System.out.println(lista1);
		
		lista1.clear();
		System.out.println(lista1);
		
		//HashSet no repite elementos y no están ordenados
		Set dias = new HashSet();
		
		dias.add("Lunes");
		dias.add("Martes");
		dias.add("Miercoles");
		dias.add("Jueves");
		dias.add("Viernes");
		dias.add("Viernes");
		
		for (Object dia : dias) {
			System.out.println(dia);
		}
		
		dias.remove("Lunes");
		System.out.println(dias);
		
		dias.clear();
		System.out.println(dias);
		
		Map numeros = new HashMap();
		numeros.put(1, "uno");
		numeros.put(2, "dos");
		numeros.put(3, "tres");
		numeros.put(4, "cuatro");
		numeros.put(5, "cinco");
		
		System.out.println(numeros);
		System.out.println(numeros.get(3));
		
		for (Object valor : numeros.values()) {
			System.out.println(valor);			
		}
		
		for (Object clave : numeros.keySet()) {
			System.out.println(clave+" "+numeros.get(clave));			
		}
		
		numeros.remove(5);
		System.out.println(numeros);
		
		crearArchivo("archivo\\Hola.txt");
		//poniendo toda la ruta, hay que poner \\ doble en vez de \, el siguiente es solo un ejemplo, la carpeta no existe
		//crearArchivo("C:\\JavaArchivos\\hola.txt");
		
		escribirArchivo("archivo\\Hola.txt", "Hola");
		escribirArchivo("archivo\\Hola.txt", "Hi");
		escribirArchivo("archivo\\Hola.txt", "3");
		
		leerArchivo("archivo\\Hola.txt");
		eliminarArchivo("archivo\\Hola.txt");

	}

}
