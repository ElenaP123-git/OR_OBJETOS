package EJERCICIO1.Controller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import EJERCICIO1.Exceptions.CraftersException;
import EJERCICIO1.Model.Deportivo;


public class Gestiona {
	private static final Logger logger = LogManager.getLogger(Gestiona.class);
	
	public static void main(String[] args) {
		logger.debug("Empieza main");
		Deportivo d = null;
		try {
			d = new Deportivo(1,100);
			throw new CraftersException("Lanzo excepción");
		} catch (CraftersException ex){
			logger.error("Error en main " + ex.getMessage());
		}
		logger.debug("Acaba");
	}
}
