package Colecciones.Boletin1.Controlador;

import Colecciones.Boletin1.Modelo.Estudiante;

import java.util.ArrayList;
import java.util.List;

public class GestionaEstudiantes {
    public static void main(String[] args) {

        Estudiante a1 = new Estudiante("Pepa", 1);
        Estudiante a2 = new Estudiante("Javi", 1);
        Estudiante a3 = new Estudiante("Jud", 3);

        List<Estudiante> estudianteList = new ArrayList<Estudiante>();

        GestionaEstudiantes g = new GestionaEstudiantes(); //para poder usar sus métodos

        g.agregaEstudiante(a1,estudianteList);
        g.agregaEstudiante(a2,estudianteList);
        g.agregaEstudiante(a3,estudianteList);

        for (Estudiante e: estudianteList){
            System.out.println(e);
        }
    }

    private boolean agregaEstudiante(Estudiante e, List<Estudiante> lista){
        boolean agregado = false;

        if(!lista.contains(e)){ // si no lo contiene (distinto id)
            lista.add(e); // lo agrega
            agregado = true;
        }
        return agregado;
    }
}
