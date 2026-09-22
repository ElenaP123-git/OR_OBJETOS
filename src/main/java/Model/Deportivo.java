package Model;

import java.time.LocalDate;

import Exceptions.CraftersException;

public class Deportivo extends Evento{

	//ATRIBUTOS
	private boolean televisado;

	//CONSTRUCTOR
	public Deportivo(String nombre, LocalDate fecha, int num_entradas, int asist_max, EstadoEvent estado,
			boolean televisado) throws CraftersException {
		super(nombre, fecha, num_entradas, asist_max, estado);
		this.televisado = televisado;
	}

	//MÉTODOS
	@Override
	public double calcularCosteBase() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
