package Colecciones.Apuntes_FINAL.RECUPERACION.EJ2.MODELO;

import java.util.Comparator;

public class Orden_Anio implements Comparator<Pelicula> {
    @Override
    public int compare(Pelicula p1, Pelicula p2) {
        return p1.getFecha().compareTo(p2.getFecha());
    }
}
