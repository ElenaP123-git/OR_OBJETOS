package ficheros.XML.Peliculas1;

import java.util.ArrayList;
import java.util.List;

public class PeliculasRepo {
	
	//ATRIBUTOS
    private final XMLDomPeliculas xmlDomPeliculas;

    //CONSTRUCTOR
    public PeliculasRepo() {
        this.xmlDomPeliculas = new XMLDomPeliculas();
    }

    public PeliculasRepo(XMLDomPeliculas xmlDomPeliculas) {
        this.xmlDomPeliculas = xmlDomPeliculas;
    }

    //MÉTODOS
    public List<Pelicula> obtenerPeliculasDesdeFichero(String nombreFichero) {
        List<Pelicula> resultado = new ArrayList<>();
        if (nombreFichero != null) {
        	resultado = xmlDomPeliculas.cargarPeliculas(nombreFichero);
        }
        return resultado;
    }
}
