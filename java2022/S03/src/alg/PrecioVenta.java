package alg;

import java.util.Scanner;

public class PrecioVenta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("Ingrese valor de venta: ");
		double vv = scanner.nextDouble();
		//igv 18%
		double igv = vv * 0.18;
		double pv = vv + igv;
		
		System.out.println("Valor venta: "+vv);
		System.out.println("IGV: "+igv);
		System.out.println("Precio de venta: "+pv);
	}

}
