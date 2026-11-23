package ficheros.XML.Peliculas2;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GestionaPeliculas2 {
	private static final Logger logger = LogManager.getLogger(GestionaPeliculas2.class);

	private final PeliculasRepo2 peliculasRepo;

	public GestionaPeliculas2() {
		this.peliculasRepo = new PeliculasRepo2();
	}

	public GestionaPeliculas2(PeliculasRepo2 peliculasRepo) {
		this.peliculasRepo = peliculasRepo;
	}

	public List<Pelicula2> listarPeliculas(String nombreFichero) {
		return peliculasRepo.obtenerPeliculasDesdeFichero(nombreFichero);
	}

	public void guardarPeliculas(String nombreFichero, List<Pelicula2> peliculas) {
		peliculasRepo.guardarPeliculasEnFichero(nombreFichero, peliculas);
	}

	public static void main(String[] args) {
		GestionaPeliculas2 gestiona = new GestionaPeliculas2();
		List<Pelicula2> peliculas = gestiona.listarPeliculas("peliculas.xml");

		if (peliculas.isEmpty()) {
			logger.info("No se encontraron películas en el fichero.");
		} else {
			for (int i = 0; i < peliculas.size(); i++) {
				Pelicula2 p = peliculas.get(i);
				int anio = (p.getFecha() != null) ? p.getFecha().getYear() : 0;
				logger.info("Título: " + p.getTitulo()
						+ " | Duración: " + p.getDuracion()
						+ " | Género: " + p.getGenero()
						+ " | Año: " + anio
						+ " | Director: " + p.getDirector()
						+ " | Sinopsis: " + (p.getSinopsis() != null ? p.getSinopsis() : "Sin sinopsis"));
			}

			// Ejemplo de escritura a un nuevo XML
			gestiona.guardarPeliculas("peliculas_salida.xml", peliculas);
		}
	}
}