package fichero.ModelFiles;

import java.io.File;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager; //loggers
import org.apache.logging.log4j.Logger;
import fichero.Exceptions.RutaNoValidaException;

public class BoletinFile4 {
	
	private static final Logger nombrelogger = LogManager.getLogger(BoletinFile4.class);
		
		public static void main(String[] args) {
			
			Scanner scanner = new Scanner(System.in);
	        System.out.print("Introduce la ruta del directorio: ");
	        String ruta = scanner.nextLine();
	        
	        //Creo objeto (estamos en el gestiona, no se usa static)
	        BoletinFile4 bol = new BoletinFile4();
	        
	        try {
	        	bol.iniciar(ruta);
	        }
	        catch (RutaNoValidaException e)
	        {
	        	nombrelogger.error("Error en la ruta: {}", e.getMessage()); //otra manera de imprimir {}
	        	} 
	        }
		
		public void iniciar(String ruta) throws RutaNoValidaException{
			
			File direct = new File(ruta); //guardo la ruta en una variable fichero (File es la ruta que ocupa algo en el disco duro, no literalmente un fichero)
											//puede ser C:\Notas (fichero) o C:\Notas\ejemplo.txt (directorio)
			if(!direct.exists()) {
				throw new RutaNoValidaException("La ruta no existe");
			}
			if (!direct.isDirectory()) {
				throw new RutaNoValidaException("La ruta no es un directorio");
			}
			
			nombrelogger.info("Listado de: " + direct.getAbsolutePath());
			listarRecursivo(direct);		
			}
		
		public void listarRecursivo(File carpeta){
			
			File[] elementos = carpeta.listFiles(); //si esto da null es que no hay permiso de lectura, muestra todos los elementos dentro de la carpeta
			
			if (elementos == null) {
				System.out.println("Sin permisos para acceder a: " + carpeta.getAbsolutePath());
			}
			else {
				for(File elem: elementos) {
					if(elem.isDirectory()) { //si es una carpeta, mostramos informacion
						nombrelogger.info("DIRECTORIO: " + elem.getAbsolutePath());
						listarRecursivo(elem); //recursividad
					}
					else if (elem.isFile()){ //si es un fichero, mostramos su nombre y ruta
						nombrelogger.info("FICHERO: " + elem.getName() + " RUTA: " + elem.getAbsolutePath());
					}
				}
			
			}
 			}
}

