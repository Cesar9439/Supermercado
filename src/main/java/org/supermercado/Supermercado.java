package org.supermercado;

import java.util.LinkedList;
import java.util.Queue;

public class Supermercado{
    private final Queue<Clientes> cola = new LinkedList<>();

    public Supermercado() {

    }

    public synchronized void agregarCliente(Clientes cliente) {
        if (!cola.contains(cliente)) {
            try {
                cola.add(cliente);
                notify();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public synchronized void atenderCliente() {
        while (cola.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Clientes cliente = cola.poll();
        if (cliente != null) {
            System.out.println("La cajera " + Thread.currentThread().getName() + " atiende al cliente " + cliente.getNombre());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public String toString() {
        return "Supermercado with " + cola.toString() + " customers in queue";
    }

    public boolean colaVacia() {
         return false;
    }
}
