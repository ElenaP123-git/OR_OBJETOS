package ej3.Model;

import java.util.Objects;

public class Pedido {
	
	//ATRIBUTOS
	private static int contadorId = 1;
    private int id;
    private Cliente cliente;
    private double importe;
    private EstadoPedido estado;

    //CONSTRUCTOR
    public Pedido(Cliente cliente, double importe) {
        this.id = contadorId++;
        this.cliente = cliente;
        this.importe = importe;
        this.estado = EstadoPedido.PENDIENTE; 
    }

    //GETTERS Y SETTERS
    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    //EQUALS Y HASHCODE
    @Override
	public int hashCode() {
		return Objects.hash(Integer.valueOf(id));
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return id == other.id;
	}

	//TOSTRING
	@Override
    public String toString() {
        return "Pedido #" + id + " [" + cliente.getNombre() + ", Importe=" + importe + "€, Estado=" + estado + "]";
    }
}

