package alg;

public class Funciones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//sumar(4,5);
		saludar("Sik", 80);
		int resta = restar(8,6);
		System.out.println(resta);
		System.out.println(sumar(5.5,6));
		cuentaRegresiva(4);
		System.out.println(factorial(5));
		System.out.println(sumar("Sik",5,5,6,8));

	}
	
//	static void sumar(int a, int b) {
//		int suma = a + b;
//		System.out.println("La suma es "+ suma);
//	}
	
	//los parametros indefinidos deben ir depués de los definidos
	static int sumar(String nombre, int... numeros) {
		System.out.println("La suma de "+nombre);
		int suma = 0;
		for (int num : numeros) {
			suma += num;
		}
		return suma;
	}
	
	static int sumar(int a, int b) {
		return a + b;
	}
	
	static double sumar(double a, double b) {
		return a+b;
	}
	
	static int restar(int a, int b) {
		return a-b;
	}
	
	static void saludar(String nombre, int edad) {
		System.out.printf("Hola %s, tu edad es %d \n", nombre, edad);
	}
	
	//Función recursiva
	static void cuentaRegresiva(int numero) {
		numero--;
		if(numero>0) {
			System.out.println(numero);
			cuentaRegresiva(numero);
		}else {
			System.out.println("Llego a 0");
		}
	}
	
	static int factorial(int numero) {
		if(numero >1) {
			numero=numero * factorial(numero-1);
		}
		return numero;
	}

}
