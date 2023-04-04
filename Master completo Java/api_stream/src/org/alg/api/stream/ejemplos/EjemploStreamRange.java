package org.alg.api.stream.ejemplos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.alg.api.stream.ejemplos.models.Usuario;

public class EjemploStreamRange {

	public static void main(String[] args) {
		 	
				IntStream num = IntStream.range(5, 20); //hay rangeClosed que incluye un segundo elemneto
						
				//Integer resultado = nombres.reduce(0, Integer::sum);
				//int resultado = num.sum();
				IntSummaryStatistics stats = num.summaryStatistics();
				System.out.println("max: "+ stats.getMax());
				System.out.println("min: "+ stats.getMin());
				System.out.println("sum: "+ stats.getSum());
				System.out.println("promedio: "+ stats.getAverage());				
				System.out.println("total: "+ stats.getCount());				
			
	}

}
