package Vec;

import java.util.Vector;

public class Vectores {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector v1 = new Vector(); //Constructor vacío 
		Vector v2 = new Vector(10); //Asignandole un tamaño
		Vector v3 = new Vector(v2); //A partir de otro vector
		
		Vector <String> vector = new Vector<String>();
		
		vector.addElement("Cadena");
		//vector.addElement(2);
		
		vector.addElement("cadena2");
		//vector.addElement(9);
		
		vector.insertElementAt("AJ", 1);
		
		/* Acceder */
		System.out.println(vector.get(2));
		System.out.println(vector.size());
		System.out.println(vector.elementAt(2));
		
		/*Eliminar*/
		vector.removeElementAt(0);
		vector.removeElement("AJ");
		
		vector.removeAll(vector);
		
		/* Operaciones */
		
		System.out.println(vector.contains("AJ"));
		System.out.println(vector.indexOf("AJ"));
		

	}

}
