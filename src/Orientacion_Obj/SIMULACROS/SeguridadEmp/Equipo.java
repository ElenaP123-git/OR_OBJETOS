package Orientacion_Obj.SIMULACROS.SeguridadEmp;

public class Equipo {

    // atributos

    private String nombre;
    private String direccion;
    private String sist_op;
    private int num_incidentes;

    // constructor

    public Equipo(String nombre, String direccion, String sist_op) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.sist_op = sist_op;
        this.num_incidentes = 0;
    }

    // métodos

    // getters setters

    public String getNombre() {return nombre;}
    public String getDireccion() {return direccion;}
    public String getSist_op() {return sist_op;}
    public int getNum_incidentes() {return num_incidentes;}

    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setDireccion(String direccion) {this.direccion = direccion;}
    public void setSist_op(String sist_op) {this.sist_op = sist_op;}
    public void setNum_incidentes(int num_incidentes) {this.num_incidentes = num_incidentes;}

    // toString

    @Override
    public String toString() {
        return "Equipo{" +
                 nombre +
                " - " + sist_op +
                " : " + num_incidentes +
                '}';
    }
}
