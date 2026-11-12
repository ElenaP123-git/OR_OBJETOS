package ficheros.EXAMEN.Repositorio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import ficheros.EXAMEN.Modelo.Criatura;

public class RepositorioJson implements IRepositorioCsv {

	private File ficheroJson;
	private Set<Criatura> criaturas;
	
	public RepositorioJson(File ficheroJson) {
		this.ficheroJson = ficheroJson;
	}

	@Override
	public List<Criatura> findAll() throws CriaturaFantasticasException {
		cargarSiHaceFalta();
		return new ArrayList<>(criaturas);
	}

	@Override
	public void save(Criatura criatura) throws CriaturaFantasticasException {
		cargarSiHaceFalta();
		criaturas.add(criatura);
		guardarJson(); // Guarda automáticamente en el fichero JSON
	}

	@Override
	public boolean findById(String nombre) throws CriaturaFantasticasException {
		cargarSiHaceFalta();
		for (Criatura c : criaturas) {
			if (c.getNombre().equalsIgnoreCase(nombre.trim())) {
				return true;
			}
		}
		return false;
	}
	
	private void cargarSiHaceFalta() throws CriaturaFantasticasException{
		if(this.criaturas == null) {
			this.criaturas = leerJson();
		}
	}

	/* CORREGIDO: Lectura completa con Gson (si el fichero no existe, arranca vacío sin romperse) */
	private Set<Criatura> leerJson() throws CriaturaFantasticasException{
		Set<Criatura> lista = new TreeSet<>();
		BufferedReader lector = null;
		
		try {
			if(ficheroJson.exists()) {
				lector = new BufferedReader(new FileReader(ficheroJson));
				Gson gson = new Gson();
				Criatura[] arrayCriaturas = gson.fromJson(lector, Criatura[].class);
				if(arrayCriaturas != null) {
					lista.addAll(Arrays.asList(arrayCriaturas));
				}
			}
		} catch (Exception e) {
			throw new CriaturaFantasticasException("Error al leer el JSON: " + e.getMessage());
		} finally {
			if(lector != null) {
				try { lector.close(); } catch (Exception e) {}
			}
		}
		return lista;
	}

	/* CORREGIDO: Método para volcar el TreeSet al fichero JSON usando Gson y FileWriter */
	public void guardarJson() throws CriaturaFantasticasException {
		try (FileWriter writer = new FileWriter(ficheroJson)) {
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			gson.toJson(criaturas, writer);
		} catch (Exception e) {
			throw new CriaturaFantasticasException("Error al escribir el JSON: " + e.getMessage());
		}
	}
}