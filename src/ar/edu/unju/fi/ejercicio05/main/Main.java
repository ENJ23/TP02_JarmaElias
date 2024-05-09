package ar.edu.unju.fi.ejercicio05.main;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import ar.edu.unju.fi.ejercicio05.model.*;
import ar.edu.unju.fi.ejercicio05.model.Producto;
import ar.edu.unju.fi.ejercicio05.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio05.model.Producto.OrigenFabricacion;


public class Main {

    public static void main(String[] args) {
        ArrayList<Producto> productos = new ArrayList<>();
        // Precarga de productos en el ArrayList "productos"

        precargarProductos(productos);
        
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
        
        System.out.println("Seleccione los productos a comprar:");
        mostrarProductos(productos);

        System.out.print("Ingrese el código del producto a comprar (0 para finalizar): ");
        String codigo = scanner.next();

        while (!codigo.equals("0")) {
            boolean encontrado = false;
            for (Producto producto : productos) {
                if (producto.getCodigo().equals(codigo)) {
                    productosComprados.add(producto);
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                System.out.println("Producto no encontrado. Por favor, ingrese un código válido.");
            }

            System.out.print("Ingrese el código del producto a comprar (0 para finalizar): ");
            codigo = scanner.next();
        }

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
        for (Producto producto : productosComprados) {
            total += producto.getPrecioUnitario();
        }
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
    
    private static void precargarProductos(ArrayList<Producto> productos) {
    	productos.add(new Producto("001", "Producto A", 100.50, OrigenFabricacion.ARGENTINA, Categoria.ELECTROHOGAR, true));
        productos.add(new Producto("002", "Producto B", 75.25, OrigenFabricacion.ARGENTINA, Categoria.ELECTROHOGAR, true));
        productos.add(new Producto("003", "Producto C", 150.80, OrigenFabricacion.ARGENTINA, Categoria.ELECTROHOGAR, true));
        productos.add(new Producto("004", "Producto D", 200.00, OrigenFabricacion.ARGENTINA, Categoria.INFORMATICA, true));
        productos.add(new Producto("005", "Producto E", 120.30, OrigenFabricacion.BRASIL, Categoria.INFORMATICA, true));
        productos.add(new Producto("006", "Producto F", 90.75, OrigenFabricacion.ARGENTINA, Categoria.INFORMATICA, true));
        productos.add(new Producto("007", "Producto G", 180.60, OrigenFabricacion.BRASIL, Categoria.TELEFONIA, true));
        productos.add(new Producto("008", "Producto H", 95.20, OrigenFabricacion.BRASIL, Categoria.TELEFONIA, true));
        productos.add(new Producto("009", "Producto I", 210.40, OrigenFabricacion.BRASIL, Categoria.TELEFONIA, true));
        productos.add(new Producto("010", "Producto J", 110.90, OrigenFabricacion.CHINA, Categoria.TELEFONIA, true));
    }
    
}