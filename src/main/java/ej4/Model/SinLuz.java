package ej4.Model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class SinLuz implements Comparable<SinLuz> {
	
	//ATRIBUTOS
    private static int contadorId = 1;
    private int identificador;
    private String nombre;
    private Set<Encuentro> encuentros;

    //CONSTRUCTOR
    public SinLuz(String nombre) {
        this.identificador = contadorId++;
        this.nombre = nombre;
        this.encuentros = new HashSet<>();
    }

    //GETTERS Y SETTERS
    public int getIdentificador() {
        return identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Encuentro> getEncuentros() {
        Set<Encuentro> copia = new HashSet<>(encuentros);
        return copia;
    }

    public void agregaOActualizaEncuentro(Encuentro encuentro) {
        if (encuentro != null) {
            if (encuentros.contains(encuentro)) {
                encuentros.remove(encuentro);
            }
            encuentros.add(encuentro);
        }
    }

    //COMPARE TO (NOMBRE)
    @Override
    public int compareTo(SinLuz otro) {
        int resultado = 0;
        if (otro != null) {
            resultado = this.nombre.compareToIgnoreCase(otro.nombre);
        }
        return resultado;
    }

  //EQUALS Y HASHCODE
    @Override
    public boolean equals(Object obj) {
        boolean esIgual = false;
        if (this == obj) {
            esIgual = true;
        } else if (obj != null && getClass() == obj.getClass()) {
            SinLuz other = (SinLuz) obj;
            esIgual = (identificador == other.identificador);
        }
        return esIgual;
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificador);
    }

    //TOSTRING
    @Override
    public String toString() {
        return "SinLuz [ID=" + identificador + ", Nombre=" + nombre + ", Encuentros=" + encuentros + "]";
    }
}
