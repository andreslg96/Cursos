package peliculas.ui;

import peliculas.modelo.*;
import javax.swing.*;

public class UIPeliculas {
	
	public static void interfazUsuario() {
		ICatalogoPeliculas peliculas = new ImplementacionCatalogoPelicula();
		Pelicula pelicula;
		
		CERRAR:
			while(true) {
				String opcion = JOptionPane.showInputDialog(
						null,
						"1 - Insertar pel�cula\n"
						+"2 - Listar pel�cula\n"
						+"3 - Buscar pel�cula\n"
						+"4 - Salir",
						"Ingrese una opci�n",
						3
					);
				
				int opcionInt = 0;
				try {
					opcionInt = Integer.parseInt(opcion);
				} catch(NumberFormatException e) {
					e.printStackTrace(System.out);
					JOptionPane.showMessageDialog(
							null, 
							"las opciones tienen que ser n�meros enteros\n"+e,
							"Error",
							JOptionPane.ERROR_MESSAGE
						);
				} catch(Exception e) {
					e.printStackTrace(System.out);
					JOptionPane.showMessageDialog(
							null, 
							e,
							"Error",
							JOptionPane.ERROR_MESSAGE
						);
				}
				
				
				switch(opcionInt) {
				case 1:
					String nombrePelicula = JOptionPane.showInputDialog(
							null,
							"Ingrese el nombre de la pel�cula",
							"Entrada",
							3
					);
					
					pelicula = new Pelicula(nombrePelicula);
					peliculas.insertarPelicula(pelicula);
					break;
				case 2:
					peliculas.listarPelicula();
					break;
				case 3:
					nombrePelicula = JOptionPane.showInputDialog(
							null,
							"Ingrese el nombre de la pel�cula",
							"Ingrese",
							3
					);
					peliculas.buscarPelicula(nombrePelicula);
					break;
				case 4:
					break CERRAR;
				default:
					JOptionPane.showMessageDialog(
							null, 
							"Opci�n incorrecta\n"
							+"vuelva a ingresar una\n"
							+"opci�n correcta\n"
							+"las opciones son de 1 a 4",
							"Error",
							JOptionPane.ERROR_MESSAGE
						);
			}
	}
}
}
