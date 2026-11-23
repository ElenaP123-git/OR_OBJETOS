package ficheros.XML.Empleados.Repositorio;

import java.util.List;

import ficheros.XML.Empleados.Modelo.Empleado;

public interface IRepositorioEmpleados {
	
	//MÉTODOS
	List<Empleado> findAll() throws EmpleadoException;
	Empleado findById(String id) throws EmpleadoException;
	boolean existsById(String id) throws EmpleadoException;
	int count() throws EmpleadoException;
	void save(Empleado empleado) throws EmpleadoException;
	boolean deleteById(String id) throws EmpleadoException;
	List<Empleado> getEmpleados();
	List<Empleado> leerFichero() throws EmpleadoException;
	void escribeFichero(List<Empleado> lista) throws EmpleadoException;
}