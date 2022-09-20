package alg;

public class ClaseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String nombre = "Oregon";
		nombre = "O r e g o n";
		System.out.println(nombre.replace(" ", "-"));
		System.out.println(nombre.substring(0,4));
		
		StringBuilder nuevo = new StringBuilder();
		System.out.println(nuevo);
		
		nuevo.append("Hola ");
		nuevo.append("Mundo");
		System.out.println(nuevo);

	}

}
