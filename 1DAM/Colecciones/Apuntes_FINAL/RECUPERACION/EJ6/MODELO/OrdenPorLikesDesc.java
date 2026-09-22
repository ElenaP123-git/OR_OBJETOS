package Colecciones.Apuntes_FINAL.RECUPERACION.EJ6.MODELO;

import java.util.Comparator;

public class OrdenPorLikesDesc implements Comparator<Publicacion> {
    @Override
    public int compare(Publicacion p1, Publicacion p2) {
        return Integer.compare(p2.getLikes(), p1.getLikes()); //descendente
    }
}
