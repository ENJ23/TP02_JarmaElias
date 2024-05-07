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
		List<Producto> productos = new ArrayList<>();
		
		    productos.add(new Producto("001", "Producto 1", 10.5, Producto.OrigenFabricacion.ARGENTINA, Producto.Categoria.ELECTROHOGAR, true));
	        productos.add(new Producto("002", "Producto 2", 20.75, Producto.OrigenFabricacion.CHINA, Producto.Categoria.INFORMATICA, true));
	        productos.add(new Producto("003", "Producto 3", 15.0, Producto.OrigenFabricacion.BRASIL, Producto.Categoria.HERRAMIENTAS, true));
	        productos.add(new Producto("004", "Producto 4", 30.25, Producto.OrigenFabricacion.URUGUAY, Producto.Categoria.TELEFONIA, false));
	        productos.add(new Producto("005", "Producto 5", 12.99, Producto.OrigenFabricacion.ARGENTINA, Producto.Categoria.ELECTROHOGAR, true));
	        productos.add(new Producto("006", "Producto 6", 18.49, Producto.OrigenFabricacion.CHINA, Producto.Categoria.INFORMATICA, true));
	        productos.add(new Producto("007", "Producto 7", 22.75, Producto.OrigenFabricacion.BRASIL, Producto.Categoria.HERRAMIENTAS, false));
	        productos.add(new Producto("008", "Producto 8", 35.0, Producto.OrigenFabricacion.URUGUAY, Producto.Categoria.TELEFONIA, true));
	        productos.add(new Producto("009", "Producto 9", 8.75, Producto.OrigenFabricacion.ARGENTINA, Producto.Categoria.ELECTROHOGAR, false));
	        productos.add(new Producto("010", "Producto 10", 19.99, Producto.OrigenFabricacion.CHINA, Producto.Categoria.INFORMATICA, true));
	        productos.add(new Producto("011", "Producto 11", 16.5, Producto.OrigenFabricacion.BRASIL, Producto.Categoria.HERRAMIENTAS, true));
	        productos.add(new Producto("012", "Producto 12", 27.25, Producto.OrigenFabricacion.URUGUAY, Producto.Categoria.TELEFONIA, true));
	        productos.add(new Producto("013", "Producto 13", 9.99, Producto.OrigenFabricacion.ARGENTINA, Producto.Categoria.ELECTROHOGAR, true));
	        productos.add(new Producto("014", "Producto 14", 21.75, Producto.OrigenFabricacion.CHINA, Producto.Categoria.INFORMATICA, false));
	        productos.add(new Producto("015", "Producto 15", 14.0, Producto.OrigenFabricacion.BRASIL, Producto.Categoria.HERRAMIENTAS, true));

	        for (Producto producto : productos) {
	            System.out.println(producto.toString());
	        }
		
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
	                        p.setPrecioUnitario(p.getPrecioUnitario() * 1.20);
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
	                    productos.sort(Comparator.comparing(Producto::getPrecioUnitario).reversed());
	                    productos.forEach(System.out::println);
	                    break;
	                case 6:
	                    // Utilizar Function y map() para mostrar nombres en mayúsculas
	                    Function<Producto, Producto> nombreMayusculas = p -> {
	                        p.setDescripcion(p.getDescripcion().toUpperCase());
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
	    scanner.close();
	}
	

}
