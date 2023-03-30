package org.alg.java8.lambda;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

import org.alg.java8.lambda.models.Usuario;

public class EjemploConsumer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Consumer<String> consumidor = saludo -> System.out.println(saludo);
		//Consumer es una interfaz funcional generica, recibe solo un argumento y no regresa nada, tiene solo el método accept
		Consumer<Date> consumidor = fecha -> {
			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
			System.out.println(f.format(fecha));
		};
		consumidor.accept(new Date());	
		
		BiConsumer<String, Integer> consumidorBi = (nombre, edad) -> {
			System.out.println(nombre + ", tiene "+edad+ " años");
		};
		consumidorBi.accept("pepe", 20);
		
		Consumer<String> consumidor2 =  System.out::println;
		consumidor2.accept("Hola mundo");
		
		List<String> nombres = Arrays.asList("andres", "pepe", "luz", "paco");
		nombres.forEach(consumidor2);
		
		Supplier<Usuario> creaUsuario = () -> new Usuario(); //o = Usuario::new;
		Usuario usuario = creaUsuario.get();
		//Usuario usuario = new Usuario();
//		BiConsumer<Usuario, String> asignarNombre = (persona, nombre) ->{
//			persona.setNombre(nombre);
//		};
		BiConsumer<Usuario, String> asignarNombre = Usuario::setNombre;
		asignarNombre.accept(usuario, "Andres");
		System.out.println("Nombre usuario: "+ usuario.getNombre());
		
//		Supplier<String> proveedor = () -> {
//			return "Hola mundo lambda supplier";
//		};
		
		Supplier<String> proveedor = () -> "Hola mundo lambda supplier";
		
		System.out.println(proveedor.get());

	}

}
