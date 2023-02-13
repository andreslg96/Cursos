package ins;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Number numero = 9.9f;
		
		if(numero instanceof Float) {
			System.out.println("Flotante");
		}
		
		if(numero instanceof Integer) {
			System.out.println("Entero");
		}
		
		if(numero instanceof Double) {
			System.out.println("Doble");
		}

	}

}
