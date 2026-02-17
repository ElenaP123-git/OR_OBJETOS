package Orientacion_Obj.SIMULACROS.SeguridadEmp;

import java.util.Objects;

public class Incidente {

    // atributos

    private int id;
    private String nombre;
    private String descripcion;
    private String fecha_registro;
    private String fecha_fin;
    private EstadoIncidente estado;
    private Criticidad criticidad;
    private Equipo equipo;

    // constructor

    public Incidente(int id, String nombre, String descripcion, String fecha_registro, String fecha_fin, EstadoIncidente estado, Criticidad criticidad, Equipo equipo) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha_registro = fecha_registro;
        setFecha_fin(fecha_fin);
        this.estado = estado;
        this.criticidad = criticidad;
        this.equipo = equipo;
    }

    // Getter setters

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public String getDescripcion() {return descripcion;}
    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}
    public String getFecha_registro() {return fecha_registro;}
    public void setFecha_registro(String fecha_registro) {this.fecha_registro = fecha_registro;}
    public String getFecha_fin() {return fecha_fin;}

    public void setFecha_fin(String fecha_fin) {
        if(!estado.equals("CERRADO")){
            this.fecha_fin = null;
        }
    }

    public EstadoIncidente getEstado() {return estado;}
    public void setEstado(EstadoIncidente estado) {this.estado = estado;}
    public Criticidad getCriticidad() {return criticidad;}
    public void setCriticidad(Criticidad criticidad) {this.criticidad = criticidad;}
    public Equipo getEquipo() {return equipo;}
    public void setEquipo(Equipo equipo) {this.equipo = equipo;}

    // métodos

    private boolean esUrgente(Incidente i){
        if(estado.equals("CRITICA") || estado.equals("GRAVE")){
            return true;
        }
        if (estado.equals("MEDIA")){
            return true;
        }
        else{
            return false;
        }
    }

    // equals hashcode

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Incidente incidente = (Incidente) o;
        return id == incidente.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    // toString

    @Override
    public String toString() {
        return "Incidente{" +
                  nombre +
                " - " + estado +
                ": " + criticidad +
                " - " + fecha_registro +
                " - " + equipo +
                '}';
    }
}
