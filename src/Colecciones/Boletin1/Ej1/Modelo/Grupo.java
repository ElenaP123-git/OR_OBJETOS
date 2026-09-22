package Colecciones.Boletin1.Ej1.Modelo;

import Colecciones.Boletin1.Ej1.Exceptions.EstudianteNoEncontradoException;
import Colecciones.Boletin1.Ej1.Exceptions.GrupoNoEncontradoException;

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

    public double calculcarPromedioEstudiante(String id) throws EstudianteNoEncontradoException {
        double resultado = 0;
        Estudiante e = buscarEstudiante(id);
        if (e == null){
            throw new EstudianteNoEncontradoException("No existe un estudiante con ID: " + id);
        }
        resultado = e.calcularPromedio();
        return resultado;
    }

    public void agregarEstudiante(Estudiante e) {
        estudiantes.add(e);
    }

    public Estudiante buscarEstudiante(String id) throws EstudianteNoEncontradoException {
        boolean encontrado = false;
        int i = 0;
        Estudiante e = null;

        do{
            if(estudiantes.get(i).getId().equalsIgnoreCase(id)){ //el get(i) es igual que lista[i], te da el id de cada estudiante
                encontrado = true;
                e = estudiantes.get(i);
            }
            else{
                i++;
            }
        } while (!encontrado &&  i < this.estudiantes.size());

        return e;
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

    public void muestraListEstyGrupos(){
        for(int i = 0; i < estudiantes.size();i++){
            System.out.println(this.descripcion + " - " + estudiantes.get(i).toString());
        }
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

