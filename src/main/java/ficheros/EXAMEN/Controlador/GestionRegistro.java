package ficheros.EXAMEN.Controlador;

import java.io.File;
import java.util.List;

import ficheros.EXAMEN.Modelo.Criatura;
import ficheros.EXAMEN.Modelo.Habitat;
import ficheros.EXAMEN.Modelo.TipoCriatura;
import ficheros.EXAMEN.Servicio.IServicio;
import ficheros.EXAMEN.Servicio.Servicio;

public class GestionRegistro {
	public static void main(String[] args) {
		File fichero = new File("src\\main\\resources\\criaturasfantasticas.csv");
		
		/* CORREGIDO: El fichero JSON de destino debe incluir nombre y extensión. 
		   Si no existe, Java/Gson lo crea automáticamente al escribir sobre él. */
		File ficheroJson = new File("src\\main\\resources\\criaturas.json");
		
		IServicio servicio = new Servicio(fichero);
		
		try {
			List<Criatura> lista = servicio.listar();
			int i = 0;
			while (i < lista.size()) {
				System.out.println(lista.get(i));
				i++;
			}
			
			Habitat hab1 = new Habitat("España", "Frio");
			Habitat hab2 = new Habitat("Francia", "Calor");
			
			servicio.alta("Dementor", TipoCriatura.SER, true, 10, 30, hab1);
			servicio.alta("Nundu", TipoCriatura.BESTIA, false, 20, 60, hab2);
			
			/* CORREGIDO: Pasamos la lista actual (colección) y el fichero JSON destino */
			servicio.convertirCsvJson(servicio.listar(), ficheroJson);
			
		} catch (Exception e) {
			System.out.println("Error en ejecución: " + e.getMessage());
		}
	}
}