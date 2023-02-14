package Generico;

public class ClaseG<T> {
	
	T objeto;
	
	public ClaseG(T algo) {
		objeto = algo;
	}
	
	public void tipoClase() {
		System.out.println("El tipo es: "+objeto.getClass().getName());
	}
	
	public static <T> String metodoGen(T x) {
		String dato;
		dato = x.toString();
		
		return dato;
	}

}
