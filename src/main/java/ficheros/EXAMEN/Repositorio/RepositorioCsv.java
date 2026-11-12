package ficheros.EXAMEN.Repositorio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Logger;

import ficheros.EXAMEN.Modelo.Criatura;
import ficheros.EXAMEN.Modelo.Habitat;
import ficheros.EXAMEN.Modelo.TipoCriatura;

public class RepositorioCsv implements IRepositorioCsv {
	Logger LOGGER = Logger.getLogger(RepositorioCsv.class.getName());
	
	File ficheroCsv;
	/* CORREGIDO: Usar TreeSet asegura orden alfabético automático y evita duplicados por nombre */
	private Set<Criatura> criaturas;
	
	public RepositorioCsv(File ficheroCsv) {
		super();
		this.ficheroCsv = ficheroCsv;
	}

	@Override
	public List<Criatura> findAll() throws CriaturaFantasticasException{
		cargarSiHaceFalta();
		return new ArrayList<>(criaturas); // Convertimos el TreeSet a List para cumplir la interfaz
	}

	@Override
	public void save(Criatura criatura) throws CriaturaFantasticasException{
		cargarSiHaceFalta();
		// Al ser un TreeSet, .add() ya comprueba si existe (equals/compareTo) y lo añade ordenado
		criaturas.add(criatura);
		// Nota: En un examen completo aquí volcarías el TreeSet al fichero CSV con PrintWriter.
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
			this.criaturas = leerCsv();
		}
	}
	
	private Set<Criatura> leerCsv() throws CriaturaFantasticasException{
		Set<Criatura> lista = new TreeSet<>(); // TreeSet ordena automáticamente
		BufferedReader lector = null;
		
		try {
			if(ficheroCsv.exists()) {
				lector = new BufferedReader(new FileReader(ficheroCsv));
				
				String linea = lector.readLine(); // Salto cabecera
				linea = lector.readLine();
				
				while(linea != null) {
					String[] partes = linea.split(";");
					if(partes.length >= 7) {
						String nombre = partes[0].trim();
						/* CORREGIDO: TipoCriatura.valueOf para convertir String a Enum */
						TipoCriatura tipo = TipoCriatura.valueOf(partes[1].trim().toUpperCase()); 
						boolean inmortal = Boolean.parseBoolean(partes[2].trim());
						int peligrosidad = Integer.parseInt(partes[3].trim());
						int magia =  Integer.parseInt(partes[4].trim());
						String region = partes[5].trim();
						String clima  = partes[6].trim();
						
						Habitat habitat = new Habitat(region, clima);
						lista.add(new Criatura(nombre, tipo, inmortal, peligrosidad, magia, habitat));
					}
					linea = lector.readLine();
				}
			}
		} catch (Exception e){
			/* CORREGIDO: El throw va SIEMPRE después del LOGGER para que no sea código inalcanzable */
			LOGGER.severe("Dato en fichero no válido debido a " + e.getMessage());
			throw new CriaturaFantasticasException("Error al leer el CSV");
		} finally {
			if(lector != null) {
				try { lector.close(); } catch (Exception ex) {}
			}
		}
		return lista;
	}
}