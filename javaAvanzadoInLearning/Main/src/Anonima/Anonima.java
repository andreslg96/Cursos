package Anonima;

public class Anonima {
	
	int numero;
	String dato;
	
	public static void main(String[] argumentos) {
		
		//Object objeto = new Object(); forma común de crear un objeto
		
		//creamos una clase anónima de la interfaz cuando solo queremos solo 1 instancia de una clase
		Caminar anonima = new Caminar() {
			
			@Override
			public void avanzar() {
				
			}
	};

}
}
