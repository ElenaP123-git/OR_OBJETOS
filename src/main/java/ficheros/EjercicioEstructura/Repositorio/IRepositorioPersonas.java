package ficheros.EjercicioEstructura.Repositorio;


import java.util.List;

import ficheros.EjercicioEstructura.Modelo.Persona;

public interface IRepositorioPersonas {
	List<Persona> findAll() throws RepositorioException;
	
}
