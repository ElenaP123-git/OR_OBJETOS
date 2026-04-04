package Colecciones.Apuntes_IA.Comparaciones;

import java.util.Comparator;

public class ComparadorPorEdad implements Comparator<Persona> {

    @Override
    public int compare(Persona p1, Persona p2) { // Orden ascendente por edad
        return Integer.compare(p1.getEdad(), p2.getEdad()); //siempre es int pq devuelve negativo si la edad es menor, 0 si igual y positivo si mayor
    }                                                       //compara las edades de cada persona

     /*
    COMPARAR VARIOS ATRIBUTOS CON CONDICIONES (forma clásica)

    @Override
    public int compare(Persona p1, Persona p2) {
        int resultado = Integer.compare(p1.getEdad(), p2.getEdad());
        if (resultado != 0) {
            return resultado; // si la edad es distinta, ya está ordenado
        }
        return p1.getNombre().compareTo(p2.getNombre()); // si empatan, ordenar por nombre
    }


    COMPARAR VARIOS ATRIBUTOS SIN CONDICIONES (forma moderna)

    @Override
    public int compare(Persona p1, Persona p2) {
        return Comparator
                .comparing(Persona::getEdad)      // 1º criterio
                .thenComparing(Persona::getNombre) // 2º criterio
                .thenComparing(Persona::getDni)    // 3º criterio
                .compare(p1, p2);
    }


    CREAR UN COMPARATOR SIN CONDICIONES (para usarlo fuera)

    Comparator<Persona> comp =
        Comparator.comparing(Persona::getEdad)
                  .thenComparing(Persona::getNombre)
                  .thenComparing(Persona::getDni);


    ORDEN DESCENDENTE SIN CONDICIONES

    Comparator<Persona> comp =
        Comparator.comparing(Persona::getEdad, Comparator.reverseOrder())
                  .thenComparing(Persona::getNombre);
    */
}

