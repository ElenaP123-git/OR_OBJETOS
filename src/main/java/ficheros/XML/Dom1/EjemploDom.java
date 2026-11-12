package ficheros.XML.Dom1;

import java.util.logging.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class EjemploDom {
    private static final Logger logger = Logger.getLogger(EjemploDom.class.getName());
    
    public static void main(String[] args) {
        try {
            Document doc = UtilesDomXML.getDocumentFromXML("dom1.xml");
            
            // Obtenemos el elemento raíz del documento XML
            Element raiz = doc.getDocumentElement();
  
            // Usamos el método UtilesDomXML.fromElement2Libro(raiz) para pasarlo a un objeto Libro
            Libro libro = UtilesDomXML.fromElement2Libro(raiz);
           
            logger.info("Libro cargado con éxito desde el XML: " + libro.toString());

        } catch (Exception e) {
            logger.severe("Error en main: " + e.getMessage());
        }
    }

    
    	/*try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File(RUTA_RESOURCES + "dom1.xml"));
            Element titulo = (Element) doc.getElementsByTagName("titulo").item(0);
            logger.info(titulo.getTextContent());
        } catch (Exception e) {
            logger.severe("Error en main: " + e.getMessage());
        }*/
}

    	/*
    	 try {
            // 1. Crear el analizador DOM
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            // 2. Leer el fichero XML
            Document doc = builder.parse(new File(RUTA_RESOURCES + "dom1.xml"));

            // 3. Obtener el elemento titulo → El Quijote
            Element titulo = (Element) doc.getElementsByTagName("titulo").item(0);
            
            // 2. Usamos logger.info(...) en lugar de Logger.debug(...)
            logger.info(titulo.getTextContent());

        } catch (Exception e) {
            // 3. Ahora este logger sí funciona porque es estático
            logger.severe("Error en main: " + e.getMessage());
        }
        */
