package JSON.Empleado;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;

import ficheros.ModelFiles.BoletinFile4;

public class UtilidadesJsonEmpleados {
	private static final Logger logger = LogManager.getLogger(UtilidadesJsonEmpleados.class);
	
	public static void main(String[] args) {
		FileReader fichero;
		
		try {
			Gson gson = new Gson();
			fichero = new FileReader ("src\\main\\resources\\empleado.json");
			Empleado empleado = gson.fromJson(fichero, Empleado.class);
			logger.debug(empleado);
		} catch(FileNotFoundException e) {
			logger.error(e);
		}
		
	}
}
