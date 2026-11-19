package ficheros.XML.Peliculas1;


import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GestionaPeliculas {
    private static final Logger logger = LogManager.getLogger(GestionaPeliculas.class);
    
    private final PeliculasRepo peliculasRepo;

    public GestionaPeliculas() {
        this.peliculasRepo = new PeliculasRepo();
    }

    public GestionaPeliculas(PeliculasRepo peliculasRepo) {
        this.peliculasRepo = peliculasRepo;
    }

    public List<Pelicula> listarPeliculas(String nombreFichero) {
        List<Pelicula> peliculas = peliculasRepo.obtenerPeliculasDesdeFichero(nombreFichero);
        return peliculas;
    }

    public static void main(String[] args) {
        GestionaPeliculas gestiona = new GestionaPeliculas();
        List<Pelicula> peliculas = gestiona.listarPeliculas("peliculas.xml");

        if (peliculas.isEmpty()) {
            logger.info("No se encontraron películas en el fichero.");
        } else {
            for (int i = 0; i < peliculas.size(); i++) {
                Pelicula p = peliculas.get(i);
                logger.info("Título: " + p.getTitulo() + " | Año: " + p.getFecha() + " | Director: " + p.getDirector());
            }
        }
    }
}