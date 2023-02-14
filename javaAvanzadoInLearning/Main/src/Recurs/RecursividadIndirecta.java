package Recurs;

public class RecursividadIndirecta {
	
	static void metodoA(char x) {
		if(x>'A') {
			metodoB(x);
			System.out.println(x);
		}
	}
	
	static void metodoB(char x) {
		metodoA(--x);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		metodoA('Z');

	}

}
