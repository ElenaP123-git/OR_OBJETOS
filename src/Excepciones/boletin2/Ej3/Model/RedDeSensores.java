package Excepciones.boletin2.Ej3.Model;

import Excepciones.boletin2.Ej3.Exceptions.FalloCriticoException;
import Excepciones.boletin2.Ej3.Exceptions.SensorException;

public class RedDeSensores {

    //atributos
    private Sensor[] sensores;
    private int numSensores;

    //constructor
    public RedDeSensores() {
        this.sensores = new Sensor[50];
    }

    //métodos
    public boolean addSensore(Sensor s) {
        for (Sensor se : sensores) {
            if (se != null) {
                se = s;
                numSensores++;
                return true;
            } else {
                return false;
            }
        }
    }
}
