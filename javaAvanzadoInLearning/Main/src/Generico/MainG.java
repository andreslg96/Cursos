package Generico;

public class MainG {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ClaseG<Integer> objetoA = new ClaseG<Integer>(1);
		objetoA.tipoClase();
		
		ClaseG<String> objetoB = new ClaseG<String>("cadena");
		objetoB.tipoClase();
		
		System.out.println(objetoA.metodoGen("Hola 1"));		
		System.out.println(objetoB.metodoGen(10));		

	}

}
