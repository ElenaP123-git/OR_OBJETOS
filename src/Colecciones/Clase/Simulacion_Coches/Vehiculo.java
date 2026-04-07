package Colecciones.Clase.Simulacion_Coches;

import java.time.LocalDate;
import java.util.Objects;
import java.util.*;
public class Vehiculo implements Comparable<Vehiculo>{

    //atributos
    private String VIN;
    private String matricula;
    private String marca;
    private String modelo;
    private LocalDate año_fab;
    private String propietario;
    private List<Rematriculacion> rematriculacionList;

    //constructor

    public Vehiculo(String propietario, LocalDate año_fab, String modelo, String marca, String matricula, String VIN) {
        this.rematriculacionList = new ArrayList<>();
        this.propietario = propietario;
        this.año_fab = año_fab;
        this.modelo = modelo;
        this.marca = marca;
        this.matricula = matricula;
        this.VIN = VIN;
    }


    //getters y setters

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public LocalDate getAño_fab() {
        return año_fab;
    }

    public void setAño_fab(LocalDate año_fab) {
        this.año_fab = año_fab;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public List<Rematriculacion> getRematriculacionList() {
        return rematriculacionList;
    }

    public void setRematriculacionList(List<Rematriculacion> rematriculacionList) {
        this.rematriculacionList = rematriculacionList;
    }

    // equals y hashcode


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Vehiculo vehiculo)) return false;
        return Objects.equals(VIN, vehiculo.VIN);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(VIN);
    }

    //toString
    @Override
    public String toString() {
        return "Vehiculo{" +
                "VIN=" + VIN +
                ", matricula='" + matricula + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", año_fab=" + año_fab +
                ", propietario='" + propietario + '\'' +
                '}';
    }

    //compareTo
    @Override
    public int compareTo(Vehiculo o) {
        return this.getMatricula().compareTo(o.getMatricula());
    }
}
