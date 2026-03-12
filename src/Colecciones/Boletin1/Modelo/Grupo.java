package Colecciones.Boletin1.Modelo;

import Colecciones.Boletin1.Exceptions.EstudianteNoEncontradoException;
import Colecciones.Boletin1.Exceptions.GrupoNoEncontradoException;

import java.util.ArrayList;
import java.util.List;

public class Grupo {


    // ATRIBUTOS

    private String descripcion;
    private String tutor;
    private String aula;
    private Horario horario;
    private List<Estudiante> estudiantes;


    // CONSTRUCTOR

    public Grupo(String descripcion, String tutor, String aula) {
        this.descripcion = descripcion;
        this.tutor = tutor;
        this.aula = aula;
        this.horario = new Horario();
        this.estudiantes = new ArrayList<>();
    }


    // MÉTODOS

    public void agregarEstudiante(Estudiante e) {
        estudiantes.add(e);
    }

    public Estudiante buscarEstudiante(String id) throws EstudianteNoEncontradoException {
        for (Estudiante e : estudiantes) {
            if (e.getId().equalsIgnoreCase(id))
                return e;
        }
        throw new EstudianteNoEncontradoException("No existe un estudiante con ID: " + id);
    }

    public double promedioGrupo() throws GrupoNoEncontradoException {
        double suma = 0;
        int contador = 0;

        for (Estudiante e : estudiantes) {
            for (double nota : e.getNotas()) {
                suma += nota;
                contador++;
            }
        }

        if (contador == 0) {
            throw new GrupoNoEncontradoException("No hay notas registradas en el grupo.");
        }

        return suma / contador;
    }


    // GETTERS Y SETTERS


    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public String getTutor() {
        return tutor;
    }
    public int getNumEstudiantes() {
        return estudiantes.size();
    }
    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }


    // TOSTRING

    @Override
    public String toString() {
        return "Grupo: " + descripcion + " | Tutor: " + tutor + " | Estudiantes: " + estudiantes.size();
    }
}

