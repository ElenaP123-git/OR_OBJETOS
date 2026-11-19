package ficheros.XML.Peliculas2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

import java.time.LocalDate;

public class XMLDomPeliculas2 {

	// ATRIBUTOS
	private final String rutaResources;

	// CONSTRUCTOR
	public XMLDomPeliculas2() {
		this.rutaResources = "src/main/resources/";
	}

	public XMLDomPeliculas2(String rutaResources) {
		this.rutaResources = rutaResources;
	}

	// MÉTODOS DE LECTURA
	public Document getDocumentFromXML(String nombreFichero) {
		Document doc = null;
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			doc = builder.parse(new File(rutaResources + nombreFichero));
			doc.getDocumentElement().normalize();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return doc;
	}

	public List<Pelicula2> cargarPeliculas(String nombreFichero) {
		List<Pelicula2> peliculas = new ArrayList<>();
		Document doc = getDocumentFromXML(nombreFichero);

		if (doc != null) {
			NodeList nodos = doc.getElementsByTagName("Pelicula");
			for (int i = 0; i < nodos.getLength(); i++) {
				Node nodo = nodos.item(i);
				if (nodo.getNodeType() == Node.ELEMENT_NODE) {
					Element elem = (Element) nodo;

					String titulo = obtenerTexto(elem, "Titulo");

					int duracion = 0;
					String duracionStr = obtenerTexto(elem, "Duracion");
					if (!duracionStr.isEmpty()) {
						duracion = Integer.parseInt(duracionStr);
					}

					String genero = obtenerTexto(elem, "Genero");

					// Sinopsis opcional: si no viene o está vacía, queda null
					String sinopsis = null;
					String sinopsisStr = obtenerTexto(elem, "sinopsis");
					if (!sinopsisStr.isEmpty()) {
						sinopsis = sinopsisStr.replaceAll("\\s+", " ");
					}

					// Fecha en el XML viene como año (ej: 1999 o 0)
					LocalDate fecha = null;
					String fechaStr = obtenerTexto(elem, "Fecha");
					if (!fechaStr.isEmpty()) {
						int anio = Integer.parseInt(fechaStr);
						if (anio > 0) {
							fecha = LocalDate.of(anio, 1, 1);
						}
					}

					String director = obtenerTexto(elem, "Director").replaceAll("\\s+", " ");

					peliculas.add(new Pelicula2(titulo, duracion, genero, sinopsis, fecha, director));
				}
			}
		}

		return peliculas;
	}

	private String obtenerTexto(Element padre, String etiqueta) {
		String texto = "";
		NodeList lista = padre.getElementsByTagName(etiqueta);
		if (lista != null && lista.getLength() > 0 && lista.item(0) != null) {
			texto = lista.item(0).getTextContent().trim();
		}
		return texto;
	}

	// MÉTODOS DE ESCRITURA
	public void escribirPeliculasEnXML(String nombreFichero, List<Pelicula2> peliculas) {
		try {
			DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factoria.newDocumentBuilder();
			DOMImplementation implementacion = builder.getDOMImplementation();
			Document documento = implementacion.createDocument(null, "CatalogoPeliculas", null);
			Element raiz = documento.getDocumentElement();

			for (Pelicula2 p : peliculas) {
				Element elemPelicula = documento.createElement("Pelicula");
				raiz.appendChild(elemPelicula);

				creaElemento("Titulo", p.getTitulo(), elemPelicula, documento);
				creaElemento("Duracion", Integer.toString(p.getDuracion()), elemPelicula, documento);
				creaElemento("Genero", p.getGenero(), elemPelicula, documento);

				if (p.getSinopsis() != null && !p.getSinopsis().isEmpty()) {
					creaElemento("sinopsis", p.getSinopsis(), elemPelicula, documento);
				}

				int anio = (p.getFecha() != null) ? p.getFecha().getYear() : 0;
				creaElemento("Fecha", Integer.toString(anio), elemPelicula, documento);
				creaElemento("Director", p.getDirector(), elemPelicula, documento);
			}

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(documento);
			StreamResult resultado = new StreamResult(new File(rutaResources + nombreFichero));
			transformer.transform(source, resultado);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Element creaElemento(String nombreElemento, String valorElemento, Element padre, Document documento) {
		Element elemento = documento.createElement(nombreElemento);
		Text texto = documento.createTextNode(valorElemento != null ? valorElemento : "");
		padre.appendChild(elemento);
		elemento.appendChild(texto);
		return elemento;
	}
}