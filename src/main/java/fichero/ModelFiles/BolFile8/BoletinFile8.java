package fichero.ModelFiles.BolFile8;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.logging.Logger;
import java.util.logging.Logger;

public class BoletinFile8 {
	private static final Logger LOGGER = Logger.getLogger(BoletinFile8.class.getName());

	public static void main(String[] args) {
		File rutaUser = new File(System.getProperty("user.home"));
		File direct = new File(rutaUser, "miDirectorio");
		
		if (direct.exists() && direct.isDirectory()) {
			BoletinFile8 bol = new BoletinFile8();
			
			File[] ficheros = direct.listFiles();
			
			if (ficheros != null && ficheros.length > 0) {
                LOGGER.info("--- LOS 5 MÁS GRANDES ---");
                bol.ordenarPorTamaño(ficheros);

                LOGGER.info("--- LOS 5 MÁS RECIENTES ---");
                bol.ordenarPorFecha(ficheros);
            }
        } else {
            LOGGER.severe("[ERROR] El directorio no existe o no es una carpeta válida.");
   
			
		}
	}
	public void ordenarPorTamaño(File[] ficheros) {
		// Antes para las arrays usaba Collections.sort pero como ahora trabajamos con File[]
		// se usa Array	
		
		Arrays.sort(ficheros, new ComparadorTamanoDesc());
		
		for (int i = 0; i < 5 && i < ficheros.length; i++) {
			LOGGER.info((i + 1) + ". " + ficheros[i].getName() + " -> " + ficheros[i].length() + " bytes");
		}
	}
	
	public void ordenarPorFecha(File[] ficheros) {
		Arrays.sort(ficheros, new ComparadorFechaDesc());
		
		for (int i = 0; i < 5 && i < ficheros.length; i++) {
            LOGGER.info((i + 1) + ". " + ficheros[i].getName() + " -> " + new Date(ficheros[i].lastModified())); //muestra fecha de la última modificación de ese archivo concreto
        }
	}
}
