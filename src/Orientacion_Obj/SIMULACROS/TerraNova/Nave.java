package Orientacion_Obj.SIMULACROS.TerraNova;

import java.util.Objects;

public class Nave {
    //atributos

    private String id;
    private String modelo;
    private int horas_vuelo;

    //constructor

    public Nave(String id, String modelo, int horas_vuelo) {
        this.id = id;
        this.modelo = modelo;
        this.horas_vuelo = horas_vuelo;
    }

    //getters y setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getHoras_vuelo() {
        return horas_vuelo;
    }

    public void setHoras_vuelo(int horas_vuelo) {
        this.horas_vuelo = horas_vuelo;
    }

    //equals

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Nave nave)) return false;
        return Objects.equals(id, nave.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    //toString

    @Override
    public String toString() {
        return "Nave{" +
                "id='" + id + '\'' +
                ", modelo='" + modelo + '\'' +
                ", horas_vuelo=" + horas_vuelo +
                '}';
    }
}
