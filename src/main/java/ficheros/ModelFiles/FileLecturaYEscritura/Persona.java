package ficheros.ModelFiles.FileLecturaYEscritura;

import java.util.List;

public class Persona {
	private String nombre;
	private List<Double> listaNotas;
	
	public Persona(String nombre, List<Double> listaNotas) {
		super();
		this.nombre = nombre;
		this.listaNotas = listaNotas;
	}
	
	
	public String getNombre() {
		return nombre;
	}

	public List<Double> getListaNotas() {
		return listaNotas;
	}

	public void setListaNotas(List<Double> listaNotas) {
		this.listaNotas = listaNotas;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	
}
