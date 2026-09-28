package ej3.Repository;

import java.util.HashSet;
import java.util.Set;

import ej3.Model.*;

public class PedidoRepo {

	//ATRIBUTOS
	private Set<Pedido> pedidos;

	//CONSTRUCTOR
	public PedidoRepo() {
		this.pedidos = new HashSet<>();
	}
	
	//MÉTODOS
	
	public boolean agregarPedido(Pedido pedido) {
        boolean insertado = false;
        if (pedido != null) {
            insertado = pedidos.add(pedido);
        }
        return insertado;
    }
	
	public Set<Pedido> getPedidos() {
	    Set<Pedido> copia = new HashSet<>(pedidos);
	    return copia;
	}
	
	public Pedido buscarPorId(int id) {
        Pedido resultado = null;
        for (Pedido p : pedidos) {
            if (resultado == null && p.getId() == id) {
                resultado = p;
            }
        }
        return resultado;
    }
	
	public boolean actualizarEstado(int id, EstadoPedido nuevoEstado) {
        boolean actualizado = false;
        Pedido p = buscarPorId(id);
        if (p != null) {
            p.setEstado(nuevoEstado);
            actualizado = true;
        }
        return actualizado;
    }
	
	public boolean eliminarPedido(int id) {
        boolean eliminado = false;
        Pedido p = buscarPorId(id);
        if (p != null) {
            eliminado = pedidos.remove(p);
        }
        return eliminado;
    }
}
