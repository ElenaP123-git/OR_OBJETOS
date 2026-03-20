package Colecciones.Boletin2.Ej1;

import java.util.Comparator;

public class ComparadorNombreFecha implements Comparator<Animal> {

    @Override
    public int compare(Animal a1, Animal a2) {

        // Primero por nombre
        int comp = a1.getNombre().compareToIgnoreCase(a2.getNombre());

        // Si el nombre es igual, ordenar por fecha de nacimiento
        if (comp == 0) {
            return a1.getFechaNacimiento().compareTo(a2.getFechaNacimiento());
        }

        return comp;
    }
}

