package ficheros.EXAMEN.Servicio;

import java.io.File;
import java.util.Collection;
import java.util.List;

import ficheros.EXAMEN.Modelo.Criatura;
import ficheros.EXAMEN.Modelo.Habitat;
import ficheros.EXAMEN.Modelo.TipoCriatura;
import ficheros.EXAMEN.Repositorio.CriaturaFantasticasException;

public interface IServicio {
	public List<Criatura> listar() throws CriaturaFantasticasException;
	public boolean alta(String nombre, TipoCriatura tipo, boolean inmortal, int peligrosidad, int magia, Habitat habitat) throws CriaturaFantasticasException;
	public boolean baja(String nombre) throws CriaturaFantasticasException;
	public List<Criatura> filtrarPorTipoCriatura(TipoCriatura tipo) throws CriaturaFantasticasException;
	void convertirCsvJson(Collection<Criatura> criaturas, File ficheroJson) throws CriaturaFantasticasException;
}