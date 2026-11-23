package ficheros.XML.Peliculas2;

import java.time.LocalDate;
import java.util.Objects;

public class Pelicula2 {

	// ATRIBUTOS
	private String titulo;
	private int duracion;
	private String genero;
	private String sinopsis; // Opcional en el XML
	private LocalDate fecha;
	private String director;

	// CONSTRUCTORES
	public Pelicula2() {
  	}

	public Pelicula2(String titulo, int duracion, String genero, String sinopsis, LocalDate fecha, String director) {
		this.titulo = titulo;
		this.duracion = duracion;
		this.genero = genero;
		this.sinopsis = sinopsis;
		this.fecha = fecha;
		this.director = director;
	}

	// GETTERS Y SETTERS
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	// EQUALS Y HASHCODE
	@Override
	public int hashCode() {
		return Objects.hash(director, duracion, fecha, genero, sinopsis, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Pelicula2 other = (Pelicula2) obj;
		return duracion == other.duracion
				&& Objects.equals(director, other.director)
				&& Objects.equals(fecha, other.fecha)
				&& Objects.equals(genero, other.genero)
				&& Objects.equals(sinopsis, other.sinopsis)
				&& Objects.equals(titulo, other.titulo);
	}

	// TOSTRING
	@Override
	public String toString() {
		int anio = (fecha != null) ? fecha.getYear() : 0;
		return "Pelicula2 [titulo=" + titulo + ", duracion=" + duracion + ", genero=" + genero
				+ ", año=" + anio + ", director=" + director
				+ ", sinopsis=" + (sinopsis != null ? sinopsis : "Sin sinopsis") + "]";
	}
}