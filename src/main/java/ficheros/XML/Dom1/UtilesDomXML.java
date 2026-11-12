package ficheros.XML.Dom1;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class UtilesDomXML {
	private static final String RUTA_RESOURCES = "src/test/resources/";
	
	// Método para obtener el Documento XML
	public static Document getDocumentFromXML(String nombreFichero) {
		Document doc = null;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		
		try {
			builder = factory.newDocumentBuilder();	
			doc = builder.parse(new File(RUTA_RESOURCES + nombreFichero));
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return doc;
	}
	
	/* 
	 * NUEVO: Método para mapear un Element de XML a un objeto Libro.
	 * Extrae atributos (como id o categoría) y etiquetas hijas (como título o autor).
	 */
	public static Libro fromElement2Libro(Element elemento) {
		
		int id = 0;
		String idStr = elemento.getAttribute("id");
		if (idStr != null && !idStr.isEmpty()) {
			id = Integer.parseInt(idStr);
		}
		String categoria = elemento.getAttribute("categoria");
		
		// Extraer el texto de las etiquetas hijas (<titulo> y <autor>)
		String titulo = elemento.getElementsByTagName("titulo").item(0).getTextContent();
		String autor = elemento.getElementsByTagName("autor").item(0).getTextContent();
		
		// Crear y devolver el objeto Libro con los datos extraídos
		return new Libro(id, categoria, titulo, autor);
	}
}