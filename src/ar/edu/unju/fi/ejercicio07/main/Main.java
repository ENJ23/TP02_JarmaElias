package ar.edu.unju.fi.ejercicio07.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import ar.edu.unju.fi.ejercicio07.model.Producto;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner (System.in);
		
		 boolean continuar = true;
	        while (continuar) {
	            System.out.println("Menú de opciones:");
	            System.out.println("1 - Mostrar productos disponibles");
	            System.out.println("2 - Mostrar productos faltantes");
	            System.out.println("3 - Incrementar precios en un 20%");
	            System.out.println("4 - Mostrar productos de la categoría Electrohogar disponibles");
	            System.out.println("5 - Ordenar productos por precio descendente");
	            System.out.println("6 - Mostrar nombres en mayúsculas");

	            // Leer la opción del usuario
	            int opcionElegida = scanner.nextInt();

	            switch (opcionElegida) {
	                case 1:
	                    // Utilizar Consumer para mostrar productos disponibles
	                    Consumer<Producto> consumer = p -> {
	                        if (p.isDisponible()) {
	                            System.out.println(p);
	                        }
	                    };
	                    productos.forEach(consumer);
	                    break;
	                case 2:
	                    // Utilizar Predicate y filter() para mostrar productos faltantes
	                    Predicate<Producto> faltantePredicate = p -> !p.isDisponible();
	                    List<Producto> productosFaltantes = productos.stream().filter(faltantePredicate).collect(Collectors.toList());
	                    productosFaltantes.forEach(System.out::println);
	                    break;
	                case 3:
	                    // Utilizar Function, map() para incrementar precios en un 20%
	                    Function<Producto, Producto> incrementarPrecio = p -> {
	                        p.setPrecio(p.getPrecio() * 1.20);
	                        return p;
	                    };
	                    List<Producto> productosIncrementados = productos.stream().map(incrementarPrecio).collect(Collectors.toList());
	                    productosIncrementados.forEach(System.out::println);
	                    break;
	                case 4:
	                    // Utilizar Predicate y filter() para mostrar productos de la categoría Electrohogar disponibles
	                    Predicate<Producto> electrohogarPredicate = p -> p.getCategoria().equals("Electrohogar") && p.isDisponible();
	                    List<Producto> productosElectrohogar = productos.stream().filter(electrohogarPredicate).collect(Collectors.toList());
	                    productosElectrohogar.forEach(System.out::println);
	                    break;
	                case 5:
	                    // Ordenar productos por precio de forma descendente
	                    productos.sort(Comparator.comparing(Producto::getPrecio).reversed());
	                    productos.forEach(System.out::println);
	                    break;
	                case 6:
	                    // Utilizar Function y map() para mostrar nombres en mayúsculas
	                    Function<Producto, Producto> nombreMayusculas = p -> {
	                        p.setNombre(p.getNombre().toUpperCase());
	                        return p;
	                    };
	                    List<Producto> productosMayusculas = productos.stream().map(nombreMayusculas).collect(Collectors.toList());
	                    productosMayusculas.forEach(System.out::println);
	                    break;
	                default:
	                    continuar = false;
	                    break;
	            }
	        }
	    
	}

}
