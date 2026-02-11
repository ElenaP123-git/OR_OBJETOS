package Orientacion_Obj.BoletinHERNCIAS.Vehiculos;

public class Automovil extends Vehiculo {

    // atributos
    private int num_puertas;
    private String tipo_gasolina;
    private boolean tiene_aire_acondc;

    //constructor

    public Automovil(String marca, String modelo, int velocidad_max, int peso, int num_ruedas, String tipo, int num_puertas, String tipo_gasolina, boolean tiene_aire_acondc) {
        super(marca, modelo, velocidad_max, peso, num_ruedas, tipo);
        this.num_puertas = num_puertas;
        this.tipo_gasolina = tipo_gasolina;
        this.tiene_aire_acondc = tiene_aire_acondc;
    }
}
