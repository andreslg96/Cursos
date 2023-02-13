package ter;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numero = 21;
		String cadena;
		
		if(numero<20) {
			cadena = "menos";
		}else {
			cadena = "más";
		}
		System.out.println(cadena);
		
		String cadena2 = numero<20 ? "menos" : "más";
		System.out.println(cadena2);

	}

}
