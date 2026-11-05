package ficheros.Bol3Libreria.Repositorio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import ficheros.Bol3Libreria.Modelo.Pais;

public class RepoPais implements IRepoPais{
	
	//ATRIBUTOS
	File fichero_entrada;
	List<Pais> paises;
	
	//CONSTRUCTOR
	public RepoPais(File fichero_entrada, List<Pais> paises) {
		super();
		this.fichero_entrada = fichero_entrada;
		this.paises = null; //no se lee el fichero hasta que se llama en un método
	}

	//MÉTODOS IMPLEMENTADOS
	
	@Override
	public List<Pais> findAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Pais pais) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean deleteById(String nombre) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	//MÉTODOS
	
	private List<Pais> lecturaCsv() throws Exception{
		List<Pais> listLeida = new ArrayList<>();
		BufferedReader lectorBuffer = null;
		
		try {
			if(fichero_entrada.exists()) {
				FileReader lectorFichero = new FileReader(fichero_entrada);
				lectorBuffer = new BufferedReader(lectorFichero);
			
				String linea = lectorBuffer.readLine(); //leemos lineas
				
				linea = lectorBuffer.readLine();  //creamos variable líneas
				
				while (linea != null) { //omitimos cabecera
					String [] partes = linea.split(",");
					
					if(partes.length >= 5) {
						String nombre = partes[0];
						String continente = partes[1];
						long poblacion = Long.parseLong(partes[2].trim());
						
						Set<String> idiomas = new HashSet<>();
						String cadenaIdiomas = partes[3].trim();
						
						if(!cadenaIdiomas.isEmpty()) {
							String[] arrayIdiomas = cadenaIdiomas.split(" ");
							for(String i: arrayIdiomas) {
								idiomas.add(i);
							}
						}
						
						String moneda = partes[4].trim();
						Pais p = new Pais(nombre, continente, poblacion, idiomas, moneda);
						
					}
					
					listaLeida.add(p);
				}
			}
		}
	}
	
	private void cargarSiHaceFalta() throws Exception{
		if (this.paises == null) {
			//this.paises = leer
		}
	}
	
}
