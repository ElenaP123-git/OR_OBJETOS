package Colecciones.Boletin2.Ej2;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.TreeSet;

public class Historial {

    // ATRIBUTOS
    private TreeSet<PaginaWeb> paginas;

    // CONSTRUCTOR
    public Historial() {
        paginas = new TreeSet<>(new ComparadorFecha());
    }

    // MÉTODOS
    public void agregarPagina(String url, LocalDateTime fecha) throws HistorialException {

        if (fecha.isAfter(LocalDateTime.now())) {
            throw new HistorialException("No se puede registrar una fecha futura.");
        }

        paginas.add(new PaginaWeb(url, fecha));
    }

    public TreeSet<PaginaWeb> getPaginas() {
        return paginas;
    }

    public void borrarPorUrl(String url) {

        Iterator<PaginaWeb> it = paginas.iterator();

        while (it.hasNext()) {
            PaginaWeb p = it.next();
            if (p.getUrl().equalsIgnoreCase(url)) {
                it.remove(); // borrar seguro sin ConcurrentModificationException
            }
        }
    }

}

