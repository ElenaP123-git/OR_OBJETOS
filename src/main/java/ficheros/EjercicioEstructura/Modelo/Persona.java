package ficheros.EjercicioEstructura.Modelo;

import java.util.List;

public class Persona {
	
	//ATRIBUTOS
	String nombre;
	List<Double> notas;
	
	//CONSTRUCTOR
	public Persona(String nombre, List<Double> notas) {
		super();
		this.nombre = nombre;
		this.notas = notas;
	}

	//GETTERS
	public String getNombre() {
		return nombre;
	}


	public List<Double> getNotas() {
		return notas;
	}

	//TOSTRING
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", notas=" + notas + "]";
	}


	
}
