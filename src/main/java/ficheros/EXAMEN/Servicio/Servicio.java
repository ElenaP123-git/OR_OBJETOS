package ficheros.EXAMEN.Servicio;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

import ficheros.EXAMEN.Modelo.Criatura;
import ficheros.EXAMEN.Modelo.Habitat;
import ficheros.EXAMEN.Modelo.TipoCriatura;
import ficheros.EXAMEN.Repositorio.CriaturaFantasticasException;
import ficheros.EXAMEN.Repositorio.IRepositorioCsv;
import ficheros.EXAMEN.Repositorio.RepositorioCsv;
import ficheros.EXAMEN.Repositorio.RepositorioJson;

public class Servicio implements IServicio {
	Logger LOGGER = Logger.getLogger(Servicio.class.getName());
	
	private IRepositorioCsv repoCsv;

	public Servicio(File ficheroCsv) {
		this.repoCsv = new RepositorioCsv(ficheroCsv);
	}

	@Override
	public boolean alta(String nombre, TipoCriatura tipo, boolean inmortal, int peligrosidad, int magia, Habitat habitat) throws CriaturaFantasticasException {
		try {
			if(nombre == null || nombre.trim().isEmpty() || tipo == null || habitat == null) {
				return false;
			}
			if(repoCsv.findById(nombre)) {
				throw new CriaturaFantasticasException("Esta criatura ya existe");
			}
			Criatura criatura = new Criatura(nombre, tipo, inmortal, peligrosidad, magia, habitat);
			repoCsv.save(criatura);
			return true;
		} catch (CriaturaFantasticasException e) {
			LOGGER.severe("Error al dar de alta a la criatura: " + e.getMessage());
			return false;
		}
	}
	
	@Override
	public List<Criatura> filtrarPorTipoCriatura(TipoCriatura tipo) throws CriaturaFantasticasException {
		List<Criatura> todos = listar();
		List<Criatura> filtrados = new ArrayList<>();
		
		int i = 0;
		while (i < todos.size()) {
			Criatura c = todos.get(i);
			if(c.getTipo().equals(tipo)) {
				filtrados.add(c);
			}
			i++;
		}
		return filtrados;
	}

	@Override
	public boolean baja(String nombre) throws CriaturaFantasticasException {
		return false; 
	}
	
	@Override
	public List<Criatura> listar() throws CriaturaFantasticasException {
		try {
			return repoCsv.findAll();
		} catch (CriaturaFantasticasException e) {
			LOGGER.severe("Error al listar a las criaturas: " + e.getMessage());
			return new ArrayList<>();
		}
	}
	
	/* CORREGIDO: Convierte pasando una colección de criaturas y el fichero destino. 
	   Nota: Si el fichero no existe, Gson / FileWriter lo crea automáticamente al escribir. */
	@Override
	public void convertirCsvJson(Collection<Criatura> criaturas, File ficheroJson) throws CriaturaFantasticasException {
		try {
			RepositorioJson repoJson = new RepositorioJson(ficheroJson);
			int i = 0;
			List<Criatura> lista = new ArrayList<>(criaturas);
			while(i < lista.size()) {
				repoJson.save(lista.get(i));
				i++;
			}
		} catch (Exception e) {
			LOGGER.severe("Error al convertir a JSON: " + e.getMessage());
			throw new CriaturaFantasticasException("Error en conversión CSV a JSON");
		}
	}
}
