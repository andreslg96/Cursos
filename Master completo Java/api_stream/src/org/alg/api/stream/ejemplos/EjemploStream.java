package org.alg.api.stream.ejemplos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class EjemploStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stream<String> nombres = Stream.of("Pato", "Paco", "Pepa", "Pepe");
		//nombres.forEach(e -> System.out.println(e)); //el forEach es un metodo terminal, con el que se "aplican" los cambios del stream
		//nombres.forEach(System.out::println); 
		
		String[] arr = {"Pato", "Paco", "Pepa", "Pepe"};
		Stream<String> nombres2 = Arrays.stream(arr);
		//nombres2.forEach(System.out::println);
		Stream<String> nombres3 = Stream.<String>builder().add("Pato")
				.add("paco")
				.add("pepa")
				.add("pepe")
				.build();
		nombres.forEach(System.out::println);
		
		List<String> lista = new ArrayList<>();
		lista.add("Pato");
		lista.add("Paco");
		lista.add("Pepe");
		lista.add("Pepa");
		
		Stream<String> nombre4 = lista.stream();
		
		lista.stream().forEach(System.out::println);

	}

}
