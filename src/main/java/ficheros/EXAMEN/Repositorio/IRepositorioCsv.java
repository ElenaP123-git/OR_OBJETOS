package ficheros.EXAMEN.Repositorio;

import java.util.List;

import ficheros.EXAMEN.Modelo.Criatura;

public interface IRepositorioCsv {
	public List<Criatura> findAll() throws CriaturaFantasticasException;
	public void save(Criatura criatura) throws CriaturaFantasticasException;
	public boolean findById(String nombre) throws CriaturaFantasticasException;
}
