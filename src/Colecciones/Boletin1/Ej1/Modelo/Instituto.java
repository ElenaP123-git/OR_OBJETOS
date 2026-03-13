package Colecciones.Boletin1.Ej1.Modelo;

import Colecciones.Boletin1.Ej1.Exceptions.GrupoNoEncontradoException;

import java.util.ArrayList;
import java.util.List;

public class Instituto {


    // ATRIBUTOS

    private List<Grupo> grupos;


    // CONSTRUCTOR

    public Instituto() {
        grupos = new ArrayList<>();
    }


    // MÉTODOS

    public void agregarGrupo(Grupo g) {
        grupos.add(g);
    }

    public Grupo buscarGrupo(String descripcion) throws GrupoNoEncontradoException {
        for (Grupo g : grupos) {
            if (g.getDescripcion().equalsIgnoreCase(descripcion))
                return g;
        }
        throw new GrupoNoEncontradoException("No existe un grupo con esa descripción.");
    }

    public void muestroinfoEstudoGrupo(){
        for (Grupo g: grupos){
            g.muestraListEstyGrupos();
        }
    }

    // GETTERS Y SETTERS

    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
    }

    public List<Grupo> getGrupos() {
        return grupos;
    }
}

