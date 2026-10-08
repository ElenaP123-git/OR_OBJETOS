package fichero.ModelFiles;

import java.io.File;
import java.util.ArrayList;
import java.util.List; 
import java.util.Scanner;
import java.util.logging.Logger;

public class BoletinFile7 {
	private static final Logger LOGGER = Logger.getLogger(BoletinFile7.class.getName());
	
	public static void main(String[] args) {
		
		File userRuta = new File(System.getProperty("user.home"));
		File direct = new File(userRuta, "miDirectorio");
		
		if (direct.exists() && direct.isDirectory()) {
			Scanner sc = new Scanner(System.in);		
			System.out.print("Introduce el texto: ");
			String texto = sc.nextLine();
			
			BoletinFile7 bol= new BoletinFile7();
			LOGGER.info("Inicio búsqueda de texto en los ficheros del directorio" + direct.getAbsolutePath());
			List<File> results = bol.buscar(direct, texto);
			
			if (results.isEmpty()) {
				LOGGER.info("No se encontraron ficheros que contengan el texto: " + texto);
			}
			else {
				LOGGER.info("Se encontraron " + results.size() + " coincidencia(s):");
				for (File f: results) {
					LOGGER.info(f.getName() + " -> " + f.getAbsolutePath());
				}
			}
		}
		
	}
	
	public List<File> buscar(File dir, String nombre) {
	    List<File> coincidencias = new ArrayList<>();

	    if (dir != null && dir.isDirectory() && dir.listFiles() != null) {
	        for (File elemento : dir.listFiles()) {

	            // Si el nombre coincide (fichero o carpeta), se añade
	            if (elemento.getName().toLowerCase().contains(nombre.toLowerCase())) {
	                coincidencias.add(elemento);
	            }

	            // Si es una carpeta, se buscan sus hijos recursivamente
	            if (elemento.isDirectory()) {
	                coincidencias.addAll(buscar(elemento, nombre));
	            }
	        }
	    }

	    return coincidencias;
	}
	
}
