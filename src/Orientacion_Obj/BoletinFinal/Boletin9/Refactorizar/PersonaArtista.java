package Orientacion_Obj.BoletinFinal.Boletin9.Refactorizar;

public class PersonaArtista extends Persona implements IArtista {

    public PersonaArtista(String nombre) {
        super(nombre);
    }

    @Override
    public void pintar() {
        System.out.println(getNombre() + " está pintando.");
    }
}

