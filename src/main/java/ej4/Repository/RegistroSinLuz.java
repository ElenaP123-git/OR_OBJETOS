package ej4.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import ej4.Exceptions.EldenException;
import ej4.Model.Encuentro;
import ej4.Model.SinLuz;

public class RegistroSinLuz {

	//ATRIBUTOS
    private Set<SinLuz> registro;

    //CONSTRUCTOR
    public RegistroSinLuz() {
       this.registro = new TreeSet<>();
    }

    //MÉTODOS
    public boolean agregaSinLuz(SinLuz sinLuz) {
        boolean insertado = false;
        if (sinLuz != null) {
            insertado = registro.add(sinLuz);
        }
        return insertado;
    }

    
    public SinLuz getSinLuz(int identificador) throws EldenException {
        SinLuz encontrado = null;

        for (SinLuz s : registro) {
            if (encontrado == null && s.getIdentificador() == identificador) {
                encontrado = s;
            }
        }

        if (encontrado == null) {
            throw new EldenException("No existe el SinLuz con el id:" + identificador);
        }

        return encontrado;
    }

    public void agregaEncuentro(int idSinLuz, Encuentro encuentro) throws EldenException {
        SinLuz personaje = getSinLuz(idSinLuz); 
        personaje.agregaOActualizaEncuentro(encuentro);
    }

 
    public List<SinLuz> getSinLuzConDificultadMayorQue(int dificultad) {
        List<SinLuz> resultado = new ArrayList<>();

        for (SinLuz s : registro) {
            boolean tieneEncuentroDificil = false;
            
            for (Encuentro e : s.getEncuentros()) {
                if (e.getDificultad() > dificultad) {
                    tieneEncuentroDificil = true;
                }
            }

            if (tieneEncuentroDificil) {
                resultado.add(s);
            }
        }

        return resultado;
    }

    public Set<SinLuz> getRegistro() {
        Set<SinLuz> copia = new TreeSet<>(registro);
        return copia;
    }
}
