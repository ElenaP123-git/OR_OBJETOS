package Orientacion_Obj.BoletinHERNCIAS.Vehiculos;

public class Camion extends Vehiculo{

    //atributos
    private double long_remolque;
    private String tipo_camion;
    private double altura;

    //constructor


    public Camion(String marca, String modelo, int velocidad_max, int peso, int num_ruedas, String tipo, double long_remolque, String tipo_camion, double altura) {
        super(marca, modelo, velocidad_max, peso, num_ruedas, tipo);
        this.long_remolque = long_remolque;
        this.tipo_camion = tipo_camion;
        this.altura = altura;
    }
}
