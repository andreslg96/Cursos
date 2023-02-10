package alg;

public class Main {
	
	public static void main(String[] argumentos) {
//		try {
//			System.out.println("Bloque 1");
//			int numero = Integer.parseInt("X");
//			//si ponemos aquí el sysoBloque1 no va a imprimir ya que no ejecuta la línea 8 y sale al catch
//		} catch (Exception e) {
//			System.out.println("Bloque 2");
//		} finally {
//			System.out.println("Bloque 3");
//		}
		
		try {
			System.out.println("provocamos error");
			throw new MiExcepcion();
		} catch(MiExcepcion e){
			System.out.println(e.exceptionError());
		}
	}

}
