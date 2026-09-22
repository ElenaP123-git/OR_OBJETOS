package Colecciones.Ejercicios_IA.Collections;

public class Tortuga extends Animal {
    public Tortuga(String nombre, int edad, double peso, TipoSangre tipe_blood) {
        super(nombre, edad, peso, tipe_blood);
    }

    @Override
    public String emitirSonido() {
        return "Ahhs";
    }


}
