package Orientacion_Obj.BoletinFinal.Boletin9.Ej1;

public class Gato extends Mascota {

    private String color;

    public Gato(String nombre, int edad, double peso, String color) {
        super(nombre, edad, peso);
        this.color = color;
    }

    @Override
    public boolean habla() {
        return false;
    }
}
