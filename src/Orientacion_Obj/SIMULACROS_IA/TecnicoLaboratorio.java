package Orientacion_Obj.SIMULACROS_IA;

import java.time.LocalDate;

public class TecnicoLaboratorio extends Persona implements Tecnico{

    //constructor super
    public TecnicoLaboratorio(String nombre, String id, LocalDate fecha) {
        super(nombre, id, fecha);
    }

    //metodo implementado
    @Override
    public void repararEquipos() {
        System.out.println("Estoy reparando equipos");
    }
}
