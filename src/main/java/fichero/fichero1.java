package fichero;

import java.io.File;
import java.io.IOException;

public class fichero1 {

    public static void main(String[] args) {
        String rutaDirectorio = "C:\\Users\\Alumno\\Documents\\fichero1";
        File directorio = new File(rutaDirectorio);

        // Referenciamos el fichero dentro de la ruta del directorio
        File fichero = new File(directorio, "fichero.txt");

        try {
            // El método createNewFile() intenta crear el fichero 
            boolean creado = fichero.createNewFile(); 
            
            if (creado) {
                System.out.println("El fichero se ha creado correctamente.");
            } else {
                System.out.println("El fichero ya existía.");
            }
        } catch (IOException e) {
            System.err.println("Error al crear el fichero: " + e.getMessage());
        }
    }
}

/* O también...

package fichero; 

import java.io.File;
import java.io.IOException;

public class fichero1 {

    public void crearFichero() {
        String rutaDirectorio = "C:\\Users\\Alumno\\Documents\\fichero1";
        File directorio = new File(rutaDirectorio);

        File fichero = new File(directorio, "fichero.txt");

        try {
            boolean creado = fichero.createNewFile();
            if (creado) {
                System.out.println("Fichero creado exitosamente.");
            }
        } catch (IOException e) {
            System.err.println("Error al crear el fichero: " + e.getMessage());
        }
    }
}*/