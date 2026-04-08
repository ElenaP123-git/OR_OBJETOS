package Colecciones.Ejercicios_IA;

import java.util.Comparator;

public class Orden_Edad implements Comparator<Animal> {
    @Override
    public int compare(Animal a1, Animal a2) {
        return Integer.compare(a1.getEdad(), a2.getEdad());
    }
}
