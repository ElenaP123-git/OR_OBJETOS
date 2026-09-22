package Colecciones.Apuntes_FINAL.RECUPERACION.EJ1.MODELO;

import java.util.Comparator;

public class ComparadorPorNombre implements Comparator<Contacto> {

    @Override
    public int compare(Contacto c1, Contacto c2) {
        return c1.getNombre().compareToIgnoreCase(c2.getNombre());
    }
}
