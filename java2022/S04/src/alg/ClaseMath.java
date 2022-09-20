package alg;

public class ClaseMath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Math.PI);
		System.out.println(Math.pow(3, 3));
		//Math.random() regresa un valor double entre 0 y 1
		System.out.println(Math.random());
		
		int numeroRandom = (int)(Math.random()*101);
		System.out.println(numeroRandom);
		
		//El 100d quiere decir que queremos tomar solo 2 decimales, 3 ceros para 3 decimales, etc
		double moneda = (double)Math.round(3.4289 * 100d)/100;
		System.out.println(moneda);

	}

}
