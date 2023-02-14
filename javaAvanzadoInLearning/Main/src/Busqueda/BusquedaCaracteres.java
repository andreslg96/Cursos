package Busqueda;

public class BusquedaCaracteres {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String cadena = "Hola José, Buenos días, que tenFgas un buen día";
		String cadenaB = "Estamos comiendo una sopa muy deliciosa";
		
		int b;
		int buscar = 20;
		b = cadena.indexOf((int) 'F', buscar);//si sale -1 es porque no ha encontrado, tiene que ser mayus para que la encuentre. ((int) 'F', 32) es para buscar a partir del index 32 por lo que no va a encontrar
		System.out.println(b);
		
		int x;
		x = cadenaB.lastIndexOf((int) 'y');
		System.out.println(x);
		
		x=cadenaB.lastIndexOf("muy");
		System.out.println(x);

	}

}
