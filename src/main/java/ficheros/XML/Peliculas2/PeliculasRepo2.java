package ficheros.XML.Peliculas2;

import java.util.ArrayList;
import java.util.List;

public class PeliculasRepo2 {

	// ATRIBUTOS
	private final XMLDomPeliculas2 xmlDomPeliculas;

	// CONSTRUCTOR
	public PeliculasRepo2() {
		this.xmlDomPeliculas = new XMLDomPeliculas2();
	}

	public PeliculasRepo2(XMLDomPeliculas2 xmlDomPeliculas) {
		this.xmlDomPeliculas = xmlDomPeliculas;
	}

	// MÉTODOS
	public List<Pelicula2> obtenerPeliculasDesdeFichero(String nombreFichero) {
		List<Pelicula2> resultado = new ArrayList<>();
		if (nombreFichero != null) {
			resultado = xmlDomPeliculas.cargarPeliculas(nombreFichero);
		}
		return resultado;
	}

	public void guardarPeliculasEnFichero(String nombreFichero, List<Pelicula2> peliculas) {
		if (nombreFichero != null && peliculas != null) {
			xmlDomPeliculas.escribirPeliculasEnXML(nombreFichero, peliculas);
		}
	}
}