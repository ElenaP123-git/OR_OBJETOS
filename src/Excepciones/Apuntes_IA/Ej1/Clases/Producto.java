package Excepciones.Apuntes_IA.Ej1.Clases;

import Excepciones.Apuntes_IA.Ej1.Exceptions.PrecioInvalidoException;
import Excepciones.Apuntes_IA.Ej1.Exceptions.StockInvalidoException;

import java.util.Objects;

public class Producto {

    //atributos
    private String nombre;
    private double precio;
    private int stock;

    //contructor

    public Producto(String nombre, double precio, int stock) throws Exception {
        setNombre(nombre);
        setPrecio(precio);
        setStock(stock);
    }

    //getters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws Exception{
        if(nombre == null || nombre.isBlank()){ // o nombre.trim().isEmpty())
            throw new Exception("No se ha añadido ningún nombre");
        }
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) throws PrecioInvalidoException {
        if(precio <= 0){
            throw new PrecioInvalidoException("Precio inválido");
        }
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) throws StockInvalidoException {
        if(stock < 0){
            throw new StockInvalidoException("Stock inválido");
        }
        this.stock = stock;
    }

    //equals y hashcode

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Producto producto)) return false;
        return Objects.equals(nombre, producto.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nombre);
    }

    //toString

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                '}';
    }
}
