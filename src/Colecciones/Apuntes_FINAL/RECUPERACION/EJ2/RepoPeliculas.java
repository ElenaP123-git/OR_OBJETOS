package Colecciones.Apuntes_FINAL.RECUPERACION.EJ2;

import java.time.LocalDate;
import java.util.HashSet;

public class RepoPeliculas {

    //atributos
    HashSet<Pelicula> peliculas;

    //constructor
    public RepoPeliculas(HashSet<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }

    //métodos

    public boolean añadirPelicula(String peli) throws AnioInvalidoException, PeliculaDuplicadaException{
        boolean encontrado = false;
        for (Pelicula p: peliculas){
            if(p.getFecha().isBefore(LocalDate.of(1888,12,31)) || p.getFecha().isAfter(LocalDate.now())){
                throw new AnioInvalidoException("Año introducido inválido");
            }
            else{
                if(p.getTitulo().equalsIgnoreCase(peli) && p.getDirector().equalsIgnoreCase(peli)){
                    throw new PeliculaDuplicadaException("Película ya registrada");
                }
                else{
                    encontrado = true;
                }
            }
        }
        return encontrado;
    }

    public boolean alquilar_por_id(int id) throws PeliculaNoDisponibleException, PeliculaNoEncontradaException{
        boolean alquilado = false;
        for(Pelicula p : peliculas){
            if(p.getId() == id){
                if(!p.isDisponible()){
                    throw new PeliculaNoDisponibleException("Película no disponible");
                }
                p.setDisponible(false);
                alquilado = true;
            }
            else{
                throw new PeliculaNoEncontradaException("Pelíucula no encontrada");
            }

        }
        return alquilado;
    }

}
