package org.supermercado;

public class Cajeras extends Thread{
    private String nombre;
    private Supermercado supermercado;

    public Cajeras(String nombre, Supermercado supermercado) {
        super(nombre);
        this.nombre = nombre;
        this.supermercado = supermercado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        try {
            long startTime = System.currentTimeMillis(); // Registra el tiempo de inicio
            while (true) {
                supermercado.atenderCliente();
                if (supermercado.colaVacia()) {
                    break;
                }
                long endTime = System.currentTimeMillis();
                long duration = endTime - startTime; // Calcula la duración
                System.out.println("La cajera " + Thread.currentThread().getName() + " ha terminado de atender en " + duration + " milisegundos.");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
