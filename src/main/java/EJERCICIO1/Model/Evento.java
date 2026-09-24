package EJERCICIO1.Model;

import java.time.LocalDate;
import java.util.Objects;

import EJERCICIO1.Exceptions.CraftersException;

public abstract class Evento {

	//ATRIBUTOS
	private int id;
	private String nombre;  
	private LocalDate fecha;
	private int num_entradas;
	private int asist_max;
	private EstadoEvent estado;
	
	//CONSTRUCTOR
	public Evento(String nombre, LocalDate fecha, int num_entradas, int asist_max, EstadoEvent estado) throws CraftersException {
		super();
		this.id = id++;
		this.nombre = nombre;
		this.fecha = fecha;
		this.estado = estado;
		this.num_entradas = num_entradas;
		this.asist_max = asist_max;
		if (num_entradas <0 || asist_max < 0 || num_entradas > asist_max) {
			throw new CraftersException("Excepción");
		}
	
	}
	
	
	
	public Evento(int num_entradas, int asist_max) {
		super();
		this.num_entradas = num_entradas;
		this.asist_max = asist_max;
	}



	//MÉTODOS
	public void modificaEstado(EstadoEvent est) {
		
	}
	
	public void getPorcentajeOcupacion()
	{
		
	}
	
	public void getPorcentajeOcupacion(int numeroEntradas) {
		
	}
	
	public abstract double calcularCosteBase();
	
	//GETTERS Y SETTERS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public int getNum_entradas() {
		return num_entradas;
	}

	public void setNum_entradas(int num_entradas) {
		this.num_entradas = num_entradas;
	}

	public int getAsist_max() {
		return asist_max;
	}

	public void setAsist_max(int asist_max) {
		this.asist_max = asist_max;
	}

	//EQUALS Y HASHCODE
	@Override
	public int hashCode() {
		return Objects.hash(Integer.valueOf(id));
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Evento other = (Evento) obj;
		return id == other.id;
	}

	//TO STRING
	@Override
	public String toString() {
		return "Evento [id=" + id + ", nombre=" + nombre + ", fecha=" + fecha + ", estado=" + estado + "]";
	}
	
	
}
