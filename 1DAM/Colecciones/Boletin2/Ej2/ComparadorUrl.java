package Colecciones.Boletin2.Ej2;

import java.util.Comparator;

public class ComparadorUrl implements Comparator<PaginaWeb> {

    @Override
    public int compare(PaginaWeb p1, PaginaWeb p2) {
        int comp = p1.getUrl().compareToIgnoreCase(p2.getUrl());
        if (comp == 0) {
            return p1.getFecha().compareTo(p2.getFecha());
        }
        return comp;
    }
}

