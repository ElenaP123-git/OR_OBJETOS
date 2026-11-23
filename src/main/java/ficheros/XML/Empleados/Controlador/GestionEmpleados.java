package ficheros.XML.Empleados.Controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import ficheros.XML.Empleados.Modelo.Empleado;
import ficheros.XML.Empleados.Modelo.Puesto;
import ficheros.XML.Empleados.Servicio.IServicioEmpleados;
import ficheros.XML.Empleados.Servicio.ServicioEmpleados;

public class GestionEmpleados {

	private static final Logger logger = Logger.getLogger(GestionEmpleados.class.getName());
	private static final String NOMBRE_FICHERO = "/empleados.xml";

	public static void main(String[] args) {
		IServicioEmpleados servicio = new ServicioEmpleados(NOMBRE_FICHERO);

		List<Empleado> listaCincoEmpleados = crearCincoEmpleados();
		boolean guardado = servicio.guardarListaEmpleados(listaCincoEmpleados);

		if (guardado) {
			logger.info("Fichero XML generado correctamente.");
		} else {
			logger.warning("No se pudo generar el fichero XML.");
		}

		List<Empleado> leidos = servicio.listarEmpleados();
		logger.info("--- Empleados leídos desde el XML ---");
		for (int i = 0; i < leidos.size(); i++) {
			Empleado emp = leidos.get(i);
			logger.info(emp.toString());
		}
	}

	private static List<Empleado> crearCincoEmpleados() {
		List<Empleado> lista = new ArrayList<>();

		Puesto p1 = new Puesto("Analista de Marketing", 35000.0);
		p1.setId("p102");
		p1.setDepartamento("Marketing");
		Empleado e1 = new Empleado("Juan Pérez", "Empresa", p1);
		e1.setId("1");
		e1.setEdad(35);

		Puesto p2 = new Puesto("Desarrollador Backend", 40000.0);
		p2.setId("p103");
		p2.setDepartamento("Tecnología");
		Empleado e2 = new Empleado("Laura Gómez", "Empresa", p2);
		e2.setId("2");
		e2.setEdad(29);

		Puesto p3 = new Puesto("Técnico de RRHH", 30000.0);
		p3.setId("p104");
		p3.setDepartamento("Recursos Humanos");
		Empleado e3 = new Empleado("Carlos Ruiz", "Empresa", p3);
		e3.setId("3");
		e3.setEdad(42);

		Puesto p4 = new Puesto("Contable", 33000.0);
		p4.setId("p105");
		p4.setDepartamento("Finanzas");
		Empleado e4 = new Empleado("Sofía Martín", "Empresa", p4);
		e4.setId("4");
		e4.setEdad(31);

		Puesto p5 = new Puesto("Jefe de Ventas", 45000.0);
		p5.setId("p106");
		p5.setDepartamento("Ventas");
		Empleado e5 = new Empleado("David López", "Empresa", p5);
		e5.setId("5");
		e5.setEdad(38);

		lista.add(e1);
		lista.add(e2);
		lista.add(e3);
		lista.add(e4);
		lista.add(e5);

		return lista;
	}
}
