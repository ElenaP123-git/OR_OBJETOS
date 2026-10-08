package fichero.ModelFiles.BolFile8;

import java.util.Comparator;
import java.io.File;

public class ComparadorFechaDesc implements Comparator<File>{
	@Override
	public int compare(File f1, File f2){
		return Long.compare(f2.lastModified(), f1.lastModified());
		}
}
