package streams;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopiarArchivo {
	
	public FileInputStream fi;
	public FileOutputStream fo;
	public byte[] b;
	public File archivoE, archivoS;
	
	public CopiarArchivo(String[] args) {
		
		if(args.length==2) {
		
			try {
				archivoE = new File(args[0]);
				archivoS = new File(args[1]);				
			} catch (Exception e) {
				// TODO: handle exception
				System.err.println(e.getMessage());
				System.exit(0);
			}
		}else {
			System.out.println("Tenemos el original");
		}
	}
	
	public void duplicar() {
		
		System.out.println("Arrancamos"+System.currentTimeMillis());
		
		try {
			fi = new FileInputStream(archivoE);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			fo = new FileOutputStream(archivoS);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		b = new byte[(int)archivoE.length()];
		System.out.println("Listo!"+System.currentTimeMillis());
		
		
		try {
			fi.read(b);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Terminamos de leer "+System.currentTimeMillis());
		try {
			fo.write(b);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fi.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fo.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Terminamos de escribir "+System.currentTimeMillis());
	}

	public static void main(String[] args) {
		
		CopiarArchivo cp = new CopiarArchivo(args);
		cp.duplicar();
		
		//en la flehca de Run -> Run Configurations... -> seleccionar pestaña de Arguments -> agregar la ruta con el archivo y una segunda con el nombre de la copia

	}

}
