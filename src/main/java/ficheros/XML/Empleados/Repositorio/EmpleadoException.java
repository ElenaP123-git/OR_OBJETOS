package ficheros.XML.Empleados.Repositorio;


public class EmpleadoException extends Exception {

	//throw new Exception("...")
	public EmpleadoException(String mensaje) {
		super(mensaje);
	}
	
	//throw new Exception("...", e)
	public EmpleadoException(String mensaje, Throwable causa) {
		super(mensaje, causa);
	}
}
