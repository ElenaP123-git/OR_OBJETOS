package ficheros.XML.Empleados.Servicio;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import ficheros.XML.Empleados.Modelo.Empleado;
import ficheros.XML.Empleados.Repositorio.EmpleadoException;
import ficheros.XML.Empleados.Repositorio.EmpleadoRepo;
import ficheros.XML.Empleados.Repositorio.IRepositorioEmpleados;

public class ServicioEmpleados implements IServicioEmpleados {

	// ATRIBUTOS
	private static final Logger logger = Logger.getLogger(ServicioEmpleados.class.getName());
	private final IRepositorioEmpleados repositorio;

	// CONSTRUCTOR
	public ServicioEmpleados(String nombreFichero) {
		if (nombreFichero == null || nombreFichero.trim().isEmpty()) {
			throw new IllegalArgumentException("El nombre del fichero no puede estar vacío.");
		}
		this.repositorio = new EmpleadoRepo(nombreFichero);
	}

	// MÉTODOS AUXILIARES DE ERROR
	private void datoNoValido(String mensaje) {
		logger.warning("Dato no válido: " + mensaje);
	}

	private void errorPersistencia(EmpleadoException e) {
		logger.severe("Error de persistencia: " + e.getMessage());
	}

	// MÉTODOS DEL SERVICIO

	@Override
	public List<Empleado> listarEmpleados() {
		List<Empleado> resultado = new ArrayList<>();
		try {
			resultado = repositorio.findAll();
		} catch (EmpleadoException e) {
			errorPersistencia(e);
		}
		return resultado;
	}

	@Override
	public Empleado buscarPorId(String id) {
		Empleado resultado = null;
		if (id == null || id.trim().isEmpty()) {
			datoNoValido("El id no puede estar vacío.");
		} else {
			try {
				resultado = repositorio.findById(id);
				if (resultado == null) {
					datoNoValido("No existe ningún empleado con id: " + id);
				}
			} catch (EmpleadoException e) {
				errorPersistencia(e);
			}
		}
		return resultado;
	}

	@Override
	public boolean guardarListaEmpleados(List<Empleado> empleados) {
		boolean hecho = false;
		if (empleados == null || empleados.isEmpty()) {
			datoNoValido("La lista de empleados está vacía.");
		} else {
			try {
				repositorio.escribeFichero(empleados);
				hecho = true;
			} catch (EmpleadoException e) {
				errorPersistencia(e);
			}
		}
		return hecho;
	}

	@Override
	public boolean guardarEmpleado(Empleado empleado) {
		boolean hecho = false;
		if (empleado == null) {
			datoNoValido("El empleado no puede ser nulo.");
		} else if (empleado.getNombreApellidos() == null || empleado.getNombreApellidos().trim().isEmpty()) {
			datoNoValido("El nombre y apellidos del empleado son obligatorios.");
		} else if (empleado.getEmpresa() == null || empleado.getEmpresa().trim().isEmpty()) {
			datoNoValido("La empresa del empleado es obligatoria.");
		} else {
			try {
				repositorio.save(empleado);
				hecho = true;
			} catch (EmpleadoException e) {
				errorPersistencia(e);
			}
		}
		return hecho;
	}

	@Override
	public boolean eliminarPorId(String id) {
		boolean hecho = false;
		if (id == null || id.trim().isEmpty()) {
			datoNoValido("El id no puede estar vacío.");
		} else {
			try {
				hecho = repositorio.deleteById(id);
				if (!hecho) {
					datoNoValido("No se encontró ningún empleado con id: " + id);
				}
			} catch (EmpleadoException e) {
				errorPersistencia(e);
			}
		}
		return hecho;
	}

	@Override
	public int contarEmpleados() {
		int total = 0;
		try {
			total = repositorio.count();
		} catch (EmpleadoException e) {
			errorPersistencia(e);
		}
		return total;
	}
}
