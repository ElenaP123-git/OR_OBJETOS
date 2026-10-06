package fichero.ModelFile;

import java.io.File;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager; //loggers
import org.apache.logging.log4j.Logger;

import fichero.Exceptions.RutaNoValidaException;

public class BoletinFile5 {
	private static final Logger logger = LogManager.getLogger(BoletinFile5.class);
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce la ruta del directorio para calcular su tamaño: ");
        String ruta = scanner.nextLine();

        BoletinFile5 bol = new BoletinFile5();
        
        try {
            bol.iniciar(ruta);
        } catch (RutaNoValidaException e) {
            logger.error("Error al procesar la ruta: {}", e.getMessage());
        }
        
	}
	public void iniciar(String ruta) throws RutaNoValidaException {
		File direct = new File(ruta);
		
		if (!direct.exists()) {
            throw new RutaNoValidaException("La ruta introducida no existe: " + ruta);
        }
        if (!direct.isDirectory()) {
            throw new RutaNoValidaException("La ruta introducida no es un directorio: " + ruta);
        }
        
        long tamanioBytes = calcularTamanioRecursivo(direct);
    /*    String tamanioFormateado = formatearTamanio(tamanioBytes); 
        logger.info("El tamaño total del directorio es: {}", tamanioFormateado);*/
	}
	
	public long calcularTamanioRecursivo(File carpeta) {
        long sumaTotal = 0;
        File[] elementos = carpeta.listFiles();

        if (elementos == null) {
            logger.warn("Sin permisos para acceder a la carpeta: {}", carpeta.getAbsolutePath());
        } else {
            for (File elem : elementos) {
                if (elem.isFile()) {
                    sumaTotal += elem.length();
                } else if (elem.isDirectory()) {
                    sumaTotal += calcularTamanioRecursivo(elem);
                }
            }
        }

        return sumaTotal;
    }
	/*
	public String formatearTamanio(long bytes) {
        double bytesDouble = bytes;
        double kilobytes = bytesDouble / 1024;
        double megabytes = kilobytes / 1024;

        if (megabytes >= 1) {
            return String.format("%.2f MB", megabytes);
        } else if (kilobytes >= 1) {
            return String.format("%.2f KB", kilobytes);
        } else {
            return String.format("%d Bytes", bytes);
        }
    } */
}
