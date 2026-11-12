package ficheros.XML.Dom2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class RepositorioLibroXML {
	private static final String RUTA_RESOURCES = "src/test/resources/";
	private File ficheroXml;

	public RepositorioLibroXML(String nombreFichero) {
		this.ficheroXml = new File(RUTA_RESOURCES + nombreFichero);
	}

	
	private Document cargarDocumento() throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		return builder.parse(ficheroXml);
	}

	 // Convierte UN SOLO Element <libro> en un objeto Libro
	 
	private Libro fromElement2Libro(Element elemento) {
		int id = 0;
		String idStr = elemento.getAttribute("id");
		if (idStr != null && !idStr.isEmpty()) {
			id = Integer.parseInt(idStr);
		}
		String categoria = elemento.getAttribute("categoria");
		
		String titulo = elemento.getElementsByTagName("titulo").item(0).getTextContent();
		String autor = elemento.getElementsByTagName("autor").item(0).getTextContent();
		
		// Comprobar si el libro tiene la etiqueta <editorial>
		Editorial editorial = null;
		
		//lista de todas las editoriales
		NodeList nodosEditorial = elemento.getElementsByTagName("editorial");
		if (nodosEditorial.getLength() > 0) { //existe al menos 1?
			
			Element elementoEditorial = (Element) nodosEditorial.item(0);
			String nombreEd = elementoEditorial.getElementsByTagName("nombre").item(0).getTextContent().trim();
			String cifEd = elementoEditorial.getElementsByTagName("cif").item(0).getTextContent().trim();
			editorial = new Editorial(nombreEd, cifEd);
		}
		
		return new Libro(id, categoria, titulo, autor, editorial);
	}

	
	 // Método principal: Devuelve la lista completa con todos los libros del XML
	 
	public List<Libro> obtenerTodosLosLibros() {
		List<Libro> listaLibros = new ArrayList<>();
		
		try {
			Document doc = cargarDocumento();
			
			// Obtenemos todos los elementos con la etiqueta <libro>
			NodeList nodosLibros = doc.getElementsByTagName("libro");
			
			int i = 0;
			while (i < nodosLibros.getLength()) {
				Element elementoLibro = (Element) nodosLibros.item(i);
				Libro libro = fromElement2Libro(elementoLibro);
				listaLibros.add(libro);
				
				i++;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listaLibros;
	}
}