package ficheros.ModelFiles;
import java.io.File;
import java.util.logging.Logger;

public class BoletinFile10 {
	private static final Logger LOGGER = Logger.getLogger(BoletinFile10.class.getName());

    public static void main(String[] args) {
        File userRuta = new File(System.getProperty("user.home"));
        File carpetaDescargas = new File(userRuta, "Downloads");

        if (carpetaDescargas.exists() && carpetaDescargas.isDirectory()) {
        	BoletinFile10 org = new BoletinFile10();
            org.organizarDirectorio(carpetaDescargas);
        } else {
            LOGGER.severe("[ERROR] El directorio especificado no existe o no es válido.");
        }
    }

    public void organizarDirectorio(File dir) {
        File[] elementos = dir.listFiles();

        if (elementos != null && elementos.length > 0) {
            int movidos = 0;

            for (int i = 0; i < elementos.length; i++) {
                File elem = elementos[i];

                if (elem.isFile()) {
                    String extension = obtenerExtension(elem.getName());

                    if (extension.isEmpty()) {
                        extension = "sin_extension";
                    }

                    // Creamos la subcarpeta si no existe
                    File subcarpetaDestino = new File(dir, extension);
                    if (!subcarpetaDestino.exists()) {
                        subcarpetaDestino.mkdir();
                    }
                    
                    File archivoDestino = obtenerDestinoUnico(subcarpetaDestino, elem.getName());
                    boolean exito = elem.renameTo(archivoDestino);

                    if (exito) {
                        LOGGER.info("Movido: " + elem.getName() + " -> " + extension + "/" + archivoDestino.getName());
                        movidos++;
                    } else {
                        LOGGER.warning("No se pudo mover el fichero: " + elem.getName());
                    }
                }
            }

            LOGGER.info("Proceso completado. Se han movido " + movidos + " fichero(s).");
        } else {
            LOGGER.info("No hay ficheros para organizar en el directorio.");
        }
    }

    //Extraer la extensión de un fichero
    private String obtenerExtension(String nombre) {
        int ultimoPunto = nombre.lastIndexOf('.'); //lastIndexOf para encontrar la posición del último punto (devuelve -1 si no lo encuentra)
        
        if (ultimoPunto > 0 && ultimoPunto < nombre.length() - 1) { //"Si hay algo antes del punto y algo detrás"
            return nombre.substring(ultimoPunto + 1).toLowerCase(); //substring para cortar la cadena por donde se pide (+1 para no coger el punto, solo lo que hay detrás)
        }
        else {
        	return "";
        }
    }

    private File obtenerDestinoUnico(File carpetaDestino, String nombreOriginal) {
        File destino = new File(carpetaDestino, nombreOriginal);

        if (!destino.exists()) {
            return destino;
        }

        // Si SÍ existe, separar el nombre de la extensión
        int ultimoPunto = nombreOriginal.lastIndexOf('.');
        
        String nombreSinExt;
        String ext;

        if (ultimoPunto > 0) {
            nombreSinExt = nombreOriginal.substring(0, ultimoPunto);
            ext = nombreOriginal.substring(ultimoPunto); //desde el último punto hasta el final
        } else {
            // No tiene extensión
            nombreSinExt = nombreOriginal;
            ext = "";
        }

        int contador = 1;
        
        while (destino.exists()) {
            String nuevoNombre = nombreSinExt + "(" + contador + ")" + ext;
            destino = new File(carpetaDestino, nuevoNombre);
            contador++;
        }

        return destino;
    }
}
