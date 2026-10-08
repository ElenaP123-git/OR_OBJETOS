package fichero.ModelFiles;

import java.io.File;
import java.util.logging.Logger;

public class BoletinFile5 {

    private static final Logger LOGGER = Logger.getLogger(BoletinFile5.class.getName());

    public static void main(String[] args) {

        File usuarioHome = new File(System.getProperty("user.home"));
        File directorioAAnalizar = new File(usuarioHome, "miDirectorio");

        // Verifico si el directorio existe y es una carpeta
        if (directorioAAnalizar.exists() && directorioAAnalizar.isDirectory()) {

            LOGGER.info("Cálculo de tamaño para: " + directorioAAnalizar.getAbsolutePath());

            // Llamo métodos creando la instancia
            BoletinFile5 bol = new BoletinFile5();
            int totalBytes = bol.calcularTamanoDirectorio(directorioAAnalizar); 
            bol.mostrarTamanoFormateado(totalBytes);

        } else {
            LOGGER.severe("[ERROR] El directorio especificado no existe o no es una carpeta: " + directorioAAnalizar.getAbsolutePath());
        }
    }

    // Método RECURSIVO que recorre carpetas y subcarpetas sumando el tamaño (.length()) de cada fichero encontrado 
     
    private int calcularTamanoDirectorio(File directorio) {
        int sumaBytes = 0;
        File[] elementos = directorio.listFiles();

        if (elementos != null) {
            for (File elemento : elementos) {
                if (elemento.isFile()) {
                    // Casteo a (int) porque .length() devuelve long
                    sumaBytes += (int) elemento.length();
                } else if (elemento.isDirectory()) {
                    // Si es una subcarpeta, volvemos a llamar a este mismo método (Recursividad)
                    sumaBytes += calcularTamanoDirectorio(elemento);
                }
            }
        }

        return sumaBytes;
    }

    // Método para convertir bytes a KB o MB con 2 decimales usando String.format
    
    private void mostrarTamanoFormateado(int bytes) {
        double bytesEnKB = bytes / 1024.0;
        double bytesEnMB = bytes / (1024.0 * 1024.0);

        if (bytes < 1024) {
            LOGGER.info("Tamaño total: " + bytes + " bytes");
        } else if (bytes < 1024 * 1024) {
            // %.2f sirve para limitar el resultado a 2 decimales
            LOGGER.info(String.format("Tamaño total: %.2f KB", bytesEnKB));
        } else {
            LOGGER.info(String.format("Tamaño total: %.2f MB", bytesEnMB));
        }
    }
}