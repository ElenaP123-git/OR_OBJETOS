package EJERCICIO1.Repository;


public class RepoEventos {  
	
	//ATRIBUTOS
	String [] listaEventos;

	//CONSTRUCTOR
	public RepoEventos() {
		super();
		this.listaEventos = new String[10]; //inicializamos lista
	}

	//GETTERS Y SETTERS
	public String[] getListaEventos() {
		return listaEventos;
	}

	public void setListaEventos(String[] listaEventos) {
		this.listaEventos = listaEventos;
	}
	
	
}

