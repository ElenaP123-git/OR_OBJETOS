package fichero.ModelFiles.BolFile8;

import java.util.Comparator;
import java.io.File;

public class ComparadorTamanoDesc implements Comparator<File>{
	@Override
    public int compare(File f1, File f2) {
        return Long.compare(f2.length(), f1.length());
    }
}
