package Orientacion_Obj.BoletinFinal.Boletin9.Ej1;

public class Loro extends Mascota {

    private String origen;
    private boolean habla;

    public Loro(String nombre, int edad, double peso, String origen, boolean habla) {
        super(nombre, edad, peso);
        this.origen = origen;
        this.habla = habla;
    }

    @Override
    public boolean habla() {
        return habla;
    }
}