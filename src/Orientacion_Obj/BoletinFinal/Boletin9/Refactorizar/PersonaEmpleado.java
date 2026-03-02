package Orientacion_Obj.BoletinFinal.Boletin9.Refactorizar;

public class PersonaEmpleado extends Persona implements IEmpleado {

    public PersonaEmpleado(String nombre) {
        super(nombre);
    }

    @Override
    public void trabajar() {
        System.out.println(getNombre() + " está trabajando.");
    }
}

