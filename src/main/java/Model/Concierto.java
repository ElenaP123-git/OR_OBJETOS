package Model;

import java.time.LocalDate;

import Exceptions.CraftersException;

public class Concierto extends Evento{
	
	//ATRIBUTOS
	private String nombreArtista;
	private String[] artistas;
	
	//CONSTRUCTOR
	public Concierto(String nombre, LocalDate fecha, int num_entradas, int asist_max, EstadoEvent estado,
			String nombreArtista, String[] artistas) throws CraftersException {
		super(nombre, fecha, num_entradas, asist_max, estado);
		this.nombreArtista = nombreArtista;
		this.artistas = artistas;
	}

	//MÉTODOS
	@Override
	public double calcularCosteBase() {
		// TODO Auto-generated method stub
		return 0;
	}

}
