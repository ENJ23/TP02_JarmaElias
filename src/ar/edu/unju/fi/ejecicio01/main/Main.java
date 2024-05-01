package ar.edu.unju.fi.ejecicio01.main;
import ar.edu.unju.fi.ejecicio01.model.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
        ArrayList<Producto> productos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menú de opciones:");
            System.out.println("1 - Crear Producto");
            System.out.println("2 - Mostrar productos");
            System.out.println("3 - Modificar producto");
            System.out.println("4 - Salir");
            System.out.print("Elija una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
            case 1:
                crearProducto(productos, scanner);
                break;

            case 2:
                mostrarProductos(productos);
                break;

            case 3:
                modificarProducto(productos, scanner);
                break;
            
            case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Inténtelo de nuevo.");
            }
        } while (opcion != 4);
        scanner.close();
	}
	
	
	
	
	
	
	public static void crearProducto(ArrayList<Producto> productos, Scanner scanner) {
	    System.out.println("Crear Producto");
	    System.out.println("Ingrese el código del producto: ");
	    String codigo = scanner.next();
	    System.out.println("Ingrese la descripción del producto: ");
	    String descripcion = scanner.next();
	    System.out.println("Ingrese el precio unitario del producto: ");
	    float precioUnitario = scanner.nextFloat();

	    System.out.println("Origen de fabricación:");
	    for (Producto.OrigenFabricacion origen : Producto.OrigenFabricacion.values()) {
	        System.out.println((origen.ordinal() + 1) + " - " + origen);
	    }
	    System.out.print("Elija una opción: ");
	    int opcionOrigen = scanner.nextInt();
	    Producto.OrigenFabricacion origenFabricacion = Producto.OrigenFabricacion.values()[opcionOrigen - 1];

	    System.out.println("Categoría:");
	    for (Producto.Categoria categoria : Producto.Categoria.values()) {
	        System.out.println((categoria.ordinal() + 1) + " - " + categoria);
	    }
	    System.out.print("Elija una opción: ");
	    int opcionCategoria = scanner.nextInt();
	    Producto.Categoria categoria = Producto.Categoria.values()[opcionCategoria - 1];

	    Producto nuevoProducto = new Producto(codigo, descripcion, precioUnitario, origenFabricacion, categoria);
	    productos.add(nuevoProducto);
	    System.out.println("Producto creado con éxito.");
	}

	public static void mostrarProductos(ArrayList<Producto> productos) {
	    System.out.println("Mostrar productos:");
	    for (Producto producto : productos) {
	        System.out.println("Código: " + producto.getCodigo());
	        System.out.println("Descripción: " + producto.getDescripcion());
	        System.out.println("Precio Unitario: " + producto.getPrecioUnitario());
	        System.out.println("Origen Fabricación: " + producto.getOrigenFabricacion());
	        System.out.println("Categoría: " + producto.getCategoria());
	        System.out.println("----------------------");
	    }
	}

	public static void modificarProducto(ArrayList<Producto> productos, Scanner scanner) {
	    System.out.println("Modificar producto:");
	    System.out.print("Ingrese el código del producto a modificar: ");
	    String codigoModificar = scanner.next();
	    int opcionModificar = 0;
	    Producto productoModificar = null;
	    for (Producto producto : productos) {
	        if (producto.getCodigo().equals(codigoModificar)) {
	            productoModificar = producto;
	            break;
	        }
	    }

	    do {
	    	 if(productoModificar != null) {
	        System.out.println("Qué desea modificar?");
	        System.out.println("1 - Descripción");
	        System.out.println("2 - Precio Unitario");
	        System.out.println("3 - Origen Fabricación");
	        System.out.println("4 - Categoría");
	        System.out.println("5 - Salir");
	        System.out.print("Elija una opción: ");
	        opcionModificar = scanner.nextInt();
	        
	        switch (opcionModificar) {
	            case 1:
	                modificarDescripcion(productoModificar, scanner);
	                break;
	            case 2:
	                modificarPrecio(productoModificar, scanner);
	                break;
	            case 3:
	                modificarOrigen(productoModificar, scanner);
	                break;
	            case 4:
	                modificarCategoria(productoModificar, scanner);
	                break;
	            case 5: 
	            	 System.out.println("Modificacion finalizada...");
	            	break;
	            default:
	                System.out.println("Opción inválida.");
	        }
	    } else {
	        System.out.println("Producto no encontrado.");
	    } 
	} while (opcionModificar != 5);
	
	}
	
	public static void modificarDescripcion(Producto producto, Scanner scanner) {
	    System.out.print("Ingrese la nueva descripción: ");
	    String nuevaDescripcion = scanner.next();
	    producto.setDescripcion(nuevaDescripcion);
	    System.out.println("Descripción modificada con éxito.");
	}

	public static void modificarPrecio(Producto producto, Scanner scanner) {
	    System.out.print("Ingrese el nuevo precio unitario: ");
	    double nuevoPrecio = scanner.nextDouble();
	    producto.setPrecioUnitario(nuevoPrecio);
	    System.out.println("Precio unitario modificado con éxito.");
	}

	public static void modificarOrigen(Producto producto, Scanner scanner) {
	    System.out.println("Origen de fabricación:");
	    for (Producto.OrigenFabricacion origen : Producto.OrigenFabricacion.values()) {
	        System.out.println((origen.ordinal() + 1) + " - " + origen);
	    }
	    System.out.print("Elija una opción: ");
	    int opcionOrigenModificar = scanner.nextInt();
	    Producto.OrigenFabricacion nuevoOrigen = Producto.OrigenFabricacion.values()[opcionOrigenModificar - 1];
	    producto.setOrigenFabricacion(nuevoOrigen);
	    System.out.println("Origen de fabricación modificado con éxito.");
	}

	public static void modificarCategoria(Producto producto, Scanner scanner) {
	    System.out.println("Categoría:");
	    for (Producto.Categoria categoria : Producto.Categoria.values()) {
	        System.out.println((categoria.ordinal() + 1) + " - " + categoria);
	    }
	    System.out.print("Elija una opción: ");
	    int opcionCategoriaModificar = scanner.nextInt();
	    Producto.Categoria nuevaCategoria = Producto.Categoria.values()[opcionCategoriaModificar - 1];
	    producto.setCategoria(nuevaCategoria);
	    System.out.println("Categoría modificada con éxito.");
	}
}



