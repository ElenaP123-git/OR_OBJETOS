package Orientacion_Obj.Boletin1.Notas;

public class Alumno {
    String nombre;
    String apellidos;
    String email;
    NotaAsignatura programacion;
    NotaAsignatura baseDatos;

    // constructor
    public Alumno(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    // metodos
    public void imprimeSiHaAprobado(NotaAsignatura asignatura) {
        if (asignatura.calcularMedia() >= 5) {
            System.out.println("El alumno " + nombre + " ha aprobado la asignatura " + asignatura.asignatura);
        }
        else {
            System.out.println("El alumno " + nombre + " NO ha aprobado la asignatura " + asignatura.asignatura);
        }
    }

    @Override public String toString() {
        return "Alumno{" + "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", email='" + email + '\'' +
                ", programacion=" + programacion +
                ", baseDatos=" + baseDatos +
                '}';
    }
}
