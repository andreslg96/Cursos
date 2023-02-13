package Basura;

public class Clase {

	public static void main(String[] args) {
		
		Object objeto = new Object(); //Se crea un objeto
		
		objeto = null; //Se libera un objeto y deja de ser referenciado y se activa la recolección de basura
		
		Main objeto2 = new Main();
		
		objeto2 = null;
		System.gc(); //Llama al recolector después de ejecutar el código
		

	}

}
