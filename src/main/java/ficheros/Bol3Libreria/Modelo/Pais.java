package ficheros.Bol3Libreria.Modelo;

import java.util.Objects;
import java.util.Set;

public class Pais {

    // ATRIBUTOS
    private String nombre;
    private String continente;
    private long poblacion;
    private Set<String> idiomas;
    private String moneda;

    // CONSTRUCTOR
    public Pais(String nombre, String continente, long poblacion, Set<String> idiomas, String moneda) {
        super();
        this.nombre = nombre;
        this.continente = continente;
        this.poblacion = poblacion;
        this.idiomas = idiomas;
        this.moneda = moneda;
    }

    // GETTERS Y SETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public long getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(long poblacion) {
        this.poblacion = poblacion;
    }

    public Set<String> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(Set<String> idiomas) {
        this.idiomas = idiomas;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    // EQUALS Y HASHCODE 
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pais pais = (Pais) o;
        return Objects.equals(nombre, pais.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    // TOSTRING
    @Override
    public String toString() {
        return "Pais [nombre=" + nombre + ", continente=" + continente + ", poblacion=" + poblacion 
                + ", idiomas=" + idiomas + ", moneda=" + moneda + "]";
    }
}