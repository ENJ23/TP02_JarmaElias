package ar.edu.unju.fi.ejecicio01.model;

import java.util.ArrayList;
import java.util.Scanner;

public class Producto {
    private String codigo;
    private String descripcion;
    private double precioUnitario;
    private OrigenFabricacion origenFabricacion;
    private Categoria categoria;

    public enum OrigenFabricacion {
        ARGENTINA, CHINA, BRASIL, URUGUAY
    }

    public enum Categoria {
        TELEFONIA, INFORMATICA, ELECTROHOGAR, HERRAMIENTAS
    }

    // Constructor, getters y setters

    public Producto(String codigo, String descripcion, double precioUnitario, OrigenFabricacion origenFabricacion, Categoria categoria) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.origenFabricacion = origenFabricacion;
        this.categoria = categoria;
    }

    // Getters y setters

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public OrigenFabricacion getOrigenFabricacion() {
        return origenFabricacion;
    }

    public void setOrigenFabricacion(OrigenFabricacion origenFabricacion) {
        this.origenFabricacion = origenFabricacion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }


		
		
		public static void crearProducto(ArrayList<Producto> productos, Scanner scanner) {
		    System.out.println("Crear Producto");
		    System.out.print("Ingrese el código del producto: ");
		    String codigo = scanner.next();
		    System.out.print("Ingrese la descripción del producto: ");
		    String descripcion = scanner.next();
		    System.out.print("Ingrese el precio unitario del producto: ");
		    double precioUnitario = scanner.nextDouble();

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

		    Producto productoModificar = null;
		    for (Producto producto : productos) {
		        if (producto.getCodigo().equals(codigoModificar)) {
		            productoModificar = producto;
		            break;
		        }
		    }

		    if (productoModificar != null) {
		        System.out.println("Qué desea modificar?");
		        System.out.println("1 - Descripción");
		        System.out.println("2 - Precio Unitario");
		        System.out.println("3 - Origen Fabricación");
		        System.out.println("4 - Categoría");
		        System.out.print("Elija una opción: ");
		        int opcionModificar = scanner.nextInt();

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
		            default:
		                System.out.println("Opción inválida.");
		        }
		    } else {
		        System.out.println("Producto no encontrado.");
		    }
		

		    if (productoModificar != null) {
		        System.out.println("Qué desea modificar?");
		        System.out.println("1 - Descripción");
		        System.out.println("2 - Precio Unitario");
		        System.out.println("3 - Origen Fabricación");
		        System.out.println("4 - Categoría");
		        System.out.print("Elija una opción: ");
		        int opcionModificar = scanner.nextInt();
		    	}
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

	