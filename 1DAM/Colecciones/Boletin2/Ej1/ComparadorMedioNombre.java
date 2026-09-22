package Colecciones.Boletin2.Ej1;

import java.util.Comparator;

public class ComparadorMedioNombre implements Comparator<Animal> {

    @Override
    public int compare(Animal a1, Animal a2) {

        // Primero por medio
        int comp = a1.getMedio().compareTo(a2.getMedio());

        // Si el medio es igual, ordenar por nombre
        if (comp == 0) {
            return a1.getNombre().compareToIgnoreCase(a2.getNombre());
        }

        return comp;
    }
}

