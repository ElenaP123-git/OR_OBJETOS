package ficheros.ModelFiles;
import java.io.File;
import java.util.Scanner;
import java.util.logging.Logger;

public class BoletinFile9 {
	private static final Logger LOGGER = Logger.getLogger(BoletinFile9.class.getName());

    public static void main(String[] args) {
        File userRuta = new File(System.getProperty("user.home"));
        File directABorrar = new File(userRuta, "miDirectorioABorrar");

        if (directABorrar.exists() && directABorrar.isDirectory()) {
        	BoletinFile9 app = new BoletinFile9();
            app.procesarBorrado(directABorrar);
        } else {
            LOGGER.severe("[ERROR] El directorio a borrar no existe o no es válido: " + directABorrar.getAbsolutePath());
        }
    }

    
    public void procesarBorrado(File dir) {
        int totalFicheros = contarFicheros(dir);

        LOGGER.info("Se van a eliminar " + totalFicheros + " elemento(s) (ficheros y subcarpetas) en: " + dir.getAbsolutePath());

        Scanner sc = new Scanner(System.in);
        System.out.print("¿Seguro que quieres eliminar este directorio y todo su contenido? (S/N): ");
        String respuesta = sc.nextLine().trim();

        if (respuesta.equalsIgnoreCase("S")) {
            boolean exito = borrarDirectorio(dir);

            if (exito) {
                LOGGER.info("El directorio y todo su contenido se han eliminado correctamente.");
            } else {
                LOGGER.severe("[ERROR] Ocurrió un fallo al intentar borrar algunos elementos.");
            }
        } else {
            LOGGER.info("Cancelado por el usuario.");
        }

    }

    //Cuenta de forma recursiva la cantidad total de ficheros y subcarpetas dentro de 'dir'.
    public int contarFicheros(File dir) {
        int contador = 0;
        File[] elementos = dir.listFiles();

        if (elementos != null) {
            for (int i = 0; i < elementos.length; i++) {
                File elem = elementos[i];

                if (elem.isDirectory()) {
                    // Recursividad 
                    contador += contarFicheros(elem);
                }
                // Si no es un directorio, se cuenta como que hay algo dentro 
                contador++;
            }
        }

        return contador;
    }

    //Borra primero todo el contenido (ficheros y subcarpetas) y finalmente la propia carpeta 'dir'.
    public boolean borrarDirectorio(File dir) {
        File[] elementos = dir.listFiles();

        if (elementos != null) {
            for (int i = 0; i < elementos.length; i++) {
                File elem = elementos[i];

                if (elem.isDirectory()) {
                    // Recursividad de borrado
                    borrarDirectorio(elem);
                } else {
                    // Si es un fichero suelto, lo borramos directamente
                    boolean borrado = elem.delete();
                    if (!borrado) {
                        LOGGER.warning("No se pudo borrar el archivo: " + elem.getAbsolutePath());
                    }
                }
            }
        }
        return dir.delete(); //esto se cumple cuando ya está todo vacío
    }
}
