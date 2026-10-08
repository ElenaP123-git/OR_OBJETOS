package fichero.ModelFiles;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

public class BoletinFile3 {
    private static final Logger LOGGER = Logger.getLogger(BoletinFile3.class.getName());

    public static void main(String[] args) {

        // Crear la carpeta 'miDirectorio' dentro de la ruta del usuario
    	
        File usuarioHome = new File(System.getProperty("user.home"));
        File miDirectorio = new File(usuarioHome, "miDirectorio");

        if (!miDirectorio.exists()) {
            if (miDirectorio.mkdir()) { //es .mkdir() porque creo una carpeta, si fuera archivo sería .createNewFile()
                LOGGER.info("[OK] Directorio creado: " + miDirectorio.getAbsolutePath());
            } else {
                LOGGER.severe("[ERROR] No se pudo crear el directorio: " + miDirectorio.getAbsolutePath());
            }
        } else {
            LOGGER.info("[INFO] El directorio ya existía: " + miDirectorio.getAbsolutePath());
        }

        // Crear dentro de miDirectorio dos ficheros vacíos
        
        File fLectura = new File(miDirectorio, "lectura.txt");
        File fNormal = new File(miDirectorio, "normal.txt");

        try {
            if (fLectura.createNewFile()) {
                LOGGER.info("[OK] Fichero creado: " + fLectura.getName());
            } else {
                LOGGER.info("[INFO] El fichero ya existía: " + fLectura.getName());
            }

            if (fNormal.createNewFile()) {
                LOGGER.info("[OK] Fichero creado: " + fNormal.getName());
            } else {
                LOGGER.info("[INFO] El fichero ya existía: " + fNormal.getName());
            }
        } catch (IOException e) {
        	LOGGER.severe("Error al crear archivo: " + e.getMessage());
        }

        // Marcar lectura.txt como fichero de solo lectura

        if (fLectura.setReadOnly()) {
            LOGGER.info("[OK] " + fLectura.getName() + " marcado como solo lectura");
        } else {
            LOGGER.severe("[ERROR] No se pudo marcar como solo lectura " + fLectura.getName());
        }

        // Muestra los permisos de lectura, escritura y ejecución 
        
        BoletinFile3 bol = new BoletinFile3();
        bol.mostrarPermisos(fLectura);
        bol.mostrarPermisos(fNormal);

        // Renombrar normal.txt a renombrado.txt

        File fRenombrado = new File(miDirectorio, "renombrado.txt");
        if (fNormal.renameTo(fRenombrado)) { // espera un objeto File, así que no se puede poner el nombre que quieres directamente
            LOGGER.info("[OK] " + fNormal.getName() + " renombrado a " + fRenombrado.getName());
        } else {
            LOGGER.severe("[ERROR] No se pudo renombrar el fichero " + fNormal.getName());
        }

        // Intentar borrar lectura.txt (al ser solo lectura fallará/dará false)

        if (fLectura.delete()) {
            LOGGER.info("[OK] " + fLectura.getName() + " borrado a la primera");
        } else {
            LOGGER.severe("[ERROR] No se ha podido borrar " + fLectura.getName());

            // Quitar marca de solo lectura (otorgar permiso de escritura) y reintentar
            if (fLectura.setWritable(true)) {
                LOGGER.info("[OK] Permiso de escritura restaurado en " + fLectura.getName());

                if (fLectura.delete()) {
                    LOGGER.info("[OK] " + fLectura.getName() + " borrado");
                } else {
                    LOGGER.severe("[ERROR] No se pudo borrar el archivo en el segundo intento.");
                }
            } else {
                LOGGER.severe("[ERROR] No se pudieron restablecer los permisos de escritura.");
            }
        }

        //Muestra el contenido final de miDirectorio (nombre de los archivos del directorio)

        LOGGER.info("Contenido final de " + miDirectorio.getName() + ":");
        File[] archivos = miDirectorio.listFiles();

        if (archivos != null) {
            for (File archivo : archivos) {
                LOGGER.info(archivo.getName());
            }
        }
    }
    
    //Método para mostrar permisos
    
    private void mostrarPermisos(File f) {
        LOGGER.info("\n" + f.getName() + " -> lectura: " + f.canRead() 
                + " | escritura: " + f.canWrite() 
                + " | ejecución: " + f.canExecute());
    }
}