package ficheros.XML.Dom2;

import java.util.List;
import java.util.logging.Logger;

public class EjemploDom {
    private static final Logger logger = Logger.getLogger(EjemploDom.class.getName());
    
    public static void main(String[] args) {
        try {
            RepositorioLibroXML repo = new RepositorioLibroXML("libros.xml");
            
            // Pedimos que nos devuelva todos los libros mapeados
            List<Libro> libros = repo.obtenerTodosLosLibros();
            
            // Recorremos e imprimimos la lista con el Logger
            int i = 0;
            while (i < libros.size()) {
                Libro l = libros.get(i);
                logger.info("Leído correctamente -> " + l.toString());
                i++;
            }

        } catch (Exception e) {
            logger.severe("Error en la ejecución del main: " + e.getMessage());
        }
    }
}