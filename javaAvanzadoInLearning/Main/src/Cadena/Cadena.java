package Cadena;

public class Cadena {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numero = 10;
		String cadena = String.valueOf(numero); //Método estático, por lo que no hay que crear un nuevo objeto
		
		float numerof = 10.0f;
		String cadenaf = String.valueOf(numerof);
		
		double numerod = 10.8d;
		String cadenad = String.valueOf(numerod);
		
		long numerol = 1000000;
		String cadenal = String.valueOf(numerol);
		
		boolean boo = true;
		String cadenab = String.valueOf(boo);

	}

}
