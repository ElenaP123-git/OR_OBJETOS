package Orientacion_Obj.SIMULACROS_IA.RolesClase;

import java.time.LocalDate;

public class Seminario extends Actividad {

    //constructor super
    public Seminario(String titulo, LocalDate fecha, int horas) {
        super(titulo, fecha, horas);
    }

    // metodos herencia
    @Override
    public double calcularCoste() {
        double coste = getHoras() * 20;
        return coste;
    }
}
