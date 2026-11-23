package ficheros.XML.Empleados.Servicio;

import java.util.List;

import ficheros.XML.Empleados.Modelo.Empleado;

public interface IServicioEmpleados {
	
	//MÉTODOS
	List<Empleado> listarEmpleados();
	Empleado buscarPorId(String id);
	boolean guardarListaEmpleados(List<Empleado> empleados);
	boolean guardarEmpleado(Empleado empleado);
	boolean eliminarPorId(String id);
	int contarEmpleados();
}