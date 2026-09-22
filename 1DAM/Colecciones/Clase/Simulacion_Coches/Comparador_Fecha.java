package Colecciones.Clase.Simulacion_Coches;

import java.time.LocalDate;
import java.util.Comparator;

public class Comparador_Fecha implements Comparator<Vehiculo> {

    @Override
    public int compare(Vehiculo o1, Vehiculo o2) {
        return o1.getAño_fab().compareTo(o2.getAño_fab());
    }
}
