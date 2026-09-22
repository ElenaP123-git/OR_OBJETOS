package Colecciones.EXAMEN1.repositorio;

import Colecciones.EXAMEN1.modelos.Comandante;

import java.util.Comparator;

public class Orden_nombre implements Comparator<Comandante> {

    @Override
    public int compare(Comandante o1, Comandante o2) {
        return o1.getNombre().compareTo(o2.getNombre()); //esto compara por nombre y no por casa(no es el órden natural)
    }
}
