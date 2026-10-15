package ficheros.ModelFiles.Bol2;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

public class DiffFolder {

    private static final Logger LOGGER = Logger.getLogger(DiffFolder.class.getName());

    // ATRIBUTOS
    private File folder1;
    private File folder2;

    // CONSTRUCTORES
    public DiffFolder() {
        super();
    }

    public DiffFolder(String ruta1, String ruta2) throws GestionFicherosException {
        super();
        File f1 = new File(ruta1);
        File f2 = new File(ruta2);
        
        setFolders(f1, f2);
    }

    // MÉTODOS
    public void setFolders(File fold1, File fold2) throws GestionFicherosException {
        if (fold1 == null || fold2 == null) {
            throw new GestionFicherosException("Los objetos File no pueden ser nulos.");
        }

        if (!fold1.exists() || !fold1.isDirectory()) {
            throw new GestionFicherosException("La ruta 1 no existe o no es una carpeta: " + fold1.getPath());
        }

        if (!fold2.exists() || !fold2.isDirectory()) {
            throw new GestionFicherosException("La ruta 2 no existe o no es una carpeta: " + fold2.getPath());
        }

        this.folder1 = fold1;
        this.folder2 = fold2;
    }
	
    Collection <ResultadoComparacion> comparame(){
    	
    }
	
	//GETTERS Y SETTERS
    
    public File getFolder1() {
		return folder1;
	}

	public void setFolder1(File folder1) {
		this.folder1 = folder1;
	}

	public File getFolder2() {
		return folder2;
	}

	public void setFolder2(File folder2) {
		this.folder2 = folder2;
	}
	

	//TOSTRING
	@Override
	public String toString() {
		return "DiffFolder [folder1=" + folder1 + ", folder2=" + folder2 + "]";
	}

	
}
