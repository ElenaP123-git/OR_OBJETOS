package ficheros.XML.Empleados.Repositorio;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

import ficheros.XML.Empleados.Modelo.Empleado;
import ficheros.XML.Empleados.Modelo.Puesto;

public class EmpleadoRepo implements IRepositorioEmpleados {

	// ATRIBUTOS
	private static final String RUTA_XML = "src/main/resources";
	private final File fichero;
	private List<Empleado> empleados;

	// CONSTRUCTOR
	public EmpleadoRepo(String nombreFichero) {
		this.fichero = new File(RUTA_XML, nombreFichero);
		this.empleados = new ArrayList<>();
	}

	// GETTERS Y SETTERS
	@Override
	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	public static String getRutaXml() {
		return RUTA_XML;
	}

	public File getNombreFichero() {
		return fichero;
	}

	// MÉTODOS DEL REPOSITORIO

	@Override
	public List<Empleado> findAll() throws EmpleadoException {
		List<Empleado> todos = leerFichero();
		return todos;
	}

	@Override
	public Empleado findById(String id) throws EmpleadoException {
		Empleado encontrado = null;
		List<Empleado> lista = leerFichero();

		if (id != null) {
			for (int i = 0; i < lista.size(); i++) {
				Empleado actual = lista.get(i);
				if (encontrado == null && id.equals(actual.getId())) {
					encontrado = actual;
				}
			}
		}

		return encontrado;
	}

	@Override
	public boolean existsById(String id) throws EmpleadoException {
		Empleado emp = findById(id);
		boolean existe = (emp != null);
		return existe;
	}

	@Override
	public int count() throws EmpleadoException {
		List<Empleado> lista = leerFichero();
		int total = lista.size();
		return total;
	}

	@Override
	public void save(Empleado empleado) throws EmpleadoException {
		if (empleado == null) {
			throw new EmpleadoException("No se puede guardar un empleado nulo.");
		}

		List<Empleado> lista = leerFichero();
		int posicion = -1;

		for (int i = 0; i < lista.size(); i++) {
			Empleado actual = lista.get(i);
			if (empleado.getId() != null && empleado.getId().equals(actual.getId())) {
				posicion = i;
			}
		}

		if (posicion == -1) {
			lista.add(empleado);
		} else {
			lista.set(posicion, empleado);
		}

		escribeFichero(lista);
	}

	@Override
	public boolean deleteById(String id) throws EmpleadoException {
		boolean borrado = false;
		List<Empleado> lista = leerFichero();
		List<Empleado> copiaSinBorrado = new ArrayList<>();

		for (int i = 0; i < lista.size(); i++) {
			Empleado actual = lista.get(i);
			if (id != null && id.equals(actual.getId())) {
				borrado = true;
			} else {
				copiaSinBorrado.add(actual);
			}
		}

		if (borrado) {
			escribeFichero(copiaSinBorrado);
		}

		return borrado;
	}

	// ESCRITURA XML

	private Element creaElemento(String nombreElemento, String valorElemento, Element padre, Document documento) {
		Element elemento = documento.createElement(nombreElemento);
		padre.appendChild(elemento);

		if (valorElemento != null) {
			Text texto = documento.createTextNode(valorElemento);
			elemento.appendChild(texto);
		}

		return elemento;
	}

	@Override
	public void escribeFichero(List<Empleado> lista) throws EmpleadoException {
		if (lista == null) {
			throw new EmpleadoException("La lista de empleados para escribir no puede ser nula.");
		}

		try {
			// Crea la factoría para configurar y obtener el constructor de documentos DOM
			DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
			// Crea el DocumentBuilder que construirá la estructura DOM en memoria
			DocumentBuilder builder = factoria.newDocumentBuilder();
			// Obtiene la implementación DOM del builder para crear un documento nuevo
			DOMImplementation implementacion = builder.getDOMImplementation();
			// Crea el Document vacío con etiqueta raíz "empleados" (sin URI ni DTD)
			Document documento = implementacion.createDocument(null, "empleados", null);
			// Obtiene y guarda el elemento raíz (<empleados>) del documento creado
			Element raiz = documento.getDocumentElement();

			for (int i = 0; i < lista.size(); i++) {
				Empleado e = lista.get(i);

				Element elemEmpleado = creaElemento("empleado", null, raiz, documento);
				if (e.getId() != null) {
					elemEmpleado.setAttribute("id", e.getId());
				}

				creaElemento("nombreApellidos", e.getNombreApellidos(), elemEmpleado, documento);
				creaElemento("edad", Integer.toString(e.getEdad()), elemEmpleado, documento);
				creaElemento("empresa", e.getEmpresa(), elemEmpleado, documento);

				if (e.getPuesto() != null) {
					Puesto p = e.getPuesto();
					Element elemPuesto = creaElemento("puesto", null, elemEmpleado, documento);
					if (p.getId() != null) {
						elemPuesto.setAttribute("id", p.getId());
					}
					creaElemento("nombrePuesto", p.getNombre(), elemPuesto, documento);
					creaElemento("departamento", p.getDepartamento(), elemPuesto, documento);
					creaElemento("salario", Double.toString(p.getSalario()), elemPuesto, documento);
				}
			}

			// Crea la factoría de transformadores XSLT/XML para volcar el árbol DOM
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			// Crea el objeto Transformer encargado de serializar el DOM a salida
			Transformer transformer = transformerFactory.newTransformer();
			// Envuelve el árbol DOM en memoria como fuente de origen para la transformación
			DOMSource source = new DOMSource(documento);
			// Define el fichero destino donde se escribirá el XML resultante
			StreamResult resultado = new StreamResult(fichero);
			// Ejecuta la transformación y escribe el contenido del DOM en el fichero XML
			transformer.transform(source, resultado);

			this.empleados = new ArrayList<>(lista);
		} catch (ParserConfigurationException e) {
			throw new EmpleadoException("Error de configuración del parser DOM al escribir el XML.", e);
		} catch (TransformerException e) {
			throw new EmpleadoException("Error al transformar y escribir el fichero XML.", e);
		}
	}

	// LECTURA XML

	private String obtenerTexto(Element padre, String etiqueta) {
		String valorTexto = "Sin dato";
		NodeList lista = padre.getElementsByTagName(etiqueta);

		if (lista.getLength() > 0 && lista.item(0) != null) {
			String leido = lista.item(0).getTextContent().trim();
			if (!leido.isEmpty()) {
				valorTexto = leido;
			}
		}

		return valorTexto;
	}

	private Empleado fromElement2Empleado(Element elem) throws EmpleadoException {
		try {
			String id = elem.getAttribute("id");
			String nombreApellidos = obtenerTexto(elem, "nombreApellidos");

			int edad = 0;
			String edadStr = obtenerTexto(elem, "edad");
			if (!edadStr.equals("Sin dato")) {
				edad = Integer.parseInt(edadStr);
			}

			String empresa = obtenerTexto(elem, "empresa");

			String idPuesto = "Sin id";
			String nombrePuesto = "Sin puesto";
			String departamento = "Sin departamento";
			double salario = 0.0;

			NodeList nodosPuesto = elem.getElementsByTagName("puesto");
			if (nodosPuesto.getLength() > 0) {
				Element elemPuesto = (Element) nodosPuesto.item(0);
				String attrIdPuesto = elemPuesto.getAttribute("id");
				if (!attrIdPuesto.isEmpty()) {
					idPuesto = attrIdPuesto;
				}
				nombrePuesto = obtenerTexto(elemPuesto, "nombrePuesto");
				departamento = obtenerTexto(elemPuesto, "departamento");

				String salarioStr = obtenerTexto(elemPuesto, "salario");
				if (!salarioStr.equals("Sin dato")) {
					salario = Double.parseDouble(salarioStr);
				}
			}

			Puesto puesto = new Puesto(nombrePuesto, salario);
			puesto.setId(idPuesto);
			puesto.setDepartamento(departamento);

			Empleado empleado = new Empleado(nombreApellidos, empresa, puesto);
			empleado.setId(id);
			empleado.setEdad(edad);

			return empleado;
		} catch (NumberFormatException e) {
			throw new EmpleadoException("Formato numérico no válido en los datos del empleado o puesto.", e);
		}
	}

	@Override
	public List<Empleado> leerFichero() throws EmpleadoException {
		List<Empleado> lista = new ArrayList<>();

		try {
			// Crea la factoría para instanciar el analizador DOM
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			// Crea el lector/analizador DOM a partir de la factoría
			DocumentBuilder builder = factory.newDocumentBuilder();
			// Parsea el fichero XML y construye en memoria el objeto Document
			Document doc = builder.parse(fichero);
			// Normaliza el elemento raíz para limpiar/unificar nodos de texto adyacentes
			doc.getDocumentElement().normalize();

			// Obtiene una NodeList con todos los elementos que tengan la etiqueta "empleado"
			NodeList nodosEmpleados = doc.getElementsByTagName("empleado");

			for (int i = 0; i < nodosEmpleados.getLength(); i++) {
				Element elem = (Element) nodosEmpleados.item(i);
				Empleado emp = fromElement2Empleado(elem);
				lista.add(emp);
			}

			this.empleados = lista;
			return this.empleados;
		} catch (EmpleadoException e) {
			throw e;
		} catch (Exception e) {
			throw new EmpleadoException("Error al leer el fichero XML de empleados.", e);
		}
	}
}