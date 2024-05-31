package org.supermercado;

import java.util.List;

public class Clientes extends Thread{
    private String nombre;
    private Productos productos;
    private Supermercado supermercado;


    public Clientes(String nombre, Productos productos, Supermercado supermercado) {
        this.nombre = nombre;
        this.productos = productos;
        this.supermercado = supermercado;
    }

    @Override
    public void run() {
        supermercado.agregarCliente(this);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "Clientes{" +
                "nombre='" + nombre + '\'' +
                ", producto=" + productos.getNombre() + " precio: " + productos.getPrecio() + "}";
    }
}
