package org.supermercado;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Supermercado de Medellin");

        System.out.println(" '👧' ¿Asi que eres el nuevo supervisor?!");
        System.out.println(" '👧' Perfecto!, haremos un simulacro para preparte en el sistema, ¿Okey?");

        Scanner scanner = new Scanner(System.in);
        Supermercado supermercado = new Supermercado();

        System.out.println(" '👧' Escoge cuantos clientes ingresan: ");
        int nc = scanner.nextInt();
        scanner.nextLine();

        System.out.println(" '👧' Asi que " + nc + " clientes!, Excelente continuemos!!");

        for (int i = 0; i < nc; i++) {
            System.out.println(" '👧' Ahora, escoge el nombre del cliente: ");
            String nombre = scanner.nextLine();

            System.out.println(" '👧' Escoge cuantos productos comprara el cliente: " + nombre);
            int np = scanner.nextInt();
            scanner.nextLine();

            List<Productos> productos = new ArrayList<>();
            for (int j = 0; j < np; j++) {
                System.out.println(" '👧' Escoge el nombre del producto: ");
                String nombreProducto = scanner.nextLine();

                System.out.println(" '👧' Escoge el precio del producto: ");
                int precio = scanner.nextInt();
                scanner.nextLine();

                Productos producto = new Productos(nombreProducto, precio);
                productos.add(producto);
            }
            Clientes cliente = new Clientes(nombre, productos.get(0), supermercado);
            cliente.start();
            supermercado.agregarCliente(cliente);
            for (int j = 0; j < np; j++) {
                if (j < productos.size()) {

                    System.out.println("El cliente " + nombre + " compró " + productos.get(j).getNombre() + " por " + productos.get(j).getPrecio() + " pesos");
                } else {
                    System.out.println("El cliente " + nombre + " intentó comprar más productos de los disponibles.");
                }
            }
        }
        System.out.println(" '👧' ¡Bien!, escoge de 2 a 4 cajeras");
        int c = scanner.nextInt();

        while (c < 2 || c > 4 ) {
            System.out.println(" '😡' Tenemos solo 4 cajeras y no podemos usar menos de 2");
            System.out.println(" '😊' Intenta de nuevo...");

            int x = scanner.nextInt();
            c = x;
        }
        System.out.println(" '👧' ¡Perfecto!, tenemos " + c + " cajeras");
        System.out.println(supermercado);

        List<Cajeras> cajeras = new ArrayList<>();

        for (int i = 0; i < c; i++) {
            String nombreCajera = "Cajera " + (i + 1);
            Cajeras cajera = new Cajeras(nombreCajera, supermercado);
            cajera.start();
            cajeras.add(cajera);
        }

        for (Cajeras cajera : cajeras) {
            cajera.join();
        }
    }
}