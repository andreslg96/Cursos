package Basura;

public class Main {
	
	int numero;
	
	public Main() {
		
		System.out.println("Constructor");		
	}
	
	protected void finalize() {
		System.out.println("Final");
	}

}
