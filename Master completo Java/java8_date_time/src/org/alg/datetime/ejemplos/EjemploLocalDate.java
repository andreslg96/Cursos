package org.alg.datetime.ejemplos;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class EjemploLocalDate {

	public static void main(String[] args) {
		
		LocalDate fechaActual = LocalDate.now();
		System.out.println("Fecha actual = " + fechaActual);
		
		fechaActual = LocalDate.of(2023, 12, 25);
		System.out.println(fechaActual);
		
		fechaActual = LocalDate.of(2023, Month.NOVEMBER, 11);
		System.out.println(fechaActual);
		
		fechaActual = LocalDate.parse("2022-10-31");
		System.out.println(fechaActual);
		
		LocalDate diaDeManiana = LocalDate.now().plusDays(1);
		System.out.println(diaDeManiana);
		
		LocalDate mesAnteriorMismoDia = LocalDate.now().minus(1, ChronoUnit.MONTHS); //minusMonth
		System.out.println(mesAnteriorMismoDia);
		
		DayOfWeek miercoles = LocalDate.parse("2020-11-11").getDayOfWeek();
		System.out.println(miercoles);
		
		int once = LocalDate.of(2020, 11, 11).getDayOfMonth();
		System.out.println(once);

	}

}
