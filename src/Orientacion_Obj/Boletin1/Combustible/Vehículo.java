package Orientacion_Obj.Boletin1.Combustible;

public class Vehículo {
    // atributos

    String marca;
    String modelo;
    int año_fabricacion;
    String tipo_combustible;
    double capacidad_tanque;

    // constructor

    public Vehículo(String marca, String modelo, int año_fabricacion, String tipo_combustible, double capacidad_tanque) {
        this.marca = marca;
        this.modelo = modelo;
        this.año_fabricacion = año_fabricacion;
        this.tipo_combustible = tipo_combustible;
        this.capacidad_tanque = capacidad_tanque;
    }

    // métodos

    public void calculo_consumo_combustible(int kilometros_recorridos){
        int litros = 0;

    }
}
