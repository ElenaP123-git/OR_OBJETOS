package ficheros.ModelFiles.Bol2;

public class ResultadoComparacion {
	
	//ATRIBUTOS
	String fileName;
	ValorComparacion valor;
	
	//CONSTRUCTOR
	public ResultadoComparacion(String fileName, ValorComparacion valor) {
		super();
		this.fileName = fileName;
		this.valor = valor;
	}

	//GETTERS Y SETTERS
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public ValorComparacion getValor() {
		return valor;
	}

	public void setValor(ValorComparacion valor) {
		this.valor = valor;
	}

	//TOSTRING
	@Override
	public String toString() {
		return "ResultadoComparacion [fileName=" + fileName + ", valor=" + valor + "]";
	}
	
	
	
}
