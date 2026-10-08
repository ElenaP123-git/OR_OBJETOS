package fichero.ModelFiles;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;
import java.util.logging.Logger;

public class BoletinFile6 {
	private static final Logger LOGGER = Logger.getLogger(BoletinFile6.class.getName());
	
	public static void main(String[] args) {
		File userRuta = new File(System.getProperty("user.home"));
		File direct = new File(userRuta,"miDirectorio");
		
		if(direct.exists() && direct.isDirectory()) {
			Scanner sc = new Scanner(System.in);
            System.out.print("Introduce la extensión a buscar (ejemplo: .txt): ");
            String extension = sc.nextLine();
            
            BoletinFile6 bol = new BoletinFile6();
            LOGGER.info("Filtrando ficheros con la extensión '" + extension + "' en: " + direct.getAbsolutePath());
		
            bol.filtrarPorExtension(direct, extension);
		} else {
			LOGGER.severe("[ERROR] El directorio no existe o no es una carpeta válida.");
		}
		
		
	}
	
	public void filtrarPorExtension(File dir, String extension) {
		File[] ficheros = dir.listFiles(new FilenameFilter(){
			@Override
            public boolean accept(File dir, String nombre) { //en este metodo siempre hay que recibir un File y un String
                // Comprobamos si el nombre del fichero termina con la extensión
                return nombre.toLowerCase().endsWith(extension.toLowerCase());
            }
		});
		
		if (ficheros != null && ficheros.length > 0) {
			LOGGER.info("Se encontraron " + ficheros.length + " fichero(s):");
			for (int i = 0; i < ficheros.length; i++) {
                LOGGER.info("- " + ficheros[i].getName());
            } 
		} else {
        	LOGGER.info("No se encontraron ficheros con la extensión: " + extension);
        }
	}
}
