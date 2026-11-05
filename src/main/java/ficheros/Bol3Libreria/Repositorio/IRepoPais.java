package ficheros.Bol3Libreria.Repositorio;
import java.util.List;
import ficheros.Bol3Libreria.Modelo.Pais;

public interface IRepoPais {
	
	//MÉTODOS
	List<Pais> findAll() throws Exception;
	void save(Pais pais) throws Exception;
	boolean deleteById(String nombre) throws Exception;
	
	
}
