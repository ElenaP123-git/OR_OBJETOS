package Colecciones.Boletin2;

import java.util.Comparator;

public class ComparadorAnimal implements Comparator<Animal> {

    @Override
    public int compare(Animal a1, Animal a2) {
        int comp = a1.getNombre().compareToIgnoreCase(a2.getNombre());
        if (comp == 0) {
            return Integer.compare(a1.getId(), a2.getId());
        }
        return comp;
    }
}
