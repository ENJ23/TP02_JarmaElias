package ar.edu.unju.fi.ejercicio05.main;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import ar.edu.unju.fi.ejecicio01.model.Producto;
import ar.edu.unju.fi.ejercicio05.model.*;


public class Main {
    public static void main(String[] args) {
        ArrayList<Producto> productos = new ArrayList<>();
        // Precarga de productos en el ArrayList "productos"

        Scanner scanner = new Scanner(System.in);

        int opcion = 0;
        do {
            System.out.println("Menú de opciones:");
            System.out.println("1 - Mostrar productos");
            System.out.println("2 - Realizar compra");
            System.out.println("3 - Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    mostrarProductos(productos);
                    break;
                case 2:
                    ArrayList<Producto> productosComprados = seleccionarProductos(scanner, productos);
                    int opcionPago = seleccionarMetodoPago(scanner);
                    double total = calcularTotal(productosComprados);
                    procesarPago(opcionPago, total);
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 3);
    }

    private static void mostrarProductos(ArrayList<Producto> productos) {
        System.out.println("Listado de productos:");
        for (Producto producto : productos) {
            System.out.println(producto.toString());
        }
    }

    private static ArrayList<Producto> seleccionarProductos(Scanner scanner, ArrayList<Producto> productos) {
        ArrayList<Producto> productosComprados = new ArrayList<>();
        // Lógica para que el usuario seleccione los productos a comprar
        return productosComprados;
    }

    private static int seleccionarMetodoPago(Scanner scanner) {
        System.out.println("Seleccione método de pago:");
        System.out.println("1 - Pago en efectivo");
        System.out.println("2 - Pago con tarjeta");
        System.out.print("Ingrese su elección: ");
        return scanner.nextInt();
    }

    private static double calcularTotal(ArrayList<Producto> productosComprados) {
        double total = 0;
        // Calcular el total de los productos seleccionados
        return total;
    }

    private static void procesarPago(int opcionPago, double total) {
        if (opcionPago == 1) {
            PagoEfectivo pagoEfectivo = new PagoEfectivo(LocalDate.now());
            pagoEfectivo.realizarPago(total);
            pagoEfectivo.imprimirRecibo();
        } else if (opcionPago == 2) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese el número de tarjeta: ");
            String numeroTarjeta = scanner.next();
            PagoTarjeta pagoTarjeta = new PagoTarjeta(numeroTarjeta, LocalDate.now());
            pagoTarjeta.realizarPago(total);
            pagoTarjeta.imprimirRecibo();
        } else {
            System.out.println("Opción de pago inválida.");
        }
    }
}