package fichero.ModelFiles;

import java.io.File;
import java.util.Scanner;

import fichero.Exceptions.RutaNoValidaException;

public class BoletinFile {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce la ruta de un directorio: ");
        String ruta = scanner.nextLine();

        try {
            analizarDirectorio(ruta);
        } catch (RutaNoValidaException e) {
            System.out.println(e.getMessage());
        }
    }

	//MÉTODO
	
    public static void analizarDirectorio(String ruta) throws RutaNoValidaException {
        File dir = new File(ruta);

        // ¿EXISTE LA RUTA?
        if (!dir.exists()) {
            throw new RutaNoValidaException("Error: La ruta introducida no existe.");
        }

        // ¿ES UN DIRECTORIO?
        if (!dir.isDirectory()) {
            throw new RutaNoValidaException("Error: La ruta introducida no corresponde a un directorio.");
        }

        // ELEMENTOS -> LISTA 
        File[] elementos = dir.listFiles();

        // listFiles() devuelve null si no hay nada,CUENTA FILES Y DIRECTORIES
     
        if (elementos == null) {
            System.out.println("No se tienen permisos de lectura para acceder a este directorio.");
        } else {
            int contadorFicheros = 0;
            int contadorDirectorios = 0;

            for (File elem : elementos) {
                if (elem.isFile()) {
                    System.out.println("[F] " + elem.getName());
                    contadorFicheros++;
                } else if (elem.isDirectory()) {
                    System.out.println("[D] " + elem.getName());
                    contadorDirectorios++;
                }
            }

            System.out.println("\nTotal de ficheros: " + contadorFicheros);
            System.out.println("Total de directorios: " + contadorDirectorios);
        }

     }
    
}
