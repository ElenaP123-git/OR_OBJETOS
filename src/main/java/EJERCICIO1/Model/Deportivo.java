package EJERCICIO1.Model;



import java.time.LocalDate;

import EJERCICIO1.Exceptions.CraftersException;
  


public class Deportivo extends Evento{

	//ATRIBUTOS
	private boolean televisado;

	//CONSTRUCTOR
	public Deportivo(String nombre, LocalDate fecha, int num_entradas, int asist_max, EstadoEvent estado,
			boolean televisado) throws CraftersException {
		super(nombre, fecha, num_entradas, asist_max, estado);
		this.televisado = televisado;
	}
	
	
	
	public Deportivo(int num_entradas, int asist_max) throws CraftersException {
		super(num_entradas, asist_max);
		this.televisado = televisado;
	}



	//GETTERS Y SETTERS

	public void setTelevisado(boolean televisado) {
		this.televisado = televisado;
	}


	//MÉTODOS
	@Override
	public double calcularCosteBase() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
