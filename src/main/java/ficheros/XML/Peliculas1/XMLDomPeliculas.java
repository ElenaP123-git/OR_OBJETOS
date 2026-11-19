package ficheros.XML.Peliculas1;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLDomPeliculas {
	
	//ATRIBUTOS
    private final String rutaResources;

    //CONSTRUCTOR
    public XMLDomPeliculas() {
        this.rutaResources = "src/main/resources/";
    }

    public XMLDomPeliculas(String rutaResources) {
        this.rutaResources = rutaResources;
    }

    //MÉTODOS
    
    //COGER DOCUMENTO XML 
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

    //LECTURA
    public List<Pelicula> cargarPeliculas(String nombreFichero) {
        List<Pelicula> peliculas = new ArrayList<>();
        Document doc = getDocumentFromXML(nombreFichero);

        if (doc != null) {
            NodeList nodos = doc.getElementsByTagName("Pelicula");
            for (int i = 0; i < nodos.getLength(); i++) {
                Node nodo = nodos.item(i);
                if (nodo.getNodeType() == Node.ELEMENT_NODE) { 
                    Element elem = (Element) nodo;
                    String titulo = obtenerDatos(elem, "Titulo");
                    String fecha = obtenerDatos(elem, "Fecha");
                    String director = obtenerDatos(elem, "Director");
                    
                    peliculas.add(new Pelicula(titulo, fecha, director));
                }
            }
        }

        return peliculas;
    }

    private String obtenerDatos(Element padre, String etiqueta) {
        String texto = "";
        NodeList lista = padre.getElementsByTagName(etiqueta);
        if (lista != null && lista.getLength() > 0 && lista.item(0) != null) {
            texto = lista.item(0).getTextContent().trim();
        }
        return texto;
    }
}
