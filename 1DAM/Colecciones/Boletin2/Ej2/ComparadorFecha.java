package Colecciones.Boletin2.Ej2;

import java.util.Comparator;

public class ComparadorFecha implements Comparator<PaginaWeb> {

    @Override
    public int compare(PaginaWeb p1, PaginaWeb p2) {
        return p1.getFecha().compareTo(p2.getFecha());
    }
}

