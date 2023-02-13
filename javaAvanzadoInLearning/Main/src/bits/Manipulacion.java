package bits;

public class Manipulacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numero = 20;
		System.out.println("El número en BIN: "+Integer.toBinaryString(numero));
		
		int numeroI = numero << 3; //se le agregan 3 ceros en binario
		
		System.out.println("Este es el resultado "+ Integer.toBinaryString(numeroI));
		
		System.out.println(numero);
		System.out.println(numeroI);
		
		int numeroD = numero >>3;
		
		System.out.println("Este es el número D en Bin");
		System.out.println("normal: "+numero);
		System.out.println(">> D:"+numeroD);
		
		int numeroDS = -1 >>>3; //se ignora el signo
		System.out.println("Desplazamiento sin signo "+numeroDS);
		
		int numA = 88;
		int numB = 150;
		
		int numAnd = numA & numB;
		System.out.println("AND "+numAnd);
		
		int numOr = numA | numB;
		System.out.println("OR "+numOr);
		
		int numXor = numA ^numB; //1 si y solo si solo una de las entradas es 1
		System.out.println("Xor "+numXor);
		
		int numC=90;
		int numNot = ~numC; //Cambio de 0 a 1 y visceversa
		System.out.println("Not "+numNot);

	}

}
