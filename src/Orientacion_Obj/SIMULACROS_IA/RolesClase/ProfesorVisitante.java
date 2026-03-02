package Orientacion_Obj.SIMULACROS_IA.RolesClase;

import java.time.LocalDate;

public class ProfesorVisitante extends Persona implements Profesor {

    //constructor super
    public ProfesorVisitante(String nombre, String id, LocalDate fecha) {
        super(nombre, id, fecha);
    }

    // métodos implememtados
    @Override
    public void impartirClase() {
        System.out.println("Estoy immpartiendo clase");
    }
}
